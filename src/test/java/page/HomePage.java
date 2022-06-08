package page;

import com.eleks.framework.base.BasePage;
import com.eleks.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    @FindBy(how = How.XPATH, using = "//a[@title = 'Manage']")
    public WebElement lnkUserName;

    @FindBy(how = How.LINK_TEXT, using = "Manage Users")
    public WebElement lnkManageUsers;

    @FindAll(@FindBy(how = How.XPATH, using = "//a[contains(text(), '')]"))
    List<WebElement> navHeaderElements;


    public LoginPage clickLogin() {
        DriverContext.waitForElementVisible(lnkLogin);
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
        DriverContext.waitForElementVisible(lnkEmployeeList);
        lnkEmployeeList.click();
        return getInstance(EmployeeListPage.class);
    }

    public ManageUsersPage clickManageUsers() {
        DriverContext.waitForElementVisible(lnkManageUsers);
        lnkManageUsers.click();
        return getInstance(ManageUsersPage.class);
    }

}


