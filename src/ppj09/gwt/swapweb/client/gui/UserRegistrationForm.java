/*
 * @(#)UserForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.TextField;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.form.Field;

/**
 * Formularfelder und Submit des Benutzers zur Registrierung. Implementiert das
 * Interface Form
 * 
 * @author Georg Ortwein
 * @author Projekt Team 4711
 * @version 0.2, 25.05.09
 */
public class UserRegistrationForm extends Composite implements Form {
	private final UserManagerAsync userManager = GWT.create(UserManager.class);
	private Label lblFirstName;
	private AbsolutePanel absolutePanel;
	private Label lblLastName;
	private Label lblZip_City;
	private Label lblStreet_Number;
	private TextField txtbxFirstName;
	private TextField txtbLastName;
	private TextField txtbZip;
	private TextField txtbCity;
	private TextField txtbStreet;
	private TextField txtbNumber;
	private Label lblUserName;
	private TextField txtbUsername;
	private TextField txtbEmail;
	private TextField txtbPassword;
	private TextField txtbPasswordRepeat;
	private Label lblPassword;
	private Label lblPasswordRepeat;
	private Label lblEmail;
	private Label lblEmailRepeat;
	private TextField txtbEmailRepeat;
	private VerticalPanel verticalPanel;
	private Label usernameFreeLabel;
	private Panel errorPanel;
	private Window window;
	private Button registration;

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public UserRegistrationForm() {

		{
			verticalPanel = new VerticalPanel();
			absolutePanel = new AbsolutePanel();
			verticalPanel.add(absolutePanel);
			initWidget(verticalPanel);
			absolutePanel.setSize("650", "325px");
			{
				lblFirstName = new Label("Vorname:");
				absolutePanel.add(lblFirstName, 33, 3);
				lblFirstName
						.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			}
			{
				lblLastName = new Label("Nachname:");
				absolutePanel.add(lblLastName, 23, 28);
			}
			{
				lblZip_City = new Label("PLZ/ Wohnort:");
				absolutePanel.add(lblZip_City, 5, 54);
			}
			{
				lblStreet_Number = new Label("Stra\u00DFe/ Nr:");
				absolutePanel.add(lblStreet_Number, 25, 80);
			}
			{
				txtbxFirstName = new TextField();
				txtbxFirstName.setAllowBlank(false);
				absolutePanel.add(txtbxFirstName, 94, 0);
			}
			{
				txtbLastName = new TextField();
				txtbLastName.setAllowBlank(false);
				absolutePanel.add(txtbLastName, 94, 26);
			}
			{
				txtbZip = new TextField();
				txtbZip.setAllowBlank(false);
				absolutePanel.add(txtbZip, 94, 52);
				txtbZip.setSize("50", "22");

			}
			{
				txtbCity = new TextField();
				txtbCity.setAllowBlank(false);
				absolutePanel.add(txtbCity, 147, 52);
				txtbCity.setSize("106", "22");

			}
			{
				txtbStreet = new TextField();
				txtbStreet.setAllowBlank(false);
				absolutePanel.add(txtbStreet, 94, 76);
				txtbStreet.setWidth("96");

			}
			{
				txtbNumber = new TextField();
				txtbNumber.setAllowBlank(false);
				absolutePanel.add(txtbNumber, 193, 76);
				txtbNumber.setWidth("60");

			}
			{
				lblUserName = new Label("Benutzername:");
				absolutePanel.add(lblUserName, 331, 3);
			}
			
			{
				txtbUsername = new TextField();
				txtbUsername.setAllowBlank(false);


				// überprüfen ob der Benutzername noch frei ist. Wenn nein,
				// setze "usernameFreeLabel".
				txtbUsername.addListener(new FieldListenerAdapter() {
					public void onBlur(Field field) {
						if (!usernameFree(txtbUsername.getText())) {
							usernameFreeLabel
									.setText("Benutzername schon vergeben");
						}
					}
				});
				absolutePanel.add(txtbUsername, 424, 0);
			}
			{
				txtbPassword = new TextField();
				txtbPassword.setAllowBlank(false);
				absolutePanel.add(txtbPassword, 424, 26);

			}
			{
				txtbPasswordRepeat = new TextField();
				txtbPasswordRepeat.setAllowBlank(false);
				absolutePanel.add(txtbPasswordRepeat, 424, 52);

			}
			{
				txtbEmail = new TextField();
				txtbEmail.setAllowBlank(false);
				absolutePanel.add(txtbEmail, 424, 78);

			}
			{
				lblPassword = new Label("Password:");
				absolutePanel.add(lblPassword, 358, 28);
			}
			{
				lblPasswordRepeat = new Label("Password Wiederholen:");
				absolutePanel.add(lblPasswordRepeat, 283, 54);
			}
			{
				lblEmail = new Label("E-Mail:");
				absolutePanel.add(lblEmail, 378, 81);
			}
			{
				lblEmailRepeat = new Label("E-Mail Wiederholen:");
				absolutePanel.add(lblEmailRepeat, 303, 107);
			}
			{
				txtbEmailRepeat = new TextField();
				txtbEmailRepeat.setAllowBlank(false);
				absolutePanel.add(txtbEmailRepeat, 424, 104);

			}
			{
				registration = new Button();
				absolutePanel.add(registration, 424, 159);
				registration.setText("Registrieren");
				registration.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						validate();
					}
				});
				registration.setSize("140", "25");
			}
			{
				usernameFreeLabel = new Label();
				absolutePanel.add(usernameFreeLabel, 579, 3);
			}

			errorPanel = new Panel();
			errorPanel.setAutoScroll(true);
			window = new Window();
		}

	}

	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet auf
	 * Rueckmeldung
	 */
	public boolean submit() {

		// Sende Daten an Server
		User newUser = null;
		userManager.createUser(newUser, new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				// :(
			}

			public void onSuccess(Integer serverMsg) {
				// :)
			}
		});
		return true;
	}

	
	
	/*
	 * Überprüft die Eingegebenen Daten. Fehlt ein oder mehrere Einträge, wird dies in einem 
	 * Popupfenster angezeigt.
	 */
	public void validate() {

		ArrayList<String> errorList = new ArrayList<String>();

		if (txtbxFirstName.getText().equals("")) {
			errorList.add("- Vorname eintragen");
		}
		if (txtbLastName.getText().equals("")) {
			errorList.add("- Nachname eintragen");
		}
		if (txtbZip.getText().equals("")) {
			errorList.add("- Postleitzahl eintragen");
		}
		if (txtbCity.getText().equals("")) {
			errorList.add("- Wohnort eintragen");
		}
		if (txtbStreet.getText().equals("")) {
			errorList.add("- Straße eintragen");
		}
		if (txtbNumber.getText().equals("")) {
			errorList.add("- Hausnummer eintragen");
		}
		if (txtbUsername.getText().equals("")) {
			errorList.add("- Benutzername eintragen");
		}
		if (txtbPassword.getText().equals("")) {
			errorList.add("- Passwort eintragen");
		}
		if (txtbPasswordRepeat.getText().equals("")) {
			errorList.add("- Passwort wiederholen");
		}
		
		//Prüfen ob Passwörter gleich sind
		if (!txtbPassword.getText().equals(txtbPasswordRepeat.getText()))
		{
			errorList.add("- Passwörter stimmen nicht überein");
		}
		if (txtbEmail.getText().equals("")) {
			errorList.add("- eMail eintragen");
		}
		if (txtbEmailRepeat.getText().equals("")) {
			errorList.add("- eMail wiederholen");
		}
		
		//Prüfen ob eMails gleich sind
		if (!txtbEmail.getText().equals(txtbEmailRepeat.getText()))
		{
			errorList.add("- eMail Adressen stimmen nicht überein");
		}
		
		if (errorList.size() != 0) {
			window.clear();
			window.setWidth(160);
			window.setHeight(150);
			window.add(errorPanel);
			window.setCloseAction(Window.CLOSE);
			window.setTitle("Fehler");
			window.setAutoScroll(true);
			for (int i = 0; i < errorList.size(); i++) {
				Label error = new Label();
				error.setText(errorList.get(i));
				window.add(error);
			}

			window.show();
		}
		
	}

	/*
	 * Methode um zu Überprüfen ob der Benutzername noch frei ist.
	 */
	public boolean usernameFree(String username) {
		return false;
	}
}