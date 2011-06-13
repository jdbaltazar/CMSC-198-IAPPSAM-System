package com.iappsam.servlet.forms;

import java.util.List;

import com.iappsam.entities.Item;

public interface Form {

	public List<Item> getItems();

	public void addItem(Item item);

//	public void removeItem(int id);
//
//	public void addItem(int id);

}
