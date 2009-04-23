package ppj09.gwt.swapweb.client.datatype;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und über
 * den DataBanker in die DB abgelegt wird.
 */
public class User {
	
	//eindeutige, unveränderliche user Identificationsnummer
	private int userId;
	//identification eines Users, Email und Passwort
	private String email;
	private String pwHash;

	//persönliche informationen des Users
	private String name;
	private String firstName;
	private int zipCode;
	private String city;
	private String street;
	private int houseNumber;

	/**
	 * Gib die userId zurück
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setzt die userId
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	/**
	 * Gibt den email zurück
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setzt den email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gibt den pw_hash zurück
	 * 
	 * @return pw_hash
	 */
	public String getPwHash() {
		return pwHash;
	}

	/**
	 * Setzt den pw_hash
	 */
	public void setPwHash(String pw_hash) {
		this.pwHash = pw_hash;
	}

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
	 * Gibt den firstName zurück
	 * 
	 * @return firstName
	 */
	public String getVorname() {
		return firstName;
	}

	/**
	 * Setzt den firstName
	 */
	public void setVorname(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gibt den zipCode zurück
	 * 
	 * @return zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * Setzt den zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gibt den city zurück
	 * 
	 * @return city
	 */
	public String getWohnort() {
		return city;
	}

	/**
	 * Setzt den city
	 */
	public void setWohnort(String city) {
		this.city = city;
	}

	/**
	 * Gibt den street zurück
	 * 
	 * @return street
	 */
	public String getStrasse() {
		return street;
	}

	/**
	 * Setzt den street
	 */
	public void setStrasse(String strasse) {
		this.street = strasse;
	}

	/**
	 * Gibt den houseNumber zurück
	 * 
	 * @return houseNumber
	 */
	public int getHausNummer() {
		return houseNumber;
	}

	/**
	 * Setzt den houseNumber
	 */
	public void setHausNummer(int houseNumber) {
		this.houseNumber = houseNumber;
	}

}
