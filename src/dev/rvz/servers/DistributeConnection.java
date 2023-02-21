package dev.rvz.servers;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

final class DistributeConnection implements Runnable {

	private final Socket socket;

	public DistributeConnection(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Distribuindo as tarefas para o cliente " + socket);
		try {
			final InputStream inputStream = socket.getInputStream();
			final Scanner scanner = new Scanner(inputStream);

			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				System.out.println("comando recebido " + line);

				if (line.equalsIgnoreCase("c1")) {
					System.out.println("Confirmação de cliente C1");
				} else if (line.equalsIgnoreCase("c2")) {
					System.out.println("Confirmação de cliente C2");
				} else {
					System.out.println("Comando não encontrado!");
				}

				System.out.println(line);
			}

			scanner.close();
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
