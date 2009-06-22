package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.Offer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OfferHandlerAsync {
	public void createOffer(Offer newOffer, AsyncCallback<Integer> callback);
}
