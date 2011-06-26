package com.iappsam.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;

public interface Request {
	
	void process(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException, TransactionException;

}
