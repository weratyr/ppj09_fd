package ppj09.gwt.swapweb.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;

public class UserSearchForm extends Composite implements Form {
	public UserSearchForm() {
		{
			AbsolutePanel absolutePanel = new AbsolutePanel();
			initWidget(absolutePanel);
			{
				Button button = new Button("New button");
				absolutePanel.add(button, 102, 74);
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
