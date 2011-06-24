package com.iappsam.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Cleaner {

	public static void clean(HttpServletRequest request) {

		// remove attribs except for username

		@SuppressWarnings("rawtypes")
		Enumeration attributeNames = request.getSession().getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String sAttribute = attributeNames.nextElement().toString();
			if (!sAttribute.equalsIgnoreCase("username")) {
				if (!sAttribute.equalsIgnoreCase("loginContext"))
					request.getSession().removeAttribute(sAttribute);
			}
		}
	}

//	public static void removeAttribute(HttpServletRequest request, String attrib) {
//
//		@SuppressWarnings("rawtypes")
//		Enumeration attributeNames = request.getSession().getAttributeNames();
//		while (attributeNames.hasMoreElements()) {
//			String sAttribute = attributeNames.nextElement().toString();
//			if (sAttribute.equalsIgnoreCase(attrib)) {
//				request.getSession().removeAttribute(attrib);
//			}
//		}
//	}

}
