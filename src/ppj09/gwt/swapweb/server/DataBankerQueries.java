package ppj09.gwt.swapweb.server;

/*
 * Stefan Elm
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import ppj09.gwt.swapweb.client.datatype.Article;
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
		String pwd = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(pwd);
		
		DataBankerConnection dbc = new DataBankerConnection();
	    
		if(!checkUsername(userID)) {
		
			try {
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("INSERT INTO user(userid, pwd, userob) VALUES(?,?,?)");
			   stmt.setString(1, userID);
			   stmt.setString(2, pwd);
			   stmt.setObject(3, (Object)newUser);
			   
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
	
	public int createArticle(String userID, Article newArticle) {
		String user = userID;
		System.out.println(user);
		return 0;
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
	public boolean loginRequest(String user, String pwHash) {
		String hashFromDB = null;
		boolean exist = false;
		ResultSet rs = null;
		
		DataBankerConnection dbc = new DataBankerConnection();
	    Statement stmt = dbc.getStatement();
	    String query = "SELECT pwd FROM user WHERE userid='"+user+"'";
	    try {
	    	rs = stmt.executeQuery(query);
	    	

	    	while (rs.next()) {
	    		hashFromDB = rs.getString(1);
			}

	    	exist =BCrypt.checkpw(pwHash, hashFromDB);
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
	    	
	    } catch (SQLException e) {
	    	return false;
	    	//e.printStackTrace();
	    }
		return exist;
	}
	
	/*
	 * return null -> Fehler beim Auslesen des Users
	 * return User -> erfolgreich ausgelesen 
	 */
	public User getUserProfile(String userId) {
		User user = new User();
		ResultSet rs = null;
		
		DataBankerConnection dbc = new DataBankerConnection();
	    Statement stmt = dbc.getStatement();
	    String query = "SELECT * FROM user WHERE userid='"+userId+"'";
	    try {
	    	rs = stmt.executeQuery(query);
	    	
	    	while (rs.next()) {
			
	    		InputStream is = rs.getBlob("userob").getBinaryStream();
	    		ObjectInputStream ois = new ObjectInputStream(is);
	    		Object x = ois.readObject(); 
	    		user = (User)x;
			}
			
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
	    	
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    	//e.printStackTrace();
	    } catch (IOException ioe) {
	    	ioe.printStackTrace();
	    } catch (ClassNotFoundException cnfe) {
	    	cnfe.printStackTrace();
	    }
		
		return user;
	}
	
	/*
	 * return = 0 -> FEHLER - User nicht angelegt
	 * return = 1 -> OK - User wurde angelegt
	 * return = 2 -> USER existiert schon
	 */
	public int updateUser(String oldUserName, User newUser) {
		int saved = 0;
		
		String userID = newUser.getUsername();
		String pwd = newUser.getPassword();
		
		DataBankerConnection dbc = new DataBankerConnection();
	    
		
		
		
		
		//if( !(userID.equals(oldUserName)) && !checkUsername(userID)) {
		
			try {
			   //PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user(userid, pwd, userob) VALUES(?,?,?)");
			   System.out.println("Mache Update");
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user SET userid=?,pwd=?,userob=? WHERE userid = ?");
			   stmt.setString(1, userID);
			   stmt.setString(2, pwd);
			   stmt.setObject(3, (Object)newUser);
			   stmt.setString(4, oldUserName);
			   
			   stmt.executeUpdate();
		       
			   dbc.close();
			   stmt.close();
			   
			   saved = 1;
			} catch (SQLException e) {
			   e.printStackTrace();
			   return 0;	
			}
		//}
		//else {
		//	saved = 2; 
		//}
		
		return saved;
	}
}
