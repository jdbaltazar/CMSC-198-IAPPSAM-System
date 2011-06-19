package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;
import com.iappsam.servlet.item.AddItemAction;
import com.iappsam.servlet.item.ItemParameter;
import com.iappsam.servlet.item.ListItemsAction;
import com.iappsam.servlet.item.NewItemAction;
import com.iappsam.servlet.item.SearchItemsAction;
import com.iappsam.servlet.item.ViewItemAction;
import com.iappsam.util.ApplicationContext;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/supplier")
public class SupplierServlet extends HttpServlet {
	
	public static final String SEARCH_SUPPLIERS = "/entities/SearchSuppliers.jsp";
	
	
//	public static final String NEW_ITEM_JSP = "/items/new-item.jsp";
//	public static final String VIEW_ITEM_JSP = "/items/view-item.jsp";
//
//	private AddItemAction addItem;
//	private NewItemAction newItem;
//	private ViewItemAction viewItem;
//	private SearchItemsAction searchItems;
//	private ListItemsAction listItems;
//
//	public SupplierServlet() {
//		this(ApplicationContext.INSTANCE);
//	}
//
//	public ItemServlet(ApplicationContext m) {
//		super();
////		addItem = new AddItemAction(m.getItemManager());
////		newItem = new NewItemAction(m.getItemManager());
////		viewItem = new ViewItemAction(m.getItemManager());
////		searchItems = new SearchItemsAction(m.getItemSearcher());
////		listItems = new ListItemsAction(m.getItemManager());
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		addItem.process(request, response);
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		parseAction(request).process(request, response);
//	}
//
//	private Action parseAction(HttpServletRequest request) {
//
//		String newParam = request.getParameter(ItemParameter.NEW_ITEM);
//		String id = request.getParameter(ItemParameter.ITEM_ID);
//		String q = request.getParameter(ItemParameter.QUERY);
//
//		if (newParam != null && newParam.equals("item")) {
//			return newItem;
//		} else if (id != null) {
//			return viewItem;
//		} else if (q != null)
//			return searchItems;
//
//		return listItems;
//	}
}
