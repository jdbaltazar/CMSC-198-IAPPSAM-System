package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;

public class SupplierManagerSession extends AbstractManager implements SupplierManager {

	@Override
	public void addSupplier(Supplier supplier) throws TransactionException {
		add(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) throws TransactionException {
		update(supplier);
	}

	@Override
	public Supplier getSupplier(int supplierId) throws TransactionException {
		return (Supplier) get(Supplier.class, supplierId);
	}

	@Override
	public Supplier getSupplier(String supplierName) throws TransactionException {
		List<Supplier> suppliers = getAllSuppliers();
		for (Supplier s : suppliers) {
			if (s.getSupplierName().equalsIgnoreCase(supplierName))
				return s;
		}
		return null;
	}

	@Override
	public void removeSupplier(Supplier supplier) throws TransactionException {

		Employee contactPerson = supplier.getContactPerson();

		if (contactPerson.getSupplierCount() == 1) {
			remove(supplier);
			remove(contactPerson);
		} else
			remove(supplier);
	}

	@Override
	public boolean containsSupplier(Supplier supplier) throws TransactionException {
		return getSupplier(supplier.getId()) != null;
	}

	@Override
	public boolean containsSupplier(String name) throws TransactionException {
		List<Supplier> suppliers = getAllSuppliers();
		for (Supplier s : suppliers) {
			if (s.getSupplierName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Supplier> getAllSuppliers() throws TransactionException {
		return getAll(Supplier.class);
	}
}
