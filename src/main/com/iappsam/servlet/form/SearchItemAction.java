package com.iappsam.servlet.form;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.search.ItemSearcher;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public abstract class SearchItemAction implements Action {

	private ItemSearcher searcher;

	public SearchItemAction(ApplicationContext appContext) {
		this.searcher = appContext.getItemSearcher();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> items = searcher.search(request.getParameter("q"));
		Form form = (Form) request.getSession().getAttribute("form");
		items.removeAll(form.getItems());
		request.setAttribute("items", items);
		request.getRequestDispatcher(getListItemJsp()).forward(request, response);
	}

	protected abstract String getListItemJsp();
}