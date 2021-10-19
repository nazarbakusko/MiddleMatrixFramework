package com.eleks.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class FrameworkInitialize extends Base {

    public void initializeBrowser(BrowserType browserType) {

        WebDriver driver = null;
        switch (browserType) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case Opera:
                driver = new OperaDriver();
                break;
        }
        //Set the driver
        DriverContext.setDriver(driver);
        //Set the browser
        DriverContext.browser = new Browser(driver);
    }

}
