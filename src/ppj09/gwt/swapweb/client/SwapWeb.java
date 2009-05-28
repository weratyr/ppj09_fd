package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.gui.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

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
	UserRegistrationForm registrationForm;

	private DockPanel dockPanel;
	private Image image;
	private DisclosurePanel disclosurePanelMy;
	private DisclosurePanel disclosurePanelKate;
	private Tree categoryTree;
	private TextBox SearchtextBox;
	private Button SearchButton;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel absolutePanel_1;
	private TreeItem autoTreeItem;
	private TreeItem computerTreeItem;
	private TreeItem gardenTreeItem;
	private VerticalPanel verticalPanel_1;
	private Hyperlink myProfileHyperlink;
	private Hyperlink myArticlesHyperlink;
	private Hyperlink insertArticleHyperlink;
	private Hyperlink myRatingsHyperlink;
	private Hyperlink myMessagesHyperlink;
	private HomeView homeView;
	private HelpView helpView;
	private VerticalPanel verticalPanel;
	private TabPanel tabPanel;
	private ArticleForm articleForm;
	private UserView userView;
	private ArticleSearchResultListView articleSearchResultView;
	private UserForm userForm;
	private ArticleView articleView;
	private Hyperlink testartikelHyperlink;
	private DisclosurePanel disclosurePanel;
	private VerticalPanel verticalPanel_2;
	private Hyperlink testProfileHyperlink;
	private Hyperlink testProfileFormHyperlink;
	private Hyperlink testArticleFormHyperlink;


	/**
	 * Die EntryPoin Methode
	 */
	public void onModuleLoad() {

		rootPanel = RootPanel.get();

		/**
		 * Hauptfenster mit DockPanel, Image, TabPanel
		 */

		dockPanel = new DockPanel();
		rootPanel.add(dockPanel);

		/**
		 * NORTH
		 */
		absolutePanel = new AbsolutePanel();
		dockPanel.add(absolutePanel, DockPanel.NORTH);
		absolutePanel.setHeight("100");
//
//		image = new Image();
//		absolutePanel.add(image);
//		image.setUrl("swapweb.tif");
//		image.setWidth("500,30");

		/**
		 * Suche
		 */

		SearchtextBox = new TextBox();
		absolutePanel.add(SearchtextBox, 538, 5);
		SearchButton = new Button("Suche");
		absolutePanel.add(SearchButton, 700, 5);
		SearchButton.setHeight("24");

		/**
		 * CENTER TabPanel
		 */

		{
			tabPanel = new TabPanel();
			dockPanel.add(tabPanel, DockPanel.CENTER);
			tabPanel.setSize("650px", "500px");

			homeView = new HomeView();
			tabPanel.add(homeView, "Home", false);

			articleSearchForm = new ArticleSearchForm();
			tabPanel.add(articleSearchForm, "Ich suche", false);

			tabPanel.selectTab(0);

			loginForm = new LoginForm();
			tabPanel.add(loginForm, "Login", false);

			registrationForm = new UserRegistrationForm();
			tabPanel.add(registrationForm, "Registrieren", false);

			helpView = new HelpView();
			tabPanel.add(helpView, "Hilfe", false);

			articleForm = new ArticleForm();
			articleSearchResultView = new ArticleSearchResultListView();
			articleView = new ArticleView();
			userView = new UserView();
			userForm = new UserForm();
		}

		/**
		 * WEST
		 */

		absolutePanel_1 = new AbsolutePanel();
		dockPanel.add(absolutePanel_1, DockPanel.WEST);

		verticalPanel = new VerticalPanel();
		absolutePanel_1.add(verticalPanel);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setSpacing(1);
		verticalPanel.setSize("150", "50");

		/**
		 * Mein SwapWeb
		 */

		{
			disclosurePanelMy = new DisclosurePanel("Mein SwapWeb", false);
			verticalPanel.add(disclosurePanelMy);
			disclosurePanelMy.setTitle("Mein SwapWeb");

			verticalPanel_1 = new VerticalPanel();
			disclosurePanelMy.setContent(verticalPanel_1);
			verticalPanel_1.setSize("140", "100");

			myProfileHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(myProfileHyperlink);
			myProfileHyperlink.setText("Mein Profil");

			myArticlesHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(myArticlesHyperlink);
			myArticlesHyperlink.setText("Meine Artikel");

			insertArticleHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(insertArticleHyperlink);
			insertArticleHyperlink.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if (!articleForm.isAttached())
						tabPanel.add(articleForm, "Artikel", false);
					else
						tabPanel.remove(articleForm);
				}

			});

			insertArticleHyperlink.setText("Artikel einstellen");

			myRatingsHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(myRatingsHyperlink);
			myRatingsHyperlink.setText("Meine Bewertungen");

			myMessagesHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(myMessagesHyperlink);
			myMessagesHyperlink.setText("Nachrichten");
		}

		/**
		 * Kategoriebaum
		 */

		{
			disclosurePanelKate = new DisclosurePanel("Kategorien", false);
			verticalPanel.add(disclosurePanelKate);
			disclosurePanelKate.setTitle("Kategorien");

			categoryTree = new Tree();
			disclosurePanelKate.setContent(categoryTree);

			autoTreeItem = new TreeItem("New item");
			categoryTree.addItem(autoTreeItem);
			autoTreeItem.setText("Auto");

			computerTreeItem = new TreeItem("New item");
			categoryTree.addItem(computerTreeItem);
			computerTreeItem.setText("Computer");

			gardenTreeItem = new TreeItem("New item");
			categoryTree.addItem(gardenTreeItem);
			gardenTreeItem.setText("Garten");

		}

		disclosurePanel = new DisclosurePanel("Tests", false);
		verticalPanel.add(disclosurePanel);

		verticalPanel_2 = new VerticalPanel();
		disclosurePanel.setContent(verticalPanel_2);
		verticalPanel_2.setSize("140", "50");
		Hyperlink SuchenTestHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_2.add(SuchenTestHyperlink);
		SuchenTestHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//addTestSearchResult();
			}
		});
		SuchenTestHyperlink.setText("Testsuche");
		testartikelHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_2.add(testartikelHyperlink);
		testartikelHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addTestArticle();
			}
		});
		testartikelHyperlink.setText("Testartikel");

		testProfileHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_2.add(testProfileHyperlink);
		testProfileHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addTestProfile();
			}
		});
		testProfileHyperlink.setText("Testprofil");
		
		testProfileFormHyperlink = new Hyperlink("New hyperlink", false, "newHistoryToken");
		verticalPanel_2.add(testProfileFormHyperlink);
		testProfileFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addTestProfileForm();
			}
		});
		testProfileFormHyperlink.setText("Testprofil \u00E4ndern");
		
		testArticleFormHyperlink = new Hyperlink("Artikel einstellen", false, "newHistoryToken");
		verticalPanel_2.add(testArticleFormHyperlink);
		testArticleFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addTestArticleForm();
			}
		});
		testProfileFormHyperlink.setText("Testprofil \u00E4ndern");

	}

	public void addTestArticle() {
		if (!articleView.isAttached()) {
			tabPanel.add(articleView, "Test Artikel", false);

		} else
			tabPanel.remove(articleView);
	}

	public void addTestProfile() {
		if (!userView.isAttached()) {
			tabPanel.add(userView, "Test Profil", false);

		} else
			tabPanel.remove(userView);
	}
	
	
	public void addTestProfileForm() {
		if (!userForm.isAttached()) {
			tabPanel.add(userForm, "Profil Šndern", false);

		} else
			tabPanel.remove(userForm);
	}
	
	
	public void addTestArticleForm() {
		if (!articleForm.isAttached()) {
			tabPanel.add(articleForm, "Neuer Artikel", false);

		} else
			tabPanel.remove(articleForm);
	}
}
