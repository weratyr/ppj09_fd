package ppj09.gwt.swapweb.server;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;
import ppj09.gwt.swapweb.client.serverInterface.GuiHelper;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GuiHelperImpl extends RemoteServiceServlet implements GuiHelper{
	DataBankerQueries db = new DataBankerQueries();

	public ArrayList getCategories() {
		// TODO Auto-generated method stub
		return db.getCategories();
	}

}
