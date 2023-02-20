package dev.rvz.servers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

final class ClientServer {

	public static void main(String[] args) throws UnknownHostException, IOException {
		final Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexão estabelecida!");
		final OutputStream outputStream = socket.getOutputStream();
		final PrintStream printStream = new PrintStream(outputStream);
		printStream.println("C1");
		final Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		outputStream.close();
		scanner.close();
		socket.close();
	}

}
