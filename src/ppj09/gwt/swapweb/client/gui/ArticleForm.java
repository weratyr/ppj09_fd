package ppj09.gwt.swapweb.client.gui;

/**
 * Klasse User- Form ist zum Aendern bzw. bearbeiten eines Profils
 * 
 * @author Georg Ortwein & Michael Lukaszczyk, Chrisitan Happ
 * @version 0.1 16.06.09
 */

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.WindowListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

public class ArticleForm extends Composite implements Form {

	private FormPanel formPanel;
	private TextField txtbxName;
	private NumberField txtbxZip;
	private TextField txtbxCity;
	private MultiFieldPanel panel1;
	private ComboBox combobxCondition;
	private ComboBox categoryComboBox;
	private Checkbox chkbxdelivery1;
	private Checkbox chkbxdelivery2;
	private Checkbox chkbxdelivery3;
	private Button submitButton;
	private TextArea txtbxAmount;
	private TextArea txtbxSwaps;
	private TextArea txtbxDescription;
	private Window window;
	TextField hiddenText;
	private Article result;

	public ArticleForm(int articleID) {
		createFrom();
		getArticle(articleID);

	}

	public ArticleForm() {
		createFrom();
	}

	private void createFrom() {
		{
			VerticalPanel verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);

			{
				formPanel = new FormPanel();
				formPanel.setMonitorValid(true);
				formPanel.setLabelAlign(Position.RIGHT);
				formPanel.setLabelWidth(250);
				formPanel.setBorder(false);
				formPanel.setFooter(true);
				formPanel.setWidth(480);

				SwapWeb.getContentPanel().setTitle("Angebot erstellen");
				{
					txtbxName = new TextField("Artikelname*", "text_field", 190);
					txtbxName.setAllowBlank(false);
					txtbxName
							.setBlankText("Bitte geben Sie den Artikelnamen ein");
					formPanel.add(txtbxName);

					final Store quickCategoryStore = new SimpleStore(
							"category", new String[] { "Auto", "Computer" });
					quickCategoryStore.load();

					categoryComboBox = new ComboBox();
					categoryComboBox.setFieldLabel("Kategorie");
					SwapWeb.getCategories(formPanel, categoryComboBox);

					txtbxZip = new NumberField("Plz* / Artikelstandort*",
							"number_field", 50);
					txtbxZip.setAllowBlank(false);
					txtbxZip.setSelectOnFocus(true);
					txtbxZip.setAllowBlank(false);
					txtbxZip
							.setBlankText("Bitte geben sie die Postleitzahl des Artikelstandortes an");
					txtbxZip.setAllowDecimals(false);
					txtbxZip.setMinLength(5);
					txtbxZip.setMaxLength(5);
					txtbxZip.setMinText("Postleitzahl zu kurz");
					txtbxZip.setMaxText("Postleitzahl zu lang");

					txtbxCity = new TextField("Wohnort", "text_field", 135);
					txtbxCity.setAllowBlank(false);
					txtbxCity.setHideLabel(true);
					txtbxCity.setSelectOnFocus(true);
					txtbxCity
							.setBlankText("Bitte geben sie den Artikelstandort an");

					panel1 = new MultiFieldPanel();
					panel1.addToRow(txtbxZip, 310);
					panel1.addToRow(txtbxCity, new ColumnLayoutData(1));
					panel1.setBorder(false);
					formPanel.add(panel1);

					final Store conditionStore = new SimpleStore(new String[] {
							"zustand", "nr" }, new String[][] {
							new String[] { "neu", "1" },
							new String[] { "gebraucht", "2" } });
					conditionStore.load();

					combobxCondition = new ComboBox();
					combobxCondition.setFieldLabel("Zustand*");
					combobxCondition.setStore(conditionStore);
					combobxCondition.setAllowBlank(false);
					combobxCondition.setDisplayField("zustand");
					combobxCondition.setMode(ComboBox.LOCAL);
					combobxCondition.setTriggerAction(ComboBox.ALL);
					combobxCondition.setTypeAhead(true);
					combobxCondition.setEditable(false);
					combobxCondition.setSelectOnFocus(true);
					combobxCondition.setWidth(190);
					combobxCondition.setHideTrigger(false);
					formPanel.add(combobxCondition);

					chkbxdelivery1 = new Checkbox("Postversand", "check_Box");
					chkbxdelivery2 = new Checkbox("Selbstabholung", "check_Box");
					chkbxdelivery3 = new Checkbox("Treffen", "check_Box");

					chkbxdelivery1.setFieldLabel("Versandoptionen*:");

					formPanel.add(chkbxdelivery1);
					formPanel.add(chkbxdelivery2);
					formPanel.add(chkbxdelivery3);

					txtbxAmount = new TextArea("Angebotsumfang*", "text_Area");
					txtbxAmount.setPixelSize(190, 70);
					txtbxAmount.setAllowBlank(false);
					txtbxAmount
							.setBlankText("Bitte geben sie hier den Angebotsumfang an");
					formPanel.add(txtbxAmount);

					txtbxSwaps = new TextArea("Gegentauschvorstellungen*",
							"text_Area");
					txtbxSwaps.setPixelSize(190, 70);
					txtbxSwaps.setAllowBlank(false);
					txtbxSwaps
							.setBlankText("Bitte geben sie hier an, was sie gerne gegen ihren Artikel tauschen würden");
					formPanel.add(txtbxSwaps);

					txtbxDescription = new TextArea("Beschreibung*",
							"text_Area");
					txtbxDescription.setPixelSize(190, 70);
					txtbxDescription.setAllowBlank(false);
					txtbxDescription
							.setBlankText("Bitte geben sie hier eine Beschreibung zum Artikel an");
					formPanel.add(txtbxDescription);

					// // AB HIER FORM FÜR FILE UPLOAD

					final com.google.gwt.user.client.ui.FormPanel imgform = new com.google.gwt.user.client.ui.FormPanel();
					imgform.setAction(GWT.getModuleBaseURL()
							+ "ImageUploadHandler");

					// Because we're going to add a FileUpload widget, we'll
					// need to set the
					// form to use the POST method, and multipart MIME encoding.
					imgform
							.setEncoding(com.google.gwt.user.client.ui.FormPanel.ENCODING_MULTIPART);
					imgform
							.setMethod(com.google.gwt.user.client.ui.FormPanel.METHOD_POST);

					VerticalPanel panel = new VerticalPanel();
					imgform.setWidget(panel);

					Panel beschreibung = new Panel();
					beschreibung.setMargins(5);
					beschreibung
							.setHtml("Mit einem Klick auf \"Datei auswählen\" können Sie ein Bild in den Formaten <b>\"jpg\"</b>, <b>\"png\"</b> oder <b>\"bmp\"</b> auswählen und anschließend hochladen.");
					beschreibung.setWidth(350);
					panel.add(beschreibung);

					panel.setSpacing(2);

					// Create a FileUpload widget.
					final FileUpload upload = new FileUpload();
					upload.setWidth("340");
					upload.setName("uploadFormElement");

					hiddenText = new TextField();
					hiddenText.setName("uploadHiddenElement");
					hiddenText.setVisible(false);

					panel.add(upload);
					panel.add(hiddenText);

					Button button2 = new Button("Submit");
					button2.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							if (validateImageExtension(upload.getFilename())) {
								System.out.println("FORM GECHICKT");
								imgform.submit();
							} else {
								System.out.println("FORM NICHT GESCHICKT");
								MessageBox
										.alert("Bitte wählen Sie ein Bild mit der Endung\n \"jpg\", \"png\" oder \"bmp\" aus.");
							}

						}
					});

