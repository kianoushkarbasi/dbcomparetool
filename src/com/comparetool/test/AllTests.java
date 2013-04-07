package com.comparetool.test;

import java.sql.ResultSet;

import com.comparetool.repository.ConnectionManager;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		String driverName ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		ConnectionManager conn = new ConnectionManager(driverName,"data.blondgorilla.com","1433","sa","Ktxt0pscan");
		ResultSet test= conn.listTables();		
		//$JUnit-END$
		return suite;
	}


}
