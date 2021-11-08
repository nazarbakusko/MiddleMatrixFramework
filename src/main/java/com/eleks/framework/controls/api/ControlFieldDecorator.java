package com.eleks.framework.controls.api;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.*;
import java.util.List;

public class ControlFieldDecorator implements FieldDecorator {

    protected ElementLocatorFactory factory;

    public ControlFieldDecorator(ElementLocatorFactory factory) {
        this.factory = factory;
    }

    public Object decorate(ClassLoader loader, Field field) {
        if (!WebElement.class.isAssignableFrom(field.getType()) && !this.isDecoratableList(field)) {
            return null;
        } else {
            ElementLocator locator = this.factory.createLocator(field);
            if (locator == null) {
                return null;
            } else if (WebElement.class.isAssignableFrom(field.getType())) {
                return this.proxyForLocator(loader, locator);
            } else {
                return List.class.isAssignableFrom(field.getType()) ? this.proxyForListLocator(loader, locator) : null;
            }
        }
    }

    protected boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        } else {
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return false;
            } else {
                Type listType = ((ParameterizedType)genericType).getActualTypeArguments()[0];
                if (!WebElement.class.equals(listType)) {
                    return false;
                } else {
                    return field.getAnnotation(FindBy.class) != null || field.getAnnotation(FindBys.class) != null || field.getAnnotation(FindAll.class) != null;
                }
            }
        }
    }

    protected WebElement proxyForLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementHandler(locator);
        WebElement proxy = (WebElement) Proxy.newProxyInstance(loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler);
        return proxy;
    }

    protected List<WebElement> proxyForListLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementListHandler(locator);
        List<WebElement> proxy = (List)Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
        return proxy;
    }


}
