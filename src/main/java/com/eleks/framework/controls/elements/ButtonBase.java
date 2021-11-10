package com.eleks.framework.controls.elements;

import com.eleks.framework.base.DriverContext;
import com.eleks.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class ButtonBase extends ControlBase implements Button {

    public ButtonBase(WebElement element) {
        super(element);
    }

    @Override
    public void performClick() {
        getWrappedElement().click();
    }

    @Override
    public void performSubmit() {
        getWrappedElement().submit();
    }

    @Override
    public String getButtonText() {
        return getWrappedElement().getText();
    }

    public void Wait() {
        DriverContext.waitForPageToLoad();
    }

    public void WaitForVisible() {
        DriverContext.waitForElementVisible(getWrappedElement());
    }

    public void ClickBtn() {
        getWrappedElement().click();
    }
}
