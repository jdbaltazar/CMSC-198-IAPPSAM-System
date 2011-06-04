package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
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
	public Item getItemByDescription(String description) throws TransactionException {
		// Session session = HibernateUtil.startSession();
		// Item item = (Item)
		// session.createCriteria(Item.class).add(Restrictions.like("description",
		// description)).uniqueResult();
		// session.close();
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
		// TODO Auto-generated method stub
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
	public void addUnit(Unit unit) throws TransactionException, DuplicateEntryException {
		if (getUnitByName(unit.getName()) == null)
			add(unit);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void addUnit(String name) throws TransactionException, DuplicateEntryException {
		if (getUnitByName(name) == null)
			addUnit(new Unit(name));
		else
			throw new DuplicateEntryException();

	}

	@Override
	public int saveUnit(Unit unit) throws TransactionException, DuplicateEntryException {
		if (getUnitByName(unit.getName()) == null)
			return (Integer) save(unit);
		else
			throw new DuplicateEntryException();

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
	public void addItemStatus(ItemStatus itemStatus) throws TransactionException, DuplicateEntryException {
		if (getItemStatus(itemStatus.getName()) == null)
			add(itemStatus);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void addItemStatus(String name) throws TransactionException, DuplicateEntryException {
		if (getItemStatus(name) == null)
			addItemStatus(new ItemStatus(name));
		else
			throw new DuplicateEntryException();

	}

	@Override
	public int saveItemStatus(ItemStatus itemStatus) throws TransactionException, DuplicateEntryException {
		if (getItemStatus(itemStatus.getName()) == null)
			return (Integer) saveItemStatus(itemStatus);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void updateItemStatus(ItemStatus itemStatus) throws TransactionException {
		update(itemStatus);
	}

	@Override
	public ItemStatus getItemStatus(String name) throws TransactionException {
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
	public void addItemCondition(ItemCondition itemCondition) throws TransactionException, DuplicateEntryException {
		if (getItemCondition(itemCondition.getName()) == null)
			add(itemCondition);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void addItemCondition(String name) throws TransactionException, DuplicateEntryException {
		if (getItemCondition(name) == null)
			addItemCondition(new ItemCondition(name));
		else
			throw new DuplicateEntryException();

	}

	@Override
	public int saveItemCondition(ItemCondition itemCondition) throws TransactionException, DuplicateEntryException {
		if (getItemCondition(itemCondition.getName()) == null)
			return (Integer) save(itemCondition);
		else
			throw new DuplicateEntryException();

	}

	@Override
	public void updateItemCondition(ItemCondition itemCondition) throws TransactionException {
		update(itemCondition);
	}

	@Override
	public ItemCondition getItemCondition(String itemCondition) throws TransactionException {
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
	public void addItemCategory(ItemCategory category) throws TransactionException, DuplicateEntryException {
		if (getItemCategoryByName(category.getName()) == null)
			add(category);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void addItemCategory(String name) throws TransactionException, DuplicateEntryException {
		if (getItemCategoryByName(name) == null)
			addItemCategory(new ItemCategory(name));
		else
			throw new DuplicateEntryException();

	}

	@Override
	public int saveItemCategory(ItemCategory category) throws TransactionException, DuplicateEntryException {
		// TODO Auto-generated method stub
		if (getItemCategoryByName(category.getName()) == null)
			return (Integer) save(category);
		else
			throw new DuplicateEntryException();

	}

	@Override
	public void updateItemCategory(ItemCategory category) throws TransactionException {
		// TODO Auto-generated method stub
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
	public ItemCategory getItemCategoryByName(String name) {
		Session session = HibernateUtil.startSession();
		ItemCategory cat = (ItemCategory) session.createCriteria(ItemCategory.class).add(Restrictions.like("name", name)).uniqueResult();
		session.close();
		return cat;
	}

}
