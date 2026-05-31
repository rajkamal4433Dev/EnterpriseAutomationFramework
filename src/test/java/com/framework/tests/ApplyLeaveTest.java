package com.framework.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.LeavesPage;

public class ApplyLeaveTest extends BaseTest {
	
	@Test(priority = 2, description = "Test to apply for leave")
	public void applyLeaveTest() {	
		// Test steps to apply for leave would go here
		// This is a placeholder for the actual test implementation
		LoginTest loginTest = new LoginTest();
		loginTest.verifyLoginPageTitle();
		
		System.out.println("Applying for leave...");
		
		LeavesPage leavesPage2 = new LeavesPage();
		leavesPage2.applyLeave("2024-07-01", "2024-07-05", "Breavement", "Family Emergency");
		
		System.out.println("Leave application submitted successfully.");
		
	}
	
	
	
	

}
