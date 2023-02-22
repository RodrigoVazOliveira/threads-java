package dev.rvz.servers.gui;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public final class GUIApplicationMain {

	public static void main(String[] args) {
		try (final Socket socket = new Socket("localhost", 12345)) {
			final JFrame window = new JFrame();
			final JTextArea jTextArea = new JTextArea();
			final PrintStream printStream = new PrintStream(socket.getOutputStream());
			final CreateWindow createWindow = new CreateWindow(window, printStream, jTextArea);
			createWindow.execute();
			final UpdateTextArea updateTextArea = new UpdateTextArea(jTextArea);
			updateTextArea.update("Conexão estabelecida com sucesso!");
			runThreadPrintUpdateTextArea(socket, updateTextArea);
			updateTextArea.update("Servidor Fechado!");

		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private static void runThreadPrintUpdateTextArea(final Socket socket, final UpdateTextArea updateTextArea)
			throws InterruptedException {
		final TaskPrintReceiveResponseServer taskPrintReceiveResponseServer = new TaskPrintReceiveResponseServer(socket,
				updateTextArea);
		final Thread threadTaskPrint = new Thread(taskPrintReceiveResponseServer);
		threadTaskPrint.setPriority(10);
		threadTaskPrint.start();
		threadTaskPrint.join();
	}

}
