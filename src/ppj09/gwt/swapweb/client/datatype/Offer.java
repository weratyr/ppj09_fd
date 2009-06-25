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
 * @author Christian Happ, Michael
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class Offer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// offerId ist eindeutig
	private int offerId;
	// speichert die Artikel Nummer der zu tauschenden Gegenstaende
	private int desiredArticleId;
	private String offeredArticleIds;
	private String shippingMethod;

	private ArrayList<SearchResult> offeredArticles;
	private String offerComment;
	// enthaelt die Id des Status; abgelehnt, noch offen des Tausches
	private int swapStatus;

	public Offer(int desiredArticleId, String offeredArticleIds, String offerComment, int swapStatus, String shippingMethod) {
		this.desiredArticleId = desiredArticleId;
		this.offeredArticleIds = offeredArticleIds;
		this.offerComment = offerComment;
		this.setSwapStatus(swapStatus);
		this.shippingMethod = shippingMethod;
	}

	public Offer() {
	}
	
	public ArrayList<SearchResult> getOfferedArticles() {
		return offeredArticles;
	}

	public void setOfferedArticles(ArrayList<SearchResult> offeredArticles) {
		this.offeredArticles = offeredArticles;
	}

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

	public int getSwapStatus() {
		return swapStatus;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

}
