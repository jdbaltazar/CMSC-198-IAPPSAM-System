package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Building;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class DivisionOfficeManagerSession extends AbstractManager implements DivisionOfficeManager {

	@Override
	public void addDivisionOffice(DivisionOffice divisionOffice) throws TransactionException, DuplicateEntryException {
		if (getDivisionOffice(divisionOffice.getDivisionName(), divisionOffice.getOfficeName()) == null) {
			add(divisionOffice);
		} else {
			throw new DuplicateEntryException();
		}
	}

	@Override
	public int saveDivisionOffice(DivisionOffice divisionOffice) throws TransactionException, DuplicateEntryException {
		if (getDivisionOffice(divisionOffice.getDivisionName(), divisionOffice.getOfficeName()) == null) {
			return (Integer) save(divisionOffice);
		} else {
			throw new DuplicateEntryException();
		}
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
		return contains(divisionOffice);
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
	public void addBuilding(Building building) throws TransactionException, DuplicateEntryException {
		if (getBuilding(building.getBuildingName(), building.getBuildingAddress()) == null)
			add(building);
	}

	@Override
	public int saveBuilding(Building building) throws TransactionException, DuplicateEntryException {
		return (Integer) save(building);
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
			if (b.getBuildingName().equalsIgnoreCase(buildingName))
				if (b.getBuildingAddress() != null && b.getBuildingAddress().equalsIgnoreCase(buildingAddress)) {
					return b;
				}
			if (b.getBuildingAddress() == null && buildingAddress == null)
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
		return contains(building);
	}

	@Override
	public boolean containsBuilding(String name) throws TransactionException {
		List<Building> buildings = getAllBuildings();
		for (Building building : buildings) {
			if (building.getBuildingName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Building> getAllBuildings() throws TransactionException {
		return getAll(Building.class);
	}
}
