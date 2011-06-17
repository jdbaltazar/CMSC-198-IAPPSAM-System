package com.iappsam.servlet.app;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormServlet;

@WebServlet("/app")
public class APPServlet extends FormServlet {

	private static final long serialVersionUID = 8057738440110323921L;

	public APPServlet() {
		super(new APPUtility());
	}
}
