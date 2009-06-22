package ppj09.gwt.swapweb.client.gui;



/**

 * Autor Daniel Abeska

 * Klasse User- Form ist zum ï¿½ndern bzw. bearbeiten eines Profils

 */



import java.util.Date;



import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.User;

import ppj09.gwt.swapweb.client.serverInterface.UserManager;

import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;



import com.google.gwt.user.client.Timer;

//import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.AbsolutePanel;

import com.google.gwt.user.client.ui.FileUpload;

import com.google.gwt.user.client.ui.Image;

import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.HorizontalPanel;

import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;

import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;

import com.gwtext.client.core.EventObject;

import com.gwtext.client.core.Position;

import com.gwtext.client.data.SimpleStore;

import com.gwtext.client.data.Store;

import com.gwtext.client.widgets.Window;

import com.gwtext.client.widgets.Button;

import com.gwtext.client.widgets.Component;

import com.gwtext.client.widgets.MessageBox;

import com.gwtext.client.widgets.MessageBoxConfig;

import com.gwtext.client.widgets.WaitConfig;

import com.gwtext.client.widgets.event.ButtonListenerAdapter;

import com.gwtext.client.widgets.form.ComboBox;

import com.gwtext.client.widgets.form.DateField;

import com.gwtext.client.widgets.form.Field;

import com.gwtext.client.widgets.form.MultiFieldPanel;

import com.gwtext.client.widgets.form.NumberField;

import com.gwtext.client.widgets.form.TextField;

import com.gwtext.client.widgets.form.VType;

import com.google.gwt.core.client.GWT;

import com.gwtext.client.widgets.form.FormPanel;

import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;

import com.gwtext.client.widgets.layout.ColumnLayoutData;

import com.gwtext.client.widgets.form.TextArea;



public class UserForm extends Composite implements View {

	private User user;

	private boolean checkedPw;

	private TextField txtbxFirstName;

	private TextField txtbxLastName;

	private TextField txtbxZip;

	private MultiFieldPanel panel1;

	private TextField txtbxCity;

	private TextField txtbxStreet;

	private NumberField txtbxNumber;

	private MultiFieldPanel streetPanel;

	private TextField txtbxUsername;

	private TextField txtbxPwd;

	private MultiFieldPanel userFreePanel;

	private Label txtbxUserFree;

	private TextField txtbxEmail;

	private TextField txtbxEmail2;

	private Label usernameLabel1;

	private Label usernameLabel2;

	private Label usernameLabel3;

	private HorizontalPanel horizontalPanel2;

	private FormPanel formPanelTop;

	private AbsolutePanel absolutePanel;

	private HorizontalPanel horizontalPanel;

	private Image image;

	private ComboBox comboBoxGender;

	private DateField dateField;

	private TextField txtbxJob;

	private TextArea txtbxHobbys;

	private TextArea txtbxMusic;

	private TextArea txtbxMovie;

	private TextArea txtbxILike;

	private TextArea txtbxIDontLike;

	private TextArea txtbxAboutMe;

	private TextField txtbxIcq;

	private TextField txtbxYahoo;

	private TextField txtbxMsn;

	private TextField txtbxJabber;

	private TextField txtbxHomepage;

	private TextField txtbxAim;

	private Button resetButton;

	private Button submitButton;

	private Button uploadWindowButton;

	private MultiFieldPanel panelButton;

	private TextField imageUploader;

	private TextField txtbxPwdNew2;

	private TextField txtbxPwdNew;

	private Window window;

	private TextField hiddenText;



	/**

	 * Constructor

	 * 

	 * @param username

	 * 

	 */



	public UserForm() {



		createForm();

		getuser();



	}

	public UserForm(User user) {

		createForm();

	}



