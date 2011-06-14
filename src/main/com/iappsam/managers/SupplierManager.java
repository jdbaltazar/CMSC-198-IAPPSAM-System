package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Supplier;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public interface SupplierManager {

	void addSupplier(Supplier supplier) throws TransactionException, DuplicateEntryException;

	void updateSupplier(Supplier supplier) throws TransactionException;

	Supplier getSupplier(int supplierId) throws TransactionException;

	Supplier getSupplier(String supplierName) throws TransactionException;

	void removeSupplier(Supplier supplier) throws TransactionException;

	boolean containsSupplier(Supplier supplier) throws TransactionException;

	boolean containsSupplier(String name) throws TransactionException;

	List<Supplier> getAllSuppliers() throws TransactionException;

	Supplier getSupplier(Supplier supplier) throws TransactionException;

}
