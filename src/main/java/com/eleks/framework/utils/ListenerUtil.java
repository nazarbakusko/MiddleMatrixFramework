package com.eleks.framework.utils;

import com.eleks.framework.base.LocalDriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ListenerUtil implements ITestListener {

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

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

    @Attachment(value = "record screen", type = "video/avi")
    public void allureVid() {
        try {
            byte[] byteArr = IOUtils.toByteArray(new FileInputStream("test"));
            Allure.addAttachment("attachment name", "video/avi", new ByteArrayInputStream(byteArr), "avi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am on failure method");

        //Get driver from BaseTest and assign to local webdriver variable.Object testClass = iTestResult.getInstance();
        WebDriver driver = LocalDriverContext.getRemoteWebDriver();

        //Allure ScreenShotRobot and Save TestLog
        if (driver instanceof WebDriver) {
            saveScreenshotPNG(driver);
        }

        allureVid();
        //save a log on allure
        saveTextLog("Test failed and screenshot taken!" + timeStamp);
    }

}