	public void createForm() {

		{

			VerticalPanel verticalPanel = new VerticalPanel();

			initWidget(verticalPanel);

			SwapWeb.getContentPanel().setTitle("Profil bearbeiten");






			{

				horizontalPanel = new HorizontalPanel();

				verticalPanel.add(horizontalPanel);

				{

					absolutePanel = new AbsolutePanel();

					horizontalPanel.add(absolutePanel);

					absolutePanel.setSize("200", "200");



					image = new Image();

					image.setPixelSize(150, 150);

					absolutePanel.add(image, 0, 0);



					//imageUploader = new TextField("File", "file");

					//imageUploader.setInputType("file");

					//absolutePanel.add(imageUploader, 0, 160);

					

					

					

					

					

					

					// // AB HIER FORM FÜR FILE UPLOAD



				     final com.google.gwt.user.client.ui.FormPanel form = new com.google.gwt.user.client.ui.FormPanel();

				     form.setAction(GWT.getModuleBaseURL()

				       + "UserImageUpdateHandler");



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

				          setAnimEl(uploadWindowButton.getId());

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

				       getuser();

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



				     

				     uploadWindowButton = new Button("Bild hochladen");

				     uploadWindowButton.addListener(new ButtonListenerAdapter() {

				      public void onClick(Button button, EventObject e) {

				       window.show(submitButton.getId());

				      }

				     });

				     absolutePanel.add(uploadWindowButton, 0, 160);

					 

				     // //// ENDE FORMS FÜR FILE UPLOAD

					

				}

				{

					formPanelTop = new FormPanel();

					formPanelTop.setLabelAlign(Position.RIGHT);

					formPanelTop.setFooter(true);

					formPanelTop.setWidth(470);

					formPanelTop.setBorder(false);

		

					// formPanelTop.setBorder(false);

					{

						txtbxFirstName = new TextField("Vorname*",

								"text_field", 190);

						txtbxFirstName.setAllowBlank(false);

						txtbxFirstName.setSelectOnFocus(true);

						formPanelTop.add(txtbxFirstName);



						txtbxLastName = new TextField("Nachname*",

								"text_field", 190);

						txtbxLastName.setAllowBlank(false);

						txtbxLastName.setSelectOnFocus(true);

						formPanelTop.add(txtbxLastName);



						txtbxStreet = new TextField("Stra\u00DFe* / Nr.*",

								"text_field", 145);

						txtbxStreet.setAllowBlank(false);

						txtbxStreet

								.setBlankText("Bitte geben Sie ihre Stra\u00DFe und Hausnummer ein");

						txtbxStreet.setSelectOnFocus(true);



						txtbxNumber = new NumberField("Nr.", "number_field", 40);

						txtbxNumber.setHideLabel(true);

						txtbxNumber.setAllowDecimals(false);

						txtbxNumber.setAllowBlank(false);

						txtbxNumber

								.setBlankText("Bitte geben Sie ihre Stra\u00DFe und Hausnummer ein");

						txtbxNumber.setSelectOnFocus(true);



						streetPanel = new MultiFieldPanel();

						streetPanel.addToRow(txtbxStreet, 255);

						streetPanel.addToRow(txtbxNumber, new ColumnLayoutData(

								1));

						streetPanel.setBorder(false);

						formPanelTop.add(streetPanel);



						txtbxZip = new TextField("Plz* / Wohnort*",

								"text_field", 50);

						txtbxZip.setAllowBlank(false);

						txtbxZip.setSelectOnFocus(true);



						txtbxCity = new TextField("Wohnort", "text_field", 135);

						txtbxCity.setAllowBlank(false);

						txtbxCity.setHideLabel(true);

						txtbxCity.setSelectOnFocus(true);



						panel1 = new MultiFieldPanel();

						panel1.addToRow(txtbxZip, 160);

						panel1.addToRow(txtbxCity, new ColumnLayoutData(1));

						panel1.setBorder(false);

						formPanelTop.add(panel1);



						txtbxEmail = new TextField("eMail*", "text_field", 190);

						txtbxEmail.setAllowBlank(false);

						txtbxEmail

								.setBlankText("Bitte geben Sie ihre eMail Adresse ein");

						txtbxEmail.setVtype(VType.EMAIL);

						txtbxEmail.setSelectOnFocus(true);

						txtbxEmail.isValidateOnBlur();

						formPanelTop.add(txtbxEmail);



						txtbxEmail2 = new TextField("eMail wdh.*",

								"text_field", 190);

						txtbxEmail2.setAllowBlank(false);

						txtbxEmail2

								.setBlankText("Bitte wiederholen Sie ihre eMail Adresse");

						txtbxEmail2.setVtype(VType.EMAIL);

						txtbxEmail2.setSelectOnFocus(true);

						txtbxEmail2.isValidateOnBlur();

						formPanelTop.add(txtbxEmail2);



						// TODO

						txtbxPwd = new TextField("Altes Passwort",

								"text_field", 190);

						txtbxPwd.setSelectOnFocus(true);

						txtbxPwd.setPassword(true);

						txtbxPwd.setMinLength(8);

						txtbxPwd

								.setMinLengthText("Das Passwort muss mindestens acht Zeichen lang sein");

						txtbxPwd.setValidateOnBlur(true);

						formPanelTop.add(txtbxPwd);



						// TODO

						txtbxPwdNew = new TextField("Neues Passwort",

								"text_field", 190);

						txtbxPwdNew.setSelectOnFocus(true);

						txtbxPwdNew.setPassword(true);

						txtbxPwdNew.setMinLength(8);

						txtbxPwdNew

								.setMinLengthText("Das Passwort muss mindestens acht Zeichen lang sein");

						txtbxPwdNew.setValidateOnBlur(true);

						formPanelTop.add(txtbxPwdNew);



						// TODO

						txtbxPwdNew2 = new TextField(

								"Neues Passwort wiederholen", "text_field", 190);

						txtbxPwdNew2.setSelectOnFocus(true);

						txtbxPwdNew2.setPassword(true);

						txtbxPwdNew2.setMinLength(8);

						txtbxPwdNew2

								.setMinLengthText("Das Passwort muss mindestens acht Zeichen lang sein");

						txtbxPwdNew2.setValidateOnBlur(true);

						formPanelTop.add(txtbxPwdNew2);



						final Store store = new SimpleStore(new String[] {

								"geschlecht", "nr" }, new String[][] {

								new String[] { "-", "0" },

								new String[] { "M\u00E4nnlich", "1" },

								new String[] { "Weiblich", "2" } });

						store.load();



						// TODO

						comboBoxGender = new ComboBox();

						comboBoxGender.setFieldLabel("Geschlecht");

						comboBoxGender.setStore(store);

						comboBoxGender.setDisplayField("geschlecht");

						comboBoxGender.setMode(ComboBox.LOCAL);

						comboBoxGender.setTriggerAction(ComboBox.ALL);

						comboBoxGender.setTypeAhead(true);

						comboBoxGender.setEditable(false);

						comboBoxGender.setSelectOnFocus(true);

						comboBoxGender.setWidth(190);

						comboBoxGender.setHideTrigger(false);

						formPanelTop.add(comboBoxGender);



						dateField = new DateField("Geburtstag ", "date_Field",

								190);

						formPanelTop.add(dateField);



						txtbxJob = new TextField("Beruf ", "text_field", 190);

						txtbxJob.setSelectOnFocus(true);

						txtbxJob.isValidateOnBlur();

						formPanelTop.add(txtbxJob);



						txtbxHomepage = new TextField("Homepage ",

								"text_field", 190);

						txtbxHomepage.setSelectOnFocus(true);

						formPanelTop.add(txtbxHomepage);



						txtbxHobbys = new TextArea("Hobbys ", "text_field");

						txtbxHobbys.setSize(190, 80);

						txtbxHobbys.setSelectOnFocus(true);

						txtbxHobbys.isValidateOnBlur();

						formPanelTop.add(txtbxHobbys);



						txtbxMusic = new TextArea("Musikgeschmack ",

								"text_field");

						txtbxMusic.setSize(190, 80);

						txtbxMusic.setSelectOnFocus(true);

						txtbxMusic.isValidateOnBlur();

						formPanelTop.add(txtbxMusic);



						txtbxMovie = new TextArea("Filmgeschmack ",

								"text_field");

						txtbxMovie.setSize(190, 80);

						txtbxMovie.setSelectOnFocus(true);

						txtbxMovie.isValidateOnBlur();

						formPanelTop.add(txtbxMovie);



						txtbxILike = new TextArea("Ich mag ", "text_field");

						txtbxILike.setSize(190, 80);

						txtbxILike.setSelectOnFocus(true);

						txtbxILike.isValidateOnBlur();

						formPanelTop.add(txtbxILike);



						txtbxIDontLike = new TextArea("Ich mag nicht ",

								"text_field");

						txtbxIDontLike.setSize(190, 80);

						txtbxIDontLike.setSelectOnFocus(true);

						txtbxIDontLike.isValidateOnBlur();

						formPanelTop.add(txtbxIDontLike);



						txtbxAboutMe = new TextArea("&uuml;ber mich ",

								"text_field");

						txtbxAboutMe.setSize(190, 80);

						txtbxAboutMe.setSelectOnFocus(true);

						txtbxAboutMe.isValidateOnBlur();

						formPanelTop.add(txtbxAboutMe);



						txtbxIcq = new TextField("ICQ ", "text_field", 190);

						txtbxIcq.setSelectOnFocus(true);

						formPanelTop.add(txtbxIcq);



						txtbxMsn = new TextField("MSN ", "text_field", 190);

						txtbxMsn.setSelectOnFocus(true);

						formPanelTop.add(txtbxMsn);



						txtbxYahoo = new TextField("Yahoo ", "text_field", 190);

						txtbxYahoo.setSelectOnFocus(true);

						formPanelTop.add(txtbxYahoo);



						txtbxAim = new TextField("AIM ", "text_field", 190);

						txtbxAim.setSelectOnFocus(true);

						formPanelTop.add(txtbxAim);



						txtbxJabber = new TextField("Jabber ", "text_field",

								190);

						txtbxJabber.setSelectOnFocus(true);

						formPanelTop.add(txtbxJabber);



						resetButton = new Button("Abbrechen");

						resetButton.setFormBind(true);

						resetButton.addListener(new ButtonListenerAdapter() {

							public void onClick(Button button, EventObject e) {

								// TODO

							}



						});



						submitButton = new Button("Speichern");

						submitButton.setFormBind(true);

						submitButton.addListener(new ButtonListenerAdapter() {

							public void onClick(Button button, EventObject e) {

								// TODO

								submit();

								//checkPassword(txtbxPwd.getText());

							}

						});



						panelButton = new MultiFieldPanel();

						panelButton.addToRow(resetButton, 160);

						panelButton.addToRow(submitButton,

								new ColumnLayoutData(1));

						panelButton.setBorder(false);

						formPanelTop.add(panelButton);



					}

					horizontalPanel.add(formPanelTop);

				}

			}



		}

	}



