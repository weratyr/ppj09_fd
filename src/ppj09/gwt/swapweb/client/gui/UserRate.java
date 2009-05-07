package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Diese Klasse zeigt eine Bewertung eines Nutzers an.
 * 
 * @author Florian Liersch
 *
 */
public class UserRate extends Composite{
	
	private AbsolutePanel absolutePanel;
	private Label labelAnzahlSterne;
	private Label labelKommentar;
	private Label starRating;
	private Label labelBewertung;
	private TextArea rateComment;
	private Hyperlink user;
	public UserRate() {
		{
			DockPanel dockPanel = new DockPanel();
			initWidget(dockPanel);
			dockPanel.setSize("522px", "187px");
			{
				absolutePanel = new AbsolutePanel();
				dockPanel.add(absolutePanel, DockPanel.NORTH);
				absolutePanel.setSize("650px", "80");
				{
					labelAnzahlSterne = new Label("Anzahl der Sterne:");
					absolutePanel.add(labelAnzahlSterne, 5, 31);
				}
				{
					labelKommentar = new Label("Kommentar:");
					absolutePanel.add(labelKommentar, 265, 5);
				}
				{
					starRating = new Label("SetNumber 1 - 5");
					absolutePanel.add(starRating, 155, 31);
				}
				{
					labelBewertung = new Label("Bewertung von:");
					absolutePanel.add(labelBewertung, 5, 5);
				}
				{
					rateComment = new TextArea();
					absolutePanel.add(rateComment, 356, 5);
					rateComment.setText("Set Comment");
					rateComment.setSize("289px", "70px");
				}
				{
					user = new Hyperlink("New hyperlink", false, "newHistoryToken");
					absolutePanel.add(user, 155, 5);
					user.setText("Set User");
				}
			}
		}
	}
	
	/**
	 * @return the starRating
	 */
	public Label getStarRating() {
		return starRating;
	}
	
	/**
	 * @param starRating the starRating to set
	 */
	public void setStarRating(String starRating) {
		this.starRating.setText(starRating);
	}
	
	/**
	 * @return the rateComment
	 */
	public String getRateComment() {
		return rateComment.getText();
	}
	
	/**
	 * @param rateComment the rateComment to set
	 */
	public void setRateComment(String rateComment) {
		this.rateComment.setText(rateComment);
	}
	
	/**
	 * @return the user
	 */
	public Hyperlink getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(Hyperlink user) {
		this.user = user;
		//sollte gelöscht werden, nur zur demo bei paul
		this.user.setText(user.getText());
	}
	
	/**
	 * delete me
	 * nur zur demo bei paul
	 */
	public void setUserName(String name){
		this.user.setText(name);
	}
}
