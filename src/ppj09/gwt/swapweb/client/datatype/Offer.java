/*
 * @(#)Offer.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 */
public class Offer implements Serializable {
	//offerId ist eindeutig
	private int offerId;
	//speichert die Artikel Nummer der zu tauschenden Gegenstaende
	private int offeredArticleId;
	private int desiredArticleId;
	//enthaelt die Id des Status; abgelehnt, noch offen des Tausches
	private boolean swapStatusId;
	
	
}
