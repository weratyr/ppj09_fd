/*
 * @(#)UserSearchForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.UserSearchQuery;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.FitLayout;


/**
 * Formularfelder und Submit der Benutzersuche. Implementiert das Interface Form
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 03.06.09
 */
public class UserSearchForm  implements Form {
	private Panel containerPanel;
	private TextField username;
	private TextField firstname;
	private TextField lastname;
	private TextField city;
	private TextField job;
	private TextField hobbies;
	
	public UserSearchForm(TabPanel tabPanel) {
		
			containerPanel = new Panel();
			containerPanel.setLayout(new FitLayout());
			containerPanel.setBorder(false);
			
			FormPanel borderPanel = new FormPanel();
			borderPanel.setBorder(false);
			
			containerPanel.setTitle("Benutzersuche");
			
			FormPanel firstFormPanel = new FormPanel();
			firstFormPanel.setBorder(false);
			firstFormPanel.setLabelAlign(Position.TOP);
			firstFormPanel.setPaddings(10,10,0,0);
			username = new TextField("Benutzername", "", 110);
			firstFormPanel.add(username);
			firstname = new TextField("Vorname", "", 110);
			firstFormPanel.add(firstname);
			
			FormPanel secondFormPanel = new FormPanel();
			secondFormPanel.setBorder(false);
			secondFormPanel.setLabelAlign(Position.TOP);
			secondFormPanel.setPaddings(10,10,0,0);
			lastname = new TextField("Nachname", "", 110);
			secondFormPanel.add(lastname);
			city  = new TextField("Wohnort", "", 110);
			secondFormPanel.add(city);
			
			FormPanel thirdFormPanel = new FormPanel();
			thirdFormPanel.setBorder(false);
			thirdFormPanel.setLabelAlign(Position.TOP);
			thirdFormPanel.setPaddings(10,10,0,0);
			job = new TextField("Job","", 110);
			thirdFormPanel.add(job);
			hobbies = new TextField("Hobbies","", 110);
			thirdFormPanel.add(hobbies);
			
			
			Panel fourthFormPanel = new Panel();
			fourthFormPanel.setBorder(false);
			fourthFormPanel.setPaddings(23,10,0,0);
			
			
			Panel checkBoxPanel = new Panel();
			checkBoxPanel.setBorder(false);
			//Checkbox activeArticleCheckBox = new Checkbox("Nur aktive Artikel anzeigen");
			//checkBoxPanel.add(activeArticleCheckBox);
			final Checkbox pictureUserCheckBox = new Checkbox("Nur mit Bild anzeigen");
			checkBoxPanel.add(pictureUserCheckBox);
			fourthFormPanel.add(checkBoxPanel);
			
			Panel buttonPanel = new Panel();
			buttonPanel.setPaddings(10,0,0,0);
			buttonPanel.setBorder(false);
			Button searchButton = new Button("Suchen", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					UserSearchQuery sq = new UserSearchQuery();
					sq.setUsername(username.getText());
					sq.setFirstname(firstname.getText());
					sq.setLastname(lastname.getText());
					sq.setCity(city.getText());
					sq.setJob(job.getText());
					sq.setHobbies(hobbies.getText());
					sq.setOnlyPic(pictureUserCheckBox.getValue());

					final ExtElement element = Ext.get("mask-panel");  
					element.mask("sucht...");  

					SearchHandlerAsync searchHandler = GWT
					.create(SearchHandler.class);
					searchHandler.search(sq,
							new AsyncCallback<ArrayList<SearchResult>>() {
						public void onFailure(Throwable caught) {
							System.out.println("RPC UserSearchForm: fehler im der  ");
							caught.printStackTrace();
						}

						public void onSuccess(ArrayList<SearchResult> results) {
							element.unmask();
							Panel cp = SwapWeb.getContentPanel();
							cp.clear();  
							Panel listView = new Panel();
							listView.setBorder(false);

							for (SearchResult r : results) {
								listView.add( (UserSearchResultView) r.getView());
							}
							cp.setTitle("Suchergebnisse");
							cp.add(listView);
							cp.doLayout();
						}
					});

				}


			});
			searchButton.setIconCls("icon-search");
			buttonPanel.add(searchButton);
			fourthFormPanel.add(buttonPanel);

			MultiFieldPanel multiPanel = new MultiFieldPanel();
			multiPanel.setPaddings(5);
			multiPanel.setBorder(false);
			multiPanel.addToRow(firstFormPanel, 130);
			multiPanel.addToRow(secondFormPanel, 130);
			multiPanel.addToRow(thirdFormPanel, 130);
			multiPanel.addToRow(fourthFormPanel, 300);
			
			borderPanel.add(multiPanel);
			containerPanel.add(borderPanel);
			tabPanel.add(containerPanel);
			/*{
				
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
