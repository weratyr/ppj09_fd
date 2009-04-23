/**
 * Formularfelder und Submit
 */
package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;


/**
 * @author
 * 
 */
public class ArticleForm extends Composite implements Form {

	/**
	 * Create a remote service proxy to talk to the server-side ArticleManager service.
	 */
	private final ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);
	
	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public ArticleForm() {

	}

	/**
	 * Schickt die validierten Formulardaten an den Artikelmanager, und wartet
	 * auf Rückmeldung
	 */
	/**
	 * Schickt die validierten Formulardaten an den Artikelmanager, und wartet
	 * auf Rückmeldung
	 */
	public boolean submit() {
		if (Validation.validateArticleForm(this)) {
			// Sende Daten an Server
			Article newArticle = null;
			articleManager.createArticle(newArticle,
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
			// Hinweis auf Fehler
			return false;
		}
	}

}
