package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.exceptions.TransactionException;
import com.mchange.v2.resourcepool.ResourcePool.Manager;

public interface SupplierManager extends Manager{
	
	void addSupplier(Supplier supplier) throws TransactionException;

	int saveSupplier(Supplier supplier) throws TransactionException;

	void updateSupplier(Supplier supplier) throws TransactionException;

	Supplier getSupplier(int supplierId) throws TransactionException;

	void removeSupplier(Supplier supplier) throws TransactionException;

	boolean containsSupplier(Supplier supplier) throws TransactionException;

	boolean containsSupplier(String name) throws TransactionException;

	List<Supplier> getAllSuppliers() throws TransactionException;
	
	Person getContactPerson(Supplier supplier) throws TransactionException;
	
}
