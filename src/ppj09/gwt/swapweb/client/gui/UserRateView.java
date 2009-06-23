/*
 * @(#)UserRateView.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.datatype.User;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Diese Klasse zeigt die Benutzerbewertungen an. Es k�nnen Bewertungen hinzugef�gt werden.
 * Die Bewertungen (UserRate Objekte) werden �ber die Methode addUserRate() auf einem Vertical Panel
 * zur Anzeige gebracht.
 * 
 * @author Florian Liersch, Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 22.06.09
 */
public class UserRateView extends Composite implements View{
	
	private User user;
	private DockPanel dockPanel;
	private AbsolutePanel absolutePanel;
	private Label lblBewertungDesBenutzers;
	private Hyperlink username;
	private VerticalPanel verticalPanel;
	
	public UserRateView(User user) {
		{
			this.user = user;
			dockPanel = new DockPanel();
			initWidget(dockPanel);
			{
				absolutePanel = new AbsolutePanel();
				dockPanel.add(absolutePanel, DockPanel.NORTH);
				absolutePanel.setHeight("47px");
				{
					lblBewertungDesBenutzers = new Label("Bewertungen des Benutzers:");
					absolutePanel.add(lblBewertungDesBenutzers, 5, 5);
					lblBewertungDesBenutzers.setSize("213px", "28px");
				}
				{
					username = new Hyperlink("New hyperlink", false, "newHistoryToken");
					absolutePanel.add(username, 251, 5);
					username.setText("hans-dieter_4711");
				}
			}
			{
				verticalPanel = new VerticalPanel();
				dockPanel.add(verticalPanel, DockPanel.CENTER);
				verticalPanel.setSize("650", "500");
			}
		}
	}

	/**
	 * Gibt den Link auf den Nutzer der bewertet wurde zur�ck.
	 * @return the hyperlink
	 */
	public Hyperlink getUsername() {
		return username;
	}

	/**
	 * Setzt den Link auf den Benutzer der die Bewertungen bekommen hat.
	 * @param hyperlink the hyperlink to set
	 */
	public void setUsername(Hyperlink name) {
		this.username = name;
	}
	
	/**
	 * F�gt eine neue Bewertung f�r den Nutzer in die Liste ein.
	 * @param UserRate to set
	 */
	public void addUserRate(UserRate rate){
		verticalPanel.add(rate);
	}

}
