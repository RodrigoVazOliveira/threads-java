package dev.rvz.servers;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class JoinResultWSAndFutureDatabase implements Callable<Void> {
	private final Future<String> futureC2WS;
	private final Future<String> futureC2Database;
	private final PrintStream printStream;

	public JoinResultWSAndFutureDatabase(Future<String> futureC2WS, Future<String> futureC2Database,
			PrintStream printStream) {
		this.futureC2WS = futureC2WS;
		this.futureC2Database = futureC2Database;
		this.printStream = printStream;
	}

	@Override
	public Void call() throws Exception {
		System.out.println("Aguardando resultado dos futureWS e futureDatabase");
		try {
			final String resultWS = this.futureC2WS.get(15, TimeUnit.SECONDS);
			final String resultDatabase = this.futureC2Database.get(15, TimeUnit.SECONDS);
			this.printStream.println("Resultado comando C2 WS " + resultWS);
			this.printStream.println("Resultado comando C2 database " + resultDatabase);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Cancelando execução do comando C2");
			this.printStream.println("timeout na execução do comando C2");
			this.futureC2WS.cancel(true);
			this.futureC2Database.cancel(true);
		}

		System.out.println("Finalizado comando C2");

		return null;
	}

}
