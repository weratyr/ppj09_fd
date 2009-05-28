package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UserManagerImpl extends RemoteServiceServlet implements UserManager {
	
	DataBankerQueries db = new DataBankerQueries(); 
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
	public int loginRequest(String user, String pwHash) {
		// TODO Auto-generated method stub
	    
		return db.loginRequest(user, pwHash);
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
}