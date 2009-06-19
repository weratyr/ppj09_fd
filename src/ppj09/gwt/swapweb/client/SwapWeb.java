package ppj09.gwt.swapweb.client;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.gui.AdvancedSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.UserForm;
import ppj09.gwt.swapweb.client.gui.UserRegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserView;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelper;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelperAsync;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

/**
 * Initialisiert das allgemeine Layout der Seite
 */
public class SwapWeb implements EntryPoint {
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
	private UserForm userForm;
	private Hyperlink testProfileFormHyperlink;
	private UserView myProfile;

	/**
	 * Die EntryPoin Methode
	 */
	public void onModuleLoad() {
		/*
		 * Hauptfenster
		 */
		
		CSS.swapStyleSheet("theme", "swapweb/js/ext/resources/css/xtheme-slate.css"); 
		
		mainPanel = new Panel();
		mainPanel.setBorder(false);
		mainPanel.setLayout(new FitLayout());

		outerPanel = new Panel();
		outerPanel.setBorder(false);
		outerPanel.setPaddings(10);
		outerPanel.setAutoScroll(true);

		/*
		 * NORTH Header und Šu§eres TabPanel
		 */
		image = new Image("http://www.renegade-station.de/swhead.jpg");
		tabPanel = getUpperTabPanel();

		Panel northOuterPanel = new Panel();
		northOuterPanel.setBorder(false);
		northOuterPanel.add(image);
		northOuterPanel.add(tabPanel);

		outerPanel.add(northOuterPanel, new BorderLayoutData(
				RegionPosition.NORTH));

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
		navigationsContentPanel.setId("navi-panel");

		// Mein SwapWeb
		meinSwapWeb = new DisclosurePanel("Mein SwapWeb", false);
		meinSwapWeb.setContent(getMySwapWebPanel());

		// Kategoriebaum
		kategorien = new DisclosurePanel("Kategorien", false);
		kategorien.setContent(getCategories());

		navigationsContentPanel.add(meinSwapWeb);
		navigationsContentPanel.add(kategorien);

		return navigationsContentPanel;
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
				articleForm = new ArticleForm();
				contentPanel.clear();
				contentPanel.add(articleForm);
				contentPanel.doLayout();
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

	private VerticalPanel getCategories() {
		final VerticalPanel verticalPanel = new VerticalPanel();

		// Erstellt die Kategorieliste aus der Datenbank
		GuiHelperAsync guiHelper = GWT.create(GuiHelper.class);
		guiHelper.getCategories(new AsyncCallback<ArrayList<String>>() {
			public void onFailure(Throwable caught) {
				System.out.println("Fehler: " + caught.getMessage());
			}

			public void onSuccess(ArrayList<String> results) {
				ArrayList<Hyperlink> categoryList = new ArrayList<Hyperlink>();
				for (int i = 0;i<results.size();i++){
					final Hyperlink categoryLink = new Hyperlink(results.get(i),null);
					categoryLink.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							// Setzt Links auf die Kategorien
							ArticleSearchQuery sq = new ArticleSearchQuery();
							sq.setSearchPhrase("WHERE category = '"+categoryLink.getText()+"'");
							
							final ExtElement element = Ext.get("navi-panel");  
			                element.mask("Lädt");  
							
							SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);
							searchHandler.search(sq, new AsyncCallback<ArrayList<SearchResult>>() {
								public void onFailure(Throwable caught) {
									System.out.println("Fehler:" + caught.getMessage());
								}
								public void onSuccess(ArrayList<SearchResult> results) {
									contentPanel.clear();
									final ExtElement element = Ext.get("navi-panel");  
					                element.unmask();  
									for (SearchResult r : results) {
										r.getView();
									}
								}
							});
						}
					});
					categoryList.add(categoryLink);
					verticalPanel.add(categoryList.get(i));
				}
			}

		});
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
