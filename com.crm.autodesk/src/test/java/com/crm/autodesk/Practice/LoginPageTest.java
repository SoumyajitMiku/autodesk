package com.crm.autodesk.Practice;

import org.testng.annotations.Test;

public class LoginPageTest {
	@Test
	public void login() {
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("username"));
		System.out.println(System.getProperty("password"));
	}
}
