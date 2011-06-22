package com.iappsam.jetty;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.iappsam.servlet.LoginServlet;
import com.iappsam.servlet.Menu;
import com.iappsam.servlet.item.ItemServlet;
import com.iappsam.servlet.pr.PRLineServlet;
import com.iappsam.servlet.pr.PRServlet;

public class WebServer {

	private static WebAppContext context;

	public static void main(String[] args) throws Exception {
		Server server = new Server(80);

		context = new WebAppContext();
		context.setResourceBase("webapp");
		context.setParentLoaderPriority(true);

		addServlet(new LoginServlet(), "/login");
		addServlet(new ItemServlet(), "/items");
		addServlet(new PRServlet(), "/pr");
		addServlet(new PRLineServlet(), "/pr/line");
		addServlet(new Menu(), "/menu");

		server.setHandler(context);

		server.start();
		server.join();
	}

	private static void addServlet(Servlet servlet, String path) {
		context.addServlet(new ServletHolder(servlet), path);
	}
}
