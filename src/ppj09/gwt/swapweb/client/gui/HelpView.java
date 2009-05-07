package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class HelpView extends Composite implements View {

	public HelpView() {
		{
			DockPanel dockPanel = new DockPanel();
			initWidget(dockPanel);
			dockPanel.setSize("650", "600");
			{
				Label lblHilfe = new Label("Hilfe!!!");
				dockPanel.add(lblHilfe, DockPanel.CENTER);
			}
		}
	}

}
