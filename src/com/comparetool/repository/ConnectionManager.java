package com.comparetool.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private Connection _connection;

	public ConnectionManager(String driverName, String serverName,
			String serverPort, String username, String password) {
		try {
			Class.forName(driverName);	
			String database = serverName + ":" + serverPort;
			String url = "jdbc:sqlserver://" + database;
			_connection = DriverManager.getConnection(url, username, password);	
		} catch (ClassNotFoundException e) {

			System.out.println("Could not find the database driver "
					+ e.getMessage());
		} catch (SQLException e) {

			System.out.println("Could not connect to the database "
					+ e.getMessage());
		}
	}	
	public void setConnection(String driverName, String serverName,
			String serverPort, String username, String password) {
		try {
			Class.forName(driverName);	
			String database = serverName + ":" + serverPort;
			String url = "jdbc:JSQLConnect://" + database;
			_connection = DriverManager.getConnection(url, username, password);	
		} catch (ClassNotFoundException e) {

			System.out.println("Could not find the database driver "
					+ e.getMessage());
		} catch (SQLException e) {

			System.out.println("Could not connect to the database "
					+ e.getMessage());
		}
	}	
	
	public ResultSet listTables()
	{

		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = _connection.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM sys.Tables");		   
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;
	}
	
	public Connection getConnection()
	{
		return _connection;
	}
}
