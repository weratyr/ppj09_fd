package ppj09.gwt.swapweb.client;

/*
 * TODO:
 * - erfolgreichen Login irgendwie kennzeichnen
 *     - eingeloggten User anzeigen
 *     - logout Möglichkeit
 * - Nachrichtensystem
 *     - User-User Nachrichten
 *     - Benachrichtigung bei
 *         - neuen/angenommenen/abgelehnten Angeboten
 *         - erfolgreiche Registrierung
 * - Bewertungssystem
 *     - Bewertung von abgeschlossenen Transaktionen
 * - Ansichten
 *     - Meine Artikel
 *     - Artikel bearbeiten
 *     - Artikel thumbnails
 * - Swap
 */

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.gui.AdvancedSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchForm;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.HelpView;
import ppj09.gwt.swapweb.client.gui.LoginForm;
import ppj09.gwt.swapweb.client.gui.MailboxView;
import ppj09.gwt.swapweb.client.gui.UserForm;
import ppj09.gwt.swapweb.client.gui.UserRegistrationForm;
import ppj09.gwt.swapweb.client.gui.UserSearchForm;
import ppj09.gwt.swapweb.client.gui.UserView;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelper;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelperAsync;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.SessionManager;
import ppj09.gwt.swapweb.client.serverInterface.SessionManagerAsync;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.TextArea;
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;

/**
 * Initialisiert das allgemeine Layout der Seite
 */
public class SwapWeb implements EntryPoint {
	private final UserManagerAsync userManager = GWT.create(UserManager.class);
	private User user;
	private Panel mainPanel;
	private Panel outerPanel;

	private static TabPanel tabPanel;

	private Image image;
	private static DisclosurePanel meinSwapWeb;
	private static DisclosurePanel kategorien;
	private static Panel contentPanel;

	private Hyperlink myProfileHyperlink;
	private Hyperlink myArticlesHyperlink;
	private Hyperlink insertArticleHyperlink;
	private Hyperlink myRatingsHyperlink;
	private Hyperlink myMessagesHyperlink;

	private Panel navigationsContentPanel;
	private static Panel navigationPanel;
	private ArticleForm articleForm;
	private UserForm userForm;
	private Hyperlink testProfileFormHyperlink;
	private UserView myProfile;
	private DisclosurePanel hilfe;
	private static VerticalPanel verticalPanel;
	private static Panel loggedInPanel2;
	private static AbsolutePanel abPanel;
	private static Hyperlink abmeldenHyperlink;
	private static Label angemeldetAlsLabel2;

	private static HorizontalPanel loggedInPanel;
	private static String userNameFromSession;