					// Add a 'submit' button.
					panel.add(button2);

					imgform.addSubmitHandler(new SubmitHandler() {

						public void onSubmit(SubmitEvent event) {
							if (upload.getFilename().length() == 0) {
								MessageBox
										.alert("The text box must not be empty");
								event.cancel();
							} else {
								System.out.println("VOR STATUSBAR");
								MessageBox.show(new MessageBoxConfig() {
									{
										setMsg("Ihr Bild wird gespeichert, bitte warten...");
										setProgressText("Speichern...");
										setWidth(300);
										setWait(true);
										setWaitConfig(new WaitConfig() {
											{
												setInterval(200);
											}
										});
										setAnimEl(submitButton.getId());
									}
								});
								System.out.println("NACH STATUSBAR");

								Timer timer = new Timer() {
									public void run() {
										MessageBox.hide();
										System.out
												.println("Done, Your fake data was saved!");
									}
								};
								timer.schedule(8000);
							}
						}
					});

					imgform
							.addSubmitCompleteHandler(new SubmitCompleteHandler() {
								public void onSubmitComplete(
										SubmitCompleteEvent event) {

									MessageBox.alert(event.getResults());
									window.close();
									SwapWeb.getContentPanel().clear();
									SwapWeb.getContentPanel().add(
											new ArticleView(Integer
													.parseInt(hiddenText
															.getText())));
									SwapWeb.getContentPanel().doLayout();

								}
							});

