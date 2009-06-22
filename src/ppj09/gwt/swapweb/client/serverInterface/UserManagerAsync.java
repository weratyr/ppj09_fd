/*
 * @(#)UserManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * UserManager Interface ist fuer den RPC des UserManagerImpl. Das Interface
 * enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface UserManagerAsync {
	public void loginRequest(String user, String pwHash, AsyncCallback<Boolean> callback);
	public void createUser(User newUser, AsyncCallback<Integer> callback);
	public void getSessionId(AsyncCallback<Integer> asyncCallback);
	public void checkUsername(String username, AsyncCallback<Boolean> callback);
	public void getUser(AsyncCallback<User> callback);
	public void getUser(String userid, AsyncCallback<User> callback);
	public void updateUser(User newUser, AsyncCallback<Integer> callback);
	public void checkPassword(String password, AsyncCallback<Boolean> callback);

}
