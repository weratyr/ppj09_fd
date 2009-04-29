package ppj09.gwt.swapweb.client.gui;

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
 * Formularfelder und Submit
 * 
 */
public class ArticleSearchForm extends Composite implements Form {
	public ArticleSearchForm() {
		{
			TabPanel tabPanel = new TabPanel();
			initWidget(tabPanel);
			{
				AbsolutePanel absolutePanel = new AbsolutePanel();
				tabPanel.add(absolutePanel, "Artikelsuche", false);
				absolutePanel.setSize("600px", "221px");
				{
					Label lblSuchbegriffOderTauschnummer = new Label("Suchbegriff oder Tauschnummer:");
					absolutePanel.add(lblSuchbegriffOderTauschnummer, 5, 5);
					lblSuchbegriffOderTauschnummer.setSize("218", "18");
				}
				{
					TextBox textBox = new TextBox();
					absolutePanel.add(textBox, 5, 23);
					textBox.setWidth("218");
				}
				{
					Label lblBegriffeVonDer = new Label("Begriffe von der Suche ausschlie\u00DFen:");
					absolutePanel.add(lblBegriffeVonDer, 5, 48);
				}
				{
					TextBox textBox = new TextBox();
					absolutePanel.add(textBox, 5, 66);
					textBox.setSize("218", "");
				}
				{
					Label lblArtikelstandort = new Label("Artikelstandort:");
					absolutePanel.add(lblArtikelstandort, 5, 94);
				}
				{
					TextBox textBox = new TextBox();
					absolutePanel.add(textBox, 103, 91);
					textBox.setWidth("120");
				}
				{
					Label lblZustand = new Label("Zustand:");
					absolutePanel.add(lblZustand, 42, 118);
				}
				{
					ListBox comboBox = new ListBox();
					absolutePanel.add(comboBox, 103, 116);
					comboBox.addItem("Beliebig");
					comboBox.addItem("Neu");
					comboBox.addItem("Gebraucht");
					comboBox.setWidth("120");
				}
				{
					ListBox comboBox = new ListBox();
					absolutePanel.add(comboBox, 103, 140);
					comboBox.addItem("Beliebig");
					comboBox.addItem("Postversand");
					comboBox.addItem("Abholung");
					comboBox.addItem("Treffen");
					comboBox.setWidth("120");
				}
				{
					Label lblVersandart = new Label("Versandart:");
					absolutePanel.add(lblVersandart, 26, 142);
				}
				{
					ListBox comboBox = new ListBox();
					absolutePanel.add(comboBox, 230, 24);
					comboBox.addItem("Kategorie");
					comboBox.setSize("120", "");
				}
				{
					CheckBox checkBox = new CheckBox("New check box");
					absolutePanel.add(checkBox, 387, 23);
					checkBox.setHTML("Nur aktive Artikel Anzeigen");
				}
				{
					CheckBox chckbxNurArtikelMit = new CheckBox("Nur Artikel mit Bildern anzeigen");
					absolutePanel.add(chckbxNurArtikelMit, 387, 45);
				}
				{
					Button button = new Button("New button");
					absolutePanel.add(button, 387, 138);
					button.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
						}
					});
					button.setText("Ergebnisse anzeigen");
				}
				{
					Label artikelGefundenLabel = new Label("5 Artikel gefunden");
					absolutePanel.add(artikelGefundenLabel, 387, 115);
					artikelGefundenLabel.setWidth("143");
				}
			}
			{
				UserSearchForm userSearchForm = new UserSearchForm();
				tabPanel.add(userSearchForm, "Benutzersuche", false);
				userSearchForm.setSize("600px", "3cm");
			}
		}
	}

	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rückmeldung
	 */
	/**
	 * Schickt die validierten Formulardaten an den Article-Search Modul, und
	 * wartet auf Rückmeldung
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
