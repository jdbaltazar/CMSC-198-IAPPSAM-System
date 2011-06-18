package com.iappsam.servlet.po;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormServlet;

@WebServlet("/po")
public class POServlet extends FormServlet {

	private static final long serialVersionUID = 8519651752354049418L;

	public POServlet() {
		super(new POUtility());
	}
}
