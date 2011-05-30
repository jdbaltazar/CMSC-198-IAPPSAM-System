package com.iappsam.search;

import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermMatchingContext;

import com.iappsam.entities.Item;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.util.HibernateUtil;

public class IIRUPSearcher {

	private FullTextSession fullSession;
	private QueryBuilder builder;
	private TermMatchingContext onField;

	public IIRUPSearcher() {
		Session s = HibernateUtil.startSession();
		fullSession = Search.getFullTextSession(s);
		builder = fullSession.getSearchFactory().buildQueryBuilder().forEntity(IIRUP.class).get();
		onField = builder.keyword().onFields("iirup_date", "iirup_station", "lines.item.description");
	}

	@SuppressWarnings("unchecked")
	public List<IIRUP> search(String string) {
		Query searchQuery = onField.ignoreFieldBridge().matching(string).createQuery();
		FullTextQuery fullTextQuery = fullSession.createFullTextQuery(searchQuery, IIRUP.class);
		return fullTextQuery.list();
	}
}
