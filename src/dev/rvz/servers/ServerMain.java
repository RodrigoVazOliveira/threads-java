package dev.rvz.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class ServerMain {

	public static void main(String[] args) throws IOException {
		System.out.println("--------- Iniciando servidor --------");
		try (ServerSocket serverSocket = new ServerSocket(12345)) {
			final ExecutorService executorService = Executors.newCachedThreadPool();

			while (true) {
				final Socket socket = serverSocket.accept();
				System.out.println("Aceitando nova conexão - porta: " + socket.getPort());
				final DistributeConnection distributeConnection = new DistributeConnection(socket);
				executorService.execute(distributeConnection);
			}
		}

	}
}
