package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.servlet.item.ServletTestCase;
import static org.mockito.BDDMockito.*;

public class PurchaseRequestServletTest extends ServletTestCase {

	private PurchaseRequestServlet prServlet;

	@Before
	public void init() {
		prServlet = new PurchaseRequestServlet();
	}

	@Test
	public void newPr() throws ServletException, IOException {
		givenParam(PurchaseRequestParam.NEW, "pr");
		givenRequestDispatcher(PurchaseRequestServlet.NEW_PR_JSP, dispatcher);

		prServlet.doGet(request, response);

		verifyForwardedTo(PurchaseRequestServlet.NEW_PR_JSP);
	}

	@Test
	public void addItem() throws ServletException, IOException {
		givenParam(PurchaseRequestParam.ADD, "item");
		givenRequestDispatcher(PurchaseRequestServlet.ADD_ITEM_JSP, dispatcher);

		prServlet.doGet(request, response);

		verifyForwardedTo(PurchaseRequestServlet.ADD_ITEM_JSP);
	}
}
