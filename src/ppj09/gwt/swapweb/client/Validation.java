/*
 * @(#)UserManagerAsync.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.UserRegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserForm;

/**
 * Validiert Formularfelder vom - Register Formular - Login Formular auf der
 * Clientseite (ohne Kommunmikation zum Server).
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public abstract class Validation {
	/**
	 * Validiert die E-Mail Adresse, welche gleichzeitig auch den Benutzername
	 * darstellt.
	 */
	public boolean validateEmail(String email) {
		return true;
	}

	/**
	 * Validiert die Eingabefelder auf Richtigkeit anhand von reguaeren -
	 * Ausdruecken - Typabfrage (int?) Bei erfolgreicher Validierung wird true
	 * zurueckgegeben, bei Fehlern false und anhand eines Labels wird im
	 * Formular der Fehler beschrieben.
	 */
	public static boolean validateRegisterForm(UserRegistrationForm registrationForm) {
		return true;
	}

	public static boolean validateLoginForm(LoginForm loginForm) {
		// ruft nur validateEmail() auf
		return true;
	}

	public static boolean validateArticleForm(ArticleForm articleForm) {
		return true;
	}

	public static boolean validateArticleSearchForm(
			ArticleSearchForm articleSearchForm) {
		return true;
	}
}
