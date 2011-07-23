package com.iappsam.servlet.ie;

import com.iappsam.servlet.form.FormLineServlet;
import com.iappsam.servlet.form.FormUtility;

public class IELineServlet extends FormLineServlet{

	public IELineServlet() {
		super(new IEUtility());
	}
}
