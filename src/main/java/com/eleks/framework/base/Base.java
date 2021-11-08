package com.eleks.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage getInstance(Class<TPage> page) {
        Object obj = PageFactory.initElements(DriverContext.Driver, page);
        return page.cast(obj);
    }

}
