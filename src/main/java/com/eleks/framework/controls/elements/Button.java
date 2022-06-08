package com.eleks.framework.controls.elements;

import com.eleks.framework.controls.internals.Control;
import com.eleks.framework.controls.internals.ImplementedBy;

@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void performClick();
    void performSubmit();
    String getButtonText();
    void Wait();
    void WaitForVisible();
    void ClickBtn();
}
