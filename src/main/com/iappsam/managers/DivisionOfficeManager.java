package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Building;
import com.iappsam.entities.EmployeeDivisionOffice;
import com.iappsam.managers.exceptions.TransactionException;

public interface DivisionOfficeManager {

	// DivisionOffice

	void addDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	int saveDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	void updateDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	DivisionOffice getDivisionOffice(int divisionOfficeId) throws TransactionException;
	
	DivisionOffice getDivisionOfficeByEmployee(int employeeId) throws TransactionException;

	void removeDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	boolean containsDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	boolean containsDivisionOffice(String name) throws TransactionException;

	List<DivisionOffice> getDivisionOfficeByBuilding(int buildingId) throws TransactionException;

	List<DivisionOffice> getAllDivisionOffice() throws TransactionException;

	// Building

	void addBuilding(Building building) throws TransactionException;

	int saveBuilding(Building building) throws TransactionException;

	void updateBuilding(Building building) throws TransactionException;

	Building getBuilding(int buildingId) throws TransactionException;

	void removeBuilding(Building building) throws TransactionException;

	boolean containsBuilding(Building building) throws TransactionException;

	boolean containsBuilding(String name) throws TransactionException;

	List<Building> getAllBuildings() throws TransactionException;

	// EmployeeDivisionOffice

	List<EmployeeDivisionOffice> getAllEmployeeDivisionOffice() throws TransactionException;

}
