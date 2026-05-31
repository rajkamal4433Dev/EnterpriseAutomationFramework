package com.framework.base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.drivers.DriverFactory;
import com.framework.utilities.ConfigReader;

/**
 * Test base that initializes and quits the WebDriver for TestNG tests.
 */
public class BaseTest {

    protected Properties prop;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        // Load properties for the environment (qa by default)
        prop = ConfigReader.initProperties();

        // Initialize browser driver (DriverFactory uses 'headless' and 'browser' props)
        DriverFactory.initDriver();

        // Navigate to base URL
        String url = prop.getProperty("url");
        if (url != null && !url.isEmpty()) {
            DriverFactory.getDriver().get(url);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Quit the driver after each test
        DriverFactory.quitDriver();
    }
}
