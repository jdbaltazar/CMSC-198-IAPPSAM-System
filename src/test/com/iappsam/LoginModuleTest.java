package com.iappsam;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginModuleTest {

	@Test
	public void login() {
		LoginModule module = new LoginModule();
		assertTrue(module.login("admin", "admin"));
	}
}
