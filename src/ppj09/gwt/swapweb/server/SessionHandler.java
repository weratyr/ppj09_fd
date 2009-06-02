package ppj09.gwt.swapweb.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionHandler {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SessionHandler() {
		
	}
	
	public void setSession(String username, HttpServletRequest r){
		HttpServletRequest request = r;
		HttpSession session = request.getSession(true);
		session.setAttribute("userid", username);
	}
	
	public String getSession(HttpServletRequest r){
		HttpServletRequest request = r;
		HttpSession session = request.getSession();
		
		return session.getAttribute("userid").toString();
	}
	
	public void deleteSession(HttpServletRequest r) {
		HttpServletRequest request = r;
		HttpSession session = request.getSession();
		
		session.removeAttribute("userid");
	}
}
