package com.iappsam.managers.sessions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.iappsam.Log;
import com.iappsam.Unit;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.LogManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class LogManagerSession  extends AbstractManager implements LogManager {

	@Override
	public void addLog(Log log) throws TransactionException {
		add(log);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> viewLogs() throws TransactionException {
		Session session = HibernateUtil.startSession();
		List<Log>logs = session.createCriteria(Log.class)
			    .addOrder( Order.desc("date") ) .list();
		return logs;
	}
	
}
