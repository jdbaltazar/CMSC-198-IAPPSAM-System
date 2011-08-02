package com.iappsam.logging;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.Account;
import com.iappsam.Log;
import com.iappsam.managers.LogManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.LogManagerSession;

public class Logger {

	public synchronized static void log(HttpServletRequest request, Date date, String description) throws TransactionException {
		Account a= (Account)request.getSession().getAttribute("account");
		LogManager lManager = new LogManagerSession();
		description = description +" by "+a.getUsername();
		Log l = new Log(date, description);
		lManager.addLog(l);
	}
	
	public synchronized static List<Log> viewLogs() throws TransactionException {
		LogManager lManager = new LogManagerSession();
		return lManager.viewLogs();
	}
	
}
