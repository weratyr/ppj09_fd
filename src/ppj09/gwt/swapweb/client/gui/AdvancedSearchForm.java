package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.FormLayout;

public class AdvancedSearchForm implements Form{
	private Panel firstTab;
	private TabPanel tabPanel;
	private VerticalPanel searchResultPanel;
	private Checkbox activeArticleCheckBox;
	private Checkbox pictureArticlesCheckBox;
	private TextField searchField;
	private TextField artikelStandort;
	private ComboBox categoryComboBox;

	public AdvancedSearchForm(TabPanel outerTabPanel) {
		categoryComboBox = new ComboBox("Kategorie");
		final FormPanel containerFormPanel = new FormPanel();
		containerFormPanel.setId("advanced-panel"); 
		containerFormPanel.setTitle("Erweiterte Suche");
		containerFormPanel.setLabelAlign(Position.TOP);
		
		Panel firstColumn = new Panel();
		firstColumn.setBorder(false);
		firstColumn.setLayout(new FormLayout());
		firstColumn.setPaddings(10);

		searchField = new TextField("Suche", "searchField", 120);
		artikelStandort = new TextField("Artikelstandort", "searchPhrase", 120);
		firstColumn.add(searchField);
		firstColumn.add(artikelStandort);

		Panel secondColumn = new Panel();
		secondColumn.setLayout(new FormLayout());
		secondColumn.setBorder(false);
		secondColumn.setPaddings(10,10,0,0);

		SwapWeb.getCategories(secondColumn, categoryComboBox);
		categoryComboBox.setFieldLabel("Kategorie");

		Object[][] optionsCondition = new Object[][] {
				new Object[] { "b", "Beliebig" }, new Object[] { "n", "Neu" },
				new Object[] { "g", "Gebraucht" } };

		Store conditionStore = new SimpleStore(new String[] { "d", "options" },
				optionsCondition);
		conditionStore.load();

		final ComboBox conditionComboBox = new ComboBox();
		conditionComboBox.setFieldLabel("Artikel Zustand");
		conditionComboBox.setStore(conditionStore);
		conditionComboBox.setDisplayField("options");
		conditionComboBox.setMode(ComboBox.LOCAL);
		conditionComboBox.setTriggerAction(ComboBox.ALL);
		conditionComboBox.setForceSelection(true);
		conditionComboBox.setEmptyText(optionsCondition[0][1].toString());
		conditionComboBox.setReadOnly(true);
		conditionComboBox.setWidth(120);
		conditionComboBox.setLazyRender(true);
		secondColumn.add(conditionComboBox); 

		Panel thirdColumn = new Panel();
		thirdColumn.setLayout(new FormLayout());
		thirdColumn.setBorder(false);
		thirdColumn.setPaddings(10,10,0,0);

		Object[][] optionsDelivery = new Object[][] {
				new Object[] { "b", "Beliebig" },
				new Object[] { "p", "Postversand" },
				new Object[] { "a", "Abholung" },
				new Object[] { "t", "Treffen" }, };

		Store deliveryStore = new SimpleStore(new String[] { "b", "options" },
				optionsDelivery);
		deliveryStore.load();

		final ComboBox versandComboBox = new ComboBox();
		versandComboBox.setFieldLabel("Versandart");
		versandComboBox.setStore(deliveryStore);
		versandComboBox.setDisplayField("options");
		versandComboBox.setMode(ComboBox.LOCAL);
		versandComboBox.setTriggerAction(ComboBox.ALL);
		versandComboBox.setForceSelection(true);
		versandComboBox.setEmptyText(optionsDelivery[0][1].toString());
		versandComboBox.setReadOnly(true);
		versandComboBox.setWidth(120);
		thirdColumn.add(versandComboBox);

		Panel fourthColumn = new Panel();
		fourthColumn.setLayout(new FormLayout());
		fourthColumn.setBorder(false);
		fourthColumn.setPaddings(23,10,0,0);

		Panel checkBoxPanel = new Panel();
		checkBoxPanel.setBorder(false);
		pictureArticlesCheckBox = new Checkbox("Nur mit Bild anzeigen");
		checkBoxPanel.add(pictureArticlesCheckBox);
		fourthColumn.add(checkBoxPanel);

		Panel buttonPanel = new Panel();
		buttonPanel.setBorder(false);
		buttonPanel.setPaddings(10, 0, 0, 0);
		Button searchButton = new Button("Suchen",
				new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				final ExtElement element = Ext.get("advanced-panel");  
				element.mask("sucht...");
				
				System.out.println("gedrueckt");
				ArticleSearchQuery sq = new ArticleSearchQuery();
				sq.setSearchPhrase(searchField.getText());
				sq.setLocation(artikelStandort.getText());
				sq.setCategory(categoryComboBox.getText());
				sq.setCondition(conditionComboBox.getText());
				sq.setShippingMethods(versandComboBox.getText());
				sq.setPicturesOnly(pictureArticlesCheckBox.getValue());

				SearchHandlerAsync searchHandler = GWT
				.create(SearchHandler.class);
				searchHandler.search(sq,
						new AsyncCallback<ArrayList<SearchResult>>() {
					public void onFailure(Throwable caught) {
						System.out.println("RPC AdvancedSearchForm FAILED");
					}

					public void onSuccess(ArrayList<SearchResult> results) {
						System.out.println("success");
						element.unmask();
						Panel cp = SwapWeb.getContentPanel();
						cp.clear();  
						Panel listView = new Panel();

						for (SearchResult r : results) {
							listView.add( (ArticleSearchResultView) r.getView());
						}
						cp.setTitle("Suchergebnisse");
						cp.add(listView);
						cp.doLayout();
					}
				});

			}

		});
		searchButton.setIconCls("icon-search");
		buttonPanel.add(searchButton);
		fourthColumn.add(buttonPanel);

		MultiFieldPanel multiPanel = new MultiFieldPanel();
		multiPanel.setPaddings(5);
		multiPanel.setBorder(false);
		multiPanel.addToRow(firstColumn, 140);
		multiPanel.addToRow(secondColumn, 140);
		multiPanel.addToRow(thirdColumn, 140);
		multiPanel.addToRow(fourthColumn, 310);

		containerFormPanel.add(multiPanel);
		outerTabPanel.add(containerFormPanel);
	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rueckmeldung
	 */
	public boolean submit() {
		if (Validation.validateAdvancedSearchForm(this)) {
			// Sende Daten an Server
			return true;
		} else {
			// Hinweis auf Fehler
			return false;
		}
	}
}

