package com.iappsam.servlet;

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

import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.util.ApplicationContext;

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
	@Mock
	protected ApplicationContext appContext;
	@Mock
	protected PersonManager pm;
	@Mock
	protected PRManager prm;
	@Mock
	protected DivisionOfficeManager dom;
	@Mock
	protected ItemManager im;
	@Mock
	protected APPManager appm;
	@Mock
	protected POManager pom;

	public ServletTestCase() {
		super();
	}

	public void init() {
		given(request.getSession()).willReturn(session);
		given(appContext.getItemManager()).willReturn(im);
		given(appContext.getPRManager()).willReturn(prm);
		given(appContext.getDivisionOfficeManager()).willReturn(dom);
		given(appContext.getPersonManager()).willReturn(pm);
		given(appContext.getAPPManager()).willReturn(appm);
		given(appContext.getPOManager()).willReturn(pom);
	}

	protected void verifyForwardedTo(String jsp) throws ServletException, IOException {
		verify(request).getRequestDispatcher(eq(jsp));
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