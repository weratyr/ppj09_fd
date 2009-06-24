/*

 * @(#)HelpView.java      			 20.04.09

 *

 * Copyright (c) 2008-2009 Project Team 4711

 * All rights reserved.

 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.Panel;
import com.google.gwt.user.client.ui.DisclosurePanel;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Daniel Abeska
 * 
 * @author Projekt Team 4711
 * 
 * @version 0.1, 07.05.09
 */

public class HelpView extends Composite implements View {

	private AbsolutePanel absolutePanel;

	private Label lblHerzlichWilkommenAuf;

	public HelpView() {
		

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		verticalPanel.setSpacing(10);

		Label faqLogin = new Label("Anmelden und einloggen!");
		verticalPanel.add(faqLogin);
		Hyperlink frage1 = new Hyperlink();
		frage1.setText("Wie schützt SwapWeb meine Daten?");
		verticalPanel.add(frage1);
		frage1.setWidth("150");
		frage1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label(
						"SwapWep setzt alles daran, Ihre Daten zu schützen. Gemäß der Datenschutzerklärung darf SwapWeb Ihre Kontaktdaten nur in einem bestimmten Rahmen verwenden. SwapWeb gibt Ihre Informationen niemals zu Marketingzwecken an Dritte weiter.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage1);
		
		
		Hyperlink frage2 = new Hyperlink();
		frage2.setText("Wie melde ich mich im SwapWeb an?");
		verticalPanel.add(frage2);
		frage2.setWidth("150");
		frage2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Sie geben Ihre persönlichen Daten ein. Danach müssen sie eine gültige E-mail Adresse angeben und ein Passwort wählen. Danach wählen sie den Button <registrieren>.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage2);	
		
		
		Hyperlink frage3 = new Hyperlink();
		frage3.setText("Kann ich mehrere Konten oder Zugänge für SwapWeb anlegen?");
		verticalPanel.add(frage3);
		frage3.setWidth("150");
		frage3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Nein. Jeder Nutzer darf maximal ein Konto oder Zugang zu SwapWeb anlegen");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage3);	
	
		
		Hyperlink frage4 = new Hyperlink();
		frage4.setText("Ich habe meinen Mitgliedernamen oder mein Passwort vergessen?");
		verticalPanel.add(frage4);
		frage4.setWidth("150");
		frage4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Geben Sie Ihre E-Mail-Adresse nach drücken des Buttons <Passwort vergessen> ein und klicken Sie dann auf Weiter. Wir werden Ihren Mitgliedsnamen oder das vergessene Passwort dann an Ihre E-Mail-Adresse senden.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage4);	
		
		
		Hyperlink frage5 = new Hyperlink();
		frage5.setText("Ich habe die Meldung bekommen, Mitgliedsname oder Passwort falsch.");
		verticalPanel.add(frage5);
		frage5.setWidth("150");
		frage5.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Achten Sie darauf Ihren Mitgliedsnamen und nicht Ihre E-Mail-Adresse einzugeben. Überprüfen Sie, ob Sie sich vertippt haben. Sollten Sie sich dann immer noch nicht einloggen können, verwenden sie den Button <Passwort vergessen>");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage5);
		
		
		Hyperlink frage6 = new Hyperlink();
		frage6.setText("Ich habe die Meldung bekommen, Mitgliedsname oder Passwort falsch.");
		verticalPanel.add(frage6);
		frage6.setWidth("150");
		frage6.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Achten Sie darauf Ihren Mitgliedsnamen und nicht Ihre E-Mail-Adresse einzugeben. Überprüfen Sie, ob Sie sich vertippt haben. Sollten Sie sich dann immer noch nicht einloggen können, verwenden sie den Button <Passwort vergessen>");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage6);	
		
		Label faqMenber = new Label("Mitgliedskonto verwalten!");
		verticalPanel.add(faqMenber);
		
		Hyperlink frage7 = new Hyperlink();
		frage7.setText("Wie aktualisiere ich meine Mitgliedsdaten?");
		verticalPanel.add(frage7);
		frage7.setWidth("150");
		frage7.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Sie müssen in ihr Profil gehen und auf Profil ändern gehen. Dort können sie alle Personenbezogene Daten sowie alle anderen Daten Ihres Profils ändern.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage7);	
		
		Label faqRating = new Label("Bewertungssystem von SwapWeb!");
		verticalPanel.add(faqRating);
		
		
		Hyperlink frage8 = new Hyperlink();
		frage8.setText("Wie gebe ich eine Bewertung ab?");
		verticalPanel.add(frage8);
		frage8.setWidth("150");
		frage8.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Auf SwapWeb können Sie eine Tauschaktion bis zu 60 Tage nach dem Tausch bewerten. Beide Seiten können sich bei jeder Tauschaktion gegenseitig bewerten, indem sie einen Punkt und einen Bewertungskommentar abgeben.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage8);	
		
		
		
		Label faqArticle = new Label("Bewertungssystem von SwapWeb!");
		verticalPanel.add(faqArticle);
		
		
		Hyperlink frage9 = new Hyperlink();
		frage9.setText("Wie kann ich nach Artikeln suchen?");
		verticalPanel.add(frage9);
		frage9.setWidth("150");
		frage9.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Sie können bei SwapWeb nach Artikeln suchen, indem Sie entweder eine gezielte Suche durchführen oder indem Sie über den Kategorien suchen. Beide Methoden haben ihre Vorteile. Welche Methode Sie verwenden sollten, hängt davon ab, wonach Sie suchen.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage9);	
		
		
		Label faqDeliver = new Label("Verpacken und versenden!");
		verticalPanel.add(faqDeliver);
		
		
		Hyperlink frage10 = new Hyperlink();
		frage10.setText("Wie gebe ich die Versandart ein?");
		verticalPanel.add(frage10);
		frage10.setWidth("150");
		frage10.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Label q1Label = new Label("Sie können beim einstellen eines Neuen Artikels, unter mehreren Versandarten auswählen und sie somit festlegen.");
				SwapWeb.getContentPanel().clear();
				SwapWeb.getContentPanel().add(q1Label);
				SwapWeb.getContentPanel().setTitle("Hilfe");
				SwapWeb.getContentPanel().doLayout();
			}
		});
		verticalPanel.add(frage10);	
		
	}

}
