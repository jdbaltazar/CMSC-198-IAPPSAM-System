package com.iappsam.servlet.item;

import static com.iappsam.servlet.item.ItemParameter.CATEGORY;
import static com.iappsam.servlet.item.ItemParameter.CONDITION;
import static com.iappsam.servlet.item.ItemParameter.DAY;
import static com.iappsam.servlet.item.ItemParameter.DESCRIPTION;
import static com.iappsam.servlet.item.ItemParameter.INVENTORY_ITEM_NUM;
import static com.iappsam.servlet.item.ItemParameter.MONTH;
import static com.iappsam.servlet.item.ItemParameter.PRICE;
import static com.iappsam.servlet.item.ItemParameter.PROPERTY_NUM;
import static com.iappsam.servlet.item.ItemParameter.STATUS;
import static com.iappsam.servlet.item.ItemParameter.STOCK_NUMBER;
import static com.iappsam.servlet.item.ItemParameter.UNIT;
import static com.iappsam.servlet.item.ItemParameter.YEAR;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.managers.ItemManager;

public class AddItemAction implements Action {

	private ItemManager itemManager;

	public AddItemAction(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			item.setStatus(itemManager.getItemStatusByName(statusName));
			item.setCondition(itemManager.getItemConditionByName(conditionName));
			item.setCategory(itemManager.getItemCategoryByName(categoryName));

			itemManager.addItem(item);
			response.sendRedirect("/items?id=" + item.getId());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("firstAttempt", "false");
			request.setAttribute("validEntries", "false");
			request.getRequestDispatcher(ItemServlet.NEW_ITEM_JSP).forward(request, response);
		}
	}
}
