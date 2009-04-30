package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.LoginForm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SwapWeb implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	RootPanel rootPanel;
	LoginForm loginForm;
	ArticleSearchForm articleSearchForm;
	
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	// private final GreetingServiceAsync greetingService =
	// GWT.create(GreetingService.class);
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {		
		rootPanel = RootPanel.get(); //Just the Root Panel
		{
			TabPanel tabPanel = new TabPanel();
			rootPanel.add(tabPanel);
			tabPanel.setSize("550px", "500px");
			articleSearchForm = new ArticleSearchForm();
			tabPanel.add(articleSearchForm, "Ich suche", false);
			tabPanel.selectTab(0);
			loginForm = new LoginForm();
			tabPanel.add(loginForm, "Login", false);
			
			
		}
		
			
				
			
		
	
	}
}
