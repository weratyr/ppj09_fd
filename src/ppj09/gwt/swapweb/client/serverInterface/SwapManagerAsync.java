/*
 * @(#)SwapManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Rate;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * SwapManager Interface ist fuer den RPC des SwapManagerImpl. Das Interface
 * enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface SwapManagerAsync {

	public void rateSwap(Rate rate, AsyncCallback<String> callback);
}
