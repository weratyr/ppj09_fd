package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Georg Ortwein
 * Klasse User- Form ist zum ändern bzw. bearbeiten eines Profils 
 */

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

public class ArticleForm extends Composite implements View {

	private FormPanel formPanel;
	private TextField txtbxName;
	private TextField txtbxZip;
	private TextField txtbxCity;
	private MultiFieldPanel panel1;
	private ComboBox combobxCondition;
	private Checkbox chkbxdelivery1;
	private Checkbox chkbxdelivery2;
	private Checkbox chkbxdelivery3;
	private TextArea txtbxAmount;
	private TextArea txtbxSwaps;
	private TextArea txtbxSpecials;
	private HtmlEditor description;
	private FormPanel formPanel2;
	private HorizontalPanel horizontalPanel;

	/**
	 * Constructor
	 * 
	 * 
	 */

	public ArticleForm() {
		{
			VerticalPanel verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			{
				formPanel = new FormPanel();
				formPanel.setLabelAlign(Position.RIGHT);
				formPanel.setLabelWidth(250);
				formPanel.setBorder(false);
				formPanel.setFooter(true);
				formPanel.setWidth(480);
				{
					txtbxName = new TextField("Artikelname*", "text_field", 190);
					formPanel.add(txtbxName);

					txtbxZip = new TextField("Plz* / Artikelstandort*",
							"text_field", 50);
					txtbxZip.setAllowBlank(false);
					txtbxZip.setSelectOnFocus(true);

					txtbxCity = new TextField("Wohnort", "text_field", 135);
					txtbxCity.setAllowBlank(false);
					txtbxCity.setHideLabel(true);
					txtbxCity.setSelectOnFocus(true);

					panel1 = new MultiFieldPanel();
					panel1.addToRow(txtbxZip, 310);
					panel1.addToRow(txtbxCity, new ColumnLayoutData(1));
					panel1.setBorder(false);
					formPanel.add(panel1);

					final Store conditionStore = new SimpleStore(new String[] {
							"zustand", "nr" }, new String[][] {
							new String[] { "neu", "1" },
							new String[] { "gebraucht", "2" } });
					conditionStore.load();

					// TODO
					combobxCondition = new ComboBox();
					combobxCondition.setFieldLabel("Zustand*");
					combobxCondition.setStore(conditionStore);
					combobxCondition.setAllowBlank(false);
					combobxCondition.setDisplayField("zustand");
					combobxCondition.setMode(ComboBox.LOCAL);
					combobxCondition.setTriggerAction(ComboBox.ALL);
					combobxCondition.setTypeAhead(true);
					combobxCondition.setEditable(false);
					combobxCondition.setSelectOnFocus(true);
					combobxCondition.setWidth(190);
					combobxCondition.setHideTrigger(false);
					formPanel.add(combobxCondition);

					chkbxdelivery1 = new Checkbox("Postversand", "check_Box");
					chkbxdelivery2 = new Checkbox("Selbstabholung", "check_Box");
					chkbxdelivery3 = new Checkbox("Treffen", "check_Box");

					chkbxdelivery1.setFieldLabel("Versandoptionen*:");

					formPanel.add(chkbxdelivery1);
					formPanel.add(chkbxdelivery2);
					formPanel.add(chkbxdelivery3);

					txtbxAmount = new TextArea("Angebotsumfang*", "text_Area");
					txtbxAmount.setPixelSize(190, 70);
					formPanel.add(txtbxAmount);

					txtbxSwaps = new TextArea("Gegentauschvorstellungen*",
							"text_Area");
					txtbxSwaps.setPixelSize(190, 70);
					formPanel.add(txtbxSwaps);

					txtbxSpecials = new TextArea("Besonderheiten*", "text_Area");
					txtbxSpecials.setPixelSize(190, 70);
					formPanel.add(txtbxSpecials);

				}

				verticalPanel.add(formPanel);

				formPanel2 = new FormPanel();
				formPanel2.setLabelAlign(Position.TOP);
				formPanel2.setLabelWidth(250);
				formPanel2.setBorder(false);
				formPanel2.setFooter(true);

				{
					description = new HtmlEditor("Beschreibung");

					// description.setWidth(700);
					// description.setHeight(300);
					formPanel2.add(description);
				}

				verticalPanel.add(formPanel2);

			}
		}

	}
}