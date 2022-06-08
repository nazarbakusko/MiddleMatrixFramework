package com.eleks.framework.config;

import com.eleks.framework.base.BrowserType;
import com.eleks.framework.utils.LogUtil;

import java.sql.Connection;

public class Settings {
    //For app backend
    public static Connection autConnection;
    public static String autConnectionString;
    // Log path for framework
    public static String logPath;
    //Driver type for sql server connectivity
    public static String driverType;
    public static String excelSheetPath;
    public static String aut;
    public static String seleniumGridHub;
    //BrowserType
    public static BrowserType browserType;
    //Logs
    public static LogUtil log;
    //Video
    public static String videoFolder;
    public static String videoEnabled;
    public static String videoMode;
    public static String recorderType;
    public static String videoSaveMode;
    public static String videoFrameRate;
    public static String ffmpegFormat;
    public static String ffmpegDisplay;
    public static String ffmpegPixelFormat;
}
