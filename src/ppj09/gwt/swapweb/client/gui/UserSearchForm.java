/*
 * @(#)UserSearchForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.datatype.UserSearchQuery;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Formularfelder und Submit der Benutzersuche. Implementiert das Interface Form
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
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
	private VerticalPanel searchResultPanel;

	public UserSearchForm() {
		{
			absolutePanel = new AbsolutePanel();
			initWidget(absolutePanel);
			absolutePanel.setSize("700", "500");
			{
				resultsButton = new Button("New button");
				absolutePanel.add(resultsButton, 333, 213);
				searchResultPanel = new VerticalPanel();
				absolutePanel.add(searchResultPanel, 5, 160);
				resultsButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
							System.out.println("gedrückt");
							/**
							 * TODO erstellt aus den Formulardaten ein ArticleSearch 
							 * Objekt und übergibt es per RPC an SearchHandler.search()
							 */
							SearchHandlerAsync searchHandler = GWT.create(SearchHandler.class);
							searchHandler.search(new UserSearchQuery(), new AsyncCallback<ArrayList<SearchResult>>() {
								public void onFailure(Throwable caught) {
									System.out.println("neeee: ");
								}
								public void onSuccess(ArrayList<SearchResult> results) {
									System.out.println("neeee: ");
									for (SearchResult r : results) {
										searchResultPanel.add((Widget) r.getView());
										
									}

								}
							});
						}
					});

					resultsButton.setText("gagaga");
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
				for (int i=18;i<100;i++)
				{
					ageComboBox_1.addItem(""+i);
				}
				ageComboBox_1.setSize("50", "");
			}
			{
				tillLabel = new Label("bis");
				absolutePanel.add(tillLabel, 175, 114);
			}
			{
				ageComboBox_2 = new ListBox();
				absolutePanel.add(ageComboBox_2, 200, 112);
				for (int i=99;i>0;i--)
				{
					ageComboBox_2.addItem(""+i);
				}
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
			{
				searchResultPanel = new VerticalPanel();
				absolutePanel.add(searchResultPanel, 5, 160);
			}
		}
	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rueckmeldung
	 */
	public boolean submit() {

	return true;
	}

}

