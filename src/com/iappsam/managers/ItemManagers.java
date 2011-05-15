package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.TransactionException;

public interface ItemManagers {
	void addItem(Item item) throws TransactionException;

	int saveItem(Item item) throws TransactionException;

	void updateItem(Item item) throws TransactionException;

	Item getItem(int itemId) throws TransactionException;

	void removeItem(Item item) throws TransactionException;

	boolean containsItem(Item item) throws TransactionException;

	boolean containsItem(String name) throws TransactionException;

	List<Item> getAllItems() throws TransactionException;

	void addUnit(Unit unit) throws TransactionException;

	int saveUnit(Unit unit) throws TransactionException;

	void updateUnit(Unit unit) throws TransactionException;

	Unit getUnit(int unitId) throws TransactionException;

	void removeUnit(Unit unit) throws TransactionException;

	boolean containsUnit(Unit unit) throws TransactionException;

	boolean containsUnit(String name) throws TransactionException;

	List<Item> getAllUnits() throws TransactionException;

	void addItemStatus(ItemStatus itemStatus) throws TransactionException;

	int saveItemStatus(ItemStatus itemStatus) throws TransactionException;

	void updateItemStatus(ItemStatus itemStatus) throws TransactionException;

	ItemStatus getItemStatus(int itemStatusId) throws TransactionException;

	void removeItemStatus(ItemStatus itemStatus) throws TransactionException;

	boolean containsItemStatus(ItemStatus itemStatus) throws TransactionException;

	boolean containsItemStatus(String name) throws TransactionException;

	List<Item> getAllItemStatus() throws TransactionException;

	void addItemCondition(ItemCondition itemCondition) throws TransactionException;

	int saveItemCondition(ItemCondition itemCondition) throws TransactionException;

	void updateItemCondition(ItemCondition itemCondition) throws TransactionException;

	ItemCondition getItemCondition(int itemConditionId) throws TransactionException;

	void removeItemCondition(ItemCondition itemCondition) throws TransactionException;

	boolean containsItemCondition(ItemCondition itemCondition) throws TransactionException;

	boolean containsItemCondition(String name) throws TransactionException;

	List<Item> getAllItemCondition() throws TransactionException;

}