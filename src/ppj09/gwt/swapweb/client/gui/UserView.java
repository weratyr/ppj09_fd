package ppj09.gwt.swapweb.client.gui;

/**
 * @author Georg Ortwein, Chrisitan Happ
 * @version 0.1  15.06.09
 * Klasse User- Form ist zum ‰ndern bzw. bearbeiten eines Profils
 */

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.Panel;

public class UserView extends Composite implements View {
	private User user;
	private Label usernameLabel1;
	private Label usernameLabel2;
	private HorizontalPanel horizontalPanel2;
	private AbsolutePanel absolutePanel;
	private HorizontalPanel horizontalPanel;
	private Image image;
	private VerticalPanel verticalPanel_1;
	private VerticalPanel verticalPanel_2;
	private HorizontalPanel hpName;
	private Label lblFirstName;
	private Label lblFirstName2;
	private Label lblLastName;
	private HorizontalPanel hpGender;
	private Label lblGender;
	private Label lblGender2;
	private Label lblBirthday2;
	private HorizontalPanel hpBirthday;
	private Label lblBirthday;
	private Label lblCity2;
	private Label lblCity;
	private HorizontalPanel hpCity;
	private Label lblZip;
	private Label lblHorizontalSeperator2;
	private Label lblHorizontalSeperator;
	private HorizontalPanel hpJob;
	private Label lblJob;
	private Label lblJob2;
	private Label lblHobbys2;
	private HorizontalPanel hpHobbys;
	private Label lblHobbys;
	private HorizontalPanel hpMusic;
	private Label lblMusic;
	private Label lblMusic2;
	private HorizontalPanel hpMovie;
	private Label lblMovie2;
	private Label lblMovie;
	private Label lblILike2;
	private HorizontalPanel hpILike;
	private Label lblILike;
	private HorizontalPanel hpIDontLike;
	private Label lblIDontLike;
	private Label lblIDontLike2;
	private HorizontalPanel hpAboutMe;
	private Label lblAboutMe;
	private Label lblAboutMe2;
	private HorizontalPanel hpIcq;
	private Label lblIcq2;
	private Label lblIcq;
	private HorizontalPanel hpMsn;
	private Label lblMsn2;
	private Label lblMsn;
	private HorizontalPanel hpYahoo;
	private Label lblYahoo2;
	private Label lblYahoo;
	private HorizontalPanel hpAim;
	private Label lblAim2;
	private Label lblAim;
	private HorizontalPanel hpJabber;
	private Label lblJabber;
	private Label lblJabber2;
	private HorizontalPanel hpHomepage;
	private Label lblHomepage2;
	private Label lblHomepage;
	private Label verticalSeperator1;
	private Hyperlink userRatings;
	private Hyperlink messageUser;
	private Hyperlink reportUser;
	private Label verticalSeperatorGender;
	private Label verticalSeperatorBirthday;
	private Label verticalSeperatorHomepage;
	private Label verticalSeperatorJob;
	private Label verticalSeperatorHobbys;
	private Label verticalSeperatorMusic;
	private Label verticalSeperatorMovie;
	private Label verticalSeperatorILike;
	private Label verticalSeperatorIDontLike;
	private Label verticalSeperatorAboutMe;
	private Label verticalSeperatorIcq;
	private Label verticalSeperatorMsn;
	private Label verticalSeperatorYahoo;
	private Label verticalSeperatorAim;
	private Label verticalSeperatorJabber;
	private Panel articlePanel;
	private VerticalPanel verticalPanel;
	private Label usernameLabel3;
	private Label usernameLabel4;

	/**
	 * Constructor
	 * 
	 * @param username
	 * 
	 */

	public UserView() {
		createForm();
		getUser();
	}

	public UserView(String username) {
		getUser(username);
		
		createForm();
		setImage("http://www.weltblick.ch/gallery/albums/pokerreise07/04_Zwei_Trottel_abnormal.jpg");

	}

