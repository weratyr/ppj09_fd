package ppj09.gwt.swapweb.client.gui;

import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.Label;

import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class OfferSearchResultView extends Composite implements SearchResultView {
	private OfferSearchResult offerSearchResult;
	
	public OfferSearchResultView(final SearchResult offerSearchResult) {
		this.offerSearchResult = (OfferSearchResult) offerSearchResult;
		Panel offerPanel = new Panel();
		
		Label title = new Label("Angebot von " + this.offerSearchResult.getOfferedBy());
		offerPanel.add(title);
		
		offerPanel.setBorder(true);
		offerPanel.setMargins(5);
		for (SearchResult articleSearchResult : ((OfferSearchResult) offerSearchResult).getArticles())
			offerPanel.add((ArticleSearchResultView) articleSearchResult.getView());
		
		HorizontalPanel horizontalButtonPanel = new HorizontalPanel();
		Button annehmen = new Button("annehmen");
		Button ablehnen = new Button("ablehnen");
		horizontalButtonPanel.add(annehmen);
		horizontalButtonPanel.add(ablehnen);
		offerPanel.add(horizontalButtonPanel);
		
		offerPanel.doLayout();
		initWidget(offerPanel);
	}
}
