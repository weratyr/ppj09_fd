package ppj09.gwt.swapweb.client.datatype;

import java.util.ArrayList;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und über
 * den DataBanker in die DB abgelegt wird.
 */
public class Article {

	// Informationen über den Artikel
	private int articleId;
	private int userId;
	private String title;
	private String location;
	private int conditionCode;
	private String description;
	// Auswahl der Kategorien zu dem der Artikel passen könnte
	private ArrayList<Integer> categoryId;
	// Versandtartsnummer und ein Kommentar
	private ArrayList<Integer> shippingMethodId;
	private String shippingMethodComment;
	// Wunschgegenstandsnummer und ein möglicher Kommentar
	private ArrayList<Integer> desiredItemsCategoryId;
	private String desiredItemsComment;

	/**
	 * Gibt den title zurück
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
	 * Gibt die articleId zurück
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
	 * Gibt die userId zurück
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
	 * Gibt die location zurück
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
	 * Gibt den conditionCode zurück
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
	 * Gibt die description zurück
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
	 * Gibt die categoryId zurück
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
	 * Gibt die shippingMethodId zurück
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
	 * Gibt den shippingMethodComment zurück
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
	 * Gibt die desiredItemsCategoryId zurück
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
	 * Gibt den desirdItemsComment zurück
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