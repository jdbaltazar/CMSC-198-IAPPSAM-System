package com.iappsam.util;

import org.hibernate.Session;
import org.hibernate.search.Search;

public class Indexer {

	public static void reindex() {
		try {
			Session s = HibernateUtil.startSession();
			Search.getFullTextSession(s).createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
