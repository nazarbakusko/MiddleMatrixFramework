package com.eleks.framework.controls.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.lang.reflect.InvocationTargetException;

public class ControlFactory extends PageFactory {

    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            T page = pageClassToProxy.getConstructor(WebDriver.class).newInstance(driver);
            PageFactory.initElements(
                    new ControlFieldDecorator(new DefaultElementLocatorFactory(driver)), page);
            return page;
        } catch (InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


}
