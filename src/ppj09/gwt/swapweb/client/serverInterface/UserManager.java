package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
/*@RemoteServiceRelativePath("greet")*/
public interface UserManager extends RemoteService {
	public int loginRequest(String user, String pwHash);
	public int createUser(User newUser);
}