	private boolean submit() {



		fillUser(user);

		System.out.println("test submit");



		UserManagerAsync userManager = GWT.create(UserManager.class);



		userManager.updateUser(user, new AsyncCallback<Integer>() {

			public void onFailure(Throwable caught) {

				// :(

				System.out.println("neeee: " + caught.getMessage());

			}



			public void onSuccess(Integer serverMsg) {

				// :)

				System.out.println("OK: " + serverMsg.toString());

			}

		});

		return true;

	}



	private void getuser() {

		UserManagerAsync userManager = GWT.create(UserManager.class);



		userManager.getUser(new AsyncCallback<User>() {

			public void onFailure(Throwable caught) {

				// :(

				MessageBox.alert("Sie sind nicht eingeloggt");



			}



			public void onSuccess(User userProfile) {

				// :)

				

				user = userProfile;

				fillForm(userProfile);

				

			}

		});

	}



	/**

	 * sendet den eingegeben Benutzernamen an den Server, welcher ï¿½berprï¿½ft ob

	 * dieser noch frei ist. Ist der Benutzername schon vergeben, wird das

	 * textField txtbxUserFree sichtbar geschaltet,

	 * 

	 * @param username

	 */

	public void checkUsername(String username) {

		// TODO rpc zum ï¿½berprï¿½fen ob der Benutzername noch frei ist

		// Sende Daten an Server

		UserManagerAsync userManager = GWT.create(UserManager.class);



		userManager.checkUsername(username, new AsyncCallback<Boolean>() {

			public void onFailure(Throwable caught) {

				// :(

				MessageBox.alert("Sie sind nicht eingeloggt");



			}



			public void onSuccess(Boolean serverMsg) {

				// :)

				// if (!serverMsg) {

				MessageBox.alert("test");



				txtbxUserFree.setVisible(true);

				// }

			}

		});

	}



