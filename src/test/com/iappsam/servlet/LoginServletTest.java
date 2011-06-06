package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class LoginServletTest {

	@Test
	public void login() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getRequestDispatcher("menu.jsp")).thenReturn(dispatcher);
		when(request.getParameter(LoginServlet.USERNAME)).thenReturn("admin");
		when(request.getParameter(LoginServlet.PASSWORD)).thenReturn("admin");
		when(request.getSession()).thenReturn(session);

		LoginServlet controller = new LoginServlet();
		controller.doPost(request, null);

		verify(request.getRequestDispatcher("menu.jsp"));
	}
}
