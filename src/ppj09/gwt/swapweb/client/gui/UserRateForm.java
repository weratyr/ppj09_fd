/*
 * @(#)UserRateForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.datatype.User;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

/**
 * Diese Klasse gibt die Möglichkeit einen anderen Benutzer zu bewerten.
 * Die Bewertung erfolgt über Sterne (1-5) und �ber einen Kommentar erfolgen.
 * 
 * @author Florian Liersch, Chrisitan Happ
 * @author Projektgruppe 4711
 * @version 0.1, 19.05.09
 */
public class UserRateForm implements Form {
	private User user;
	private Label userToRate;
	private Label BewerteUserLabel;

	
	public UserRateForm(User user) {
		this.user = user;
		createMessagePopupWindow();
	}

	/**
	 * Schickt die eingetragenen Daten ab
	 */
	public boolean submit() {
		
		return true;
	}
	
	public void createMessagePopupWindow() {
		final Window messageWindow = new Window();
		messageWindow.setTitle("Bewertung ");
		messageWindow.setWidth(500);
		messageWindow.setHeight(300);
		messageWindow.setMinWidth(300);
		messageWindow.setMinHeight(200);
		messageWindow.setLayout(new FitLayout());
		messageWindow.setPaddings(5);
		messageWindow.setButtonAlign(Position.CENTER);

		FormPanel messagePanel = new FormPanel();
		messagePanel.setLabelAlign(Position.TOP);
		messagePanel.setMonitorValid(true);

		// anchor width by percentage
		BewerteUserLabel = new Label ("Bewerte Benutzer "+user.getUsername());
		
		messagePanel.add(BewerteUserLabel);		
		Object[][] optionsDelivery = new Object[][] {
				new Object[] { "1", "1 Stern" },
				new Object[] { "2", "2 Stern" },
				new Object[] { "3", "3 Stern" },
				new Object[] { "4", "4 Stern" },
				new Object[] { "5", "5 Stern" }};

		Store deliveryStore = new SimpleStore(new String[] { "1", "Stern" },
				optionsDelivery);
		deliveryStore.load();

		final ComboBox starsComboBox = new ComboBox();
		starsComboBox.setFieldLabel("Bewertungspunkte");
		starsComboBox.setStore(deliveryStore);
		starsComboBox.setDisplayField("Stern");
		starsComboBox.setMode(ComboBox.LOCAL);
		starsComboBox.setTriggerAction(ComboBox.ALL);
		starsComboBox.setEmptyText("1 Stern");
		starsComboBox.setForceSelection(true);
		starsComboBox.setReadOnly(true);
		starsComboBox.setWidth(120);
		messagePanel.add(starsComboBox);

		final TextArea textArea = new TextArea("Kommentar", "kommentar");
		textArea.setAllowBlank(false);
		// anchor width by percentage and height by raw adjustment
		// sets width to 100% and height to "remainder" height - 53px
		messagePanel.add(textArea, new AnchorLayoutData("100% -163"));

		Button send = new Button("Bewertung absenden");
		send.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {

			}
		});
		send.setFormBind(true);
		messagePanel.addButton(send);
		Button cancel = new Button("Cancel");
		cancel.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				messageWindow.close();
			}
		});
		messagePanel.addButton(cancel);

		messageWindow.setCloseAction(Window.HIDE);
		messageWindow.setPlain(true);
		// strips all Ext styling for the component
		messagePanel.setBaseCls("x-plain");
		messagePanel.setLabelWidth(55);
		messagePanel.setUrl("save-form.php");

		messagePanel.setWidth(500);
		messagePanel.setHeight(300);

		messageWindow.add(messagePanel);
		messageWindow.show();

	}

}
