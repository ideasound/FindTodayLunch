package kr.co.findourlunch.common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	
	public String perform(HttpServletRequest request,
			HttpServletResponse response, String action) throws ServletException, IOException;
	
	public void setRedirect(boolean redirect);
	
	public boolean isRedirect();
}
