package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;


/**
 * Ein ArticleSearchResult wird benutzt, um Suchergebnisse anzuzeigen.
 * Diese werden dann auf die ArticleSearchResultView geadded.
 * 
 * @author Georg Ortwein
 * @author Projekt Team 4711
 * @version 0.1, 06.05.09
 */

public class ArticleSearchResult extends Composite {
	private VerticalPanel verticalPanel;
	private AbsolutePanel absolutePanel;
	private Image articleImage;
	private Label userLabel;
	private Hyperlink articlenameHyperlink;
	private Label shippingLabel;
	private Hyperlink userHyperlink;
	private Label shippingLabel_1;

	public ArticleSearchResult() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			verticalPanel.setSize("650", "90");
			{
				absolutePanel = new AbsolutePanel();
				verticalPanel.add(absolutePanel);
				absolutePanel.setSize("650", "90");
				{
					articleImage = new Image(null);
					absolutePanel.add(articleImage, 5, 5);
					articleImage.setSize("80", "80");
				}
				{
					userLabel = new Label("Benutzer:");
					absolutePanel.add(userLabel, 105, 40);
				}
				{
					articlenameHyperlink = new Hyperlink("New hyperlink",
							false, "newHistoryToken");
					absolutePanel.add(articlenameHyperlink, 100, 5);
					articlenameHyperlink.setWidth("400");
				}
				{
					shippingLabel = new Label("Versand:");
					absolutePanel.add(shippingLabel, 105, 60);
				}
				{
					userHyperlink = new Hyperlink("New hyperlink", false,
							"newHistoryToken");
					absolutePanel.add(userHyperlink, 180, 40);
					userHyperlink.setWidth("300");
				}
				{
					shippingLabel_1 = new Label("New label");
					absolutePanel.add(shippingLabel_1, 180, 60);
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