package dev.rvz.servers.commands;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public final class CommandC2WS implements Callable<String> {
	private PrintStream printStream;

	public CommandC2WS(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public String call() throws Exception {
		this.printStream.println("Executando comando C2");
		this.printStream.println("Processamento comando C2 WS");
		Thread.sleep(20000);
		Integer number = new Random().nextInt(100) + 1;
		this.printStream.println("Servidor finalizou o comando C2WS!");

		return number.toString();
	}

}
