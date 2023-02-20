package dev.rvz.servers;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

final class ClientServer {

	public static void main(String[] args) throws UnknownHostException, IOException {
		final Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexão estabelecida!");
		final Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		socket.close();
	}

}
