package dev.rvz.servers;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

final class PutAndOutPutInfo implements Runnable {

    private final Socket socket;

    public PutAndOutPutInfo(Socket socket) {
	this.socket = socket;
    }

    @Override
    public void run() {
	System.out.println("Conexão estabelecida!");
	try (PrintStream printStream = new PrintStream(socket.getOutputStream())) {
	    printStream.println("C1");
	    final Scanner scanner = new Scanner(System.in);
	    while (scanner.hasNextLine()) {
		final String line = scanner.nextLine();
		final String lineWithoutSpaces = line.trim();
		if (lineWithoutSpaces.equals("")) {
		    break;
		}

		printStream.println(line);
	    }

	    scanner.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
