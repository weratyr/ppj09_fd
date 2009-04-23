package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.UserForm;

/**
 * Validiert Formularfelder vom 
 * - Register Formular 
 * - Login Formular auf der
 * Clientseite (ohne Kommunmikation zum Server).
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
	 * Validiert die Eingabefelder auf Richtigkeit anhand von regulären
	 * - Ausdrücken 
	 * - Typabfrage (int?) 
	 * Bei erfolgreicher Validierung wird true
	 * zurückgegeben, bei Fehlern false und anhand eines Labels wird im Formular
	 * der Fehler beschrieben.
	 */
	public static boolean validateRegisterForm(UserForm registerForm) {
		return true;
	}

	public static boolean validateLoginForm(LoginForm loginForm) {
		// ruft nur validateEmail() auf
		return true;
	}

	public static boolean validateArticleForm(ArticleForm articleForm) {
		return true;
	}
	
	public static boolean validateArticleSearchForm(ArticleSearchForm articleSearchForm) {
		return true;
	}
}
