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
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelper;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelperAsync;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;

/**
 * Formularfelder und Submit der Artikelsuche. Implementiert das Interface Form.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 03.06.09
 */
public class ArticleSearchForm implements Form {
	private Panel maskPanel;
	private HorizontalPanel searchPanel;
	private final Panel containerFormPanel;
	
	public ArticleSearchForm(TabPanel outerTabPanel) {
		containerFormPanel = new FormPanel();
		containerFormPanel.setTitle("Ich suche");
		containerFormPanel.setId("mask-panel"); 
		searchPanel = new HorizontalPanel();
		searchPanel.setSpacing(6);
		getCategories();
		Label searchLabel = new Label("Suche: ");
		TextField searchField = new TextField("", "phrase", 120);
		searchPanel.add(searchLabel);
		searchPanel.add(searchField);
		containerFormPanel.add(searchPanel);

		outerTabPanel.add(containerFormPanel);
	}


	private void getCategories() {
		GuiHelperAsync guiHelper = GWT.create(GuiHelper.class);
		
		guiHelper.getCategories(new AsyncCallback<ArrayList<String>>() {

			public void onFailure(Throwable caught) {
				System.out.println("Fehler: " + caught.getMessage());
			}

			public void onSuccess(ArrayList<String> results) {
				String[] categories = new String[results.size()];
				for (int i = 0;i<results.size();i++){
					categories[i] = results.get(i);
				}
				
				Store quickCategoryStore = new SimpleStore("category", categories);
			    quickCategoryStore.load();
			 
			    final ComboBox quickArticleCategoryCB = new ComboBox();
			    quickArticleCategoryCB.setStore(quickCategoryStore);
			    quickArticleCategoryCB.setDisplayField("category");
			    quickArticleCategoryCB.setMode(ComboBox.LOCAL);
			    quickArticleCategoryCB.setTriggerAction(ComboBox.ALL);
			    quickArticleCategoryCB.setForceSelection(true);
			    quickArticleCategoryCB.setReadOnly(true);
			    quickArticleCategoryCB.setWidth(120);
			    quickArticleCategoryCB.setEmptyText("Kategorie wählen");
			    searchPanel.add(quickArticleCategoryCB);
			    
			    Button quickSearchButton = new Button("Suchen",
						new ButtonListenerAdapter() {
							public void onClick(Button button, EventObject e) {
								ArticleSearchQuery sq = new ArticleSearchQuery();
								sq.setSearchPhrase("");
				                 
								final ExtElement element = Ext.get("mask-panel");  
				                element.mask("sucht...");  
								
				                SearchHandlerAsync searchHandler = GWT
										.create(SearchHandler.class);
								searchHandler.search(sq,
										new AsyncCallback<ArrayList<SearchResult>>() {
											public void onFailure(Throwable caught) {
												System.out.println("neeee: ");
											}

											public void onSuccess(ArrayList<SearchResult> results) {
												SwapWeb.getContentPanel().clear();
												final ExtElement element = Ext.get("mask-panel");  
								                element.unmask();
												for (SearchResult r : results) {
													r.getView();
												}
											}
										});
							}

						});
			    
				quickSearchButton.setIconCls("icon-search");
				searchPanel.add(quickSearchButton);
			    }
			
		});
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
