package com.iappsam.servlet.systemlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

/**
 * Servlet implementation class BuildingServlet
 */
@WebServlet("/system-logs")
public class ViewSystemLogs extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6524025640333074089L;

	public static final String VIEW_SYSTEM_LOGS = "database/ViewSystemLog.jsp";
	
	public ViewSystemLogs() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = parseAction(request);

		if (action != null)
			action.process(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = parseAction(request);

		if (action != null)
			action.process(request, response);
	}

	private Action parseAction(HttpServletRequest request) {
		return new ViewSystemLogsAction();
	}
}
