/*
 * @(#)ArticleSearchForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.RegionPosition;
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
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ContainerLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.core.EventObject;

/**
 * Formularfelder und Submit der Artikelsuche. Implementiert das Interface Form.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class ArticleSearchForm extends Composite implements Form {
	private Panel firstTab;
	private Checkbox activeArticleCheckBox;
	private Checkbox pictureArticlesCheckBox;
	private VerticalPanel searchResultPanel;
	private Hyperlink advancedSearchHyperlink;
	private TabPanel tabPanel;

	public ArticleSearchForm() {

		FormPanel containerFormPanel = new FormPanel();
		containerFormPanel.setLabelAlign(Position.TOP);
		HorizontalPanel searchPanel = new HorizontalPanel();
		searchPanel.setSpacing(10);
		searchPanel.add(new TextField("", "phrase", 120));

		Object[][] quickOptionsCategory = new Object[][] { new Object[] {
				"index", "nix drin" }, };

		Store quickCategoryStore = new SimpleStore(new String[] { "b",
				"options" }, quickOptionsCategory);
		quickCategoryStore.load();

		final ComboBox quickArticleCategoryCB = new ComboBox();
		
		quickArticleCategoryCB.setStore(quickCategoryStore);
		quickArticleCategoryCB.setDisplayField("options");
		quickArticleCategoryCB.setMode(ComboBox.LOCAL);
		quickArticleCategoryCB.setTriggerAction(ComboBox.ALL);
		quickArticleCategoryCB.setForceSelection(true);
		quickArticleCategoryCB.setReadOnly(true);
		quickArticleCategoryCB.setWidth(110);
		searchPanel.add(quickArticleCategoryCB);
		

		Button quickSearchButton = new Button("Suchen",
				new ButtonListenerAdapter() {
					public void onClick(Button button, EventObject e) {

						System.out.println("gedrückt");
						/**
						 * TODO erstellt aus den Formulardaten ein ArticleSearch
						 * Objekt und übergibt es per RPC an
						 * SearchHandler.search()
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
											searchResultPanel.add((Widget) r
													.getView());
										}
									}
								});
					}

				});
		quickSearchButton.setIconCls("icon-search");
		searchPanel.add(quickSearchButton);

		advancedSearchHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		searchPanel.add(advancedSearchHyperlink);
		advancedSearchHyperlink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				tabPanel.setVisible(!tabPanel.isVisible());
			}
		});
		advancedSearchHyperlink.setText("Erweiterte Suche");

		containerFormPanel.add(searchPanel);
		
		tabPanel = new TabPanel();;
		tabPanel.setWidth(1000);
		tabPanel.setVisible(false);
		tabPanel.setActiveTab(0);
		tabPanel.setPaddings(5);
		containerFormPanel.add(tabPanel);
		
		firstTab = new Panel();
		firstTab.setBorder(false);
		firstTab.setTitle("Artikelsuche");
		
		Panel firstColumn = new Panel();
		firstColumn.setBorder(false);
		firstColumn.setLayout(new FormLayout());
		firstColumn.setPaddings(10);

		firstColumn.add(new TextField("Suche", "searchPhrase", 110));
		firstColumn.add(new TextField("Artikelstandort", "searchPhrase", 110));

		Panel secondColumn = new Panel();
		secondColumn.setLayout(new FormLayout());
		secondColumn.setBorder(false);
		secondColumn.setPaddings(10,10,0,0);

		Object[][] optionsCategory = new Object[][] { new Object[] { "index",
				"nix drin" }, };

		Store categoryStore = new SimpleStore(new String[] { "b", "options" },
				optionsCategory);
		categoryStore.load();

		final ComboBox articleCategoryCB = new ComboBox("Kategorie");
		
		articleCategoryCB.setStore(categoryStore);
		articleCategoryCB.setDisplayField("options");
		articleCategoryCB.setMode(ComboBox.LOCAL);
		articleCategoryCB.setTriggerAction(ComboBox.ALL);
		articleCategoryCB.setForceSelection(true);
		articleCategoryCB.setReadOnly(true);
		articleCategoryCB.setWidth(110);

		secondColumn.add(articleCategoryCB);

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
		articleConditionCB.setWidth(110);
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
		articleDeliveryCB.setValueField("b");
		articleDeliveryCB.setReadOnly(true);
		articleDeliveryCB.setWidth(110);
		thirdColumn.add(articleDeliveryCB);

		Panel fourthColumn = new Panel();
		fourthColumn.setLayout(new FormLayout());
		fourthColumn.setBorder(false);
		fourthColumn.setPaddings(10,10,0,0);

		activeArticleCheckBox = new Checkbox("Nur aktive Artikel anzeigen");
		fourthColumn.add(activeArticleCheckBox);
		pictureArticlesCheckBox = new Checkbox("Nur mit Bild anzeigen");
		fourthColumn.add(pictureArticlesCheckBox);

		Panel buttonPanel = new Panel();
		buttonPanel.setBorder(false);
		buttonPanel.setPaddings(10, 0, 0, 0);
		Button searchButton = new Button("Suchen", new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {

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
		searchButton.setIconCls("icon-search");
		buttonPanel.add(searchButton);
		fourthColumn.add(buttonPanel);

		MultiFieldPanel multiPanel = new MultiFieldPanel();
		multiPanel.setPaddings(5);
		
		multiPanel.addToRow(firstColumn, 120);
		multiPanel.addToRow(secondColumn, 120);
		multiPanel.addToRow(thirdColumn, 120);
		multiPanel.addToRow(fourthColumn, 300);
		
		Panel test = new Panel ();
		test.setTitle("test");
		test.add(new TextField("hallo"));
		tabPanel.add(test);
		
		firstTab.add(multiPanel);
		//tabPanel.add(firstTab);
		tabPanel.add(new UserSearchForm());
		containerFormPanel.add(multiPanel);
		initWidget(containerFormPanel);
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
