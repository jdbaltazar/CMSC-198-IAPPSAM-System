package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.RSMI;
import com.iappsam.entities.forms.RSMILine;
import com.iappsam.entities.forms.RecapitulationLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RSMIManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RSMIManagerSession extends AbstractManager implements RSMIManager {

	@Override
	public void addRSMI(RSMI rsmi) throws TransactionException {
		add(rsmi);
	}

	@Override
	public int saveRSMI(RSMI rsmi) throws TransactionException {
		return (Integer) save(rsmi);
	}

	@Override
	public void updateRSMI(RSMI rsmi) throws TransactionException {
		update(rsmi);
	}

	@Override
	public RSMI getRSMI(int rsmiID) throws TransactionException {
		return (RSMI) get(RSMI.class, rsmiID);
	}

	@Override
	public boolean containsRSMI(RSMI rsmi) throws TransactionException {
		return contains(rsmi);
	}

	@Override
	public List<RSMI> getAllRSMI() throws TransactionException {
		return getAllRSMI();
	}

	@Override
	public void addRecapitulationLine(RecapitulationLine recapitulationLine) throws TransactionException {
		add(recapitulationLine);
	}

	@Override
	public void updateRecapitulationLine(RecapitulationLine recapitulationLine) throws TransactionException {
		update(recapitulationLine);
	}

	@Override
	public List<RecapitulationLine> getRecapitulationLineByRSMI(int rsmiID) throws TransactionException {
		List<RecapitulationLine> recapLines = getAllRecapitulationLine();
		List<RecapitulationLine> result = new ArrayList<RecapitulationLine>();
		for (RecapitulationLine recapLine : recapLines) {
			if (recapLine.getRsmiID() == rsmiID)
				result.add(recapLine);
		}
		return result;
	}

	@Override
	public boolean containsRecapitulationLine(RecapitulationLine recapitulationLine) throws TransactionException {
		return contains(recapitulationLine);
	}

	@Override
	public List<RecapitulationLine> getAllRecapitulationLine() throws TransactionException {
		return getAll(RecapitulationLine.class);
	}

}
