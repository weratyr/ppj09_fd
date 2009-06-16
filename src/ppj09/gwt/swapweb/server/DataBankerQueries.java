package ppj09.gwt.swapweb.server;

/*
 * Stefan Elm
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Date;
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
		
		String username = newUser.getUsername();
		String pwd = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(pwd);
		String firstName = newUser.getFirstName();
		String lastName = newUser.getLastName();
		String street = newUser.getStreet();
		String houseNumber = newUser.getHouseNumber();
		String zipCode = newUser.getZip();
		String city = newUser.getCity();
		String email = newUser.getEmail();
		String gender = newUser.getGender();
		Date birthdate = (Date) newUser.getBirthdate();
		String job = newUser.getJob();
		String hobbies = newUser.getHobbys();
		String music = newUser.getMusic();
		String movies = newUser.getMovie();
		String iLike = newUser.getILike();
		String iDontLike = newUser.getIDontLike();
		String aboutMe = newUser.getAboutMe();
		String icq = newUser.getIcq();
		String yahoo = newUser.getYahoo();
		String aim = newUser.getAim();
		String jabber = newUser.getJabber();
		String msn = newUser.getMsn();
		String homepage = newUser.getHomepage();

		DataBankerConnection dbc = new DataBankerConnection();
	    
		if(!checkUsername(username)) {
		
			try {
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("INSERT INTO user2(username, pwd, firstName, lastName, street, houseNumber, zipCode, city, email, gender, birthdate, job, hobbies, music, movies, iLike, iDontLike, aboutMe, icq, yahoo, aim, jabber, msn, homepage) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			   stmt.setString(1, username);
			   stmt.setString(2, pwd);
			   stmt.setString(3, firstName);
			   stmt.setString(4, lastName);
			   stmt.setString(5, street);
			   stmt.setString(6, houseNumber);
			   stmt.setString(7, zipCode);
			   stmt.setString(8, city);
			   stmt.setString(9, email);
			   stmt.setString(10, gender);
			   stmt.setDate(11, birthdate);
			   stmt.setString(12, job);
			   stmt.setString(13, hobbies);
			   stmt.setString(14, music);
			   stmt.setString(15, movies);
			   stmt.setString(16, iLike);
			   stmt.setString(17, iDontLike);
			   stmt.setString(18, aboutMe);
			   stmt.setString(19, icq);
			   stmt.setString(20, yahoo);
			   stmt.setString(21, aim);
			   stmt.setString(22, jabber);
			   stmt.setString(23, msn);
			   stmt.setString(24, homepage);
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
	
	public int createArticle(Article newArticle) {
		int saved = 0;
		
		String title = newArticle.getTitle();
		String zipcode = newArticle.getZipCode();
		String city = newArticle.getLocation();
		System.out.println(newArticle.getShippingMethods());

		DataBankerConnection dbc = new DataBankerConnection();

		try {
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("INSERT INTO article(title, zipcode, city) VALUES(?,?,?)");
			   stmt.setString(1, title);
			   stmt.setString(2, zipcode);
			   stmt.setString(3, city);
//			   stmt.setString(4, lastName);
//			   stmt.setString(5, street);
//			   stmt.setObject(6, houseNumber);
//			   stmt.setString(7, zipCode);
//			   stmt.setString(8, city);
//			   stmt.setObject(9, email);
//			   stmt.setString(10, gender);

			   stmt.executeUpdate();
		       
			   dbc.close();
			   stmt.close();
			   System.out.println("done!");
			   saved = 1;
			} catch (SQLException e) {
				   System.out.println("net done!");
				return 0;	
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
		
//			try {
//			   //PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user(userid, pwd, userob) VALUES(?,?,?)");
//			   System.out.println("Mache Update");
//			   PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user SET userid=?,pwd=?,userob=? WHERE userid = ?");
//			   stmt.setString(1, userID);
//			   stmt.setString(2, pwd);
//			   stmt.setObject(3, (Object)newUser);
//			   stmt.setString(4, oldUserName);
//			   
//			   stmt.executeUpdate();
//		       
//			   dbc.close();
//			   stmt.close();
//			   
//			   saved = 1;
//			}
		try {
			   //PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user(userid, pwd, userob) VALUES(?,?,?)");
			   System.out.println("Mache Update");
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user SET userid=?,userob=? WHERE userid = ?");
			   stmt.setString(1, userID);
			//   stmt.setString(2, pwd);
			   stmt.setObject(2, (Object)newUser);
			   stmt.setString(3, oldUserName);
			   
			   stmt.executeUpdate();
		       
			   dbc.close();
			   stmt.close();
			   
			   saved = 1;
			}catch (SQLException e) {
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
