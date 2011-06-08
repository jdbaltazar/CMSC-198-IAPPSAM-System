package com.iappsam.servlet.item;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServletTestCase {

	@Mock
	protected HttpServletRequest request;
	@Mock
	protected HttpServletResponse response;
	@Mock
	protected RequestDispatcher dispatcher;

	public ServletTestCase() {
		super();

	}

	protected void verifyForwardedTo(String jsp) throws ServletException, IOException {
		verify(request).getRequestDispatcher(jsp);
		verify(dispatcher).forward(request, response);
	}

	protected void givenParam(String param, String value) {
		when(request.getParameter(param)).thenReturn(value);
	}

	protected void givenRequestDispatcher(String jsp, RequestDispatcher dispatcher) {
		when(request.getRequestDispatcher(jsp)).thenReturn(dispatcher);
	}

}