package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.i18n.client.HasDirection;

public class UserView extends Composite implements View {
	private AbsolutePanel absolutePanel;
	private Image userPicture;
	private Hyperlink messageHyperlink;
	private Hyperlink ratingHyperlink;
	private Hyperlink reportHyperlink;
	private Hyperlink Bewertung_Ansicht;
	private Label posRatingLabel;
	private Label filmLabel;
	private Label usernameLabel;
	private Label genderLabel;
	private Label birthdayLabel;
	private Label cityLabel;
	private Label jobLabel;
	private Label hobby2Label;
	private Label musicLabel;
	private Label iLikeLabel;
	private Label iDontLikeLabel;
	private Label contactLabel;
	private Label aboutMeLabel;
	private Label username2Label;
	private Label gender2Label;
	private Label birthday2Label;
	private Label city2Label;
	private Label job2Label;
	private Label music2Label;
	private Label film2Label;
	private Label iLike2Label;
	private Label iDontLike2Label;
	private Label contact2Label;
	private Label aboutMe2Label;
	private AbsolutePanel absolutePanel_1;
	private Image ratingStarsImage;
	private Label posRating2Label;
	private Label neutralRatingLabel;
	private Label neutralRating2Label;
	private Label label;
	private Label negRatingLabel;
	private VerticalPanel verticalPanel;
	private Label profileNameLabel;


	/**
	 * Die Profilansicht eines Benutzers
	 * 
	 * @author Georg Ortwein, Daniel Abeska
	 * @author Projekt Team 4711
	 * @version 0.1, 06.05.09
	 */
	
	
	public UserView() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			absolutePanel = new AbsolutePanel();
			verticalPanel.add(absolutePanel);
			absolutePanel.setSize("650px", "700px");
			{
				userPicture = new Image(null);
				absolutePanel.add(userPicture, 5, 32);
				userPicture.setSize("175px", "175px");
			}
			{
				messageHyperlink = new Hyperlink("New hyperlink", false,
						"newHistoryToken");
				absolutePanel.add(messageHyperlink, 5, 212);
				messageHyperlink.setText("Nachricht schicken");
			}
			{
				ratingHyperlink = new Hyperlink("New hyperlink", false,
						"newHistoryToken");
				absolutePanel.add(ratingHyperlink, 5, 235);
				ratingHyperlink.setText("Bewertungen");
			}
			{
				reportHyperlink = new Hyperlink("New hyperlink", false,
						"newHistoryToken");
				absolutePanel.add(reportHyperlink, 5, 258);
				reportHyperlink.setText("Melden");
			}
			{
				Bewertung_Ansicht = new Hyperlink("New hyperlink", false,
						"newHistoryToken");
				absolutePanel.add(Bewertung_Ansicht, 220, 32);
				Bewertung_Ansicht.setText("6 Bewertungen");
			}
			{
				posRatingLabel = new Label("100");
				absolutePanel.add(posRatingLabel, 220, 55);
				posRatingLabel.setDirection(HasDirection.Direction.RTL);
			}
			{
				usernameLabel = new Label("Name:");
				absolutePanel.add(usernameLabel, 220, 95);
				usernameLabel.setWidth("100");
			}
			{
				username2Label = new Label("Hans Baembel");
				absolutePanel.add(username2Label, 350, 95);
				username2Label.setSize("300", "18");
			}
			{
				genderLabel = new Label("Geschlecht:");
				absolutePanel.add(genderLabel, 220, 118);
				genderLabel.setWidth("100");
			}
			{
				gender2Label = new Label("m\u00E4nnlich");
				absolutePanel.add(gender2Label, 350, 118);
				gender2Label.setSize("300", "18");
			}
			{
				birthdayLabel = new Label("Geburtstag:");
				absolutePanel.add(birthdayLabel, 220, 141);
				birthdayLabel.setWidth("100");
			}
			{
				birthday2Label = new Label("18.01.1965");
				absolutePanel.add(birthday2Label, 350, 141);
				birthday2Label.setSize("150", "18");
			}
			{
				cityLabel = new Label("Wohnort");
				absolutePanel.add(cityLabel, 220, 164);
				cityLabel.setWidth("100");
			}
			{
				city2Label = new Label("Fulda");
				absolutePanel.add(city2Label, 350, 164);
				city2Label.setSize("300", "18");
			}
			{
				jobLabel = new Label("Beruf:");
				absolutePanel.add(jobLabel, 220, 187);
				jobLabel.setWidth("100");
			}
			{
				job2Label = new Label("Trommelbauer");
				absolutePanel.add(job2Label, 350, 187);
				job2Label.setSize("300", "18");
			}

