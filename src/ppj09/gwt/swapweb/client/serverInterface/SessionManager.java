/*
 * @(#)SessionManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * SessionManager Interface ist fuer den RPC des SessionManagerImpl. Es erzeugt
 * eine Instance einer Session. Diese Instance ist eine eindeutige Session
 * Nummer.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */

@RemoteServiceRelativePath("SessionManager")
public interface SessionManager extends RemoteService {

	public void logout();
	
}
