package com.eleks.framework.controls.elements;

import com.eleks.framework.controls.internals.Control;

public interface Button extends Control {

    void performClick();
    void performSubmit();
    String getButtonText();

}
