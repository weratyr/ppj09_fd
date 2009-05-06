/*
 * @(#)UserView.java       		 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

/**
 * Stellt das Benutzerprofil eines Benutzers dar
 * 
 * @author christianhapp
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.widgets.form.Label;

public class UserView extends Composite implements View {
	private AbsolutePanel absolutePanel;
	private AbsolutePanel absolutePanelLeft;
	private Image image;
	private AbsolutePanel absolutePanelRight;
	private Label lblName;
	private Label lblFirstName;
	private Label lblStreet;
	private Label lblPlzOrt;
	private Label lblEmail;
	private Label lblUserid;
	private Label lblFirstNameText;
	private Label lblUserIDText;
	private Label lblNameText;
	private Label lblStreetText;
	private Label lblPlzText;
	private Label lblEmailText;
	private Label lblOrtText;
	private Label lblHnumberText;

	public UserView() {
		{
			absolutePanel = new AbsolutePanel();
			initWidget(absolutePanel);
			{
				absolutePanelLeft = new AbsolutePanel();
				absolutePanel.add(absolutePanelLeft, 5, 5);
				absolutePanelLeft.setSize("138px", "290px");
				{
					image = new Image(null);
					absolutePanelLeft.add(image, 5, 5);
					image.setSize("128px", "134px");
				}
			}
			{
				absolutePanelRight = new AbsolutePanel();
				absolutePanel.add(absolutePanelRight, 148, 5);
				absolutePanelRight.setSize("297px", "290px");
				{
					lblName = new com.gwtext.client.widgets.form.Label("Name:");
					absolutePanelRight.add(lblName, 5, 31);
				}
				{
					lblFirstName = new com.gwtext.client.widgets.form.Label(
							"Vorname:");
					absolutePanelRight.add(lblFirstName, 5, 57);
				}
				{
					lblStreet = new com.gwtext.client.widgets.form.Label(
							"Stra\u00DFe:");
					absolutePanelRight.add(lblStreet, 5, 83);
				}
				{
					lblPlzOrt = new com.gwtext.client.widgets.form.Label(
							"PLZ / Ort:");
					absolutePanelRight.add(lblPlzOrt, 5, 109);
				}
				{
					lblEmail = new com.gwtext.client.widgets.form.Label(
							"eMail:");
					absolutePanelRight.add(lblEmail, 5, 135);
				}
				{
					lblUserid = new com.gwtext.client.widgets.form.Label(
							"UserID:");
					absolutePanelRight.add(lblUserid, 5, 5);
				}
				{
					lblFirstNameText = new com.gwtext.client.widgets.form.Label(
							"");
					absolutePanelRight.add(lblFirstNameText, 79, 57);
					lblFirstNameText.setSize("213px", "21px");
				}
				{
					lblUserIDText = new com.gwtext.client.widgets.form.Label("");
					absolutePanelRight.add(lblUserIDText, 79, 5);
					lblUserIDText.setSize("213px", "21px");
				}
				{
					lblNameText = new com.gwtext.client.widgets.form.Label("");
					absolutePanelRight.add(lblNameText, 79, 31);
					lblNameText.setSize("213px", "21px");
				}
				{
					lblStreetText = new com.gwtext.client.widgets.form.Label("");
					absolutePanelRight.add(lblStreetText, 79, 83);
					lblStreetText.setSize("180px", "21px");
				}
				{
					lblPlzText = new com.gwtext.client.widgets.form.Label("");
					absolutePanelRight.add(lblPlzText, 79, 109);
					lblPlzText.setSize("55px", "21px");
				}
				{
					lblEmailText = new com.gwtext.client.widgets.form.Label("");
					absolutePanelRight.add(lblEmailText, 79, 135);
					lblEmailText.setSize("213px", "21px");
				}
				{
					lblOrtText = new Label("");
					absolutePanelRight.add(lblOrtText, 139, 109);
					lblOrtText.setSize("153px", "21px");
				}
				{
					lblHnumberText = new com.gwtext.client.widgets.form.Label(
							"");
					absolutePanelRight.add(lblHnumberText, 265, 83);
					lblHnumberText.setSize("27px", "21px");
				}
			}
		}
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setLblFirstNameText(String lblFirstNameText) {
		this.lblFirstNameText.setText(lblFirstNameText);
	}

	public void setLblUserIDText(String lblUserIDText) {
		this.lblUserIDText.setText(lblUserIDText);
	}

	public void setLblNameText(String lblNameText) {
		this.lblNameText.setText(lblNameText);
	}

	public void setLblStreetText(String lblStreetText) {
		this.lblStreetText.setText(lblStreetText);
	}

	public void setLblPlzText(String lblPlzText) {
		this.lblPlzText.setText(lblPlzText);
	}

	public void setLblEmailText(String lblEmailText) {
		this.lblEmailText.setText(lblEmailText);
	}

	public void setLblOrtText(String lblOrtText) {
		this.lblOrtText.setText(lblOrtText);
	}

	public void setLblHnumberText(Label lblHnumberText) {
		this.lblHnumberText = lblHnumberText;
	}
}
