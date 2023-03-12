package dev.rvz.servers.commands;

import java.io.PrintStream;

public final class CommandC2 implements Runnable {
	private PrintStream printStream;

	public CommandC2(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void run() {
		this.printStream.println("Executando comando C2");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		this.printStream.println("Comando C2 executado com sucesso!");
		throw new RuntimeException("Simulando erro em uma THREAD");
	}

}
