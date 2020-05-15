package project1.spark.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;


public class SqlSparkRepository {
	private SqlDataSource dataSource;
	private LinkedHashMap<String, String> cache;
	
	public SqlSparkRepository(SqlDataSource dataSource) {
		this.dataSource = dataSource;
		cache = new LinkedHashMap<String, String>();
	}
	
	public void insertAll(String name, String result) {
		String sql = "insert into RDDTransform(name_short, result) values(?, ?)";
		try (Connection connection = this.dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setString(1, name);
				statement.setString(2, result);
				statement.addBatch();
				statement.executeBatch();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public LinkedHashMap<String, String> readAll() {
		String sql = "select * from RDDTransform";
		try (Connection connection = this.dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);) {
			while (rs.next()) {
				cache.put(rs.getString("name_short"), rs.getString("result"));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}	
		return cache;
	}
}
