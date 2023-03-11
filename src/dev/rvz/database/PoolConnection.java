package dev.rvz.database;

final class PoolConnection {

	public String getConnection() {
		System.out.println("Emprestando conexão");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "connection";
	}
}
