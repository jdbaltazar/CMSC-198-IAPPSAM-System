package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

	@Test
	public void login() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getRequestDispatcher("menu.jsp")).thenReturn(dispatcher);
		when(request.getParameter(LoginController.USERNAME)).thenReturn("admin");
		when(request.getParameter(LoginController.PASSWORD)).thenReturn("admin");
		when(request.getSession()).thenReturn(session);

		LoginController controller = new LoginController();
		controller.doPost(request, null);

		verify(request.getRequestDispatcher("menu.jsp"));
	}
}
