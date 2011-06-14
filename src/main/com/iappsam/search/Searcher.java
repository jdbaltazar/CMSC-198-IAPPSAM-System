package com.iappsam.search;

import java.util.List;

public interface Searcher {

	<T> List<T> search(Class<T> c, String string);

}
