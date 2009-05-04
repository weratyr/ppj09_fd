/*
 * @(#)LoginForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.user.client.ui.FocusListenerAdapter;

/**
 * Formularfelder und Submit des Login. Der Benutzer hat die Mšglichkeit, seine
 * Logindaten einzugeben. Diese Klasse implementiert das Interface Form.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 */
public class LoginForm extends Composite implements Form {

	/*
	 * Erstellt ein remote service proxy, um mit dem UserManager der Serverseite
	 * zu kommunizieren.
	 */
	private final UserManagerAsync userManager = GWT.create(UserManager.class);

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public LoginForm() {

	}

	/**
	 * Schickt die validierten Formulardaten an den UserManager und wartet auf
	 * Rueckmeldung
	 */
	public boolean submit() {
		if (Validation.validateLoginForm(this)) {
			// Sende Daten an Server
			userManager.loginRequest("Test", "123",
					new AsyncCallback<Integer>() {
						public void onFailure(Throwable caught) {
							// :(
						}

						public void onSuccess(Integer serverMsg) {
							// :)
						}
					});
			return true;
		} else {
			// Hinweis auf Fehler im Formular
			return false;
		}
	}

}