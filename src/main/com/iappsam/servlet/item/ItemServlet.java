package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.ItemSearcher;
import com.iappsam.util.Managers;

import static com.iappsam.servlet.item.ItemParameter.*;
import static com.iappsam.servlet.item.ItemAttribute.*;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {

	public static final String LIST_ITEMS_JSP = "/items/list.jsp";
	public static final String NEW_ITEM_JSP = "/items/new.jsp";
	public static final String VIEW_ITEM_JSP = "/items/view.jsp";

	private static final long serialVersionUID = 1L;
	private ItemManager itemManager;
	private ItemSearcher searcher;

	public ItemServlet() {
		this(Managers.ITEM_MANAGER, new ItemSearcher());
	}

	public ItemServlet(ItemManager itemManager, ItemSearcher searcher) {
		super();
		this.itemManager = itemManager;
		this.searcher = searcher;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addItem(request, response);
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Item item = new Item();

		String description = request.getParameter(DESCRIPTION);
		String stockNumber = request.getParameter(STOCK_NUMBER);
		String unit = request.getParameter(UNIT);
		String price = request.getParameter(PRICE);
		String day = request.getParameter(DAY);
		String month = request.getParameter(MONTH);
		String year = request.getParameter(YEAR);

		String inventoryItemNumber = request.getParameter(INVENTORY_ITEM_NUM);
		String propertyNumber = request.getParameter(PROPERTY_NUM);
		String statusName = request.getParameter(STATUS);
		String conditionName = request.getParameter(CONDITION);
		String categoryName = request.getParameter(CATEGORY);

		request.setAttribute("firstAttempt", "false");
		request.setAttribute("validEntries", "true");

		try {
			item.setDescription(description);
			item.setStockNumber(stockNumber);
			item.setPrice(price);
			if (Item.isDateValid(year, month, day))
				item.setDateAcquired(year, month, day);
			item.setInventoryItemNumber(inventoryItemNumber);
			item.setPropertyNumber(propertyNumber);
			item.setUnit(itemManager.getUnitByName(unit));
			item.setItemStatus(itemManager.getItemStatusByName(statusName));
			item.setItemCondition(itemManager.getItemConditionByName(conditionName));
			item.setItemCategory(itemManager.getItemCategoryByName(categoryName));

			itemManager.addItem(item);
			response.sendRedirect("/items?id=" + item.getId());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("firstAttempt", "false");
			request.setAttribute("validEntries", "false");
			request.getRequestDispatcher(NEW_ITEM_JSP).forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ItemAction action = parseAction(request);

		if (action == ItemAction.NEW_ITEM)
			newItem(request, response);
		else if (action == ItemAction.VIEW_ITEM)
			viewItem(request, response);
		else if (action == ItemAction.SEARCH_ITEM)
			listItems(request, response, searcher.search(request.getParameter(ItemParameter.QUERY)));
		else
			try {
				listItems(request, response, itemManager.getAllItems());
			} catch (TransactionException e) {
				e.printStackTrace();
			}
	}

	private void viewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int itemID = Integer.parseInt(request.getParameter(ITEM_ID));
			Item item = itemManager.getItem(itemID);
			request.setAttribute(ItemAttribute.ITEM, item);

			// if (item.getDateAcquired() != null) {
			// Date date = item.getDateAcquired();
			// String day = DateUtil.getDayEquivalent(date);
			// String month = DateUtil.getMonthEquivalentInWords(date);
			// String year = DateUtil.getYearEquivalent(date);
			//
			// request.setAttribute("day", day);
			// request.setAttribute("month", month);
			// request.setAttribute("year", year);
			// }
			request.getRequestDispatcher(VIEW_ITEM_JSP).forward(request, response);
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}
	}

	private void newItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setAttribute(DONE, false);
			request.setAttribute(UNITS, itemManager.getAllUnits());
			request.setAttribute(CATEGORIES, itemManager.getAllItemCategory());
			request.setAttribute(STATUSES, itemManager.getAllItemStatus());
			request.setAttribute(CONDITIONS, itemManager.getAllItemCondition());
			request.setAttribute(VALID_INPUT_FOR_ITEM, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(NEW_ITEM_JSP).forward(request, response);
	}

	private void listItems(HttpServletRequest request, HttpServletResponse response, List<Item> items) throws ServletException, IOException {
		request.setAttribute(ITEMS, items);
		request.getRequestDispatcher(LIST_ITEMS_JSP).forward(request, response);
	}

	private ItemAction parseAction(HttpServletRequest request) {

		String newItem = request.getParameter("new");
		String id = request.getParameter("id");
		String q = request.getParameter(ItemParameter.QUERY);

		if (newItem != null) {
			if (newItem.equals("item"))
				return ItemAction.NEW_ITEM;
		} else if (id != null) {
			return ItemAction.VIEW_ITEM;
		} else if (q != null)
			return ItemAction.SEARCH_ITEM;

		return ItemAction.LIST_ITEMS;
	}
}
