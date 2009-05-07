package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResult;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.ArticleView;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.MessageForm;
import ppj09.gwt.swapweb.client.gui.MessageView;
import ppj09.gwt.swapweb.client.gui.RegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserForm;
import ppj09.gwt.swapweb.client.gui.UserView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.TreeListener;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

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
	UserForm userForm;
	ArticleView articleView;
	ArticleForm articleForm;
	MessageForm messageForm;
	MessageView messageView;
	
	
	private DockPanel dockPanel;
	private Image image;
	private DisclosurePanel disclosurePanelMy;
	private DisclosurePanel disclosurePanelKate;
	private TreePanel treePanel;
	private TreeNode trndroot;
	private Tree tree;
	private TreeItem treeItem;
	private Label lblMy = new Label();
	private Label lblSearch = new Label();
	private HorizontalPanel horizontalPanel;
	private TextBox SearchtextBox;
	private Button SearchButton;

	
	
	
	/**
	 * Die EntryPoin Methode
	 */
	public void onModuleLoad() {
		
		rootPanel = RootPanel.get(); // Just the Root Panel
				
		
		
		 /**
		 * Hauptfenster mit DockPanel, Image, TabPanel
		 */
	    
		dockPanel = new DockPanel();
		rootPanel.add(dockPanel);
		
		horizontalPanel = new HorizontalPanel();
		dockPanel.add(horizontalPanel, DockPanel.NORTH);
		
		image = new Image("");
		horizontalPanel.add(image);
		
		/**
		 * Suche
		 */
	
		SearchtextBox = new TextBox();
		SearchButton = new Button("Suche");
		lblSearch.setPixelSize(300, 0);
		horizontalPanel.add(lblSearch);
		horizontalPanel.add(SearchtextBox);
		horizontalPanel.add(SearchButton);
		
		
		{
			TabPanel tabPanel = new TabPanel();
			dockPanel.add(tabPanel, DockPanel.CENTER);
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
			userForm=new UserForm();
			tabPanel.add(userForm, "User aendern", false);
			articleView = new ArticleView();
			tabPanel.add(articleView, "Artikel", false);
			articleForm = new ArticleForm();
			tabPanel.add(articleForm, "Artikel aendern", false);
			messageView = new MessageView();
			tabPanel.add(messageView, "Nachrichten anzeigen", false);
			messageForm = new MessageForm();
			tabPanel.add(messageForm, "Nachricht schreiben", false);



		}
			
		
		/**
		 * Mein SwapWeb
		 */
		
//		Hyperlink link0 = new Hyperlink("Mein Profil", "Login");
//	    Hyperlink link1 = new Hyperlink("Meine Artikel", "");
//	    Hyperlink link2 = new Hyperlink("Artikel einstellen", "");
//	    Hyperlink link3 = new Hyperlink("Bewertungen", "");
//	    Hyperlink link4 = new Hyperlink("Nachrichten", "");
//	    VerticalPanel panel = new VerticalPanel();
//	    panel.add(lblMy);
//	    panel.add(link0);
//	    panel.add(link1);
//	    panel.add(link2);
//	    panel.add(link3);
//	    panel.add(link4);
	    
		{
			VerticalPanel verticalPanel = new VerticalPanel();
			dockPanel.add(verticalPanel, DockPanel.WEST);
			verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
			verticalPanel.setSpacing(1);
			verticalPanel.setSize("140", "200");
			
			disclosurePanelMy = new DisclosurePanel("Mein SwapWeb", false);
			verticalPanel.add(disclosurePanelMy);
			disclosurePanelMy.setTitle("Mein SwapWeb");
//			disclosurePanelMy.setSize("0", "0");
//			disclosurePanelMy.add(panel);
			
			tree = new Tree();
			disclosurePanelMy.setContent(tree);
			
			treeItem = new TreeItem("Mein Profil");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			
			treeItem = new TreeItem("Mein Artikel");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			
			treeItem = new TreeItem("Artikel einstellen");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			
			treeItem = new TreeItem("Bewertungen");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			
			treeItem = new TreeItem("Nachrichten");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			
			/**
			 * Kategoriebaum
			 */
			
			disclosurePanelKate = new DisclosurePanel("Kategorien", false);
			verticalPanel.add(disclosurePanelKate);
			disclosurePanelKate.setTitle("Kategorien");
			
			tree = new Tree();
			disclosurePanelKate.setContent(tree);
			tree.setSize("0", "0");
			
			
			treeItem = new TreeItem("Auto");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			
			treeItem = new TreeItem("Motorrad");
			tree.addItem(treeItem);
			treeItem.setHeight("18");
			}	
	}
}
