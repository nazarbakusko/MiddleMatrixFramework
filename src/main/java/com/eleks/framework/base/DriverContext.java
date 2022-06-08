package com.eleks.framework.base;

import com.eleks.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {

    public static void goToUrl(String url) {
        LocalDriverContext.getRemoteWebDriver().get(url);
    }

    public static void waitForPageToLoad() {
        var wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 30);
        var jsExecutor = LocalDriverContext.getRemoteWebDriver();
        ExpectedCondition<Boolean> jsLoad = webDriver -> LocalDriverContext.getRemoteWebDriver()
                .executeScript("return document.readyState").toString().equals("complete");

        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady)
            wait.until(jsLoad);
        else
            Settings.log.write("Page is empty!");
    }

    public static void waitForElementVisible(final WebElement elementFindBy) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void waitForElementTextVisible(final WebElement elementFindBy, String text) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void waitUntilTextDisplayed(final By element, String text) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 30);
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text) {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }

    public static void waitElementEnabled(final By elementFindBy) {
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(), 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }

    public static void quitBrowser() {
        LocalDriverContext.getRemoteWebDriver().quit();
    }
}
