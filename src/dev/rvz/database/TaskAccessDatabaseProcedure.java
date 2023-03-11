package dev.rvz.database;

final class TaskAccessDatabaseProcedure implements Runnable {
    private final DatabaseConnectionManagerMain databaseConnectionManagerMain;
    private final PoolConnection poolConnection;

    public TaskAccessDatabaseProcedure(DatabaseConnectionManagerMain databaseConnectionManagerMain,
	    PoolConnection poolConnection) {
	this.databaseConnectionManagerMain = databaseConnectionManagerMain;
	this.poolConnection = poolConnection;
    }

    @Override
    public void run() {
	synchronized (poolConnection) {
	    System.out.println("Peguei a chave da poolConnection");
	    poolConnection.getConnection();
	    synchronized (databaseConnectionManagerMain) {
		System.out.println("Peguei a chave do databaseConnectionManagerMain");
		databaseConnectionManagerMain.begin();
	    }
	}
    }

}