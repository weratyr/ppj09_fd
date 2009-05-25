/*
 * @(#)UserManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * UserManager Interface ist fuer den RPC des UserManagerImpl. Das Interface
 * enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */


public interface UserManager extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static UserManagerAsync instance;
		public static UserManagerAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(UserManager.class);
			}
			return instance;
		}
	}
	
	
	public int loginRequest(String user, String pwHash);
	public int createUser(User newUser);
}
