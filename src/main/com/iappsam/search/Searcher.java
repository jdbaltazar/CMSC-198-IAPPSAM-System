package com.iappsam.search;

import java.util.List;

import com.iappsam.entities.Item;

public interface Searcher {

	List<Item> search(String string);

}
