package kr.co.findourlunch.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.findourlunch.common.action.IAction;

public class WebController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3568698864314391985L;

	private Map<String, String> actionMap;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		ResourceBundle rb = ResourceBundle.getBundle("uriActionMapping");
		actionMap = new HashMap<String, String>();
		Enumeration<String> keys = rb.getKeys();
		while(keys.hasMoreElements()){
			String uri = keys.nextElement();
			String actionName = rb.getString(uri);
			actionMap.put(uri.trim(), actionName.trim());
		}
		System.out.println(this + ": Action Mapping Info Loading Complete!");
	}

	private IAction getAction(String uri){
		System.out.println("Request URI : " + uri);
		String actionName = actionMap.get(uri);
		IAction action = null;
		try {
			Class<?> clz = Class.forName(actionName);
			action = (IAction) clz.newInstance();
			return action;
		} catch (ClassNotFoundException e) {
			System.out.println(this + " : Could Not found action");
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			System.out.println(this + " : Could Not create instance");
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			System.out.println(this + " : Could Not create instance");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int len = request.getContextPath().length();
		uri = uri.substring(len);
		
		IAction action = getAction(uri);
		String view = null;
		if (action != null){
			view = action.perform(request, response, uri);
			if (view == null){
				if(response.isCommitted()){
					return;
				}else{
					response.sendError(500, "Internal Error!");
					return;
				}
			} else {
				boolean isRedirect = action.isRedirect();
				if(isRedirect) {
					response.sendRedirect(request.getContextPath() + view);
				} else {
					view = "/WEB-INF/views" + view;
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				}
			}
		} else {
			response.sendError(400, "Document not Found Error");
		}
	}

	
}
