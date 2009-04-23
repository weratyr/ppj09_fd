package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;

/**
 * The async counterpart of SearchHandler
 */
public interface SearchHandlerAsync {
	public void search(SearchQuery s, AsyncCallback<ArrayList<SearchResult>> callback);
}
