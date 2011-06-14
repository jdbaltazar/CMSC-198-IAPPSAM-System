package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.InventoryOfEquipment;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class IEManagerSession extends AbstractManager implements IEManager {

	@Override
	public void addIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException {
		add(inventoryOfEquipment);
	}

	@Override
	public void updateIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException {
		update(inventoryOfEquipment);
	}

	@Override
	public InventoryOfEquipment getIE(int inventoryOfEquipmentID) throws TransactionException {
		return (InventoryOfEquipment) get(InventoryOfEquipment.class, inventoryOfEquipmentID);
	}

	@Override
	public boolean containsIE(InventoryOfEquipment inventoryOfEquipment) throws TransactionException {
		return getIE(inventoryOfEquipment.getIeID()) != null;
	}

	@Override
	public List<InventoryOfEquipment> getAllIE() throws TransactionException {
		return getAll(InventoryOfEquipment.class);
	}
}
