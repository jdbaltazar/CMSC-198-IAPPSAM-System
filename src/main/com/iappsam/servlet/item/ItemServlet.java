package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.DateUtil;
import com.iappsam.util.ManagerBin;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {
	public static final String LIST_ITEMS_JSP = "/items/list-items.jsp";
	public static final String ADD_ITEM_JSP = "/items/add-item.jsp";

	private static final long serialVersionUID = 1L;

	public ItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ItemAction action = getAction(request);

		if (action == ItemAction.VIEW_ITEMS) {
			viewItems(request, response);
		} else if (action == ItemAction.ADD_ITEM) {
			addItem(request, response);
		}
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager iManager = new ItemManagerSession();

		List<Unit> units = new ArrayList<Unit>();
		List<ItemCategory> categories = new ArrayList<ItemCategory>();
		List<ItemStatus> status = new ArrayList<ItemStatus>();
		List<ItemCondition> conditions = new ArrayList<ItemCondition>();

		ArrayList<String> itemUnits = new ArrayList<String>();
		ArrayList<String> itemCategories = new ArrayList<String>();
		ArrayList<String> itemStatuses = new ArrayList<String>();
		ArrayList<String> itemConditions = new ArrayList<String>();

		try {

			units = iManager.getAllUnits();
			categories = iManager.getAllItemCategory();
			status = iManager.getAllItemStatus();
			conditions = iManager.getAllItemCondition();

			if (units == null)
				units = new ArrayList<Unit>();

			if (categories == null)
				categories = new ArrayList<ItemCategory>();

			if (status == null)
				status = new ArrayList<ItemStatus>();

			if (conditions == null)
				conditions = new ArrayList<ItemCondition>();

		} catch (TransactionException e) {
			e.printStackTrace();
		}
		for (Unit u : units) {
			itemUnits.add(u.getName());
		}

		for (ItemCategory i : categories) {
			itemCategories.add(i.getName());
		}

		for (ItemStatus i : status) {
			itemStatuses.add(i.getName());
		}

		for (ItemCondition i : conditions) {
			itemConditions.add(i.getName());
		}

		request.setAttribute("finishedInputting", "false");
		request.setAttribute("validInputForItem", "true");
		request.setAttribute("itemUnits", itemUnits);
		request.setAttribute("itemCategories", itemCategories);
		request.setAttribute("itemStatuses", itemStatuses);
		request.setAttribute("itemConditions", itemConditions);

		request.setAttribute("validInputForItem", "true");
		request.setAttribute("finishedInputting", "false");

		RequestDispatcher view = request.getRequestDispatcher(ADD_ITEM_JSP);
		view.forward(request, response);
	}

	private void viewItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Item> items = new ArrayList<Item>();
		try {
			items = ManagerBin.iManager.getAllItems();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.setAttribute("items", items);
		request.getRequestDispatcher(LIST_ITEMS_JSP).forward(request, response);
	}

	private ItemAction getAction(HttpServletRequest request) {

		String view = request.getParameter("view");
		String add = request.getParameter("add");

		if (view != null) {
			if (view.equals("items"))
				return ItemAction.VIEW_ITEMS;
		} else if (add != null) {
			if (add.equals("item"))
				return ItemAction.ADD_ITEM;
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
