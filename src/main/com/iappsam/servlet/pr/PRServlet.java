package com.iappsam.servlet.pr;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormServlet;

@WebServlet("/pr")
public class PRServlet extends FormServlet {

	private static final long serialVersionUID = 1617728781320146937L;

	public PRServlet() {
		super(new PRUtility());
	}
}
