package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.IE;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class IEManagerSession extends AbstractManager implements IEManager {

	@Override
	public void addIE(IE inventoryOfEquipment) throws TransactionException {
		add(inventoryOfEquipment);
	}

	@Override
	public void updateIE(IE inventoryOfEquipment) throws TransactionException {
		update(inventoryOfEquipment);
	}

	@Override
	public IE getIE(int inventoryOfEquipmentID) throws TransactionException {
		return (IE) get(IE.class, inventoryOfEquipmentID);
	}

	@Override
	public boolean containsIE(IE inventoryOfEquipment) throws TransactionException {
		return getIE(inventoryOfEquipment.getId()) != null;
	}

	@Override
	public List<IE> getAllIE() throws TransactionException {
		return getAll(IE.class);
	}

	@Override
	public void removeIE(IE ie) throws TransactionException {
		remove(ie);
	}
}
