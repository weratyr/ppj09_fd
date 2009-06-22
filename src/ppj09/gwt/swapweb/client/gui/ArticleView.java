package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Georg Ortwein
 * Klasse ArticleView ist zum anzeigen eines Artikels
 */

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxSelectionModel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class ArticleView extends Composite implements View {
	private Article article;

	private AbsolutePanel absolutePanel;
	private HorizontalPanel horizontalPanel;
	private VerticalPanel verticalPanel_2;
	private Label lblHorizontalSeperator;
	private VerticalPanel verticalPanel;
	private Label lblArticleName;
	private TabPanel imagePanel;
	private Image image1;
	private Image image2;
	private Image image3;
	private Panel ImagePanel2;
	private Panel imagePanel1;
	private Panel ImagePanel3;
	private HorizontalPanel hpLocation;
	private Label lblUsername;
	private Label lblLocation;
	private Label lblLocation2;
	private HorizontalPanel hpCondition;
	private Label lblCondition2;
	private Label lblCondition;
	private Label verticalSeperator1;
	private HorizontalPanel hpDelivery;
	private Label lblDelivery2;
	private Label lblDelivery;
	private HorizontalPanel hpAmount;
	private Label lblAmount;
	private Label lblAmount2;
	private HorizontalPanel hpSwapIdea;
	private Label lblSwapIdea2;
	private Label lblSwapIdea;
	private Label description;

	/**
	 * Constructor
	 * 
	 * @param username
	 * 
	 */
	public ArticleView(int articleId) {
		article = new Article();
		createForm();
		getArticle(articleId);

	}

	public void createForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);

			// Überschrift
			{
				lblArticleName = new Label();

				verticalPanel.add(lblArticleName);
			}

			{
				horizontalPanel = new HorizontalPanel();
				verticalPanel.add(horizontalPanel);
				{
					absolutePanel = new AbsolutePanel();
					horizontalPanel.add(absolutePanel);
					absolutePanel.setSize("200", "200");

					// Bild
					{
						imagePanel = new TabPanel();
						imagePanel.setWidth(155);
						imagePanel.setTabPosition(Position.BOTTOM);

						image1 = new Image();
						image1.setSize("150", "160");
						image1
								.setUrl("http://www.willgewinnen.at/wp-content/uploads/2008/09/wg_e-gitarre1.jpg");

						imagePanel1 = new Panel();
						imagePanel1.setTitle("Bild 1");
						imagePanel1.add(image1);
						imagePanel.add(imagePanel1);

						image2 = new Image();
						image2.setPixelSize(150, 160);
						image2
								.setUrl("http://www.spiegel.de/img/0,1020,128453,00.jpg");

						ImagePanel2 = new Panel();
						ImagePanel2.setTitle("Bild 2");
						ImagePanel2.add(image2);
						imagePanel.add(ImagePanel2);

						image3 = new Image();
						image3.setPixelSize(150, 160);
						image3
								.setUrl("http://www.willgewinnen.at/wp-content/uploads/2008/09/wg_e-gitarre1.jpg");

						ImagePanel3 = new Panel();
						ImagePanel3.setTitle("Bild 3");
						ImagePanel3.add(image3);
						imagePanel.add(ImagePanel3);

						absolutePanel.add(imagePanel, 0, 0);
					}

				}

				{

					verticalPanel_2 = new VerticalPanel();

					// Standort
					{
						hpLocation = new HorizontalPanel();
						lblLocation = new Label("Standort:");
						lblLocation.setWidth("160");
						hpLocation.add(lblLocation);
						lblLocation2 = new Label();
						hpLocation.add(lblLocation2);

						lblHorizontalSeperator = new Label();
						lblHorizontalSeperator.setWidth("5");
						hpLocation.add(lblHorizontalSeperator);

						verticalPanel_2.add(hpLocation);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);

					}

					// Zustand
					{
						hpCondition = new HorizontalPanel();
						lblCondition = new Label("Zutand:");
						lblCondition.setWidth("160");
						hpCondition.add(lblCondition);
						lblCondition2 = new Label();
						hpCondition.add(lblCondition2);

						verticalPanel_2.add(hpCondition);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

					// Versandoptionen
					{
						hpDelivery = new HorizontalPanel();
						lblDelivery = new Label("Versandoptionen:");
						lblDelivery.setWidth("160");
						hpDelivery.add(lblDelivery);
						lblDelivery2 = new Label();
						hpDelivery.add(lblDelivery2);

						verticalPanel_2.add(hpDelivery);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

					// Angebotsumfang
					{
						hpAmount = new HorizontalPanel();
						lblAmount = new Label("Angebotsumfang:");
						lblAmount.setWidth("160");
						hpAmount.add(lblAmount);
						lblAmount2 = new Label();
						hpAmount.add(lblAmount2);

						verticalPanel_2.add(hpAmount);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

					// Gegentauschvorstellungen
					{
						hpSwapIdea = new HorizontalPanel();
						lblSwapIdea = new Label("Tauschvorstellungen:");
						lblSwapIdea.setWidth("160");
						hpSwapIdea.add(lblSwapIdea);
						lblSwapIdea2 = new Label();
						hpSwapIdea.add(lblSwapIdea2);

						verticalPanel_2.add(hpSwapIdea);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

				}
				horizontalPanel.add(verticalPanel_2);
			}

			Panel articleDescription = new Panel();
			articleDescription.setTitle("Über das Angebot:");
			description = new Label();
			articleDescription.add(description);
			articleDescription.setWidth(660);
			articleDescription.setPaddings(5);
			verticalPanel.add(articleDescription);
			verticalPanel.setSpacing(10);
			createOwnArticlesForm(); 

		}
	}

//	  private Object[][] getOwnArticles() {  
//		         return new Object[][]{  
//		                 new Object[]{"3m Co", new Double(71.72), new Double(0.02)}
//		         };  
//		     }  
	
	
	private void createOwnArticlesForm() {  
		

		/**
		 * TODO erstellt aus den Formulardaten ein ArticleSearch Objekt und
		 * übergibt es per RPC an SearchHandler.search()
		 */
//		ArticleSearchQuery sq = new ArticleSearchQuery();
		ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);

		articleManager.getOwnArticlesList(new AsyncCallback<ArrayList<Article>>() {
			private Window window;

			public void onFailure(Throwable caught) {
				System.out
				.println("RPC ArticleView: Fehler beim ausgeben der eigenen Artikel");
			}

			public void onSuccess(ArrayList<Article> results) {
				Object[][] ownArticleList = new Object[results.size()][10];
				for (int i = 0;i<results.size();i++){
						ownArticleList[i] = new Object[]{results.get(i).getTitle(),results.get(i).getOfferScope(),results.get(i).getArticleId()};
				}
				Panel offeredArticles = new Panel();
				offeredArticles.setTitle("Vorliegende Angebote:");
				offeredArticles.setWidth(660);
				verticalPanel.add(offeredArticles);

				Panel ownArticles = new Panel();
				ownArticles.setWidth(660);
				ownArticles.setPaddings(0);
				ownArticles.setLayout(new VerticalLayout(15));

				final CheckboxSelectionModel cbSelectionModel = new CheckboxSelectionModel();

				RecordDef recordDef = new RecordDef(new FieldDef[] {
						new StringFieldDef("artikel"),
						new StringFieldDef("angebotsumfang"),
						new StringFieldDef("artikelId") 
				});

				GridPanel grid = new GridPanel();

				Object[][] data = ownArticleList;
				MemoryProxy proxy = new MemoryProxy(data);

				ArrayReader reader = new ArrayReader(recordDef);
				Store store = new Store(proxy, reader);
				store.load();
				grid.setStore(store);

				BaseColumnConfig[] columns = new BaseColumnConfig[] {
						new CheckboxColumnConfig(cbSelectionModel),
						// column ID is company which is later used in
						// setAutoExpandColumn
						new ColumnConfig("Artikel", "artikel", 400, true, null,"artikel"), 
						new ColumnConfig("Angebotsumfang", "angebotsumfang",200),
						new ColumnConfig("Artikel ID", "artikelId", 60)
				};

				ColumnModel columnModel = new ColumnModel(columns);
				grid.setColumnModel(columnModel);

				grid.setFrame(true);
				grid.setStripeRows(true);
				grid.setAutoExpandColumn("artikel");

				grid.setSelectionModel(cbSelectionModel);
				grid.setWidth(660);
				grid.setFrame(true);
				grid.setTitle("Ihre eigenen Artikel");
				
				window = new Window();
				window.setTitle("Bild hochladen");
				window.setClosable(true);
				window.setWidth(600);
				window.setHeight(350);
				window.setPlain(true);
				window.add(getOfferSubmitForm());
				window.setCloseAction(Window.HIDE);
				
				Button button = new Button("Angebot senden",
						new ButtonListenerAdapter() {
							public void onClick(Button button, EventObject e) {
//								Record[] records = cbSelectionModel.getSelections();
//								String msg = "";
//								for (int i = 0; i < records.length; i++) {
//									Record record = records[i];
//									msg += record.getAsString("artikel") + " ";
//								}
//								System.out.println("Records Selected :" + msg);
								
								window.show(button.getId());  
							}
						});

				ownArticles.add(grid);
				ownArticles.add(button);

				verticalPanel.add(ownArticles);
				Label guide = new Label(
						"Wählen sie einen oder mehrere Artikel aus der Liste aus und klicken sie auf 'Angebot senden' um ein Tauschangebot an "
								+ lblUsername + " zu senden. Wenn sie mehrere Artikel auswählen, werden diese Artikel zu einem Angebot zusammengefasst.");
				verticalPanel.add(guide);
			}

			private Component getOfferSubmitForm() {
				Panel offerSubmitForm = new Panel();
				Label offerQuestion = new Label();
				Label offerList = new Label();

				offerQuestion.setText("Sind sie sicher, dass sie Folgende Artikel:\n"+offerList+" gegen den Artikel \""+article.getTitle().toString()+"\" tauschen möchten?");
				offerSubmitForm.add(offerQuestion);
				return offerSubmitForm;
			} 	 	
		});
	}
         
//	private void getUserSession(){
//		UserManagerAsync usermanager = GWT.create(UserManager.class);
//		usermanager.getSessionId(new AsyncCallback<Integer>(){
//			public void onFailure(Throwable caught) {
//				System.out.println("Fehler:Article View RPC");
//			}
//			public void onSuccess(Integer result) {
//				userIdVisitor = result;
//			}			
//		});
//	}
    
	
	private void getArticle(int articleId) {
		System.out.println("test");

		ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);

		articleManager.getArticle(articleId, new AsyncCallback<Article>() {
			public void onFailure(Throwable caught) {
				// :(
				System.out.println("fehler");

			}

			public void onSuccess(Article articleDatatype) {
				article = articleDatatype;

				System.out.println(article.getTitle());
				System.out.println(article.getUserId());
				lblArticleName.setText(article.getTitle());
				lblLocation2.setText(article.getZipCode() + " "
						+ article.getLocation());
				lblCondition2.setText(article.getCondition());
				lblDelivery2.setText(article.getShippingMethods());
				lblAmount2.setText(article.getOfferScope());
				lblSwapIdea2.setText(article.getDesiredItemsComment());
				description.setText(article.getDescription());
			}

		});
	}
}
