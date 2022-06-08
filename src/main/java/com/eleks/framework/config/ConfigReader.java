package com.eleks.framework.config;

import com.eleks.framework.base.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        var reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() throws IOException {
        var prop = new Properties();
        //Load property file available in same package
        var inputStream = new FileInputStream("src/main/java/com/eleks/framework/config/GlobalConfig.properties");
        prop.load(inputStream);
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
        //Hub
        Settings.seleniumGridHub = prop.getProperty("seleniumGridHub");
        //Video
        Settings.videoFolder = prop.getProperty("videoFolder");
        Settings.videoEnabled = prop.getProperty("videoEnabled");
        Settings.videoMode = prop.getProperty("videoMode");
        Settings.recorderType = prop.getProperty("recorderType");
        Settings.videoSaveMode = prop.getProperty("videoSaveMode");
        Settings.videoFrameRate = prop.getProperty("videoFrameRate");
        Settings.ffmpegFormat = prop.getProperty("ffmpegFormat");
        Settings.ffmpegDisplay = prop.getProperty("ffmpegDisplay");
        Settings.ffmpegPixelFormat = prop.getProperty("ffmpegPixelFormat");
        //Get log
        //Settings.log = LogUtilprop.getProperty("log"));

    }

}
