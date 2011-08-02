package com.iappsam.managers;

import java.util.List;

import com.iappsam.Log;
import com.iappsam.managers.exceptions.TransactionException;

public interface LogManager {
	
	void addLog(Log log) throws TransactionException;
	
	List<Log> viewLogs() throws TransactionException;

}
