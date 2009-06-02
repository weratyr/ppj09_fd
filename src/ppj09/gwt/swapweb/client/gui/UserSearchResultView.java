/*
 * @(#)UserSearchResultView.java        20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.UserSearchResult;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Stellt eine Benutzersuchanfrage dar.
 * @author Michael Lukaszczyk
 * @author Projekt Team 4711
 * @version 0.1, 02.06.09
 */
public class UserSearchResultView extends Composite implements SearchResultView {
	private VerticalPanel verticalPanel;
	private AbsolutePanel absolutePanel;
	private Image userImage;
	private Label userLabel;
	private Hyperlink articlenameHyperlink;
	private Label shippingLabel;
	private Hyperlink userHyperlink;
	private Label shippingLabel_1;
	private UserSearchResult searchResult;

	public UserSearchResultView(SearchResult searchResult) {
		{
			this.searchResult = (UserSearchResult) searchResult;
			
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			verticalPanel.setSize("650", "90");
			{
				absolutePanel = new AbsolutePanel();
				SwapWeb.getContenPanel().clear();
				SwapWeb.getContenPanel().add(absolutePanel);
				absolutePanel.setSize("650", "90");
				{
					userImage = new Image(null);
					absolutePanel.add(userImage);
					userImage.setSize("80", "80");
				}
				{
					userLabel = new Label("Benutzer:");
					absolutePanel.add(userLabel);
				}
				{
					userHyperlink = new Hyperlink(this.searchResult.getUsername(), false,
							"newHistoryToken");
					absolutePanel.add(userHyperlink);
					userHyperlink.setWidth("300");
				}
			}
		}
	}

	/**
	 * @return the articlenameHyperlink text
	 */
	public String getArticlename() {
		return articlenameHyperlink.getText();
	}



	/**
	 * @return the userHyperlink text
	 */
	public String getUserName() {
		return userHyperlink.getText();
	}

	/**
	 * @param username
	 *            the userHyperlink to set
	 */
	public void setUsername(String username) {
		this.userHyperlink.setText(username);
	}

	/**
	 * @param articleImage
	 *            the articleImage to set
	 */
	public void setUserImage(Image userImage) {
		this.userImage = userImage;
	}
}
