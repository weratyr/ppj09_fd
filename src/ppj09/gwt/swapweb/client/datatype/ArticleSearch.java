/*
 * @(#)ArticleSearch.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;  
import java.util.HashMap;


/**
 * Enthaelt ein ArticleSearch Objekt einer Suchanfrage.
 * 
 * @author Christian Happ, André Wagner und NICHT Michael Lukaszczyk (dafür hat er nudeln gekocht)
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class ArticleSearch extends Article implements SearchQuery {
	// primitive Suche
	private String searchPhrase;

	// erweiterte Suche
	private boolean picturesOnly;

	public ArrayList<Parameter> getParameters() {
		ArrayList<Parameter> params = new ArrayList<Parameter>();
		params.add(new Parameter("searchPhrase", Operator.LIKE, searchPhrase));
		params.add(new Parameter("pictureUrls", Operator.MIN_LENGTH, 1));
		params.add(new Parameter("conditionCodes", Operator.HAS, conditionCodes));
		params.add(new Parameter("categoryIds", Operator.HAS, categoryIds));
		params.add(new Parameter("shippingMethodIds", Operator.HAS, shippingMethodIds));
		return params;
	}

	

}
