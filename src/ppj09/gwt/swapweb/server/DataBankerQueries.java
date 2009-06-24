package ppj09.gwt.swapweb.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.datatype.Offer;
import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.Rate;
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
								"INSERT INTO user(username, pwd, firstName, lastName, street, houseNumber, zipCode, city, email,image) VALUES(?,?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, username);
				stmt.setString(2, pwdHash);
				stmt.setString(3, firstName);
				stmt.setString(4, lastName);
				stmt.setString(5, street);
				stmt.setString(6, houseNumber);
				stmt.setString(7, zipCode);
				stmt.setString(8, city);
				stmt.setString(9, email);
				stmt.setString(10, "uploads/default.jpg");
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
								"INSERT INTO article(userid, title, zipcode, category, city, articlecondition, shipping, amount, swaps, description) "
										+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
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
		String shippingMethod = newOffer.getShippingMethod();
		int swapStatus = newOffer.getSwapStatus();

		DataBankerConnection dbc = new DataBankerConnection();
		try {
			PreparedStatement stmt = dbc
					.getConnection()
					.prepareStatement(
							"INSERT INTO offer(desiredItemId, offerItemIds, offerComment, swapConcluded, shippingMethod) VALUES(?,?,?,?,?)");
			stmt.setInt(1, desiredArticleId);
			stmt.setString(2, offerItemIds);
			stmt.setString(3, offerComment);
			stmt.setInt(4, swapStatus);
			stmt.setString(5, shippingMethod);

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

				// return resultCode;

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
		System.out.println("user: " + user);
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
		String query = "SELECT * FROM user WHERE username='" + UserId + "'";
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

		System.out.println(query + " getArticleSearch");
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				articleList.add(new ArticleSearchResult(resultSet
						.getString("title"), getUsername(resultSet
						.getInt("userid")), resultSet.getString("image1"),
						resultSet.getInt("id"), resultSet.getString("amount")));
			}
		} catch (Exception e) {
			System.out.println(e);
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
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		ResultSet offerResultSet = null;

		String query = "SELECT * FROM offer WHERE desiredItemId = '"
				+ articleId + "'";
		try {
			offerResultSet = stmt.executeQuery(query);
			// for desiredItems
			while (offerResultSet.next()) {
				ArrayList<ArticleSearchResult> articles = new ArrayList<ArticleSearchResult>();
				ArrayList<Integer> ids = parseForIds(offerResultSet
						.getString("offerItemIds"));

				// System.out.println("IDs: " + ids.toString());

				articles = fetchArticles(ids);

				offerList.add(new OfferSearchResult(
						offerResultSet.getInt("id"), // offer Id
						articles.get(0).getUserName(), // offer from UserName
						getUsername(getArticle(articleId).getUserId()), // offer
						// to
						// UserName
						articles, offerResultSet.getBoolean("swapConcluded")));
			}
			dbc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return offerList;
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
				userList.add(new UserSearchResult(getUserProfile(resultSet
						.getString("username"))));
			}
			dbc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return userList;
	}

	public int saveMessage(Message mesg) {
		DataBankerConnection dbc = new DataBankerConnection();
		String query = "INSERT INTO message (articleID, author, receiver, topic, message, isRead) "
				+ "VALUES('"
				+ mesg.getArticleId()
				+ "', '"
				+ mesg.getAuthor()
				+ "', '"
				+ mesg.getReceiver()
				+ "', '"
				+ mesg.getTopic()
				+ "', '" + mesg.getMessage() + "', '" + 0 + "')";
		try {
			PreparedStatement stmt = dbc.getConnection()
					.prepareStatement(query);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("fehler DBQ - saveMessage(Message mesg) " + e);
		}
		return 0;
	}

	/**
	 * Setzt das Feld `swapConcluded` in der Offer und den beteiligten Articles
	 * auf 1.
	 */
	public int acceptOffer(int offerId) {
		/*
		 * INSERT INTO usr_web85_1.message (articleID, author, receiver, topic,
		 * message, isRead) VALUES(0,'SwapWeb System','geo21','Angebot
		 * angekommen','bla',0)
		 */
		DataBankerConnection dbc = new DataBankerConnection();
		int statusCode = 0;
		try {
			Statement stmt = dbc.getStatement();
			String query = "UPDATE offer SET swapConcluded = 1 WHERE id = '"
					+ offerId + "'";
			statusCode = stmt.executeUpdate(query);

			stmt = dbc.getStatement();
			query = "SELECT * FROM offer WHERE id = '" + offerId + "'";
			ResultSet offerResult = stmt.executeQuery(query);
			offerResult.next();

			ArrayList<Integer> ids = parseForIds(offerResult
					.getString("offerItemIds"));

			stmt = dbc.getStatement();
			query = "SELECT * FROM article WHERE id = '" + ids.get(0) + "'";
			ResultSet articleResult = stmt.executeQuery(query);
			articleResult.next();
			String userName = getUsername(articleResult.getInt("userid"));
			System.out.println("UserName: " + userName);

			for (int id : ids) {
				stmt = dbc.getStatement();
				query = "UPDATE article SET swapConcluded = 1 WHERE id = '"
						+ id + "'";
				int articleResultCode = stmt.executeUpdate(query);
				System.out.println("articleResultCode: " + articleResultCode);
			}

			query = "INSERT INTO message (articleID, author, receiver, topic, message, isRead) VALUES(?,?,?,?,?,?)";
			PreparedStatement pStmt = dbc.getConnection().prepareStatement(
					query);
			pStmt.setInt(1, 0);
			pStmt.setString(2, "SwapWeb Notification");
			pStmt.setString(3, userName);
			pStmt.setString(4, "Angebot wurde angenommen!");
			pStmt.setString(5, "Das Angebot mit der ID " + offerId
					+ " wurde angenommen.");
			pStmt.setInt(6, 0);
			statusCode = pStmt.executeUpdate();
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusCode;
	}

	/**
	 * Löscht die Offer aus der Datenbank.
	 */
	public int declineOffer(int offerId) {
		DataBankerConnection dbc = new DataBankerConnection();
		int statusCode = 0;
		try {
			// get UserName
			Statement stmt = dbc.getStatement();
			query = "SELECT * FROM offer WHERE id = '" + offerId + "'";
			ResultSet offerResult = stmt.executeQuery(query);
			offerResult.next();

			ArrayList<Integer> ids = parseForIds(offerResult
					.getString("offerItemIds"));

			stmt = dbc.getStatement();
			query = "SELECT * FROM article WHERE id = '" + ids.get(0) + "'";
			ResultSet articleResult = stmt.executeQuery(query);
			articleResult.next();
			String userName = getUsername(articleResult.getInt("userid"));

			stmt = dbc.getStatement();
			String query = "DELETE FROM offer WHERE id = '" + offerId + "'";
			statusCode = stmt.executeUpdate(query);

			query = "INSERT INTO message (articleID, author, receiver, topic, message, isRead) VALUES(?,?,?,?,?,?)";
			PreparedStatement pStmt = dbc.getConnection().prepareStatement(
					query);
			pStmt.setInt(1, 0);
			pStmt.setString(2, "SwapWeb Notification");
			pStmt.setString(3, userName);
			pStmt.setString(4, "Angebot wurde abgelehnt!");
			pStmt.setString(5, "Das Angebot mit der ID " + offerId
					+ " wurde abgelehnt.");
			pStmt.setInt(6, 0);
			statusCode = pStmt.executeUpdate();
			dbc.close();
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusCode;
	}

	public ArrayList<Message> getMessages(String username) {
		ArrayList<Message> messages = new ArrayList<Message>();
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT * FROM message WHERE author = '" + username
				+ "' OR receiver = '" + username + "'";

		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				messages.add(new Message(rs.getInt("messageID"), rs
						.getInt("articleID"), rs.getString("author"), rs
						.getString("receiver"), rs.getString("topic"), rs
						.getString("message"), rs.getInt("isRead"), rs
						.getTimestamp("Date").toString()));
			}
			stmt.close();
			rs.close();
			dbc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return messages;
	}

	/* Helper mehtods */

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
	 * Überprüft ob der angegebene (String) Parameter definiert ist.
	 */
	public boolean attrSpecified(String str) {
		if (str == null || str.trim().equals(""))
			return false;
		else
			return true;
	}

	/**
	 * Nimmt eine Kommagetrennte Liste von Integers in Stringform entgegen und
	 * gibt sie als ArrayList<Integer> zurück.
	 */
	public ArrayList<Integer> parseForIds(String strIdList) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for (String strId : strIdList.split(",")) {
			int intId = Integer.parseInt(strId);
			if (intId != 0) {
				ids.add(intId);
			}
		}
		return ids;
	}

	/**
	 * Fetched die Article mit den übergebenen Ids und gibt sie als ArrayList
	 * von ArticleSearchResults zurück.
	 */
	public ArrayList<ArticleSearchResult> fetchArticles(ArrayList<Integer> ids)
			throws SQLException {
		// Fetched Offer Objekte für die Ids
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt;
		ArrayList<ArticleSearchResult> articles = new ArrayList<ArticleSearchResult>();
		for (int id : ids) {
			stmt = dbc.getStatement();
			query = "SELECT * FROM article WHERE id = '" + id + "'";
			ResultSet articleResultSet = stmt.executeQuery(query);
			;
			while (articleResultSet.next()) {
				articles.add(new ArticleSearchResult(articleResultSet
						.getString("title"), getUsername(articleResultSet
						.getInt("userid")), articleResultSet
						.getString("image1"), articleResultSet.getInt("id"),
						articleResultSet.getString("amount")));
			}
		}
		dbc.close();
		return articles;
	}

	public int saveRate(Rate rate) {
		DataBankerConnection dbc = new DataBankerConnection();
		try {
			PreparedStatement stmt = dbc
					.getConnection()
					.prepareStatement(
							"INSERT "
									+ "INTO rate (offerId, ratedUserName, ratingUserName, comment, stars) VALUES('"
									+ rate.getOfferId() + "','"
									+ rate.getRatedUser() + "','"
									+ rate.getRatingUser() + "','"
									+ rate.getComment() + "','"
									+ rate.getStars() + "')");
			stmt.executeUpdate();
			stmt.close();
			dbc.close();
			return 1;
		} catch (Exception e) {
			System.out.println("fehler DB dbq saveRate(Rate rate) " + e);
			return 0;
		}
	}

	public int getRate(String username) {
		DataBankerConnection dbc = new DataBankerConnection();
		try {
			Statement stmt = dbc.getStatement();
			query = "SELECT avg(stars) AS average FROM rate WHERE ratingUserName = '"
					+ username + "'";
			ResultSet rateResultSet = stmt.executeQuery(query);
			rateResultSet.next();
			int rateAverage = rateResultSet.getInt("average");
			stmt.close();
			dbc.close();

			return rateAverage;
		} catch (Exception e) {
			System.out.println("fehler db getRate(String username) " + e);
		}
		return 0;
	}

	public int getUnreaded(String username) {

		int anzahl = 0;
		DataBankerConnection dbc = new DataBankerConnection();
		System.out.println("USERNAME: " + username);
		try {
			Statement stmt = dbc.getStatement();
			query = "SELECT isRead FROM message WHERE receiver ='" + username
					+ "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (rs.getInt("isRead") == 0)
					anzahl++;
				System.out.println("FOUND ANZ: " + anzahl);
			}
			stmt.close();
			dbc.close();

			System.out.println("anzahl ungelesener:" + anzahl);
			return anzahl;
		} catch (Exception e) {
			System.out.println("fehler db getRate(String username) " + e);
		}
		return anzahl;
	}

}