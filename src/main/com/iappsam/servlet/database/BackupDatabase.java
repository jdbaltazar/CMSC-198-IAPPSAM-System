package com.iappsam.servlet.database;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.text.DateFormat;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/database/backup.do")
public class BackupDatabase extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String filePath = "C:\\Users\\JDB\\workspace\\CMSC-198-IAPPSAM-Sytem\\";
		String fileName = "File.sql";
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;

		try {

			stream = response.getOutputStream();
			File file = new File(filePath + fileName);

			// set response headers
			response.setContentType("text/sql");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.setContentLength((int) file.length());

			FileInputStream input = new FileInputStream(file);
			buf = new BufferedInputStream(input);
			int readBytes = 0;

			while ((readBytes = buf.read()) != -1)
				stream.write(readBytes);

		} catch (IOException ioe) {

			throw new ServletException(ioe.getMessage());

		} finally {

			if (stream != null)
				stream.close();
			if (buf != null)
				buf.close();
		}
	}
}
