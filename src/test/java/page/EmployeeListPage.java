package page;

import com.eleks.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListPage extends BasePage {

    public EmployeeListPage() {
    }

    @FindBy(how = How.NAME, using = "searchTerm")
    public WebElement txtSearch;

    @FindBy(how = How.LINK_TEXT, using = "Create New")
    public WebElement lnkCreateNew;

    @FindBy(how = How.CLASS_NAME, using = "table")
    public WebElement tblEmployeeList;

    public CreateEmployeePage clickCreateNew() {
        lnkCreateNew.click();
        return getInstance(CreateEmployeePage.class);
    }

    public WebElement getEmployeeList() {
        return tblEmployeeList;
    }
}
