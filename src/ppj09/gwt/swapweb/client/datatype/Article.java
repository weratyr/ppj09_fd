/*
 * @(#)Article.java      			 20.04.09
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
public class Article implements Serializable {

	// Informationen ueber den Artikel
	protected int articleId;
	private int userId;
	private String title;
	private String location;
	private String zipCode;
	private ArrayList<String> pictureUrls;
	protected String condition;
	private String description;
	private String offerScope;
	// Auswahl der Kategorien zu dem der Artikel passen koennte
	protected ArrayList<Integer> categoryIds;
	// Versandtartsnummer und ein Kommentar
	protected String shippingMethods;
	private String shippingMethodComment;
	// Wunschgegenstandsnummer und ein moeglicher Kommentar
	private ArrayList<Integer> desiredItemsCategoryIds;
	private String desiredItemsComment;
	// Wenn ein Artikel im Tausch ist, aber noch offen ist
	private boolean inSwap; 
	
	
	
	/**
	 * Gibt die articleId zurueck
	 * 
	 * @return articleId
	 */
	public int getArticleId() {
		return articleId;
	}

	/**
	 * Setzt die articleId
	 */
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	/**
	 * Gibt den inSwap Wert zurueck
	 * 
	 * @return inSwap
	 */
	public boolean isInSwap() {
		return inSwap;
	}

	/**
	 * Setzt die inSwap
	 */
	public void setInSwap(boolean inSwap) {
		this.inSwap = inSwap;
	}

	/**
	 * Gibt den title zurueck
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setzt den title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gibt die articleId zurueck
	 * 
	 * @return articleId
	 */
	public int articleId() {
		return articleId;
	}

	/**
	 * Setzt die articleId
	 */
	public void articleId(int articleId) {
		this.articleId = articleId;
	}

	/**
	 * Gibt die userId zurueck
	 * 
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gibt die location zurueck
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Setzt die location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gibt den conditionCode zurueck
	 * 
	 * @return conditionCode
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Setzt den condition
	 */
	public void setCondition(String conditionCode) {
		this.condition = condition;
	}

	/**
	 * Gibt die description zurueck
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setzt die description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gibt die categoryId zurueck
	 * 
	 * @return categoryId
	 */
	public ArrayList<Integer> getCategoryId() {
		return categoryIds;
	}

	/**
	 * Setzt die categoryId
	 */
	public void setCategoryId(ArrayList<Integer> categoryId) {
		this.categoryIds = categoryId;
	}

	/**
	 * Gibt die shippingMethodId zurueck
	 * 
	 * @return shippingMethodId
	 */
	public String getShippingMethods() {
		return shippingMethods;
	}

	/**
	 * Setzt die shippingMethodId
	 */
	public void setShippingMethods(String shippingMethods) {
		this.shippingMethods = shippingMethods;
	}

	/**
	 * Gibt den shippingMethodComment zurueck
	 * 
	 * @return shippingMethodComment
	 */
	public String getShippingMethodComment() {
		return shippingMethodComment;
	}

	/**
	 * Setzt den shippingMethodComment
	 */
	public void setShippingMethodComment(String shippingMethodComment) {
		this.shippingMethodComment = shippingMethodComment;
	}

	/**
	 * Gibt die desiredItemsCategoryId zurueck
	 * 
	 * @return desirdItemsCategoryId
	 */
	public ArrayList<Integer> getDesiredItemsCategoryId() {
		return desiredItemsCategoryIds;
	}

	/**
	 * Setzt die desiredItemsCategoryId
	 */
	public void setDesiredItemsCategoryId(
			ArrayList<Integer> desiredItemsCategoryId) {
		this.desiredItemsCategoryIds = desiredItemsCategoryId;
	}

	/**
	 * Gibt den desirdItemsComment zurueck
	 * 
	 * @return desirdItemsComment
	 */
	public String getDesiredItemsComment() {
		return desiredItemsComment;
	}

	/**
	 * Setzt den desiredItemsComment
	 */
	public void setDesiredItemsComment(String desiredItemsComment) {
		this.desiredItemsComment = desiredItemsComment;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setOfferScope(String offerScope) {
		this.offerScope = offerScope;
	}

	public String getOfferScope() {
		return offerScope;
	}

}