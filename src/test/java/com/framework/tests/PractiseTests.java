package com.framework.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.PractiseShadowDoM;

public class PractiseTests extends BaseTest {
	
	@Test(priority = 1, description = "Test to apply for leave")
	public void applyLeaveTest() {
		
		PractiseShadowDoM practiseShadowDoM = new PractiseShadowDoM();
		practiseShadowDoM.interactWithShadowDom();
		
		
		
	}

}