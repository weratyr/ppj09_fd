/*
 * @(#)User.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import java.util.Date;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * 
 * @author Christian Happ, Michael Lukaszczyk
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String street;
	private String houseNumber;
	private String zip;
	private String city;
	private String username;
	private String email;
	private String password;
	private String gender;
	private Date birthdate;
	private String job;
	private String hobbys;
	private String music;
	private String movie;
	private String iLike;
	private String iDontLike;
	private String aboutMe;
	private String icq;
	private String msn;
	private String yahoo;
	private String aim;
	private String jabber;
	private String homepage;
	private String image;

	/**
	 * @param firstName
	 *            the firstName to set
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the firstName textField
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param lastName
	 *            the firstName to set
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the lastName textField
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param street
	 *            the street to set
	 */

	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the firstName textField
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param houseNumber
	 *            the houseNumber to set
	 */

	public void setHouseNumber(String number) {
		this.houseNumber = number;
	}

	/**
	 * @return the houseNumber textField
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the zipCode textField
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the city textField
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param eMail
	 *            the eMail to set
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the eMail textField
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password textField
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the username textField
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the gender textField
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param birthdate
	 *            the birthdate to set
	 */
	public void setBirthdate(Date date) {
		this.birthdate = date;
	}

	/**
	 * @return the birthdate textField
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the job textField
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param hobbys
	 *            the hobbys to set
	 */
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}

	/**
	 * @return the hobby textArea
	 */
	public String getHobbys() {
		return hobbys;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(String music) {
		this.music = music;
	}

	/**
	 * @return the music textArea
	 */
	public String getMusic() {
		return music;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMovie(String movie) {
		this.movie = movie;
	}

	/**
	 * @return the movie textArea
	 */
	public String getMovie() {
		return movie;
	}

	/**
	 * @param ilike
	 *            the ilike to set
	 */
	public void setILike(String ilike) {
		this.iLike = ilike;
	}

	/**
	 * @return the ilike textArea
	 */
	public String getILike() {
		return iLike;
	}

	/**
	 * @param idontlike
	 *            the idontlike to set
	 */
	public void setIDontLike(String idontlike) {
		this.iDontLike = idontlike;
	}

	/**
	 * @return the idontlike textArea
	 */
	public String getIDontLike() {
		return iDontLike;
	}

	/**
	 * @param aboutme
	 *            the aboutme to set
	 */
	public void setAboutMe(String aboutme) {
		this.aboutMe = aboutme;
	}

	/**
	 * @return the aboutme textArea
	 */
	public String getAboutMe() {
		return aboutMe;
	}

	/**
	 * @param icq
	 *            the icq to set
	 */
	public void setIcq(String icq) {
		this.icq = icq;
	}

	/**
	 * @return the icq textArea
	 */
	public String getIcq() {
		return icq;
	}

	/**
	 * @param msn
	 *            the msn to set
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}

	/**
	 * @return the msn textArea
	 */
	public String getMsn() {
		return msn;
	}

	/**
	 * @param yahoo
	 *            the yahoo to set
	 */
	public void setYahoo(String yahoo) {
		this.yahoo = yahoo;
	}

	/**
	 * @return the yahoo textArea
	 */
	public String getYahoo() {
		return yahoo;
	}

	/**
	 * @param aim
	 *            the aim to set
	 */
	public void setAim(String aim) {
		this.aim = aim;
	}

	/**
	 * @return the aim textArea
	 */
	public String getAim() {
		return aim;
	}

	/**
	 * @param jabber
	 *            the jabber to set
	 */
	public void setJabber(String jabber) {
		this.jabber = jabber;;
	}

	/**
	 * @return the jabber textArea
	 */
	public String getJabber() {
		return jabber;
	}
	
	/**
	 * @param url
	 *            the homepage to set
	 */
	public void setHomepage(String url) {
		this.homepage = url;;
	}

	/**
	 * @return the homepage textArea
	 */
	public String getHomepage() {
		return homepage;
	}
	
	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;;
	}

	/**
	 * @return the homepage textArea
	 */
	public String getImage() {
		return image;
	}


}