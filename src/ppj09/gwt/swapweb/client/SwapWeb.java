package ppj09.gwt.swapweb.client;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.gui.AdvancedSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultListView;
import ppj09.gwt.swapweb.client.gui.ArticleView;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.UserForm;
import ppj09.gwt.swapweb.client.gui.UserRegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserView;
import ppj09.gwt.swapweb.client.serverInterface.SwapManager;
import ppj09.gwt.swapweb.client.serverInterface.SwapManagerAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.BoxComponent;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.event.ContainerListenerAdapter;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

/**
 * Initialisiert das allgemeine Layout der Seite
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
	private Panel outerPanel;
	private TabPanel tabPanel;

	private Image image;
	private DisclosurePanel meinSwapWeb;
	private DisclosurePanel kategorien;
	private static Panel contentPanel;

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
	private DisclosurePanel tests;
	private Hyperlink testProfileHyperlink;
	private Hyperlink testProfileFormHyperlink;
	private Hyperlink testArticleFormHyperlink;
	private Hyperlink suchenTestHyperlink;
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
		mainPanel.setLayout(new FitLayout());

		outerPanel = new Panel();
		outerPanel.setBorder(false);
		outerPanel.setPaddings(10);
		outerPanel.setAutoScroll(true);

		/*
		 * NORTH Header und äußeres TabPanel
		 */
		image = new Image("http://www.renegade-station.de/swhead.jpg");
		tabPanel = getUpperTabPanel();
		
		Panel northOuterPanel = new Panel();
		northOuterPanel.setBorder(false);
		northOuterPanel.add(image);
		northOuterPanel.add(tabPanel);
		
		outerPanel.add(northOuterPanel, new BorderLayoutData(RegionPosition.NORTH));

		MultiFieldPanel southContainer = new MultiFieldPanel();
		southContainer.setBorder(false);
		southContainer.setPaddings(5, 0, 0, 0);

		/*
		 * CENTER contentPanel
		 */
		contentPanel = new Panel("Inhaltspanel");
		contentPanel.setWidth(700);
		contentPanel.setPaddings(10);

		Panel navigationPanel = new Panel("Navigation");
		navigationPanel.setWidth(181);
		navigationPanel.add(getNavigationPanel());
		
		// WEST
		southContainer.addToRow(navigationPanel, 185);
		southContainer.add(contentPanel);

		outerPanel.add(southContainer);

		mainPanel.add(outerPanel);
		new Viewport(mainPanel);
	}


	private Panel getNavigationPanel() {
		navigationsContentPanel = new Panel();
		navigationsContentPanel.setBorder(false);

		// Mein SwapWeb
		meinSwapWeb = new DisclosurePanel("Mein SwapWeb", false);
		meinSwapWeb.setContent(getMySwapWebPanel());

		// Kategoriebaum
		kategorien = new DisclosurePanel("Kategorien", false);
		kategorien.setContent(getTestPanel());

		// Test
		tests = new DisclosurePanel("Tests", false);
		tests.setContent(getTestPanel());

		navigationsContentPanel.add(meinSwapWeb);
		navigationsContentPanel.add(kategorien);
		navigationsContentPanel.add(tests);
		
		return navigationsContentPanel;
	}

	
	private VerticalPanel getTestPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSize("140", "50");

		suchenTestHyperlink = new Hyperlink("Testsuche", null);
		suchenTestHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				articleSearchResultView = new ArticleSearchResultListView();
				contentPanel.clear();
				contentPanel.add(articleSearchResultView);
				contentPanel.doLayout();
			}
		});


		testartikelHyperlink = new Hyperlink("Testartikel", null);
		testartikelHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				articleView = new ArticleView(30);
				contentPanel.clear();
				contentPanel.add(articleView);
				contentPanel.doLayout();
			}
		});


		testProfileHyperlink = new Hyperlink("Testprofil", null);
		testProfileHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userView = new UserView("Theonlybender");
				contentPanel.clear();
				contentPanel.add(userView);
				contentPanel.doLayout();
			}
		});

		testArticleFormHyperlink = new Hyperlink("Artikel einstellen", null);
		testArticleFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				articleForm = new ArticleForm();
				contentPanel.clear();
				contentPanel.add(articleForm);
				contentPanel.doLayout();
			}
		});

		verticalPanel.add(suchenTestHyperlink);
		verticalPanel.add(testartikelHyperlink);
		verticalPanel.add(testProfileHyperlink);
		verticalPanel.add(testArticleFormHyperlink);

		return verticalPanel;
	}

	private VerticalPanel getMySwapWebPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSize("140", "100");

		myProfileHyperlink = new Hyperlink("Mein Profil", null);
		myProfileHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				myProfile = new UserView();
				contentPanel.clear();
				contentPanel.add(myProfile);
				contentPanel.doLayout();
			}
		});

		testProfileFormHyperlink = new Hyperlink("Profil bearbeiten", null);
		testProfileFormHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userForm = new UserForm();
				contentPanel.clear();
				contentPanel.add(userForm);
				contentPanel.doLayout();
			}
		});

		myArticlesHyperlink = new Hyperlink("Meine Artikel", null);

		insertArticleHyperlink = new Hyperlink("Artikel einstellen", null);
		insertArticleHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				contentPanel.clear();
				contentPanel.add(articleForm);
			}

		});

		myRatingsHyperlink = new Hyperlink("Meine Bewertungen", null);
		myMessagesHyperlink = new Hyperlink("Nachrichten", null);

		verticalPanel.add(myProfileHyperlink);
		verticalPanel.add(testProfileFormHyperlink);
		verticalPanel.add(myArticlesHyperlink);
		verticalPanel.add(insertArticleHyperlink);
		verticalPanel.add(myRatingsHyperlink);
		verticalPanel.add(myMessagesHyperlink);

		return verticalPanel;
	}

	private TabPanel getUpperTabPanel() {
		tabPanel = new TabPanel();
		tabPanel.setPaddings(3);
		tabPanel.setWidth(885);
		new ArticleSearchForm(tabPanel);
		new AdvancedSearchForm(tabPanel);
		new LoginForm(tabPanel);
		new UserRegistrationForm(tabPanel);
		return tabPanel;
	}

	public static Panel getContentPanel() {
		return contentPanel;
	}
}
