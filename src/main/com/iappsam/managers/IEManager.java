package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.InventoryOfEquipment;
import com.iappsam.entities.forms.InventoryOfEquipmentLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface IEManager {

	void addIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;

	int saveIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;

	void updateIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;

	InventoryOfEquipment getIE(int inventoryOfEquipmentID) throws TransactionException;

	boolean containsIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;

	List<InventoryOfEquipment> getALLIE() throws TransactionException;

	// InventoryOfEquipmentLine

	void addIELine(InventoryOfEquipmentLine invenEquipmentLine) throws TransactionException;

	void updateIELineOfIE(InventoryOfEquipmentLine invenEquipmentLine) throws TransactionException;

	List<InventoryOfEquipmentLine> getIELineByIE(int invenEquipmentID) throws TransactionException;

	boolean containsIELine(int invenEquipmentID, String itemDescription) throws TransactionException;

	List<InventoryOfEquipmentLine> getAllIELine() throws TransactionException;
}
