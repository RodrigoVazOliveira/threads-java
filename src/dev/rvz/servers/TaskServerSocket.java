package dev.rvz.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

final class TaskServerSocket {
	private final ServerSocket serverSocket;
	private final Integer PORT = 12345;
	private final ExecutorService executorService;
	private AtomicBoolean isRunning;
	private final BlockingQueue<String> queueCommand;

	public TaskServerSocket() throws IOException {
		System.out.println("--------- Iniciando servidor --------");
		this.serverSocket = new ServerSocket(PORT);
		final ThreadFactoryCustom threadFactoryCustom = new ThreadFactoryCustom();
		this.executorService = Executors.newCachedThreadPool(threadFactoryCustom);
		this.isRunning = new AtomicBoolean(true);
		this.queueCommand = new ArrayBlockingQueue<>(2);
		startConsummers();
	}

	private void startConsummers() {
		final Integer totalConsummers = 2;
		for (int i = 0; i < totalConsummers; i++) {
			final TaskConsummer taskConsummer = new TaskConsummer(queueCommand);
			this.executorService.execute(taskConsummer);
		}
	}

	public void run() throws IOException {
		while (this.isRunning.get()) {
			final Socket socket = this.serverSocket.accept();
			System.out.println("Aceitando nova conexão - porta: " + socket.getPort());
			final DistributeConnection distributeConnection = new DistributeConnection(executorService, socket, this,
					this.queueCommand);
			executorService.execute(distributeConnection);
		}
	}

	public void down() throws IOException {
		this.isRunning.set(false);
		this.serverSocket.close();
		this.executorService.shutdown();
		System.exit(0);
	}
}
