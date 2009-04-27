package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	private HorizontalPanel horizontalPanel;
	private HorizontalPanel horizontalPanel_1;
	private TextBox userNameTextBox;
	private TextBox passwordTextBox;
	private Button loginButton;
	private Hyperlink pwForgottenHyperlink;
	private TextBox userName2TextBox;
	private TextBox emailTextBox;
	private Button pwForgottenButton;

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public LoginForm() {
		{
			verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);
			{
				horizontalPanel = new HorizontalPanel();
				verticalPanel.add(horizontalPanel);
				{
					userNameTextBox = new TextBox();
					horizontalPanel.add(userNameTextBox);
					userNameTextBox.setText("Benutzername");
					userNameTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							userNameTextBox.setText("");				
						}
					});
				}
				{
					passwordTextBox = new TextBox();
					horizontalPanel.add(passwordTextBox);
					passwordTextBox.setText("Passwort");
					passwordTextBox.setName("Passwort");
					passwordTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							passwordTextBox.setText("");				
						}
					});
				}
				{
					loginButton = new Button("New button");
					horizontalPanel.add(loginButton);
					loginButton.setText("Login");
					loginButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							//todo
						}
					});
				}
				
				
				/**
				 * Link "Passwort vergessen" schaltet Passwort anfordern sichtbar oder unsichtbar.
				 */
				
				
				
				{
					pwForgottenHyperlink = new Hyperlink("New hyperlink",
							false, "newHistoryToken");
					horizontalPanel.add(pwForgottenHyperlink);
					pwForgottenHyperlink.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							horizontalPanel_1.setVisible(!horizontalPanel_1.isVisible());
						}
					});
					pwForgottenHyperlink.setText("Passwort vergessen");
				}
			}
			{
				horizontalPanel_1 = new HorizontalPanel();
				horizontalPanel_1.setVisible(false);
				verticalPanel.add(horizontalPanel_1);
				{
					userName2TextBox = new TextBox();
					horizontalPanel_1.add(userName2TextBox);
					userName2TextBox.setText("Benutzername");
					userName2TextBox.setName("Benutzername");
					userName2TextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							userName2TextBox.setText("");				
						}
					});
				}
				{
					emailTextBox = new TextBox();
					horizontalPanel_1.add(emailTextBox);
					emailTextBox.setText("eMail");
					emailTextBox.setName("eMail Adresse");
					emailTextBox.addFocusHandler(new FocusHandler() {
						public void onFocus(FocusEvent event) {
							emailTextBox.setText("");				
						}
					});
				}
				{
					pwForgottenButton = new Button("New button");
					horizontalPanel_1.add(pwForgottenButton);
					pwForgottenButton.setText("Passwort Anfordern");
					pwForgottenButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							//todo
						}
					});
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