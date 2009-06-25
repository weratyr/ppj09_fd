/*
 * @(#)Category.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * 
 * @author Christian Happ, Michael Lukaszczyk
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Kategoriename und die dazugehörige id
	private String name;
	private int id;

	/**
	 * Gibt den name zurueck
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
	 * Gibt den id zurueck
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
