package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.Building;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.EmployeeDivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class DivisionOfficeManagerSession extends AbstractManager implements DivisionOfficeManager {

	@Override
	public void addDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		// TODO Auto-generated method stub
		add(divisionOffice);
	}

	@Override
	public int saveDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(divisionOffice);
	}

	@Override
	public void updateDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		// TODO Auto-generated method stub
		update(divisionOffice);
	}

	@Override
	public DivisionOffice getDivisionOffice(int divisionOfficeId) throws TransactionException {
		// TODO Auto-generated method stub
		return (DivisionOffice) get(DivisionOffice.class, divisionOfficeId);
	}

	@Override
	public void removeDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		// TODO Auto-generated method stub
		remove(divisionOffice);
	}

	@Override
	public boolean containsDivisionOffice(DivisionOffice divisionOffice) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(divisionOffice);
	}

	@Override
	public boolean containsDivisionOffice(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<DivisionOffice> divisionOffices = getAllDivisionOffice();
		for (DivisionOffice divisionOffice : divisionOffices) {
			if (divisionOffice.getDivisionName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public DivisionOffice getDivisionOfficeByEmployee(int employeeId) throws TransactionException {
		// TODO Auto-generated method stub
		List<EmployeeDivisionOffice> emDivisionOffices = getAllEmployeeDivisionOffice();
		for (EmployeeDivisionOffice emDivisionOffice : emDivisionOffices) {
			if (emDivisionOffice.getEmployeeID() == employeeId)
				return getDivisionOffice(emDivisionOffice.getDivisionOfficeID());
		}
		return null;
	}

	@Override
	public List<DivisionOffice> getAllDivisionOffice() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(DivisionOffice.class);
	}

	@Override
	public void addBuilding(Building building) throws TransactionException {
		// TODO Auto-generated method stub
		add(building);
	}

	@Override
	public int saveBuilding(Building building) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(building);
	}

	@Override
	public void updateBuilding(Building building) throws TransactionException {
		// TODO Auto-generated method stub
		update(building);
	}

	@Override
	public Building getBuilding(int buildingId) throws TransactionException {
		// TODO Auto-generated method stub
		return (Building) get(Building.class, buildingId);
	}

	@Override
	public void removeBuilding(Building building) throws TransactionException {
		// TODO Auto-generated method stub
		remove(building);
	}

	@Override
	public boolean containsBuilding(Building building) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(building);
	}

	@Override
	public boolean containsBuilding(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<Building> buildings = getAllBuildings();
		for (Building building : buildings) {
			if (building.getBuildingName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Building> getAllBuildings() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Building.class);
	}

	@Override
	public List<EmployeeDivisionOffice> getAllEmployeeDivisionOffice() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(EmployeeDivisionOffice.class);
	}

}
