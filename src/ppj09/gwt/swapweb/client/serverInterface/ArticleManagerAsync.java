package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Article;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of Article Manager
 */
public interface ArticleManagerAsync {
	public void createArticle(Article newArticle, AsyncCallback<Integer> callback);
}
