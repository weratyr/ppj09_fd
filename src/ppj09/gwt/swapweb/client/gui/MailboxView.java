package ppj09.gwt.swapweb.client.gui;


import java.util.ArrayList;


import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.event.GridRowListener;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;

public class MailboxView extends Composite{

	private GridPanel inboxGrid;
	private GridPanel outboxGrid;
	private Panel inbox;
	private Panel outbox;
	private Object[][] inboxItems;
	private Object[][] outboxItems;
	private Panel accordionPanel;
	private Label message;
	private Label subject;
	private Label author;
	private String authorTemp;
	private String subjectTemp;
	private ArrayList<Message> inboxItemsArrayList;
	private ArrayList<Message> outboxItemsArrayList;


	
	public MailboxView() {
		Panel mainWindow = new Panel();
		mainWindow.setBorder(false);
		mainWindow.setCollapsible(true);
		mainWindow.setPaddings(0);
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
					inbox.clear();
					outbox.clear();
					receiveMessages();
			 }
		});
		
		Toolbar mainWindowToolbar = new Toolbar();
		mainWindowToolbar.addButton(compose);
		mainWindowToolbar.addButton(refresh);
		
		mainWindow.setTopToolbar(mainWindowToolbar);
		
		 
		accordionPanel = createAccordionPanel();
		accordionPanel.setHeight(450);
