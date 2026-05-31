package com.framework.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import com.framework.drivers.DriverFactory;

public class Hooks {

    @Before
    public void beforeScenario() {
        System.out.println("[HOOK] Before scenario: setup test data / start driver");
        // Initialize WebDriver for scenarios (DriverFactory reads headless from config)
        try {
            DriverFactory.initDriver();
        } catch (Exception e) {
            // If driver cannot start (e.g., Safari on CI), log and continue for non-browser tests
            System.out.println("[HOOK] Warning: failed to start WebDriver: " + e.getMessage());
        }
    }

    @After
    public void afterScenario() {
        System.out.println("[HOOK] After scenario: cleanup / take screenshot on failure");
        try {
            DriverFactory.quitDriver();
        } catch (Exception e) {
            System.out.println("[HOOK] Warning: failed to quit WebDriver: " + e.getMessage());
        }
    }
}