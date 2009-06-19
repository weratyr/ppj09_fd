package ppj09.gwt.swapweb.server;

/*
 * Stefan Elm
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.Parameter;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;

public class DataBankerQueries {

	private String[] categories;

	public ArrayList<SearchResult> retriveArticles(
			ArrayList<Parameter> parameters) {
		return null;
	}

	public ArrayList<SearchResult> retriveUsers() {
		return null;

	}

	/*
	 * return = 0 -> FEHLER - User nicht angelegt return = 1 -> OK - User wurde
	 * angelegt return = 2 -> USER existiert schon
	 */
	public int createUser(User newUser) {
		// IN DATENBANK SPEICHERN
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
		} else {
			saved = 2;
		}

		return saved;
	}

	public int createArticle(Article newArticle, int user) {
		int saved = 0;

		String title = newArticle.getTitle();
		String category = newArticle.getCategory();
		String zipcode = newArticle.getZipCode();
		String city = newArticle.getLocation();
		String articlecondition = newArticle.getCondition();
		String shipping = newArticle.getShippingMethods();
		String amount = newArticle.getOfferScope();
		String swaps = newArticle.getDesiredItemsComment();
		String description = newArticle.getDescription();

		// Test output
		System.out.println(title);
		System.out.println(zipcode);
		System.out.println(city);
		System.out.println(articlecondition);
		System.out.println(shipping);
		System.out.println(amount);
		System.out.println(swaps);
		System.out.println(description);

		DataBankerConnection dbc = new DataBankerConnection();

		if (user != 0) { // User ist eingeloggt
			try {
				PreparedStatement stmt = dbc
						.getConnection()
						.prepareStatement(
								"INSERT INTO article(userid, title, zipcode, category, city, articlecondition, shipping, amount, swaps, description) VALUES(?,?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, Integer.toString(user));
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
	 * Vergleicht das angegebene Passwort mit dem aus dem Userprofil return 1
	 * wenn übereinstimmend, andernfalls return 0
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
	public String getUsername(int userid) {
		ResultSet rs = null;
		String username = null;

		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = "SELECT username FROM user WHERE id='" + userid + "'";
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
			rs.next();// Sollte nur eine Iteration durchlaufen
			System.out.println(rs.getString("username") + " username");
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

			rs.close();
			dbc.close();
			stmt.close();
			dbc.closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler databankerQueries: getUserProfil()");
			return null;
		}
		return user;
	}

	/*
	 * Aktualisiert das Userprofil
	 */
	public int updateUser(String userName, User updatedUser) {
		int saved = 0;
		String userID = updatedUser.getUsername();
		String pwd = updatedUser.getPassword();
		DataBankerConnection dbc = new DataBankerConnection();

		try {
			System.out.println("Mache Update");
			PreparedStatement stmt = dbc.getConnection().prepareStatement(
					"UPDATE user SET username=?,userob=? WHERE username = ?");
			stmt.setString(1, userID);
			stmt.setObject(2, (Object) updatedUser);
			stmt.setString(3, userName);
			stmt.executeUpdate();
			dbc.close();
			stmt.close();

			saved = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return saved;
	}

	public ArrayList<SearchResult> getArticleSearchResult(ArticleSearchQuery sq) {
		ArrayList<SearchResult> articleList = new ArrayList<SearchResult>();
		DataBankerConnection dbc = new DataBankerConnection();
		Statement stmt = dbc.getStatement();
		String query = null;
		if (sq.getUserName() != null) {
			int userid = getUserId(sq.getUserName());
			query = "SELECT * FROM article WHERE userid ='" + userid + "'";
		} else if (sq.getCategoryPhrase() != null) {
			query = "SELECT * FROM article WHERE category ='"
					+ sq.getCategoryPhrase() + "'";
		} else {
			query = "SELECT * FROM article WHERE title ='"
					+ sq.getSearchPhrase() + "'";
		}

		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				articleList.add(new ArticleSearchResult(resultSet
						.getString("title"), getUsername(resultSet
						.getInt("userid")), resultSet.getString("image1"),
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
}