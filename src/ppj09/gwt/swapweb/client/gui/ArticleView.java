/*
 * @(#)ArticleView.java      20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

/**
 * Stellt die Sicht auf einen Artikel dar.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 * 
 */

package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.AbsolutePanel;

import com.google.gwt.user.client.ui.Image;

import com.gwtext.client.widgets.form.Label;

public class ArticleView extends Composite implements View {

	private AbsolutePanel absolutePanel;

	private AbsolutePanel absolutePanelLeft;

	private Image image;

	private AbsolutePanel absolutePanelRight;

	private Label lblArticelId;

	private Label lblTitel;

	private Label lblDescription;

	private Label lblCategorie;

	private Label lblShippingMethode;

	private Label lblUserid;

	private Label lblTitelText;

	private Label lblUserIDText;

	private Label lblArtikelIdText;

	private Label lblDescriptionText;

	private Label lblCategorieText;

	private Label lblShippingMethodeText;

	public ArticleView() {

		{

			absolutePanel = new AbsolutePanel();

			absolutePanel.setSize("450px", "450px");

			initWidget(absolutePanel);

			// absolutePanel.setHeight("335px");

			{

				absolutePanelLeft = new AbsolutePanel();

				absolutePanel.add(absolutePanelLeft, 5, 5);

				absolutePanelLeft.setSize("138px", "440px");

				{

					image = new Image(null);

					absolutePanelLeft.add(image, 5, 5);

					image.setSize("128px", "134px");

				}

			}

			{

				absolutePanelRight = new AbsolutePanel();

				absolutePanel.add(absolutePanelRight, 148, 5);

				absolutePanelRight.setSize("297px", "440px");

				{

					lblArticelId = new com.gwtext.client.widgets.form.Label(
							"ArtikelId:");

					absolutePanelRight.add(lblArticelId, 5, 31);

				}

				{

					lblTitel = new com.gwtext.client.widgets.form.Label(
							"Titel:");

					absolutePanelRight.add(lblTitel, 5, 57);

				}

				{

					lblDescription = new com.gwtext.client.widgets.form.Label(
							"Beschreibung:");

					absolutePanelRight.add(lblDescription, 5, 83);

				}

				{

					lblCategorie = new com.gwtext.client.widgets.form.Label(
							"Kategorie:");

					absolutePanelRight.add(lblCategorie, 5, 238);

				}

				{

					lblShippingMethode = new com.gwtext.client.widgets.form.Label(
							"Versand:");

					absolutePanelRight.add(lblShippingMethode, 5, 264);

				}

				{

					lblUserid = new com.gwtext.client.widgets.form.Label(
							"UserID:");

					absolutePanelRight.add(lblUserid, 5, 5);

				}

				{

					lblTitelText = new com.gwtext.client.widgets.form.Label("");

					absolutePanelRight.add(lblTitelText, 79, 57);

					lblTitelText.setSize("213px", "21px");

				}

				{

					lblUserIDText = new com.gwtext.client.widgets.form.Label("");

					absolutePanelRight.add(lblUserIDText, 79, 5);

					lblUserIDText.setSize("213px", "21px");

				}

				{

					lblArtikelIdText = new com.gwtext.client.widgets.form.Label(
							"");

					absolutePanelRight.add(lblArtikelIdText, 79, 31);

					lblArtikelIdText.setSize("213px", "21px");

				}

				{

					lblDescriptionText = new com.gwtext.client.widgets.form.Label(
							"");

					absolutePanelRight.add(lblDescriptionText, 5, 109);

					lblDescriptionText.setSize("287px", "124px");

				}

				{

					lblShippingMethodeText = new com.gwtext.client.widgets.form.Label(
							"");

					absolutePanelRight.add(lblShippingMethodeText, 82, 264);

					lblShippingMethodeText.setSize("210px", "21px");

				}

				{

					lblCategorieText = new Label("");

					absolutePanelRight.add(lblCategorieText, 82, 238);

					lblCategorieText.setSize("207px", "21px");

				}

			}

		}

	}

	public void setImage(Image image) {

		this.image = image;

	}

	public void setLblTitelText(String lblTitelText) {

		this.lblTitelText.setText(lblTitelText);

	}

	public void setLblUserIDText(String lblUserIDText) {

		this.lblUserIDText.setText(lblUserIDText);

	}

	public void setLblArtikelIdText(String lblArtikelIdText) {

		this.lblArtikelIdText.setText(lblArtikelIdText);

	}

	public void setLblDescriptionText(String lblDescriptionText) {

		this.lblDescriptionText.setText(lblDescriptionText);

	}

	public void setLblCategorieText(String lblCategorieText) {

		this.lblCategorieText.setText(lblCategorieText);

	}

	public void setLblShippingMethodeText(String lblShippingMethodeText) {

		this.lblShippingMethodeText.setText(lblShippingMethodeText);

	}

}