	public boolean checkPassword(String password) {

		UserManagerAsync userManager = GWT.create(UserManager.class);



		if (!txtbxPwd.getText().equals("")) {

			if (txtbxPwdNew.getText().equals(txtbxPwdNew2.getText())

					&& !txtbxPwdNew.getText().equals("")) {

				if ((txtbxPwdNew.isValid() && txtbxPwdNew2.isValid())) {

					userManager.checkPassword(password,

							new AsyncCallback<Boolean>() {

								public void onFailure(Throwable caught) {

									// :(

									MessageBox.alert("Fehler" + caught);



								}



								public void onSuccess(Boolean serverMsg) {

									// :)

									checkedPw = serverMsg;

									if (serverMsg) {

										System.out.println("pw okay");

									} else {

										System.out.println("pw falsch");

									}



								}

							});

				} else {

					System.out.println("neue passwÃ¶rter ");

				}

			} else {

				System.out

						.println("neue PasswÃ¶rter leer/ stimmen nicht Ã¼berein");

				txtbxPwdNew.markInvalid("Das neue Passwort muss mindestens acht Zeichen haben");

				txtbxPwdNew2.markInvalid("Das neue Passwort muss mindestens acht Zeichen haben");

				}

		} else {

			System.out.println("passwort alt leer");

		}

		return checkedPw;



	}



