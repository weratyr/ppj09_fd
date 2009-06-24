package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Message;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageHandlerAsync {
	public void sendMessage(Message mesg, AsyncCallback<Integer> callback);
	public void setIsRead(int messageId, AsyncCallback<Integer> callback);
	public void getMessages(String username, AsyncCallback<ArrayList<Message>> callback);
}
