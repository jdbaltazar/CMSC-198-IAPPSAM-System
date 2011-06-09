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
	public void updateWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		update(wasteMaterialsReport);
	}

	@Override
	public WasteMaterialsReport getWMR(int wasteMaterialsReportID) throws TransactionException {
		return (WasteMaterialsReport) get(WasteMaterialsReport.class, wasteMaterialsReportID);
	}

	@Override
	public boolean containsWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		return getWMR(wasteMaterialsReport.getID()) != null;
	}

	@Override
	public List<WasteMaterialsReport> getAllWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		return getAll(WasteMaterialsReport.class);
	}

	@Override
	public void addDisposal(Disposal disposal) throws TransactionException {
		Disposal disp = getDisposal(disposal.getName());
		if (disp == null)
			add(disposal);
		else
			disposal.setId(disp.getId());
	}

	@Override
	public void addDisposal(String name) throws TransactionException {
		addDisposal(new Disposal(name));
	}

	@Override
	public void removeDisposal(Disposal disposal) throws TransactionException {
		remove(disposal);
	}

	@Override
	public boolean containsDisposal(Disposal disposal) throws TransactionException {
		return getDisposal(disposal.getId()) != null;
	}

	@Override
	public List<Disposal> getAllDisposal() throws TransactionException {
		return getAll(Disposal.class);
	}

	@Override
	public void updateDisposal(Disposal disposal) throws TransactionException {
		update(disposal);
	}

	@Override
	public Disposal getDisposal(int disposalID) throws TransactionException {
		return (Disposal) get(Disposal.class, disposalID);
	}

	@Override
	public Disposal getDisposal(String disposal) throws TransactionException {
		List<Disposal> disposals = getAllDisposal();
		for (Disposal d : disposals) {
			if (d.getName().equalsIgnoreCase(disposal))
				return d;
		}
		return null;
	}

}
