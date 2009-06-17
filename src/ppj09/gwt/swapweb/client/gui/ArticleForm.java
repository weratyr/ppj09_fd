package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Georg Ortwein & Michael Lukaszczyk
 * Klasse User- Form ist zum Aendern bzw. bearbeiten eines Profils 
 */

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

public class ArticleForm extends Composite implements Form {

	private FormPanel formPanel;
	private TextField txtbxName;
	private TextField txtbxZip;
	private TextField txtbxCity;
	private MultiFieldPanel panel1;
	private ComboBox combobxCondition;
	private Checkbox chkbxdelivery1;
	private Checkbox chkbxdelivery2;
	private Checkbox chkbxdelivery3;
	private Button submitButton;
	private TextArea txtbxAmount;
	private TextArea txtbxSwaps;
	private TextArea txtbxDescription;

	public ArticleForm() {
		{
			VerticalPanel verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			{
				formPanel = new FormPanel();
				formPanel.setLabelAlign(Position.RIGHT);
				formPanel.setLabelWidth(250);
				formPanel.setBorder(false);
				formPanel.setFooter(true);
				formPanel.setWidth(480);
				{
					txtbxName = new TextField("Artikelname*", "text_field", 190);
					formPanel.add(txtbxName);

					txtbxZip = new TextField("Plz* / Artikelstandort*",
							"text_field", 50);
					txtbxZip.setAllowBlank(false);
					txtbxZip.setSelectOnFocus(true);

					txtbxCity = new TextField("Wohnort", "text_field", 135);
					txtbxCity.setAllowBlank(false);
					txtbxCity.setHideLabel(true);
					txtbxCity.setSelectOnFocus(true);

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
					formPanel.add(txtbxAmount);

					txtbxSwaps = new TextArea("Gegentauschvorstellungen*","text_Area");
					txtbxSwaps.setPixelSize(190, 70);
					formPanel.add(txtbxSwaps);

					txtbxDescription = new TextArea("Beschreibung*", "text_Area");
					txtbxDescription.setPixelSize(190, 70);
					formPanel.add(txtbxDescription);
					
					submitButton = new Button("Artikel Erstellen");
					submitButton.setTabIndex(12);
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
	
	public boolean submit() {
		Article newArticle = new Article();
		newArticle = fillArticle(newArticle);
		System.out.println(newArticle.getShippingMethods());
		
		ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);
		articleManager.createArticle(newArticle, new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				// :(
				System.out.println("neeee: "+ caught.getMessage());
			}

			public void onSuccess(Integer serverMsg) {
				// :)
				System.out.println("OK: "+ serverMsg.toString());
			}
		});
		// }
		return true;
	}
	
	private Article fillArticle(Article article) {
		article.setTitle(txtbxName.getText());
		article.setZipCode(txtbxZip.getText());
		article.setLocation(txtbxCity.getText());
		article.setCondition(combobxCondition.getText());
		article.setShippingMethods(getShippingMethods());
		article.setOfferScope(txtbxAmount.getText());
		article.setDesiredItemsComment(txtbxSwaps.getText());
		article.setDescription(txtbxDescription.getText());
		return article;
	}
	
	private String getShippingMethods(){
		String shippingMethods = "";
			if(chkbxdelivery1.getValue() == true){
				shippingMethods.concat("Postversand");
			}
			if(chkbxdelivery2.getValue() == true){
				shippingMethods.concat(", Selbstabholung");
			}
			if(chkbxdelivery3.getValue() == true){
				shippingMethods.concat(", Treffen");
			}
		return shippingMethods;
	}
}