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
public class LeavesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators (placeholders - update to real values)
    private final By leaveMenu = By.xpath("//a/span[contains(.,'Leave')]");
    private final By applyButton = By.xpath("//li/a[contains(.,'Apply')]");
    private final By fromDateInput = By.xpath("//div[contains(.,'From Date')][@class='oxd-input-group oxd-input-field-bottom-space']//../input");
    private final By toDateInput = By.xpath("//div[contains(.,'To Date')][@class='oxd-input-group oxd-input-field-bottom-space']//../input");
    private final By leaveTypeSelect = By.xpath("//div[contains(.,'Leave Type')][@class='oxd-input-group__label-wrapper']//following-sibling::div//../i");
    private final By commentTextArea = By.xpath("//div[contains(.,'Comments')][@class='oxd-input-group oxd-input-field-bottom-space']//../textarea");
    private final By submitButton = By.xpath("//button[contains(.,'Apply')]");
    private final By leaveTypeSelectValueBereavement = By.xpath("//div[@role='option']//../span[contains(.,'CAN - Bereavement')]");
    
  //div[contains(.,'CAN - Bereavement')][@tabindex]
    private final By successMessage = By.cssSelector(".message.success");

    // Constructor wires driver and wait
    public LeavesPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigation / page helpers
    public LeavesPage openLeavesModule() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
        return this;
    }

    public LeavesPage clickApply() {
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
        return this;
    }

    // Form actions
    public LeavesPage setFromDate(String date) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput));
        el.clear();
        el.sendKeys(date);
        return this;
    }

    public LeavesPage setToDate(String date) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(toDateInput));
        el.clear();
        el.sendKeys(date);
        return this;
    }

    public LeavesPage selectLeaveType(String typeText) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(leaveTypeSelect));
        el.click(); // Open dropdown
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(leaveTypeSelectValueBereavement)); // Update locator for dynamic selection if needed
        option.click(); // Select option - Berevement
        return this;
    }

    public LeavesPage enterComment(String comment) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextArea));
        el.clear();
        el.sendKeys(comment);
        return this;
    }

    public LeavesPage submitApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;
    }

    // Getters / assertions
    public String getSuccessMessageText() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveMenu)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Utility: build-and-submit convenience flow example
    public  LeavesPage applyLeave(String fromDate, String toDate, String leaveType, String comment) {
    	openLeavesModule();
    	clickApply();
        setFromDate(fromDate);
        setToDate(toDate);
        selectLeaveType(leaveType);
        enterComment(comment);
        submitApplication();
        return this;
    }

}