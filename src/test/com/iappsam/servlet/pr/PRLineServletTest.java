package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import com.iappsam.Item;
import com.iappsam.forms.PR;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.search.ItemSearcher;
import com.iappsam.servlet.ServletTestCase;
import com.iappsam.servlet.form.AddFormLineAction;
import com.iappsam.servlet.form.FormLineServlet;
import com.iappsam.servlet.form.ListItemsAction;
import com.iappsam.servlet.form.SearchItemAction;

public class PRLineServletTest extends ServletTestCase {

	private FormLineServlet servlet;
	@Mock
	private ItemSearcher itemSearcher;
	@Mock
	private SearchItemAction searchItem;
	@Mock
	private ListItemsAction listItems;
	@Mock
	private ItemManagerSession im;
	@Mock
	private AddFormLineAction addSelectedItemAction;
	@Mock
	private PR pr;

	@Override
	@Before
	public void init() {
		super.init();
		given(appContext.getItemManager()).willReturn(im);
		given(appContext.getItemSearcher()).willReturn(itemSearcher);
		servlet = new PRLineServlet(listItems, searchItem, addSelectedItemAction);
	}

	@Test
	public void listItems() throws ServletException, IOException {
		servlet.doGet(request, response);
		verify(listItems).process(request, response);
	}

	@Test
	public void processListItems() throws TransactionException, ServletException, IOException {
		// given all items
		ArrayList<Item> all = new ArrayList<Item>();
		given(im.getAllItems()).willReturn(all);

		given(session.getAttribute("form")).willReturn(pr);

		givenRequestDispatcher(PRLineServlet.LIST_ITEMS_JSP);

		new ListItemsAction("pr", appContext).process(request, response);

		verify(request).setAttribute("items", all);
		verifyForwardedTo(PRLineServlet.LIST_ITEMS_JSP);
	}

	@Test
	public void shouldNotListSelectedItems() throws TransactionException, ServletException, IOException {

		// given all items
		ArrayList<Item> all = new ArrayList<Item>();
		Item item = new Item();
		item.setId(1);
		all.add(item);
		given(im.getAllItems()).willReturn(all);

		given(session.getAttribute("form")).willReturn(pr);

		// given items included in the form
		ArrayList<Item> selected = new ArrayList<Item>();
		Item e = new Item();
		e.setId(1);
		selected.add(e);
		given(pr.getItems()).willReturn(selected);

		// given request dispatcher
		givenRequestDispatcher(PRLineServlet.LIST_ITEMS_JSP);

		new ListItemsAction("pr", appContext).process(request, response);

		ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
		verify(request).setAttribute(eq("items"), captor.capture());
		assertEquals(0, captor.getValue().size());

		verifyForwardedTo(PRLineServlet.LIST_ITEMS_JSP);
	}

	@Test
	public void searchItem() throws ServletException, IOException {
		givenParam("q", "search");
		servlet.doGet(request, response);
		verify(searchItem).process(request, response);
	}

	@Test
	public void processSearchItem() throws ServletException, IOException {
		givenParam("q", "item");

		// given result from searching item
		ArrayList<Item> res = new ArrayList<Item>();
		given(itemSearcher.search("item")).willReturn(res);
		givenRequestDispatcher(PRLineServlet.LIST_ITEMS_JSP);

		given(session.getAttribute("form")).willReturn(pr);

		new SearchItemAction("pr", appContext).process(request, response);

		verify(request).setAttribute("items", res);
		verifyForwardedTo(PRLineServlet.LIST_ITEMS_JSP);
	}

	@Test
	public void addSelectedItemAction() throws ServletException, IOException {
		givenParam("add", "items");
		servlet.doPost(request, response);
		verify(addSelectedItemAction).process(request, response);
	}

	@Test
	public void processAddSelectedItem() throws ServletException, IOException, TransactionException {
		givenParam("add", "items");
		String[] itemIds = new String[] { "1", "2" };
		givenParams("itemIds", itemIds);
		given(session.getAttribute("form")).willReturn(pr);

		// given item id = 1
		Item item1 = new Item();
		item1.setId(1);
		given(im.getItem(1)).willReturn(item1);

		// given item id = 2
		Item item2 = new Item();
		item2.setId(2);
		given(im.getItem(2)).willReturn(item2);

		new AddFormLineAction("pr", appContext).process(request, response);

		verify(pr, atLeastOnce()).addItem(eq(item1));
		verify(pr, atLeastOnce()).addItem(eq(item2));
		verify(response).sendRedirect("/pr?new=pr");
	}

}
