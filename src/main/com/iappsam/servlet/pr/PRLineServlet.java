package com.iappsam.servlet.pr;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormLineServlet;

@WebServlet("/pr/line")
public class PRLineServlet extends FormLineServlet {
	
	private static final long serialVersionUID = 1L;

	public PRLineServlet() {
		super(new PRUtility());
	}
}
