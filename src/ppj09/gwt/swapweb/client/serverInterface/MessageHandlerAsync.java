package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Message;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageHandlerAsync {
	public void sendMessage(Message mesg, AsyncCallback<Integer> callback);
}
