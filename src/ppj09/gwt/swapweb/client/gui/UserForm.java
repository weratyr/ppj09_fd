package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Formularfelder und Submit
 * 
 */
public class UserForm extends Composite implements Form {
	private final UserManagerAsync userManager = GWT.create(UserManager.class);

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public UserForm() {
		// TODO Organisation in Panels
		final TextBox nameField = new TextBox();
		final TextBox vornameField = new TextBox();
		final TextBox emailField = new TextBox();
		final TextBox plzField = new TextBox();
		final TextBox wohnortField = new TextBox();
		final TextBox hausNummerField = new TextBox();
	}

	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet auf
	 * Rückmeldung
	 */
	public boolean submit() {
		if (Validation.validateRegisterForm(this)) {
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
		} else {
			// Hinweis auf Fehler im Formular
			return false;
		}
	}
}