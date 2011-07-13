package com.iappsam.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(filterName = "SecurityFilter", urlPatterns = { "/*" })
public class SecurityFilter implements Filter {

	public static final String HOME1 = "/";
	public static final String HOME2 = "/index";
	public static final String HOME3 = "/index.jsp";

	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		/*
		 * Tasks: handle redirect when nto logged in show menu when
		 */

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		Account account = null;
		String link = "";
		if (request instanceof HttpServletRequest) {
			
			account = (Account) httpReq.getSession().getAttribute("account");
			//username = (String) httpReq.getSession().getAttribute("username");
			link = httpReq.getRequestURI();
			//System.out.println("username: " + account.getUsername());
			//System.out.println("link: " + link);

			if (link.startsWith("/images") || link.startsWith("/css")) {
				chain.doFilter(request, response);
				return;
			}

			if (account == null) {
				if (link.equalsIgnoreCase(HOME1) || link.equalsIgnoreCase(HOME2) || link.equalsIgnoreCase(HOME3)) {
					chain.doFilter(request, response);
					return;
				}
				if (link.equalsIgnoreCase("/login")) {
					chain.doFilter(request, response);
					return;
				}

				if (link.startsWith("/")) {
					httpReq.getSession().setAttribute("from", httpReq.getRequestURI());
					httpResp.sendRedirect("/");
					return;
				} else {
					chain.doFilter(request, response);
					return;
				}
			} else {
				if (link.equalsIgnoreCase(HOME1) || link.equalsIgnoreCase(HOME2) || link.equalsIgnoreCase(HOME3)) {
					httpReq.getSession().setAttribute("from", httpReq.getRequestURI());
					httpResp.sendRedirect("/menu");
					return;
				} else {
					chain.doFilter(request, response);
				}
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
