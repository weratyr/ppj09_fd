package ppj09.gwt.swapweb.client.datatype;

import java.util.ArrayList;

public class ArticleSearch implements SearchQuery {
	// primitive Suche
	private String searchPhrase;
	private ArrayList<Category> category;

	// erweiterte Suche in Bezug auf Tauscheigenschaften
	private int swapNumber;
	private String location;
	private ArrayList<Integer> conditionId;
	private ArrayList<Integer> shippingMethodId;
	private boolean picturesOnly;

	/**
	 * Gibt den searchPhrase zurück
	 * 
	 * @return searchPhrase
	 */
	public String getSearchPhrase() {
		return searchPhrase;
	}

	/**
	 * Setzt den searchPhrase
	 */
	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}

	/**
	 * Gibt den category zurück
	 * 
	 * @return category
	 */
	public ArrayList<Category> getCategory() {
		return category;
	}

	/**
	 * Setzt die category
	 */
	public void setCategory(ArrayList<Category> category) {
		this.category = category;
	}

	/**
	 * Gibt den swapNumber zurück
	 * 
	 * @return swapNumber
	 */
	public int getSwapNumber() {
		return swapNumber;
	}

	/**
	 * Setzt den swapNumber
	 */
	public void setSwapNumber(int swapNumber) {
		this.swapNumber = swapNumber;
	}

	/**
	 * Gibt den location zurück
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Setzt den location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gibt den conditionId zurück
	 * 
	 * @return conditionId
	 */
	public ArrayList<Integer> getConditionId() {
		return conditionId;
	}

	/**
	 * Setzt den conditionId
	 */
	public void setConditionId(ArrayList<Integer> conditionId) {
		this.conditionId = conditionId;
	}

	/**
	 * Gibt den shippingMethodId zurück
	 * 
	 * @return shippingMethodId
	 */
	public ArrayList<Integer> getShippingMethodId() {
		return shippingMethodId;
	}

	/**
	 * Setzt den shippingMethodId
	 */
	public void setShippingMethodId(ArrayList<Integer> shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	/**
	 * Gibt den picturesOnly zurück
	 * 
	 * @return picturesOnly
	 */
	public boolean isPicturesOnly() {
		return picturesOnly;
	}

	/**
	 * Setzt den picturesOnly
	 */
	public void setPicturesOnly(boolean picturesOnly) {
		this.picturesOnly = picturesOnly;
	}

}
