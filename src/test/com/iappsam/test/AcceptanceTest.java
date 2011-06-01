package com.iappsam.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

public class AcceptanceTest {

	private WebTester tester;

	@Before
	public void setup() throws Exception {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost:8080/CMSC-198-IAPPSAM-Sytem/");
	}

	@Test
	public void loginAdminAccount() {
		tester.beginAt("/login");
		assertIsInLoginPage();
		tryTologinWith("admin", "admin");
	}

	@After
	public void logout() {
		tester.assertFormPresent("logout");
		tester.setWorkingForm("logout");
		tester.submit();
		assertIsInLoginPage();
	}

	private void assertIsInLoginPage() {
		tester.assertTitleEquals("IAPPSAM :: Login");
		tester.assertTextPresent("Username");
		tester.assertTextPresent("Password");
	}

	private void tryTologinWith(String username, String password) {
		tester.setTextField("username", username);
		tester.setTextField("password", password);
		tester.submit();
		tester.assertTextPresent("Welcome, " + username + "!");
	}

}
