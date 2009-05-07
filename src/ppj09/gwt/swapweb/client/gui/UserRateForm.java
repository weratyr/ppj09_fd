package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Diese Klasse gibt die Möglichkeit einen anderen Benutzer zu bewerten.
 * Die Bewertung erfolgt über Sterne (1-5) und über einen Kommentar erfolgen.
 * 
 * @author Florian Liersch
 *
 */
public class UserRateForm extends Composite implements Form{
	
	private Hyperlink userName;
	private Label userToRate;
	private Label lblBewertung;
	private ListBox rateStars;
	private Label lblKommentar;
	private TextBox rateComment;
	private Button submitButton;
	
	public UserRateForm() {
		{
			DockPanel dockPanel = new DockPanel();
			initWidget(dockPanel);
			{
				AbsolutePanel absolutePanel = new AbsolutePanel();
				dockPanel.add(absolutePanel, DockPanel.NORTH);
				absolutePanel.setSize("449px", "37px");
				{
					userToRate = new Label("Zu bewertender Nutzer:");
					absolutePanel.add(userToRate, 5, 5);
					userToRate.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
					userToRate.setWidth("200");
				}
				{
					userName = new Hyperlink("New hyperlink", false, "newHistoryToken");
					absolutePanel.add(userName, 224, 5);
					userName.setText("Benutzername");
					userName.setSize("220px", "21px");
				}
			}
			{
				AbsolutePanel absolutePanel = new AbsolutePanel();
				dockPanel.add(absolutePanel, DockPanel.CENTER);
				absolutePanel.setHeight("179px");
				{
					lblBewertung = new Label("Sterne:");
					absolutePanel.add(lblBewertung, 5, 19);
					lblBewertung.setSize("40", "18");
				}
				{
					rateStars = new ListBox();
					absolutePanel.add(rateStars, 113, 15);
					rateStars.addItem("1");
					rateStars.addItem("2");
					rateStars.addItem("3");
					rateStars.addItem("4");
					rateStars.addItem("5");
					rateStars.setSize("80px", "22");
				}
				{
					lblKommentar = new Label("Kommentar:");
					absolutePanel.add(lblKommentar, 5, 75);
					lblKommentar.setHeight("18");
				}
				{
					rateComment = new TextBox();
					absolutePanel.add(rateComment, 113, 75);
					rateComment.setSize("307px", "21");
				}
				{
					submitButton = new Button("New button");
					absolutePanel.add(submitButton, 113, 123);
					submitButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							submit();
						}
					});
					submitButton.setSize("150", "25");
					submitButton.setText("Nutzer Bewerten");
				}
			}
		}
	}

	/**
	 * Schickt die eingetragenen Daten ab
	 */
	public boolean submit() {
		Window.alert("Nutzer bewertet");
		return false;
	}
	
	/**
	 * @return the comboBox
	 */
	public String getComboBox() {
		return rateStars.getItemText(rateStars.getSelectedIndex());
	}

	/**
	 * @return the lblKommentar
	 */
	public Label getLblKommentar() {
		return lblKommentar;
	}

	/**
	 * @param hyperlink the hyperlink to set
	 */
	public void setHyperlink(Hyperlink hyperlink) {
		this.userName = hyperlink;
	}
}
