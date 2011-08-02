package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemCondition;
import com.iappsam.ItemStatus;
import com.iappsam.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.ItemSearcher;
import com.iappsam.servlet.ServletTestCase;

import static org.junit.Assert.*;
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

	@Override
	@Before
	public void init() {
		given(appContext.getItemManager()).willReturn(itemManager);
		given(appContext.getItemSearcher()).willReturn(searcher);

		servlet = new ItemServlet(appContext);
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
		given(request.getParameter("add")).willReturn("item");

		servlet.doPost(request, response);

		verifyForwardedTo(ItemServlet.NEW_ITEM_JSP);
	}

	@Test
	public void itemUpdatedUnsucessfully() throws ServletException, IOException {

		givenRequestDispatcher(ItemServlet.VIEW_ITEM_JSP);
		given(request.getParameter("update")).willReturn("item");

		servlet.doPost(request, response);

		verifyForwardedTo(ItemServlet.VIEW_ITEM_JSP);
	}

	@Test
	public void itemUpdatedSucessfully() {
		fail();
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
		given(request.getParameter(INVENTORY_ITEM_NUM)).willReturn("inv");
		given(request.getParameter(PROPERTY_NUM)).willReturn("proper");
		given(request.getParameter(UNIT)).willReturn(unit.getName());
		given(request.getParameter(CONDITION)).willReturn(con.getName());
		given(request.getParameter(CATEGORY)).willReturn(cat.getName());
		given(request.getParameter(STATUS)).willReturn(stat.getName());
		given(request.getParameter(ITEM_ID)).willReturn(item.getId() + "");
		given(request.getParameter("add")).willReturn("item");
	}
}
