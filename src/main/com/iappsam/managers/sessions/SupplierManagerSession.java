package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.Manager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;

public class SupplierManagerSession extends Manager implements SupplierManager{

	@Override
	public void addSupplier(Supplier supplier) throws TransactionException {
		// TODO Auto-generated method stub
		add(supplier);
	}

	@Override
	public int saveSupplier(Supplier supplier) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer)save(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) throws TransactionException {
		// TODO Auto-generated method stub
		update(supplier);
	}

	@Override
	public Supplier getSupplier(int supplierId) throws TransactionException {
		// TODO Auto-generated method stub
		return (Supplier)get(Supplier.class, supplierId);
	}

	@Override
	public void removeSupplier(Supplier supplier) throws TransactionException {
		// TODO Auto-generated method stub
		remove(supplier);
	}

	@Override
	public boolean containsSupplier(Supplier supplier) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(supplier);
	}

	@Override
	public boolean containsSupplier(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<Supplier>suppliers = getList(Supplier.class);
		for(Supplier s: suppliers){
			if(s.getSupplierName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Supplier> getAllSuppliers() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Supplier.class);
	}
	
	//ContactPerson

	@Override
	public Person getContactPerson(Supplier supplier) throws TransactionException {
		// TODO Auto-generated method stub
		PersonManager pManager = new PersonManagerSession();
		return pManager.getPerson(supplier.getContactPersonID());
	}

}
