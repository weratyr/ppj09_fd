package ppj09.gwt.swapweb.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import ppj09.gwt.swapweb.client.datatype.Rate;
import ppj09.gwt.swapweb.client.serverInterface.RatingHandler;

public class RatingHandlerImpl extends RemoteServiceServlet implements RatingHandler {
	private DataBankerQueries db = new DataBankerQueries();
	
	public int sendRate(Rate rate) {
		if(db.saveRate(rate) == 1){
			return 1;
		}else
			return 0;
	}
	
	public int getRate(String username) {
		return db.getRate(username);
	}


}
