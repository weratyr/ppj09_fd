package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GuiHelper")
public interface GuiHelper extends RemoteService{
	public ArrayList<String> getCategories();

}
