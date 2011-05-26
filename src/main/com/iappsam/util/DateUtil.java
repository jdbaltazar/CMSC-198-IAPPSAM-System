package com.iappsam.util;

import java.util.Date;

public class DateUtil {

	public static String getDayEquivalent(Date date) {
		return date.toString().substring(8, 10);
	}

	public static String getMonthEquivalent(Date date) {

		return date.toString().substring(5, 7);
	}

	public static String getMonthEquivalentInWords(Date date) {

		int i = Integer.parseInt(date.toString().substring(5, 7));

		switch (i) {

		case 1:
			return "Jan";
		case 2:
			return "Feb";
		case 3:
			return "Mar";
		case 4:
			return "Apr";
		case 5:
			return "May";
		case 6:
			return "Jun";
		case 7:
			return "Jul";
		case 8:
			return "Aug";
		case 9:
			return "Sep";
		case 10:
			return "Oct";
		case 11:
			return "Nov";
		case 12:
			return "Dec";
		default:
			return "MM";
		}
	}

	public static String getNumericMonthEquivalent(String s) {
		if (s.equalsIgnoreCase("Jan"))
			return "01";
		if (s.equalsIgnoreCase("Feb"))
			return "02";
		if (s.equalsIgnoreCase("Mar"))
			return "03";
		if (s.equalsIgnoreCase("Apr"))
			return "04";
		if (s.equalsIgnoreCase("May"))
			return "05";
		if (s.equalsIgnoreCase("Jun"))
			return "06";
		if (s.equalsIgnoreCase("Jul"))
			return "07";
		if (s.equalsIgnoreCase("Aug"))
			return "08";
		if (s.equalsIgnoreCase("Sep"))
			return "09";
		if (s.equalsIgnoreCase("Oct"))
			return "10";
		if (s.equalsIgnoreCase("Nov"))
			return "11";
		if (s.equalsIgnoreCase("Dec"))
			return "12";
		return "00";
	}

	public static String getYearEquivalent(Date date) {
		return date.toString().substring(0, 4);
	}

	public static Date converToDate(String yyyy, String mm, String dd) {
		Date date = java.sql.Date.valueOf(yyyy + "-" + mm + "-" + dd);
		return date;
	}
}
