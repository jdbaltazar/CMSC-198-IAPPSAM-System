package com.iappsam.servlet.item;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class SaveItemTest {

	@Test
	public void parseDateFromValid() {

		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("year")).thenReturn("2000");
		when(request.getParameter("month")).thenReturn("01");
		when(request.getParameter("day")).thenReturn("01");

		SaveItem.parseDateFrom(request);
	}
}
