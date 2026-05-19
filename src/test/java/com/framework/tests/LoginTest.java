package com.framework.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.drivers.DriverFactory;

public class LoginTest extends BaseTest {

    @Test

    public void verifyLoginPageTitle() {

        // Get Page Title

        String title =
                DriverFactory.getDriver()
                        .getTitle();

        System.out.println("Page Title Is: "
                + title);

        // Validation

        Assert.assertTrue(
                title.contains("OrangeHRM"),
                "Title Validation Failed");
    }
}