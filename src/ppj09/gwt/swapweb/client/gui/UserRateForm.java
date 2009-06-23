/*
 * @(#)UserRateForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.datatype.Rate;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.RatingHandler;
import ppj09.gwt.swapweb.client.serverInterface.RatingHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
				new Object[] { "1" },
				new Object[] { "2"},
				new Object[] { "3"},
				new Object[] { "4"},
				new Object[] { "5"}};

		Store deliveryStore = new SimpleStore(new String[] { "1" },
				optionsDelivery);
		deliveryStore.load();

		final ComboBox starsComboBox = new ComboBox();
		starsComboBox.setFieldLabel("Bewertungspunkte");
		starsComboBox.setStore(deliveryStore);
		
		starsComboBox.setDisplayField("1");
		starsComboBox.setMode(ComboBox.LOCAL);
		starsComboBox.setTriggerAction(ComboBox.ALL);
		starsComboBox.setEmptyText("Sterne wählen");
		starsComboBox.setForceSelection(true);
		starsComboBox.setReadOnly(true);
		starsComboBox.setWidth(120);
		starsComboBox.setAllowBlank(false);
		messagePanel.add(starsComboBox);

		final TextArea textArea = new TextArea("Kommentar", "kommentar");
		textArea.setAllowBlank(false);
		// anchor width by percentage and height by raw adjustment
		// sets width to 100% and height to "remainder" height - 53px
		messagePanel.add(textArea, new AnchorLayoutData("100% -163"));
		
		Button send = new Button("Bewertung absenden");
		send.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				Rate rate = new Rate();
				rate.setStars(new Integer( starsComboBox.getValue() ));
				RatingHandlerAsync ratingHandler = GWT.create(RatingHandler.class);
				ratingHandler.sendRate(rate, new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						System.out.println(starsComboBox.getValue()	);
						System.out.println("RPC: Rating UserRateForm.java "+caught);
						caught.printStackTrace();
					}

					public void onSuccess(Integer result) {
						messageWindow.close();
					}
				});
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
