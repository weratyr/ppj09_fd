/*
 * @(#)ArticleSearchForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.form.Field;

/**
 * Formularfelder und Submit der Artikelsuche. Implementiert das Interface Form.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class ArticleSearchForm extends Composite implements Form {
	private TabPanel tabPanel;
	private FormPanel formPanel;
	private Label searchqueryLabel;
	private TextBox searchqueryTextBox;
	private Label excludeArticleLabel;
	private TextBox excludeArticleTextBox;
	private Label articleLocationLabel;
	private TextBox articleLocationTextBox;
	private Label articleConditionLabel;
	private ListBox articleConditionComboBox;
	private ListBox deliveryComboBox;
	private Label deliveryLabel;
	private ListBox categoryComboBox;
	private CheckBox activeArticleCheckBox;
	private CheckBox pictureArticlesCheckBox;
	private Button resultButton;
	private Label resultLabel;
	private UserSearchForm userSearchForm;
	private VerticalPanel searchResultPanel;
	private TextBox SearchtextBox;
	private Button SearchButton;
	private ListBox categoryComboBoxQuckSearch;
	private Hyperlink advancedSearchHyperlink;

	public ArticleSearchForm() {

		VerticalPanel container = new VerticalPanel();
		initWidget(container);

		HorizontalPanel searchPanel = new HorizontalPanel();
		searchPanel.setSpacing(8);
		SearchtextBox = new TextBox();
		searchPanel.add(SearchtextBox);

		categoryComboBoxQuckSearch = new ListBox();
		searchPanel.add(categoryComboBoxQuckSearch);
		categoryComboBoxQuckSearch.addItem("Kategorie");
		categoryComboBoxQuckSearch.setSize("120", "");
		container.add(searchPanel);

		SearchButton = new Button("Suche");
		searchPanel.add(SearchButton);
		SearchButton.setHeight("22");

		advancedSearchHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		searchPanel.add(advancedSearchHyperlink);
		advancedSearchHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				tabPanel.setVisible(!tabPanel.isVisible());

			}
		});
		advancedSearchHyperlink.setText("erweiterte Suche");

		tabPanel = new TabPanel();
		// tabPanel.setVisible(false);
		container.add(tabPanel);

		formPanel = new FormPanel();
		formPanel.setLabelAlign(Position.TOP);

		Panel firstColumn = new Panel();
		firstColumn.setLayout(new FormLayout());
		firstColumn.setBorder(false);
		firstColumn.setPaddings(10);

		firstColumn.add(new TextField("Suche",
				"searchPhrase", 110));
		firstColumn.add(new TextField("Begriff ignorieren",
				"searchPhrase", 110));
		firstColumn.add(new TextField("Artikelstandort", "searchPhrase", 110));

		Panel secondColumn = new Panel();
		secondColumn.setLayout(new FormLayout());
		secondColumn.setBorder(false);
		secondColumn.setPaddings(10);

		Object[][] optionsCondition = new Object[][] {
				new Object[] { "b", "Beliebig" }, new Object[] { "n", "Neu" },
				new Object[] { "g", "Gebraucht" }, };

		Store conditionStore = new SimpleStore(new String[] { "b", "options" },
				optionsCondition);
		conditionStore.load();

		final ComboBox articleConditionCB = new ComboBox();
		articleConditionCB.setFieldLabel("Artikel Zustand");
		articleConditionCB.setStore(conditionStore);
		articleConditionCB.setDisplayField("options");
		articleConditionCB.setMode(ComboBox.LOCAL);
		articleConditionCB.setTriggerAction(ComboBox.ALL);
		articleConditionCB.setForceSelection(true);
		articleConditionCB.setValueField("b");
		articleConditionCB.setReadOnly(true);
		articleConditionCB.setWidth(90);
		secondColumn.add(articleConditionCB);

		Object[][] optionsDelivery = new Object[][] {
				new Object[] { "b", "Beliebig" },
				new Object[] { "p", "Postversand" },
				new Object[] { "a", "Abholung" },
				new Object[] { "t", "Treffen" }, };

		Store deliveryStore = new SimpleStore(new String[] { "b", "options" },
				optionsDelivery);
		conditionStore.load();

		final ComboBox articleDeliveryCB = new ComboBox();
		articleDeliveryCB.setFieldLabel("Versandart");
		articleDeliveryCB.setStore(deliveryStore);
		articleDeliveryCB.setDisplayField("options");
		articleDeliveryCB.setMode(ComboBox.LOCAL);
		articleDeliveryCB.setTriggerAction(ComboBox.ALL);
		articleDeliveryCB.setForceSelection(true);
		articleDeliveryCB.setValueField("b");
		articleDeliveryCB.setReadOnly(true);
		articleDeliveryCB.setWidth(90);
		secondColumn.add(articleDeliveryCB);

	
		Object[][] optionsCategory = new Object[][] {
				new Object[] { "index", "nix drin" }, };

		Store categoryStore = new SimpleStore(new String[] { "b", "options" },
				optionsCategory);
		conditionStore.load();

		final ComboBox articleCategoryCB = new ComboBox();
		articleCategoryCB.setFieldLabel("Kategorie");
		articleCategoryCB.setStore(categoryStore);
		articleCategoryCB.setDisplayField("options");
		articleCategoryCB.setMode(ComboBox.LOCAL);
		articleCategoryCB.setTriggerAction(ComboBox.ALL);
		articleCategoryCB.setForceSelection(true);
		
		articleCategoryCB.setReadOnly(true);
		articleCategoryCB.setWidth(90);
		secondColumn.add(articleCategoryCB);

		deliveryLabel = new Label("Versandart:");
		categoryComboBox = new ListBox();
		// formPanel.add(categoryComboBox);
		categoryComboBox.addItem("Kategorie");
		categoryComboBox.setSize("120", "");

		activeArticleCheckBox = new CheckBox("New check box");
		// formPanel.add(activeArticleCheckBox);
		activeArticleCheckBox.setHTML("Nur aktive Artikel Anzeigen");

		pictureArticlesCheckBox = new CheckBox(
				"Nur Artikel mit Bildern anzeigen");
		// formPanel.add(pictureArticlesCheckBox);

		resultButton = new Button("New button");
		// formPanel.add(resultButton);
		resultButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("gedrückt");
				/**
				 * TODO erstellt aus den Formulardaten ein ArticleSearch Objekt
				 * und übergibt es per RPC an SearchHandler.search()
				 */
				SearchHandlerAsync searchHandler = GWT
						.create(SearchHandler.class);
				searchHandler.search(new ArticleSearchQuery(),
						new AsyncCallback<ArrayList<SearchResult>>() {
							public void onFailure(Throwable caught) {
								System.out.println("neeee: ");
							}

							public void onSuccess(
									ArrayList<SearchResult> results) {
								System.out.println("neeee: ");
								for (SearchResult r : results) {
									searchResultPanel.add((Widget) r.getView());
								}
							}
						});
			}
		});

		resultButton.setText("Ergebnisse anzeigen");

		resultLabel = new Label("5 Artikel gefunden");
		// formPanel.add(resultLabel);
		resultLabel.setWidth("143");

		searchResultPanel = new VerticalPanel();
		// formPanel.add(searchResultPanel);

		MultiFieldPanel left = new MultiFieldPanel();
		left.addToRow(firstColumn, 180);
		left.addToRow(secondColumn, 180);

		formPanel.add(left);

		tabPanel.add(formPanel, "Artikelsuche", false);
		tabPanel.selectTab(0);

		{
			userSearchForm = new UserSearchForm();
			tabPanel.add(userSearchForm, "Benutzersuche", false);
			userSearchForm.setSize("600px", "150");
		}

	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rueckmeldung
	 */
	public boolean submit() {
		if (Validation.validateArticleSearchForm(this)) {
			// Sende Daten an Server
			return true;
		} else {
			// Hinweis auf Fehler
			return false;
		}
	}
}
