package dev.rvz.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class TaskServerSocket {
	private final ServerSocket serverSocket;
	private final Integer PORT = 12345;
	private final ExecutorService executorService;
	private Boolean isRunning;

	public TaskServerSocket() throws IOException {
		System.out.println("--------- Iniciando servidor --------");
		this.serverSocket = new ServerSocket(PORT);
		this.executorService = Executors.newCachedThreadPool();
		this.isRunning = true;
	}

	public void run() throws IOException {
		while (this.isRunning) {
			final Socket socket = this.serverSocket.accept();
			System.out.println("Aceitando nova conexão - porta: " + socket.getPort());
			final DistributeConnection distributeConnection = new DistributeConnection(socket, this);
			executorService.execute(distributeConnection);
		}
	}

	public void down() throws IOException {
		this.isRunning = false;
		this.serverSocket.close();
		this.executorService.shutdownNow();
		System.exit(0);
	}
}
