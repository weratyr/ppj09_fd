/*
 * @(#)UserSearchForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Formularfelder und Submit der Benutzersuche. Implementiert das Interface Form
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 */
public class UserSearchForm extends Composite implements Form {
	private AbsolutePanel absolutePanel;
	private Button resultsButton;
	private Label usernameLabel;
	private Label firstNameLabel;
	private Label lastNameLabel;
	private TextBox usernameTextBox;
	private TextBox firstNameTextBox;
	private TextBox lastNameTextBox;
	private Label cityLabel;
	private TextBox cityTextBox;
	private Label ageLabel;
	private ListBox ageComboBox_1;
	private Label tillLabel;
	private ListBox ageComboBox_2;
	private TextBox jobTextBox;
	private Label jobLabel;
	private TextBox hobbysTextBox;
	private Label hobbysLabel;
	private TextBox musicTextBox;
	private Label musicLabel;
	private TextBox filmTextBox;
	private Label filmLabel;
	private CheckBox activeUsersChckbx;
	private CheckBox pictureUsersChckbx;

	public UserSearchForm() {
		{
			absolutePanel = new AbsolutePanel();
			initWidget(absolutePanel);
			absolutePanel.setSize("700", "500");
			{
				resultsButton = new Button("New button");
				absolutePanel.add(resultsButton, 333, 213);
				resultsButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						// TODO
					}
				});
				resultsButton.setSize("150px", "25");
				resultsButton.setText("Ergebnisse Anzeigen");
			}
			{
				usernameLabel = new Label("Benutzer:");
				absolutePanel.add(usernameLabel, 19, 7);
			}
			{
				firstNameLabel = new Label("Vorname:");
				absolutePanel.add(firstNameLabel, 19, 35);
			}
			{
				lastNameLabel = new Label("Nachname:");
				absolutePanel.add(lastNameLabel, 9, 60);
			}
			{
				usernameTextBox = new TextBox();
				absolutePanel.add(usernameTextBox, 80, 5);
				usernameTextBox.setWidth("170");
			}
			{
				firstNameTextBox = new TextBox();
				absolutePanel.add(firstNameTextBox, 80, 31);
				firstNameTextBox.setWidth("170");
			}
			{
				lastNameTextBox = new TextBox();
				absolutePanel.add(lastNameTextBox, 80, 57);
				lastNameTextBox.setWidth("170");
			}
			{
				cityLabel = new Label("Wohnort:");
				absolutePanel.add(cityLabel, 23, 87);
			}
			{
				cityTextBox = new TextBox();
				absolutePanel.add(cityTextBox, 80, 84);
				cityTextBox.setWidth("170");
			}
			{
				ageLabel = new Label("Alter:");
				absolutePanel.add(ageLabel, 80, 114);
			}
			{
				ageComboBox_1 = new ListBox();
				absolutePanel.add(ageComboBox_1, 115, 112);
				ageComboBox_1.addItem("18");
				ageComboBox_1.addItem("19");
				ageComboBox_1.addItem("20");
				ageComboBox_1.addItem("21");
				ageComboBox_1.addItem("22");
				ageComboBox_1.addItem("23");
				ageComboBox_1.addItem("24");
				ageComboBox_1.addItem("25");
				ageComboBox_1.addItem("26");
				ageComboBox_1.addItem("27");
				ageComboBox_1.addItem("28");
				ageComboBox_1.addItem("29");
				ageComboBox_1.addItem("30");
				ageComboBox_1.addItem("31");
				ageComboBox_1.addItem("32");
				ageComboBox_1.addItem("33");
				ageComboBox_1.addItem("34");
				ageComboBox_1.addItem("35");
				ageComboBox_1.addItem("36");
				ageComboBox_1.addItem("37");
				ageComboBox_1.addItem("38");
				ageComboBox_1.addItem("39");
				ageComboBox_1.addItem("40");
				ageComboBox_1.addItem("41");
				ageComboBox_1.addItem("42");
				ageComboBox_1.addItem("43");
				ageComboBox_1.addItem("44");
				ageComboBox_1.addItem("45");
				ageComboBox_1.addItem("46");
				ageComboBox_1.addItem("47");
				ageComboBox_1.addItem("48");
				ageComboBox_1.addItem("49");
				ageComboBox_1.addItem("50");
				ageComboBox_1.addItem("51");
				ageComboBox_1.addItem("52");
				ageComboBox_1.addItem("53");
				ageComboBox_1.addItem("54");
				ageComboBox_1.addItem("55");
				ageComboBox_1.addItem("56");
				ageComboBox_1.addItem("57");
				ageComboBox_1.addItem("58");
				ageComboBox_1.addItem("59");
				ageComboBox_1.addItem("60");
				ageComboBox_1.addItem("61");
				ageComboBox_1.addItem("62");
				ageComboBox_1.addItem("63");
				ageComboBox_1.addItem("64");
				ageComboBox_1.addItem("65");
				ageComboBox_1.addItem("66");
				ageComboBox_1.addItem("67");
				ageComboBox_1.addItem("68");
				ageComboBox_1.addItem("69");
				ageComboBox_1.addItem("70");
				ageComboBox_1.addItem("71");
				ageComboBox_1.addItem("72");
				ageComboBox_1.addItem("73");
				ageComboBox_1.addItem("74");
				ageComboBox_1.addItem("75");
				ageComboBox_1.addItem("76");
				ageComboBox_1.addItem("77");
				ageComboBox_1.addItem("78");
				ageComboBox_1.addItem("79");
				ageComboBox_1.addItem("80");
				ageComboBox_1.addItem("81");
				ageComboBox_1.addItem("82");
				ageComboBox_1.addItem("83");
				ageComboBox_1.addItem("84");
				ageComboBox_1.addItem("85");
				ageComboBox_1.addItem("86");
				ageComboBox_1.addItem("87");
				ageComboBox_1.addItem("88");
				ageComboBox_1.addItem("89");
				ageComboBox_1.addItem("90");
				ageComboBox_1.addItem("91");
				ageComboBox_1.addItem("92");
				ageComboBox_1.addItem("93");
				ageComboBox_1.addItem("94");
				ageComboBox_1.addItem("95");
				ageComboBox_1.addItem("96");
				ageComboBox_1.addItem("97");
				ageComboBox_1.addItem("98");
				ageComboBox_1.addItem("99");
				ageComboBox_1.setSize("50", "");
			}
			{
				tillLabel = new Label("bis");
				absolutePanel.add(tillLabel, 175, 114);
			}
			{
				ageComboBox_2 = new ListBox();
				absolutePanel.add(ageComboBox_2, 200, 112);
				ageComboBox_2.addItem("99");
				ageComboBox_2.addItem("98");
				ageComboBox_2.addItem("97");
				ageComboBox_2.addItem("96");
				ageComboBox_2.addItem("95");
				ageComboBox_2.addItem("94");
				ageComboBox_2.addItem("93");
				ageComboBox_2.addItem("92");
				ageComboBox_2.addItem("91");
				ageComboBox_2.addItem("90");
				ageComboBox_2.addItem("89");
				ageComboBox_2.addItem("88");
				ageComboBox_2.addItem("87");
				ageComboBox_2.addItem("86");
				ageComboBox_2.addItem("85");
				ageComboBox_2.addItem("84");
				ageComboBox_2.addItem("83");
				ageComboBox_2.addItem("82");
				ageComboBox_2.addItem("81");
				ageComboBox_2.addItem("80");
				ageComboBox_2.addItem("79");
				ageComboBox_2.addItem("78");
				ageComboBox_2.addItem("77");
				ageComboBox_2.addItem("76");
				ageComboBox_2.addItem("75");
				ageComboBox_2.addItem("74");
				ageComboBox_2.addItem("73");
				ageComboBox_2.addItem("72");
				ageComboBox_2.addItem("71");
				ageComboBox_2.addItem("70");
				ageComboBox_2.addItem("69");
				ageComboBox_2.addItem("68");
				ageComboBox_2.addItem("67");
				ageComboBox_2.addItem("66");
				ageComboBox_2.addItem("65");
				ageComboBox_2.addItem("64");
				ageComboBox_2.addItem("63");
				ageComboBox_2.addItem("62");
				ageComboBox_2.addItem("61");
				ageComboBox_2.addItem("60");
				ageComboBox_2.addItem("59");
				ageComboBox_2.addItem("58");
				ageComboBox_2.addItem("57");
				ageComboBox_2.addItem("56");
				ageComboBox_2.addItem("55");
				ageComboBox_2.addItem("54");
				ageComboBox_2.addItem("53");
				ageComboBox_2.addItem("52");
				ageComboBox_2.addItem("51");
				ageComboBox_2.addItem("50");
				ageComboBox_2.addItem("49");
				ageComboBox_2.addItem("48");
				ageComboBox_2.addItem("47");
				ageComboBox_2.addItem("46");
				ageComboBox_2.addItem("45");
				ageComboBox_2.addItem("44");
				ageComboBox_2.addItem("43");
				ageComboBox_2.addItem("42");
				ageComboBox_2.addItem("41");
				ageComboBox_2.addItem("40");
				ageComboBox_2.addItem("39");
				ageComboBox_2.addItem("38");
				ageComboBox_2.addItem("37");
				ageComboBox_2.addItem("36");
				ageComboBox_2.addItem("35");
				ageComboBox_2.addItem("34");
				ageComboBox_2.addItem("33");
				ageComboBox_2.addItem("32");
				ageComboBox_2.addItem("31");
				ageComboBox_2.addItem("30");
				ageComboBox_2.addItem("29");
				ageComboBox_2.addItem("28");
				ageComboBox_2.addItem("27");
				ageComboBox_2.addItem("26");
				ageComboBox_2.addItem("25");
				ageComboBox_2.addItem("24");
				ageComboBox_2.addItem("23");
				ageComboBox_2.addItem("22");
				ageComboBox_2.addItem("21");
				ageComboBox_2.addItem("20");
				ageComboBox_2.addItem("19");
				ageComboBox_2.addItem("18");
				ageComboBox_2.setWidth("50");
			}
			{
				jobTextBox = new TextBox();
				absolutePanel.add(jobTextBox, 80, 136);
				jobTextBox.setWidth("170");
			}
			{
				jobLabel = new Label("Beruf:");
				absolutePanel.add(jobLabel, 40, 139);
			}
			{
				hobbysTextBox = new TextBox();
				absolutePanel.add(hobbysTextBox, 80, 163);
				hobbysTextBox.setWidth("170");
			}
			{
				hobbysLabel = new Label("Hobbys:");
				absolutePanel.add(hobbysLabel, 27, 166);
			}
			{
				musicTextBox = new TextBox();
				absolutePanel.add(musicTextBox, 80, 190);
				musicTextBox.setWidth("170");
			}
			{
				musicLabel = new Label("Musik:");
				absolutePanel.add(musicLabel, 36, 194);
			}
			{
				filmTextBox = new TextBox();
				absolutePanel.add(filmTextBox, 80, 217);
				filmTextBox.setWidth("170");
			}
			{
				filmLabel = new Label("Film:");
				absolutePanel.add(filmLabel, 46, 221);
			}
			{
				activeUsersChckbx = new CheckBox("Nur aktive beenutzer zeigen");
				absolutePanel.add(activeUsersChckbx, 333, 7);
				activeUsersChckbx.setSize("197px", "18");
			}
			{
				pictureUsersChckbx = new CheckBox(
						"Nur Benutzer mit Bildern anzeigen");
				absolutePanel.add(pictureUsersChckbx, 333, 29);
				pictureUsersChckbx.setSize("226px", "18");
			}
			{
				Label resultLabel = new Label("5 Ergebnisse gefunden");
				absolutePanel.add(resultLabel, 333, 190);
				resultLabel.setWidth("150");
			}
		}
	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rueckmeldung
	 */
	public boolean submit() {
		// TODO Auto-generated method stub
		return false;
	}
}
