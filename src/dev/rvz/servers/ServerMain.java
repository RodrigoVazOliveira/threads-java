package dev.rvz.servers;

import java.io.IOException;

final class ServerMain {

	public static void main(String[] args) throws IOException {
		final TaskServerSocket taskServerSocket = new TaskServerSocket();
		taskServerSocket.run();
	}
}
