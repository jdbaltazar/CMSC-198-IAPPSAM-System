package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.forms.APPLine;

public class APPLineTest {

	@Test
	public void sameAppLine() {
		APPLine line = new APPLine();
		line.setId(1);

		APPLine line2 = new APPLine();
		line2.setId(1);

		assertEquals(line, line2);
	}
}