	public void createForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);

			// Überschrift
			{
				horizontalPanel2 = new HorizontalPanel();
				usernameLabel1 = new Label();
				horizontalPanel2.add(usernameLabel1);
				lblHorizontalSeperator = new Label();
				usernameLabel3 = new Label("'s Profil");
				horizontalPanel2.add(usernameLabel3);
				usernameLabel4 = new Label();
				horizontalPanel2.add(usernameLabel4);

				verticalPanel.add(horizontalPanel2);
			}

			{
				horizontalPanel = new HorizontalPanel();
				verticalPanel.add(horizontalPanel);
				{
					absolutePanel = new AbsolutePanel();
					absolutePanel.setSize("200", "300");

					// Bild
					{
						image = new Image();
						image.setPixelSize(150, 150);
						setImage("http://www.weltblick.ch/gallery/albums/pokerreise07/04_Zwei_Trottel_abnormal.jpg");
						absolutePanel.add(image, 0, 0);
					}

					// Links unter Bild
					{
						verticalPanel_1 = new VerticalPanel();
						verticalPanel_1.setWidth("170");

						messageUser = new Hyperlink();
						verticalPanel_1.add(messageUser);

						userRatings = new Hyperlink();
						verticalPanel_1.add(userRatings);

						reportUser = new Hyperlink();
						verticalPanel_1.add(reportUser);
						absolutePanel.add(verticalPanel_1, 0, 460);
						horizontalPanel.add(absolutePanel);

					}

				}

				{

					verticalPanel_2 = new VerticalPanel();

					// Name
					{
						hpName = new HorizontalPanel();
						lblFirstName = new Label("Name:");
						lblFirstName.setWidth("140");
						hpName.add(lblFirstName);
						lblFirstName2 = new Label();
						hpName.add(lblFirstName2);

						lblHorizontalSeperator = new Label();
						lblHorizontalSeperator.setWidth("5");
						hpName.add(lblHorizontalSeperator);
						lblLastName = new Label();
						hpName.add(lblLastName);

						verticalPanel_2.add(hpName);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

					// Geschlecht
					{
						hpGender = new HorizontalPanel();
						lblGender = new Label("Geschlecht:");
						lblGender.setWidth("140");
						hpGender.add(lblGender);
						lblGender2 = new Label();
						hpGender.add(lblGender2);

						verticalPanel_2.add(hpGender);
						hpGender.setVisible(false);
						verticalSeperatorGender = new Label();
						verticalSeperatorGender.setHeight("5");
						verticalPanel_2.add(verticalSeperatorGender);
						verticalSeperatorGender.setVisible(false);
					}
					// Geburtstag

					{
						hpBirthday = new HorizontalPanel();
						lblBirthday = new Label("Geburtstag:");
						lblBirthday.setWidth("140");
						hpBirthday.add(lblBirthday);
						lblBirthday2 = new Label();
						hpBirthday.add(lblBirthday2);

						verticalPanel_2.add(hpBirthday);
						hpBirthday.setVisible(false);

						verticalSeperatorBirthday = new Label();
						verticalSeperatorBirthday.setHeight("5");
						verticalPanel_2.add(verticalSeperatorBirthday);
						verticalSeperatorBirthday.setVisible(false);
					}

					// Wohnort
					{
						hpCity = new HorizontalPanel();
						lblCity = new Label("Wohnort:");
						lblCity.setWidth("140");
						hpCity.add(lblCity);

						lblZip = new Label();
						hpCity.add(lblZip);

						lblHorizontalSeperator2 = new Label();
						lblHorizontalSeperator2.setWidth("5");
						hpCity.add(lblHorizontalSeperator2);
						lblHorizontalSeperator2.setVisible(false);

						lblCity2 = new Label();
						hpCity.add(lblCity2);

						verticalPanel_2.add(hpCity);

						verticalSeperator1 = new Label();
						verticalSeperator1.setHeight("5");
						verticalPanel_2.add(verticalSeperator1);
					}

					// Homepage
					{
						hpHomepage = new HorizontalPanel();
						lblHomepage = new Label("Homepage:");
						lblHomepage.setWidth("140");
						hpHomepage.add(lblHomepage);

						lblHomepage2 = new Label();
						hpHomepage.add(lblHomepage2);

						verticalPanel_2.add(hpHomepage);
						hpHomepage.setVisible(false);

						verticalSeperatorHomepage = new Label();
						verticalSeperatorHomepage.setHeight("5");
						verticalPanel_2.add(verticalSeperatorHomepage);
						verticalSeperatorHomepage.setVisible(false);
					}

					// Beruf
					{
						hpJob = new HorizontalPanel();
						lblJob = new Label("Beruf:");
						lblJob.setWidth("140");
						hpJob.add(lblJob);

						lblJob2 = new Label();
						hpJob.add(lblJob2);

						verticalPanel_2.add(hpJob);
						hpJob.setVisible(false);

						verticalSeperatorJob = new Label();
						verticalSeperatorJob.setHeight("5");
						verticalPanel_2.add(verticalSeperatorJob);
						verticalSeperatorJob.setVisible(false);
					}

					// Hobbys
					{
						hpHobbys = new HorizontalPanel();
						lblHobbys = new Label("Hobbys:");
						lblHobbys.setWidth("140");
						hpHobbys.add(lblHobbys);
						lblHobbys2 = new Label();
						lblHobbys2.setWidth("250");
						hpHobbys.add(lblHobbys2);

						verticalPanel_2.add(hpHobbys);
						hpHobbys.setVisible(false);

						verticalSeperatorHobbys = new Label();
						verticalSeperatorHobbys.setHeight("5");
						verticalPanel_2.add(verticalSeperatorHobbys);
						verticalSeperatorHobbys.setVisible(false);
					}

					// Musikgeschmack

					{
						hpMusic = new HorizontalPanel();
						lblMusic = new Label("Musikgeschmack:");
						lblMusic.setWidth("140");
						hpMusic.add(lblMusic);
						lblMusic2 = new Label();
						lblMusic2.setWidth("250");
						hpMusic.add(lblMusic2);

						verticalPanel_2.add(hpMusic);
						hpMusic.setVisible(false);

						verticalSeperatorMusic = new Label();
						verticalSeperatorMusic.setHeight("5");
						verticalPanel_2.add(verticalSeperatorMusic);
						verticalSeperatorMusic.setVisible(false);
					}

					// Filmgeschmack
					{
						hpMovie = new HorizontalPanel();
						lblMovie = new Label("Filmgeschmack:");
						lblMovie.setWidth("140");
						hpMovie.add(lblMovie);
						lblMovie2 = new Label();
						lblMovie2.setWidth("250");
						hpMovie.add(lblMovie2);

						verticalPanel_2.add(hpMovie);
						hpMovie.setVisible(false);

						verticalSeperatorMovie = new Label();
						verticalSeperatorMovie.setHeight("5");
						verticalPanel_2.add(verticalSeperatorMovie);
						verticalSeperatorMovie.setVisible(false);
					}

					// Ich mag
					{
						hpILike = new HorizontalPanel();
						lblILike = new Label("Ich mag:");
						lblILike.setWidth("140");
						hpILike.add(lblILike);
						lblILike2 = new Label();
						lblILike2.setWidth("250");
						hpILike.add(lblILike2);

						verticalPanel_2.add(hpILike);
						hpILike.setVisible(false);

						verticalSeperatorILike = new Label();
						verticalSeperatorILike.setHeight("5");
						verticalPanel_2.add(verticalSeperatorILike);
						verticalSeperatorILike.setVisible(false);
					}

					// Ich mag nicht
					{
						hpIDontLike = new HorizontalPanel();
						lblIDontLike = new Label("Ich mag nicht:");
						lblIDontLike.setWidth("140");
						hpIDontLike.add(lblIDontLike);
						lblIDontLike2 = new Label();
						lblIDontLike2.setWidth("250");
						hpIDontLike.add(lblIDontLike2);

						verticalPanel_2.add(hpIDontLike);
						hpIDontLike.setVisible(false);

						verticalSeperatorIDontLike = new Label();
						verticalSeperatorIDontLike.setHeight("5");
						verticalPanel_2.add(verticalSeperatorIDontLike);
						verticalSeperatorIDontLike.setVisible(false);
					}

					// Über mich
					{
						hpAboutMe = new HorizontalPanel();
						lblAboutMe = new Label("\u00dcber mich:");
						lblAboutMe.setWidth("140");
						hpAboutMe.add(lblAboutMe);
						hpAboutMe.setTitle("Über mich:");
						lblAboutMe2 = new Label();
						lblAboutMe2.setWidth("250");
						hpAboutMe.add(lblAboutMe2);

						verticalPanel_2.add(hpAboutMe);
						hpAboutMe.setVisible(false);

						verticalSeperatorAboutMe = new Label();
						verticalSeperatorAboutMe.setHeight("5");
						verticalPanel_2.add(verticalSeperatorAboutMe);
						verticalSeperatorAboutMe.setVisible(false);
					}

					// Icq
					{
						hpIcq = new HorizontalPanel();
						lblIcq = new Label("ICQ:");
						lblIcq.setWidth("140");
						hpIcq.add(lblIcq);
						lblIcq2 = new Label();
						lblIcq2.setWidth("250");
						hpIcq.add(lblIcq2);

						verticalPanel_2.add(hpIcq);
						hpIcq.setVisible(false);

						verticalSeperatorIcq = new Label();
						verticalSeperatorIcq.setHeight("5");
						verticalPanel_2.add(verticalSeperatorIcq);
						verticalSeperatorIcq.setVisible(false);
					}

					// Msn
					{
						hpMsn = new HorizontalPanel();
						lblMsn = new Label("MSN:");
						lblMsn.setWidth("140");
						hpMsn.add(lblMsn);
						lblMsn2 = new Label();
						lblMsn2.setWidth("250");
						hpMsn.add(lblMsn2);

						verticalPanel_2.add(hpMsn);
						hpMsn.setVisible(false);

						verticalSeperatorMsn = new Label();
						verticalSeperatorMsn.setHeight("5");
						verticalPanel_2.add(verticalSeperatorMsn);
						verticalSeperatorMsn.setVisible(false);
					}

					// Yahoo
					{
						hpYahoo = new HorizontalPanel();
						lblYahoo = new Label("Yahoo:");
						lblYahoo.setWidth("140");
						hpYahoo.add(lblYahoo);
						lblYahoo2 = new Label();
						lblYahoo2.setWidth("250");
						hpYahoo.add(lblYahoo2);

						verticalPanel_2.add(hpYahoo);
						hpYahoo.setVisible(false);

						verticalSeperatorYahoo = new Label();
						verticalSeperatorYahoo.setHeight("5");
						verticalPanel_2.add(verticalSeperatorYahoo);
						verticalSeperatorYahoo.setVisible(false);
					}

					// AIM
					{
						hpAim = new HorizontalPanel();
						lblAim = new Label("AIM:");
						lblAim.setWidth("140");
						hpAim.add(lblAim);
						lblAim2 = new Label();
						lblAim2.setWidth("250");
						hpAim.add(lblAim2);

						verticalPanel_2.add(hpAim);
						hpAim.setVisible(false);

						verticalSeperatorAim = new Label();
						verticalSeperatorAim.setHeight("5");
						verticalPanel_2.add(verticalSeperatorAim);
						verticalSeperatorAim.setVisible(false);
					}

					// Jabber
					{
						hpJabber = new HorizontalPanel();
						lblJabber = new Label("Jabber:");
						lblJabber.setWidth("140");
						hpJabber.add(lblJabber);
						lblJabber2 = new Label();
						lblJabber2.setWidth("250");
						hpJabber.add(lblJabber2);

						verticalPanel_2.add(hpJabber);
						hpJabber.setVisible(false);

						verticalSeperatorJabber = new Label();
						verticalSeperatorJabber.setHeight("5");
						verticalPanel_2.add(verticalSeperatorJabber);
						verticalSeperatorJabber.setVisible(false);
					}
					horizontalPanel.add(verticalPanel_2);
				}

			}
		}

		// Artikel Panel
		{
			articlePanel = new Panel();
			articlePanel.setPaddings(10);
			articlePanel.setTitle("Meine Tauschartikel");
			articlePanel.setCollapsible(true);
			articlePanel.setWidth(670);
			verticalPanel.add(articlePanel);
		}
	}

	private VerticalPanel getArtikelListe() {
		final VerticalPanel userArticleList = new VerticalPanel();

		/**
		 * TODO erstellt aus den Formulardaten ein ArticleSearch Objekt und
		 * übergibt es per RPC an SearchHandler.search()
		 */
		ArticleSearchQuery sq = new ArticleSearchQuery();
		sq.setUserName(user.getUsername());
		SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);

		searchHandler.search(sq, new AsyncCallback<ArrayList<SearchResult>>() {
			public void onFailure(Throwable caught) {
				System.out
				.println("RPC UserView: fehler im user article liste");
			}

			public void onSuccess(ArrayList<SearchResult> results) {
				for (SearchResult r : results) {
					userArticleList.add((ArticleSearchResultView) r.getView());
				}
			}
		});
		return userArticleList;
	}

	private void getUser(String username) {
		UserManagerAsync userManager = GWT.create(UserManager.class);

		userManager.getUser(username, new AsyncCallback<User>() {
			public void onFailure(Throwable caught) {
				// :(
				System.out.println("fehler: userView getUser(String username)");
			}

			public void onSuccess(User userProfile) {
				// :)
				user = userProfile;
				SwapWeb.getContentPanel().setTitle(user.getUsername()+"´s Profil");
				fillForm();
			}
		});
	}

	private void getUser() {
		UserManagerAsync userManager = GWT.create(UserManager.class);

		userManager.getUser(new AsyncCallback<User>() {
			public void onFailure(Throwable caught) {
				// :(
				System.out.println("fehler: getUser() :"+caught.getMessage());

			}

			public void onSuccess(User userProfile) {
				// :)
				user = userProfile;
				fillForm();
				setUserName(user.getUsername());
			}
		});
		
	}

	public void fillForm() {
		articlePanel.add(getArtikelListe());
		articlePanel.doLayout();

		try {
			lblFirstName2.setText(user.getFirstName());
		} catch (NullPointerException e) {
		}
		try {
			lblLastName.setText(user.getLastName());
		} catch (NullPointerException e) {
		}
		try {
			lblZip.setText(user.getZip());
		} catch (NullPointerException e) {
		}

		try {
			lblCity2.setText(user.getCity());
		} catch (NullPointerException e) {
		}
		try {
			usernameLabel2.setText(user.getUsername());
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getGender() == null)) {
				lblGender2.setText(user.getGender());
				hpGender.setVisible(true);
				verticalSeperatorGender.setVisible(true);
			}

		} catch (NullPointerException e) {
		}
		// try {
		// if (user.getBirthdate().equals("")) {
		// setBirthdate(user.getBirthdate());
		// hpBirthday.setVisible(true);
		// verticalSeperatorBirthday.setVisible(true);
		// }
		// } catch (NullPointerException e) {
		// }
		try {

			if (!(user.getJob() == null)) {
				lblJob2.setText(user.getJob());
				hpJob.setVisible(true);
				verticalSeperatorJob.setVisible(true);

			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getHomepage() == null)) {
				lblHomepage2.setText(user.getHomepage());
				hpHomepage.setVisible(true);
				verticalSeperatorHomepage.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getHobbys() == null)) {
				lblHobbys2.setText(user.getHobbys());
				hpHobbys.setVisible(true);
				verticalSeperatorHobbys.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getMusic() == null)) {
				lblMusic2.setText(user.getMusic());
				hpMusic.setVisible(true);
				verticalSeperatorMusic.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getMovie() == null)) {
				lblMovie2.setText(user.getMovie());
				hpMusic.setVisible(true);
				verticalSeperatorMovie.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getILike() == null)) {
				lblILike2.setText(user.getILike());
				hpILike.setVisible(true);
				verticalSeperatorILike.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getIDontLike() == null)) {
				lblIDontLike2.setText(user.getIDontLike());
				hpIDontLike.setVisible(true);
				verticalSeperatorIDontLike.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getIcq() == null)) {
				lblIcq2.setText(user.getIcq());
				hpIcq.setVisible(true);
				verticalSeperatorIcq.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getMsn() == null)) {
				lblMsn2.setText(user.getMsn());
				hpMsn.setVisible(true);
				verticalSeperatorMsn.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getYahoo() == null)) {
				lblYahoo2.setText(user.getYahoo());
				hpYahoo.setVisible(true);
				verticalSeperatorYahoo.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getAim() == null)) {
				lblAim2.setText(user.getAim());
				hpAim.setVisible(true);
				verticalSeperatorAim.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getJabber() == null)) {
				lblJabber2.setText(user.getJabber());
				hpJabber.setVisible(true);
				verticalSeperatorJabber.setVisible(true);
			}
		} catch (NullPointerException e) {
		}
		try {
			if (!(user.getImage() == null)) {
				setImage(user.getImage());

			}
		} catch (NullPointerException e) {
		}

	}

	public void setUserName(String userName) {
		articlePanel.setTitle(userName + "'s Artikel");
		this.messageUser.setText("Nachricht an " + userName);
		this.userRatings.setText(userName + "'s Bewertungen");
		this.reportUser.setText(userName + " melden");
	}

	public void setImage(String imageurl) {
		this.image.setUrl(imageurl);
	}
}