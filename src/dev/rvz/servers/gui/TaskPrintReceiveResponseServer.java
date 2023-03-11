package dev.rvz.servers.gui;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public final class TaskPrintReceiveResponseServer implements Runnable {
    private final Socket socket;
    private final UpdateTextArea updateTextArea;

    public TaskPrintReceiveResponseServer(Socket socket, UpdateTextArea updateTextArea) {
	this.socket = socket;
	this.updateTextArea = updateTextArea;
    }

    @Override
    public void run() {
	try {
	    updateTextArea.update("Recebendo dados do servidor");
	    final Scanner scanner = new Scanner(socket.getInputStream());
	    while (scanner.hasNextLine()) {
		final String newLine = scanner.nextLine();
		updateTextArea.update(newLine);
	    }

	    scanner.close();
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}

    }

}
