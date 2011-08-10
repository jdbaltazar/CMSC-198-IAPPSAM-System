package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = -5790141818408223780L;

	private NewFormPageAction newPage;
	private FormLinePageAction linePage;
	private ListFormAction list;
	private RemoveFormLineAction removeItem;
	private AddFormAction addForm;
	private ViewFormAction viewForm;
	private ExportPdfAction exportPdf;
	private ExportXlsAction exportXls;

	public FormServlet(FormUtility utility) {
		this.list = new ListFormAction(utility);
		this.newPage = new NewFormPageAction(utility);
		this.linePage = new FormLinePageAction(utility);
		this.removeItem = new RemoveFormLineAction(utility);
		this.addForm = new AddFormAction(utility);
		this.viewForm = new ViewFormAction(utility);
		this.exportPdf = new ExportPdfAction(utility);
		this.exportXls = new ExportXlsAction(utility);
	}

	public FormServlet(NewFormPageAction newPr, FormLinePageAction linePage, ListFormAction list, RemoveFormLineAction removeItem,
			AddFormAction addPr, ViewFormAction viewPr, ExportPdfAction exportPdf, ExportXlsAction exportXls) {
		super();
		this.newPage = newPr;
		this.linePage = linePage;
		this.list = list;
		this.removeItem = removeItem;
		this.addForm = addPr;
		this.viewForm = viewPr;
		this.exportPdf = exportPdf;
		this.exportXls = exportXls;
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

		if (newParam != null) {
			return newPage;
		} else if (addItemParam != null)
			return linePage;
		else if (removeItemParam != null)
			return removeItem;
		else if (savePrParam != null)
			return addForm;
		else if (idParam != null)
			return viewForm;
		else if (exportParam != null && exportParam.equals("pdf"))
			return exportPdf;
		else if (exportParam != null && exportParam.equals("xls"))
			return exportXls;

		return list;
	}
}