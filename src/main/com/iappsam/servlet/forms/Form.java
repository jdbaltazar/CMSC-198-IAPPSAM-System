package com.iappsam.servlet.forms;

import java.util.List;

import com.iappsam.entities.Item;
import com.iappsam.entities.Validatable;

public interface Form extends Validatable {

	public List<Item> getItems();

	public void addItem(Item item);

}
