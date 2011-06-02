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

public class AbstractSearcher {

	private MultiFieldQueryParser queryParser;
	protected FullTextSession fullSession;
	protected Class<?> cl;

	public <T> AbstractSearcher(Class<T> class1, String... string) {
		super();
		Session s = HibernateUtil.startSession();
		fullSession = Search.getFullTextSession(s);
		createParser(string);
		setEntity(class1);
	}

	protected <T> void setEntity(Class<T> class1) {
		cl = class1;
	}

	private void createParser(String... fields) {
		queryParser = new MultiFieldQueryParser(Version.LUCENE_31, fields, new StandardAnalyzer(Version.LUCENE_31));
		queryParser.setAllowLeadingWildcard(true);
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> searchWithWilcardIn(String string) {
		Query searchQuery;
		try {
			searchQuery = queryParser.parse("*" + string + "*");
			FullTextQuery fullTextQuery = fullSession.createFullTextQuery(searchQuery, cl);
			return fullTextQuery.list();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<T>();
	}

	public <T> List<T> search(String string) {
		return searchWithWilcardIn(string);
	}

}