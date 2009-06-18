package ppj09.gwt.swapweb.server;

/*
 * Stefan Elm
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBankerConnection {


	
	private String dbUrl = "jdbc:mysql://88.198.34.99:3306/usr_web85_1";
	private String username = "web85";
	private String pwd = "QO6lhUMx";

	
	
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
