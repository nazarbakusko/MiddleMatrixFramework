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
    //BrowserType
    public static BrowserType browserType;
    //Logs
    public static LogUtil log;
}
