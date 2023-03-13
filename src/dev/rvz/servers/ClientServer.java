package dev.rvz.servers;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

final class ClientServer {

	public static vo3id main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		final Socket socket = new Socket("localhost", 12345);
		final Thread taskPutAndOutPutInfo = new Thread(new PutAndOutPutInfo(socket));
		final Thread taskGetOutput = new Thread(new GetOutPutServer(socket));
		taskGetOutput.start();
		taskPutAndOutPutInfo.start();
		taskPutAndOutPutInfo.join();

		System.out.println("Fechando o socket do cliente");
		socket.close();
	}

}
