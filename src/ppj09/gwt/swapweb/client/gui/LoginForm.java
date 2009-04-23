package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

/**
 * Formularfelder und Submit
 * 
 */
 public class LoginForm extends Composite implements Form {
	/**
	 * Create a remote service proxy to talk to the server-side userManager service.
	 */
	private final UserManagerAsync userManager = GWT.create(UserManager.class);
	
	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public LoginForm() {

	}

	/**
	 * Schickt die validierten Formulardaten an den ProfileManager, und wartet
	 * auf Rückmeldung
	 */
	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet
	 * auf Rückmeldung
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