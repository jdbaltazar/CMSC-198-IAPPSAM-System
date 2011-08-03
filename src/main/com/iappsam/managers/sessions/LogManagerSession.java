package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.Log;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.LogManager;
import com.iappsam.managers.exceptions.TransactionException;

public class LogManagerSession  extends AbstractManager implements LogManager {

	@Override
	public void addLog(Log log) throws TransactionException {
		add(log);
	}

	@Override
	public List<Log> viewLogs() throws TransactionException {
		return getAll(Log.class);
	}
	
}
