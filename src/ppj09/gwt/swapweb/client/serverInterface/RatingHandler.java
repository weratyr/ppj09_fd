package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Rate;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("RatingHandler")
public interface RatingHandler extends RemoteService {
	public int sendRate(Rate rate);
	public int getRate(String username);
}
