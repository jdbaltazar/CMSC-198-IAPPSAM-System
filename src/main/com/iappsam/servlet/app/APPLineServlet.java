package com.iappsam.servlet.app;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormLineServlet;

@WebServlet("/app/line")
public class APPLineServlet extends FormLineServlet {

	private static final long serialVersionUID = -2839740062941296728L;

	public APPLineServlet() {
		super(new APPUtility());
	}
}
