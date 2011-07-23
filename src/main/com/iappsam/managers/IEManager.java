package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.IE;
import com.iappsam.managers.exceptions.TransactionException;

public interface IEManager {

	void addIE(IE inventoryOfEquipment) throws TransactionException;


	void updateIE(IE inventoryOfEquipment) throws TransactionException;

	IE getIE(int id) throws TransactionException;

	boolean containsIE(IE inventoryOfEquipment) throws TransactionException;

	List<IE> getAllIE() throws TransactionException;
}
