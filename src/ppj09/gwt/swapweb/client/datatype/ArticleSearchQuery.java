/*
 * @(#)ArticleSearch.java          20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

/**
 * Enthält alle Daten einer Artikel Suche. Ein Großteil der Datenfelder werden
 * direkt von Article geerbt.
 * 
 * @author Christian, André, Michael
 * @version 0.1, 17.05.09
 */
public class ArticleSearchQuery extends Article implements SearchQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// primitive Suche
	private String searchPhrase;
	private String userNamePhrase;
	private String userIdPhrase;
	private String categoryPhrase;

	// erweiterte Suche
	private boolean picturesOnly;

	public ArticleSearchQuery() {

	}

	public String getUserName() {
		return userNamePhrase;
	}

	public void setUserName(String userName) {
		userNamePhrase = userName;
	}

	public String getSearchPhrase() {
		return searchPhrase;
	}

	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}

	public boolean isPicturesOnly() {
		return picturesOnly;
	}

	public void setPicturesOnly(boolean picturesOnly) {
		this.picturesOnly = picturesOnly;
	}

	public void setCategoryPhrase(String categoryPhrase) {
		this.categoryPhrase = categoryPhrase;
	}

	public String getCategoryPhrase() {
		return categoryPhrase;
	}

	public void setUserIdPhrase(String userIdPhrase) {
		this.userIdPhrase = userIdPhrase;
	}

	public String getUserIdPhrase() {
		return userIdPhrase;
	}

	/*
	 * Auf diese Weise würden die Parameter in eine universelle Form gebracht
	 * werden, die vom Databanker unabhängig vom Inhalt verarbeitet werden kann.
	 * 
	 * public ArrayList<Parameter> getParameters() { ArrayList<Parameter> params
	 * = new ArrayList<Parameter>(); params.add(new Parameter("searchPhrase",
	 * Operator.LIKE, searchPhrase)); params.add(new Parameter("pictureUrls",
	 * Operator.MIN_LENGTH, 1)); params.add(new Parameter("conditionCodes",
	 * Operator.HAS, conditionCodes)); params.add(new Parameter("categoryIds",
	 * Operator.HAS, categoryIds)); params.add(new
	 * Parameter("shippingMethodIds", Operator.HAS, shippingMethodIds)); return
	 * params; }
	 */

}