package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Rate;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RatingHandlerAsync {
	public void sendRate(Rate rate, AsyncCallback<Integer> callback);
}
