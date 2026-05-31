package com.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties initProperties() {

        prop = new Properties();

        String env =
                System.getProperty("env");

        if (env == null) {

            env = "qa";
        }

        String path =
                System.getProperty("user.dir")
                + "/src/test/resources/config/"
                + env
                + ".properties";

        try {

            FileInputStream fis =
                    new FileInputStream(path);

            prop.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }

        // Allow JVM system properties to override file values
        // e.g. mvn test -Dheadless=true or -Dbrowser=firefox
        String sysHeadless = System.getProperty("headless");
        if (sysHeadless != null && !sysHeadless.isEmpty()) {
            prop.setProperty("headless", sysHeadless);
        }
        String sysBrowser = System.getProperty("browser");
        if (sysBrowser != null && !sysBrowser.isEmpty()) {
            prop.setProperty("browser", sysBrowser);
        }

        return prop;
    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}