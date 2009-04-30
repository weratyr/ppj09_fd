package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.user.client.ui.FocusListenerAdapter;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.BlurEvent;

/**
 * Formularfelder und Submit
 * 
 */
public class LoginForm extends Composite implements Form {
	/**
	 * Create a remote service proxy to talk to the server-side userManager
	 * service.
	 */
	private final UserManagerAsync userManager = GWT.create(UserManager.class);
	private VerticalPanel verticalPanel;
	private AbsolutePanel absolutePanel_1;
	private TextBox usernameTextBox;
	private Button loginButton;
	private Hyperlink passwordLostHyperlink;
	private PasswordTextBox pswrdtxtbxPasswort;
	private TextBox passwordTextBox;
	private AbsolutePanel absolutePanel;
	private TextBox pwLostEmailTextBox;
	private Button pwLostButton;
	private TextBox pwLostUsernameTextBox;

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public LoginForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			verticalPanel.setSize("550", "80");
			{
				absolutePanel_1 = new AbsolutePanel();
				verticalPanel.add(absolutePanel_1);
				absolutePanel_1.setSize("550", "30");
				{
					usernameTextBox = new TextBox();
					absolutePanel_1.add(usernameTextBox, 5, 0);
					usernameTextBox.addBlurHandler(new BlurHandler() {
						public void onBlur(BlurEvent event) {
							if (usernameTextBox.getText().equals(
									"")) {
								usernameTextBox.setText("Benutzername");
							}
						}
					});
					usernameTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							if (usernameTextBox.getText().equals(
									"Benutzername")) {
								usernameTextBox.setText("");
							}
						}
					});
					usernameTextBox.setText("Benutzername");
				}
				{
					loginButton = new Button("New button");
					absolutePanel_1.add(loginButton, 323, 0);
					loginButton.setText("Login");
				}
				{
					passwordLostHyperlink = new Hyperlink("New hyperlink", false,
							"newHistoryToken");
					absolutePanel_1.add(passwordLostHyperlink, 375, 3);
					passwordLostHyperlink.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {

						}
					});
					passwordLostHyperlink.setText("Passwort vergessen");
				}
				{
					pswrdtxtbxPasswort = new PasswordTextBox();
					pswrdtxtbxPasswort.addBlurHandler(new BlurHandler() {
						public void onBlur(BlurEvent event) {
							if (pswrdtxtbxPasswort.getText().equals(
									"")) {
								passwordTextBox.setVisible(true);
							}
						}
					});
					
					usernameTextBox.setText("Benutzername");
					absolutePanel_1.add(pswrdtxtbxPasswort, 160, 0);
				}
				{
					passwordTextBox = new TextBox();
					absolutePanel_1.add(passwordTextBox, 160, 0);
					passwordTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							passwordTextBox.setVisible(false);
							pswrdtxtbxPasswort.setFocus(true);
						}
					});
					passwordTextBox.setText("Passwort");
				}
			}
			{
				absolutePanel = new AbsolutePanel();
				verticalPanel.add(absolutePanel);
				absolutePanel.setSize("550", "30");
				{
					pwLostUsernameTextBox = new TextBox();
					absolutePanel.add(pwLostUsernameTextBox, 5, 0);
					pwLostUsernameTextBox.setText("Benutzername");
					pwLostUsernameTextBox.addBlurHandler(new BlurHandler() {
						public void onBlur(BlurEvent event) {
							if (pwLostUsernameTextBox.getText().equals(
									"")) {
								pwLostUsernameTextBox.setText("Benutzername");
							}
						}
					});
					pwLostUsernameTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							if (pwLostUsernameTextBox.getText().equals(
									"Benutzername")) {
								pwLostUsernameTextBox.setText("");
							}
						}
					});
				}
				{
					pwLostEmailTextBox = new TextBox();
					absolutePanel.add(pwLostEmailTextBox, 160, 0);
					pwLostEmailTextBox.setText("eMail");
					pwLostEmailTextBox.addBlurHandler(new BlurHandler() {
						public void onBlur(BlurEvent event) {
							if (pwLostEmailTextBox.getText().equals(
									"")) {
								pwLostEmailTextBox.setText("eMail");
							}
						}
					});
					pwLostEmailTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							if (pwLostEmailTextBox.getText().equals(
									"eMail")) {
								pwLostEmailTextBox.setText("");
							}
						}
					});
				}
				{
					pwLostButton = new Button();
					absolutePanel.add(pwLostButton, 323, 0);
					pwLostButton.setText("Passwort an mich senden");
				}
			}
		}

	}

	/**
	 * Schickt die validierten Formulardaten an den ProfileManager, und wartet
	 * auf Rückmeldung
	 */
	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet auf
	 * Rückmeldung
	 */
	public boolean submit() {
		if (Validation.validateLoginForm(this)) {
			// Sende Daten an Server
			userManager.loginRequest("Test", "123",
					new AsyncCallback<Integer>() {
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