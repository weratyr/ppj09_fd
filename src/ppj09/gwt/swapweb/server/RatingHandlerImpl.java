package ppj09.gwt.swapweb.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import ppj09.gwt.swapweb.client.datatype.Rate;
import ppj09.gwt.swapweb.client.serverInterface.RatingHandler;

public class RatingHandlerImpl extends RemoteServiceServlet implements RatingHandler {

	public int sendRate(Rate rate) {
		System.out.println("rate"+ rate.getStars());
		return 0;
	}

}
