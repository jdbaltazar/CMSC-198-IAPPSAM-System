package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
