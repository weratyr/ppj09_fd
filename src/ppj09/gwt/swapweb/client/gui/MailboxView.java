package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;

public class MailboxView extends Composite{

	public MailboxView() {
		Panel mainWindow = new Panel();
		mainWindow.setBorder(false);
		mainWindow.setPaddings(0);
		mainWindow.setWidth(500);
		mainWindow.setHeight(300);

		mainWindow.setLayout(new HorizontalLayout(0));

		Panel accordionPanel = createAccordionPanel();
		accordionPanel.setHeight(300);
		accordionPanel.setWidth(180);
		mainWindow.add(accordionPanel);
		
		Panel mailContents = new Panel();
		mailContents.setBorder(false);
		mailContents.setWidth(320);
		mailContents.setHeight(300);
		mainWindow.add(mailContents);
		
		Panel messageWindow = new Panel();
		messageWindow.setTitle("Nachricht");
		messageWindow.setWidth(320);
		messageWindow.setHeight(150);
		messageWindow.setBorder(true);
		messageWindow.setAutoScroll(true);
		mailContents.add(messageWindow);
		
		Label author = new Label("Von: ");
		messageWindow.add(author);
		
		Label subject = new Label("Betreff: ");
		messageWindow.add(subject);
		
		Label messageSeperator = new Label();
		messageSeperator.setHeight("10");
		messageWindow.add(messageSeperator);
		
		Label message = new Label("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, At accusam aliquyam diam diam dolore dolores duo eirmod eos erat, et nonumy sed tempor et et invidunt justo labore Stet clita ea et gubergren, kasd magna no rebum. sanctus sea sed takimata ut vero voluptua. est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur");
		messageWindow.add(message);
		
		Panel responseWindow = new Panel();
		responseWindow.setTitle("Antworten");
		responseWindow.setWidth(320);
		responseWindow.setHeight(150);
		responseWindow.setBorder(true);
		responseWindow.setAutoScroll(true);
		mailContents.add(responseWindow);
		
		Window window = new Window();
		window.setTitle("Postfach");
		window.add(mainWindow);
		window.show();

	}

	private Panel createAccordionPanel() {
		Panel accordionPanel = new Panel();
		accordionPanel.setLayout(new AccordionLayout(true));

		Panel panelOne = new Panel("Posteingang", "<p>Panel1 content!</p>");
		accordionPanel.add(panelOne);

		Panel panelTwo = new Panel("Postausgang", "<p>Panel2 content!</p>");
		accordionPanel.add(panelTwo);
		
		return accordionPanel;
	}
}