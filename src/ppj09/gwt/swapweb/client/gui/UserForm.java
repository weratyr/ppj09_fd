package ppj09.gwt.swapweb.client.gui;


import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

/**
 * Formularfelder und Submit
 * 
 */
public class UserForm extends Composite implements Form {
	private final UserManagerAsync userManager = GWT.create(UserManager.class);
	private Label lblFirstName;
	private AbsolutePanel absolutePanel;
	private Label lblLastName;
	private Label lblZip_City;
	private Label lblStreet_Number;
	private TextBox txtbxFirstName;
	private TextBox txtbLastName;
	private TextBox txtbZip;
	private TextBox txtbCity;
	private TextBox txtbStreet;
	private TextBox txtbNumber;
	private Label lblUserName;
	private TextBox txtbUserName;
	private TextBox txtbUsername;
	private TextBox txtbPassword;
	private TextBox txtbPasswordRepeat;
	private Label lblPassword;
	private Label lblPasswordRepeat;
	private Label lblEmail;
	private Label lblEmailRepeat;
	private TextBox txtbEmailRepeat;
	private VerticalPanel verticalPanel;

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public UserForm() {
		{
			verticalPanel = new VerticalPanel();
			absolutePanel = new AbsolutePanel();
			verticalPanel.add(absolutePanel);
			initWidget(verticalPanel);
			absolutePanel.setSize("600", "325px");
			{
				lblFirstName = new Label("Vorname:");
				absolutePanel.add(lblFirstName, 33, 3);
				lblFirstName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			}
			{
				lblLastName = new Label("Nachname:");
				absolutePanel.add(lblLastName, 23, 28);
			}
			{
				lblZip_City = new Label("PLZ/ Wohnort:");
				absolutePanel.add(lblZip_City, 5, 54);
			}
			{
				lblStreet_Number = new Label("Stra\u00DFe/ Nr:");
				absolutePanel.add(lblStreet_Number, 25, 80);
			}
			{
				txtbxFirstName = new TextBox();
				absolutePanel.add(txtbxFirstName, 94, 0);
			}
			{
				txtbLastName = new TextBox();
				absolutePanel.add(txtbLastName, 94, 26);
			}
			{
				txtbZip = new TextBox();
				absolutePanel.add(txtbZip, 94, 52);
				txtbZip.setSize("50", "22");
			}
			{
				txtbCity = new TextBox();
				absolutePanel.add(txtbCity, 147, 52);
				txtbCity.setSize("106", "22");
			}
			{
				txtbStreet = new TextBox();
				absolutePanel.add(txtbStreet, 94, 76);
				txtbStreet.setWidth("96");
			}
			{
				txtbNumber = new TextBox();
				absolutePanel.add(txtbNumber, 193, 76);
				txtbNumber.setWidth("60");
			}
			{
				lblUserName = new Label("Benutzername:");
				absolutePanel.add(lblUserName, 331, 3);
			}
			{
				txtbUserName = new TextBox();
				absolutePanel.add(txtbUserName, 424, 78);
			}
			{
				txtbUsername = new TextBox();
				absolutePanel.add(txtbUsername, 424, 0);
			}
			{
				txtbPassword = new TextBox();
				absolutePanel.add(txtbPassword, 424, 26);
			}
			{
				txtbPasswordRepeat = new TextBox();
				absolutePanel.add(txtbPasswordRepeat, 424, 52);
			}
			{
				lblPassword = new Label("Password:");
				absolutePanel.add(lblPassword, 358, 28);
			}
			{
				lblPasswordRepeat = new Label("Password Wiederholen:");
				absolutePanel.add(lblPasswordRepeat, 283, 54);
			}
			{
				lblEmail = new Label("E-Mail:");
				absolutePanel.add(lblEmail, 378, 81);
			}
			{
				lblEmailRepeat = new Label("E-Mail Wiederholen:");
				absolutePanel.add(lblEmailRepeat, 303, 107);
			}
			{
				txtbEmailRepeat = new TextBox();
				absolutePanel.add(txtbEmailRepeat, 424, 104);
			}
			{
				Button Registration = new Button();
				absolutePanel.add(Registration, 424, 159);
				Registration.setText("Registrieren");
				Registration.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						Window.alert("Hallo");
					}
				});
				Registration.setSize("140", "25");
			}
		}

	}

	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet auf
	 * Rueckmeldung
	 */
	public boolean submit() {
		if (Validation.validateRegisterForm(this)) {
			// Sende Daten an Server
			User newUser = null;
			userManager.createUser(newUser, new AsyncCallback<Integer>() {
				public void onFailure(Throwable caught) {
					// :(
				}

				public void onSuccess(Integer serverMsg) {
					// :)
				}
			});
			return true;
		} else {
			// Hinweis auf Fehler im Formular
			return false;
		}
	}
}