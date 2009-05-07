package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class HomeView extends Composite implements View {

	public HomeView() {
		{
			DockPanel dockPanel = new DockPanel();
			initWidget(dockPanel);
			{
				Label lblHome = new Label("Home");
				dockPanel.add(lblHome, DockPanel.CENTER);
			}
		}
	}

}
