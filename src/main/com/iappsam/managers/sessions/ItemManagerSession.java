package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSession extends AbstractManager implements ItemManager {

	@Override
	public void addItem(Item item) throws TransactionException {
		add(item);
	}

	@Override
	public int saveItem(Item item) throws TransactionException {
		return (Integer) save(item);
	}

	@Override
	public void updateItem(Item item) throws TransactionException {
		update(item);
	}

	@Override
	public Item getItem(int itemID) throws TransactionException {
		return (Item) get(Item.class, itemID);
	}

	@Override
	public void removeItem(Item item) throws TransactionException {
		remove(item);
	}

	@Override
	public boolean containsItem(Item item) throws TransactionException {
		return get(Item.class, item.getId()) != null;
	}

	@Override
	public boolean containsItem(int itemID) throws TransactionException {
		List<Item> items = getAllItems();
		for (Item item : items) {
			if (item.getId() == itemID)
				return true;
		}
		return false;
	}

	@Override
	public List<Item> getAllItems() throws TransactionException {
		return getList(Item.class);
	}

	@Override
	public void addUnit(Unit unit) throws TransactionException {
		add(unit);
	}

	@Override
	public String saveUnit(Unit unit) throws TransactionException {
		return (String) save(unit);
	}

	@Override
	public void updateUnit(Unit unit) throws TransactionException {
		update(unit);
	}

	@Override
	public Unit getUnit(String unitName) throws TransactionException {
		return (Unit) get(Unit.class, unitName);
	}

	@Override
	public void removeUnit(Unit unit) throws TransactionException {
		remove(unit);
	}

	@Override
	public boolean containsUnit(Unit unit) throws TransactionException {
		return get(Unit.class, unit.getUnit()) != null;
	}

	@Override
	public boolean containsUnit(String name) throws TransactionException {
		List<Unit> units = getAllUnits();
		for (Unit unit : units) {
			if (unit.getUnit().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Unit> getAllUnits() throws TransactionException {
		return getList(Unit.class);
	}

	@Override
	public void addItemStatus(ItemStatus itemStatus) throws TransactionException {
		add(itemStatus);
	}

	@Override
	public String saveItemStatus(ItemStatus itemStatus) throws TransactionException {
		return (String) saveItemStatus(itemStatus);
	}

	@Override
	public void updateItemStatus(ItemStatus itemStatus) throws TransactionException {
		update(itemStatus);
	}

	@Override
	public ItemStatus getItemStatus(String itemStatus) throws TransactionException {
		return (ItemStatus) get(Item.class, itemStatus);
	}

	@Override
	public void removeItemStatus(ItemStatus itemStatus) throws TransactionException {
		remove(itemStatus);
	}

	@Override
	public boolean containsItemStatus(ItemStatus itemStatus) throws TransactionException {
		return get(ItemStatus.class, itemStatus.getItemStatus()) != null;
	}

	@Override
	public boolean containsItemStatus(String name) throws TransactionException {
		List<ItemStatus> itemStatuses = getAllItemStatus();
		for (ItemStatus itemStatus : itemStatuses) {
			if (itemStatus.getItemStatus().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<ItemStatus> getAllItemStatus() throws TransactionException {
		return getList(ItemStatus.class);
	}

	@Override
	public void addItemCondition(ItemCondition itemCondition) throws TransactionException {
		add(itemCondition);
	}

	@Override
	public String saveItemCondition(ItemCondition itemCondition) throws TransactionException {
		return (String) save(itemCondition);
	}

	@Override
	public void updateItemCondition(ItemCondition itemCondition) throws TransactionException {
		update(itemCondition);
	}

	@Override
	public ItemCondition getItemCondition(String itemCondition) throws TransactionException {
		return (ItemCondition) get(ItemCondition.class, itemCondition);
	}

	@Override
	public void removeItemCondition(ItemCondition itemCondition) throws TransactionException {
		remove(itemCondition);
	}

	@Override
	public boolean containsItemCondition(ItemCondition itemCondition) throws TransactionException {
		return get(ItemCondition.class, itemCondition.getItemCondition()) != null;
	}

	@Override
	public boolean containsItemCondition(String name) throws TransactionException {
		List<ItemCondition> itemConditions = getAllItemCondition();
		for (ItemCondition itemCondition : itemConditions) {
			if (itemCondition.getItemCondition().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<ItemCondition> getAllItemCondition() throws TransactionException {
		return getList(ItemCondition.class);
	}

	public void addItemCategory(ItemCategory category) throws TransactionException {
		add(category);
	}

	@Override
	public boolean containsItemCategory(ItemCategory category) throws TransactionException {
		return get(ItemCategory.class, category.getItemCategory()) != null;
	}

	@Override
	public void removeItemCategory(ItemCategory category) throws TransactionException {
		remove(category);
	}

}