//		accordionPanel.setAutoHeight(true);
		accordionPanel.setWidth(408);
		
		mainWindow.add(accordionPanel);
		mainWindow.add(getMailContents());
		
		
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
		inbox.setAutoHeight(true);
		inbox.setPaddings(0);
		accordionPanel.add(inbox);
		

		outbox = new Panel("Postausgang");
		outbox.setAutoScroll(true);
		outbox.setAutoHeight(true);
		outbox.setPaddings(0);
		accordionPanel.add(outbox);
		
		receiveMessages();

		return accordionPanel;
	}
	
	private void receiveMessages(){
		MessageHandlerAsync messageHandler = GWT.create(MessageHandler.class);
		messageHandler.getMessages(SwapWeb.getUserNameFromSession(), new AsyncCallback<ArrayList<Message>>(){
			public void onFailure(Throwable caught) {
				System.out.println("RPC failed @ MailboxView: " + caught);
			}
			public void onSuccess(ArrayList<Message> result) {
				System.out.println(result.get(0).getDate());
				inboxItems = new Object[result.size()][10];
				outboxItems = new Object[result.size()][10];
				inboxItemsArrayList = new ArrayList<Message>();
				outboxItemsArrayList = new ArrayList<Message>();
				int j = 0;
				int k = 0;
				for (int i = 0;i<result.size();i++){
					if(!(result.get(i).getAuthor().equals(SwapWeb.getUserNameFromSession()))){
						inboxItemsArrayList.add(result.get(i));
						inboxItems[j] = new Object[] {result.get(i).getAuthor(),result.get(i).getTopic(),result.get(i).getDate() };
						j++;
					} else {
						outboxItemsArrayList.add(result.get(i));
						outboxItems[k] = new Object[] {result.get(i).getAuthor(),result.get(i).getTopic(),result.get(i).getDate() };
						k++;
					}
				}
				inbox.add(createInbox());
				outbox.add(createOutbox());
				inbox.doLayout();
				outbox.doLayout();
			    accordionPanel.doLayout();
			}
			});
		}
	

	private Panel getMailContents(){
		Panel mailContents = new Panel();
		mailContents.setBorder(false);
		mailContents.setWidth(420);
		mailContents.setHeight(450);
		
		Panel messageWindow = new Panel();
		messageWindow.setTitle("Nachricht");
		messageWindow.setPaddings(5);
		messageWindow.setWidth(420);
		messageWindow.setHeight(450);
		messageWindow.setBorder(true);
		messageWindow.setAutoScroll(true);
		mailContents.add(messageWindow);
		
		author = new Label();
		messageWindow.add(author);
		
		subject = new Label();
		messageWindow.add(subject);
		
		Label messageSeperator = new Label();
		messageSeperator.setHeight("10");
		messageWindow.add(messageSeperator);
		
		message = new Label();
		messageWindow.add(message);
		
		
		// respond Button in bottom toolbar
		ToolbarButton respond = new ToolbarButton("Antworten");
		respond.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 new MessageComposeView(authorTemp,subjectTemp);
			 }
		});
		
		Toolbar mailContentToolbar = new Toolbar();
		mailContentToolbar.addButton(respond);
		
		messageWindow.setBottomToolbar(mailContentToolbar);
		return mailContents;
	};
	
	private Panel createInbox(){
			   
			         RecordDef recordDef = new RecordDef(  
			                 new FieldDef[]{  
			                         new StringFieldDef("author"),
			                         new StringFieldDef("topic"),
			                         new StringFieldDef("date")
			                 }  
			         );  
			   
			         inboxGrid = new GridPanel();  
			   
			         Object[][] data = inboxItems;  
			         MemoryProxy proxy = new MemoryProxy(data);  
			   
			         ArrayReader reader = new ArrayReader(recordDef);  
			         Store store = new Store(proxy, reader);  
			         store.load();  
			         inboxGrid.setStore(store);  
			   
			   
			         ColumnConfig[] columns = new ColumnConfig[]{  
			                 new ColumnConfig("Datum", "date", 90, true, null, "date"),
			                 new ColumnConfig("Betreff", "topic", 170, true, null, "topic"),
			                 new ColumnConfig("Von", "author", 120, true, null, "author")
			         };  
			   
			         ColumnModel columnModel = new ColumnModel(columns);  
			         inboxGrid.setColumnModel(columnModel);  
			   
			         inboxGrid.setStripeRows(true);  
			         inboxGrid.setAutoExpandColumn("topic");  
			         inboxGrid.setHeight(399);
			         inboxGrid.setWidth(400);
			         
			          inboxGrid.addGridRowListener(new GridRowListener() {  
        	              public void onRowClick(GridPanel grid, int rowIndex, EventObject e) {
        	                  authorTemp = (inboxItemsArrayList.get(rowIndex).getAuthor());
        	                  subjectTemp = (inboxItemsArrayList.get(rowIndex).getTopic());
        	            	  author.setText("Von: "+(inboxItemsArrayList.get(rowIndex).getAuthor()));
        	            	  subject.setText("Betreff: "+(inboxItemsArrayList.get(rowIndex).getTopic()));
        	            	  message.setText(inboxItemsArrayList.get(rowIndex).getMessage());
        	            	  
        	            	  MessageHandlerAsync messageHandler = GWT.create(MessageHandler.class);
        	            	  messageHandler.setIsRead(inboxItemsArrayList.get(rowIndex).getMessageId(), new AsyncCallback<Integer>(){

								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								public void onSuccess(Integer result) {
									System.out.println("erfolg");
								}
        	            	  
        	              });}
        	              
//        	            	  messageHandler.setIsRead(inboxItemsArrayList.get(rowIndex).getMessageId(), AsyncCallback<String>(){
//        	          			public void onFailure(Throwable caught) {
//        	        				System.out.println("RPC failed @ MailboxView: " + caught);
//        	        			}
//        	        			public void onSuccess(ArrayList<Message> result) {
//        	              });
//        	            	  }}}

						public void onRowContextMenu(GridPanel grid,
								int rowIndex, EventObject e) {
							// TODO Auto-generated method stub
							
						}

						public void onRowDblClick(GridPanel grid,
								int rowIndex, EventObject e) {
							// TODO Auto-generated method stub
							
						}  
        	          });  
			inboxGrid.doLayout();
			return inboxGrid;
	}
	
	private Panel createOutbox(){
		   
        RecordDef recordDef = new RecordDef(  
                new FieldDef[]{  
                        new StringFieldDef("date"),  
                        new StringFieldDef("topic"),
                        new StringFieldDef("author")
                }  
        );  
  
        outboxGrid = new GridPanel();  
  
        Object[][] data = outboxItems;  
        MemoryProxy proxy = new MemoryProxy(data);  
  
        ArrayReader reader = new ArrayReader(recordDef);  
        Store store = new Store(proxy, reader);  
        store.load();  
        outboxGrid.setStore(store);  
  
  
        ColumnConfig[] columns = new ColumnConfig[]{  
                new ColumnConfig("Datum", "date", 90, true, null, "date"),
                new ColumnConfig("Betreff", "topic", 170, true, null, "topic"),
                new ColumnConfig("Von", "author", 120, true, null, "author")
        };  
  
        ColumnModel columnModel = new ColumnModel(columns);  
        outboxGrid.setColumnModel(columnModel);  
  
        outboxGrid.setStripeRows(true);  
        outboxGrid.setAutoExpandColumn("topic");  
        outboxGrid.setHeight(399);
        outboxGrid.setWidth(400);
        
        outboxGrid.addGridRowListener(new GridRowListener() {  
             public void onRowClick(GridPanel grid, int rowIndex, EventObject e) {
              authorTemp = (outboxItemsArrayList.get(rowIndex).getAuthor());
              subjectTemp = (outboxItemsArrayList.get(rowIndex).getTopic());
           	  author.setText("Von: "+(outboxItemsArrayList.get(rowIndex).getAuthor()));
           	  subject.setText("Betreff: NEU "+(outboxItemsArrayList.get(rowIndex).getTopic()));
           	  message.setText(outboxItemsArrayList.get(rowIndex).getMessage());
           	  
           	MessageHandlerAsync messageHandler = GWT.create(MessageHandler.class);
      	    messageHandler.setIsRead(inboxItemsArrayList.get(rowIndex).getMessageId(), new AsyncCallback<Integer>(){

				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				public void onSuccess(Integer result) {
					System.out.println("erfolg");
					
					
				}
      	  
         });}

			public void onRowContextMenu(GridPanel grid,
					int rowIndex, EventObject e) {
				// TODO Auto-generated method stub
				
			}

			public void onRowDblClick(GridPanel grid,
					int rowIndex, EventObject e) {
				// TODO Auto-generated method stub
				
			}  
         });  
         outboxGrid.doLayout();
	     return outboxGrid;
}
}