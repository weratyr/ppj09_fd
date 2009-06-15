package ppj09.gwt.swapweb.server;

/*
 * Stefan Elm
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBankerConnection {


	
	private String dbUrl = "jdbc:mysql://db4free.net:3306/onlineswapdb";
	private String username = "fuldaprojekt";
	private String pwd = "fuldaprojekt";

	
	
	private Connection con = null;
	Statement stmt = null;
	
	public DataBankerConnection(){
		
	}
	
	public Statement getStatement() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(dbUrl, username, pwd);
			stmt = con.createStatement(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
	 
    public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(dbUrl, username, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void close() throws SQLException {
		con.close();
	}
	
	public void closeStatement() throws SQLException{
		stmt.close();
	}

}
