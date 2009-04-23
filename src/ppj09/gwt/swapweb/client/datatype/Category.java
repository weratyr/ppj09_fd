package ppj09.gwt.swapweb.client.datatype;

public class Category {
	//Kategoriename und die dazugehörige id
	private String name;
	private int id;

	/**
	 * Gibt den name zurück
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt den name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gibt den id zurück
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setzt den id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
