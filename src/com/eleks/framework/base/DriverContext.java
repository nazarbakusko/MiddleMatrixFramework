package com.eleks.framework.base;

import com.eleks.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {

    public static WebDriver Driver;

    public static Browser browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver;
        ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor) Driver)
                .executeScript("return document.readyState").toString().equals("complete");

        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady)
            wait.until(jsLoad);
        else
            Settings.log.write("Page is empty!");
    }

    public static void waitForElementVisible(final WebElement elementFindBy) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void waitForElementTextVisible(final WebElement elementFindBy, String text) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void waitUntilTextDisplayed(final By element, String text) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text) {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }

    public static void waitElementEnabled(final By elementFindBy) {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }
}
