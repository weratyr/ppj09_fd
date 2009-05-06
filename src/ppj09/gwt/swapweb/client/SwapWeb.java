package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResult;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.RegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserForm;
import ppj09.gwt.swapweb.client.gui.UserView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * SwapWeb implementiert das EntryPoint Interface. Die erst zu ladene Methode
 * der Web Application ist die<code>onModuleLoad()</code>, in der das Layout
 * zusammen gefuegt wird.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class SwapWeb implements EntryPoint {
	/**
	 * Die Nachricht wird dem Benutzer angezeigt, falls der Server einen
	 * internen oder einen externen Fehler hat.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	RootPanel rootPanel;
	LoginForm loginForm;
	ArticleSearchForm articleSearchForm;
	RegistrationForm registrationForm;
	ArticleSearchResultView articleSearchResultView;
	UserView userView;
	/**
	 * Die EntryPoin Methode
	 */
	public void onModuleLoad() {
		
		rootPanel = RootPanel.get(); // Just the Root Panel
				
		
		/**
		 * Mein SwapWeb
		 */
		
		
		/**
		 * Kategoriebaum
		 */
	
		/**
		 * Suche
		 */
		
		/**
		 * Hauptfenster mit TabPanel
		 */
		{
			TabPanel tabPanel = new TabPanel();
			rootPanel.add(tabPanel);
			tabPanel.setSize("650px", "500px");
			articleSearchForm = new ArticleSearchForm();
			tabPanel.add(articleSearchForm, "Ich suche", false);
			tabPanel.selectTab(0);
			loginForm = new LoginForm();
			tabPanel.add(loginForm, "Login", false);
			registrationForm = new RegistrationForm();
			tabPanel.add(registrationForm, "Registrieren", false);
			articleSearchResultView = new ArticleSearchResultView();
			tabPanel.add(articleSearchResultView, "ArticleSearch", false);
			articleSearchResultView.setSearchQuery("Test");
			ArticleSearchResult result1 = new ArticleSearchResult();
			result1.setArticlename("Testartikel");
			result1.setUsername("Hans");
			result1.setShipping("Bla");
			articleSearchResultView.addSearchResult(result1);
			ArticleSearchResult result2 = new ArticleSearchResult();
			articleSearchResultView.addSearchResult(result2);
			userView = new UserView();
			tabPanel.add(userView, "User", false);
		}
						
			
	}
}