	public void fillForm(User user) {



		try {

			this.setFirstName(user.getFirstName());

		} catch (NullPointerException e) {

		}

		try {



			this.setLastName(user.getLastName());

		} catch (NullPointerException e) {

		}

		try {



			this.setStreet(user.getStreet());

		} catch (NullPointerException e) {

		}

		try {



			this.setHouseNumber(user.getHouseNumber());

		} catch (NullPointerException e) {

		}

		try {



			this.setZip(user.getZip());

		} catch (NullPointerException e) {

		}

		try {



			this.setCity(user.getCity());

		} catch (NullPointerException e) {

		}

		try {



			this.setUsername(user.getUsername());

		} catch (NullPointerException e) {

		}

		try {



			this.setHiddenText(user.getUsername());

		} catch (NullPointerException e) {

		}

		// try {

		// this.setPwd(user.getPassword());

		// } catch (NullPointerException e) {

		// }

		try {



			this.setEmail(user.getEmail());

		} catch (NullPointerException e) {

		}

		try {



			this.setGender(user.getGender());

		} catch (NullPointerException e) {

		}

		try {



			this.setBirthdate(user.getBirthdate());

		} catch (NullPointerException e) {

		}

		try {



			this.setJob(user.getJob());

		} catch (NullPointerException e) {

		}

		try {



			this.setHomepage(user.getHomepage());

		} catch (NullPointerException e) {

		}

		try {



			this.setHobbys(user.getHobbys());

		} catch (NullPointerException e) {

		}

		try {



			this.setMusic(user.getMusic());

		} catch (NullPointerException e) {

		}

		try {



			this.setMovie(user.getMovie());

		} catch (NullPointerException e) {

		}

		try {



			this.setILike(user.getILike());

		} catch (NullPointerException e) {

		}

		try {



			this.setIDontLike(user.getIDontLike());

		} catch (NullPointerException e) {

		}

		try {



			this.setAboutMe(user.getAboutMe());

		} catch (NullPointerException e) {

		}

		try {



			this.setIcq(user.getIcq());

		} catch (NullPointerException e) {

		}

		try {



			this.setMsn(user.getMsn());

		} catch (NullPointerException e) {

		}

		try {



			this.setYahoo(user.getYahoo());

		} catch (NullPointerException e) {

		}

		try {



			this.setAim(user.getAim());

		} catch (NullPointerException e) {

		}

		try {



			this.setJabber(user.getJabber());

		} catch (NullPointerException e) {

		}

		try {



			this.setImage(user.getImage());

		} catch (NullPointerException e) {

		}

		System.out.println("test3");



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



	public void validate() {



	}



	public User fillUser(User user) {

		user.setFirstName(getFirstName());

		user.setLastName(getLastName());

		user.setStreet(getStreet());

		user.setHouseNumber(getHouseNumber());

		user.setZip(getZip());

		user.setCity(getCity());

		//user.setUsername(getUsername());

		//user.setPassword(getPwd());

		user.setEmail(getEmail());

		//user.setGender(getGender());

		//user.setBirthdate(getBirthday());

		user.setJob(getJob());

		user.setHomepage(getHomepage());

		user.setHobbys(getHobbys());

		user.setMusic(getMusic());

		user.setMovie(getMovie());

		user.setILike(getILike());

		user.setIDontLike(getIDontLike());

		user.setAboutMe(getAboutMe());

		user.setIcq(getIcq());

		user.setMsn(getMsn());

		user.setYahoo(getYahoo());

		user.setAim(getAim());

		user.setJabber(getJabber());

		user.setImage(getImage());



		return user;

	}



	/**

	 * @param firstName

	 *            the firstName to set

	 */



	public void setFirstName(String firstName) {

		this.txtbxFirstName.setRawValue(firstName);

	}



	/**

	 * @return the firstName textField

	 */

	public String getFirstName() {

		return this.txtbxFirstName.getText();

	}



	/**

	 * @param lastName

	 *            the firstName to set

	 */



	public void setLastName(String lastName) {

		this.txtbxLastName.setRawValue(lastName);

	}



	/**

	 * @return the lastName textField

	 */

	public String getLastName() {

		return this.txtbxLastName.getText();

	}



	/**

	 * @param street

	 *            the street to set

	 */



	public void setStreet(String street) {

		this.txtbxStreet.setRawValue(street);

	}



	/**

	 * @return the firstName textField

	 */

	public String getStreet() {

		return this.txtbxStreet.getText();

	}



	/**

	 * @param houseNumber

	 *            the houseNumber to set

	 */



	public void setHouseNumber(String number) {

		this.txtbxNumber.setRawValue(number);

	}



	/**

	 * @return the houseNumber textField

	 */

	public String getHouseNumber() {

		return this.txtbxNumber.getText();

	}



	/**

	 * @param zipCode

	 *            the zipCode to set

	 */

	public void setZip(String zip) {

		this.txtbxZip.setRawValue(zip);

	}



	/**

	 * @return the zipCode textField

	 */

	public String getZip() {

		return this.txtbxZip.getText();

	}



	/**

	 * @param city

	 *            the city to set

	 */

	public void setCity(String city) {

		this.txtbxCity.setRawValue(city);

	}



	/**

	 * @return the city textField

	 */

	public String getCity() {

		return this.txtbxCity.getText();

	}



	/**

	 * @param eMail

	 *            the eMail to set

	 */



	public void setEmail(String email) {

		this.txtbxEmail.setRawValue(email);

		this.txtbxEmail2.setRawValue(email);

	}



	/**

	 * @return the eMail textField

	 */

	public String getEmail() {

		return this.txtbxEmail.getText();

	}



	/**

	 * @param username

	 *            the username to set

	 */

	public void setUsername(String username) {

		// this.txtbxUsername.setRawValue(username);
		//SwapWeb.getContentPanel().setTitle("Profil bearbeiten");
	}



	/**

	 * @return the eMail textField

	 */

	public String getPwd() {

		return this.txtbxPwd.getText();

	}



	/**

	 * @param username

	 *            the username to set

	 */

	public void setPwd(String pwd) {

		this.txtbxPwd.setRawValue(pwd);

	}



	/**

	 * @return the username textField

	 */

	public String getUsername() {

		return this.txtbxUsername.getText();

	}



	/**

	 * @param username

	 *            the username to set

	 */

	public void setGender(String gender) {

		// TODO

	}



	/**

	 * @return the username textField

	 */

	public String getGender() {

		// TODO

		return "";

	}



	/**

	 * @param birthdate

	 *            the birthdate to set

	 */

	public void setBirthdate(Date date) {

		dateField.setRawValue(date.toString());

	}



	/**

	 * @return the birthdate textField

	 */

	public Date getBirthday() {

		return dateField.getValue();

	}



	/**

	 * @param job

	 *            the job to set

	 */

	public void setJob(String job) {

		this.txtbxJob.setRawValue(job);

	}



	/**

	 * @return the job textField

	 */

	public String getJob() {

		return txtbxJob.getText();

	}



	/**

	 * @param hobbys

	 *            the hobbys to set

	 */

	public void setHobbys(String hobbys) {

		this.txtbxHobbys.setRawValue(hobbys);

	}



	/**

	 * @return the hobby textArea

	 */

	public String getHobbys() {

		return txtbxHobbys.getText();

	}



	/**

	 * @param music

	 *            the music to set

	 */

	public void setMusic(String music) {

		this.txtbxMusic.setRawValue(music);

	}



	/**

	 * @return the music textArea

	 */

	public String getMusic() {

		return txtbxMusic.getText();

	}



	/**

	 * @param movie

	 *            the movie to set

	 */

	public void setMovie(String movie) {

		this.txtbxMovie.setRawValue(movie);

	}



	/**

	 * @return the movie textArea

	 */

	public String getMovie() {

		return txtbxMovie.getText();

	}



	/**

	 * @param ilike

	 *            the ilike to set

	 */

	public void setILike(String ilike) {

		this.txtbxILike.setRawValue(ilike);

	}



	/**

	 * @return the ilike textArea

	 */

	public String getILike() {

		return txtbxILike.getText();

	}



	/**

	 * @param idontlike

	 *            the idontlike to set

	 */

	public void setIDontLike(String idontlike) {

		this.txtbxIDontLike.setRawValue(idontlike);

	}



	/**

	 * @return the idontlike textArea

	 */

	public String getIDontLike() {

		return txtbxIDontLike.getText();

	}



	/**

	 * @param aboutme

	 *            the aboutme to set

	 */

	public void setAboutMe(String aboutme) {

		this.txtbxAboutMe.setRawValue(aboutme);

	}



	/**

	 * @return the aboutme textArea

	 */

	public String getAboutMe() {

		return txtbxAboutMe.getText();

	}



	/**

	 * @param icq

	 *            the icq to set

	 */

	public void setIcq(String icq) {

		this.txtbxIcq.setRawValue(icq);

	}



	/**

	 * @return the icq textArea

	 */

	public String getIcq() {

		return txtbxIcq.getText();

	}



	/**

	 * @param msn

	 *            the msn to set

	 */

	public void setMsn(String msn) {

		this.txtbxMsn.setRawValue(msn);

	}



	/**

	 * @return the msn textArea

	 */

	public String getMsn() {

		return txtbxMsn.getText();

	}



	/**

	 * @param yahoo

	 *            the yahoo to set

	 */

	public void setYahoo(String yahoo) {

		this.txtbxYahoo.setRawValue(yahoo);

	}



	/**

	 * @return the yahoo textArea

	 */

	public String getYahoo() {

		return txtbxYahoo.getText();

	}



	/**

	 * @param aim

	 *            the aim to set

	 */

	public void setAim(String aim) {

		this.txtbxAim.setRawValue(aim);

	}



	/**

	 * @return the aim textArea

	 */

	public String getAim() {

		return txtbxAim.getText();

	}



	/**

	 * @param jabber

	 *            the jabber to set

	 */

	public void setJabber(String jabber) {

		this.txtbxJabber.setRawValue(jabber);

	}



	/**

	 * @return the jabber textArea

	 */

	public String getJabber() {

		return txtbxJabber.getText();

	}



	/**

	 * @param url

	 *            the homepage to set

	 */

	public void setHomepage(String url) {

		this.txtbxHomepage.setRawValue(url);

	}



	/**

	 * @return the homepage textArea

	 */

	public String getHomepage() {

		return txtbxHomepage.getText();

	}



	/**

	 * @param imageurl

	 *            the imageurl to set

	 */

	public void setImage(String imageurl) {

		// TODO

		this.image.setUrl(imageurl);

	}



	/**

	 * @return the imageurl textArea

	 */

	public String getImage() {

		return image.getUrl();

		// TODO

	}

	

	public void setHiddenText(String username) {

		this.hiddenText.setRawValue(username);

	}

	

	public String getHiddenText() {

		return hiddenText.getText();

	}

}