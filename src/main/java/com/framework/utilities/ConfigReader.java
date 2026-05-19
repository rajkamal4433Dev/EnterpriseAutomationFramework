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

        return prop;
    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}