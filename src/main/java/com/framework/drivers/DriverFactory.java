package com.framework.drivers;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.framework.utilities.ConfigReader;

public class DriverFactory {

    // ThreadLocal for Parallel Execution

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private static Properties prop;

    // Initialize Driver

    public static void initDriver() {

        prop = ConfigReader.initProperties();

        String browser =
                prop.getProperty("browser");

        // CHROME

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments(
                    "--remote-allow-origins=*");

            if (prop.getProperty("headless")
                    .equalsIgnoreCase("true")) {

                options.addArguments("--headless=new");
            }

            driver.set(
                    new ChromeDriver(options));
        }

        // FIREFOX

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options =
                    new FirefoxOptions();

            if (prop.getProperty("headless")
                    .equalsIgnoreCase("true")) {

                options.addArguments("--headless");
            }

            driver.set(
                    new FirefoxDriver(options));
        }

        // SAFARI

        else if (browser.equalsIgnoreCase("safari")) {

            driver.set(new SafariDriver());
        }

        else {

            throw new RuntimeException(
                    "Browser Not Supported: "
                            + browser);
        }

        // Maximize Window

        getDriver().manage()
                .window()
                .maximize();

        // Implicit Wait

        getDriver().manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(
                                Integer.parseInt(
                                        prop.getProperty(
                                                "implicitWait"))));
    }

    // Get Driver

    public static WebDriver getDriver() {

        return driver.get();
    }

    // Quit Driver

    public static void quitDriver() {

        if (driver.get() != null) {

            getDriver().quit();

            driver.remove();
        }
    }
}