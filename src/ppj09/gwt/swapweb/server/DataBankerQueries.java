package ppj09.gwt.swapweb.server;

/*
 * Stefan Elm
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Parameter;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;

public class DataBankerQueries {
	public ArrayList<SearchResult> retriveArticles(ArrayList<Parameter> parameters) {
		return null;
	}
	
	public ArrayList<SearchResult> retriveUsers() {
		return null;
		
	}
	
	/*
	 * return = 0 -> FEHLER - User nicht angelegt
	 * return = 1 -> OK - User wurde angelegt
	 * return = 2 -> USER existiert schon
	 */
	public int createUser(User newUser) {
		//IN DATENBANK SPEICHERN
		int saved = 0;
		
		String userID = newUser.getUsername();
		String pwd = newUser.getPassword();
		
		DataBankerConnection dbc = new DataBankerConnection();
	    
		if(!checkUsername(userID)) {
		
			try {
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("INSERT INTO user(userid, pwd, userob) VALUES(?,?,?)");
			   stmt.setString(1, userID);
			   stmt.setString(2, pwd);
			   stmt.setObject(3, newUser);
			   
			   stmt.executeUpdate();
		       
			   dbc.close();
			   stmt.close();
			   
			   saved = 1;
			} catch (SQLException e) {
			   return 0;	
			}
		}
		else {
			saved = 2; 
		}
		
		return saved;
	}
	
	public boolean checkUsername(String UserId) {
		ResultSet rs = null;
		boolean exist = false;
		
		DataBankerConnection dbc = new DataBankerConnection();
		
		Statement stmt = dbc.getStatement();
	    String query = "SELECT * FROM user WHERE userid='"+UserId+"'";
	    try {
	    	rs = stmt.executeQuery(query);
	    	
	    	while (rs.next()) {
				exist = true;
			}
			
			rs.close();
			stmt.close();
			dbc.close();
	    	
	    } catch (SQLException e) {
	    	return false;
	    	//e.printStackTrace();
	    }
		return exist;
	}
	
	/*
	 * return = 0 -> KOMBINATION user, pwHash nicht vorhanden - nicht angemeldet
	 * return = 1 -> OK - user erfolgreich angemeldet
	 */
	public int loginRequest(String user, String pwHash) {
       int exist = 0;
       ResultSet rs = null;
		
		DataBankerConnection dbc = new DataBankerConnection();
	    Statement stmt = dbc.getStatement();
	    String query = "SELECT * FROM user WHERE userid='"+user+"' AND password='"+pwHash+"'";
	    try {
	    	rs = stmt.executeQuery(query);
	    	
	    	while (rs.next()) {
				exist = 1;
			}
			
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
	    	
	    } catch (SQLException e) {
	    	return 0;
	    	//e.printStackTrace();
	    }
		return exist;
	}
	
	/*
	 * return null -> Fehler beim Auslesen des Users
	 * return User -> erfolgreich ausgelesen 
	 */
	public User getUserProfile(String userId) {
		User user = null;
		ResultSet rs = null;
		
		DataBankerConnection dbc = new DataBankerConnection();
	    Statement stmt = dbc.getStatement();
	    String query = "SELECT * FROM user WHERE userid='"+userId+"'";
	    try {
	    	rs = stmt.executeQuery(query);
	    	
	    	//while (rs.next()) {
			user = (User) rs.getObject("userob");
			//}
			
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
	    	
	    } catch (SQLException e) {
	    	return null;
	    	//e.printStackTrace();
	    }
		
		return user;
	}
}
