package ppj09.gwt.swapweb.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.Offer;

public class SwapManagerImpl extends RemoteServiceServlet implements SwapManager {
	public int createSwapOffer(Article offeredArticle, Article desiredArticle) {
		return 1;
	} 
	public int declareInterest(Article desiredArticle) {
		return 1;
	}
	public int acceptOffer(Offer offer) {
		return 1;
	}
	public int declineOfer(Offer offer) {
		return 1;
	}
}
