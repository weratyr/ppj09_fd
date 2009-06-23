package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.serverInterface.SessionManager;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SessionManagerImpl extends RemoteServiceServlet implements SessionManager{

	
	public void logout() {
		System.out.println("logout test");
		SessionHandler handler = new SessionHandler();
		handler.deleteSession(this.getThreadLocalRequest());
	}

}
