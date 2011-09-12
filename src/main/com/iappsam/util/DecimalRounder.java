package com.iappsam.util;

import java.math.BigDecimal;

public class DecimalRounder {

	public static float roundOff(float input, int decimalPlaces) {

		BigDecimal bdTest = new BigDecimal(input);
		bdTest = bdTest.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		return bdTest.floatValue();

	}

}
