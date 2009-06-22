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
	private Checkbox activeArticleCheckBox;
	private Checkbox pictureArticlesCheckBox;
	private VerticalPanel searchResultPanel;
	private TabPanel tabPanel;
	private TextField searchField;
	private TextField artikelStandort;

	public AdvancedSearchForm(TabPanel outerTabPanel) {

		final FormPanel containerFormPanel = new FormPanel();
		containerFormPanel.setId("advanced-panel"); 
		containerFormPanel.setTitle("Erweiterte Suche");
		containerFormPanel.setLabelAlign(Position.TOP);
		
		tabPanel = new TabPanel();;
		tabPanel.setWidth("100%");
		//tabPanel.setVisible(false);
		tabPanel.setActiveTab(0);
		tabPanel.setPaddings(5);
		tabPanel.setVisible(true);
		containerFormPanel.add(tabPanel);

		firstTab = new Panel();
		firstTab.setBorder(false);
		firstTab.setTitle("Artikelsuche");

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

		//		Object[][] optionsCategory = new Object[][] { new Object[] { "index",
		//				"nix drin" }, };

		Store categoryStore = new SimpleStore(new String[] { "index", "category" },
				new String[][] {
				new String[] { "1", "test1" },
				new String[] { "2", "test2" } });
		categoryStore.load();

		final ComboBox articleCategoryCB = new ComboBox("Kategorie");

		articleCategoryCB.setStore(categoryStore);
		articleCategoryCB.setDisplayField("options");
		articleCategoryCB.setMode(ComboBox.LOCAL);
		articleCategoryCB.setTriggerAction(ComboBox.ALL);
		articleCategoryCB.setForceSelection(true);
		articleCategoryCB.setEmptyText("Kategorie wählen");
		articleCategoryCB.setReadOnly(true);
		articleCategoryCB.setWidth(120);

		secondColumn.add(articleCategoryCB);

		Object[][] optionsCondition = new Object[][] {
				new Object[] { "b", "Beliebig" }, new Object[] { "n", "Neu" },
				new Object[] { "g", "Gebraucht" } };

		Store conditionStore = new SimpleStore(new String[] { "d", "options" },
				optionsCondition);
		conditionStore.load();

		final ComboBox articleConditionCB = new ComboBox();
		articleConditionCB.setFieldLabel("Artikel Zustand");
		articleConditionCB.setStore(conditionStore);
		articleConditionCB.setDisplayField("options");
		articleConditionCB.setMode(ComboBox.LOCAL);
		articleConditionCB.setTriggerAction(ComboBox.ALL);
		articleConditionCB.setForceSelection(true);
		articleConditionCB.setEmptyText(optionsCondition[0][1].toString());
		articleConditionCB.setReadOnly(true);
		articleConditionCB.setWidth(120);
		articleConditionCB.setLazyRender(true);
		secondColumn.add(articleConditionCB);

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

		final ComboBox articleDeliveryCB = new ComboBox();
		articleDeliveryCB.setFieldLabel("Versandart");
		articleDeliveryCB.setStore(deliveryStore);
		articleDeliveryCB.setDisplayField("options");
		articleDeliveryCB.setMode(ComboBox.LOCAL);
		articleDeliveryCB.setTriggerAction(ComboBox.ALL);
		articleDeliveryCB.setForceSelection(true);
		articleDeliveryCB.setEmptyText(optionsDelivery[0][1].toString());
		articleDeliveryCB.setReadOnly(true);
		articleDeliveryCB.setWidth(120);
		thirdColumn.add(articleDeliveryCB);

		Panel fourthColumn = new Panel();
		fourthColumn.setLayout(new FormLayout());
		fourthColumn.setBorder(false);
		fourthColumn.setPaddings(23,10,0,0);

		Panel checkBoxPanel = new Panel();
		checkBoxPanel.setBorder(false);
		activeArticleCheckBox = new Checkbox("Nur aktive Artikel anzeigen");
		checkBoxPanel.add(activeArticleCheckBox);
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
				sq.setCategory(articleCategoryCB.getText());

				SearchHandlerAsync searchHandler = GWT
				.create(SearchHandler.class);
				searchHandler.search(sq,
						new AsyncCallback<ArrayList<SearchResult>>() {
					public void onFailure(Throwable caught) {
						System.out.println("RPC ArticleSearchForm: fehler im quickserach ");
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

		firstTab.add(multiPanel);
		tabPanel.add(firstTab);
		new UserSearchForm(tabPanel);
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

