/**
 * Formularfelder und Submit
 * testkommentar
 */
package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

import ppj09.gwt.swapweb.client.Validation;
import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManagerAsync;
import com.google.gwt.user.client.ui.DockPanel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.core.EventObject;
import com.google.gwt.user.client.ui.FileUpload;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.core.Position;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;


/**
 * @author
 * 
 */
public class ArticleForm extends Composite implements Form {

	/**
	 * Create a remote service proxy to talk to the server-side ArticleManager service.
	 */
	private final ArticleManagerAsync articleManager = GWT.create(ArticleManager.class);
	private DockPanel dockPanel;
	private FormPanel frmpnlArtikelAnlegen;
	private TextField txtArtikleName;
	private TextField txtStandort;
	private TextField txtZustand;
	private TextField txtVersand;
	private TextField txtUmfang;
	private TextField txtGegentauschvorst;
	private TextField txtBesonderh;
	private Button btnReset;
	private Button btnSubmit;
	private Label lblBilder;
	private FileUpload upload;
	private TextArea txtAreaBeschreibung;
	private AbsolutePanel absolutePanel;
	private com.google.gwt.user.client.ui.Label lblHochgeladeneBilder;
	private Image image;
	private Hyperlink hplDelUploadImage;
	
	/**
	 * Initialisiert Formular Eingabefelder
	 */
	public ArticleForm() {
		{
			dockPanel = new DockPanel();
			initWidget(dockPanel);
			dockPanel.setWidth("650");
			{
				frmpnlArtikelAnlegen = new FormPanel();
				frmpnlArtikelAnlegen.setSize("650", "639px");
				frmpnlArtikelAnlegen.setFooter(true);
				
				{
					txtArtikleName = new TextField("Artikelname", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtArtikleName);
					txtArtikleName.setWidth("300");
				}
				{
					txtStandort = new TextField("Standort", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtStandort);
					txtStandort.setWidth("300");
				}
				{
					txtZustand = new TextField("Zustand", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtZustand);
					txtZustand.setWidth("300");
				}
				{
					txtVersand = new TextField("Versand", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtVersand);
					txtVersand.setWidth("300");
				}
				{
					txtUmfang = new TextField("Angebotsumfang", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtUmfang);
					txtUmfang.setWidth("300");
				}
				{
					txtGegentauschvorst = new TextField("Gegentauschvorstellung", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtGegentauschvorst);
					txtGegentauschvorst.setWidth("300");
				}
				{
					txtBesonderh = new TextField("Besonderheiten", "text_field", 100);
					frmpnlArtikelAnlegen.add(txtBesonderh);
					txtBesonderh.setWidth("300");
				}
				{
					txtAreaBeschreibung = new TextArea("Beschreibung", "text_area");
					frmpnlArtikelAnlegen.add(txtAreaBeschreibung);
					txtAreaBeschreibung.setWidth("300");
				}
				{
					lblBilder = new Label("Bild hochladen:  ");
					lblBilder.setHeight("18");
					frmpnlArtikelAnlegen.add(lblBilder);
				}
				{
					upload = new FileUpload();
				    upload.setName("pictureFile");
				    frmpnlArtikelAnlegen.add(upload);
				}
				{
					btnReset = new Button("zur\u00FCcksetzen");
					btnReset.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							txtArtikleName.reset();
							txtStandort.reset();
							txtZustand.reset();
							txtVersand.reset();
							txtUmfang.reset();
							txtGegentauschvorst.reset();
							txtBesonderh.reset();
							txtAreaBeschreibung.reset();
						}
					});
					{
						absolutePanel = new AbsolutePanel();
						frmpnlArtikelAnlegen.add(absolutePanel, new AnchorLayoutData(" 22%"));
						{
							lblHochgeladeneBilder = new com.google.gwt.user.client.ui.Label("Hochgeladenes Bild:");
							absolutePanel.add(lblHochgeladeneBilder, 5, 5);
						}
						{
							image = new Image(null);
							absolutePanel.add(image, 156, 5);
							image.setSize("113px", "116px");
						}
						{
							hplDelUploadImage = new Hyperlink("New hyperlink", false, "newHistoryToken");
							absolutePanel.add(hplDelUploadImage, 5, 31);
							hplDelUploadImage.setHTML("l\u00F6schen");
						}
					}
					frmpnlArtikelAnlegen.addButton(btnReset);
				}
				{
					btnSubmit = new Button("absenden");
					btnSubmit.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							submit();
						}
					});
					frmpnlArtikelAnlegen.addButton(btnSubmit);
				}
				frmpnlArtikelAnlegen.setBorder(false);
				frmpnlArtikelAnlegen.setTitle("Artikel anlegen");
				frmpnlArtikelAnlegen.setLabelAlign(Position.TOP);
				dockPanel.add(frmpnlArtikelAnlegen, DockPanel.SOUTH);
			}
		}

	}
	
    /**
	 * Schickt die validierten Formulardaten an den Artikelmanager, und wartet
	 * auf RŸckmeldung
	 */
	/**
	 * Schickt die validierten Formulardaten an den Artikelmanager, und wartet
	 * auf RŸckmeldung
	 */
	public boolean submit() {
		if (Validation.validateArticleForm(this)) {
			// Sende Daten an Server
			Article newArticle = null;
			articleManager.createArticle(newArticle,
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
			// Hinweis auf Fehler
			return false;
		}
	}

	public String getTxtArtikleName() {
		return txtArtikleName.getText();
	}

	public void setTxtArtikleName(String txtArtikleName) {
		this.txtArtikleName.setEmptyText(txtArtikleName);
	}

	public String getTxtStandort() {
		return txtStandort.getText();
	}

	public void setTxtStandort(String txtStandort) {
		this.txtStandort.setEmptyText(txtStandort);
	}

	public String getTxtZustand() {
		return txtZustand.getText();
	}

	public void setTxtZustand(String txtZustand) {
		this.txtZustand.setEmptyText(txtZustand);
	}

	public String getTxtVersand() {
		return txtVersand.getText();
	}

	public void setTxtVersand(String txtVersand) {
		this.txtVersand.setEmptyText(txtVersand);
	}

	public String getTxtUmfang() {
		return txtUmfang.getText();
	}

	public void setTxtUmfang(String txtUmfang) {
		this.txtUmfang.setEmptyText(txtUmfang);
	}

	public String getTxtGegentauschvorst() {
		return txtGegentauschvorst.getText();
	}

	public void setTxtGegentauschvorst(String txtGegentauschvorst) {
		this.txtGegentauschvorst.setEmptyText(txtGegentauschvorst);
	}

	public String getTxtBesonderh() {
		return txtBesonderh.getText();
	}

	public void setTxtBesonderh(String txtBesonderh) {
		this.txtBesonderh.setEmptyText(txtBesonderh);
	}

	public FileUpload getUpload() {
		return upload;
	}

	public String getTxtAreaBeschreibung() {
		return txtAreaBeschreibung.getText();
	}

	public void setTxtAreaBeschreibung(String txtAreaBeschreibung) {
		this.txtAreaBeschreibung.setEmptyText(txtAreaBeschreibung);
	}

	public Image getHplDelUploadImage() {
		return this.image;
	}
}
