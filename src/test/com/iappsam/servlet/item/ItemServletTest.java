package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.ItemSearcher;

import static org.mockito.Mockito.*;
import static com.iappsam.servlet.item.ItemParameter.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServletTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private RequestDispatcher dispatcher;

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
	public void init() throws TransactionException {
		servlet = new ItemServlet(itemManager, searcher);
		item.setId(1);
	}

	@Test
	public void listItems() throws ServletException, IOException, TransactionException {
		List<Item> items = new ArrayList<Item>();

		when(itemManager.getAllItems()).thenReturn(items);
		when(request.getRequestDispatcher(ItemServlet.LIST_ITEMS_JSP)).thenReturn(dispatcher);

		servlet.doGet(request, response);

		verify(request).setAttribute(ItemAttribute.ITEMS, items);
		verifyForwardedTo(ItemServlet.LIST_ITEMS_JSP);
	}

	@Test
	public void searchItems() throws ServletException, IOException {
		ArrayList<Item> list = new ArrayList<Item>();

		when(request.getParameter(ItemParameter.QUERY)).thenReturn("search");
		when(searcher.search("search")).thenReturn(list);
		when(request.getRequestDispatcher(ItemServlet.LIST_ITEMS_JSP)).thenReturn(dispatcher);

		servlet.doGet(request, response);

		verify(searcher).search("search");
		verify(request).setAttribute(ItemAttribute.ITEMS, list);
		verifyForwardedTo(ItemServlet.LIST_ITEMS_JSP);
	}

	private void verifyForwardedTo(String jsp) throws ServletException, IOException {
		verify(request).getRequestDispatcher(jsp);
		verify(dispatcher).forward(request, response);
	}

	@Test
	public void newItem() throws ServletException, IOException {
		when(request.getParameter("new")).thenReturn("item");
		when(request.getRequestDispatcher(ItemServlet.NEW_ITEM_JSP)).thenReturn(dispatcher);

		servlet.doGet(request, response);

		verifyForwardedTo(ItemServlet.NEW_ITEM_JSP);
	}

	@Test
	public void viewItem() throws ServletException, IOException, TransactionException {
		mockRequestToViewItem();
		mockItemManager();

		servlet.doGet(request, response);

		verify(itemManager).getItem(1);
		verify(request).setAttribute(ItemAttribute.ITEM, item);
		verifyForwardedTo(ItemServlet.VIEW_ITEM_JSP);
	}

	private void mockRequestToViewItem() {
		when(request.getParameter(ItemParameter.ITEM_ID)).thenReturn("1");
		when(request.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP)).thenReturn(dispatcher);
	}

	@Test
	public void itemWasAddedSuccessfully() throws ServletException, IOException, TransactionException {
		mockRequestToFillupForm();
		mockItemManager();

		when(request.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP)).thenReturn(dispatcher);

		servlet.doPost(request, response);

		verify(itemManager).addItem(any(Item.class));
		verify(response).sendRedirect(startsWith("/items?id="));
	}

	@Test
	public void itemWasNotAdded() throws ServletException, IOException {
		when(request.getRequestDispatcher(ItemServlet.NEW_ITEM_JSP)).thenReturn(dispatcher);
		servlet.doPost(request, response);

		verifyForwardedTo(ItemServlet.NEW_ITEM_JSP);
	}

	private void mockItemManager() throws TransactionException {
		when(itemManager.getUnitByName(unit.getName())).thenReturn(unit);
		when(itemManager.getItemConditionByName(con.getName())).thenReturn(con);
		when(itemManager.getItemCategoryByName(cat.getName())).thenReturn(cat);
		when(itemManager.getItemStatusByName(stat.getName())).thenReturn(stat);
		when(itemManager.getItem(item.getId())).thenReturn(item);
	}

	private void mockRequestToFillupForm() {
		when(request.getRequestDispatcher(ItemServlet.VIEW_ITEM_JSP)).thenReturn(dispatcher);
		when(request.getParameter(DESCRIPTION)).thenReturn("des");
		when(request.getParameter(STOCK_NUMBER)).thenReturn("10");
		when(request.getParameter(PRICE)).thenReturn("des");
		when(request.getParameter(YEAR)).thenReturn("2011");
		when(request.getParameter(MONTH)).thenReturn("01");
		when(request.getParameter(DAY)).thenReturn("01");
		when(request.getParameter(INVENTORY_ITEM_NUM)).thenReturn("inv");
		when(request.getParameter(PROPERTY_NUM)).thenReturn("proper");
		when(request.getParameter(UNIT)).thenReturn(unit.getName());
		when(request.getParameter(CONDITION)).thenReturn(con.getName());
		when(request.getParameter(CATEGORY)).thenReturn(cat.getName());
		when(request.getParameter(STATUS)).thenReturn(stat.getName());
		when(request.getParameter(ITEM_ID)).thenReturn(item.getId() + "");
	}
}
