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
import ppj09.gwt.swapweb.client.serverInterface.GuiHelper;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelperAsync;
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
	private TabPanel tabPanel;

	private Image image;
	private DisclosurePanel meinSwapWeb;
	private DisclosurePanel kategorien;
	private Tree categoryTree;
	private static Panel contentPanel;
	
	private VerticalPanel meinSwapWeb_verticalPanel;
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
		mainPanel.setLayout(new FitLayout());

		borderPanel = new Panel();
		borderPanel.setBorder(false);
		borderPanel.setPaddings(10);
		borderPanel.setAutoScroll(true);

		/*
		 * NORTH Header und äußeres TabPanel
		 */
		image = new Image("http://www.renegade-station.de/swhead.jpg");

		Panel northOuterPanel = new Panel();
		northOuterPanel.add(image);
		northOuterPanel.setBorder(false);

		tabPanel = getUpperTabPanel();
		northOuterPanel.add(tabPanel);
		borderPanel.add(northOuterPanel, new BorderLayoutData(RegionPosition.NORTH));

		MultiFieldPanel southContainer = new MultiFieldPanel();
		southContainer.setBorder(false);
		southContainer.setPaddings(5, 0, 0, 0);

		/*
		 * CENTER contentPanel
		 */
		contentPanel = new Panel();
		contentPanel.setTitle("Inhaltspanel");
		contentPanel.setWidth(700);
		contentPanel.setPaddings(10);

		// WEST
		Panel navigationPanel = new Panel("Navigation");
		navigationPanel.setWidth(181);

		southContainer.addToRow(navigationPanel, 185);
		southContainer.add(contentPanel);

		borderPanel.add(southContainer);

		navigationsContentPanel = new Panel();
		navigationsContentPanel.setBorder(false);
		navigationPanel.add(navigationsContentPanel);

		// Mein SwapWeb
		meinSwapWeb = new DisclosurePanel("Mein SwapWeb", false);
		meinSwapWeb.setContent(getMySwapWebPanel());
		navigationsContentPanel.add(meinSwapWeb);


		// Kategoriebaum

		kategorien = new DisclosurePanel("Kategorien", false);
		navigationsContentPanel.add(kategorien);

		categoryTree = new Tree();
		kategorien.setContent(categoryTree);

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
				articleView = new ArticleView(30);
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
				userView = new UserView("Theonlybender");
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

	private VerticalPanel getMySwapWebPanel() {
		meinSwapWeb_verticalPanel = new VerticalPanel();
		meinSwapWeb_verticalPanel.setSize("140", "100");

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
		
		//frage den databanker welche kategorien es gibt
		//rpc
		GuiHelperAsync guiHelper = GWT.create(GuiHelper.class);
		guiHelper.getCategories(new AsyncCallback<String[]>() {
			public void onFailure(Throwable caught) {
				System.out.println("Kategorien RPC funzt net: \n\n" + caught.getMessage());
			}
			public void onSuccess(String[] categories) {
				System.out.println("Kategorien RPC funzt");
				
				ArrayList listItems = new ArrayList<TreeItem>();
				
				for (int i = 0; i < categories.length; i++){
					TreeItem temp = new TreeItem("New Item");
					temp.setText(categories[i]);
					System.out.println(categories[i]);
				}
			}
		});
		
		meinSwapWeb_verticalPanel.add(myProfileHyperlink);
		meinSwapWeb_verticalPanel.add(testProfileFormHyperlink);
		meinSwapWeb_verticalPanel.add(myArticlesHyperlink);
		meinSwapWeb_verticalPanel.add(insertArticleHyperlink);
		meinSwapWeb_verticalPanel.add(myRatingsHyperlink);
		meinSwapWeb_verticalPanel.add(myMessagesHyperlink);
		
		return meinSwapWeb_verticalPanel;
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

	public static Panel getContenPanel() {
		return contentPanel;
	}
}
