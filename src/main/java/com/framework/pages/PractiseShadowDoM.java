package com.framework.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.drivers.DriverFactory;


public class PractiseShadowDoM {
	
	
    private final WebDriverWait wait;
    private final WebDriver driver;
	
	 // Constructor wires driver and wait
        public PractiseShadowDoM() {
        this.driver = DriverFactory.getDriver();
		
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        
       public void interactWithShadowDom() {
    	   driver.get("https://practice.expandtesting.com/shadowdom");
    	   driver.manage().window().maximize();
		   // Example of interacting with a shadow DOM element
		   // Replace the locator with the actual shadow host and shadow element locators
    	    String jspath = "return document.querySelector('#shadow-host').shadowRoot.querySelector('#my-btn')";
    	    
    	    JavascriptExecutor jse = (JavascriptExecutor)driver;
    	    WebElement shadowButton = (WebElement) jse.executeScript(jspath);
    	    
    	    scrollIntoView(shadowButton);
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(shadowButton));
    	    
    	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", shadowButton);
    	    
    	    System.out.println("Clicked the button inside shadow DOM");
    	   
		   
	   }

	   private void scrollIntoView(WebElement shadowButton) {
		// TODO Auto-generated method stub
		 
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", shadowButton);
		   
	   }
        


}