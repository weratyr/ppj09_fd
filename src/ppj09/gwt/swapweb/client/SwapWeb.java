package ppj09.gwt.swapweb.client;

import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultListView;
import ppj09.gwt.swapweb.client.gui.ArticleView;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.UserForm;
import ppj09.gwt.swapweb.client.gui.UserRegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

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

	private Panel mainPanel;
	private Panel borderPanel;
	private TabPanel outerTabPanel;

	private Image image;
	private DisclosurePanel disclosurePanelMy;
	private DisclosurePanel disclosurePanelKate;
	private Tree categoryTree;
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

	private Panel navigationsContentPanel;
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

		/*
		 * Hauptfenster
		 */
		mainPanel = new Panel();
		mainPanel.setBorder(false);
		mainPanel.setPaddings(15);
		mainPanel.setLayout(new FitLayout());
		
		borderPanel = new Panel();
		borderPanel.setBorder(false);
		borderPanel.setPaddings(10);
		borderPanel.setAutoScroll(true);

		/*
		 * NORTH Header und äußeres TabPanel
		 */
		image = new Image();
		image.setUrl("http://www.renegade-station.de/swhead.jpg");

		Panel northOuterPanel = new Panel();
		northOuterPanel.add(image);
		northOuterPanel.setBorder(false);

		outerTabPanel = new TabPanel();
		outerTabPanel.setPaddings(10);
		new ArticleSearchForm(outerTabPanel);
		new LoginForm(outerTabPanel);
		new UserRegistrationForm(outerTabPanel);
		northOuterPanel.add(outerTabPanel);
		borderPanel.add(northOuterPanel, new BorderLayoutData(RegionPosition.NORTH));

		MultiFieldPanel southContainer = new MultiFieldPanel();
		southContainer.setBorder(false);
		southContainer.setPaddings(5, 0, 0, 0);

		/*
		 * CENTER contentPanel
		 */
		contentPanel = new Panel();
		contentPanel.setTitle("Inhaltspanel");
		contentPanel.setWidth("80%");

		// WEST
		Panel navigationPanel = new Panel();
		navigationPanel.setTitle("My Swapweb");
		navigationPanel.setWidth("98%");

		southContainer.addToRow(navigationPanel, 185);
		southContainer.add(contentPanel);

		borderPanel.add(southContainer);

		navigationsContentPanel = new Panel();
		navigationsContentPanel.setBorder(false);
		navigationPanel.add(navigationsContentPanel);

		// Mein SwapWeb
		disclosurePanelMy = new DisclosurePanel("Mein SwapWeb", false);
		navigationsContentPanel.add(disclosurePanelMy);
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

		testProfileFormHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		verticalPanel_1.add(testProfileFormHyperlink);
		testProfileFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userForm = new UserForm();
				contentPanel.clear();
				contentPanel.add(userForm);
				contentPanel.doLayout();
			}
		});
		testProfileFormHyperlink.setText("Profil bearbeiten");

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

		// Kategoriebaum

		disclosurePanelKate = new DisclosurePanel("Kategorien", false);
		navigationsContentPanel.add(disclosurePanelKate);
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

		disclosurePanel = new DisclosurePanel("Tests", false);
		navigationsContentPanel.add(disclosurePanel);

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
				articleView = new ArticleView(29);
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
				userView = new UserView(5);
				contentPanel.clear();
				contentPanel.add(userView);
				contentPanel.doLayout();
			}
		});
		testProfileHyperlink.setText("Testprofil");

		testArticleFormHyperlink = new Hyperlink("Artikel einstellen", false,
				"newHistoryToken");
		verticalPanel_2.add(testArticleFormHyperlink);
		testArticleFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				articleForm = new ArticleForm();
				contentPanel.clear();
				contentPanel.add(articleForm);
				contentPanel.doLayout();
			}
		});

		mainPanel.add(borderPanel);
		new Viewport(mainPanel);
	}

	public static Panel getContenPanel() {
		return contentPanel;
	}
}
