package com.iappsam.logging;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.Account;
import com.iappsam.Log;
import com.iappsam.managers.LogManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.LogManagerSession;

public class Logger {

	public synchronized static void log(HttpServletRequest request, String description) {
		try {
			Account a = (Account) request.getSession().getAttribute("account");
			LogManager lManager = new LogManagerSession();
			description = description + " by " + a.getUsername();
			java.util.Date utilDate = new java.util.Date();
		   java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			Log l = new Log(sqlDate, description);
			lManager.addLog(l);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	public synchronized static List<Log> viewLogs() {
		try {
			LogManager lManager = new LogManagerSession();
			return lManager.viewLogs();
		} catch (TransactionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
