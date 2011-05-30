package com.iappsam.search;

import java.util.List;

import com.iappsam.entities.Item;

public interface Searcher {

	<T> List<T> search(Class<T> c, String string);

}
