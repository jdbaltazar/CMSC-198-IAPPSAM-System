package com.iappsam.servlet.ris;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormLineServlet;

@WebServlet("/ris/line")
public class RISLineServlet extends FormLineServlet {
	private static final long serialVersionUID = 8716375873087507696L;

	public RISLineServlet() {
		super(new RISUtility());
	}
}
