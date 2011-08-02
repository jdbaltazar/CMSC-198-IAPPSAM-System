package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.Building;
import com.iappsam.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class DivisionOfficeManagerSession extends AbstractManager implements DivisionOfficeManager {

	@Override
	public void addDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		DivisionOffice office = getDivisionOffice(divisionOffice.getDivisionName(), divisionOffice.getOfficeName());
		if (office == null)
			add(divisionOffice);
		else
			divisionOffice.setId(office.getId());
	}

	@Override
	public void updateDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		update(divisionOffice);
	}

	@Override
	public DivisionOffice getDivisionOffice(int divisionOfficeId) throws TransactionException {
		return (DivisionOffice) get(DivisionOffice.class, divisionOfficeId);
	}

	@Override
	public DivisionOffice getDivisionOffice(String division, String office) throws TransactionException {
		List<DivisionOffice> dOffices = getAllDivisionOffice();
		for (DivisionOffice dOffice : dOffices) {
			if (dOffice.getDivisionName().equalsIgnoreCase(division)) {
				if (office == null || office.equalsIgnoreCase("null"))
					return dOffice;
				else if (office != null && (dOffice.getOfficeName() != null && dOffice.getOfficeName().equalsIgnoreCase(office))) {
					return dOffice;
				}
			}
		}
		return null;
	}

	@Override
	public void removeDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		remove(divisionOffice);
	}

	@Override
	public boolean containsDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		return getDivisionOffice(divisionOffice.getId()) != null;
	}

	@Override
	public boolean containsDivisionOffice(String name) throws TransactionException {
		List<DivisionOffice> divisionOffices = getAllDivisionOffice();
		for (DivisionOffice divisionOffice : divisionOffices) {
			if (divisionOffice.getDivisionName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<DivisionOffice> getAllDivisionOffice() throws TransactionException {
		return getAll(DivisionOffice.class);
	}

	@Override
	public List<DivisionOffice> getOfficesUnderDivision(String divisionName) throws TransactionException {
		// TODO Auto-generated method stub

		List<DivisionOffice> offices = new ArrayList<DivisionOffice>();
		List<DivisionOffice> dOffices = getAllDivisionOffice();

		for (DivisionOffice dOffice : dOffices) {
			if (dOffice.getDivisionName().equalsIgnoreCase(divisionName) && dOffice.getOfficeName() != null) {
				offices.add(dOffice);
			}
		}
		return offices;
	}

	@Override
	public void addBuilding(Building building) throws TransactionException, DuplicateEntryException {
		if (getBuilding(building.getName(), building.getAddress()) == null)
			add(building);
	}

	@Override
	public void updateBuilding(Building building) throws TransactionException {
		update(building);
	}

	@Override
	public Building getBuilding(int buildingId) throws TransactionException {
		return (Building) get(Building.class, buildingId);
	}

	@Override
	public Building getBuilding(String buildingName, String buildingAddress) throws TransactionException {
		List<Building> buildings = getAllBuildings();
		for (Building b : buildings) {
			if (b.getName().equalsIgnoreCase(buildingName))
				if (b.getAddress() != null && b.getAddress().equalsIgnoreCase(buildingAddress)) {
					return b;
				}
			if (b.getAddress() == null && buildingAddress == null)
				return b;
		}
		return null;
	}

	@Override
	public void removeBuilding(Building building) throws TransactionException {
		remove(building);
	}

	@Override
	public boolean containsBuilding(Building building) throws TransactionException {
		return getBuilding(building.getId()) != null;
	}

	@Override
	public boolean containsBuilding(String name) throws TransactionException {
		List<Building> buildings = getAllBuildings();
		for (Building building : buildings) {
			if (building.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Building> getAllBuildings() throws TransactionException {
		return getAll(Building.class);
	}

	@Override
	public DivisionOffice getDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		return getDivisionOffice(divisionOffice.getId());
	}

	@Override
	public DivisionOffice getDivisionOffice(String doId) throws TransactionException {
		if (doId != null) {
			int id;
			try {
				id = Integer.parseInt(doId);
			} catch (NumberFormatException e) {
				return null;
			}
			return getDivisionOffice(id);
		} else
			return null;
	}

	@Override
	public Building getBuilding(String buildingId) throws TransactionException {
		if (buildingId != null) {
			int id;
			try {
				id = Integer.parseInt(buildingId);
			} catch (Exception e) {
				return null;
			}
			return getBuilding(id);
		}
		return null;
	}
}
