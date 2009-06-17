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
//		String gender = newUser.getGender();
//		Date birthdate = (Date) newUser.getBirthdate();
//		String job = newUser.getJob();
//		String hobbies = newUser.getHobbys();
//		String music = newUser.getMusic();
//		String movies = newUser.getMovie();
//		String iLike = newUser.getILike();
//		String iDontLike = newUser.getIDontLike();
//		String aboutMe = newUser.getAboutMe();
//		String icq = newUser.getIcq();
//		String yahoo = newUser.getYahoo();
//		String aim = newUser.getAim();
//		String jabber = newUser.getJabber();
//		String msn = newUser.getMsn();
//		String homepage = newUser.getHomepage();

		DataBankerConnection dbc = new DataBankerConnection();
	    
		if(!checkUsername(username)) {
		
			try {
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("INSERT INTO user(username, pwd, firstName, lastName, street, houseNumber, zipCode, city, email) VALUES(?,?,?,?,?,?,?,?,?)");
			   stmt.setString(1, username);
			   stmt.setString(2, pwd);
			   stmt.setString(3, firstName);
			   stmt.setString(4, lastName);
			   stmt.setString(5, street);
			   stmt.setString(6, houseNumber);
			   stmt.setString(7, zipCode);
			   stmt.setString(8, city);
			   stmt.setString(9, email);
			   System.out.println(stmt.toString());

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
	
//	public int getUserId(String user) {
//		ResultSet rs = null;
//		int id = 0;
//		
//		DataBankerConnection dbc = new DataBankerConnection();
//	    Statement stmt = dbc.getStatement();
//	    String query = "SELECT id FROM user WHERE userid='"+user+"'";
//	    try {
//	    	rs = stmt.executeQuery(query);
//	    	
//	    	while (rs.next()) {
//	    		id = rs.getInt(1);
//			}
//	    	
//			rs.close();
//			dbc.close();
//			stmt.close();
//			dbc.closeStatement();
//	    	
//	    } catch (SQLException e) {
//	    	return id;
//	    	//e.printStackTrace();
//	    }
//	    
//	    return id;
//	}
	
	public int createArticle(Article newArticle, int user) {
		int saved = 0;
		
		String title = newArticle.getTitle();
		String zipcode = newArticle.getZipCode();
		String city = newArticle.getLocation();
		String articlecondition = newArticle.getCondition();
		String shipping = newArticle.getShippingMethods();
		String amount = newArticle.getOfferScope();
		String swaps = newArticle.getDesiredItemsComment();
		String description = newArticle.getDescription();
		
		System.out.println(title);
		System.out.println(zipcode);
		System.out.println(city);
		System.out.println(articlecondition);
		System.out.println(shipping);
		System.out.println(amount);
		System.out.println(swaps);
		System.out.println(description);


		DataBankerConnection dbc = new DataBankerConnection();
        
		if (user != 0) {
			try {
			    PreparedStatement stmt = dbc.getConnection().prepareStatement("INSERT INTO article(userid, title, zipcode, city, articlecondition, shipping, amount, swaps, description) VALUES(?,?,?,?,?,?,?,?,?)");
			    stmt.setString(1, Integer.toString(user));
			    stmt.setString(2, title);
			    stmt.setString(3, zipcode);
			    stmt.setString(4, city);
			    stmt.setString(5, articlecondition);
			    stmt.setString(6, shipping);
			    stmt.setString(7, amount);
			    stmt.setString(8, swaps);
			    stmt.setString(9, description);
			    System.out.println(stmt.toString());

			   stmt.executeUpdate();
		       
			    dbc.close();
			    stmt.close();
			    System.out.println("done!");
			    saved = 1;
			} catch (SQLException e) {
			    e.printStackTrace();
			    System.out.println("net done!");
			    return 0;	
			}
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
	    String query = "SELECT pwd FROM user WHERE username='"+user+"'";
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
	public int getUserId(String user) {
		 ResultSet rs = null;
		 int id = 0;
		 
		 DataBankerConnection dbc = new DataBankerConnection();
		    Statement stmt = dbc.getStatement();
		    String query = "SELECT id FROM user WHERE username='"+user+"'";
		    try {
		     rs = stmt.executeQuery(query);
		     
		     while (rs.next()) {
		      id = rs.getInt(1);
		  }
		     
		  rs.close();
		  dbc.close();
		  stmt.close();
		  dbc.closeStatement();
		     
		    } catch (SQLException e) {
		     return id;
		     //e.printStackTrace();
		    }
		    
		    return id;
		}

	public User getUserProfile(String userId) {
		User user = new User();
		ResultSet rs = null;
		
		DataBankerConnection dbc = new DataBankerConnection();
	    Statement stmt = dbc.getStatement();
	    String query = "SELECT * FROM user WHERE username='"+userId+"'";
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
			   PreparedStatement stmt = dbc.getConnection().prepareStatement("UPDATE user SET username=?,userob=? WHERE username = ?");
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

	public Article getArticle(int articleId) {
		Article article = new Article();
		ResultSet rs = null;
		
		DataBankerConnection dbc = new DataBankerConnection();
	    Statement stmt = dbc.getStatement();
	    String query = "SELECT * FROM article WHERE id='"+articleId+"'";
	    try {
	    	rs = stmt.executeQuery(query);
	    	
	    	while (rs.next()) {
	    		article.setUserId(rs.getInt("userid"));
	    		article.setTitle(rs.getString("title"));
	    		article.setZipCode(rs.getString("zipcode"));
	    		article.setLocation(rs.getString("city"));
	    		article.setCondition(rs.getString("articlecondition"));
	    		article.setShippingMethods(rs.getString("shipping"));
	    		article.setOfferScope(rs.getString("amount"));
	    		article.setDesiredItemsComment(rs.getString("swaps"));
	    		article.setDescription(rs.getString("description"));
			}
			
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
	    	
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    	//e.printStackTrace();
	    }
		
		return article;
	}
}
