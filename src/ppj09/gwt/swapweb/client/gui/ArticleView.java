package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Georg Ortwein
 * Klasse ArticleView ist zum anzeigen eines Artikels
 */

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;

import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.Offer;
import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.OfferHandler;
import ppj09.gwt.swapweb.client.serverInterface.OfferHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxSelectionModel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.menu.Menu;

public class ArticleView extends Composite implements View {
	private Article article;

	private AbsolutePanel absolutePanel;
	private HorizontalPanel horizontalPanel;
	private VerticalPanel verticalPanel_2;
	private Label lblHorizontalSeperator;
	private VerticalPanel verticalPanel;
	private Label lblArticleName;
	private TabPanel imagePanel;
	private Image image;
	private Image image2;
	private Image image3;
	private Panel ImagePanel2;
	private Panel imagePanel1;
	private Panel ImagePanel3;
	private HorizontalPanel hpLocation;

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
	private String imageUrl;
	private HorizontalPanel hpUsername;
	private Label lblUsername;
	private Label lblUsername2;
	private HorizontalPanel hpCategory;
	private Label lblCategory;
	private Label lblCategory2;
	private Hyperlink usernameHyperlink;
	private Hyperlink categoryHyperlink;
	private Hyperlink messageHyperlink;
	private Hyperlink rateHyperlink;
	private int usernameVisitorId;

	/**
	 * Constructor
	 * 
	 * @param username
	 * 
	 */
	public ArticleView(int articleId) {
		article = new Article();
		getArticle(articleId);
		createForm();

	}

	public void createForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);

			// Überschrift

			{
				horizontalPanel = new HorizontalPanel();
				verticalPanel.add(horizontalPanel);
				{
					absolutePanel = new AbsolutePanel();
					horizontalPanel.add(absolutePanel);
					absolutePanel.setSize("200", "210");

					// Bild
					{
						image = new Image();
						image.setSize("150", "150");
						absolutePanel.add(image, 0, 0);
					}
					
					// Nachricht senden + Bewerung einsehen (Links)
					messageHyperlink = new Hyperlink("",null);
					messageHyperlink.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							showMessageForm();
						}
					});
					
					absolutePanel.add(messageHyperlink,2,158);
					
					rateHyperlink = new Hyperlink("",null);
					rateHyperlink.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
						}
					});
					absolutePanel.add(rateHyperlink,2,176);

					
					// Rechtes Panel ArtikelInformationen
					
					verticalPanel_2 = new VerticalPanel();

					// Benutzername
					{
						hpUsername = new HorizontalPanel();
						lblUsername = new Label("Anbieter:");
						lblUsername.setWidth("160");
						hpUsername.add(lblUsername);
						usernameHyperlink = new Hyperlink("",null);
						usernameHyperlink.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								Panel contentPanel = SwapWeb.getContentPanel();
								contentPanel.clear();
								contentPanel.add(new UserView(usernameHyperlink.getText()));
								contentPanel.doLayout();
							}
						});
						hpUsername.add(usernameHyperlink);

						lblHorizontalSeperator = new Label();
						lblHorizontalSeperator.setWidth("5");
						hpUsername.add(lblHorizontalSeperator);

						verticalPanel_2.add(hpUsername);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

