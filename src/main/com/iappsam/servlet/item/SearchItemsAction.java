package com.iappsam.servlet.item;

import static com.iappsam.servlet.item.ItemAttribute.ITEMS;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.search.ItemSearcher;
import com.iappsam.servlet.Action;

public class SearchItemsAction implements Action {

	private ItemSearcher searcher;

	public SearchItemsAction(ItemSearcher searcher) {
		super();
		this.searcher = searcher;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> items = searcher.search(request.getParameter(ItemParameter.QUERY));
		request.setAttribute(ITEMS, items);
		request.setAttribute("query", request.getParameter(ItemParameter.QUERY));
		request.getRequestDispatcher(ItemServlet.LIST_ITEMS_JSP).forward(request, response);
	}
}
