package dev.rvz.database;

final class DatabaseMain {

    public static void main(String[] args) {
	DatabaseConnectionManagerMain databaseConnectionManagerMain = new DatabaseConnectionManagerMain();
	PoolConnection poolConnection = new PoolConnection();

	Thread threadOne = new Thread(new TaskAccessDatabase(databaseConnectionManagerMain, poolConnection),
		"Abrindo conexão");
	Thread threadTwo = new Thread(new TaskAccessDatabaseProcedure(databaseConnectionManagerMain, poolConnection),
		"Fazendo o procedimento");

	threadOne.start();
	threadTwo.start();
    }
}
