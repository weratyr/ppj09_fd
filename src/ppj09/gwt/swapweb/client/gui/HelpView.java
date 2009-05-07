/*

 * @(#)HelpView.java      			 20.04.09

 *

 * Copyright (c) 2008-2009 Project Team 4711

 * All rights reserved.

 */

package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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

		{

			absolutePanel = new AbsolutePanel();

			initWidget(absolutePanel);

			absolutePanel.setSize("650", "417px");

			{

				VerticalPanel verticalPanel = new VerticalPanel();

				absolutePanel.add(verticalPanel);
				verticalPanel.setWidth("650");

				{

					lblHerzlichWilkommenAuf = new Label(
							"Herzlich wilkommen auf den Hilfeseiten von Swapweb");

					verticalPanel.add(lblHerzlichWilkommenAuf);
					lblHerzlichWilkommenAuf.setStyleName("gwt-Label2");

					lblHerzlichWilkommenAuf
							.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

					lblHerzlichWilkommenAuf.setHeight("100");

				}
				
				AbsolutePanel absolutePanel_1 = new AbsolutePanel();
				verticalPanel.add(absolutePanel_1);
				absolutePanel_1.setHeight("40");

				{

					Label lblH_Fragen = new Label(
							"Haeufige Fragen");
					absolutePanel_1.add(lblH_Fragen, 5, 10);
					lblH_Fragen.setStyleName("gwt-Label3");
					lblH_Fragen.setHeight("18");

				}
				
				DisclosurePanel disclosurePanel = new DisclosurePanel("Frage 1", false);
				verticalPanel.add(disclosurePanel);
				disclosurePanel.setWidth("500");
				
				Label q1Label = new Label("Welche IP-Adresse steht an der ersten Stelle? Wiederholen Sie \u201Edig www.bu.edu\u201C noch drei Mal. Welche IP-Adressen stehen jetzt an der ersten Stelle? Wie erkl\u00E4ren Sie sich die Tatsache, dass der DNS-Server immer eine andere IP-Adresse an die erste Stelle setzt, wenn man davon ausgeht, dass Ihr WEB-Browser immer die erste IP-Adresse nimmt? ");
				disclosurePanel.setContent(q1Label);
				q1Label.setSize("500", "4cm");
				
				DisclosurePanel disclosurePanel_1 = new DisclosurePanel("Frage 2", false);
				verticalPanel.add(disclosurePanel_1);
				disclosurePanel_1.setWidth("500");
				
				Label q2Llabel = new Label("Welche IP-Adresse steht an der ersten Stelle? Wiederholen Sie \u201Edig www.bu.edu\u201C noch drei Mal. Welche IP-Adressen stehen jetzt an der ersten Stelle? Wie erkl\u00E4ren Sie sich die Tatsache, dass der DNS-Server immer eine andere IP-Adresse an die erste Stelle setzt, wenn man davon ausgeht, dass Ihr WEB-Browser immer die erste IP-Adresse nimmt");
				disclosurePanel_1.setContent(q2Llabel);
				q2Llabel.setSize("500", "4cm");
				
				DisclosurePanel disclosurePanel_2 = new DisclosurePanel("Frage 3", false);
				verticalPanel.add(disclosurePanel_2);
				disclosurePanel_2.setWidth("500");
				
				Label q3Label = new Label("Welche IP-Adresse steht an der ersten Stelle? Wiederholen Sie \u201Edig www.bu.edu\u201C noch drei Mal. Welche IP-Adressen stehen jetzt an der ersten Stelle? Wie erkl\u00E4ren Sie sich die Tatsache, dass der DNS-Server immer eine andere IP-Adresse an die erste Stelle setzt, wenn man davon ausgeht, dass Ihr WEB-Browser immer die erste IP-Adresse nimmt");
				disclosurePanel_2.setContent(q3Label);
				q3Label.setSize("500", "4cm");
				
				AbsolutePanel absolutePanel_2 = new AbsolutePanel();
				verticalPanel.add(absolutePanel_2);
				absolutePanel_2.setHeight("40");

				{

					Label lbl_Search_Find = new Label(
							"Suchen und Finden");
					absolutePanel_2.add(lbl_Search_Find, 5, 10);
					lbl_Search_Find.setStyleName("gwt-Label3");
					lbl_Search_Find.setHeight("18");

				}
				
				DisclosurePanel disclosurePanel_3 = new DisclosurePanel("Frage 1", false);
				verticalPanel.add(disclosurePanel_3);
				disclosurePanel_3.setWidth("500");
				
				Label q4Label = new Label("Welche IP-Adresse steht an der ersten Stelle? Wiederholen Sie \u201Edig www.bu.edu\u201C noch drei Mal. Welche IP-Adressen stehen jetzt an der ersten Stelle? Wie erkl\u00E4ren Sie sich die Tatsache, dass der DNS-Server immer eine andere IP-Adresse an die erste Stelle setzt, wenn man davon ausgeht, dass Ihr WEB-Browser immer die erste IP-Adresse nimmt");
				disclosurePanel_3.setContent(q4Label);
				q4Label.setSize("5cm", "4cm");

			}

		}

	}

}
