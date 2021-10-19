package com.eleks.framework.controls.elements;

import com.eleks.framework.controls.internals.Control;

public interface TextBox extends Control {

    void enterText(String text);
    String getTextValue();

}
