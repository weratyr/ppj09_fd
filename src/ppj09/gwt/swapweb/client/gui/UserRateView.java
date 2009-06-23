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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.FitLayout;

/**
 * Diese Klasse zeigt die Benutzerbewertungen an. Es k�nnen Bewertungen
 * hinzugef�gt werden. Die Bewertungen (UserRate Objekte) werden �ber die
 * Methode addUserRate() auf einem Vertical Panel zur Anzeige gebracht.
 * 
 * @author Florian Liersch, Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 22.06.09
 */
public class UserRateView extends Composite implements View {

	private User user;
	private HorizontalPanel dockPanel;
	private AbsolutePanel absolutePanel;
	private Label lblBewertungDesBenutzers;
	private Hyperlink username;
	private VerticalPanel verticalPanel;

	public UserRateView(User user) {
		this.user = user;

		Window messageWindow = new Window();
		messageWindow.setTitle("Bewertungen von "+user.getUsername());
		messageWindow.setWidth(500);
		messageWindow.setHeight(300);
		messageWindow.setMinWidth(300);
		messageWindow.setMinHeight(200);
		messageWindow.setLayout(new FitLayout());
		messageWindow.setPaddings(5);
		messageWindow.setButtonAlign(Position.CENTER);
		messageWindow.setAutoScroll(true);

		VerticalPanel messagePanel = new VerticalPanel();
		
		TextField t = new TextField("fd");
		messagePanel.add(t);
		
		
		
		messageWindow.setCloseAction(Window.HIDE);
		messageWindow.setPlain(true);
		// strips all Ext styling for the component
		

		messagePanel.setWidth("100%");
		messagePanel.setHeight("100%");

		messageWindow.add(messagePanel);
		messageWindow.show();
	}

	/**
	 * Gibt den Link auf den Nutzer der bewertet wurde zur�ck.
	 * 
	 * @return the hyperlink
	 */
	public Hyperlink getUsername() {
		return username;
	}

	/**
	 * Setzt den Link auf den Benutzer der die Bewertungen bekommen hat.
	 * 
	 * @param hyperlink
	 *            the hyperlink to set
	 */
	public void setUsername(Hyperlink name) {
		this.username = name;
	}

	/**
	 * F�gt eine neue Bewertung f�r den Nutzer in die Liste ein.
	 * 
	 * @param UserRate
	 *            to set
	 */
	public void addUserRate(UserRate rate) {
		verticalPanel.add(rate);
	}

}
