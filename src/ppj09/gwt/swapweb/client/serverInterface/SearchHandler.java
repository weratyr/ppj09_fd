package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * The client side stub for the RPC service.
 */
public interface SearchHandler extends RemoteService {
	public ArrayList<SearchResult> search(SearchQuery searchQuery);
}
