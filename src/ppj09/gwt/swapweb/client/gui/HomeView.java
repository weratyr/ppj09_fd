package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class HomeView extends Composite implements View {


	/**
	 * Die Start/Willkommensseite des SwapWebs.
	 * 
	 * @author Georg Ortwein
	 * @author Projekt Team 4711
	 * @version 0.1, 06.05.09
	 */
	
	
	public HomeView() {
		{
			
			//Dockpanel und Label zum Tes
			DockPanel dockPanel = new DockPanel();
			initWidget(dockPanel);
			{
				Label lblHome = new Label("Home");
				dockPanel.add(lblHome, DockPanel.CENTER);
			}
		}
	}

}
