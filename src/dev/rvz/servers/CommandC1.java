package dev.rvz.servers;

import java.io.PrintStream;

public final class CommandC1 implements Runnable {
	private PrintStream printStream;

	public CommandC1(PrintStream printStream) {
		this.printStream = printStream;
	}

	public PrintStream getPrintStream() {
		return printStream;
	}

	@Override
	public void run() {
		System.out.println("Executando commando C1");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		printStream.println("Comando C1 executado com sucesso!");
	}
}