//					// Kategorie
					{
						hpCategory = new HorizontalPanel();
						lblCategory = new Label("Kategorie:");
						lblCategory.setWidth("160");
						hpCategory.add(lblCategory);
						categoryHyperlink = new Hyperlink("", null);
						categoryHyperlink.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								// Setzt den Link auf die Kategorie
								final Panel contentPanel = SwapWeb.getContentPanel();

								ArticleSearchQuery sq = new ArticleSearchQuery();
								sq.setCategoryPhrase(categoryHyperlink.getText());

								SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);
								searchHandler.search(sq, new AsyncCallback<ArrayList<SearchResult>>() {
													public void onFailure(Throwable caught) {
														System.out.println("Fehler: ArticleView.java "+ caught.getMessage());
													}
													public void onSuccess(ArrayList<SearchResult> results) {
														contentPanel.clear();
														Panel listView = new Panel();
														for (SearchResult r : results) {
															listView.add((ArticleSearchResultView) r.getView());
														}
														contentPanel.add(listView);
														contentPanel.doLayout();
													}
												});
							}
						});
						hpCategory.add(categoryHyperlink);

						lblHorizontalSeperator = new Label();
						lblHorizontalSeperator.setWidth("5");
						hpCategory.add(lblHorizontalSeperator);

						verticalPanel_2.add(hpCategory);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

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
			
			Panel offeredArticles = new Panel();
			offeredArticles.setTitle("Vorliegende Angebote:");
			offeredArticles.setWidth(660);
			offeredArticles.add(getArtikelListe());
			verticalPanel.add(offeredArticles);
			
			createOwnArticlesForm();
		}
	}

	// private Object[][] getOwnArticles() {
	// return new Object[][]{
	// new Object[]{"3m Co", new Double(71.72), new Double(0.02)}
	// };
	// }

	private void createOwnArticlesForm() {

		/**
		 * TODO erstellt aus den Formulardaten ein ArticleSearch Objekt und
		 * übergibt es per RPC an SearchHandler.search()
		 */
		// ArticleSearchQuery sq = new ArticleSearchQuery();
		ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);

		articleManager
				.getOwnArticlesList(new AsyncCallback<ArrayList<Article>>() {
					private Window offerWindow;

					public void onFailure(Throwable caught) {
						System.out
								.println("RPC ArticleView: Fehler beim ausgeben der eigenen Artikel");
					}

					public void onSuccess(ArrayList<Article> results) {
						usernameVisitorId =  results.get(0).getUserId();
						Object[][] ownArticleList = new Object[results.size()][10];
						for (int i = 0; i < results.size(); i++) {
							ownArticleList[i] = new Object[] {
									results.get(i).getTitle(),
									results.get(i).getOfferScope(),
									results.get(i).getArticleId() };
						}

						Panel ownArticles = new Panel();
						ownArticles.setWidth(660);
						ownArticles.setPaddings(0);
						ownArticles.setLayout(new VerticalLayout(15));

						final CheckboxSelectionModel cbSelectionModel = new CheckboxSelectionModel();
						final RecordDef recordDef = new RecordDef(
								new FieldDef[] { new StringFieldDef("artikel"),
										new StringFieldDef("angebotsumfang"),
										new StringFieldDef("artikelId") });

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
								new ColumnConfig("Artikel", "artikel", 400,
										true, null, "artikel"),
								new ColumnConfig("Angebotsumfang",
										"angebotsumfang", 200),
								new ColumnConfig("Artikel ID", "artikelId", 60) };

						ColumnModel columnModel = new ColumnModel(columns);
						grid.setColumnModel(columnModel);

						grid.setFrame(true);
						grid.setStripeRows(true);
						grid.setAutoExpandColumn("artikel");

						grid.setSelectionModel(cbSelectionModel);
						grid.setWidth(660);
						grid.setFrame(true);
						grid.setTitle("Ihre eigenen Artikel");

						offerWindow = new Window();
						offerWindow.setTitle("Artikel zum Tausch anbieten");
						offerWindow.setClosable(true);
						offerWindow.setWidth(400);
						offerWindow.setPlain(true);
						offerWindow.setCloseAction(Window.HIDE);

						Button button = new Button("Angebot senden",
								new ButtonListenerAdapter() {
									public void onClick(Button button,
											EventObject e) {
										Record[] records = cbSelectionModel
												.getSelections();
										String offerListIds = "";
										String offerListTitles = "";
										for (int i = 0; i < records.length; i++) {
											Record record = records[i];
											offerListIds += record
													.getAsString("artikelId")
													+ ",";
											offerListTitles += "<li> - "
													+ record
															.getAsString("artikel")
													+ " (ID: "
													+ record
															.getAsString("artikelId")
													+ ")</li>";
										}

										offerWindow.add(getOfferSubmitForm(
												offerListIds, offerListTitles));
										offerWindow.show(button.getId());
									}
								});

						ownArticles.add(grid);
						ownArticles.add(button);

						verticalPanel.add(ownArticles);
						Label guide = new Label(
								"Wählen sie einen oder mehrere Artikel aus der Liste aus und klicken sie auf 'Angebot senden' um ein Tauschangebot an "
										+ lblUsername2
										+ " zu senden. Wenn sie mehrere Artikel auswählen, werden diese Artikel zu einem Angebot zusammengefasst.");
						verticalPanel.add(guide);
					}

					private Component getOfferSubmitForm(
							final String offerListIds, String offerListTitles) {

						FormPanel offerSubmitForm = new FormPanel();
						offerSubmitForm.setBorder(false);
						offerSubmitForm.setPaddings(6);
						offerSubmitForm.setLabelAlign(Position.TOP);
						offerSubmitForm.setMonitorValid(true);
						offerSubmitForm.setFooter(true);

						final Store shippingStore = new SimpleStore("shipping",
								splitShippingMethods());
						shippingStore.load();

						ComboBox shippingCB = new ComboBox();
						shippingCB.setStore(shippingStore);
						shippingCB.setFieldLabel("Versandart*");
						shippingCB.setDisplayField("shipping");
						shippingCB.setMode(ComboBox.LOCAL);
						shippingCB.setTriggerAction(ComboBox.ALL);
						shippingCB.setForceSelection(true);
						shippingCB.setWidth(190);
						shippingCB.setEmptyText("Versandart wählen");

						Panel offerQuestion = new Panel();
						offerQuestion.setBorder(false);
						offerQuestion
								.setHtml("Sind sie sicher, dass sie Folgende Artikel:<b><br><ol>"
										+ offerListTitles
										+ "</ol></b> gegen den Artikel \"<b>"
										+ article.getTitle().toString()
										+ " (ID: "
										+ article.getArticleId()
										+ ")</b>\" tauschen möchten?<br><br> ");
						offerSubmitForm.add(offerQuestion);

						final TextArea offerComment = new TextArea(
								"Kommentar (optional)");
						offerComment.setAllowBlank(false);
						offerComment.setSize(365, 50);

						Checkbox chkbxAccept = new Checkbox(
								"Ja, ich möchte tauschen", "check_Box");
						chkbxAccept.setValidateOnBlur(true);

						Button button = new Button("Angebot senden");
						// button.setFormBind(true);

						offerSubmitForm.add(shippingCB);
						offerSubmitForm.add(offerComment);
						offerSubmitForm.add(chkbxAccept);
						offerSubmitForm.add(button);

						button.addListener(new ButtonListenerAdapter() {
							public void onClick(Button button, EventObject e) {
								System.out.println("lol");
								int swapStatus = 0;
								// Offer offer = new Offer();
								Offer offer = new Offer(article.getArticleId(),
										offerListIds, offerComment.getText(),
										swapStatus);
								OfferHandlerAsync offerHandler = GWT
										.create(OfferHandler.class);
								offerHandler.createOffer(offer,
										new AsyncCallback<Integer>() {
											public void onFailure(
													Throwable caught) {
												System.out
														.println("ArticleView failed");
											}

											public void onSuccess(Integer result) {
												System.out
														.println("ArticleView success");
											}

										});
							}
						});

						return offerSubmitForm;
					}

					private String[] splitShippingMethods() {
						ArrayList<String> temp = new ArrayList<String>();
						String[] shippingMethods;
						if (article.getShippingMethods().toString().contains(
								"Postversand")) {
							temp.add("Postversand");
						}
						if (article.getShippingMethods().toString().contains(
								"Selbstabholung")) {
							temp.add("Selbstabholung");
						}
						if (article.getShippingMethods().toString().contains(
								"Treffen")) {
							temp.add("Treffen");
						}
						shippingMethods = new String[temp.size()];
						for (int i = 0; i < temp.size(); i++) {
							shippingMethods[i] = temp.get(i);
						}
						return shippingMethods;
					}
				});
	}

	// private void getUserSession(){
	// UserManagerAsync usermanager = GWT.create(UserManager.class);
	// usermanager.getSessionId(new AsyncCallback<Integer>(){
	// public void onFailure(Throwable caught) {
	// System.out.println("Fehler:Article View RPC");
	// }
	// public void onSuccess(Integer result) {
	// userIdVisitor = result;
	// }
	// });
	// }

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
				SwapWeb.getContentPanel().setTitle("Artikel: "+article.getTitle()+" (ID: "+article.getArticleId()+")");

				image.setUrl(article.getPictureUrl());
				usernameHyperlink.setText(article.getUserName());
				categoryHyperlink.setText(article.getCategory());
				messageHyperlink.setText("Nachricht an "+article.getUserName());
				rateHyperlink.setText("Bewertungen von "+article.getUserName());
				lblLocation2.setText(article.getZipCode() + " "+ article.getLocation());
				lblCondition2.setText(article.getCondition());
				lblDelivery2.setText(article.getShippingMethods());
				lblAmount2.setText(article.getOfferScope());
				lblSwapIdea2.setText(article.getDesiredItemsComment());
				description.setText(article.getDescription());
			}

		});
	}

	public void showMessageForm() {
		final Window messageWindow = new Window();
		messageWindow.setTitle("Resize Me");
		messageWindow.setWidth(500);
		messageWindow.setHeight(300);
		messageWindow.setMinWidth(300);
		messageWindow.setMinHeight(200);
		messageWindow.setLayout(new FitLayout());
		messageWindow.setPaddings(5);
		messageWindow.setButtonAlign(Position.CENTER);
		

		FormPanel messagePanel = new FormPanel();
	
		// anchor width by percentage
		TextField sentTo = new TextField("Send To", "to");
		sentTo.setEmptyText(article.getUserName());
		sentTo.setDisabled(true);
		messagePanel.add(sentTo, new AnchorLayoutData(
		"100%"));

		// anchor width by percentage
		final TextField subject = new TextField("Subject", "subject");
		subject.setEmptyText("Artikel: "+article.getTitle()+" (ID: "+article.getArticleId()+")");
		subject.setDisabled(true);
		messagePanel.add(subject,new AnchorLayoutData("100%"));
		

		final TextArea textArea = new TextArea("Subject", "subject");
		textArea.setHideLabel(true);
		// anchor width by percentage and height by raw adjustment
		// sets width to 100% and height to "remainder" height - 53px
		messagePanel.add(textArea, new AnchorLayoutData("100% -53"));
		
		Button send = new Button("Send");
		send.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 System.out.println("send me");
				 Message mesg = new Message();
				 mesg.setArticleId(article.getArticleId());
				 mesg.setAuthor(usernameVisitorId);
				 mesg.setMessage(textArea.getText());
				 mesg.setReceiver(article.getUserId());
				 mesg.setTopic("Artikel: "+article.getTitle()+" (ID: "+article.getArticleId()+")");
				 MessageHandlerAsync messageProxy = GWT.create(MessageHandler.class);
				 messageProxy.sendMessage(mesg, new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						
					}
					 
				 });
				 
				 
			 }
		});
		messageWindow.addButton(send);
		Button cancel = new Button("Cancel");
		cancel.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 System.out.println("send me");
				 messageWindow.close();
			 }
		});
		messageWindow.addButton(cancel);

		messageWindow.setCloseAction(Window.HIDE);
		messageWindow.setPlain(true);
	// strips all Ext styling for the component
		messagePanel.setBaseCls("x-plain");
		messagePanel.setLabelWidth(55);
		messagePanel.setUrl("save-form.php");

		messagePanel.setWidth(500);
		messagePanel.setHeight(300);

		

		messageWindow.add(messagePanel);
		messageWindow.show();
	}
	
	private VerticalPanel getArtikelListe() {
		final VerticalPanel offeredArticles = new VerticalPanel();

		SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);
		searchHandler.getOfferedArticles(article.getArticleId(), new AsyncCallback<ArrayList<SearchResult>>() {
			public void onFailure(Throwable e) {
				e.printStackTrace();
			}

			public void onSuccess(ArrayList<SearchResult> results) {
				System.out.println("success");
				for (SearchResult r : results) {
					Panel offerPanel = new Panel();
					offerPanel.setBorder(true);
					offerPanel.setMargins(5);
					for (SearchResult articleSearchResult : ((OfferSearchResult)r).getArticles())
						offerPanel.add((ArticleSearchResultView) articleSearchResult.getView());
					offerPanel.doLayout();
					offeredArticles.add(offerPanel);
				}
			}
		});
		return offeredArticles;
	}

}