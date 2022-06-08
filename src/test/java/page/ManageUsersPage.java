package page;

import com.eleks.framework.base.BasePage;
import com.eleks.framework.base.DriverContext;
import com.eleks.framework.controls.elements.Select;
import com.eleks.framework.controls.elements.SelectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManageUsersPage extends BasePage {

    public ManageUsersPage() {
    }

    @FindBy(how = How.XPATH, using = "//h3[text() = 'List of Users']")
    public WebElement title;

    @FindBy(how = How.XPATH, using = "//select")
    public WebElement role;

    public void selectRole(String value) {
        DriverContext.waitForElementVisible(title);
        Select selectRole = new SelectBase(role);
        selectRole.selectByValue(value);
    }
}
