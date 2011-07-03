package com.iappsam.servlet.ris;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormServlet;

@WebServlet("/ris")
public class RISServlet extends FormServlet {

	private static final long serialVersionUID = -1524592875815519169L;

	public RISServlet() {
		super(new RISUtility());
	}
}
