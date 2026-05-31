package com.framework.tests;



import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.drivers.DriverFactory;
import com.framework.pages.LoginPage;
import com.framework.utilities.ConfigReader;

public class LoginTest extends BaseTest {
	
	protected String username;
	protected String password;	
	protected Properties prop;
	
	@DataProvider(name = "loginData")
		public Object[][] loginDataProvider() {
		return new Object[][] {
			{"validUser", "validPass"},
			{"invalidUser", "invalidPass"},
			{"", ""},
			{"validUser", ""},
			{"", "validPass"}
		};
	}
	
	
	

    @Test(priority = 1, description = "Verify Login Page Title and perform login")

    public void verifyLoginPageTitle() {
    	
    	 // Initialize test config here (cannot have bare statements at class scope)
        this.prop = ConfigReader.initProperties();
        this.username = prop.getProperty("username");
        this.password = prop.getProperty("password");

        // Get Page Title

        String title =
                DriverFactory.getDriver()
                        .getTitle();

        System.out.println("Page Title Is: "
                + title);
        
        // Enter Details and Login
        
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(username)
				 .enterPassword(password)
				 .clickSignIn();
        
        

        // Validation

        Assert.assertTrue(
                title.contains("OrangeHRM"),
                "Title Validation Failed");
    }
    
    @Test(dataProvider = "loginData", priority = 2, description = "Verify login with invalid credentials")
    public void verifyLoginWithInvalidCredentials(String testUsername, String testPassword) {
    	
    	// Attempt login with invalid credentials
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(testUsername)
				 .enterPassword(testPassword)
				 .clickSignIn();

    	
    
    }
}