package com.framework.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.drivers.DriverFactory;


/**
 * Page object template for Leaves page.
 *
 * - Replace locator values with the actual application's locators.
 * - Use the provided helper methods from this class to interact with the page.
 */
public class LoginPage  {
	
	

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators (placeholders - update to real values)
    private final By Username = By.xpath("//input[@name='username']");
    private final By Password = By.xpath("//input[@name='password']");
    private final By SignIn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    
    // Constructor wires driver and wait
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      
       
    }
    
    public LoginPage enterUsername(String username) {
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
		el.clear();
		el.sendKeys(username);
		return this;
	}
    
    public LoginPage enterPassword(String password) {
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		el.clear();
		el.sendKeys(password);
		return this;
	}
	
	public void clickSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(SignIn)).click();
	}
	
}