package ppj09.gwt.swapweb.client.gui;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

public class MessageComposeView extends Composite{
	private Article article;
	private User user;

	
	private TextField subject; 
	private TextField sentTo; 
	
	
	public MessageComposeView(Article article) {
		this.article = article;
		createMessagePopupWindow();
		subject.setDisabled(true);
		subject.setEmptyText("Artikel: "+article.getTitle()+" (ID: "+article.getArticleId()+")");
		sentTo.setDisabled(true);
		sentTo.setEmptyText(article.getUserName());
			
	}
	
	public MessageComposeView(User user) {
		this.user = user;
		createMessagePopupWindow();
	}
	
	public MessageComposeView() {
		
		createMessagePopupWindow();
	}
	
	
	public void createMessagePopupWindow() {
		final Window messageWindow = new Window();
		messageWindow.setTitle("Resize Me");
		messageWindow.setWidth(500);
		messageWindow.setHeight(300);
		messageWindow.setMinWidth(300);
		messageWindow.setMinHeight(200);
		messageWindow.setLayout(new FitLayout());
		messageWindow.setPaddings(5);
		messageWindow.setButtonAlign(Position.CENTER);
		

		FormPanel messagePanel = new FormPanel();
	
		// anchor width by percentage
		sentTo = new TextField("Send To", "to");
		
		messagePanel.add(sentTo, new AnchorLayoutData(
		"100%"));

		// anchor width by percentage
		subject = new TextField("Subject", "subject");
		
		
		messagePanel.add(subject,new AnchorLayoutData("100%"));
		

		final TextArea textArea = new TextArea("Subject", "subject");
		textArea.setHideLabel(true);
		// anchor width by percentage and height by raw adjustment
		// sets width to 100% and height to "remainder" height - 53px
		messagePanel.add(textArea, new AnchorLayoutData("100% -53"));
		
		Button send = new Button("Send");
		send.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 System.out.println("send me");
				 Message mesg = new Message();
				 mesg.setArticleId(article.getArticleId());
				 mesg.setAuthor(SwapWeb.getUserNameFromSession());
				 mesg.setMessage(textArea.getText());
				 mesg.setReceiver(article.getUserId());
				 mesg.setTopic("Artikel: "+article.getTitle()+" (ID: "+article.getArticleId()+")");
				 MessageHandlerAsync messageProxy = GWT.create(MessageHandler.class);
				 messageProxy.sendMessage(mesg, new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						
					}
					 
				 });
				 
				 
			 }
		});
		messageWindow.addButton(send);
		Button cancel = new Button("Cancel");
		cancel.addListener(new ButtonListenerAdapter(){
			 public void onClick(Button button, EventObject e) {
				 messageWindow.close();
			 }
		});
		messageWindow.addButton(cancel);

		messageWindow.setCloseAction(Window.HIDE);
		messageWindow.setPlain(true);
	// strips all Ext styling for the component
		messagePanel.setBaseCls("x-plain");
		messagePanel.setLabelWidth(55);
		messagePanel.setUrl("save-form.php");

		messagePanel.setWidth(500);
		messagePanel.setHeight(300);

		

		messageWindow.add(messagePanel);
		messageWindow.show();
	
	}
}