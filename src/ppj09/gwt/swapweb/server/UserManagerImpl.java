package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UserManagerImpl extends RemoteServiceServlet implements UserManager {
	/**
	 * Legt den neuen User über den DataBanker in der Datenbank ab
	 */
	public int createUser(User newUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Holt sich im Authentication Modul einen hash vom pw,
	 * und gleicht ihn dann mit dem (user,pw) Tupel in der DB ab.
	 */
	public int loginRequest(String user, String pwHash) {
		// TODO Auto-generated method stub
		return 0;
	}
}