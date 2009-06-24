package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Message;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MessageHandler")
public interface MessageHandler extends RemoteService {
	public int sendMessage(Message mesg);
	public int setIsRead(int messageId);
	public ArrayList<Message> getMessages(String username);
}
