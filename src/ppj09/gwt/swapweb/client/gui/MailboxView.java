package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class MailboxView extends Composite{

	public MailboxView() {
		Panel mainWindow = new Panel();
		mainWindow.setBorder(false);
		mainWindow.setCollapsible(true);
		mainWindow.setPaddings(0);
		mainWindow.setWidth(600);
		mainWindow.setLayout(new HorizontalLayout(0));

		// composeMessage Button in bottom toolbar
		ToolbarButton compose = new ToolbarButton("Nachricht verfassen");
		compose.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 new MessageComposeView();
			 }
		});
		// Aktualisieren Button in bottom toolbar
		ToolbarButton refresh = new ToolbarButton("Empfangen");
		refresh.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 
			 }
		});
		
		Toolbar mainWindowToolbar = new Toolbar();
		mainWindowToolbar.addButton(compose);
		mainWindowToolbar.addButton(refresh);
		
		mainWindow.setTopToolbar(mainWindowToolbar);
		
		Panel accordionPanel = createAccordionPanel();
		accordionPanel.setHeight(450);
		accordionPanel.setWidth(180);
		mainWindow.add(accordionPanel);
		
		Panel mailContents = new Panel();
		mailContents.setBorder(false);
		mailContents.setWidth(420);
		mailContents.setHeight(450);
		mainWindow.add(mailContents);
		
		Panel messageWindow = new Panel();
		messageWindow.setTitle("Nachricht");
		messageWindow.setPaddings(5);
		messageWindow.setWidth(420);
		messageWindow.setHeight(450);
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
		
		
		// respond Button in bottom toolbar
		ToolbarButton respond = new ToolbarButton("Antworten");
		respond.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 
			 }
		});
		// delete Button in bottom toolbar
		ToolbarButton delete = new ToolbarButton("Löschen");
		delete.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 
			 }
		});
		Toolbar mailContentToolbar = new Toolbar();
		mailContentToolbar.addButton(respond);
		mailContentToolbar.addButton(delete);
		
		messageWindow.setBottomToolbar(mailContentToolbar);

//		Panel responsePanel = new Panel();
//		responsePanel.setLayout(new VerticalLayout(0));
//		responsePanel.setWidth(320);
//		responsePanel.setHeight(40);
//		responsePanel.setBorder(true);
//		mailContents.add(responsePanel);
		
		Window window = new Window();
		window.setTitle("Postfach");
		window.add(mainWindow);
		window.show();

	}

	private Panel createAccordionPanel() {
		Panel accordionPanel = new Panel();
		accordionPanel.setLayout(new AccordionLayout(true));

		Panel panelOne = new Panel("Posteingang", "<p>Panel1 content!</p>");
		panelOne.setAutoScroll(true);
		accordionPanel.add(panelOne);

		Panel panelTwo = new Panel("Postausgang", "<p>Panel2 content!</p>");
		panelTwo.setAutoScroll(true);
		accordionPanel.add(panelTwo);
		
		return accordionPanel;
	}
}