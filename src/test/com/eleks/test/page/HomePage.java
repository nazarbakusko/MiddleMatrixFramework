package com.eleks.test.page;

import com.eleks.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    @FindBy(how = How.XPATH, using = "//a[@title = 'Manage']")
    public WebElement lnkUserName;

    public LoginPage clickLogin() {
        lnkLogin.click();
        return getInstance(LoginPage.class);
    }

    public boolean isLogin() {
        return lnkLogin.isDisplayed();
    }

    public String getLoggedInUser() {
        return lnkUserName.getText();
    }

    public EmployeeListPage clickEmployeeList() {
        lnkEmployeeList.click();
        return getInstance(EmployeeListPage.class);
    }
}
