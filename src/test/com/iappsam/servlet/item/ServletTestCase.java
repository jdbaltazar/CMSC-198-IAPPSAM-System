package com.iappsam.servlet.item;

import static org.mockito.BDDMockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	@Mock
	protected HttpSession session;

	public ServletTestCase() {
		super();
	}

	public void init() {
		given(request.getSession()).willReturn(session);
	}

	protected void verifyForwardedTo(String jsp) throws ServletException, IOException {
		verify(request).getRequestDispatcher(jsp);
		verify(dispatcher).forward(request, response);
	}

	protected void givenParam(String param, String value) {
		when(request.getParameter(param)).thenReturn(value);
	}

	protected void givenRequestDispatcher(String jsp) {
		when(request.getRequestDispatcher(jsp)).thenReturn(dispatcher);
	}

	protected void givenSessionAttrib(String name, Object value) {
		given(session.getAttribute(name)).willReturn(value);
	}

	protected void verifySessionAttrib(String string, Object value) {
		session.setAttribute("itemIds", value);
	}

	protected void givenParams(String string, String[] strings) {
		given(request.getParameterValues(string)).willReturn(strings);
	}
}