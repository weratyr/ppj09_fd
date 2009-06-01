package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;


/**
 * Dieser View rendert ein einzelnes Suchergebnis vom Typ ArticleSearchResult.
 * Er wird zusammen mit anderen SearchResults innerhalb einer *SearchResultListView aufgerufen. 
 * 
 * @author Georg, André
 * @version 0.1, 15.05.09
 */

public class ArticleSearchResultView extends Composite implements SearchResultView {
	private VerticalPanel verticalPanel;
	private AbsolutePanel absolutePanel;
	private Image articleImage;
	private Label userLabel;
	private Hyperlink articlenameHyperlink;
	private Label shippingLabel;
	private Hyperlink userHyperlink;
	private Label shippingLabel_1;
	private ArticleSearchResult searchResult;

	public ArticleSearchResultView(SearchResult searchResult) {
		{
			this.searchResult = (ArticleSearchResult) searchResult;
			
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			verticalPanel.setSize("650", "90");
			{
				absolutePanel = new AbsolutePanel();
				verticalPanel.add(absolutePanel);
				absolutePanel.setSize("650", "90");
				{
					articleImage = new Image(null);
					SwapWeb.getContenPanel().add(articleImage);
					articleImage.setSize("80", "80");
				}
				{
					userLabel = new Label("Benutzer:");
					SwapWeb.getContenPanel().add(userLabel);
				}
				{
					articlenameHyperlink = new Hyperlink(this.searchResult.getTitle(), false, "newHistoryToken");
					SwapWeb.getContenPanel().add(articlenameHyperlink);
					articlenameHyperlink.setWidth("400");
				}
				{
					shippingLabel = new Label("Versand:");
					SwapWeb.getContenPanel().add(shippingLabel);
				}
				{
					userHyperlink = new Hyperlink(this.searchResult.getUserName(), false,
							"newHistoryToken");
					SwapWeb.getContenPanel().add(userHyperlink);
					userHyperlink.setWidth("300");
				}
				{
					shippingLabel_1 = new Label("New label");
					SwapWeb.getContenPanel().add(shippingLabel_1);
					shippingLabel_1.setWidth("300");
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
	 * @param articlename
	 *            the articlenameHyperlink to set
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
	 *            the userHyperlink to set
	 */
	public void setUsername(String username) {
		this.userHyperlink.setText(username);
	}

	/**
	 * @return the shippingLabel text
	 */
	public String getShipping() {
		return shippingLabel_1.getText();
	}

	/**
	 * @param shipping
	 *            the shippingLabel to set
	 */
	public void setShipping(String shipping) {
		this.shippingLabel_1.setText(shipping);
	}

	/**
	 * @param articleImage
	 *            the articleImage to set
	 */
	public void setArticleImage(Image articleImage) {
		this.articleImage = articleImage;
	}

}
