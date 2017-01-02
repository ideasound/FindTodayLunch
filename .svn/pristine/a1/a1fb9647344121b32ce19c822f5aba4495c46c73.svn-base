package kr.co.findourlunch.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MainServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println(this + ":: Application Start!");
		ServletContext app = contextEvent.getServletContext();
		String cPath = app.getContextPath();
		app.setAttribute("cPath", cPath);
	}

}
