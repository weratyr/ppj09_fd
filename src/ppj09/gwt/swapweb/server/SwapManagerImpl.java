package ppj09.gwt.swapweb.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.Offer;
import ppj09.gwt.swapweb.client.datatype.Rate;
import ppj09.gwt.swapweb.client.serverInterface.SwapManager;

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
	
	/**
	 * Bewertet einen Tausch (Swap)
	 */
	public String rateSwap(Rate rate) {
		String bla = ("\nKommentar: \t" + rate.getComment() + "\nSterne: \t" + rate.getStars()  );
		
		return bla;
	}
}
