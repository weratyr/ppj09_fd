package ppj09.gwt.swapweb.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ppj09.gwt.swapweb.client.datatype.ArticleSearch;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.MessageSearch;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.UserSearch;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;

public class SearchHandlerImpl extends RemoteServiceServlet implements SearchHandler {
	public ArrayList<ArticleSearchResult> search(ArticleSearch articleSearch) {
		return null;
	}
	

	public ArrayList<ArticleSearchResult> search(UserSearch articleSearch) {
		return null;
	}

	public ArrayList<ArticleSearchResult> search(MessageSearch articleSearch) {
		return null;
	}
	
	public ArrayList<SearchResult> search(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}

}
