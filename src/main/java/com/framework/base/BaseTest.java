package com.framework.base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.drivers.DriverFactory;
import com.framework.utilities.ConfigReader;

public class BaseTest {

    protected Properties prop;

    @BeforeMethod(alwaysRun = true)

    public void setup() {

        // Load Config

        prop = ConfigReader.initProperties();

        // Initialize Browser

        DriverFactory.initDriver();

        // Launch Application

        DriverFactory.getDriver()
                .get(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)

    public void tearDown() {

        DriverFactory.quitDriver();
    }
}