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
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;

public class MessageComposeView extends Composite {
	private Article article;
	private String receiver;
	private int articleId;
	private User user;

	private TextField subject;
	private TextField sentTo;

	public MessageComposeView(Article article) {
		this.article = article;
		this.receiver = article.getUserName();
		this.articleId = article.getArticleId();

		createMessagePopupWindow();
		subject.setValue("Artikel: " + article.getTitle() + " (ID: "
				+ article.getArticleId() + ")");
		subject.setDisabled(true);
		sentTo.setValue(article.getUserName());
		sentTo.setDisabled(true);

	}

	public MessageComposeView(User user) {
		this.user = user;
		createMessagePopupWindow();
		sentTo.setValue(user.getUsername());
		sentTo.setDisabled(true);
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
		messagePanel.setMonitorValid(true);

		// anchor width by percentage
		sentTo = new TextField("Send To", "to");
		sentTo.setAllowBlank(false);
		sentTo.setMinLength(5);
		sentTo.setMinLengthText("Es muss ein empfänger angegeben werden!!");

		messagePanel.add(sentTo, new AnchorLayoutData("100%"));

		// anchor width by percentage
		subject = new TextField("Subject", "subject");
		subject.setAllowBlank(false);
		subject.setMinLength(2);
		subject.setMinLengthText("Betreff ist leer!");
		messagePanel.add(subject, new AnchorLayoutData("100%"));

		final TextArea textArea = new TextArea("Subject", "subject");
		textArea.setAllowBlank(false);
		textArea.setHideLabel(true);
		// anchor width by percentage and height by raw adjustment
		// sets width to 100% and height to "remainder" height - 53px
		messagePanel.add(textArea, new AnchorLayoutData("100% -53"));

		Button send = new Button("Send");

		send.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				System.out.println("send me" + subject.getText());
				Message mesg = new Message();
				mesg.setArticleId(articleId);
				mesg.setAuthor(SwapWeb.getUserNameFromSession());
				mesg.setMessage(textArea.getText());
				mesg.setReceiver(receiver);
				mesg.setTopic(subject.getText());

				MessageHandlerAsync messageProxy = GWT
						.create(MessageHandler.class);
				messageProxy.sendMessage(mesg, new AsyncCallback<Integer>() {
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					public void onSuccess(Integer result) {
						// TODO Auto-generated method stub
						MessageBox.alert("Deine Nachricht wurde versand");
						messageWindow.close();
					}
					
				 });
				 
			 }

		});
		send.setFormBind(true);
		messagePanel.addButton(send);
		Button cancel = new Button("Cancel");
		cancel.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				messageWindow.close();
			}
		});
		messagePanel.addButton(cancel);

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