package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.widgets.form.TextField;

public class HomeView extends Composite implements View {

	private Panel panel;
	private Button button;

	/**
	 * Die Start/Willkommensseite des SwapWebs.
	 * 
	 * @author Georg Ortwein
	 * @author Projekt Team 4711
	 * @version 0.1, 06.05.09
	 */

	public HomeView() {
		{

			// Dockpanel und Label zum Tes
			DockPanel dockPanel = new DockPanel();
			initWidget(dockPanel);
			{
				Label lblHome = new Label("Home");
				dockPanel.add(lblHome, DockPanel.CENTER);
			}
			{
				TextField textField = new TextField("New text field",
						"text_field", 100);
				dockPanel.add(textField, DockPanel.WEST);
				textField.markInvalid("las");
			}

		}
	}
}
