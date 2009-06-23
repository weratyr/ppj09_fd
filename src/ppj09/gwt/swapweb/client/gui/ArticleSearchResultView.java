package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;


/**
 * Dieser View rendert ein einzelnes Suchergebnis vom Typ ArticleSearchResult.
 * Er wird zusammen mit anderen SearchResults innerhalb einer *SearchResultListView aufgerufen.
 *
 * @author Georg, Andre, Michael, Chrisitan
 * @version 0.1, 15.05.09
 */

public class ArticleSearchResultView extends Composite implements SearchResultView {
	private VerticalPanel verticalPanel;
	private AbsolutePanel absolutePanel;
	private Image articleImage;
	private Label userLabel;
	private Hyperlink articlenameHyperlink;
	private Label offerScopeLabel;
	private Hyperlink userHyperlink;
	private Label offerScopeLabel2;
	private ArticleSearchResult searchResult;

	public ArticleSearchResultView(final SearchResult searchResult) {
		{
			
			this.searchResult = (ArticleSearchResult) searchResult;
			
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
		
			verticalPanel.setSize("650", "90");
			{
				absolutePanel = new AbsolutePanel();
				absolutePanel.setSize("650", "90");
				{
					articleImage = new Image(this.searchResult.getPictureUrl());
					absolutePanel.add(articleImage, 5, 5);
					articleImage.setSize("80", "80");
				}
				{
					userLabel = new Label("Benutzer:");
					absolutePanel.add(userLabel, 105, 40);
				}
				{
					articlenameHyperlink = new Hyperlink(this.searchResult.getTitle(), false, "newHistoryToken");

					articlenameHyperlink.addClickHandler(new ClickHandler() { 
						public void onClick(ClickEvent event) {
							System.out.println("article");
							SwapWeb.getContentPanel().clear();
							SwapWeb.getContentPanel().add(new ArticleView( ( (ArticleSearchResult) searchResult).getId() ) );
							SwapWeb.getContentPanel().doLayout();
						}
					});
					absolutePanel.add(articlenameHyperlink, 100, 5);
					articlenameHyperlink.setWidth("400");
				}
				{
					offerScopeLabel = new Label("Artikelumfang:");
					absolutePanel.add(offerScopeLabel, 105, 60);
				}
				{
					userHyperlink = new Hyperlink(this.searchResult.getUserName(), false, "newHistoryToken");
					userHyperlink.addClickHandler(new ClickHandler() { 
						public void onClick(ClickEvent event) {
							System.out.println("user");
							SwapWeb.getContentPanel().clear();
							SwapWeb.getContentPanel().add(new UserView(((ArticleSearchResult) searchResult).getUserName()) );
							SwapWeb.getContentPanel().doLayout();
						}
					});
					absolutePanel.add(userHyperlink, 180, 40);
					userHyperlink.setWidth("300");
				}
				{
					offerScopeLabel2 = new Label(this.searchResult.getOfferScope());
					absolutePanel.add(offerScopeLabel2, 195, 60);
					offerScopeLabel2.setWidth("300");
				}
				verticalPanel.add(absolutePanel);
				
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
	 * @param articlename
	 * the articlenameHyperlink to set
	 */
	public void setArticlename(String articlename) {
		this.articlenameHyperlink.setText(articlename);
	}

	/**
	 * @return the userHyperlink text
	 */
	public String getUsername() {
		return userHyperlink.getText();
	}

	/**
	 * @param username
	 * the userHyperlink to set
	 */
	public void setUsername(String username) {
		this.userHyperlink.setText(username);
	}

	/**
	 * @return the shippingLabel text
	 */
	public String getShipping() {
		return offerScopeLabel2.getText();
	}

	/**
	 * @param shipping
	 * the shippingLabel to set
	 */
	public void setShipping(String shipping) {
		this.offerScopeLabel2.setText(shipping);
	}

	/**
	 * @param articleImage
	 * the articleImage to set
	 */
	public void setArticleImage(Image articleImage) {
		this.articleImage = articleImage;
	}

}