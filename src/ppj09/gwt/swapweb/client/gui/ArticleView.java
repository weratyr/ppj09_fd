package ppj09.gwt.swapweb.client.gui;



import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.AbsolutePanel;

import com.google.gwt.user.client.ui.Image;

import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.Hyperlink;

import com.google.gwt.user.client.ui.DockPanel;



public class ArticleView extends Composite implements View {

	private DockPanel dockPanel;
	private AbsolutePanel absolutePanelNorth;
	private AbsolutePanel absolutePanelSouth;
	private Label lblArtName;
	private Label lblArtikelNrBez;
	private Label lblArtNr;
	private Label lblBeschreibungBez;
	private Label lblBeschreibung;
	private AbsolutePanel absolutePanelWest;
	private Image imgArtikle;
	private AbsolutePanel absolutePanelCenter;
	private Label lblOfferer;
	private Hyperlink hblOfferer;
	private Image imgStars;
	private Label lblRateBez;
	private Label lblProzPos;
	private Label lblProzPosBez;
	private Label lblPozNeg;
	private Label lblPozNegBez;
	private Hyperlink hplMail;
	private Label lblStandortBez;
	private Label lblStandort;
	private Label lblZustandBez;
	private Label lblZustand;
	private Label lblVersandBez;
	private Label lblVersand;
	private Label lblUmfangBez;
	private Label lblUmfang;
	private Label lblGegentauschBez;
	private Label lblGegentausch;
	private Label lblBesonderhBez;
	private Label lblBesonderh;

	

	public ArticleView() {

		{

			dockPanel = new DockPanel();

			initWidget(dockPanel);

			dockPanel.setSize("650px", "400px");

			{

				absolutePanelNorth = new AbsolutePanel();

				dockPanel.add(absolutePanelNorth, DockPanel.NORTH);

				absolutePanelNorth.setHeight("32px");

				{

					lblArtName = new Label("Testartikelname");

					absolutePanelNorth.add(lblArtName, 5, 5);

					lblArtName.setSize("367px", "21px");

				}

				{

					lblArtikelNrBez = new Label("Artikelnr.:");

					absolutePanelNorth.add(lblArtikelNrBez, 377, 5);

				}

				{

					lblArtNr = new Label("123456789");

					absolutePanelNorth.add(lblArtNr, 447, 5);

					lblArtNr.setSize("98px", "21px");

				}

			}

			{

				absolutePanelSouth = new AbsolutePanel();

				dockPanel.add(absolutePanelSouth, DockPanel.SOUTH);

				absolutePanelSouth.setSize("548px", "233px");

				{

					lblBeschreibungBez = new Label("\u00DCber das Angebot:");

					absolutePanelSouth.add(lblBeschreibungBez, 5, 5);

					lblBeschreibungBez.setHeight("18");

				}

				{

					lblBeschreibung = new Label("Hier steht eine lange Beschreibung, die meistens sowieso keinen interessiert und deshalb total \u00FCberfl\u00FCssig ist!!!!!");

					absolutePanelSouth.add(lblBeschreibung, 5, 26);

					lblBeschreibung.setSize("538px", "202px");

				}

			}

			{

				absolutePanelWest = new AbsolutePanel();

				dockPanel.add(absolutePanelWest, DockPanel.WEST);

				absolutePanelWest.setSize("150px", "272px");

				{

					imgArtikle = new Image(null);

					absolutePanelWest.add(imgArtikle, 5, 5);

					imgArtikle.setSize("131px", "112px");

				}

			}

			{

				absolutePanelCenter = new AbsolutePanel();

				dockPanel.add(absolutePanelCenter, DockPanel.CENTER);

				absolutePanelCenter.setSize("400px", "272px");

				{

					lblOfferer = new Label("Anbieter:");

					absolutePanelCenter.add(lblOfferer, 5, 5);

					lblOfferer.setHeight("18");

				}

				{

					hblOfferer = new Hyperlink("New hyperlink", false, "newHistoryToken");

					absolutePanelCenter.add(hblOfferer, 73, 5);

					hblOfferer.setSize("158px", "18px");

					hblOfferer.setHTML("Stefan Elm");

				}

				{

					imgStars = new Image(null);

					absolutePanelCenter.add(imgStars, 307, 27);

					imgStars.setSize("88px", "21px");

				}

				{

					lblRateBez = new Label("Bewertungen:");

					absolutePanelCenter.add(lblRateBez, 5, 27);

					lblRateBez.setHeight("18");

				}

				{

					lblProzPos = new Label("100");

					absolutePanelCenter.add(lblProzPos, 109, 27);

					lblProzPos.setHeight("18");

				}

				{

					lblProzPosBez = new Label("% positiv");

					absolutePanelCenter.add(lblProzPosBez, 136, 27);

					lblProzPosBez.setHeight("18");

				}

				{

					lblPozNeg = new Label("100");

					absolutePanelCenter.add(lblPozNeg, 201, 27);

					lblPozNeg.setHeight("18");

				}

				{

					lblPozNegBez = new Label("% negativ");

					absolutePanelCenter.add(lblPozNegBez, 228, 27);

					lblPozNegBez.setHeight("18");

				}

				{

					hplMail = new Hyperlink("New hyperlink", false, "newHistoryToken");

					absolutePanelCenter.add(hplMail, 5, 47);

					hplMail.setHTML("Nachricht an den Anbieter");

				}

				{

					lblStandortBez = new Label("Standort:");

					absolutePanelCenter.add(lblStandortBez, 5, 80);

					lblStandortBez.setHeight("18");

				}

				{

					lblStandort = new Label("Frankfurt");

					absolutePanelCenter.add(lblStandort, 73, 80);

					lblStandort.setSize("300px", "18px");

				}

				{

					lblZustandBez = new Label("Zustand:");

					absolutePanelCenter.add(lblZustandBez, 5, 98);

					lblZustandBez.setHeight("18");

				}

				{

					lblZustand = new Label("gebraucht");

					absolutePanelCenter.add(lblZustand, 73, 98);

					lblZustand.setSize("300", "18");

				}

				{

					lblVersandBez = new Label("Versand:");

					absolutePanelCenter.add(lblVersandBez, 5, 116);

					lblVersandBez.setHeight("18");

				}

				{

					lblVersand = new Label("Nur per Post");

					absolutePanelCenter.add(lblVersand, 73, 116);

					lblVersand.setSize("300", "18");

				}

				{

					lblUmfangBez = new Label("Angebotsumfang:");

					absolutePanelCenter.add(lblUmfangBez, 5, 133);

					lblUmfangBez.setHeight("18");

				}

				{

					lblUmfang = new Label("Testartikel mit allen m\u00F6glichen Testzugaben");

					absolutePanelCenter.add(lblUmfang, 5, 152);

					lblUmfang.setSize("390px", "18px");

				}

				{

					lblGegentauschBez = new Label("Gegentauschvorstellungen:");

					absolutePanelCenter.add(lblGegentauschBez, 5, 170);

					lblGegentauschBez.setHeight("18");

				}

				{

					lblGegentausch = new Label("Alles, auser das was ich nicht haben will");

					absolutePanelCenter.add(lblGegentausch, 5, 190);

					lblGegentausch.setSize("390px", "18px");

				}

				{

					lblBesonderhBez = new Label("Besonderheiten:");

					absolutePanelCenter.add(lblBesonderhBez, 5, 208);

					lblBesonderhBez.setHeight("18");

				}

				{

					lblBesonderh = new Label("Das Ger\u00E4t ist kaputt");

					absolutePanelCenter.add(lblBesonderh, 5, 227);

					lblBesonderh.setSize("390px", "21px");

				}

			}

		}

	}



