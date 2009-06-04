package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Georg Ortwein
 * Klasse ArticleView ist zum anzeigen eines Artikels
 */

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.layout.FormLayout;

public class ArticleView extends Composite implements View {
	private Article article;

	private AbsolutePanel absolutePanel;
	private HorizontalPanel horizontalPanel;
	private VerticalPanel verticalPanel_2;
	private HorizontalPanel hpName;
	private Label lblFirstName;
	private Label lblFirstName2;
	private Label lblLastName;
	private Label lblHorizontalSeperator;
	private VerticalPanel verticalPanel;
	private Label lblArticleName;
	private TabPanel imagePanel;
	private Image image1;
	private Image image2;
	private Image image3;

	private Panel ImagePanel2;

	private Panel imagePanel1;

	private Panel ImagePanel3;

	private HorizontalPanel hpLocation;

	private Label lblLocation;

	private Label lblLocation2;

	private HorizontalPanel hpCondition;

	private Label lblCondition2;

	private Label lblCondition;

	private Label verticalSeperator1;

	private HorizontalPanel hpDelivery;

	private Label lblDelivery2;

	private Label lblDelivery;

	private HorizontalPanel hpAmount;

	private Label lblAmount;

	private Label lblAmount2;

	private HorizontalPanel hpSwapIdea;

	private Label lblSwapIdea2;

	private Label lblSwapIdea;

	/**
	 * Constructor
	 * 
	 * @param username
	 * 
	 */

	public ArticleView(int articleId) {

		article = new Article();
		createForm();
		// getArticle(articleId);

	}

	public void createForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);

			// Überschrift
			{
				lblArticleName = new Label("Test");

				verticalPanel.add(lblArticleName);
			}

			{
				horizontalPanel = new HorizontalPanel();
				verticalPanel.add(horizontalPanel);
				{
					absolutePanel = new AbsolutePanel();
					horizontalPanel.add(absolutePanel);
					absolutePanel.setSize("200", "200");

					// Bild
					{
						imagePanel = new TabPanel();
						imagePanel.setWidth(155);
						imagePanel.setTabPosition(Position.BOTTOM);

						image1 = new Image();
						image1.setSize("150", "160");
						image1
								.setUrl("http://www.willgewinnen.at/wp-content/uploads/2008/09/wg_e-gitarre1.jpg");

						imagePanel1 = new Panel();
						imagePanel1.setTitle("Bild 1");
						imagePanel1.add(image1);
						imagePanel.add(imagePanel1);

						image2 = new Image();
						image2.setPixelSize(150, 160);
						image2
								.setUrl("http://www.spiegel.de/img/0,1020,128453,00.jpg");

						ImagePanel2 = new Panel();
						ImagePanel2.setTitle("Bild 2");
						ImagePanel2.add(image2);
						imagePanel.add(ImagePanel2);

						image3 = new Image();
						image3.setPixelSize(150, 160);
						image3
								.setUrl("http://www.willgewinnen.at/wp-content/uploads/2008/09/wg_e-gitarre1.jpg");

						ImagePanel3 = new Panel();
						ImagePanel3.setTitle("Bild 3");
						ImagePanel3.add(image3);
						imagePanel.add(ImagePanel3);

						absolutePanel.add(imagePanel, 0, 0);
					}

				}

				{

					verticalPanel_2 = new VerticalPanel();

					// Standort
					{
						hpLocation = new HorizontalPanel();
						lblLocation = new Label("Standort:");
						lblLocation.setWidth("140");
						hpLocation.add(lblLocation);
						lblLocation2 = new Label();
						hpLocation.add(lblLocation2);

						lblHorizontalSeperator = new Label();
						lblHorizontalSeperator.setWidth("5");
						hpLocation.add(lblHorizontalSeperator);
						
						verticalPanel_2.add(hpLocation);
						
						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);

					}
					
					// Zustand
					{
						hpCondition = new HorizontalPanel();
						lblCondition = new Label("Zutand:");
						lblCondition.setWidth("140");
						hpCondition.add(lblCondition);
						lblCondition2 = new Label();
						hpCondition.add(lblCondition2);

						verticalPanel_2.add(hpCondition);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}
					
					// Versandoptionen
					{
						hpDelivery = new HorizontalPanel();
						lblDelivery = new Label("Versandoptionen:");
						lblDelivery.setWidth("140");
						hpDelivery.add(lblDelivery);
						lblDelivery2 = new Label();
						hpDelivery.add(lblDelivery2);

						verticalPanel_2.add(hpDelivery);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}
					
					
					// Angebotsumfang
					{
						hpAmount = new HorizontalPanel();
						lblAmount = new Label("Angebotsumfang:");
						lblAmount.setWidth("140");
						hpAmount.add(lblAmount);
						lblAmount2 = new Label();
						hpAmount.add(lblAmount2);

						verticalPanel_2.add(hpAmount);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}
					
					// Gegentauschvorstellungen
					{
						hpSwapIdea = new HorizontalPanel();
						lblSwapIdea = new Label("Gegentauschvorstellungen:");
						lblSwapIdea.setWidth("140");
						hpSwapIdea.add(lblSwapIdea);
						lblSwapIdea2 = new Label();
						hpSwapIdea.add(lblSwapIdea2);

						verticalPanel_2.add(hpSwapIdea);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

				}
				horizontalPanel.add(verticalPanel_2);
			}
			
			Panel articleDescription = new Panel();
			articleDescription.setTitle("Über das Angebot:");
			Label label = new Label("bla");
			articleDescription.add(label);
			verticalPanel.add(articleDescription);
			

		}

	}

	private void getArticle(int articleId) {
		ArticleManagerAsync articleManager = GWT.create(UserManager.class);

		articleManager.getArticle(articleId, new AsyncCallback<Article>() {
			public void onFailure(Throwable caught) {
				// :(
				System.out.println("fehler");

			}

			public void onSuccess(Article articleDatatype) {
				// :)
				article = articleDatatype;
				fillForm(articleDatatype);
			}

		});
	}

	private void fillForm(Article article) {
		// TODO Auto-generated method stub

	}

}
