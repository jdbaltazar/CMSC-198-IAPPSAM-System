package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.IOE;
import com.iappsam.managers.exceptions.TransactionException;

public interface IEManager {

	void addIE(IOE inventoryOfEquipment) throws TransactionException;


	void updateIE(IOE inventoryOfEquipment) throws TransactionException;

	IOE getIE(int inventoryOfEquipmentID) throws TransactionException;

	boolean containsIE(IOE inventoryOfEquipment) throws TransactionException;

	List<IOE> getAllIE() throws TransactionException;
}
