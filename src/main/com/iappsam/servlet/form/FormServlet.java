package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;

public abstract class FormServlet extends HttpServlet {

	private NewFormPageAction newPr;
	private FormLinePageAction addItem;
	private ListFormAction list;
	private RemoveFormLineAction removeItem;
	private AddFormAction addPr;
	private ViewFormAction viewPr;

	public FormServlet(ListFormAction list, AddFormAction addPr, NewFormPageAction newPr, FormLinePageAction addItem, RemoveFormLineAction removeItem,
			ViewFormAction viewPr) {
		this.list = list;
		this.newPr = newPr;
		this.addItem = addItem;
		this.removeItem = removeItem;
		this.addPr = addPr;
		this.viewPr = viewPr;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parseAction(request).process(request, response);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		parseAction(req).process(req, resp);
	}

	private Action parseAction(HttpServletRequest request) {
		String newParam = request.getParameter("new");
		String addItemParam = request.getParameter("addItems");
		String removeItemParam = request.getParameter("removeItems");
		String savePrParam = request.getParameter("saveForm");
		String idParam = request.getParameter("id");

		if (newParam != null)
			return newPr;
		else if (addItemParam != null)
			return addItem;
		else if (removeItemParam != null)
			return removeItem;
		else if (savePrParam != null)
			return addPr;
		else if (idParam != null)
			return viewPr;
		return list;
	}

}