package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		Connection connection = 
				DriverManager.getConnection("jdbc:db2://dashdb-txn-sbox-yp-lon02-13.services.eu-gb.bluemix.net:50000/BLUDB", "ktq38125","20v4+nh0pfglgxq0");
		System.out.println("Connected");
	}
}
