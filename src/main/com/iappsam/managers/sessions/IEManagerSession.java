package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.IOE;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class IEManagerSession extends AbstractManager implements IEManager {

	@Override
	public void addIE(IOE inventoryOfEquipment) throws TransactionException {
		add(inventoryOfEquipment);
	}

	@Override
	public void updateIE(IOE inventoryOfEquipment) throws TransactionException {
		update(inventoryOfEquipment);
	}

	@Override
	public IOE getIE(int inventoryOfEquipmentID) throws TransactionException {
		return (IOE) get(IOE.class, inventoryOfEquipmentID);
	}

	@Override
	public boolean containsIE(IOE inventoryOfEquipment) throws TransactionException {
		return getIE(inventoryOfEquipment.getIeID()) != null;
	}

	@Override
	public List<IOE> getAllIE() throws TransactionException {
		return getAll(IOE.class);
	}
}
