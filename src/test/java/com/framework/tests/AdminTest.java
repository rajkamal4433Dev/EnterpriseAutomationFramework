package com.framework.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.pages.LeavesPage;

public class AdminTest extends BaseTest {
	
	@Test(priority = 2, description = "Test to apply for leave")
	public void applyLeaveTest() {	
		// Test steps to apply for leave would go here
		// This is a placeholder for the actual test implementation
		LoginTest loginTest = new LoginTest();
		loginTest.verifyLoginPageTitle();
		
		System.out.println("Clicking on Admin Tab.");
		HomePage homePage = new HomePage();
		homePage.clickLink("Admin");

		
	}}