package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.*;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;

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
	private HorizontalPanel HeaderPanel;
	private static Panel contentPanel;
	private TreeItem autoTreeItem;
	private TreeItem computerTreeItem;
	private TreeItem gardenTreeItem;
	private VerticalPanel verticalPanel_1;
	private Hyperlink myProfileHyperlink;
	private Hyperlink myArticlesHyperlink;
	private Hyperlink insertArticleHyperlink;
	private Hyperlink myRatingsHyperlink;
	private Hyperlink myMessagesHyperlink;
	
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
	private UserView myProfile;


	/**
	 * Die EntryPoin Methode
	 */
	public void onModuleLoad() {

		rootPanel = RootPanel.get();

		/*
		 * Hauptfenster mit DockPanel, Image, TabPanel
		 */

		dockPanel = new DockPanel();
		dockPanel.setSize("100%", "100%");
		dockPanel.setSpacing(5);
		// dockPanel.setBorderWidth(2);
		rootPanel.add(dockPanel);

		/*
		 * NORTH
		 */
		HeaderPanel = new HorizontalPanel();
		dockPanel.add(HeaderPanel, DockPanel.NORTH);
		dockPanel.setCellHeight(HeaderPanel, "85");
		image = new Image();
		HeaderPanel.add(image);
		image.setUrl("http://www.renegade-station.de/swhead.jpg");

		VerticalPanel nordTabPanel = new VerticalPanel();
		nordTabPanel.setWidth("100%");
		dockPanel.add(nordTabPanel, DockPanel.NORTH);

		
		TabPanel outerTabPanel = new TabPanel();
		outerTabPanel.setHeight("100%");
		
		articleSearchForm = new ArticleSearchForm(outerTabPanel);
		

		loginForm = new LoginForm(outerTabPanel);
		

		registrationForm = new UserRegistrationForm(outerTabPanel);
		//tabPanel.add(registrationForm, "Registrieren", false);
		/*
		helpView = new HelpView();
		tabPanel.add(helpView, "Hilfe", false);*/
		
		
		nordTabPanel.add(outerTabPanel);

		/*
		 * CENTER contentPanel
		 */
		contentPanel = new Panel();
		contentPanel.setPaddings(10);
		contentPanel.setTitle("Inhaltspanel");
		contentPanel.setCollapsible(true);
		dockPanel.add(contentPanel, DockPanel.CENTER);
		dockPanel.setCellHeight(contentPanel, "100%");

		/*
		 * WEST
		 */

		Panel navigationPanel = new Panel();
		navigationPanel.setTitle("My Swapweb");
		navigationPanel.setPaddings(10);
		
		dockPanel.add(navigationPanel, DockPanel.WEST);
		dockPanel.setCellWidth(navigationPanel, "180");

		verticalPanel = new VerticalPanel();
		navigationPanel.add(verticalPanel);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setSpacing(1);
		navigationPanel.doLayout();
		/*
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
			myProfileHyperlink.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					myProfile = new UserView();			
					contentPanel.clear();
					contentPanel.add(myProfile);
					contentPanel.doLayout();
				}

			});

			myArticlesHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(myArticlesHyperlink);
			myArticlesHyperlink.setText("Meine Artikel");

			insertArticleHyperlink = new Hyperlink("New hyperlink", false,
					"newHistoryToken");
			verticalPanel_1.add(insertArticleHyperlink);
			insertArticleHyperlink.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
						contentPanel.clear();
						contentPanel.add(articleForm);
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

		/*
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
				articleSearchResultView = new ArticleSearchResultListView();
				contentPanel.clear();
				contentPanel.add(articleSearchResultView);
				contentPanel.doLayout();
			}
		});
		SuchenTestHyperlink.setText("Testsuche");
		testartikelHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_2.add(testartikelHyperlink);
		testartikelHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				articleView = new ArticleView();
				contentPanel.clear();
				contentPanel.add(articleView);
				contentPanel.doLayout();
			}
		});
		testartikelHyperlink.setText("Testartikel");

		testProfileHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_2.add(testProfileHyperlink);
		testProfileHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userView = new UserView("georg");
				contentPanel.clear();
				contentPanel.add(userView);
				contentPanel.doLayout();
				}
		});
		testProfileHyperlink.setText("Testprofil");

		testProfileFormHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_2.add(testProfileFormHyperlink);
		testProfileFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userForm = new UserForm();			
				contentPanel.clear();
				contentPanel.add(userForm);
				contentPanel.doLayout();
				}
		});
		testProfileFormHyperlink.setText("Testprofil \u00E4ndern");

		testArticleFormHyperlink = new Hyperlink("Artikel einstellen", false,
				"newHistoryToken");
		verticalPanel_2.add(testArticleFormHyperlink);
		testArticleFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				articleForm = new ArticleForm();
				contentPanel.clear();
				contentPanel.add(articleForm);			
				}
		});
	}

	public static Panel getContenPanel() {
		// TODO Auto-generated method stub
		return contentPanel;
	}
}
