/*
 * @(#)UserForm.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
//import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

/**
 * Formularfelder und Submit des Benutzers zur Registrierung. Implementiert das
 * Interface Form
 * 
 * @author Georg Ortwein
 * @author Projekt Team 4711
 * @version 0.3, 26.05.09
 */
public class UserRegistrationForm implements Form {
	private HorizontalPanel horizontalPanel;
	private FormPanel formPanel;
	private MultiFieldPanel cityPanel, streetPanel;
	private NumberField txtbxZip;
	private TextField txtbxCity;
	private TextField txtbxLastName;
	private TextField txtbxFirstName;
	private TextField txtbxUsername;
	private TextField txtbxStreet;
	private NumberField txtbxNumber;
	private TextField txtbxPassword;
	private TextField txtbxPassword2;
	private TextField txtbxEmail2;
	private TextField txtbxEmail;
	private Button regButton;
	private MultiFieldPanel panel1;
	private MultiFieldPanel panel2;
	private MultiFieldPanel panel3;
	private MultiFieldPanel panel4;
	private MultiFieldPanel panel5;
	private TextField dummy;
	private Label txtbxUserFree;
	private MultiFieldPanel userFreePanel;
	private final Window window;
	private TextField hiddenText;

	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public UserRegistrationForm(TabPanel outerTabPanel) {
		{
			Panel panelContainer = new Panel();
			panelContainer.setTitle("Registrieren");
			horizontalPanel = new HorizontalPanel();
			
			{
				formPanel = new FormPanel();
				formPanel.setLabelAlign(Position.RIGHT);
				formPanel.setLabelWidth(100);
				formPanel.setBorder(false);
				formPanel.setFooter(true);
				formPanel.setMonitorValid(true);
				formPanel.setLabelAlign(Position.TOP);
				{

					txtbxFirstName = new TextField("Vorname", "text_field", 190);
					txtbxFirstName.setAllowBlank(false);
					txtbxFirstName.setTabIndex(1);
					txtbxFirstName
							.setBlankText("Bitte geben Sie ihren Vornamen ein");

					txtbxUsername = new TextField("Benutzername", "text_field",
							190);
					txtbxUsername.setAllowBlank(false);
					txtbxUsername.setMinLength(5);
					txtbxUsername
							.setMinLengthText("Der Benutzername muss mindestens 5 Zeichen lang sein");
					txtbxUsername.setTabIndex(7);
					txtbxUsername
							.setBlankText("Bitte geben Sie ihren gew&uuml;nschten Benutzernamen ein");
					txtbxUsername.addListener(new TextFieldListenerAdapter() {
						public void onBlur(Field field) {
							if (txtbxUsername.isValid()) {
								checkUsername(txtbxUsername.getText());
							}
						}
					});

					txtbxUserFree = new Label();
					txtbxUserFree.setText("Benutzername schon vergeben!");
					txtbxUserFree.setVisible(false);

					panel1 = new MultiFieldPanel();
					panel1.addToRow(txtbxFirstName, 250);
					panel1.addToRow(txtbxUsername, new ColumnLayoutData(1));
					panel1.setBorder(false);

					userFreePanel = new MultiFieldPanel();
					userFreePanel.addToRow(panel1, 460);
					userFreePanel.addToRow(txtbxUserFree, new ColumnLayoutData(
							1));
					userFreePanel.setBorder(false);
					formPanel.add(userFreePanel);

					txtbxLastName = new TextField("Nachname", "text_field", 190);
					txtbxLastName.setAllowBlank(false);
					txtbxLastName.setTabIndex(2);
					txtbxLastName
							.setBlankText("Bitte geben Sie ihren Nachnamen ein");

					txtbxPassword = new TextField("Passwort", "text_field", 190);
					txtbxPassword.setAllowBlank(false);
					txtbxPassword.setTabIndex(8);
					txtbxPassword
							.setBlankText("Bitte geben Sie ihr gew&uuml;nschtes Passwort ein <br>(mindestens acht Zeichen)");
					txtbxPassword.setMinLength(8);
					txtbxPassword.setPassword(true);
					
					panel2 = new MultiFieldPanel();
					panel2.addToRow(txtbxLastName, 250);
					panel2.addToRow(txtbxPassword, new ColumnLayoutData(1));
					panel2.setBorder(false);
					formPanel.add(panel2);

					txtbxStreet = new TextField("Stra\u00DFe", "text_field",
							165);
					txtbxStreet.setSize("145px", "20px");
					txtbxStreet.setAllowBlank(false);
					txtbxStreet.setTabIndex(3);
					txtbxStreet
							.setBlankText("Bitte geben Sie ihre Stra\u00DFe und Hausnummer ein");

					txtbxNumber = new NumberField("Nr.", "number_field", 40);
					// txtbxNumber.setHideLabel(true);
					txtbxNumber.setAllowDecimals(false);
					txtbxNumber.setAllowBlank(false);
					txtbxNumber.setTabIndex(4);
					txtbxNumber
							.setBlankText("Bitte geben Sie ihre Stra\u00DFe und Hausnummer ein");

					streetPanel = new MultiFieldPanel();
					streetPanel.addToRow(txtbxStreet, 150);
					streetPanel.addToRow(txtbxNumber, new ColumnLayoutData(1));
					streetPanel.setBorder(false);

					txtbxPassword2 = new TextField("Passwort wdh.",
							"text_field", 190);
					txtbxPassword2.setAllowBlank(false);
					txtbxPassword2.setTabIndex(9);
					txtbxPassword2
							.setBlankText("Bitte wiederholen Sie ihr Passwort");
					txtbxPassword2.setPassword(true);
					
					panel3 = new MultiFieldPanel();
					panel3.addToRow(streetPanel, 250);
					panel3.addToRow(txtbxPassword2, new ColumnLayoutData(1));
					panel3.setBorder(false);
					formPanel.add(panel3);

					txtbxZip = new NumberField("Plz", "number_field", 50);
					txtbxZip.setAllowBlank(false);
					txtbxZip.setAllowDecimals(false);
					txtbxZip.setTabIndex(5);
					txtbxZip
							.setBlankText("Bitte geben Sie ihre Postleitzahl ein");
					txtbxZip.setMinLength(5);
					txtbxZip.setMaxLength(5);
					txtbxZip
							.setMinLengthText("Die Postleitzahl muss aus 5 Ziffern bestehen");
					txtbxZip
							.setMaxLengthText("Die Postleitzahl muss aus 5 Ziffern bestehen");

					txtbxCity = new TextField("Wohnort", "text_field", 135);
					txtbxCity.setAllowBlank(false);
					// txtbxCity.setHideLabel(true);
					txtbxCity.setTabIndex(6);
					txtbxNumber
							.setBlankText("Bitte geben Sie ihren Wohnort ein");

					cityPanel = new MultiFieldPanel();
					cityPanel.addToRow(txtbxZip, 55);
					cityPanel.addToRow(txtbxCity, new ColumnLayoutData(1));
					cityPanel.setBorder(false);

					txtbxEmail = new TextField("eMail", "text_field", 190);
					txtbxEmail.setAllowBlank(false);
					txtbxEmail.setTabIndex(10);
					txtbxEmail
							.setBlankText("Bitte geben Sie ihre eMail Adresse ein");
					txtbxEmail.setVtype(VType.EMAIL);
					txtbxEmail.isValidateOnBlur();

					panel4 = new MultiFieldPanel();
					panel4.addToRow(cityPanel, 250);
					panel4.addToRow(txtbxEmail, new ColumnLayoutData(1));
					panel4.setBorder(false);
					formPanel.add(panel4);

					dummy = new TextField("dummy", "text_field", 190);
					dummy.setVisible(false);
					dummy.setHideLabel(true);

					txtbxEmail2 = new TextField("eMail wdh.", "text_field", 190);
					txtbxEmail2.setAllowBlank(false);
					txtbxEmail2.setTabIndex(11);
					txtbxEmail2
							.setBlankText("Bitte wiederholen Sie ihre eMail Adresse");
					txtbxEmail2.setVtype(VType.EMAIL);
					txtbxEmail2.isValidateOnBlur();

					panel5 = new MultiFieldPanel();
					panel5.addToRow(dummy, 250);
					panel5.addToRow(txtbxEmail2, new ColumnLayoutData(1));
					panel5.setBorder(false);
					formPanel.add(panel5);
					
					
					// // AB HIER FORM FÜR FILE UPLOAD

				     final com.google.gwt.user.client.ui.FormPanel form = new com.google.gwt.user.client.ui.FormPanel();
				     form.setAction(GWT.getModuleBaseURL()
				       + "UserImageUploadHandler");

				     // Because we're going to add a FileUpload widget, we'll
				     // need to set the
				     // form to use the POST method, and multipart MIME encoding.
				     form
				       .setEncoding(com.google.gwt.user.client.ui.FormPanel.ENCODING_MULTIPART);
				     form
				       .setMethod(com.google.gwt.user.client.ui.FormPanel.METHOD_POST);

				     VerticalPanel panel = new VerticalPanel();
				     form.setWidget(panel);

				     // Create a FileUpload widget.
				     final FileUpload upload = new FileUpload();
				     upload.setName("uploadFormElement");

				     hiddenText = new TextField();
				     hiddenText.setName("uploadHiddenElement");
				     hiddenText.setVisible(false);
				     
				     panel.add(upload);
				     panel.add(hiddenText);

				     Button button2 = new Button("Submit");
				     button2.addListener(new ButtonListenerAdapter() {
				      public void onClick(Button button, EventObject e) {
				    	  if(validateImageExtension(upload.getFilename())) {
				             form.submit();
						  } else {
							 MessageBox.alert("Bitte wählen Sie ein Bild mit der Endung\n \"jpg\", \"png\" oder \"bmp\" aus.");
						  }

				      }
				     });

				     // Add a 'submit' button.
				     panel.add(button2);

				     form.addSubmitHandler(new SubmitHandler() {

				      public void onSubmit(SubmitEvent event) {
				       if (upload.getFilename().length() == 0) {
				        MessageBox
				          .alert("The text box must not be empty");
				        event.cancel();
				       } else {
				        MessageBox.show(new MessageBoxConfig() {
				         {
				          setMsg("Ihr Bild wird gespeichert, bitte warten...");
				          setProgressText("Speichern...");
				          setWidth(300);
				          setWait(true);
				          setWaitConfig(new WaitConfig() {
				           {
				            setInterval(200);
				           }
				          });
				          setAnimEl(regButton.getId());
				         }
				        });

				        Timer timer = new Timer() {
				         public void run() {
				          MessageBox.hide();
				          System.out
				            .println("Done, Your fake data was saved!");
				         }
				        };
				        timer.schedule(8000);
				       }
				      }
				     });

				     form.addSubmitCompleteHandler(new SubmitCompleteHandler() {
				      public void onSubmitComplete(SubmitCompleteEvent event) {
				       // When the form submission is successfully
				       // completed, this event is
				       // fired. Assuming the service returned a response
				       // of type text/html,
				       // we can get the result text here (see the
				       // FormPanel documentation for
				       // further explanation).
				       MessageBox.alert(event.getResults());
				      }
				     });

				     window = new Window();
				     window.setTitle("Bild hochladen");
				     window.setClosable(true);
				     window.setWidth(600);
				     window.setHeight(350);
				     window.setPlain(true);
				     window.add(form);
				     window.setCloseAction(Window.HIDE);

				     /*
				     uploadWindowButton = new Button("Bild hochladen");
				     uploadWindowButton.addListener(new ButtonListenerAdapter() {
				      public void onClick(Button button, EventObject e) {
				       window.show(submitButton.getId());
				      }
				     });
				     formPanel.add(uploadWindowButton);
					 */
				     // //// ENDE FORMS FÜR FILE UPLOAD
					
					
					
					

					regButton = new Button("Registrieren");
					regButton.setTabIndex(12);
					regButton.setFormBind(true);

					formPanel.addButton(regButton);
					regButton.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							if (validate()) {
								submit();
							}
						}
					});

					horizontalPanel.add(formPanel);
					panelContainer.add(horizontalPanel);
					outerTabPanel.add(panelContainer);
				}

			}

		}
		
	}
	
	public boolean validateImageExtension(String filename){
		boolean isAllowdExt = false;
		
		int indexPoint = filename.lastIndexOf(".");
	    int length = filename.length();
	       
	    String extension = filename.substring(indexPoint+1, length);
		
	    if (extension.equals("jpg") || extension.equals("png") || extension.equals("bmp")) {
	    	isAllowdExt = true;
	    }
	    
		return isAllowdExt;
    }

	public boolean validate() {
		if (formPanel.getForm().isValid()) {

			if (txtbxPassword.getText().length() < 8) {
				MessageBox.alert("Fehler!", "Ihr Passwort ist zu kurz.");
				txtbxPassword.reset();
				txtbxPassword2.reset();
				return false;
			} else if (!validateEmail() && validatePassword()) {
				MessageBox.alert("Fehler!", "eMails stimmen nicht �berein.");
				return false;
			} else if (!validatePassword() && validateEmail()) {
				txtbxPassword.reset();
				txtbxPassword2.reset();
				MessageBox.alert("Fehler!",
						"Passw&ooml;rter stimmen nicht �berein.");
				return false;
			} else if (!validateEmail() && !validatePassword()) {
				txtbxPassword.reset();
				txtbxPassword2.reset();
				MessageBox.alert("Fehler!",
						"Passw&ooml;rter und eMails stimmen nicht �berein.");
				return false;
			} else if (txtbxUserFree.isVisible()) {
				MessageBox.alert("Fehler!",
						"Der Benutzername ist schon vergeben.");
			} else {
				MessageBox.alert("kein Fehler", "Alles okay");
				return true;
			}
		}
		return false;
	}

	public boolean validateEmail() {
		if (txtbxEmail.getText().equals(txtbxEmail2.getText())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validatePassword() {
		if (txtbxPassword.getText().equals(txtbxPassword2.getText())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Schickt die validierten Formulardaten an den UserManager, und wartet auf
	 * Rueckmeldung
	 */
	public boolean submit() {
		// if (Validation.validateRegisterForm(this)) {
		// TODO
		// Sende Daten an Server
		User user = new User();
		user = fillUser(user);
		System.out.println("test1");

		UserManagerAsync userManager = GWT.create(UserManager.class);

		userManager.createUser(user, new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				// :(
				System.out.println("neeee: " + caught.getMessage());
			}

			public void onSuccess(Integer serverMsg) {
				// :)
				System.out.println("OK: " + serverMsg.toString());
				if(serverMsg == 2){
			    	MessageBox.alert("ACHTUNG: Sie sind nicht eingeloggt. Bitte Melden Sie sich an.");
			    } else if (serverMsg > 2) {
			        //formPanel.getForm().reset();
			        hiddenText.setRawValue(serverMsg.toString());
			        window.show(regButton.getId());
			    } else if (serverMsg == 0){
			    	MessageBox.alert("FEHLER: Ihr Artikel konnte nicht angelegt werden.");
			    }
			}
		});
		// }
		return true;

	}

	private User fillUser(User user) {
		user.setFirstName(txtbxFirstName.getText());
		user.setLastName(txtbxLastName.getText());
		user.setStreet(txtbxStreet.getText());
		user.setHouseNumber(txtbxNumber.getText());
		user.setZip(txtbxZip.getText());
		user.setCity(txtbxCity.getText());
		user.setUsername(txtbxUsername.getText());
		user.setPassword(txtbxPassword.getText());
		user.setEmail(txtbxEmail.getText());

		return user;

	}

	/**
	 * sendet den eingegeben Benutzernamen an den Server, welcher �berpr�ft ob
	 * dieser noch frei ist. Ist der Benutzername schon vergeben, wird das
	 * textField txtbxUserFree sichtbar geschaltet,
	 * 
	 * @param username
	 */
	public void checkUsername(String username) {
		// TODO rpc zum �berpr�fen ob der Benutzername noch frei ist
		// Sende Daten an Server

		System.out.println("test2");

		UserManagerAsync userManager = GWT.create(UserManager.class);

		userManager.checkUsername(username, new AsyncCallback<Boolean>() {
			public void onFailure(Throwable caught) {
				// :(
				//Window.alert("fehler");

			}

			public void onSuccess(Boolean serverMsg) {
				// :)
				if (serverMsg) {
				//Window.alert("test");

				txtbxUserFree.setVisible(true);
				} else {
					txtbxUserFree.setVisible(false);
				}
			}
		});
	}

}