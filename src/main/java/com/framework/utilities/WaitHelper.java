package com.framework.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class WaitHelper {
	
	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	public WaitHelper(WebDriver driver, Duration timeout, Duration pollingInterval) {
		this.driver = driver;
		this.wait = new FluentWait<>(driver)
				.withTimeout(timeout)
				.pollingEvery(pollingInterval)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotInteractableException.class);
	}

	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(driver -> {
			WebElement element = driver.findElement(locator);
			if (element.isDisplayed() && element.isEnabled()) {
				return element;
			}
			return null;
		});
	}
	
	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(driver -> {
			WebElement element = driver.findElement(locator);
			if (element.isDisplayed()) {
				return element;
			}
			return null;
		});
	}
	
	public WebElement waitForElementToBePresent(By locator) {
		return wait.until(driver -> driver.findElement(locator));
	}
	
	public WebElement waitforelementtobeenabled(By locator) {
		return wait.until(driver -> {
			WebElement element = driver.findElement(locator);
			if (element.isEnabled()) {
				return element;
			}
			return null;
		});
	}

	public void waitForPageToLoad() {
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}

}
