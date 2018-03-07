package br.com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getMyConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://<database-url>/<schema-name>?verifyServerCertificate=false&useSSL=false", "<user>", "<password>");
			//return DriverManager.getConnection("jdbc:postgresql://<database-url>/<schema-name>", "<user>", "<password>");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
