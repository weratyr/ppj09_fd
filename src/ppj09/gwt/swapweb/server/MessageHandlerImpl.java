package ppj09.gwt.swapweb.server;

import java.io.IOException;

import ppj09.gwt.swapweb.client.datatype.Message;
import ppj09.gwt.swapweb.client.serverInterface.MessageHandler;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
	

public class MessageHandlerImpl extends RemoteServiceServlet implements MessageHandler {
	private DataBankerQueries db = new DataBankerQueries();
	
	public int sendMessage(Message mesg) {
		System.out.println(mesg.getMessage());
		db.saveMessage(mesg);
		// TODO Auto-generated method stub
		return 1;
	}


}
