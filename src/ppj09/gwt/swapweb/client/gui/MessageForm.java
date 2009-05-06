package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.core.EventObject;

public class MessageForm extends Composite implements Form {
	private AbsolutePanel absolutePanel;
	private FormPanel formPanel;
	private TextField txtSender;
	private TextField txtReceiver;
	private TextField txtSubject;
	private TextArea txtAreaMessage;
	private Button btnSubmit;
	private Button btnReset;
	private VerticalPanel verticalPanel;
		
	public MessageForm() {
		{
			verticalPanel = new VerticalPanel();
			absolutePanel = new AbsolutePanel();
			verticalPanel.add(absolutePanel);
			verticalPanel.setSize("650", "90");
			initWidget(verticalPanel);
			{
				formPanel = new FormPanel();
				formPanel.setFooter(true);
				formPanel.setBorder(false);
				formPanel.setSize("440px", "192px");
				{
					txtSender = new TextField("Absender", "text_field", 150);
					txtSender.setReadOnly(true);
					formPanel.add(txtSender);
				}
				{
					txtReceiver = new TextField("Empf\u00E4nger", "text_field", 150);
					formPanel.add(txtReceiver);
				}
				{
					txtSubject = new TextField("Betreff", "text_field", 250);
					formPanel.add(txtSubject);
				}
				{
					txtAreaMessage = new TextArea("Nachricht", "text_area");
					txtAreaMessage.setWidth(250);
					formPanel.add(txtAreaMessage);
				}
				{
					btnReset = new Button("zur\u00FCcksetzen");
					btnReset.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							txtReceiver.reset();
							txtSubject.reset();
							txtAreaMessage.reset();
						}
					});
					formPanel.addButton(btnReset);
				}
				{
					btnSubmit = new Button("absenden");
					btnSubmit.addListener(new ButtonListenerAdapter() {
						public void onClick(Button button, EventObject e) {
							
						}
					});
					formPanel.addButton(btnSubmit);
				}
				absolutePanel.add(formPanel, 5, 5);
			}
		}
	}

	/**
	 * 
	 */
	public boolean submit() {
		// TODO Auto-generated method stub
		return false;
	}
}
