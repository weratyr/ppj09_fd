package ppj09.gwt.swapweb.client.gui;

import com.gwtext.client.widgets.Panel;

import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import com.google.gwt.user.client.ui.Composite;

public class OfferSearchResultView extends Composite implements SearchResultView {
	private SearchResult offerSearchResult;
	
	public OfferSearchResultView(final SearchResult offerSearchResult) {
		this.offerSearchResult = offerSearchResult;
		
		Panel offerPanel = new Panel();
		offerPanel.setBorder(true);
		offerPanel.setMargins(5);
		for (SearchResult articleSearchResult : ((OfferSearchResult) offerSearchResult).getArticles())
			offerPanel.add((ArticleSearchResultView) articleSearchResult.getView());
		offerPanel.doLayout();
		
		initWidget(offerPanel);
	}
}
