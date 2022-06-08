package com.eleks.framework.controls.elements;

import com.eleks.framework.controls.internals.Control;
import com.eleks.framework.controls.internals.ImplementedBy;

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void enterText(String text);
    String getTextValue();

}
