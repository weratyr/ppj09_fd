package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

/**
 * Formularfelder und Submit
 * 
 */
public class ArticleSearchForm extends Composite implements Form {

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rückmeldung
	 */
	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rückmeldung
	 */
	public boolean submit() {
		if (Validation.validateArticleSearchForm(this)) {
			// Sende Daten an Server
			return true;
		} else {
			// Hinweis auf Fehler
			return false;
		}
	}
}
