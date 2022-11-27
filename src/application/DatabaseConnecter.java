package application;

import java.sql.Connection;

public class DatabaseConnecter {

	static Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		DatabaseConnecter.con = con;
	}
	
	
	
}
