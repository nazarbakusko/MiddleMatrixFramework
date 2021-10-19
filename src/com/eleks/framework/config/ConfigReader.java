package com.eleks.framework.config;

import com.eleks.framework.base.BrowserType;
import com.eleks.framework.utils.LogUtil;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() throws IOException {
        Properties prop = new Properties();
        //Load property file available in same package
        prop.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        //Get AUTConnection String
        Settings.autConnectionString = prop.getProperty("autConnectionString");
        //Get logPath String
        Settings.logPath = prop.getProperty("logPath");
        //Get driverType String
        Settings.driverType = prop.getProperty("driverType");
        //Get excelSheetPath String
        Settings.excelSheetPath = prop.getProperty("excelSheetPath");
        //Get url String
        Settings.aut = prop.getProperty("aut");
        //Get browser Type
        Settings.browserType = BrowserType.valueOf(prop.getProperty("browserType"));
        //Get log
        //Settings.log = LogUtilprop.getProperty("log"));

    }

}
