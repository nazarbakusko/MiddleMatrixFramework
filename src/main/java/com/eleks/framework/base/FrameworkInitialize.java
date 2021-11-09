package com.eleks.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FrameworkInitialize extends Base {

    public void initializeBrowser(BrowserType browserType) throws MalformedURLException {

        WebDriver driver = null;
        switch (browserType) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
                DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
                driver = new RemoteWebDriver(new URL("http://192.168.0.139:4444/wd/hub"), capabilities);
                break;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
                DesiredCapabilities capabilities1 = new DesiredCapabilities().firefox();
                driver = new RemoteWebDriver(new URL("http://192.168.0.139:4444/wd/hub"), capabilities1);
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
