package ppj09.gwt.swapweb.server;

import java.io.IOException;
import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MessageHandlerImpl extends RemoteServiceServlet implements
		MessageHandler {

	private DataBankerQueries db = new DataBankerQueries();
	private SessionHandler sh = new SessionHandler();

	public int sendMessage(Message mesg) {
		if (db.saveMessage(mesg) == 1) {
			return 1;
		}
		return 0;
	}

	public ArrayList<Message> getMessages(String username) {
		return db.getMessages(username);
	}

<<<<<<< HEAD:src/ppj09/gwt/swapweb/server/MessageHandlerImpl.java
	public int setIsRead(int messageId) {
		return db.setMessageIsRead(messageId);
	}

=======
	public int getUnreadedMsgs() {
		// TODO Auto-generated method stub
		return db.getUnreaded(sh.getSession(this.getThreadLocalRequest()));
	}
>>>>>>> 608a45f4a2e1bc7151030ea842fe95b19d27fd18:src/ppj09/gwt/swapweb/server/MessageHandlerImpl.java

}
