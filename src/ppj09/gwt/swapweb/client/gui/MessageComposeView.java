package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

public class MessageComposeView extends Composite{

	public MessageComposeView() {
		Panel panel = new Panel();
		panel.setBorder(false);
		panel.setPaddings(15);

		final Window window = new Window();
		window.setTitle("Resize Me");
		window.setWidth(500);
		window.setHeight(300);
		window.setMinWidth(300);
		window.setMinHeight(200);
		window.setLayout(new FitLayout());
		window.setPaddings(5);
		window.setButtonAlign(Position.CENTER);
		window.addButton(new Button("Send"));
		window.addButton(new Button("Cancel"));

		window.setCloseAction(Window.HIDE);
		window.setPlain(true);

		FormPanel formPanel = new FormPanel();
		// strips all Ext styling for the component
		formPanel.setBaseCls("x-plain");
		formPanel.setLabelWidth(55);
		formPanel.setUrl("save-form.php");

		formPanel.setWidth(500);
		formPanel.setHeight(300);

		// anchor width by percentage
		formPanel.add(new TextField("Send To", "to"), new AnchorLayoutData(
				"100%"));

		// anchor width by percentage
		formPanel.add(new TextField("Subject", "subject"),
				new AnchorLayoutData("100%"));

		TextArea textArea = new TextArea("Subject", "subject");
		textArea.setHideLabel(true);
		// anchor width by percentage and height by raw adjustment
		// sets width to 100% and height to "remainder" height - 53px
		formPanel.add(textArea, new AnchorLayoutData("100% -53"));

		window.add(formPanel);

		Button button = new Button("Show Anchor Form",
				new ButtonListenerAdapter() {
					public void onClick(Button button, EventObject e) {
						window.show();
					}
				});
		panel.add(button);

		SwapWeb.getContentPanel().add(panel);
	}
}