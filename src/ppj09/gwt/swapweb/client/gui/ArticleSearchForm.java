/*
 * @(#)ArticleSearchForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */
 
package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.Validation;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;


/**
 * Formularfelder und Submit der Artikelsuche. Implementiert das Interface Form.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class ArticleSearchForm extends Composite implements Form {
	private TabPanel tabPanel;
	private AbsolutePanel absolutePanel;
	private Label searchqueryLabel;
	private TextBox searchqueryTextBox;
	private Label excludeArticleLabel;
	private TextBox excludeArticleTextBox;
	private Label articleLocationLabel;
	private TextBox articleLocationTextBox;
	private Label articleConditionLabel;
	private ListBox articleConditionComboBox;
	private ListBox deliveryComboBox;
	private Label deliveryLabel;
	private ListBox categoryComboBox;
	private CheckBox activeArticleCheckBox;
	private CheckBox pictureArticlesCheckBox;
	private Button resultButton;
	private Label resultLabel;
	private UserSearchForm userSearchForm;
	public ArticleSearchForm() {
		{
			tabPanel = new TabPanel();
			initWidget(tabPanel);
			{
				absolutePanel = new AbsolutePanel();
				tabPanel.add(absolutePanel, "Artikelsuche", false);
				tabPanel.selectTab(0);
				absolutePanel.setSize("600px", "250");
				{
					searchqueryLabel = new Label("Suchbegriff oder Tauschnummer:");
					absolutePanel.add(searchqueryLabel, 5, 5);
					searchqueryLabel.setSize("218", "18");
				}
				{
					searchqueryTextBox = new TextBox();
					absolutePanel.add(searchqueryTextBox, 5, 23);
					searchqueryTextBox.setWidth("218");
				}
				{
					excludeArticleLabel = new Label("Begriffe von der Suche ausschlie\u00DFen:");
					absolutePanel.add(excludeArticleLabel, 5, 48);
				}
				{
					excludeArticleTextBox = new TextBox();
					absolutePanel.add(excludeArticleTextBox, 5, 66);
					excludeArticleTextBox.setSize("218", "");
				}
				{
					articleLocationLabel = new Label("Artikelstandort:");
					absolutePanel.add(articleLocationLabel, 5, 96);
				}
				{
					articleLocationTextBox = new TextBox();
					absolutePanel.add(articleLocationTextBox, 103, 93);
					articleLocationTextBox.setWidth("120");
				}
				{
					articleConditionLabel = new Label("Zustand:");
					absolutePanel.add(articleConditionLabel, 42, 122);
				}
				{
					articleConditionComboBox = new ListBox();
					absolutePanel.add(articleConditionComboBox, 103, 120);
					articleConditionComboBox.addItem("Beliebig");
					articleConditionComboBox.addItem("Neu");
					articleConditionComboBox.addItem("Gebraucht");
					articleConditionComboBox.setWidth("120");
				}
				{
					deliveryComboBox = new ListBox();
					absolutePanel.add(deliveryComboBox, 103, 144);
					deliveryComboBox.addItem("Beliebig");
					deliveryComboBox.addItem("Postversand");
					deliveryComboBox.addItem("Abholung");
					deliveryComboBox.addItem("Treffen");
					deliveryComboBox.setWidth("120");
				}
				{
					deliveryLabel = new Label("Versandart:");
					absolutePanel.add(deliveryLabel, 26, 145);
				}
				{
					categoryComboBox = new ListBox();
					absolutePanel.add(categoryComboBox, 230, 24);
					categoryComboBox.addItem("Kategorie");
					categoryComboBox.setSize("120", "");
				}
				{
					activeArticleCheckBox = new CheckBox("New check box");
					absolutePanel.add(activeArticleCheckBox, 387, 23);
					activeArticleCheckBox.setHTML("Nur aktive Artikel Anzeigen");
				}
				{
					pictureArticlesCheckBox = new CheckBox("Nur Artikel mit Bildern anzeigen");
					absolutePanel.add(pictureArticlesCheckBox, 387, 45);
				}
				{
					resultButton = new Button("New button");
					absolutePanel.add(resultButton, 387, 138);
					resultButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							
						}
					});
				
					resultButton.setText("Ergebnisse anzeigen");
				}
				{
					resultLabel = new Label("5 Artikel gefunden");
					absolutePanel.add(resultLabel, 387, 115);
					resultLabel.setWidth("143");
				}
			}
			{
				userSearchForm = new UserSearchForm();
				tabPanel.add(userSearchForm, "Benutzersuche", false);
				userSearchForm.setSize("600px", "250");
			}
		}
	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rueckmeldung
	 */
	public boolean submit() {
		if (Validation.validateArticleSearchForm(this)) {
			// Sende Daten an Server
			return true;
		} else {
			// Hinweis auf Fehler
			return false;
		}
	}
}
