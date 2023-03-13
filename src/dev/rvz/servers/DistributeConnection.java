package dev.rvz.servers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import dev.rvz.servers.commands.CommandC1;
import dev.rvz.servers.commands.CommandC2AccessDatabase;
import dev.rvz.servers.commands.CommandC2WS;

final class DistributeConnection implements Runnable {
	private final ExecutorService executorService;
	private final Socket socket;
	private final TaskServerSocket taskServerSocket;
	private final BlockingQueue<String> queueCommand;

	public DistributeConnection(ExecutorService executorService, Socket socket, TaskServerSocket taskServerSocket,
			BlockingQueue<String> queueCommand) {
		this.executorService = executorService;
		this.socket = socket;
		this.taskServerSocket = taskServerSocket;
		this.queueCommand = queueCommand;
	}

	@Override
	public void run() {
		System.out.println("Distribuindo as tarefas para o cliente " + socket);
		try {
			final PrintStream printStream = new PrintStream(socket.getOutputStream());
			final InputStream inputStream = socket.getInputStream();
			final Scanner scanner = new Scanner(inputStream);

			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				System.out.println("comando recebido " + line);

				if (line.equalsIgnoreCase("c1")) {
					System.out.println("Confirmação de cliente C1");
					printStream.println("Confirmação de cliente C1");
					final CommandC1 commandC1 = new CommandC1(printStream);
					this.executorService.execute(commandC1);
				} else if (line.equalsIgnoreCase("c2")) {
					System.out.println("Confirmação de cliente C2");
					printStream.println("Confirmação de cliente C2");
					final CommandC2WS commandC2WS = new CommandC2WS(printStream);
					final CommandC2AccessDatabase commandC2AccessDatabase = new CommandC2AccessDatabase(printStream);

					final Future<String> futureC2WS = this.executorService.submit(commandC2WS);
					final Future<String> futureC2Database = this.executorService.submit(commandC2AccessDatabase);

					this.executorService
							.submit(new JoinResultWSAndFutureDatabase(futureC2WS, futureC2Database, printStream));

				} else if (line.equalsIgnoreCase("C3")) {
					this.queueCommand.put(line); // bloquear
					printStream.println("Comando C3 adicionado na fila!");
				} else if (line.equals("fim")) {
					System.out.println("Desligando o servidor");
					taskServerSocket.down();
				} else {
					System.out.println("Comando não encontrado!");
					printStream.println("Comando não encontrado!");
				}

			}

			scanner.close();
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
