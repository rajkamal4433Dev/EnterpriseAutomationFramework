package com.framework.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.PractiseShadowDoM;

public class PractiseGITMovesTest extends BaseTest {
	
	@Test(priority = 1, description = "Test to apply for leave")
	public void applyLeaveTest() {
		
		PractiseShadowDoM practiseShadowDoM = new PractiseShadowDoM();
		practiseShadowDoM.interactWithShadowDom();
		
		System.out.println("This is the Practise Test by user 2");
		
		
		
	}

}