package com.eleks.test.page;

import com.eleks.framework.base.BasePage;
import com.eleks.framework.controls.elements.Button;
import com.eleks.framework.controls.elements.ButtonBase;
import com.eleks.framework.controls.elements.TextBox;
import com.eleks.framework.controls.elements.TextBoxBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage() {
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.CSS, using = "[class*='btn-default']")
    public WebElement btnLogin;

    //Modified
    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserNameM;

    //Modified
    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPasswordM;

    //Modified
    @FindBy(how = How.CSS, using = "[class*='btn-default']")
    public WebElement btnLoginM;

    public void login(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    //Modified
    public void loginM(String userName, String password) {
        TextBox textUser = new TextBoxBase(txtUserNameM);
        textUser.enterText(userName);
        TextBox textPass = new TextBoxBase(txtPasswordM);
        textPass.enterText(password);
    }

    public HomePage clickLoginM() {
        btnLogin.submit();
        return getInstance(HomePage.class);
    }

    //Modified
//    public HomePage clickLoginM() {
//        Button btn = new ButtonBase(btnLoginM);
//        btn.performSubmit();
//        return getInstance(HomePage.class);
//    }
}
