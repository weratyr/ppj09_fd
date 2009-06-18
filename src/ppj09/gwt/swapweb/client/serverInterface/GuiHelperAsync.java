package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GuiHelperAsync{
	public void getCategories(AsyncCallback<ArrayList<String>> callback);

}
