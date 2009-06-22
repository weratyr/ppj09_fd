package ppj09.gwt.swapweb.client.gui;

/**
 * Klasse User- Form ist zum Aendern bzw. bearbeiten eines Profils
 * 
 * @author Georg Ortwein & Michael Lukaszczyk, Chrisitan Happ
 * @version 0.1 16.06.09
 */

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
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
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
 private ComboBox quickArticleCategoryCB;
 private Checkbox chkbxdelivery1;
 private Checkbox chkbxdelivery2;
 private Checkbox chkbxdelivery3;
 private Button submitButton;
 private Button uploadWindowButton;
 private TextArea txtbxAmount;
 private TextArea txtbxSwaps;
 private TextArea txtbxDescription;
 private final Window window;
 TextField hiddenText;

 public ArticleForm() {
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
    {
     txtbxName = new TextField("Artikelname*", "text_field", 190);
     txtbxName.setAllowBlank(false);
     txtbxName
       .setBlankText("Bitte geben Sie den Artikelnamen ein");
     formPanel.add(txtbxName);

     final Store quickCategoryStore = new SimpleStore("category", new String[]{"Auto","Computer"});
        quickCategoryStore.load();
     
        quickArticleCategoryCB = new ComboBox();
        quickArticleCategoryCB.setStore(quickCategoryStore);
        quickArticleCategoryCB.setFieldLabel("Zustand*");
        quickArticleCategoryCB.setDisplayField("category");
        quickArticleCategoryCB.setMode(ComboBox.LOCAL);
        quickArticleCategoryCB.setTriggerAction(ComboBox.ALL);
        quickArticleCategoryCB.setForceSelection(true);
        quickArticleCategoryCB.setWidth(190);
        quickArticleCategoryCB.setEmptyText("Kategorie wählen");
        formPanel.add(quickArticleCategoryCB);
     
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

     // Create a FileUpload widget.
     final FileUpload upload = new FileUpload();
     upload.setName("uploadFormElement");

     hiddenText = new TextField();
     hiddenText.setName("uploadHiddenElement");
     hiddenText.setVisible(false);
     
     panel.add(upload);
     panel.add(hiddenText);

     Button button2 = new Button("Submit");
     button2.addListener(new ButtonListenerAdapter() {
      public void onClick(Button button, EventObject e) {
    	  if(validateImageExtension(upload.getFilename())) {
    		 System.out.println("FORM GECHICKT");
             imgform.submit();
		  } else {
			 System.out.println("FORM NICHT GESCHICKT"); 
			 MessageBox.alert("Bitte wählen Sie ein Bild mit der Endung\n \"jpg\", \"png\" oder \"bmp\" aus.");
		  }

      }
     });

     // Add a 'submit' button.
     panel.add(button2);

     imgform.addSubmitHandler(new SubmitHandler() {

      public void onSubmit(SubmitEvent event) {
       if (upload.getFilename().length() == 0) {
        MessageBox.alert("The text box must not be empty");
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
        		   System.out.println("Done, Your fake data was saved!");
        	   }
           };
           timer.schedule(8000);
       }
      }
     });

     imgform.addSubmitCompleteHandler(new SubmitCompleteHandler() {
      public void onSubmitComplete(SubmitCompleteEvent event) {
       // When the form submission is successfully
       // completed, this event is
       // fired. Assuming the service returned a response
       // of type text/html,
       // we can get the result text here (see the
       // FormPanel documentation for
       // further explanation).
       MessageBox.alert(event.getResults());
      }
     });

     window = new Window();
     window.setTitle("Bild hochladen");
     window.setClosable(true);
     window.setWidth(600);
     window.setHeight(350);
     window.setPlain(true);
     window.add(imgform);
     window.setCloseAction(Window.HIDE);

     /*
     uploadWindowButton = new Button("Bild hochladen");
     uploadWindowButton.addListener(new ButtonListenerAdapter() {
      public void onClick(Button button, EventObject e) {
       window.show(submitButton.getId());
      }
     });
     formPanel.add(uploadWindowButton);
	 */
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
 
 public boolean validateImageExtension(String filename){
		boolean isAllowdExt = false;
		
		int indexPoint = filename.lastIndexOf(".");
	    int length = filename.length();
	       
	    String extension = filename.substring(indexPoint+1, length);
		
	    if (extension.equals("jpg") || extension.equals("png") || extension.equals("bmp")) {
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
    if(serverMsg == 2){
    	MessageBox.alert("ACHTUNG: Sie sind nicht eingeloggt. Bitte Melden Sie sich an.");
    } else if (serverMsg > 2) {
        formPanel.getForm().reset();
        hiddenText.setRawValue(serverMsg.toString());
        window.show(submitButton.getId());
    } else if (serverMsg == 0){
    	MessageBox.alert("FEHLER: Ihr Artikel konnte nicht angelegt werden.");
    }
   }
  });
  // }
  return true;
 }

 // füllt das Artikelobjekt mit Formulardaten
 private Article fillArticle(Article article) {
  article.setTitle(txtbxName.getText());
  article.setCategory(quickArticleCategoryCB.getText());
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
}