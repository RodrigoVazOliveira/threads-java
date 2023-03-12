package dev.rvz.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

final class TaskServerSocket {
	private final ServerSocket serverSocket;
	private final Integer PORT = 12345;
	private final ExecutorService executorService;
	private AtomicBoolean isRunning;

	public TaskServerSocket() throws IOException {
		System.out.println("--------- Iniciando servidor --------");
		this.serverSocket = new ServerSocket(PORT);
		final ThreadFactoryCustom threadFactoryCustom = new ThreadFactoryCustom();
		this.executorService = Executors.newCachedThreadPool(threadFactoryCustom);
		this.isRunning = new AtomicBoolean(true);
	}

	public void run() throws IOException {
		while (this.isRunning.get()) {
			final Socket socket = this.serverSocket.accept();
			System.out.println("Aceitando nova conexão - porta: " + socket.getPort());
			final DistributeConnection distributeConnection = new DistributeConnection(executorService, socket, this);
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
