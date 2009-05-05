/*
 * @(#)SessionManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * SessionManager Interface ist fuer den RPC des SessionManagerImpl. Es erzeugt
 * eine Instance einer Session. Diese Instance ist eine eindeutige Session
 * Nummer.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface SessionManager extends RemoteService {

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SessionManagerAsync instance;

		public static SessionManagerAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(SessionManager.class);
			}
			return instance;
		}
	}
}
