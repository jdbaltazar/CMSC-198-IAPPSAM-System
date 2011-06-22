package com.iappsam.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.iappsam.servlet.LoginServlet;
import com.iappsam.servlet.Menu;
import com.iappsam.servlet.item.ItemServlet;
import com.iappsam.servlet.pr.PRServlet;

public class WebServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(80);

		WebAppContext context = new WebAppContext();
		context.setResourceBase("webapp");
		context.setDescriptor("webapp/WEB-INF/web.xml");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);

		context.addServlet(new ServletHolder(new LoginServlet()), "/login");
		context.addServlet(new ServletHolder(new ItemServlet()), "/items");
		context.addServlet(new ServletHolder(new PRServlet()), "/pr");
		context.addServlet(new ServletHolder(new Menu()), "/menu");

		server.setHandler(context);

		server.start();
		server.join();
	}
}
