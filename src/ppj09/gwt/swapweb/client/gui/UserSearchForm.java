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
import com.gwtext.client.widgets.Panel;

/**
 * Formularfelder und Submit der Benutzersuche. Implementiert das Interface Form
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class UserSearchForm extends Composite implements Form {
	private Panel containerPanel;
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
		
			containerPanel = new Panel();
			
			initWidget(containerPanel);
			containerPanel.setTitle("Benutzersuche");
			/*{
				resultsButton = new Button("New button");
				containerPanel.add(resultsButton);
				searchResultPanel = new VerticalPanel();
				containerPanel.add(searchResultPanel);
				resultsButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
							System.out.println("gedrückt");
							*//**
							 * TODO erstellt aus den Formulardaten ein ArticleSearch 
							 * Objekt und übergibt es per RPC an SearchHandler.search()
							 *//*
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
				containerPanel.add(usernameLabel);
			}
			{
				firstNameLabel = new Label("Vorname:");
				containerPanel.add(firstNameLabel);
			}
			{
				lastNameLabel = new Label("Nachname:");
				containerPanel.add(lastNameLabel);
			}
			{
				usernameTextBox = new TextBox();
				containerPanel.add(usernameTextBox);
				usernameTextBox.setWidth("170");
			}
			{
				firstNameTextBox = new TextBox();
				containerPanel.add(firstNameTextBox);
				firstNameTextBox.setWidth("170");
			}
			{
				lastNameTextBox = new TextBox();
				containerPanel.add(lastNameTextBox);
				lastNameTextBox.setWidth("170");
			}
			{
				cityLabel = new Label("Wohnort:");
				containerPanel.add(cityLabel);
			}
			{
				cityTextBox = new TextBox();
				containerPanel.add(cityTextBox);
				cityTextBox.setWidth("170");
			}
			{
				ageLabel = new Label("Alter:");
				containerPanel.add(ageLabel);
			}
			{
				ageComboBox_1 = new ListBox();
				containerPanel.add(ageComboBox_1);
				for (int i=18;i<100;i++)
				{
					ageComboBox_1.addItem(""+i);
				}
				ageComboBox_1.setSize("50", "");
			}
			{
				tillLabel = new Label("bis");
				containerPanel.add(tillLabel);
			}
			{
				ageComboBox_2 = new ListBox();
				containerPanel.add(ageComboBox_2);
				for (int i=99;i>0;i--)
				{
					ageComboBox_2.addItem(""+i);
				}
				ageComboBox_2.setWidth("50");
			}
			{
				jobTextBox = new TextBox();
				containerPanel.add(jobTextBox);
				jobTextBox.setWidth("170");
			}
			{
				jobLabel = new Label("Beruf:");
				containerPanel.add(jobLabel);
			}
			{
				hobbysTextBox = new TextBox();
				containerPanel.add(hobbysTextBox);
				hobbysTextBox.setWidth("170");
			}
			{
				hobbysLabel = new Label("Hobbys:");
				containerPanel.add(hobbysLabel);
			}
			{
				musicTextBox = new TextBox();
				containerPanel.add(musicTextBox);
				musicTextBox.setWidth("170");
			}
			{
				musicLabel = new Label("Musik:");
				containerPanel.add(musicLabel);
			}
			{
				filmTextBox = new TextBox();
				containerPanel.add(filmTextBox);
				filmTextBox.setWidth("170");
			}
			{
				filmLabel = new Label("Film:");
				containerPanel.add(filmLabel);
			}
			{
				activeUsersChckbx = new CheckBox("Nur aktive beenutzer zeigen");
				containerPanel.add(activeUsersChckbx);
				activeUsersChckbx.setSize("197px", "18");
			}
			{
				pictureUsersChckbx = new CheckBox(
						"Nur Benutzer mit Bildern anzeigen");
				containerPanel.add(pictureUsersChckbx);
				pictureUsersChckbx.setSize("226px", "18");
			}
			{
				Label resultLabel = new Label("5 Ergebnisse gefunden");
				containerPanel.add(resultLabel);
				resultLabel.setWidth("150");
			}
			{
				searchResultPanel = new VerticalPanel();
				containerPanel.add(searchResultPanel);
			}
			*/	
	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rueckmeldung
	 */
	public boolean submit() {

		return true;
	}

}
