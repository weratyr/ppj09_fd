package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.form.Label;

public class MessageView extends Composite implements View {
	private AbsolutePanel absolutePanel;
	private FormPanel formPanel;
	private TextField txtSender;
	private TextField txtReceiver;
	private TextField txtSubject;
	private VerticalPanel verticalPanel;
	
	public MessageView() {
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
				formPanel.setSize("440px", "290px");
				{
					txtSender = new TextField("Absender", "text_field", 150);
					txtSender.setReadOnly(true);
					formPanel.add(txtSender);
				}
				{
					txtReceiver = new TextField("Empf\u00E4nger", "text_field", 150);
					txtReceiver.setReadOnly(true);
					formPanel.add(txtReceiver);
				}
				{
					txtSubject = new TextField("Betreff", "text_field", 250);
					txtSubject.setReadOnly(true);
					formPanel.add(txtSubject);
				}
				{
					Label lblViewMessage = new Label("");
					lblViewMessage.setWidth(400);
					formPanel.add(lblViewMessage, new AnchorLayoutData("99% 71%"));
				}
				absolutePanel.add(formPanel, 5, 5);
			}
		}
	}
}
