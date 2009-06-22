package ppj09.gwt.swapweb.server;



import ppj09.gwt.swapweb.client.datatype.User;

import ppj09.gwt.swapweb.client.serverInterface.UserManager;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class UserManagerImpl extends RemoteServiceServlet implements		UserManager {

	private static final long serialVersionUID = 1L;

	DataBankerQueries db = new DataBankerQueries();
	SessionHandler sh = new SessionHandler();
	/**
	 * Stefan Elm Legt den neuen User über den DataBanker in der Datenbank ab
	 * 
	 * return = 0 -> FEHLER - User nicht angelegt return = 1 -> OK
	 */
	public int createUser(User newUser) {
		// TODO Auto-generated method stub
		return db.createUser(newUser);
	}
	/**
	 * Stefan Elm Holt sich im Authentication Modul einen hash vom pw, und
	 * gleicht ihn dann mit dem (user,pw) Tupel in der DB ab.
	 * 
	 * return = 0 -> KOMBINATION user, pwHash nicht vorhanden - nicht angemeldet
	 * return = 1 -> OK - user erfolgreich angemeldet
	 */
	public boolean loginRequest(String user, String pwHash) {
		// TODO Auto-generated method stub
		boolean ex = db.loginRequest(user, pwHash);
		if (ex) {
			sh.setSession(user, this.getThreadLocalRequest());
		}
		return ex;
	}
	/*
	 * return null -> Fehler beim Auslesen des Users return User -> erfolgreich
	 * ausgelesen
	 */
	public User getUserProfile(String userId) {
		return db.getUserProfile(userId);
	}

	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		return db.checkUsername(username);
	}

	public int getSessionId() {
		String user = sh.getSession(this.getThreadLocalRequest());
		if (user == null) {
			return 0;
		} else {
			return db.getUserId(user);
		}
	}
	
	public User getUser() {
		String user = sh.getSession(this.getThreadLocalRequest());
		if (user == null) {
			return null;
		} else {
			return db.getUserProfile(user);
		}
	}

	public User getUser(String username) {
		if (username == null) {
			return null;
		} else {
			return db.getUserProfile(username);
		}
	}

	public int updateUser(User newUser) {
		String user = sh.getSession(this.getThreadLocalRequest());
		return db.updateUser(user, newUser);
	}

	public boolean checkPassword(String password) {
		String user = sh.getSession(this.getThreadLocalRequest());
		boolean ex = db.loginRequest(user, password);
		return ex;
	}

}