	public void setHblOfferer(String hblOfferer) {

		this.hblOfferer.setText(hblOfferer);

	}



	public void setLblArtName(String lblArtName) {

		this.lblArtName.setText(lblArtName);

	}



	public void setLblArtNr(String lblArtNr) {

		this.lblArtNr.setText(lblArtNr);

	}



	public void setLblBeschreibung(String lblBeschreibung) {

		this.lblBeschreibung.setText(lblBeschreibung);

	}



	public void setImgArtikle(Image imgArtikle) {

		this.imgArtikle = imgArtikle;

	}



	public void setImgStars(Image imgStars) {

		this.imgStars = imgStars;

	}



	public void setLblProzPos(String lblProzPos) {

		this.lblProzPos.setText(lblProzPos);

	}



	public void setLblPozNeg(String lblPozNeg) {

		this.lblPozNeg.setText(lblPozNeg);

	}



	public void setLblStandort(String lblStandort) {

		this.lblStandort.setText(lblStandort);

	}



	public void setLblZustand(String lblZustand) {

		this.lblZustand.setText(lblZustand);

	}



	public void setLblVersand(String lblVersand) {

		this.lblVersand.setText(lblVersand);

	}



	public void setLblUmfang(String lblUmfang) {

		this.lblUmfang.setText(lblUmfang);

	}



	public void setLblGegentausch(String lblGegentausch) {

		this.lblGegentausch.setText(lblGegentausch);

	}



	public void setLblBesonderh(String lblBesonderh) {

		this.lblBesonderh.setText(lblBesonderh);

	}

}

