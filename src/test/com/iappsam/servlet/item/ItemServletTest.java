package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.ItemSearcher;
import com.iappsam.servlet.ServletTestCase;

import static org.mockito.BDDMockito.*;
import static com.iappsam.servlet.item.ItemParameter.*;

public class ItemServletTest extends ServletTestCase {

	@Mock
	private ItemManager itemManager;
	@Mock
	private ItemSearcher searcher;

	private ItemCondition con = new ItemCondition("Good Condition");
	private Unit unit = new Unit("PCS");
	private ItemCategory cat = new ItemCategory("Others");
	private ItemStatus stat = new ItemStatus("Available");

	private Item item = new Item("Des", cat, unit, stat, con);

	private ItemServlet servlet;

	@Before
	public void init() {
		servlet = new ItemServlet(itemManager, searcher);
		item.setId(1);
	}

	@Test
	public void listItems() throws ServletException, IOException, TransactionException {
		List<Item> items = new ArrayList<Item>();

		given(itemManager.getAllItems()).willReturn(items);
		givenRequestDispatcher(ItemServlet.LIST_ITEMS_JSP);

		servlet.doGet(request, response);

		verify(request).setAttribute(ItemAttribute.ITEMS, items);
		verifyForwardedTo(ItemServlet.LIST_ITEMS_JSP);
	}

	@Test
	public void searchItems() throws ServletException, IOException {
		ArrayList<Item> list = new ArrayList<Item>();

		givenParam(ItemParameter.QUERY, "search");
		given(searcher.search("search")).willReturn(list);
		givenRequestDispatcher(ItemServlet.LIST_ITEMS_JSP);

		servlet.doGet(request, response);

		verify(searcher).search("search");
		verify(request).setAttribute(ItemAttribute.ITEMS, list);
		verifyForwardedTo(ItemServlet.LIST_ITEMS_JSP);
	}

	@Test
	public void newItem() throws ServletException, IOException {
		givenParam("new", "item");
		givenRequestDispatcher(ItemServlet.NEW_ITEM_JSP);

		servlet.doGet(request, response);

		verifyForwardedTo(ItemServlet.NEW_ITEM_JSP);
	}

	@Test
	public void viewItem() throws ServletException, IOException, TransactionException {
		givenRequestToViewItem();
		givenItemManager();

		servlet.doGet(request, response);

		verify(itemManager).getItem(1);
		verify(request).setAttribute(ItemAttribute.ITEM, item);
		verifyForwardedTo(ItemServlet.VIEW_ITEM_JSP);
	}

	@Test
	public void itemWasAddedSuccessfully() throws ServletException, IOException, TransactionException {
		givenRequestToFillupForm();
		givenItemManager();

		servlet.doPost(request, response);

		verify(itemManager).addItem(any(Item.class));
		verify(response).sendRedirect(startsWith("/items?id="));
	}

	@Test
	public void itemWasNotAdded() throws ServletException, IOException {
		givenRequestDispatcher(ItemServlet.NEW_ITEM_JSP);

		servlet.doPost(request, response);

		verifyForwardedTo(ItemServlet.NEW_ITEM_JSP);
	}

	private void givenRequestToViewItem() {
		given(request.getParameter(ItemParameter.ITEM_ID)).willReturn("1");
		given(request.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP)).willReturn(dispatcher);
	}

	private void givenItemManager() throws TransactionException {
		given(itemManager.getUnitByName(unit.getName())).willReturn(unit);
		given(itemManager.getItemConditionByName(con.getName())).willReturn(con);
		given(itemManager.getItemCategoryByName(cat.getName())).willReturn(cat);
		given(itemManager.getItemStatusByName(stat.getName())).willReturn(stat);
		given(itemManager.getItem(item.getId())).willReturn(item);
	}

	private void givenRequestToFillupForm() {
		given(request.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP)).willReturn(dispatcher);
		given(request.getParameter(DESCRIPTION)).willReturn("des");
		given(request.getParameter(STOCK_NUMBER)).willReturn("10");
		given(request.getParameter(PRICE)).willReturn("des");
		given(request.getParameter(YEAR)).willReturn("2011");
		given(request.getParameter(MONTH)).willReturn("01");
		given(request.getParameter(DAY)).willReturn("01");
		given(request.getParameter(INVENTORY_ITEM_NUM)).willReturn("inv");
		given(request.getParameter(PROPERTY_NUM)).willReturn("proper");
		given(request.getParameter(UNIT)).willReturn(unit.getName());
		given(request.getParameter(CONDITION)).willReturn(con.getName());
		given(request.getParameter(CATEGORY)).willReturn(cat.getName());
		given(request.getParameter(STATUS)).willReturn(stat.getName());
		given(request.getParameter(ITEM_ID)).willReturn(item.getId() + "");
	}
}
