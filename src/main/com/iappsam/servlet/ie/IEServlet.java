package com.iappsam.servlet.ie;

import com.iappsam.servlet.form.FormServlet;

public class IEServlet extends FormServlet {

	public IEServlet() {
		super(new IEUtility());
	}
}
