/*
 * @(#)UserForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

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
	private HorizontalPanel horizontalPanel;
	private FormPanel formPanel_1;
	private MultiFieldPanel namePanel, cityPanel;
	private NumberField txtbxZip;
	private TextField txtbxCity;
	private FormPanel formPanel;
	private TextField txtbxUserName;
	private TextField txtbxLastName;
	private TextField txtbxFirstName;

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public UserRegistrationForm() {
		{
			horizontalPanel = new HorizontalPanel();
			initWidget(horizontalPanel);
			{
				formPanel_1 = new FormPanel();

				txtbxFirstName = new TextField("Vor / Nachname", "text_field",
						110);

				txtbxLastName = new TextField("Nachname", "text_field", 110);
				txtbxLastName.setHideLabel(true);

				namePanel = new MultiFieldPanel();
				namePanel.addToRow(txtbxFirstName, 240);
				namePanel.addToRow(txtbxLastName, new ColumnLayoutData(1));
				namePanel.setBorder(false);
				formPanel_1.add(namePanel);

				txtbxZip = new NumberField("PLZ / Wohnort", "number_field", 60);
				txtbxZip.setAllowBlank(false);

				
				txtbxCity = new TextField("Wohnort", "text_field", 160);
				txtbxCity.setHideLabel(true);
				txtbxCity.setAllowBlank(false);

				
				cityPanel = new MultiFieldPanel();
				cityPanel.addToRow(txtbxZip, 190);
				cityPanel.addToRow(txtbxCity, new ColumnLayoutData(1));
				cityPanel.setBorder(false);
				formPanel_1.add(cityPanel);
				
				horizontalPanel.add(formPanel_1);
			}
			{
				formPanel = new FormPanel();
				{
					txtbxUserName = new TextField("Benutzername", "text_field",
							100);
					formPanel.add(txtbxUserName);
				}
				horizontalPanel.add(formPanel);
			}
		}

	}

	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet auf
	 * Rueckmeldung
	 */
	public boolean submit() {
		if (Validation.validateRegisterForm(this)) {

			// Sende Daten an Server
			User newUser = new User();
			userManager.createUser(newUser, new AsyncCallback<Integer>() {
				public void onFailure(Throwable caught) {
					// :(

				}

				public void onSuccess(Integer serverMsg) {
					// :)
				}
			});
		}
		return true;

	}

	/*
	 * Überprüft die Eingegebenen Daten. Fehlt ein oder mehrere Einträge, wird
	 * dies in einem Popupfenster angezeigt.
	 */
	// public void validate() {
	//
	// ArrayList<String> errorList = new ArrayList<String>();
	// errorList.clear();
	//
	// // Überprüfen ob die Felder leer sind.
	// if (txtbxFirstName.getText().equals("")) {
	// errorList.add("- Vorname eintragen");
	// }
	// if (txtbLastName.getText().equals("")) {
	// errorList.add("- Nachname eintragen");
	// }
	// if (txtbZip.getText().equals("")) {
	// errorList.add("- Postleitzahl eintragen");
	// }
	// if (txtbCity.getText().equals("")) {
	// errorList.add("- Wohnort eintragen");
	// }
	// if (txtbStreet.getText().equals("")) {
	// errorList.add("- Straße eintragen");
	// }
	// if (txtbNumber.getText().equals("")) {
	// errorList.add("- Hausnummer eintragen");
	// }
	// if (txtbUsername.getText().equals("")) {
	// errorList.add("- Benutzername eintragen");
	// }
	// if (txtbPassword.getText().equals("")) {
	// errorList.add("- Passwort eintragen");
	// }
	// if (txtbPasswordRepeat.getText().equals("")) {
	// errorList.add("- Passwort wiederholen");
	// }
	//
	// // Prüfen ob Passwörter gleich sind
	// if (!txtbPassword.getText().equals(txtbPasswordRepeat.getText())) {
	// errorList.add("- Passwörter stimmen nicht überein");
	// }
	// if (txtbEmail.getText().equals("")) {
	// errorList.add("- eMail eintragen");
	// }
	// if (txtbEmailRepeat.getText().equals("")) {
	// errorList.add("- eMail wiederholen");
	// }
	//
	// // Prüfen ob eMails gleich sind
	// if (!txtbEmail.getText().equals(txtbEmailRepeat.getText())) {
	// errorList.add("- eMail Adressen stimmen nicht überein");
	// }
	//
	// // Erzeuge Popup wenn ein Fehler vorliegt
	// if (errorList.size() != 0) {
	// window.destroy();
	// if (window.isAttached()) {
	// errorList.clear();
	// }
	// window.clear();
	// window.setWidth(160);
	// window.setHeight(150);
	// window.add(errorPanel);
	// window.setCloseAction(Window.CLOSE);
	// window.setTitle("Fehler");
	// window.setAutoScroll(true);
	// for (int i = 0; i < errorList.size(); i++) {
	// Label error = new Label();
	// error.setText(errorList.get(i));
	// errorPanel.add(error);
	// }
	// window.show();
	// }
	//
	// }
	/*
	 * Methode um zu Überprüfen ob der Benutzername noch frei ist.
	 */
	public boolean usernameFree(String username) {
		return false;
	}
}