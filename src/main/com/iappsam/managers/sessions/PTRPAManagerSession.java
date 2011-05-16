package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.PTRPA;
import com.iappsam.entities.forms.PTRPALine;
import com.iappsam.managers.Manager;
import com.iappsam.managers.PTRPAManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PTRPAManagerSession extends Manager implements PTRPAManager {

	@Override
	public void addPTRPA(PTRPA ptrpa) throws TransactionException {
		// TODO Auto-generated method stub
		add(ptrpa);
	}

	@Override
	public int savePTRPA(PTRPA ptrpa) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(ptrpa);
	}

	@Override
	public void updatePTRPA(PTRPA ptrpa) throws TransactionException {
		// TODO Auto-generated method stub
		update(ptrpa);
	}

	@Override
	public PTRPA getPTRPA(int ptrpaID) throws TransactionException {
		// TODO Auto-generated method stub
		return (PTRPA) get(PTRPA.class, ptrpaID);
	}

	@Override
	public boolean containsPTRPA(PTRPA ptrpa) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(ptrpa);
	}

	@Override
	public List<PTRPA> getAllPTRPA() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(PTRPA.class);
	}

	@Override
	public void addPTRPALine(PTRPALine ptrpaLine) throws TransactionException {
		// TODO Auto-generated method stub
		add(ptrpaLine);
	}

	@Override
	public void updatePTRPALine(PTRPALine ptrpaLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(ptrpaLine);
	}

	@Override
	public List<PTRPALine> getPTRPALineByPTRPA(int ptrpaID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<PTRPALine> ptrpaLines = getAllPTRPALine();
		List<PTRPALine> result = new ArrayList<PTRPALine>();
		for (PTRPALine ptrpaLine : ptrpaLines) {
			if (ptrpaLine.getPtrpaID() == ptrpaID)
				result.add(ptrpaLine);
		}
		return result;
	}

	@Override
	public boolean containsPTRPALine(PTRPALine ptrpaLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(ptrpaLine);
	}

	@Override
	public List<PTRPALine> getAllPTRPALine() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(PTRPALine.class);
	}

}
