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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.BorderLayout;

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

	public UserSearchResultView(final SearchResult searchResult) {
		
			this.searchResult = (UserSearchResult) searchResult;
		
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			verticalPanel.setSize("650", "90");
			verticalPanel.setSpacing(5);
			{
				Panel borderPanel = new Panel();
				absolutePanel = new AbsolutePanel();
				absolutePanel.setSize("650", "90");
				
				{
					userImage = new Image(this.searchResult.getUserPicture());
					absolutePanel.add(userImage, 5, 5);
					userImage.setSize("80", "80");
				}
				{
					userLabel = new Label("Benutzer:");
					absolutePanel.add(userLabel, 100, 10);
					absolutePanel.add(new Label("Vorname: "), 100, 30);
					absolutePanel.add(new Label("Nachname: "), 100, 50);
					absolutePanel.add(new Label("Wohnort: "), 100, 70);
					
				}
				{
					articlenameHyperlink = new Hyperlink(this.searchResult.getUsername(), false, "newHistoryToken");

					articlenameHyperlink.addClickHandler(new ClickHandler() { 
						public void onClick(ClickEvent event) {
							System.out.println("User");
							SwapWeb.getContentPanel().clear();
							SwapWeb.getContentPanel().add(new UserView(((UserSearchResult) searchResult).getUsername() ));
							SwapWeb.getContentPanel().doLayout();
						}
					});
					absolutePanel.add(articlenameHyperlink, 170, 10);
					articlenameHyperlink.setWidth("400");
					Label firstname = new Label(this.searchResult.getFirstname());
					Label lastname = new Label(this.searchResult.getLastname());
					Label city = new Label(this.searchResult.getCity());
					absolutePanel.add(firstname, 170, 30);
					absolutePanel.add(lastname, 170, 50);
					absolutePanel.add(city, 170, 70);
					System.out.println(this.searchResult.getFirstname());
				}
				borderPanel.add(absolutePanel);
				verticalPanel.add(borderPanel);
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
