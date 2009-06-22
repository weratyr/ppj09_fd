package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.Offer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("OfferHandler")
public interface OfferHandler extends RemoteService {
	public int createOffer(Offer newOffer);
}
