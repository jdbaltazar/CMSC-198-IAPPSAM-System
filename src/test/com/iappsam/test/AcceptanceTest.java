package com.iappsam.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

public class AcceptanceTest {

	private WebTester tester;

	@Before
	public void setup() throws Exception {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost/");

		tester.beginAt("/login");
		assertIsInLoginPage();
		tryTologinWith("admin", "admin");
	}

	@Test
	public void navigateToItemPage() {
		clickItemLink();
		tester.assertTitleEquals("IAPPSAM :: Items");
	}

	@Test
	public void navigateToAddItemPage() {
		clickItemLink();
		clickAddItemLink();
		tester.assertTitleEquals("IAPPSAM :: Add Item");
	}

	@Test
	public void clickBackInAddItemPage() {
		clickItemLink();
		clickAddItemLink();

		tester.assertLinkPresent("back");
		tester.clickLink("back");
		tester.assertTitleEquals("IAPPSAM :: Items");
	}

	@Ignore
	@Test
	public void backToMenuFromItemList() {
		clickItemLink();
	}

	@After
	public void logout() {
		tester.assertFormPresent("logout");
		tester.setWorkingForm("logout");
		tester.submit();
		assertIsInLoginPage();
	}

	private void clickAddItemLink() {
		tester.assertLinkPresentWithExactText("Add Item >>");
		tester.clickLinkWithText("Add Item >>");
	}

	private void assertIsInLoginPage() {
		tester.assertTitleEquals("IAPPSAM :: Login");
		tester.assertTextPresent("Username");
		tester.assertTextPresent("Password");
	}

	private void clickItemLink() {
		tester.assertLinkPresent("view-items");
		tester.clickLink("view-items");
	}

	private void tryTologinWith(String username, String password) {
		tester.setTextField("username", username);
		tester.setTextField("password", password);
		tester.submit();
		tester.assertTextPresent("Welcome, " + username + "!");
	}

}
