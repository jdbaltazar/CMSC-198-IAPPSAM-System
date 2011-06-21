package com.iappsam.managers;

import java.util.List;

import com.iappsam.Building;
import com.iappsam.DivisionOffice;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public interface DivisionOfficeManager {

	// DivisionOffice

	void addDivisionOffice(DivisionOffice divisionOffice) throws TransactionException, DuplicateEntryException;

	void updateDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	DivisionOffice getDivisionOffice(int divisionOfficeId) throws TransactionException;

	DivisionOffice getDivisionOffice(String division, String office) throws TransactionException;

	void removeDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	boolean containsDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

	boolean containsDivisionOffice(String name) throws TransactionException;

	List<DivisionOffice> getAllDivisionOffice() throws TransactionException;
	
	List<DivisionOffice> getOfficesUnderDivision(String divisionName) throws TransactionException;

	// Building

	void addBuilding(Building building) throws TransactionException, DuplicateEntryException;

	void updateBuilding(Building building) throws TransactionException;

	Building getBuilding(int buildingId) throws TransactionException;
	
	Building getBuilding(String buildingName, String buildingAddress) throws TransactionException;

	void removeBuilding(Building building) throws TransactionException;

	boolean containsBuilding(Building building) throws TransactionException;

	boolean containsBuilding(String name) throws TransactionException;

	List<Building> getAllBuildings() throws TransactionException;

	DivisionOffice getDivisionOffice(DivisionOffice divisionOffice) throws TransactionException;

}
