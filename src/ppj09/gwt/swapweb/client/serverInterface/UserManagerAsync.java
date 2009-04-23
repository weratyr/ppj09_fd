package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of User Manager
 */
public interface UserManagerAsync {
	public void loginRequest(String user, String pw, AsyncCallback<Integer> callback);
	public void createUser(User newUser, AsyncCallback<Integer> callback);
}
