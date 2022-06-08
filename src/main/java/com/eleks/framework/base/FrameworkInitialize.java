package com.eleks.framework.base;

import com.eleks.framework.config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
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
                WebDriverManager.chromedriver();
                DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
                driver = new RemoteWebDriver(new URL(Settings.seleniumGridHub), capabilities);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            case Firefox:
                WebDriverManager.firefoxdriver();
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
