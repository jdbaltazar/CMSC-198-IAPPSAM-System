package com.iappsam.search;

import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermMatchingContext;

import com.iappsam.entities.Item;
import com.iappsam.util.HibernateUtil;

public class ItemSearcher implements Searcher {

	private QueryBuilder builder;
	private TermMatchingContext onField;
	private FullTextSession fullSession;

	public ItemSearcher() {
		Session s = HibernateUtil.startSession();
		fullSession = Search.getFullTextSession(s);
		builder = fullSession.getSearchFactory().buildQueryBuilder().forEntity(Item.class).get();
		onField = builder.keyword().onField("description").andField("date");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> search(String string) {
		Query searchQuery = onField.ignoreFieldBridge().matching(string).createQuery();
		return fullSession.createFullTextQuery(searchQuery, Item.class).list();
	}
}
