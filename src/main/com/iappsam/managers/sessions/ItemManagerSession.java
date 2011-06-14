package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemCondition;
import com.iappsam.ItemStatus;
import com.iappsam.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class ItemManagerSession extends AbstractManager implements ItemManager {

	@Override
	public void addItem(Item item) throws TransactionException {
		add(item);
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
	public Item getItemByDescription(String description) throws TransactionException {
		List<Item> items = getAllItems();
		for (Item i : items) {
			if (i.getDescription().equalsIgnoreCase(description))
				return i;
		}
		return null;
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
		return getAll(Item.class);
	}

	@Override
	public List<Item> getAllExisitingItems() throws TransactionException {
		List<Item> items = getAllItems();
		List<Item> results = new ArrayList<Item>();
		for (Item i : items) {
			if (i.getDateAcquired() != null) {
				results.add(i);
			}
		}
		return results;
	}

	@Override
	public void addUnit(Unit unit) throws TransactionException {
		Unit u = getUnitByName(unit.getName());
		if (u == null)
			add(unit);
		else
			unit.setId(u.getId());
	}

	@Override
	public void addUnit(String name) throws TransactionException {
		if (getUnitByName(name) == null)
			add(new Unit(name));
	}

	@Override
	public void updateUnit(Unit unit) throws TransactionException {
		update(unit);
	}

	@Override
	public Unit getUnitByName(String unitName) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Unit item = (Unit) session.createCriteria(Unit.class).add(Restrictions.like("name", unitName)).uniqueResult();
		session.close();
		return item;
	}

	@Override
	public void removeUnit(Unit unit) throws TransactionException {
		remove(unit);
	}

	@Override
	public boolean containsUnit(Unit unit) throws TransactionException {
		return get(Unit.class, unit.getId()) != null;
	}

	@Override
	public boolean containsUnit(String name) throws TransactionException {
		return getUnitByName(name) != null;
	}

	@Override
	public List<Unit> getAllUnits() throws TransactionException {
		return getAll(Unit.class);
	}

	@Override
	public void addItemStatus(ItemStatus itemStatus) throws TransactionException {
		ItemStatus status = getItemStatusByName(itemStatus.getName());
		if (status == null)
			add(itemStatus);
		else
			itemStatus.setId(status.getId());
	}

	@Override
	public void addItemStatus(String name) throws TransactionException, DuplicateEntryException {
		if (getItemStatusByName(name) == null)
			add(new ItemStatus(name));
	}

	@Override
	public void updateItemStatus(ItemStatus itemStatus) throws TransactionException {
		update(itemStatus);
	}

	@Override
	public ItemStatus getItemStatusByName(String name) throws TransactionException {
		Session session = HibernateUtil.startSession();
		ItemStatus cat = (ItemStatus) session.createCriteria(ItemStatus.class).add(Restrictions.like("name", name)).uniqueResult();
		session.close();
		return cat;
	}

	@Override
	public void removeItemStatus(ItemStatus itemStatus) throws TransactionException {
		remove(itemStatus);
	}

	@Override
	public boolean containsItemStatus(ItemStatus itemStatus) throws TransactionException {
		return get(ItemStatus.class, itemStatus.getId()) != null;
	}

	@Override
	public boolean containsItemStatus(String name) throws TransactionException {
		List<ItemStatus> itemStatuses = getAllItemStatus();
		for (ItemStatus itemStatus : itemStatuses) {
			if (itemStatus.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<ItemStatus> getAllItemStatus() throws TransactionException {
		return getAll(ItemStatus.class);
	}

	@Override
	public void addItemCondition(ItemCondition itemCondition) throws TransactionException {
		ItemCondition condition = getItemConditionByName(itemCondition.getName());
		if (condition == null)
			add(itemCondition);
		else
			itemCondition.setId(condition.getId());
	}

	@Override
	public void addItemCondition(String name) throws TransactionException {
		if (getItemConditionByName(name) == null)
			add(new ItemCondition(name));
	}

	@Override
	public void updateItemCondition(ItemCondition itemCondition) throws TransactionException {
		update(itemCondition);
	}

	@Override
	public ItemCondition getItemConditionByName(String itemCondition) throws TransactionException {
		Session session = HibernateUtil.startSession();
		ItemCondition cat = (ItemCondition) session.createCriteria(ItemCondition.class).add(Restrictions.like("name", itemCondition)).uniqueResult();
		session.close();
		return cat;
	}

	@Override
	public void removeItemCondition(ItemCondition itemCondition) throws TransactionException {
		remove(itemCondition);
	}

	@Override
	public boolean containsItemCondition(ItemCondition itemCondition) throws TransactionException {
		return get(ItemCondition.class, itemCondition.getId()) != null;
	}

	@Override
	public boolean containsItemCondition(String name) throws TransactionException {
		List<ItemCondition> itemConditions = getAllItemCondition();
		for (ItemCondition itemCondition : itemConditions) {
			if (itemCondition.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<ItemCondition> getAllItemCondition() throws TransactionException {
		return getAll(ItemCondition.class);
	}

	@Override
	public void addItemCategory(ItemCategory category) throws TransactionException {
		ItemCategory cat = getItemCategoryByName(category.getName());
		if (cat == null)
			add(category);
		else
			category.setId(cat.getId());
	}

	@Override
	public void addItemCategory(String name) throws TransactionException {
		if (getItemCategoryByName(name) == null)
			add(new ItemCategory(name));

	}

	@Override
	public void updateItemCategory(ItemCategory category) throws TransactionException {
		update(category);
	}

	@Override
	public boolean containsItemCategory(ItemCategory category) throws TransactionException {
		return get(ItemCategory.class, category.getId()) != null;
	}

	@Override
	public void removeItemCategory(ItemCategory category) throws TransactionException {
		remove(category);
	}

	@Override
	public List<ItemCategory> getAllItemCategory() throws TransactionException {
		return getAll(ItemCategory.class);
	}

	@Override
	public ItemCategory getItemCategoryByName(String name) throws TransactionException {
		Session session = HibernateUtil.startSession();
		ItemCategory cat = (ItemCategory) session.createCriteria(ItemCategory.class).add(Restrictions.like("name", name)).uniqueResult();
		session.close();
		return cat;
	}

	@Override
	public ItemCategory getItemCategory(int itemCategoryID) throws TransactionException {
		return (ItemCategory) get(ItemCategory.class, itemCategoryID);
	}

	@Override
	public Unit getUnit(int unitID) throws TransactionException {
		return (Unit) get(Unit.class, unitID);
	}

	@Override
	public ItemStatus getItemStatus(int itemStatusID) throws TransactionException {
		return (ItemStatus) get(ItemStatus.class, itemStatusID);
	}

	@Override
	public ItemCondition getItemCondition(int itemConditionID) throws TransactionException {
		return (ItemCondition) get(ItemCondition.class, itemConditionID);
	}

	@Override
	public Item getItem(Item item) throws TransactionException {
		return getItemByDescription(item.getDescription());
	}
}
