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
 * @author Florian Liersch
 * @author Projekt Team 4711
 * @version 0.1, 19.05.09
 */
public class Rate {

	//Bewertungskommentar
	private String comment;
	//Anzahl der Sterne (1-5) 
	private int stars;
	
	//Nutzer-ID des Nutzers der bewertet werden soll -> wenn m�glich, notfalls auch ein User_objekt
	private String ratedUser;
	//Nutzer-ID des Nutzers der die Bewertung geschrieben hat -> wenn m�glich, notfalls auch ein User_objekt
	private String ratingUser;
	
	
	//hier muss ich auf fertigstellung von Datentyp SWAP warten. Auch muss ich wissen ob bzw. wie das
	//Datum des Tausches gespeichert werden soll
	
	/*
	//Datum an dem die Bewertung ertellt wurde
	private Date date;
	//Tauschnummer (Swap) der bewertet wurde
	private int swapnumber;
	*/
	
	/**
	 * Gibt den Bewertungskommentar
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * Setzt den Bewertungskommentar
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * Gibt die Anzahl der Sterne mit denen bewertet wurde
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}
	/**
	 * Setzt die Anzahl der Sterne mit denen bewertet werde soll
	 * @param stars the stars to set
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	//------------------------------------------------------------------
	//die folgenden Methoden sind wahrscheinlich überflüssig
	//------------------------------------------------------------------
	
	/**
	 * Gibt die User-Id des Benutzers der bewertet werden soll
	 * @return the ratedUser
	 */
	public String getRatedUser() {
		return ratedUser;
	}
	/**
	 * Setzt die User-Id des Nutzers der bewertet werden soll
	 * @param ratedUser the ratedUser to set
	 */
	public void setRatedUser(String ratedUser) {
		this.ratedUser = ratedUser;
	}
	/**
	 * Gibt die User-Id des Nutzers der die Bewertung geschrieben hat
	 * @return the ratingUser
	 */
	public String getRatingUser() {
		return ratingUser;
	}
	/**
	 * Setzt die User-Id des Nutzers der die Bewertung geschrieben hat
	 * @param ratingUser the ratingUser to set
	 */
	public void setRatingUser(String ratingUser) {
		this.ratingUser = ratingUser;
	}
}

