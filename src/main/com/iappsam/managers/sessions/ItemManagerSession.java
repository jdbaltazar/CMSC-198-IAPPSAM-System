package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSession extends AbstractManager implements ItemManager {

	@Override
	public void addItem(Item item) throws TransactionException {
		// TODO Auto-generated method stub
		add(item);
	}

	@Override
	public int saveItem(Item item) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(item);
	}

	@Override
	public void updateItem(Item item) throws TransactionException {
		// TODO Auto-generated method stub
		update(item);
	}

	@Override
	public Item getItem(String description) throws TransactionException {
		// TODO Auto-generated method stub
		return (Item) get(Item.class, description);
	}

	@Override
	public void removeItem(Item item) throws TransactionException {
		// TODO Auto-generated method stub
		remove(item);
	}

	@Override
	public boolean containsItem(Item item) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(item);
	}

	@Override
	public boolean containsItem(String description) throws TransactionException {
		// TODO Auto-generated method stub
		List<Item> items = getAllItems();
		for (Item item : items) {
			if (item.getDescription().equalsIgnoreCase(description))
				return true;
		}
		return false;
	}

	@Override
	public List<Item> getAllItems() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Item.class);
	}

	@Override
	public void addUnit(Unit unit) throws TransactionException {
		// TODO Auto-generated method stub
		add(unit);
	}

	@Override
	public String saveUnit(Unit unit) throws TransactionException {
		// TODO Auto-generated method stub
		return (String) save(unit);
	}

	@Override
	public void updateUnit(Unit unit) throws TransactionException {
		// TODO Auto-generated method stub
		update(unit);
	}

	@Override
	public Unit getUnit(String unitName) throws TransactionException {
		// TODO Auto-generated method stub
		return (Unit) get(Unit.class, unitName);
	}

	@Override
	public void removeUnit(Unit unit) throws TransactionException {
		// TODO Auto-generated method stub
		remove(unit);
	}

	@Override
	public boolean containsUnit(Unit unit) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(unit);
	}

	@Override
	public boolean containsUnit(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<Unit> units = getAllUnits();
		for (Unit unit : units) {
			if (unit.getUnit().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Unit> getAllUnits() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Unit.class);
	}

	@Override
	public void addItemStatus(ItemStatus itemStatus) throws TransactionException {
		// TODO Auto-generated method stub
		add(itemStatus);
	}

	@Override
	public String saveItemStatus(ItemStatus itemStatus) throws TransactionException {
		// TODO Auto-generated method stub
		return (String) saveItemStatus(itemStatus);
	}

	@Override
	public void updateItemStatus(ItemStatus itemStatus) throws TransactionException {
		// TODO Auto-generated method stub
		update(itemStatus);
	}

	@Override
	public ItemStatus getItemStatus(String itemStatus) throws TransactionException {
		// TODO Auto-generated method stub
		return (ItemStatus) get(Item.class, itemStatus);
	}

	@Override
	public void removeItemStatus(ItemStatus itemStatus) throws TransactionException {
		// TODO Auto-generated method stub
		remove(itemStatus);
	}

	@Override
	public boolean containsItemStatus(ItemStatus itemStatus) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(itemStatus);
	}

	@Override
	public boolean containsItemStatus(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<ItemStatus> itemStatuses = getAllItemStatus();
		for (ItemStatus itemStatus : itemStatuses) {
			if (itemStatus.getItemStatus().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<ItemStatus> getAllItemStatus() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(ItemStatus.class);
	}

	@Override
	public void addItemCondition(ItemCondition itemCondition) throws TransactionException {
		// TODO Auto-generated method stub
		add(itemCondition);
	}

	@Override
	public String saveItemCondition(ItemCondition itemCondition) throws TransactionException {
		// TODO Auto-generated method stub
		return (String) save(itemCondition);
	}

	@Override
	public void updateItemCondition(ItemCondition itemCondition) throws TransactionException {
		// TODO Auto-generated method stub
		update(itemCondition);
	}

	@Override
	public ItemCondition getItemCondition(String itemCondition) throws TransactionException {
		// TODO Auto-generated method stub
		return (ItemCondition) get(ItemCondition.class, itemCondition);
	}

	@Override
	public void removeItemCondition(ItemCondition itemCondition) throws TransactionException {
		// TODO Auto-generated method stub
		remove(itemCondition);
	}

	@Override
	public boolean containsItemCondition(ItemCondition itemCondition) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(itemCondition);
	}

	@Override
	public boolean containsItemCondition(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<ItemCondition> itemConditions = getAllItemCondition();
		for (ItemCondition itemCondition : itemConditions) {
			if (itemCondition.getItemCondition().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<ItemCondition> getAllItemCondition() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(ItemCondition.class);
	}

}
