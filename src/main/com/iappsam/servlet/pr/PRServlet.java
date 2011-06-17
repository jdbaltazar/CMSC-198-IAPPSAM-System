package com.iappsam.servlet.pr;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.AddFormAction;
import com.iappsam.servlet.form.FormLinePageAction;
import com.iappsam.servlet.form.FormServlet;
import com.iappsam.servlet.form.ListFormAction;
import com.iappsam.servlet.form.NewFormPageAction;
import com.iappsam.servlet.form.RemoveFormLineAction;
import com.iappsam.servlet.form.ViewFormAction;
import com.iappsam.util.ApplicationContext;

@WebServlet("/pr")
public class PRServlet extends FormServlet {

	private static final long serialVersionUID = 1617728781320146937L;
	public static final String NEW_PR_JSP = "/pr/new-pr.jsp";
	public static final String ADD_ITEM_JSP = "/pr/line/add-item.jsp";
	public static final String LIST_PR_JSP = null;
	public static final String VIEW_PR_JSP = "/pr/view-pr.jsp";

	public PRServlet() {
		super(new ListPRAction(ApplicationContext.INSTANCE), //
				new AddPRAction(ApplicationContext.INSTANCE, new PRParser()), //
				new NewPRPageAction(ApplicationContext.INSTANCE), //
				new PRLinePageAction(ApplicationContext.INSTANCE, new PRParser()), //
				new RemovePRLineAction(ApplicationContext.INSTANCE, new PRParser()),//
				new ViewPRAction(ApplicationContext.INSTANCE));
	}

	public PRServlet(ListFormAction list, AddFormAction addPr, NewFormPageAction newPr, FormLinePageAction addItem, RemoveFormLineAction removeItem,
			ViewFormAction viewPr) {
		super(list, addPr, newPr, addItem, removeItem, viewPr);
	}
}
