package ppj09.gwt.swapweb.client.serverInterface;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GuiHelperAsync {
	public void getCategories(AsyncCallback<String []> callback);
}
