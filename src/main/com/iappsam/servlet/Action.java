package com.iappsam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;

public interface Action {

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
