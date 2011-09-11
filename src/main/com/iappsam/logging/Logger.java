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
				Log l = new Log(description);
				lManager.addLog(l);
		}catch(java.lang.IllegalStateException e1){
			e1.printStackTrace();
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
