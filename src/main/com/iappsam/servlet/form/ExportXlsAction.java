package com.iappsam.servlet.form;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.item.Action;

public class ExportXlsAction implements Action {

	private FormUtility utility;

	public ExportXlsAction(FormUtility utility) {
		this.utility = utility;
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			File pdf = utility.getXls((Form) req.getSession().getAttribute("form"));

			ServletOutputStream stream = res.getOutputStream();
			res.setContentType("application/vnd.ms-excel");
			res.setContentLength((int) pdf.length());

			FileInputStream input = new FileInputStream(pdf);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;

			while ((readBytes = buf.read()) != -1)
				stream.write(readBytes);

			buf.close();
			stream.close();
		} catch (ReportException e) {
			e.printStackTrace();
		}
	}
}
