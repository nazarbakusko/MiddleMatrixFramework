package com.eleks.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends Base {

    private final WebDriver _driver;

    public BrowserType type;

    public Browser(WebDriver driver) {
        _driver = driver;
    }

    public void maximizeWindow() {
        _driver.manage().window().maximize();
    }

    public void quitBrowser() {
        _driver.quit();
    }

}
