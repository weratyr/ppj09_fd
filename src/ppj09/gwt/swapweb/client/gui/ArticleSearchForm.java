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
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.KeyListener;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;

/**
 * Formularfelder und Submit der Artikelsuche. Implementiert das Interface Form.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 15.06.09
 */
public class ArticleSearchForm implements Form {
	private HorizontalPanel searchPanel;
	private final Panel containerFormPanel;
	private Panel buttonPanel;
	private ComboBox categoryComboBox;

	private TextField searchField;
	private Button quickSearchButton;

	public ArticleSearchForm(TabPanel outerTabPanel) {
		categoryComboBox = new ComboBox();
		containerFormPanel = new FormPanel();
		containerFormPanel.setTitle("Ich suche");
		containerFormPanel.setId("mask-panel");
		searchPanel = new HorizontalPanel();
		searchPanel.setSpacing(8);

		Label searchLabel = new Label("Suche: ");
		searchField = new TextField("", "phrase", 120);
		searchField.addKeyListener(13, new KeyListener() {
	          public void onKey(int key, EventObject e) {	        	 
	              quickSearchButton.focus();
	            }
	          });
		searchPanel.add(searchLabel);
		searchPanel.add(searchField);
		// holt via rpc die Kategorienliste aus der Datenbank

		buttonPanel = new Panel();
		buttonPanel.setBorder(false);
		searchPanel.add(buttonPanel);

		SwapWeb.getCategories(buttonPanel, categoryComboBox);

		quickSearchButton = new Button("Suchen",
				new ButtonListenerAdapter() {
					public void onClick(Button button, EventObject e) {
						final ArticleSearchQuery sq = new ArticleSearchQuery();
						sq.setSearchPhrase(searchField.getText());
						sq.setCategory(categoryComboBox.getText());

						final ExtElement element = Ext.get("mask-panel");
						element.mask("sucht...");

						SearchHandlerAsync searchHandler = GWT
								.create(SearchHandler.class);
						searchHandler.search(sq,
								new AsyncCallback<ArrayList<SearchResult>>() {
									public void onFailure(Throwable caught) {
										System.out
												.println("RPC ArticleSearchForm: fehler im quickserach ");
									}

									public void onSuccess(
											ArrayList<SearchResult> results) {
										element.unmask();
										Panel cp = SwapWeb.getContentPanel();
										cp.clear();
										Panel listView = new Panel();

										for (SearchResult r : results) {
											listView
													.add((ArticleSearchResultView) r
															.getView());
										}

										cp.add(listView);
										cp.setTitle("Suchergebnisse für \""+searchField.getText()+"\"");
										cp.doLayout();
									}
								});

					}

				});

		quickSearchButton.setIconCls("icon-search");
		searchPanel.add(quickSearchButton);
		containerFormPanel.add(searchPanel);
		outerTabPanel.add(containerFormPanel);
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