					window = new Window();
					window.setTitle("Bild hochladen");
					window.setClosable(true);
					// TODO
					window.addListener(new WindowListenerAdapter() {
						public void onHide(Component component) {
							MessageBox
									.alert("Ihr Artikel wurde erfolgreich erstellt");
							SwapWeb.getContentPanel().clear();
							SwapWeb.getContentPanel().add(
									new ArticleView(Integer.parseInt(hiddenText
											.getText())));
							SwapWeb.getContentPanel().doLayout();
						}
					});
					window.setPaddings(5);
					window.setPlain(true);
					window.add(imgform);
					window.setCloseAction(Window.HIDE);

					// //// ENDE FORMS FÜR FILE UPLOAD
					submitButton = new Button("Artikel Erstellen");
					submitButton.setFormBind(true);

					formPanel.addButton(submitButton);

					submitButton.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							submit();
						}
					});
				}

				verticalPanel.add(formPanel);
			}
		}

	}

	public boolean validateImageExtension(String filename) {
		boolean isAllowdExt = false;

		int indexPoint = filename.lastIndexOf(".");
		int length = filename.length();

		String extension = filename.substring(indexPoint + 1, length);

		extension = extension.toLowerCase();
		if (extension.equals("jpg") || extension.equals("png")
				|| extension.equals("bmp")) {
			isAllowdExt = true;
		}

		return isAllowdExt;
	}

	public boolean submit() {
		Article newArticle = new Article();
		newArticle = fillArticle(newArticle);

		ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);
		articleManager.createArticle(newArticle, new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				//
				System.out.println("neeee: " + caught.getMessage());
			}

			public void onSuccess(Integer serverMsg) {
				//
				System.out.println("OK: " + serverMsg.toString());
				if (serverMsg == 2) {
					MessageBox
							.alert("ACHTUNG: Sie sind nicht eingeloggt. Bitte Melden Sie sich an.");
				} else if (serverMsg > 2) {
					formPanel.getForm().reset();
					hiddenText.setRawValue(serverMsg.toString());
					window.show(submitButton.getId());
				} else if (serverMsg == 0) {
					MessageBox
							.alert("FEHLER: Ihr Artikel konnte nicht angelegt werden.");
				}
			}
		});
		// }
		return true;
	}

	// füllt das Artikelobjekt mit Formulardaten
	private Article fillArticle(Article article) {
		article.setTitle(txtbxName.getText());
		article.setCategory(categoryComboBox.getText());
		article.setZipCode(txtbxZip.getText());
		article.setLocation(txtbxCity.getText());
		article.setCondition(combobxCondition.getText());
		article.setShippingMethods(getShippingMethods());
		article.setOfferScope(txtbxAmount.getText());
		article.setDesiredItemsComment(txtbxSwaps.getText());
		article.setDescription(txtbxDescription.getText());
		return article;
	}

	private String getShippingMethods() {
		String shippingMethods = "";
		if (chkbxdelivery1.getValue() == true) {
			shippingMethods = shippingMethods.concat("Postversand\n");
		}
		if (chkbxdelivery2.getValue() == true) {
			shippingMethods = shippingMethods.concat("Selbstabholung\n");
		}
		if (chkbxdelivery3.getValue() == true) {
			shippingMethods = shippingMethods.concat("Treffen");
		}
		return shippingMethods;
	}

	// private boolean checkboxValidate(){
	// if(chkbxdelivery1.getValue() == false && chkbxdelivery2.getValue() ==
	// false && chkbxdelivery3.getValue() == false){
	// return false;
	// }
	// return true;
	// }

	public Article getArticle(int articleID) {
		result = new Article();

		ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);
		articleManager.getArticle(articleID, new AsyncCallback<Article>() {

			public void onSuccess(Article resultArticle) {
				System.out.println(resultArticle.getTitle());
				result = resultArticle;
				fillForm(resultArticle);
			}

			public void onFailure(Throwable caught) {
				System.out.println("Fehler in ArticleForm getArticle RPC");
			}

		});
		return result;
	}

	public void fillForm(Article article) {
		try {
			this.txtbxName.setRawValue(article.getTitle());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		try {
			this.txtbxZip.setRawValue(article.getZipCode());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		try {
			this.txtbxCity.setRawValue(article.getLocation());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		try {
			this.combobxCondition.setRawValue(article.getCondition());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		// Shipping //TODO
		try {
			this.txtbxAmount.setRawValue(article.getOfferScope());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		try {
			this.txtbxSwaps.setRawValue(article.getDesiredItemsComment());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		try {
			this.txtbxDescription.setRawValue(article.getDescription());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		try {
			this.categoryComboBox.setRawValue(article.getCategory());
		} catch (NullPointerException e) {
			System.out.println("Fehler fillForm() " + e);
		}
		
		
	}

}
