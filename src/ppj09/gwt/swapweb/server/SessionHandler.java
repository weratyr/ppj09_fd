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
	
	public void setSession(String user, HttpServletRequest r){
		HttpServletRequest request = r;
		HttpSession session = request.getSession(true);
		session.setAttribute("userid", user);
	}
	
	public Integer getSession(HttpServletRequest r){
		HttpServletRequest request = r;
		HttpSession session = request.getSession();
		
		return (Integer) session.getAttribute("userid");
	}
	
	public void deleteSession(HttpServletRequest r) {
		HttpServletRequest request = r;
		HttpSession session = request.getSession();
		
		session.removeAttribute("userid");
	}
}