			{
				hobby2Label = new Label("Sport,.....");
				absolutePanel.add(hobby2Label, 350, 210);
				hobby2Label.setSize("300", "18");
			}
			{
				musicLabel = new Label("Musikgeschmack:");
				absolutePanel.add(musicLabel, 220, 256);
				musicLabel.setWidth("100");
			}
			{
				music2Label = new Label("Heino, Wildecker Herzbuben,.....");
				absolutePanel.add(music2Label, 350, 256);
				music2Label.setSize("300", "18");
			}
			{
				filmLabel = new Label("Filmgeschmack:");
				absolutePanel.add(filmLabel, 220, 302);
				filmLabel.setWidth("100");
			}
			{
				film2Label = new Label(
						"Braveheart, K\u00F6nigreich der Himmel,..");
				absolutePanel.add(film2Label, 350, 302);
				film2Label.setSize("300", "18");
			}
			{
				iLikeLabel = new Label("Ich mag:");
				absolutePanel.add(iLikeLabel, 220, 348);
			}
			{
				iLike2Label = new Label("viel,...");
				absolutePanel.add(iLike2Label, 350, 348);
				iLike2Label.setSize("300", "18");
			}
			{
				iDontLikeLabel = new Label("Ich mag nicht:");
				absolutePanel.add(iDontLikeLabel, 220, 394);
				iDontLikeLabel.setWidth("100");
			}
			{
				iDontLike2Label = new Label("viel,..");
				absolutePanel.add(iDontLike2Label, 350, 394);
				iDontLike2Label.setSize("300", "18");
			}
			{
				contactLabel = new Label("Kontakt:");
				absolutePanel.add(contactLabel, 220, 440);
				contactLabel.setWidth("100");
			}
			{
				contact2Label = new Label("hans.baembel@bla.de");
				absolutePanel.add(contact2Label, 350, 440);
				contact2Label.setSize("300", "18");
			}
			{
				aboutMeLabel = new Label("\u00DCber mich:");
				absolutePanel.add(aboutMeLabel, 220, 486);
				aboutMeLabel.setWidth("100");
			}
			{
				aboutMe2Label = new Label("blabla,laber laber,...etc.");
				absolutePanel.add(aboutMe2Label, 350, 486);
				aboutMe2Label.setSize("300", "18");
			}
			{
				absolutePanel_1 = new AbsolutePanel();
				absolutePanel.add(absolutePanel_1, 5, 469);
				absolutePanel_1.setSize("650px", "100px");
			}
			{
				ratingStarsImage = new Image(null);
				absolutePanel.add(ratingStarsImage, 350, 32);
				ratingStarsImage.setSize("40", "18");
			}
			{
				posRating2Label = new Label("% Positiv");
				absolutePanel.add(posRating2Label, 244, 55);
			}
			{
				neutralRatingLabel = new Label("100");
				absolutePanel.add(neutralRatingLabel, 326, 55);
				neutralRatingLabel.setDirection(HasDirection.Direction.RTL);
				neutralRatingLabel.setWidth("25");
			}
			{
				neutralRating2Label = new Label("% Neutral");
				absolutePanel.add(neutralRating2Label, 349, 55);
			}
			{
				label = new Label("100");
				absolutePanel.add(label, 432, 55);
				label.setSize("22", "18");
			}
			{
				negRatingLabel = new Label("% Negativ");
				absolutePanel.add(negRatingLabel, 457, 55);
				negRatingLabel.setSize("100", "18");
			}

			profileNameLabel = new Label("Hans Baembel's Profil");
			absolutePanel.add(profileNameLabel, 5, 5);
			profileNameLabel.setSize("650", "22");
			{
				Label hobbyLabel = new Label("Hobbys:");
				absolutePanel.add(hobbyLabel, 220, 210);
			}
		}
	}

	/**
	 * @return the username text
	 */
	public String getUsername() {
		return this.username2Label.getText();
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username2Label.setText(username);
	}

	/**
	 * @return the gender text
	 */
	public String getGender() {
		return this.gender2Label.getText();
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender2Label.setText(gender);
	}

	/**
	 * @return the job text
	 */
	public String getJob() {
		return this.job2Label.getText();
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setLblBeruf_Ansicht(String job) {
		this.job2Label.setText(job);
	}

	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return this.hobby2Label.getText();
	}

	/**
	 * @param hobby
	 *            the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby2Label.setText(hobby);
	}

	/**
	 * @return the music text
	 */
	public String getMusic() {
		return this.music2Label.getText();
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setLblMusik_Ansicht(String music) {
		this.music2Label.setText(music);
	}

	/**
	 * @return the film text
	 */
	public String getFilm() {
		return film2Label.getText();
	}

	/**
	 * @param film
	 *            the film to set
	 */
	public void setLblFilm_Ansicht(String film) {
		this.film2Label.setText(film);
	}

	/**
	 * @return the iLike
	 */
	public String getILike() {
		return iLike2Label.getText();
	}

	/**
	 * @param iLike
	 *            the iLike to set
	 */
	public void setILike(String iLike) {
		this.iLike2Label.setText(iLike);
	}

	/**
	 * @return the iDontLike text
	 */
	public String getIDontLike() {
		return iDontLike2Label.getText();
	}

	/**
	 * @param iDontLike
	 *            the iDontLike to set
	 */
	public void setIDontLike(String iDontLike) {
		this.iDontLike2Label.setText(iDontLike);
	}

	/**
	 * @return the contact text
	 */
	public String getContact() {
		return contact2Label.getText();
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact2Label.setText(contact);
	}

	/**
	 * @return the aboutMe text
	 */
	public String getAboutMe() {
		return aboutMe2Label.getText();
	}

	/**
	 * @param aboutMe
	 *            the aboutMe to set
	 */
	public void setLblUeberMich_Ansicht(String aboutMe) {
		this.aboutMe2Label.setText(aboutMe);
	}

	/**
	 * @param posRating
	 *            the posRating to set
	 */
	public void setPosRating(String posRating) {
		this.posRating2Label.setText(posRating);
	}

	/**
	 * @return the posRating text
	 */
	public String getPosRating() {
		return posRating2Label.getText();
	}

	/**
	 * @param neutralRating
	 *            the neutralRating to set
	 */
	public void setLblPrzent_Neutral_Bez(String neutralRating) {
		this.neutralRating2Label.setText(neutralRating);
	}

	/**
	 * @return the neutralRating text
	 */
	public String getNeutralRating() {
		return neutralRating2Label.getText();
	}

	/**
	 * @param negRating
	 *            the negRating to set
	 */
	public void setNegRating(String negRating) {
		this.negRatingLabel.setText(negRating);
	}

	/**
	 * @return the neutralRating text
	 */
	public String getNegRating() {
		return negRatingLabel.getText();
	}
}
