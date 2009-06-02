package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class UserManagerImpl extends RemoteServiceServlet implements UserManager {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DataBankerQueries db = new DataBankerQueries();
	SessionHandler sh = new SessionHandler();
	/**
	 * Stefan Elm
	 * Legt den neuen User über den DataBanker in der Datenbank ab
	 * 
	 * return = 0 -> FEHLER - User nicht angelegt
	 * return = 1 -> OK
	 */
	public int createUser(User newUser) {
		// TODO Auto-generated method stub		
		return db.createUser(newUser);
	}

	/**
	 * Stefan Elm
	 * Holt sich im Authentication Modul einen hash vom pw,
	 * und gleicht ihn dann mit dem (user,pw) Tupel in der DB ab.
	 * 
	 * return = 0 -> KOMBINATION user, pwHash nicht vorhanden - nicht angemeldet
	 * return = 1 -> OK - user erfolgreich angemeldet
	 */
	public boolean loginRequest(String user, String pwHash) {
		// TODO Auto-generated method stub
		boolean ex = db.loginRequest(user, pwHash);
		
		if(ex) {
			sh.setSession(user, this.getThreadLocalRequest());
		}
		
	    return ex;
	}
	
	/*
	 * return null -> Fehler beim Auslesen des Users
	 * return User -> erfolgreich ausgelesen
	 */
	public User getUserProfile(String userId) {
		
		return db.getUserProfile(userId);
	}

	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		return db.checkUsername(username);
	}

	public User getUser() {
		
		String user = sh.getSession(this.getThreadLocalRequest());
		
		if (user == null) {
			return null;
		} else {
			return db.getUserProfile(user);
		}
	}

	@Override
	public int updateUser(User newUser) {
		// TODO Auto-generated method stub
		String user = sh.getSession(this.getThreadLocalRequest());
		
		return db.updateUser(user, newUser);
	}
}