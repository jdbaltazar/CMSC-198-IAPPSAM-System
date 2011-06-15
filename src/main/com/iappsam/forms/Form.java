package com.iappsam.forms;

import java.util.List;

import com.iappsam.Item;
import com.iappsam.Validatable;

public interface Form extends Validatable {

	public List<Item> getItems();

	public void addItem(Item item);

}
