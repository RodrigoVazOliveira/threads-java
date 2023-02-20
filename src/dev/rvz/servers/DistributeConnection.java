package dev.rvz.servers;

import java.net.Socket;

final class DistributeConnection implements Runnable {

	private final Socket socket;

	public DistributeConnection(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Distribuindo as tarefas para o cliente " + socket);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
