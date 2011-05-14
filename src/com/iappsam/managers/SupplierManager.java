package com.iappsam.managers;

import com.iappsam.entities.Supplier;
import com.iappsam.managers.exceptions.TransactionException;
import com.mchange.v2.resourcepool.ResourcePool.Manager;

public interface SupplierManager extends Manager{
	
	void addSupplier(Supplier supplier) throws TransactionException;
	
}
