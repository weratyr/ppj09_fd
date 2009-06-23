package ppj09.gwt.swapweb.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.Offer;
import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.Parameter;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.datatype.UserSearchQuery;
import ppj09.gwt.swapweb.client.datatype.UserSearchResult;

public class DataBankerQueries {
	private boolean queryHasCondition;
	private String query;

	public DataBankerQueries() {
		queryHasCondition = false;
	}

	public ArrayList<SearchResult> retriveArticles(
			ArrayList<Parameter> parameters) {
		return null;
	}

	public ArrayList<SearchResult> retriveUsers() {
		return null;
	}

	/*
	 * Erstellt einen neuen User und gibt einen Status Code zurück 0 = Fehler 1
	 * = OK 2 = User existiert bereits
	 */
	public int createUser(User newUser) {
		String username = newUser.getUsername();
		String pwdHash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		String firstName = newUser.getFirstName();
		String lastName = newUser.getLastName();
		String street = newUser.getStreet();
		String houseNumber = newUser.getHouseNumber();
		String zipCode = newUser.getZip();
		String city = newUser.getCity();
		String email = newUser.getEmail();
		// String gender = newUser.getGender();
		// Date birthdate = (Date) newUser.getBirthdate();
		// String job = newUser.getJob();
		// String hobbies = newUser.getHobbys();
		// String music = newUser.getMusic();
		// String movies = newUser.getMovie();
		// String iLike = newUser.getILike();
		// String iDontLike = newUser.getIDontLike();
		// String aboutMe = newUser.getAboutMe();
		// String icq = newUser.getIcq();
		// String yahoo = newUser.getYahoo();
		// String aim = newUser.getAim();
		// String jabber = newUser.getJabber();
		// String msn = newUser.getMsn();
		// String homepage = newUser.getHomepage();

		DataBankerConnection dbc = new DataBankerConnection();

		if (!checkUsername(username)) {
			try {
				PreparedStatement stmt = dbc


				.getConnection()
				.prepareStatement(
				"INSERT INTO user(username, pwd, firstName, lastName, street, houseNumber, zipCode, city, email) VALUES(?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, username);
				stmt.setString(2, pwdHash);
				stmt.setString(3, firstName);
				stmt.setString(4, lastName);
				stmt.setString(5, street);
				stmt.setString(6, houseNumber);
				stmt.setString(7, zipCode);
				stmt.setString(8, city);
				stmt.setString(9, email);
				System.out.println(stmt.toString());

				stmt.executeUpdate();

				ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

				int id = 0;

				while (rs.next()) {
					id = rs.getInt(1);
				}

				System.out.println("DAS IST JETZT DIE LETZTE ID: " + id);

				rs.close();
				dbc.close();
				stmt.close();

				return id; // OK
			} catch (SQLException e) {
				System.out.println(e);
				return 0; // Fehler
			}
		} else {
			return 2; // Username existiert bereits
		}
	}


	/*
	 * Aktualisiert das Userprofil und gibt Statuscode zurück 0 = Fehler ...
	 */
	public int updateUser(String userName, User updatedUser) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		DataBankerConnection dbc = new DataBankerConnection();
		try {
			System.out.println("Mache Update");

			String pwd = BCrypt.hashpw(updatedUser.getPassword(), BCrypt
					.gensalt());
			String query = null;
			if (updatedUser.getPassword().equals("")) {
				query = "UPDATE user SET firstName='"
						+ updatedUser.getFirstName() + "', " + "lastName='"
						+ updatedUser.getLastName() + "', " + "street='"
						+ updatedUser.getStreet() + "', " + "houseNumber='"
						+ updatedUser.getHouseNumber() + "'," + "zipcode='"
						+ updatedUser.getZip() + "', " + "city='"
						+ updatedUser.getCity() + "'," + "email='"
						+ updatedUser.getEmail() + "', " + "gender='"
						+ updatedUser.getGender() + "', " + "birthdate='"
						+ sdf.format(updatedUser.getBirthdate()) + "', "
						+ "job='" + updatedUser.getJob() + "', " + "hobbies='"
						+ updatedUser.getHobbys() + "', " + "music='"
						+ updatedUser.getMusic() + "'," + "movies='"
						+ updatedUser.getMovie() + "'," + "iLike='"
						+ updatedUser.getILike() + "', " + "iDontLike='"
						+ updatedUser.getIDontLike() + "', " + "aboutMe='"
						+ updatedUser.getAboutMe() + "'," + "icq='"
						+ updatedUser.getIcq() + "'," + " yahoo='"
						+ updatedUser.getYahoo() + "'," + " aim='"
						+ updatedUser.getAim() + "', " + "jabber='"
						+ updatedUser.getJabber() + "', " + "msn='"
						+ updatedUser.getMsn() + "', " + "homepage='"
						+ updatedUser.getHomepage() + "' " + "WHERE username='"
						+ userName + "' ";

			} else {
				query = "UPDATE user SET pwd='" + pwd + "', " + "firstName='"
						+ updatedUser.getFirstName() + "', " + "lastName='"
						+ updatedUser.getLastName() + "', " + "street='"
						+ updatedUser.getStreet() + "', " + "houseNumber='"
						+ updatedUser.getHouseNumber() + "'," + "zipcode='"
						+ updatedUser.getZip() + "', " + "city='"
						+ updatedUser.getCity() + "'," + "email='"
						+ updatedUser.getEmail() + "', " + "gender='"
						+ updatedUser.getGender() + "', " + "birthdate='"
						+ sdf.format(updatedUser.getBirthdate()) + "', "
						+ "job='" + updatedUser.getJob() + "', " + "hobbies='"
						+ updatedUser.getHobbys() + "', " + "music='"
						+ updatedUser.getMusic() + "'," + "movies='"
						+ updatedUser.getMovie() + "'," + "iLike='"
						+ updatedUser.getILike() + "', " + "iDontLike='"
						+ updatedUser.getIDontLike() + "', " + "aboutMe='"
						+ updatedUser.getAboutMe() + "'," + "icq='"
						+ updatedUser.getIcq() + "'," + " yahoo='"
						+ updatedUser.getYahoo() + "'," + " aim='"
						+ updatedUser.getAim() + "', " + "jabber='"
						+ updatedUser.getJabber() + "', " + "msn='"
						+ updatedUser.getMsn() + "', " + "homepage='"
						+ updatedUser.getHomepage() + "' " + "WHERE username='"
						+ userName + "' ";
			}
			int resultCode = dbc.getStatement().executeUpdate(query);
			dbc.close();
			dbc.getStatement().close();
			return resultCode;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Erstellt einen neuen Artikel und gibt Statuscode zurück: 0 = Fehler 1 =
	 * OK 2 = User nicht eingeloggt
	 */
	public int createArticle(Article newArticle, int userId) {
		String title = newArticle.getTitle();
		String category = newArticle.getCategory();
		String zipcode = newArticle.getZipCode();
		String city = newArticle.getLocation();
		String articlecondition = newArticle.getCondition();
		String shipping = newArticle.getShippingMethods();
		String amount = newArticle.getOfferScope();
		String swaps = newArticle.getDesiredItemsComment();
		String description = newArticle.getDescription();

		DataBankerConnection dbc = new DataBankerConnection();
		if (userId != 0) { // User ist eingeloggt
			try {
				PreparedStatement stmt = dbc

				.getConnection()
				.prepareStatement(
				"INSERT INTO article(userid, title, zipcode, category, city, articlecondition, shipping, amount, swaps, description) VALUES(?,?,?,?,?,?,?,?,?,?)");

				stmt.setString(1, Integer.toString(userId));
				stmt.setString(2, title);
				stmt.setString(3, zipcode);
				stmt.setString(4, category);
				stmt.setString(5, city);
				stmt.setString(6, articlecondition);
				stmt.setString(7, shipping);
				stmt.setString(8, amount);
				stmt.setString(9, swaps);
				stmt.setString(10, description);
				System.out.println(stmt.toString());

				stmt.executeUpdate();

				ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

				int id = 0;

				while (rs.next()) {
					id = rs.getInt(1);
				}

				rs.close();
				dbc.close();
				stmt.close();
				System.out.println("done!");
				return id; // OK
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("net done!");
				return 0; // Fehler
			}
		} else {
			System.out.println("NICHT EINGELOGT");
			return 2; // User nicht eingeloggt
		}
	}

	/*
	 * Erstellt einen neuen Offer und gibt Statuscode zurück: 0 = Fehler 1 = OK
	 */

	public int createOffer(Offer newOffer) {
		int desiredArticleId = newOffer.getDesiredArticleId();
		String offerItemIds = newOffer.getOfferedArticleIds();
		String offerComment = newOffer.getOfferComment();
		int swapStatus = newOffer.getSwapStatus();

		DataBankerConnection dbc = new DataBankerConnection();
		try {
			PreparedStatement stmt = dbc.getConnection().prepareStatement(
					"INSERT INTO offer(desiredItemId, offerItemIds, offerComment, swapStatusId) VALUES(?,?,?,?)");
			stmt.setInt(1, desiredArticleId);
			stmt.setString(2, offerItemIds);
			stmt.setString(3, offerComment);
			stmt.setInt(4, swapStatus);

			stmt.executeUpdate();

			dbc.close();
			stmt.close();
			System.out.println("done!");
			return 1; // OK
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("net done!");
			return 0; // Fehler
		}
	}

	public boolean saveImageToArticle(String url, String id) {
		boolean saved = false;

		DataBankerConnection dbc = new DataBankerConnection();

		if (!id.equals("0")) {
			try {
				int resultCode = dbc.getStatement().executeUpdate(
						"UPDATE article SET image1='" + url + "' WHERE id='"
								+ id + "'");
				dbc.close();
				dbc.getStatement().close();

				saved = true; // OK
			} catch (SQLException e) {
				System.out.println(e);
				return false; // Fehler
			}
		}

		return saved;
	}

	public boolean saveImageToUser(String url, String id) {
		boolean saved = false;

		DataBankerConnection dbc = new DataBankerConnection();

		if (!id.equals("0")) {
			try {
				int resultCode = dbc.getStatement().executeUpdate(
						"UPDATE user SET image='" + url + "' WHERE id='" + id
								+ "'");
				dbc.close();
				dbc.getStatement().close();

				//return resultCode;

				saved = true; // OK
			} catch (SQLException e) {
				System.out.println(e);
				return false; // Fehler
			}
		}

		return saved;
	}

	public boolean updateImageToUser(String url, String user) {
		boolean saved = false;

		DataBankerConnection dbc = new DataBankerConnection();

		if (attrSpecified(user)) {
			try {
				int resultCode = dbc.getStatement().executeUpdate(
						"UPDATE user SET image='" + url + "' WHERE username='"
								+ user + "'");
				dbc.close();
				dbc.getStatement().close();

				saved = true; // OK
			} catch (SQLException e) {
				System.out.println(e);
				return false; // Fehler
			}
		}

		return saved;
	}

	public int getLastInsertedId() {
		int id = 0;
		ResultSet rs = null;

		DataBankerConnection dbc = new DataBankerConnection();

		Statement stmt = dbc.getStatement();
		String query = "SELECT LAST_INSERT_ID()";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				id = rs.getInt(1);
			}

			System.out.println("LAST ID: " + id);
			rs.close();
			stmt.close();
			dbc.close();

		} catch (SQLException e) {
			return 0;
			// e.printStackTrace();
		}

		return id;
	}

