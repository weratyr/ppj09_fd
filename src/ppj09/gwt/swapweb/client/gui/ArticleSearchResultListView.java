/*
 * @(#)ArticleSearchResultView.java     20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.SearchResult;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.gwtext.client.widgets.Panel;

/**
 * Zeigt die Suchergebnisse einer Artikelsuche im vertical panel.
 * 
 * @author Georg Ortwein, Christan
 * @author Projekt Team 4711
 * @version 0.1, 08.06.09
 * 
 */
public class ArticleSearchResultListView extends Composite implements SearchResultView {
	private VerticalPanel verticalPanel;
	private HorizontalPanel horizontalPanel;
	private Label searchResultsForLabel;
	private Label searchQueryLabel;
	private Label searchResultsForLabel_2;

	public ArticleSearchResultListView(SearchResult searchResult) {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			verticalPanel.setWidth("650");

			horizontalPanel = new HorizontalPanel();
			verticalPanel.add(horizontalPanel);
			horizontalPanel
					.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			horizontalPanel
					.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

			searchResultsForLabel = new Label("Suchergebnisse f\u00FCr \"");
			SwapWeb.getContentPanel().add(searchResultsForLabel);
			searchResultsForLabel.setHeight("25");

			searchQueryLabel = new Label("New label");
			SwapWeb.getContentPanel().add(searchQueryLabel);
			searchQueryLabel.setHeight("25");

			searchResultsForLabel_2 = new Label(" \"");
			SwapWeb.getContentPanel().add(searchResultsForLabel_2);
			searchResultsForLabel_2.setHeight("25");
		}
	}

	/**
	 * @param searchQuery
	 *            the searchQuery to set
	 */
	public void setSearchQuery(String searchQuery) {
		searchQueryLabel.setText(searchQuery);
	}

	/**
	 * @param result
	 *            the ArticleSearchResult to add
	 */
	public void addSearchResult(ArticleSearchResultView result) {
		verticalPanel.add(result);
	}
}
