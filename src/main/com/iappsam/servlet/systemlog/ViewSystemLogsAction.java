package com.iappsam.servlet.systemlog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Log;
import com.iappsam.managers.LogManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.LogManagerSession;
import com.iappsam.servlet.Action;

public class ViewSystemLogsAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogManager l = new LogManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(SystemLogServlet.VIEW_SYSTEM_LOGS);
		
		List<Log> logs = new ArrayList<Log>();
		
		try {
			logs = l.viewLogs();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("logs", logs);
		view.forward(request, response);
	}

}
