package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public interface ItemManager extends Manager {

	// Item

	void addItem(Item item) throws TransactionException;

	int saveItem(Item item) throws TransactionException;

	void updateItem(Item item) throws TransactionException;

	Item getItem(int itemID) throws TransactionException;

	Item getItemByDescription(String description) throws TransactionException;

	void removeItem(Item item) throws TransactionException;

	boolean containsItem(Item item) throws TransactionException;

	boolean containsItem(int itemID) throws TransactionException;

	List<Item> getAllItems() throws TransactionException;

	List<Item> getAllExisitingItems() throws TransactionException;

	// Unit

	void addUnit(Unit unit) throws TransactionException, DuplicateEntryException;

	void addUnit(String unitName) throws TransactionException, DuplicateEntryException;

	int saveUnit(Unit unit) throws TransactionException, DuplicateEntryException;

	void updateUnit(Unit unit) throws TransactionException;

	Unit getUnitByName(String unitName) throws TransactionException;

	void removeUnit(Unit unit) throws TransactionException;

	boolean containsUnit(Unit unit) throws TransactionException;

	boolean containsUnit(String name) throws TransactionException;

	List<Unit> getAllUnits() throws TransactionException;

	// ItemStatus

	void addItemStatus(ItemStatus itemStatus) throws TransactionException, DuplicateEntryException;

	void addItemStatus(String name) throws TransactionException, DuplicateEntryException;

	int saveItemStatus(ItemStatus itemStatus) throws TransactionException, DuplicateEntryException;

	void updateItemStatus(ItemStatus itemStatus) throws TransactionException;

	ItemStatus getItemStatus(String itemStatus) throws TransactionException;

	void removeItemStatus(ItemStatus itemStatus) throws TransactionException;

	boolean containsItemStatus(ItemStatus itemStatus) throws TransactionException;

	boolean containsItemStatus(String name) throws TransactionException;

	List<ItemStatus> getAllItemStatus() throws TransactionException;

	// ItemCondition

	void addItemCondition(ItemCondition itemCondition) throws TransactionException, DuplicateEntryException;

	void addItemCondition(String name) throws TransactionException, DuplicateEntryException;

	int saveItemCondition(ItemCondition itemCondition) throws TransactionException, DuplicateEntryException;

	void updateItemCondition(ItemCondition itemCondition) throws TransactionException;

	ItemCondition getItemCondition(String itemCondition) throws TransactionException;

	void removeItemCondition(ItemCondition itemCondition) throws TransactionException;

	boolean containsItemCondition(ItemCondition itemCondition) throws TransactionException;

	boolean containsItemCondition(String name) throws TransactionException;

	List<ItemCondition> getAllItemCondition() throws TransactionException;

	// ItemCategory

	void addItemCategory(ItemCategory category) throws TransactionException, DuplicateEntryException;

	void addItemCategory(String name) throws TransactionException, DuplicateEntryException;

	int saveItemCategory(ItemCategory category) throws TransactionException, DuplicateEntryException;

	void updateItemCategory(ItemCategory category) throws TransactionException;

	ItemCategory getItemCategoryByName(String name) throws TransactionException;

	ItemCategory getItemCategory(int itemCategoryID) throws TransactionException;

	boolean containsItemCategory(ItemCategory category) throws TransactionException;

	void removeItemCategory(ItemCategory category) throws TransactionException;

	List<ItemCategory> getAllItemCategory() throws TransactionException;

}