	/**
	 * Die EntryPoint Methode
	 */
	public void onModuleLoad() {
		/*
		 * Hauptfenster
		 */
		CSS.swapStyleSheet("theme",
				"swapweb/js/ext/resources/css/xtheme-slate.css");

		userManager.getUser(new AsyncCallback<User>() {
			public void onFailure(Throwable caught) {
				user = null;
			}

			public void onSuccess(User result) {
				user = result;
			}
		});

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

		// eingellogt als
		image = new Image("http://www.renegade-station.de/swhead.jpg");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getContentPanel().clear();
				getContentPanel().setTitle("Startseite");
			}
		});
		tabPanel = getUpperTabPanel();

		loggedInPanel = new HorizontalPanel();
		loggedInPanel2 = new Panel();
		loggedInPanel2.setBorder(false);

		// loggedInPanel.setBorder(false);
	

		abmeldenHyperlink = new Hyperlink("abmelden", null);

		abmeldenHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("logout test client seite");

				SessionManagerAsync sessionManager = GWT
						.create(SessionManager.class);

				sessionManager.logout(new AsyncCallback<Void>() {
					public void onFailure(Throwable caught) {
						// :(
						System.out.println("fehler: logout() :"
								+ caught.getMessage());
					}

					public void onSuccess(Void result) {
						// :)
						loggedInPanel.setVisible(false);
				
						new LoginForm(getTabPanel());
						new UserRegistrationForm(getTabPanel());
						toggleMeinSwapWeb();

					}
				});
			}
		});
		loggedInPanel.add(loggedInPanel2);
		loggedInPanel.add(abmeldenHyperlink);

		angemeldetAlsLabel2 = new Label("]");
		loggedInPanel.add(angemeldetAlsLabel2);

		loggedInPanel.setVisible(false);


		MultiFieldPanel northContainer = new MultiFieldPanel();
		northContainer.setBorder(false);
		northContainer.add(image);

		abPanel = new AbsolutePanel();
		abPanel.setSize("600", "80");
		abPanel.add(loggedInPanel, 320, 0);
		northContainer.add(abPanel);
		
		Panel northOuterPanel = new Panel();
		northOuterPanel.setBorder(false);
		northOuterPanel.add(northContainer);
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
		
		Panel startMessage = new Panel();
		startMessage.setBorder(false);
		startMessage.setHtml("<b>Wilkommen bei SwapWeb</b></br></br> Bei SwapWeb wird alles getauscht, was nützlich ist und einen neuen Besitzer sucht. Waren jeder Art, egal ob Kleinigkeiten oder Dinge mit großem Wert. In unserer Tauschbörse das ein oder andere Schnäppchen machen. Stöbere in Ruhe in den  Rubriken. Finde heraus, was hier schon alles zum Tausch angeboten wird. SwapWeb ist nicht nur etwas für Flohmarkt-Fans oder Sammler. Hier findet man auch hochwertige Waren! Es ist nichts besonderes, hier im SwapWeb auch Autos, Häuser oder Grundstücke zu finden. Fast alles ist erlaubt! Solange es legal ist und nicht gegen gute Sitten verstößt.Die Teilnahme ist kostenlos. Es gibt definitiv keine versteckten Kosten. Hier wird also niemand zur Kasse gebeten. Man kann sich kostenlos anmelden, kostenlos Bilder hochladen und kostenlos Inserate schalten.");
		contentPanel.add(startMessage);
		contentPanel.setTitle("Start Seite");
		
		navigationPanel = new Panel("Navigation");
		navigationPanel.setWidth(181);

		navigationPanel.add(createNavigationPanel());

		// WEST
		southContainer.addToRow(navigationPanel, 185);
		southContainer.add(contentPanel);

		outerPanel.add(southContainer);

		mainPanel.add(outerPanel);
		new Viewport(mainPanel);
	}

	private Panel createNavigationPanel() {
		navigationsContentPanel = new Panel();
		navigationsContentPanel.setBorder(false);
		navigationsContentPanel.setId("navi-panel");

		verticalPanel = new VerticalPanel();
		
		// Mein SwapWeb
		meinSwapWeb = new DisclosurePanel("Mein SwapWeb", false);
		meinSwapWeb.setContent(getMySwapWebPanel());

		
		// Kategoriebaum
		kategorien = new DisclosurePanel("Kategorien", false);
		kategorien.setContent(getCategories());
		
		//navigationsContentPanel.add(kategorien);
		verticalPanel.add(kategorien);
		
		// Hilfe
		hilfe = new DisclosurePanel("Hilfe", false);
		hilfe.add(new HelpView());
		verticalPanel.add(hilfe);
		
		
		navigationsContentPanel.add(verticalPanel);
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
		myMessagesHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				contentPanel.add(new MailboxView());
			}

		});

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

			public void onSuccess(final ArrayList<String> results) {
				ArrayList<Hyperlink> categoryList = new ArrayList<Hyperlink>();
				for (int i = 0; i < results.size(); i++) {
					final Hyperlink categoryLink = new Hyperlink(
							results.get(i), null);
					categoryLink.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							// Setzt Links auf die Kategorien
							ArticleSearchQuery sq = new ArticleSearchQuery();
							sq.setCategoryPhrase(categoryLink.getText());

							final ExtElement element = Ext.get("navi-panel");
							element.mask("Lädt");

							SearchHandlerAsync searchHandler = GWT
							.create(SearchHandler.class);
							searchHandler
							.search(
									sq,
									new AsyncCallback<ArrayList<SearchResult>>() {
										public void onFailure(
												Throwable caught) {
											System.out
											.println("Fehler: SwapWeb.java "
													+ caught
													.getMessage());
										}

										public void onSuccess(
												ArrayList<SearchResult> results) {
											element.unmask();
											SwapWeb.getContentPanel()
											.clear();
											Panel listView = new Panel();

											for (SearchResult r : results) {
												listView
												.add((ArticleSearchResultView) r
														.getView());
											}

											SwapWeb.getContentPanel()
											.add(listView);
											SwapWeb.getContentPanel()
											.doLayout();
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
		new UserSearchForm(tabPanel);
		new LoginForm(tabPanel);
		new UserRegistrationForm(tabPanel);

		return tabPanel;
	}

	public static TabPanel getTabPanel() {
		return tabPanel;
	}

	public static Panel getContentPanel() {
		return contentPanel;
	}

	public static void toggleMeinSwapWeb() {
		if (!meinSwapWeb.isAttached()) {
			verticalPanel.insert(meinSwapWeb,0);
			// navigationsContentPanel.add(meinSwapWeb);
		} else {
			verticalPanel.remove(meinSwapWeb);
		}
		meinSwapWeb.setOpen(true);
		navigationPanel.doLayout();
	}

	public static void setLoggedin(String username) {
		loggedInPanel.setVisible(true);
		loggedInPanel2
				.setHtml("Sie sind angemeldet als <b>"
						+ username
						+"</b> ["
						);
	}

	public static void getCategories(final Panel container,
			final ComboBox categoryComboBox) {
		GuiHelperAsync guiHelper = GWT.create(GuiHelper.class);
		guiHelper.getCategories(new AsyncCallback<ArrayList<String>>() {
			public void onFailure(Throwable caught) {
				System.out.println("Fehler: " + caught.getMessage());
			}

			public void onSuccess(ArrayList<String> results) {
				Store quickCategoryStore = new SimpleStore("category", results
						.toArray());
				quickCategoryStore.load();
				categoryComboBox.setStore(quickCategoryStore);
				categoryComboBox.setDisplayField("category");
				categoryComboBox.setMode(ComboBox.LOCAL);
				categoryComboBox.setTriggerAction(ComboBox.ALL);
				categoryComboBox.setForceSelection(true);
				categoryComboBox.setReadOnly(true);
				categoryComboBox.setWidth(120);
				categoryComboBox.setEmptyText("Kategorie wählen");
				container.add(categoryComboBox);
				container.doLayout();
			}
		});
	}

	public static String getUserNameFromSession() {
		return userNameFromSession;
	}

	public static void setUserNameFromSession(String userNameFromSession) {
		SwapWeb.userNameFromSession = userNameFromSession;
	}
	
	public static HorizontalPanel getVorliegendeAngebotePanel(int articleId) {
		final HorizontalPanel offeredArticles = new HorizontalPanel();
		SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);
		searchHandler.getOfferedArticles(articleId, new AsyncCallback<ArrayList<SearchResult>>() {
			public void onFailure(Throwable e) {
				e.printStackTrace();
			}
			public void onSuccess(ArrayList<SearchResult> results) {
				System.out.println("Anzahl results: " + results.size());
				for (SearchResult r : results) {
					offeredArticles.add((Widget) r.getView());
				}
			}
		});
		return offeredArticles;
	}
	
	public static void getVorliegendeAngebotePanel(final Label title, final Panel outerPanel, int articleId) {
		final VerticalPanel offeredArticles = new VerticalPanel();

		SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);
		searchHandler.getOfferedArticles(articleId, new AsyncCallback<ArrayList<SearchResult>>() {
			public void onFailure(Throwable e) {
				e.printStackTrace();
			}
			public void onSuccess(ArrayList<SearchResult> results) {
				// DisclosurePanel angeboteDisclosurePanel = new DisclosurePanel();
				title.setText("Angebote (" + results.size() + ")");
				System.out.println("Anzahl results: " + results.size());
				// angeboteDisclosurePanel.setTitle("Angebote (" + results.size() + ")");
				for (SearchResult r : results) {
					offeredArticles.add((Widget) r.getView());
				}
				// angeboteDisclosurePanel.setContent(offeredArticles);
				outerPanel.add(title);
				outerPanel.add(offeredArticles);
				outerPanel.doLayout();
			}
		});
	}
	
}
