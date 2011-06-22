package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;

public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = -5790141818408223780L;

	private NewFormPageAction newPr;
	private FormLinePageAction linePage;
	private ListFormAction list;
	private RemoveFormLineAction removeItem;
	private AddFormAction addPr;
	private ViewFormAction viewPr;
	private ExportPdfAction exportPdf;

	public FormServlet(FormUtility utility) {
		this.list = new ListFormAction(utility);
		this.newPr = new NewFormPageAction(utility);
		this.linePage = new FormLinePageAction(utility);
		this.removeItem = new RemoveFormLineAction(utility);
		this.addPr = new AddFormAction(utility);
		this.viewPr = new ViewFormAction(utility);
		this.exportPdf = new ExportPdfAction(utility);
	}

	public FormServlet(NewFormPageAction newPr, FormLinePageAction linePage, ListFormAction list, RemoveFormLineAction removeItem, AddFormAction addPr, ViewFormAction viewPr, ExportPdfAction exportPdf) {
		super();
		this.newPr = newPr;
		this.linePage = linePage;
		this.list = list;
		this.removeItem = removeItem;
		this.addPr = addPr;
		this.viewPr = viewPr;
		this.exportPdf = exportPdf;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		parseAction(req).process(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		parseAction(req).process(req, res);
	}

	private Action parseAction(HttpServletRequest req) {

		String newParam = req.getParameter("new");
		String addItemParam = req.getParameter("addItems");
		String removeItemParam = req.getParameter("removeItems");
		String savePrParam = req.getParameter("saveForm");
		String idParam = req.getParameter("id");
		String exportParam = req.getParameter("export");

		if (newParam != null)
			return newPr;
		else if (addItemParam != null)
			return linePage;
		else if (removeItemParam != null)
			return removeItem;
		else if (savePrParam != null)
			return addPr;
		else if (idParam != null)
			return viewPr;
		else if (exportParam != null && exportParam.equals("pdf"))
			return exportPdf;

		return list;
	}
}