package ppj09.gwt.swapweb.client.datatype;

import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.SearchResultView;

import com.google.gwt.user.client.ui.Composite;

public class ArticleSearchResult extends Composite implements SearchResult  {
	public SearchResultView getView() {
		return new ArticleSearchResultView();
	}
}
