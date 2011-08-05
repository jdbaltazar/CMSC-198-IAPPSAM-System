package com.iappsam.servlet.ie;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormServlet;

@WebServlet("/ie")
public class IEServlet extends FormServlet {

	public IEServlet() {
		super(new IEUtility());
	}
}
