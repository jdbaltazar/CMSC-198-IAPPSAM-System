package com.iappsam.servlet.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.search.ItemSearcher;
import com.iappsam.servlet.Action;

public class SearchItemAction implements Action {

	private ItemSearcher searcher;
	private String formName;

	public SearchItemAction(FormUtility utility) {
		this.searcher = utility.getApplicationContext().getItemSearcher();
		this.formName = utility.getFormName();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> all = searcher.search(request.getParameter("q"));
		List<Item> items = new ArrayList<Item>();
		for (Item i : all) {
			if (!items.contains(i))
				items.add(i);
		}
		Form form = (Form) request.getSession().getAttribute("form");
		items.removeAll(form.getItems());
		request.setAttribute("items", items);
		request.setAttribute("q", request.getParameter("q"));
		request.getRequestDispatcher(getListItemJsp()).forward(request, response);
	}

	protected String getListItemJsp() {
		return String.format("/%s/line/add-item.jsp", formName);
	}
}