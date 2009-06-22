/*
 * @(#)Offer.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class Offer implements Serializable {
	//offerId ist eindeutig
	private int offerId;
	//speichert die Artikel Nummer der zu tauschenden Gegenstaende
	private int desiredArticleId;
	private String offeredArticleIds;
	private String offerComment;
	//enthaelt die Id des Status; abgelehnt, noch offen des Tausches
	private int swapStatus;
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setDesiredArticleId(int desiredArticleId) {
		this.desiredArticleId = desiredArticleId;
	}
	public int getDesiredArticleId() {
		return desiredArticleId;
	}
	public void setOfferedArticleIds(String offeredArticleIds) {
		this.offeredArticleIds = offeredArticleIds;
	}
	public String getOfferedArticleIds() {
		return offeredArticleIds;
	}
	public void setOfferComment(String offerComment) {
		this.offerComment = offerComment;
	}
	public String getOfferComment() {
		return offerComment;
	}
	public void setSwapStatus(int swapStatus) {
		this.swapStatus = swapStatus;
	}
	public int isSwapStatus() {
		return swapStatus;
	}
	
}
