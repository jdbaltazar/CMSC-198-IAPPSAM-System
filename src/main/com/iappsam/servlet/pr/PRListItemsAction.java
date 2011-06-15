/**
 * 
 */
package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

/**
 * @author JK
 * 
 */
public class PRListItemsAction implements Action {

	private ItemManager im;

	public PRListItemsAction(ItemManager im) {
		this.im = im;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Item> items = im.getAllItems();
			Form form = (Form) request.getSession().getAttribute("form");
			items.removeAll(form.getItems());
			request.setAttribute("items", items);
			request.getRequestDispatcher(PRLineServlet.LIST_ITEMS).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
