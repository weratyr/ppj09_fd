package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Article;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * The client side stub for the RPC service.
 */
public interface ArticleManager extends RemoteService {
	public int createArticle(Article newArticle);
}