	public boolean checkUsername(String UserId) {
		ResultSet rs = null;
		boolean exist = false;

		DataBankerConnection dbc = new DataBankerConnection();

		Statement stmt = dbc.getStatement();
		String query = "SELECT * FROM user WHERE userid='" + UserId + "'";
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
			// e.printStackTrace();
		}
		return exist;
	}

	/*
	 * Vergleicht das angegebene Passwort mit dem aus dem Userprofil und gibt
	 * einen Statuscode zurück 1 = übereinstimmend 0 = nicht übereinstimmend
	 */
	public boolean loginRequest(String user, String suppliedPwd) {
		String hashFromDB = null;
		boolean exists = false;
		ResultSet rs = null;

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT pwd FROM user WHERE username='" + user + "'";

		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				hashFromDB = rs.getString(1);
			}

			exists = BCrypt.checkpw(suppliedPwd, hashFromDB);
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();

		} catch (SQLException e) {
			return false;
		}
		return exists;
	}

	/*
	 * Liefert die ID für einen Usernamen oder Null wenn der Username nicht
	 * existiert
	 */
	public int getUserId(String userName) {
		ResultSet rs = null;
		int id = 0;

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT id FROM user WHERE username='" + userName + "'";
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
			// e.printStackTrace();
		}
		return id;
	}

	/*
	 * Liefert den Username für eine userid oder Null wenn die userid nicht
	 * existiert
	 */
	public String getUsername(int user) {
		ResultSet rs = null;
		String username = null;

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT username FROM user WHERE id='" + user + "'";
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				username = rs.getString("username");
			}
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
		} catch (SQLException e) {
			return username;
			// e.printStackTrace();
		}
		return username;
	}

	public User getUserProfile(String username) {
		User user = new User();
		ResultSet rs = null;

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT * FROM user WHERE username='" + username + "'";
		try {
			rs = stmt.executeQuery(query);
			if (rs.wasNull()) {
				System.out.println("rs ist null getUserProfil");
			}
			rs.next();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("pwd"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setStreet(rs.getString("street"));
			user.setHouseNumber(rs.getString("houseNumber"));
			user.setZip(rs.getString("zipCode"));
			user.setCity(rs.getString("city"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setBirthdate(rs.getDate("birthdate"));
			user.setJob(rs.getString("job"));
			user.setHobbys(rs.getString("hobbies"));
			user.setMusic(rs.getString("music"));
			user.setMovie(rs.getString("movies"));
			user.setILike(rs.getString("iLike"));
			user.setIDontLike(rs.getString("iDontLike"));
			user.setAboutMe(rs.getString("aboutMe"));
			user.setIcq(rs.getString("icq"));
			user.setYahoo(rs.getString("yahoo"));
			user.setAim(rs.getString("aim"));
			user.setJabber(rs.getString("jabber"));
			user.setMsn(rs.getString("msn"));
			user.setHomepage(rs.getString("homepage"));
			user.setImage(rs.getString("image"));
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fehler databankerQueries: getUserProfil()");
			return null;
		}
		return user;
	}


	public ArrayList<SearchResult> getArticleSearchResults(ArticleSearchQuery sq) {
		ArrayList<SearchResult> articleList = new ArrayList<SearchResult>();
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();

		queryHasCondition = false;
		query = "SELECT * FROM article WHERE ";
		if (attrSpecified(sq.getUserName())) {
			int userid = getUserId(sq.getUserName());
			addCondition("userid ='" + userid + "'");
		}
		if (attrSpecified(sq.getCategoryPhrase()))
			addCondition("category ='" + sq.getCategoryPhrase() + "'");
		if (attrSpecified(sq.getUserIdPhrase()))
			addCondition("id ='" + sq.getCategoryPhrase() + "'");
		if (attrSpecified(sq.getSearchPhrase()))
			addCondition("title like '%" + sq.getSearchPhrase() + "%'");
		if (attrSpecified(sq.getLocation()))
			addCondition("city like '" + sq.getLocation() + "'");
		if (attrSpecified(sq.getCategory()))
			addCondition("category = '" + sq.getCategory() + "'");
		if (attrSpecified(sq.getCondition()))
			addCondition("articlecondition = '" + sq.getCondition() + "'");
		if (attrSpecified(sq.getShippingMethods()))
			addCondition("shipping = '" + sq.getShippingMethods() + "'");
		if (sq.isPicturesOnly())
			addCondition("image1 is not null");

		System.out.println(query);
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				articleList.add(new ArticleSearchResult(
						resultSet.getString("title"), 
						getUsername(resultSet.getInt("userid")), 
						resultSet.getString("image1"),
						resultSet.getInt("id")));
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return articleList;
	}
	
	/*
	 * Liefert den Artikel über die ID
	 */
	public Article getArticle(int articleId) {
		Article article = new Article();
		ResultSet rs = null;

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT * FROM article WHERE id='" + articleId + "'";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				article.setUserId(rs.getInt("userid"));
				article.setUserName(getUsername(rs.getInt("userid")));
				article.setArticleId(rs.getInt("id"));
				article.setCategory(rs.getString("category"));
				article.setPictureUrl(rs.getString("image1"));
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
		}

		return article;
	}

	public ArrayList<String> getCategories() {
		ResultSet rs = null;
		ArrayList<String> categories = new ArrayList<String>();

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT * FROM categories";
		try {
			rs = stmt.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				categories.add(rs.getString("category"));
				i++;
			}
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return categories;
	}

	public ArrayList<Article> getOwnArticlesList(int userId) {
		ResultSet rs = null;
		ArrayList<Article> ownArticles = new ArrayList<Article>();
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT * FROM article WHERE userid ='" + userId + "'";
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ownArticles.add(new Article(rs.getInt("id"), rs
						.getString("title"), rs.getString("amount")));
			}
			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return ownArticles;
	}
	

	public ArrayList<SearchResult> getOfferedArticles(int articleId) {
		ArrayList<SearchResult> offerList = new ArrayList<SearchResult>();
		
//		ArticleSearchResult asr = new ArticleSearchResult("a","b","c",5);
//		ArrayList<SearchResult> asr_list = new ArrayList<SearchResult>();
//		asr_list.add(asr);
//		OfferSearchResult osr = new OfferSearchResult(asr_list);
//		offerList.add(osr);
//		return offerList;
//		
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		ResultSet desiredItemsResultSet = null;
		
		String teststr = "";
		
		articleId = 76;
		String query = "SELECT * FROM offer WHERE desiredItemId = '" + articleId + "'";
		// desiredItemId, offerItemIds
		try {
			desiredItemsResultSet = stmt.executeQuery(query);
			// for desiredItems
			while (desiredItemsResultSet.next()) {
				ArrayList<Integer> ids = new ArrayList<Integer>();
				ArrayList<SearchResult> articles = new ArrayList<SearchResult>();
				// Parsed die ids aus dem String
				for (String strId : desiredItemsResultSet.getString("offerItemIds").split(",")) {
					int intId = Integer.parseInt(strId);
					if (intId != 0) {
						ids.add(intId);
					}
				}
				System.out.println("IDs: " + ids.toString());

				// Fetched Offer Objekte für die Ids
				for (int id : ids) {
					// DataBankerConnection dbc = new DataBankerConnection();
					query = "SELECT * FROM article WHERE id = '" + id + "'";
					stmt = dbc.getStatement();
					ResultSet articleResultSet = stmt.executeQuery(query);;
					while(articleResultSet.next()) {
						articles.add(new ArticleSearchResult(
								articleResultSet.getString("title"), 
								getUsername(articleResultSet.getInt("userid")), 
								articleResultSet.getString("image1"),
								articleResultSet.getInt("id")));
					} 
					System.out.println("neuer Result: " + id);
				}
				ids.clear();
				//Offer o = new Offer(resultSet);
				offerList.add(new OfferSearchResult(articles));
				teststr = "";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return offerList;
	}
	
	
	// Helper mehtods
	
	/**
	 * Fügt eine neue Bedingung an das Query an.
	 */
	public void addCondition(String condition) {
		if (!queryHasCondition) {
			query += condition;
			queryHasCondition = true;
		} else
			query += " AND " + condition;
	}

	/**
	 * Überprüft ob der angegebene Parameter definiert ist.
	 */
	public boolean attrSpecified(String str) {
		if (str==null || str.trim().equals(""))
			return false;
		else
			return true;
	}
	
	public ArrayList<SearchResult> getUserSearchResults(UserSearchQuery sq) {
		ArrayList<SearchResult> userList = new ArrayList<SearchResult>();
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();

		queryHasCondition = false;
		query = "SELECT * FROM user WHERE ";
		
		if (attrSpecified(sq.getFirstname()))
			addCondition("firstname ='" + sq.getFirstname() + "'");
		if (attrSpecified(sq.getLastname()))
			addCondition("lastname ='" + sq.getLastname() + "'");
		if (attrSpecified(sq.getUsername()))
			addCondition("username like '%" + sq.getUsername() + "%'");
		if (attrSpecified(sq.getCity()))
			addCondition("city = '" + sq.getCity() + "'");
		if (attrSpecified(sq.getHobbies()))
			addCondition("hobbies = '" + sq.getHobbies() + "'");
		if (attrSpecified(sq.getJob()))
			addCondition("job = '" + sq.getJob() + "'");
		if (sq.isOnlyPic())
			addCondition("image is not null");

		System.out.println(query);
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				userList.add(new UserSearchResult(getUserProfile(resultSet.getString("username"))));
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return userList;
	}
}