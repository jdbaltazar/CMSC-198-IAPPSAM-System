package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class LoginTest {
	@Test
	public void doPostSucessful() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);
		when(session.isNew()).thenReturn(true);

		when(request.getParameter(Login.USERNAME)).thenReturn("root");
		when(request.getParameter(Login.PASSWORD)).thenReturn("123456");
		when(request.getRequestDispatcher("/MenuFrame.jsp")).thenReturn(dispatcher);
		when(request.getSession()).thenReturn(session);

		Login login = new Login();
		login.doPost(request, response);

		verify(dispatcher, times(1)).forward(request, response);
	}
}
