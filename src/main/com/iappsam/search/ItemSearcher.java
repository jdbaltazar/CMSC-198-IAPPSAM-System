package com.iappsam.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import com.iappsam.entities.Item;
import com.iappsam.util.HibernateUtil;

public class ItemSearcher {

	private FullTextSession fullSession;
	private MultiFieldQueryParser queryParser;

	public ItemSearcher() {
		Session s = HibernateUtil.startSession();
		fullSession = Search.getFullTextSession(s);

		queryParser = new MultiFieldQueryParser(Version.LUCENE_31, new String[] { "description" }, new StandardAnalyzer(Version.LUCENE_31));
		queryParser.setAllowLeadingWildcard(true);
	}

	@SuppressWarnings("unchecked")
	public List<Item> search(String string) {

		Query searchQuery;
		try {
			searchQuery = queryParser.parse("*" + string + "*");
			FullTextQuery fullTextQuery = fullSession.createFullTextQuery(searchQuery, Item.class);
			return fullTextQuery.list();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<Item>();
	}
}
