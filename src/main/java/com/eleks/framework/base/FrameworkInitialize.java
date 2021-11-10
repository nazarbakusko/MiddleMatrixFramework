package com.eleks.framework.base;

import com.eleks.framework.config.Settings;
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

        RemoteWebDriver driver = null;
        switch (browserType) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
                DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
                driver = new RemoteWebDriver(new URL(Settings.seleniumGridHub), capabilities);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
                DesiredCapabilities capabilities1 = new DesiredCapabilities().firefox();
                driver = new RemoteWebDriver(new URL(Settings.seleniumGridHub), capabilities1);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case Opera:
                driver = new OperaDriver();
                break;
        }

    }

}
