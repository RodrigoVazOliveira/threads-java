package dev.rvz.servers.commands;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public final class CommandC2AccessDatabase implements Callable<String> {
	private final PrintStream printStream;

	public CommandC2AccessDatabase(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public String call() throws Exception {
		this.printStream.println("Servidor recebeu comando C2 - ACESSO A BASE DE DADOS");
		this.printStream.println("Processando comando C2 - banco de dados");
		Thread.sleep(10000);
		Integer number = new Random().nextInt(100) + 1;
		this.printStream.println("Servidor finalizou o comando C2 Access Database");
		return number.toString();
	}

}
