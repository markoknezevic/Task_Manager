package DataAccess.Repositories;

import java.sql.Connection;

public class Repository implements IRepository{

	Connection databaseConnection;
	
	public Repository(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
}
