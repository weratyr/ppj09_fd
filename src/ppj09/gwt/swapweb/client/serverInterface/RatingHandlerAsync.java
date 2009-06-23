package ppj09.gwt.swapweb.client.serverInterface;

import com.google.gwt.user.client.rpc.AsyncCallback;

import ppj09.gwt.swapweb.client.datatype.Rate;

public interface RatingHandlerAsync {
	public void sendRate(Rate rate, AsyncCallback<Integer> callback);
}
