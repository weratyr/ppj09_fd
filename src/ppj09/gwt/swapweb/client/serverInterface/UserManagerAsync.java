/*
 * @(#)UserManagerAsync.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * UserManagerAsync Interface fuer den RPC des UserManagerImpl. Das
 * Interface enthaelt die Methoden, die auf der Serverseite via
 * <b>AsyncCallback</b> aufgerufen werden.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface UserManagerAsync {
	public void loginRequest(String user, String pw, AsyncCallback<Integer> callback);
	public void createUser(User newUser, AsyncCallback<Integer> callback);
}
