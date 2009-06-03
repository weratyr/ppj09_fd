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
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.FitLayout;


/**
 * Formularfelder und Submit der Benutzersuche. Implementiert das Interface Form
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class UserSearchForm extends Composite implements Form {
	private Panel containerPanel;
	private VerticalPanel searchResultPanel;
	

	public UserSearchForm() {
		
			containerPanel = new Panel();
			containerPanel.setLayout(new FitLayout());
			containerPanel.setBorder(false);
			initWidget(containerPanel);
			
		
			HorizontalPanel borderPanel = new HorizontalPanel();
			
			containerPanel.setTitle("Benutzersuche");
			
			FormPanel firstFormPanel = new FormPanel();
			firstFormPanel.setBorder(false);
			firstFormPanel.setLabelAlign(Position.TOP);
			firstFormPanel.setPaddings(10,10,0,0);
			firstFormPanel.add(new TextField("Benutzername", "", 110));
			firstFormPanel.add(new TextField("Vorname", "", 110));
			
			FormPanel secondFormPanel = new FormPanel();
			secondFormPanel.setBorder(false);
			secondFormPanel.setLabelAlign(Position.TOP);
			secondFormPanel.setPaddings(10,10,0,0);
			secondFormPanel.add(new TextField("Nachname", "", 110));
			secondFormPanel.add(new TextField("Wohnort", "", 110));
			
			FormPanel thirdFormPanel = new FormPanel();
			thirdFormPanel.setBorder(false);
			thirdFormPanel.setLabelAlign(Position.TOP);
			thirdFormPanel.setPaddings(10,10,0,0);
			thirdFormPanel.add(new TextField("Job","", 110));
			thirdFormPanel.add(new TextField("Hobbies","", 110));
			
			
			FormPanel fourthFormPanel = new FormPanel();
			fourthFormPanel.setBorder(false);
			fourthFormPanel.setPaddings(10,10,0,0);
			fourthFormPanel.setLabelAlign(Position.TOP);
			Checkbox activeArticleCheckBox = new Checkbox("Nur aktive Artikel anzeigen");
			fourthFormPanel.add(activeArticleCheckBox);
			Checkbox pictureArticlesCheckBox = new Checkbox("Nur mit Bild anzeigen");
			fourthFormPanel.add(pictureArticlesCheckBox);
			
			
			Panel buttonPanel = new Panel();
			buttonPanel.setPaddings(10,0,0,0);
			buttonPanel.setBorder(false);
			Button searchButton = new Button("Suchen", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {

					System.out.println("gedrückt");
					/**
					 * TODO erstellt aus den Formulardaten ein ArticleSearch Objekt
					 * und übergibt es per RPC an SearchHandler.search()
					 */
					SearchHandlerAsync searchHandler = GWT
							.create(SearchHandler.class);
					searchHandler.search(new ArticleSearchQuery(),
							new AsyncCallback<ArrayList<SearchResult>>() {
								public void onFailure(Throwable caught) {
									System.out.println("neeee: ");
								}

								public void onSuccess(
										ArrayList<SearchResult> results) {
									System.out.println("neeee: ");
									for (SearchResult r : results) {
										searchResultPanel.add((Widget) r.getView());
									}
								}
							});
				}

			});
			searchButton.setIconCls("icon-search");
			buttonPanel.add(searchButton);
			fourthFormPanel.add(buttonPanel);
			
			borderPanel.add(firstFormPanel);
			borderPanel.add(secondFormPanel);
			borderPanel.add(thirdFormPanel);
			borderPanel.add(fourthFormPanel);
			
			containerPanel.add(borderPanel);
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
