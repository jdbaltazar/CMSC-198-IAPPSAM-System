package com.iappsam.servlet.ris;

import javax.servlet.annotation.WebServlet;

import com.iappsam.servlet.form.FormServlet;

@WebServlet("/ris")
public class RISServlet extends FormServlet {

	public RISServlet() {
		super(new RISUtility());
	}

}
