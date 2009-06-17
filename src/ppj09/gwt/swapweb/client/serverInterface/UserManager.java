/*
 * @(#)UserManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.User;

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
@RemoteServiceRelativePath("UserManager")
public interface UserManager extends RemoteService {
	public boolean loginRequest(String user, String pwHash);
	public int createUser(User newUser);
	public boolean checkUsername(String username);
	public User getUser();
	public User getUser(String userid);
	public int updateUser(User newUser);
	public boolean checkPassword(String password);

}
