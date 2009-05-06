package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Daniel Abeska
 * Klasse User- Form ist zum ändern bzw. bearbeiten eines Profils 
 */

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.form.TextField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class UserForm extends Composite implements View {
	private AbsolutePanel absolutePanel;
	private Image Picture;
	private Label lblFilmgeschmack_1;
	private Label lblName;
	private Label lblGeschlecht;
	private Label lblGeburtstag;
	private Label lblBeruf;
	private Label lblHobbys;
	private Label lblMusikgeschmack;
	private Label lblIchmag;
	private Label lblIchMagnicht;
	private Label lbKontakt;
	private Label lblUeberMich;
	private AbsolutePanel absolutePanel_1;
	private TextBox tBox_Beruf;
	private Label lblProfilName;
	private TextBox tBox_Name;
	private TextBox tBox_Geb;
	private Label lblWohnort;
	private TextBox tBox_WohnO;
	private TextArea tArea_Hobby;
	private TextArea tArea_Musik;
	private TextArea tArea_Film;
	private TextArea tArea_Mag;
	private TextArea tArea_MagNicht;
	private TextArea tArea_Kontakt;
	private TextArea tArea_UeberMich;
	private Button Button_Bild;
	private VerticalPanel verticalPanel;
	public UserForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			absolutePanel = new AbsolutePanel();
			verticalPanel.add(absolutePanel);
			absolutePanel.setSize("650px", "700px");
			{
				lblProfilName = new Label("Hans Baembel s Profil");
				absolutePanel.add(lblProfilName, 5, 5);
				lblProfilName.setSize("350", "22");
			}
			{
				Picture = new Image(null);
				absolutePanel.add(Picture, 5, 32);
				Picture.setSize("175px", "175px");
			}
			{
				lblName = new Label("Name:");
				absolutePanel.add(lblName, 220, 95);
				lblName.setWidth("100");
			}
			{
				tBox_Name = new TextBox();
				absolutePanel.add(tBox_Name, 350, 95);
				tBox_Name.setSize("200", "21");
			}
			{
				lblGeschlecht = new Label("Geschlecht:");
				absolutePanel.add(lblGeschlecht, 220, 118);
				lblGeschlecht.setWidth("100");
			}
			{
				lblGeburtstag = new Label("Geburtstag:");
				absolutePanel.add(lblGeburtstag, 220, 141);
				lblGeburtstag.setWidth("100");
			}
			{
				tBox_Geb = new TextBox();
				absolutePanel.add(tBox_Geb, 350, 141);
				tBox_Geb.setSize("200", "21");
			}
			{
				lblWohnort = new Label("Wohnort");
				absolutePanel.add(lblWohnort, 220, 164);
				lblWohnort.setWidth("100");
			}
			{
				tBox_WohnO = new TextBox();
				absolutePanel.add(tBox_WohnO, 350, 164);
				tBox_WohnO.setSize("200", "21");
			}
			{
				lblBeruf = new Label("Beruf:");
				absolutePanel.add(lblBeruf, 220, 187);
				lblBeruf.setWidth("100");
			}
			{
				tBox_Beruf = new TextBox();
				absolutePanel.add(tBox_Beruf, 350, 187);
				tBox_Beruf.setSize("200", "21");
			}
			{
				lblHobbys = new Label("Hobbys:");
				absolutePanel.add(lblHobbys, 220, 210);
				lblHobbys.setWidth("100");
			}
			{
				tArea_Hobby = new TextArea();
				absolutePanel.add(tArea_Hobby, 350, 210);
				tArea_Hobby.setSize("200", "38");
			}
			{
				lblMusikgeschmack = new Label("Musikgeschmack:");
				absolutePanel.add(lblMusikgeschmack, 220, 256);
				lblMusikgeschmack.setWidth("100");
			}
			{
				tArea_Musik = new TextArea();
				absolutePanel.add(tArea_Musik, 350, 256);
				tArea_Musik.setSize("200", "38");
			}
			{
				lblFilmgeschmack_1 = new Label("Filmgeschmack:");
				absolutePanel.add(lblFilmgeschmack_1, 220, 302);
				lblFilmgeschmack_1.setWidth("100");
			}
			{
				tArea_Film = new TextArea();
				absolutePanel.add(tArea_Film, 350, 302);
				tArea_Film.setSize("200", "38");
			}
			{
				lblIchmag = new Label("Ich mag:");
				absolutePanel.add(lblIchmag, 220, 348);
			}
			{
				tArea_Mag = new TextArea();
				absolutePanel.add(tArea_Mag, 350, 348);
				tArea_Mag.setSize("200", "38");
			}
			{
				lblIchMagnicht = new Label("Ich mag nicht:");
				absolutePanel.add(lblIchMagnicht, 220, 394);
				lblIchMagnicht.setWidth("100");
			}
			{
				tArea_MagNicht = new TextArea();
				absolutePanel.add(tArea_MagNicht, 350, 394);
				tArea_MagNicht.setSize("200", "38");
			}
			{
				lbKontakt = new Label("Kontakt:");
				absolutePanel.add(lbKontakt, 220, 440);
				lbKontakt.setWidth("100");
			}
			{
				tArea_Kontakt = new TextArea();
				absolutePanel.add(tArea_Kontakt, 350, 440);
				tArea_Kontakt.setSize("200", "38");
			}
			{
				lblUeberMich = new Label("\u00DCber mich:");
				absolutePanel.add(lblUeberMich, 220, 486);
				lblUeberMich.setWidth("100");
			}
			{
				tArea_UeberMich = new TextArea();
				absolutePanel.add(tArea_UeberMich, 350, 486);
				tArea_UeberMich.setSize("200", "38");
			}
			{
				absolutePanel_1 = new AbsolutePanel();
				absolutePanel.add(absolutePanel_1, 5, 469);
				absolutePanel_1.setSize("650px", "100px");
			}
			{
				Button_Bild = new Button("New button");
				absolutePanel.add(Button_Bild, 5, 212);
				Button_Bild.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						Window.alert("Bild hochgeladen");
					}
				});
				Button_Bild.setText("Bild Hochladen");
				Button_Bild.setSize("175", "25");
			}
			{
				Button Button_BackUp = new Button("New button");
				absolutePanel.add(Button_BackUp, 350, 540);
				Button_BackUp.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						Window.alert("Profil geändert");
					}
				});
				Button_BackUp.setText("Best\u00E4tigen");
				Button_BackUp.setSize("200", "25");
			}
			{
				ListBox comboBox = new ListBox();
				absolutePanel.add(comboBox, 350, 118);
				comboBox.addItem("m\u00E4nnlich");
				comboBox.addItem("weiblich");
				comboBox.setSize("200", "21");
			}
		}
	}
}