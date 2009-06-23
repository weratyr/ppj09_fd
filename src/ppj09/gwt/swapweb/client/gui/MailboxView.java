package ppj09.gwt.swapweb.client.gui;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;

public class MailboxView extends Composite{

	private Panel inbox;
	private Panel outbox;
	

	private ArrayList<Message> inboxMessages = new ArrayList<Message>();
	private ArrayList<Message> outboxMessages = new ArrayList<Message>();
	
	public MailboxView() {
		Panel mainWindow = new Panel();
		mainWindow.setBorder(false);
		mainWindow.setCollapsible(true);
		mainWindow.setPaddings(0);
		mainWindow.setWidth(600);
		mainWindow.setLayout(new HorizontalLayout(0));

		receiveMessages();
		
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
					inbox.clear();
					outbox.clear();
					outboxMessages.clear();
					inboxMessages.clear();
					receiveMessages();
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
		
		Window window = new Window();
		window.setTitle("Postfach");
		window.setPaddings(0);
		window.setBorder(false);
		window.add(mainWindow);
		window.show();

	}

	private Panel createAccordionPanel() {
		Panel accordionPanel = new Panel();
		accordionPanel.setLayout(new AccordionLayout(true));

		inbox = new Panel("Posteingang");
		inbox.setAutoScroll(true);
		accordionPanel.add(inbox);
		

		outbox = new Panel("Postausgang");
		outbox.setAutoScroll(true);
		accordionPanel.add(outbox);
		
		return accordionPanel;
	}
	
	private void receiveMessages(){
		MessageHandlerAsync messageHandler = GWT.create(MessageHandler.class);
		messageHandler.getMessages(SwapWeb.getUserNameFromSession(), new AsyncCallback<ArrayList<Message>>(){
			public void onFailure(Throwable caught) {
				System.out.println("RPC failed @ MailboxView: " + caught);
			}
			public void onSuccess(ArrayList<Message> result) {
				for (int i = 0;i<result.size();i++){
					if(!(result.get(i).getAuthor().equals(SwapWeb.getUserNameFromSession()))){
						inboxMessages.add(result.get(i));
					} else {
						outboxMessages.add(result.get(i));
					}
				}
				fillMailbox(inboxMessages, outboxMessages);
			}
		});
	}

	private void fillMailbox(ArrayList<Message> inboxMessages, ArrayList<Message> outboxMessages) {
		for (int i = 0;i<inboxMessages.size();i++){
			final Hyperlink inboxItem = new Hyperlink(inboxMessages.get(i).getTopic(), null);
			inbox.add(inboxItem);
		}
		for (int i = 0;i<outboxMessages.size();i++){
			final Hyperlink outboxItem = new Hyperlink(outboxMessages.get(i).getTopic(), null);
			outbox.add(outboxItem);
		}
		inbox.doLayout();
		outbox.doLayout();
	}
}