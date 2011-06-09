package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;

public class EmptyAction implements Action {

	public static final Action INSTANCE = new EmptyAction();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
