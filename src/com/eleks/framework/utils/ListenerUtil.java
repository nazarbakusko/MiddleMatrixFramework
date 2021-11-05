package com.eleks.framework.utils;

import com.eleks.framework.base.Base;
import com.eleks.framework.base.DriverContext;
import com.eleks.framework.base.FrameworkInitialize;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtil extends Base implements ITestListener {

    //screenshot attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am on failure method");

        //Get driver from BaseTest and assign to local webdriver variable.Object testClass = iTestResult.getInstance();
        WebDriver driver = DriverContext.Driver;

        //Allure ScreenShotRobot and Save TestLog
        if (driver instanceof WebDriver) {
            saveScreenshotPNG(driver);
        }

        //save a log on allure
        saveTextLog("Test failed and screenshot taken!");
    }
}
