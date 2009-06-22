package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.datatype.Offer;
import ppj09.gwt.swapweb.client.serverInterface.OfferHandler;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class OfferHandlerImpl extends RemoteServiceServlet implements OfferHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DataBankerQueries db = new DataBankerQueries();

	public int createOffer(Offer newOffer) {
		return db.createOffer(newOffer);
	}
}
