package kr.co.findourlunch.common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractAction implements IAction {

	protected boolean redirect;
	
	@Override
	public abstract String perform(HttpServletRequest request,
			HttpServletResponse response, String action) throws ServletException, IOException;

	@Override
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;

	}

	@Override
	public boolean isRedirect() {
		return this.redirect;
	}

}
