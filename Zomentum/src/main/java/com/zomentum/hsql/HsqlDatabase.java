package com.zomentum.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlDatabase {
	
	public Connection conn;
	
	public HsqlDatabase() {
		try {
			loadJdbcDriverForSQLServer();
			setupConnection();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setupConnection() throws SQLException {
		try {
			System.out.println("SetupConnection Accessed Successfully");
			String connectionUrl = "jdbc:sqlserver://APOORV\\SQLEXPRESS:51120;"
					+ "databaseName=SpringJava;integratedSecurity=true";
			 conn = DriverManager.getConnection(connectionUrl);
			System.out.println(conn.getCatalog());
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
    private void loadJdbcDriverForSQLServer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("loadJdbcDriverForSQLServer Accessed Successfully");
	}
	
	private void shutdownHsqlDatabase() throws SQLException {
		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
	}
	
	public void closeConnection() throws SQLException {
		shutdownHsqlDatabase();
		conn.close();
	}
}