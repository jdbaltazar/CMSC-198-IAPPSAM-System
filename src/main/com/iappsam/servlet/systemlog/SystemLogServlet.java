package com.iappsam.servlet.systemlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

@WebServlet("/system-logs")
public class SystemLogServlet extends HttpServlet {

	private static final long serialVersionUID = 6524025640333074089L;

	public static final String VIEW_SYSTEM_LOGS = "database/ViewSystemLog.jsp";

	public static final String SYSTEM_LOG_ACTION = "system-logs-action";
	public static final String VIEW_SYSTEM_LOG_ACTION = "view-system-logs";
	public static final String SEARCH_SYSTEM_LOG_ACTION = "search-system-logs";

	public SystemLogServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = parseAction(request);

		System.out.println("before processing in post");
		
		if (action != null)
			action.process(request, response);
		
		System.out.println("after processing in post");
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = parseAction(request);

		System.out.println("before processing in get");
		
		if (action != null)
			action.process(request, response);
	
		System.out.println("after processing in get");
	}
	

	private Action parseAction(HttpServletRequest request) {

		String action = request.getParameter(SYSTEM_LOG_ACTION);
		if (action.equalsIgnoreCase(VIEW_SYSTEM_LOG_ACTION)) {
			Action viewAction = new ViewSystemLogsAction();
			return viewAction;
		}
		
		if (action.equalsIgnoreCase(SEARCH_SYSTEM_LOG_ACTION)) {
			Action searchAction = new SearchSystemLogsAction();
			return searchAction;
		}
		
		return null;
	
	}
}
