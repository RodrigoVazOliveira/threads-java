package dev.rvz.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

final class ServerMain {

	public static void main(String[] args) throws IOException {
		System.out.println("--------- Iniciando servidor --------");
		ServerSocket serverSocket = new ServerSocket(12345);

		while (true) {
			final Socket socket = serverSocket.accept();
			System.out.println("Aceitando nova conexão - porta: " + socket.getPort());
			final DistributeConnection distributeConnection = new DistributeConnection(socket);
			final Thread taskNewConnection = new Thread(distributeConnection);
			taskNewConnection.start();

		}
	}

}
