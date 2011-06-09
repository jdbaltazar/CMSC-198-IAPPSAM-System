package com.iappsam.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(80);

		WebAppContext context = new WebAppContext();
		context.setResourceBase("webapp");
		context.setDescriptor("webapp/WEB-INF/web.xml");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);

		server.setHandler(context);

		server.start();
		server.join();
	}
}
