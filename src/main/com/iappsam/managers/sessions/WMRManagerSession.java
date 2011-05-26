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
		// TODO Auto-generated method stub
		add(wasteMaterialsReport);
	}

	@Override
	public int saveWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(wasteMaterialsReport);
	}

	@Override
	public void updateWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		// TODO Auto-generated method stub
		update(wasteMaterialsReport);
	}

	@Override
	public WasteMaterialsReport getWMR(int wasteMaterialsReportID) throws TransactionException {
		// TODO Auto-generated method stub
		return (WasteMaterialsReport) get(WasteMaterialsReport.class, wasteMaterialsReportID);
	}

	@Override
	public boolean containsWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(wasteMaterialsReport);
	}

	@Override
	public List<WasteMaterialsReport> getAllWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException {
		// TODO Auto-generated method stub
		return getList(WasteMaterialsReport.class);
	}

	@Override
	public void addWMRLine(WasteMaterialsReportLine wasteMaterialsReportLine) throws TransactionException {
		// TODO Auto-generated method stub
		add(wasteMaterialsReportLine);
	}

	@Override
	public void updateWMRLine(WasteMaterialsReportLine wasteMaterialsReportLine) throws TransactionException {
		// TODO Auto-generated method stub
		update(wasteMaterialsReportLine);
	}

	@Override
	public List<WasteMaterialsReportLine> getWMRLineByWMR(int wasteMaterialsReportID) throws TransactionException {
		// TODO Auto-generated method stub
		List<WasteMaterialsReportLine> wmrLines = getAllWMRLine();
		List<WasteMaterialsReportLine> result = new ArrayList<WasteMaterialsReportLine>();
		for (WasteMaterialsReportLine wmrLine : wmrLines) {
			if (wmrLine.getWasteMaterialsReportId() == wasteMaterialsReportID)
				result.add(wmrLine);
		}
		return result;
	}

	@Override
	public boolean containsWMRLine(WasteMaterialsReportLine wasteMaterialsReportLine) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(wasteMaterialsReportLine);
	}

	@Override
	public List<WasteMaterialsReportLine> getAllWMRLine() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(WasteMaterialsReportLine.class);
	}

	@Override
	public void addDisposal(Disposal disposal) throws TransactionException {
		// TODO Auto-generated method stub
		add(disposal);
	}

	@Override
	public String saveDisposal(Disposal disposal) throws TransactionException {
		// TODO Auto-generated method stub
		return (String) save(disposal);
	}

	@Override
	public void removeDisposal(Disposal disposal) throws TransactionException {
		// TODO Auto-generated method stub
		remove(disposal);
	}

	@Override
	public boolean containsDisposal(Disposal disposal) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(disposal);
	}

	@Override
	public List<Disposal> getAllDisposal() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Disposal.class);
	}

}
