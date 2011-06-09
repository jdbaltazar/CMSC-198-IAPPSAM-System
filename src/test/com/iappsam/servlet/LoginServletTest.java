package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.LoginModule;
import com.iappsam.servlet.item.ServletTestCase;

import static org.mockito.BDDMockito.*;

public class LoginServletTest extends ServletTestCase {

	@Mock
	private HttpSession session;
	@Mock
	private LoginModule loginModule;

	private LoginServlet loginServlet;

	@Before
	public void init() {
		loginServlet = new LoginServlet(loginModule);
	}

	@Test
	public void login() throws ServletException, IOException {

		givenRequestDispatcher("menu.jsp", dispatcher);
		givenParam(LoginServlet.USERNAME, "admin");
		givenParam(LoginServlet.PASSWORD, "admin");
		given(loginModule.login("admin", "admin")).willReturn(true);
		given(request.getSession()).willReturn(session);

		loginServlet.doPost(request, response);

		verifyForwardedTo("menu.jsp");
	}
}
