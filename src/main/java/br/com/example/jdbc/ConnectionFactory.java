package br.com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getMyConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/<database-url>", "<user>", "<password>");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
