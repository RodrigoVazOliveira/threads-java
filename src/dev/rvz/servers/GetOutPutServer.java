package dev.rvz.servers;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

final class GetOutPutServer implements Runnable {

	private final Socket socket;

	public GetOutPutServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Recebendo dados do servidor!");
		try {
			final Scanner scanner = new Scanner(socket.getInputStream());
			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				System.out.println(line);
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
