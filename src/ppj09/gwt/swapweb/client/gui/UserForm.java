package ppj09.gwt.swapweb.client.gui;

/**
 * Autor Daniel Abeska
 * Klasse User- Form ist zum ‰ndern bzw. bearbeiten eines Profils 
 */

import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.UserManager;
import ppj09.gwt.swapweb.client.serverInterface.UserManagerAsync;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.MultiFieldPanel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.form.TextArea;


public class UserForm extends Composite implements View {
	private TextField txtbxFirstName;
	private TextField txtbxLastName;
	private TextField txtbxZip;
	private MultiFieldPanel panel1;
	private TextField txtbxCity;
	private TextField txtbxStreet;
	private NumberField txtbxNumber;
	private MultiFieldPanel streetPanel;
	private TextField txtbxUsername;
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
	private DatePicker birthDatePicker;
	private DateField dateField;
	private TextField txtbxJob;
	private TextArea txtbxHobbys;
	private TextArea txtbxMusic;

	/**
	 * Constructor
	 * 
	 * @param user
	 *            object
	 */

	public UserForm(User user) {
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setStreet(user.getStreet());
		this.setHouseNumber(user.getHouseNumber());
		this.setZip(user.getZip());
		this.setCity(user.getCity());
		this.setUsername(user.getUsername());
		this.setEmail(user.getEmail());
	}

	/**
	 * testconstructor
	 */
	public UserForm() {
		createForm();
		setFirstName("test");
		setUsername("blabla");
	}

	public void createForm() {
		{
			VerticalPanel verticalPanel = new VerticalPanel();
			initWidget(verticalPanel);

			horizontalPanel2 = new HorizontalPanel();
			usernameLabel1 = new Label("Profil von:\" ");
			horizontalPanel2.add(usernameLabel1);
			usernameLabel2 = new Label("Test");
			horizontalPanel2.add(usernameLabel2);
			usernameLabel3 = new Label("\"");
			horizontalPanel2.add(usernameLabel3);
			verticalPanel.add(horizontalPanel2);

			{
				horizontalPanel = new HorizontalPanel();
				verticalPanel.add(horizontalPanel);
				{
					absolutePanel = new AbsolutePanel();
					horizontalPanel.add(absolutePanel);
					absolutePanel.setSize("200", "200");

					image = new Image();
					absolutePanel.add(image, 100, 100);
				}
				{
					formPanelTop = new FormPanel();
					formPanelTop.setLabelAlign(Position.RIGHT);
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

						txtbxUsername = new TextField("Benutzername*",
								"text_field", 190);
						txtbxUsername.setAllowBlank(false);
						txtbxUsername
								.setBlankText("Bitte geben Sie ihren gew&uuml;nschten Benutzernamen ein");
						txtbxUsername.setSelectOnFocus(true);
						txtbxUsername
								.addListener(new TextFieldListenerAdapter() {
									public void onBlur(Field field) {
										if (txtbxUsername.isValid()) {
											checkUsername(txtbxUsername
													.getText());
										}
									}
								});

						txtbxUserFree = new Label();
						txtbxUserFree.setText("Benutzername schon vergeben!");
						txtbxUserFree.setVisible(false);

						userFreePanel = new MultiFieldPanel();
						userFreePanel.addToRow(txtbxUsername, 315);
						userFreePanel.addToRow(txtbxUserFree,
								new ColumnLayoutData(1));
						userFreePanel.setBorder(false);
						formPanelTop.add(userFreePanel);

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

						comboBoxGender = new ComboBox("Geschlecht ",
								"combo_Box", 190);
						formPanelTop.add(comboBoxGender);

						dateField = new DateField("Geburtstag ", "date_Field",
								190);
						formPanelTop.add(dateField);

						txtbxJob = new TextField("Beruf ", "text_field",
								190);
						txtbxJob.setSelectOnFocus(true);
						txtbxJob.isValidateOnBlur(); 
						formPanelTop.add(txtbxJob);
						
						txtbxHobbys = new TextArea("Hobbys ", "text_field");
						txtbxHobbys.setSize(190, 80);
						txtbxHobbys.setSelectOnFocus(true);
						txtbxHobbys.isValidateOnBlur(); 
						formPanelTop.add(txtbxHobbys);
						
						txtbxMusic = new TextArea("Musikgeschmack ", "text_field");
						txtbxMusic.setSize(190, 80);
						txtbxMusic.setSelectOnFocus(true);
						txtbxMusic.isValidateOnBlur(); 
						formPanelTop.add(txtbxMusic);
					}
					horizontalPanel.add(formPanelTop);
				}
			}
			{
				FormPanel formPanelBottom = new FormPanel();
				{
					TextField textField = new TextField("New text field",
							"text_field", 100);
					formPanelBottom.add(textField);
				}
				verticalPanel.add(formPanelBottom);
			}
		}
	}

	/**
	 * sendet den eingegeben Benutzernamen an den Server, welcher überprüft ob
	 * dieser noch frei ist. Ist der Benutzername schon vergeben, wird das
	 * textField txtbxUserFree sichtbar geschaltet,
	 * 
	 * @param username
	 */
	public void checkUsername(String username) {
		// TODO rpc zum überprüfen ob der Benutzername noch frei ist
		// Sende Daten an Server
		UserManagerAsync userManager = GWT.create(UserManager.class);

		userManager.checkUsername(username, new AsyncCallback<Boolean>() {
			public void onFailure(Throwable caught) {
				// :(
				Window.alert("fehler");

			}

			public void onSuccess(Boolean serverMsg) {
				// :)
				// if (!serverMsg) {
				Window.alert("test");

				txtbxUserFree.setVisible(true);
				// }
			}
		});
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
		this.txtbxUsername.setRawValue(username);
		this.usernameLabel2.setText(username);
	}

	/**
	 * @return the username textField
	 */
	public String getUsername() {
		return this.txtbxUsername.getText();
	}
}