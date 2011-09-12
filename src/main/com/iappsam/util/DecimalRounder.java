package com.iappsam.util;

import java.math.BigDecimal;

public class DecimalRounder {

	public static float roundOff(double input, int decimalPlaces) {

		float floatInput = Float.parseFloat(Double.toString(input));
		BigDecimal bdTest = new BigDecimal(floatInput);
		bdTest = bdTest.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		return bdTest.floatValue();
	}
}
