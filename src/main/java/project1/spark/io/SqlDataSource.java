package project1.spark.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataSource {
	private static SqlDataSource instance;
	private String url;
	private String user;
	private String password;
	
	private SqlDataSource() {
		url = System.getProperty("database.url", "jdbc:postgresql://3.21.205.41:5432/players");
		user = System.getProperty("database.username", "players");
		password = System.getProperty("database.password", "players");
	}
	
	public static SqlDataSource getInstance() {
		if (instance == null) {
			instance = new SqlDataSource();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

}
