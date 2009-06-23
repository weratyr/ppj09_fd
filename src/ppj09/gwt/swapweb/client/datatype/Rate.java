/*
 * @(#)Rate.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * Der Datentyp enth�lt die Bewertung die ein Nutzer einem anderen gegeben hat.
 * 
 * @author Florian Liersch, Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 19.06.09
 */
public class Rate implements Serializable {

	//Bewertungskommentar
	private String comment;
	//Anzahl der Sterne (1-5) 
	private int stars;
	
	//Nutzer-ID des Nutzers der bewertet werden soll -> wenn m�glich, notfalls auch ein User_objekt
	private String ratedUser;
	//Nutzer-ID des Nutzers der die Bewertung geschrieben hat -> wenn m�glich, notfalls auch ein User_objekt
	private String ratingUser;
	
	
	
}

