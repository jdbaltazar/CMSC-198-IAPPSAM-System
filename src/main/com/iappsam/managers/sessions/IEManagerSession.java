package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.InventoryOfEquipment;
import com.iappsam.entities.forms.InventoryOfEquipmentLine;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class IEManagerSession extends AbstractManager implements IEManager {

	@Override
	public void addIE(InventoryOfEquipment inventoryOfEquipment)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(inventoryOfEquipment);
	}

	@Override
	public int saveIE(InventoryOfEquipment inventoryOfEquipment)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(inventoryOfEquipment);
	}

	@Override
	public void updateIE(InventoryOfEquipment inventoryOfEquipment)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(inventoryOfEquipment);
	}

	@Override
	public InventoryOfEquipment getIE(int inventoryOfEquipmentID)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (InventoryOfEquipment) get(InventoryOfEquipment.class,
				inventoryOfEquipmentID);
	}

	@Override
	public boolean containsIE(InventoryOfEquipment inventoryOfEquipment)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(inventoryOfEquipment);
	}

	@Override
	public List<InventoryOfEquipment> getALLIE() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(InventoryOfEquipment.class);
	}

	@Override
	public void addIELine(InventoryOfEquipmentLine invenEquipmentLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(invenEquipmentLine);
	}

	@Override
	public void updateIELineOfIE(InventoryOfEquipmentLine invenEquipmentLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(invenEquipmentLine);
	}

	@Override
	public List<InventoryOfEquipmentLine> getIELineByIE(int invenEquipmentID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<InventoryOfEquipmentLine> ieLines = getAllIELine();
		List<InventoryOfEquipmentLine> results = new ArrayList<InventoryOfEquipmentLine>();
		for (InventoryOfEquipmentLine ieLine : ieLines) {
			if (ieLine.getIeID() == invenEquipmentID)
				results.add(ieLine);
		}
		return results;
	}

	@Override
	public boolean containsIELine(int invenEquipmentID, String itemDescription)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<InventoryOfEquipmentLine> ieLines = getAllIELine();
		for (InventoryOfEquipmentLine ieLine : ieLines) {
			if (ieLine.getIeID() == invenEquipmentID
					&& ieLine.getItemDescription().equalsIgnoreCase(itemDescription))
				return true;
		}
		return false;
	}

	@Override
	public List<InventoryOfEquipmentLine> getAllIELine()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(InventoryOfEquipmentLine.class);
	}

}
