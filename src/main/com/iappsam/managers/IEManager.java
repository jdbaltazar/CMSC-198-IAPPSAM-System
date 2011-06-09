package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.InventoryOfEquipment;
import com.iappsam.entities.forms.InventoryOfEquipmentLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface IEManager {

	void addIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;


	void updateIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;

	InventoryOfEquipment getIE(int inventoryOfEquipmentID) throws TransactionException;

	boolean containsIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException;

	List<InventoryOfEquipment> getAllIE() throws TransactionException;
}
