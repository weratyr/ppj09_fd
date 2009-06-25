package ppj09.gwt.swapweb.server;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MessageHandlerImpl extends RemoteServiceServlet implements
		MessageHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public int setIsRead(int messageId) {
		return db.setMessageIsRead(messageId);
	}

	public int getUnreadedMsgs() {
		return db.getUnreaded(sh.getSession(this.getThreadLocalRequest()));
	}

}
