package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServletTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private RequestDispatcher dispatcher;

	@Test
	public void listItems() throws ServletException, IOException {

		when(request.getParameter("view")).thenReturn("items");
		when(request.getRequestDispatcher(ItemServlet.SEARCH_ITEMS_JSP)).thenReturn(dispatcher);

		ItemServlet servlet = new ItemServlet();
		servlet.doGet(request, response);

		verify(dispatcher).forward(request, response);
	}
}
