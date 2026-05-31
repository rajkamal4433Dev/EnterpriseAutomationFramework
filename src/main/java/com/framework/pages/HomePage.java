package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.drivers.DriverFactory;


public class HomePage {
	
	 private final WebDriver driver;
	    private final WebDriverWait wait;

	    // Locators (placeholders - update to real values)
	    private final By AdminLink = By.xpath("//a[contains(.,'Admin')]");
	    private final By PIMLink = By.xpath("//a[contains(.,'PIM')]");
	    
	    // Constructor wires driver and wait
	    public HomePage() {
	        this.driver = DriverFactory.getDriver();
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	        
	        public void clickLink(String linkName) {
	        	if(linkName.equalsIgnoreCase("Admin")) {
	        		wait.until(ExpectedConditions.elementToBeClickable(AdminLink)).click();
	        	} else if(linkName.equalsIgnoreCase("PIM")) {
	        		wait.until(ExpectedConditions.elementToBeClickable(PIMLink)).click();
	        	} else {
	        		System.out.println("Invalid link name: " + linkName);
	        	}
	    		wait.until(ExpectedConditions.elementToBeClickable(AdminLink)).click();;
	    


}}
