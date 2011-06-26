package com.iappsam.servlet.po;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormLineServlet;

@WebServlet("/po/line")
public class POLineServlet extends FormLineServlet {

	private static final long serialVersionUID = 458044750873603134L;

	public POLineServlet() {
		super(new POUtility());
	}
}
