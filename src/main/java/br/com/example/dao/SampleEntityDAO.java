package br.com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.example.jdbc.ConnectionFactory;
import br.com.example.model.SampleEntity;

public class SampleEntityDAO {
	
	private Connection connection;
	
	public SampleEntityDAO() {
		this.connection = new ConnectionFactory().getMyConnection();
	}
	
	public void insert(SampleEntity sampleEntity) throws SQLException {
		String query = "insert into SampleEntity "
				+ "(name, creation) "
				+ "values (?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, sampleEntity.getName());
			pstmt.setDate(2, new Date(sampleEntity.getCreation().getTimeInMillis()));	
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

}
