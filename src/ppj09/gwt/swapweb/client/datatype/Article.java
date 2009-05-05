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
 * @version %I%, %G%
 */
public class Article implements Serializable {

	// Informationen ueber den Artikel
	private int articleId;
	private int userId;
	private String title;
	private String location;
	private int conditionCode;
	private String description;
	// Auswahl der Kategorien zu dem der Artikel passen koennte
	private ArrayList<Integer> categoryId;
	// Versandtartsnummer und ein Kommentar
	private ArrayList<Integer> shippingMethodId;
	private String shippingMethodComment;
	// Wunschgegenstandsnummer und ein moeglicher Kommentar
	private ArrayList<Integer> desiredItemsCategoryId;
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
	public int getConditionCode() {
		return conditionCode;
	}

	/**
	 * Setzt den condition
	 */
	public void setConditionCode(int conditionCode) {
		this.conditionCode = conditionCode;
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
		return categoryId;
	}

	/**
	 * Setzt die categoryId
	 */
	public void setCategoryId(ArrayList<Integer> categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gibt die shippingMethodId zurueck
	 * 
	 * @return shippingMethodId
	 */
	public ArrayList<Integer> getShippingMethodId() {
		return shippingMethodId;
	}

	/**
	 * Setzt die shippingMethodId
	 */
	public void setShippingMethodId(ArrayList<Integer> shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
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
		return desiredItemsCategoryId;
	}

	/**
	 * Setzt die desiredItemsCategoryId
	 */
	public void setDesiredItemsCategoryId(
			ArrayList<Integer> desiredItemsCategoryId) {
		this.desiredItemsCategoryId = desiredItemsCategoryId;
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

}