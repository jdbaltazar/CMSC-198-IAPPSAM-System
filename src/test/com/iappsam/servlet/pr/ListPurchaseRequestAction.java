package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class ListPurchaseRequestAction implements Action {

	private PRManager prm;

	public ListPurchaseRequestAction(PRManager prm) {
		super();
		this.prm = prm;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("PRs", prm.getAllPR());
			request.getRequestDispatcher(PurchaseRequestServlet.LIST_PR_JSP).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
