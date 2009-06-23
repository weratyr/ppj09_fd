/*
* @(#)LoginForm.java        20.04.09
*
* Copyright (c) 2008-2009 Project Team 4711
* All rights reserved.
*/
 
package ppj09.gwt.swapweb.client.gui;
 
import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;
 
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.KeyListener;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
 
/**
* Formularfelder und Submit des Login. Der Benutzer hat die Möglichkeit, seine
* Logindaten einzugeben. Diese Klasse implementiert das Interface Form.
*
* @author Christian Happ
* @author Projekt Team 4711
* @version 0.1, 04.05.09
*/
public class LoginForm implements Form {
 
  /*
   * Erstellt ein remote service proxy, um mit dem UserManager der Serverseite
   * zu kommunizieren.
   */
  private final UserManagerAsync userManager = GWT.create(UserManager.class);
  private TextField txtbxUsername;
  private FormPanel formPanel;
  private TextField txtbxPassword;
  private MultiFieldPanel multiPanel1;
  private Button loginButton;
  private Hyperlink lostPwHyperlink;
 
  /**
   * Initialisiert Formular Eingabefelder
   */
  public LoginForm(TabPanel outerTabPanel) {
    {
      formPanel = new FormPanel();
      formPanel.setLabelAlign(Position.TOP);
      formPanel.setTitle("Login");
      formPanel.setFooter(true);
      formPanel.setMonitorValid(true);
      formPanel.setBorder(false);
 
      {
        txtbxUsername = new TextField("Benutzername", "text_field", 190);
        txtbxUsername.setAllowBlank(false);
        txtbxUsername
            .setBlankText("Bitte geben Sie ihren Benutzernamen ein");
        txtbxUsername.setTabIndex(1);
        txtbxUsername.focus();
        txtbxUsername.addKeyListener(13, new KeyListener() {
          public void onKey(int key, EventObject e) {
            if (txtbxUsername.isValid() && txtbxPassword.isValid()) {
              submit();
            }
          }
        });
 
        txtbxPassword = new TextField("Passwort", "text_field", 190);
        txtbxPassword.setAllowBlank(false);
        txtbxPassword.setPassword(true);
        txtbxPassword.setBlankText("Bitte geben Sie ihr Passwort ein");
        txtbxPassword.setMinLength(8);
        txtbxPassword
            .setMinLengthText("Das Passwort muss mindestens acht Zeichen lang sein");
        txtbxPassword.setTabIndex(2);
        txtbxPassword.addKeyListener(13, new KeyListener() {
          public void onKey(int key, EventObject e) {
            if (txtbxUsername.isValid() && txtbxPassword.isValid()) {
              submit();
            }
          }
        });
 
        multiPanel1 = new MultiFieldPanel();
        multiPanel1.addToRow(txtbxUsername, 210);
        multiPanel1.addToRow(txtbxPassword, new ColumnLayoutData(1));
        multiPanel1.setBorder(false);
        formPanel.add(multiPanel1);
 
        loginButton = new Button("Login");
        loginButton.setFormBind(true);
        loginButton.setTabIndex(3);
        loginButton.addListener(new ButtonListenerAdapter() {
          public void onClick(Button button, EventObject e) {
            if (txtbxUsername.isValid() && txtbxPassword.isValid()) {
              submit();
            }
          }
        });
 
        lostPwHyperlink = new Hyperlink("Passwort vergessen", false,
            "newHistoryToken");
 
        multiPanel1 = new MultiFieldPanel();
        multiPanel1.addToRow(loginButton, 60);
        multiPanel1.addToRow(lostPwHyperlink, new ColumnLayoutData(1));
        multiPanel1.setBorder(false);
        formPanel.add(multiPanel1);
 
      }
      outerTabPanel.add(formPanel);
    }
 
  }
 
  /**
   * Schickt die validierten Formulardaten an den UserManager und wartet auf
   * Rueckmeldung
   */
  public boolean submit() {
    // Sende Daten an Server
 
    String username = txtbxUsername.getText();
    String password = txtbxPassword.getText();
    userManager.loginRequest(username, password,
        new AsyncCallback<Boolean>() {
          public void onFailure(Throwable caught) {
            // :(
            System.out.println("Benutzername oder Passwort falsch");
          }
 
          public void onSuccess(Boolean serverMsg) {
            // :)
            if (serverMsg) {
              System.out.println("Eingeloggt");
              SwapWeb.setLoggedin(txtbxUsername.getText());
              SwapWeb.addMeinSwapWeb();
              SwapWeb.getTabPanel().remove("2");
              SwapWeb.getTabPanel().remove("2");
            } else
              System.out
                  .println("Benutzername oder Passwort falsch");
          }
 
        });
    return true;
 
  }
}