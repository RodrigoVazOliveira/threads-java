package dev.rvz.database;

final class TaskAccessDatabase implements Runnable {

	private final DatabaseConnectionManagerMain databaseConnectionManagerMain;
	private final PoolConnection poolConnection;

	public TaskAccessDatabase(DatabaseConnectionManagerMain databaseConnectionManagerMain,
			PoolConnection poolConnection) {
		this.databaseConnectionManagerMain = databaseConnectionManagerMain;
		this.poolConnection = poolConnection;
	}

	@Override
	public void run() {
		synchronized (poolConnection) {
			System.out.println("Peguei a chave da pool");
			poolConnection.getConnection();
			synchronized (databaseConnectionManagerMain) {
				System.out.println("Peguei a chave do database");

				databaseConnectionManagerMain.begin();
			}
		}
	}

}
