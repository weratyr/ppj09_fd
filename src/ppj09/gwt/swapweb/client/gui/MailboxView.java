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
	
//	private Panel createMailboxes(){
//		 public void onModuleLoad() {  
//			         Panel panel = new Panel();  
//			         panel.setBorder(false);  
//			         panel.setPaddings(15);  
//			   
//			         RecordDef recordDef = new RecordDef(  
//			                 new FieldDef[]{  
//			                         new StringFieldDef("company"),  
//			                         new FloatFieldDef("price"),  
//			                         new FloatFieldDef("change"),  
//			                         new FloatFieldDef("pctChange"),  
//			                         new DateFieldDef("lastChanged", "n/j h:ia"),  
//			                         new StringFieldDef("symbol"),  
//			                         new StringFieldDef("industry")  
//			                 }  
//			         );  
//			   
//			         GridPanel grid = new GridPanel();  
//			   
//			         Object[][] data = getCompanyData();  
//			         MemoryProxy proxy = new MemoryProxy(data);  
//			   
//			         ArrayReader reader = new ArrayReader(recordDef);  
//			         Store store = new Store(proxy, reader);  
//			         store.load();  
//			         grid.setStore(store);  
//			   
//			   
//			         ColumnConfig[] columns = new ColumnConfig[]{  
//			                 //column ID is company which is later used in setAutoExpandColumn  
//			                 new ColumnConfig("Company", "company", 160, true, null, "company"),  
//			                 new ColumnConfig("Price", "price", 35),  
//			                 new ColumnConfig("Change", "change", 45),  
//			                 new ColumnConfig("% Change", "pctChange", 65),  
//			                 new ColumnConfig("Last Updated", "lastChanged", 65),  
//			                 new ColumnConfig("Industry", "industry", 60, true)  
//			         };  
//			   
//			         ColumnModel columnModel = new ColumnModel(columns);  
//			         grid.setColumnModel(columnModel);  
//			   
//			         grid.setFrame(true);  
//			         grid.setStripeRows(true);  
//			         grid.setAutoExpandColumn("company");  
//			   
//			         grid.setHeight(350);  
//			         grid.setWidth(600);  
//			         grid.setTitle("Array Grid");  
//			   
//			         Toolbar bottomToolbar = new Toolbar();  
//			         bottomToolbar.addFill();  
//			         bottomToolbar.addButton(new ToolbarButton("Clear Sort", new ButtonListenerAdapter() {  
//			             public void onClick(Button button, EventObject e) {  
//			                 grid.clearSortState(true);  
//			             }  
//			         }));  
//			         grid.setBottomToolbar(bottomToolbar);  
//			   
//			         panel.add(grid);  
//			   
//			         RootPanel.get().add(panel);  
//			     }  
//			   
//			     private Object[][] getCompanyData() {  
//			         return new Object[][]{  
//			                 new Object[]{"3m Co", new Double(71.72), new Double(0.02),  
//			                         new Double(0.03), "9/1 12:00am", "MMM", "Manufacturing"},  
//			                 new Object[]{"Alcoa Inc", new Double(29.01), new Double(0.42),  
//			                         new Double(1.47), "9/1 12:00am", "AA", "Manufacturing"},  
//			                 new Object[]{"Altria Group Inc", new Double(83.81), new Double(0.28),  
//			                         new Double(0.34), "9/1 12:00am", "MO", "Manufacturing"},  
//			                 new Object[]{"American Express Company", new Double(52.55), new Double(0.01),  
//			                         new Double(0.02), "9/1 12:00am", "AXP", "Finance"},  
//			                 new Object[]{"American International Group, Inc.", new Double(64.13), new Double(0.31),  
//			                         new Double(0.49), "9/1 12:00am", "AIG", "Services"},  
//			                 new Object[]{"AT&T Inc.", new Double(31.61), new Double(-0.48),  
//			                         new Double(-1.54), "9/1 12:00am", "T", "Services"},  
//			                 new Object[]{"Boeing Co.", new Double(75.43), new Double(0.53),  
//			                         new Double(0.71), "9/1 12:00am", "BA", "Manufacturing"},  
//			                 new Object[]{"Caterpillar Inc.", new Double(67.27), new Double(0.92),  
//			                         new Double(1.39), "9/1 12:00am", "CAT", "Services"},  
//			                 new Object[]{"Citigroup, Inc.", new Double(49.37), new Double(0.02),  
//			                         new Double(0.04), "9/1 12:00am", "C", "Finance"},  
//			                 new Object[]{"E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51),  
//			                         new Double(1.28), "9/1 12:00am", "DD", "Manufacturing"}  
//			         };  
//			     }  
//			 }  
//		return null;
//	}
}