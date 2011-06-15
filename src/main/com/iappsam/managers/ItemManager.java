package com.iappsam.managers;

import java.util.List;

import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemCondition;
import com.iappsam.ItemStatus;
import com.iappsam.Unit;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public interface ItemManager extends Manager {

	// Item

	void addItem(Item item) throws TransactionException;

	void updateItem(Item item) throws TransactionException;

	Item getItem(int itemID) throws TransactionException;

	Item getItemByDescription(String description) throws TransactionException;

	void removeItem(Item item) throws TransactionException;

	boolean containsItem(Item item) throws TransactionException;

	boolean containsItem(int itemID) throws TransactionException;

	List<Item> getAllItems() throws TransactionException;

	List<Item> getAllExisitingItems() throws TransactionException;

	// Unit

	void addUnit(Unit unit) throws TransactionException;

	void addUnit(String unitName) throws TransactionException;

	void updateUnit(Unit unit) throws TransactionException;

	Unit getUnitByName(String unitName) throws TransactionException;

	Unit getUnit(int unitID) throws TransactionException;

	void removeUnit(Unit unit) throws TransactionException;

	boolean containsUnit(Unit unit) throws TransactionException;

	boolean containsUnit(String name) throws TransactionException;

	List<Unit> getAllUnits() throws TransactionException;

	// ItemStatus

	void addItemStatus(ItemStatus itemStatus) throws TransactionException;

	void addItemStatus(String name) throws TransactionException, DuplicateEntryException;

	void updateItemStatus(ItemStatus itemStatus) throws TransactionException;

	ItemStatus getItemStatusByName(String itemStatus) throws TransactionException;

	ItemStatus getItemStatus(int itemStatusID) throws TransactionException;

	void removeItemStatus(ItemStatus itemStatus) throws TransactionException;

	boolean containsItemStatus(ItemStatus itemStatus) throws TransactionException;

	boolean containsItemStatus(String name) throws TransactionException;

	List<ItemStatus> getAllItemStatus() throws TransactionException;

	// ItemCondition

	void addItemCondition(ItemCondition itemCondition) throws TransactionException;

	void addItemCondition(String name) throws TransactionException, DuplicateEntryException;

	void updateItemCondition(ItemCondition itemCondition) throws TransactionException;

	ItemCondition getItemConditionByName(String itemCondition) throws TransactionException;

	ItemCondition getItemCondition(int itemConditionID) throws TransactionException;

	void removeItemCondition(ItemCondition itemCondition) throws TransactionException;

	boolean containsItemCondition(ItemCondition itemCondition) throws TransactionException;

	boolean containsItemCondition(String name) throws TransactionException;

	List<ItemCondition> getAllItemCondition() throws TransactionException;

	// ItemCategory

	void addItemCategory(ItemCategory category) throws TransactionException;

	void addItemCategory(String name) throws TransactionException, DuplicateEntryException;

	void updateItemCategory(ItemCategory category) throws TransactionException;

	ItemCategory getItemCategoryByName(String name) throws TransactionException;

	ItemCategory getItemCategory(int itemCategoryID) throws TransactionException;

	boolean containsItemCategory(ItemCategory category) throws TransactionException;

	void removeItemCategory(ItemCategory category) throws TransactionException;

	List<ItemCategory> getAllItemCategory() throws TransactionException;

	Item getItem(Item item) throws TransactionException;

}
