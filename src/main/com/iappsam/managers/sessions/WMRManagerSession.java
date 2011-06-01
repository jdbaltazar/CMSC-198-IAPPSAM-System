package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.WasteMaterialsReport;
import com.iappsam.entities.forms.WasteMaterialsReportLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.exceptions.TransactionException;

public class WMRManagerSession extends AbstractManager implements WMRManager {

	@Override
	public void addWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		add(wasteMaterialsReport);
	}

	@Override
	public int saveWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		return (Integer) save(wasteMaterialsReport);
	}

	@Override
	public void updateWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		update(wasteMaterialsReport);
	}

	@Override
	public WasteMaterialsReport getWMR(int wasteMaterialsReportID) throws TransactionException {
		return (WasteMaterialsReport) get(WasteMaterialsReport.class, wasteMaterialsReportID);
	}

	@Override
	public boolean containsWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		return contains(wasteMaterialsReport);
	}

	@Override
	public List<WasteMaterialsReport> getAllWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		return getAll(WasteMaterialsReport.class);
	}

	@Override
	public void addDisposal(Disposal disposal) throws TransactionException {
		add(disposal);
	}

	@Override
	public String saveDisposal(Disposal disposal) throws TransactionException {
		return (String) save(disposal);
	}

	@Override
	public void removeDisposal(Disposal disposal) throws TransactionException {
		remove(disposal);
	}

	@Override
	public boolean containsDisposal(Disposal disposal) throws TransactionException {
		return contains(disposal);
	}

	@Override
	public List<Disposal> getAllDisposal() throws TransactionException {
		return getAll(Disposal.class);
	}

}
