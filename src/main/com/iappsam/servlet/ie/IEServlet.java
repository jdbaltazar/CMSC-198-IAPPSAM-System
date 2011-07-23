package com.iappsam.servlet.ie;

import com.iappsam.servlet.form.FormServlet;
import com.iappsam.servlet.form.FormUtility;

public class IEServlet extends FormServlet {

	public IEServlet() {
		super(new IEUtility());
	}
}
