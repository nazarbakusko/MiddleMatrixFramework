package stepsdefinition;

import com.eleks.framework.base.DriverContext;
import com.eleks.framework.utils.CucumberUtil;
import page.CreateEmployeePage;
import page.EmployeeListPage;
import page.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static com.eleks.framework.base.Base.CurrentPage;

public class EmployeeSteps {

    @Step("I click employeeList link")
    @And("I click employeeList link")
    public void iClickEmployeeListLink() {
        CurrentPage = CurrentPage.as(HomePage.class).clickEmployeeList();
        DriverContext.waitForPageToLoad();
    }

    @Step("I click create new btn")
    @Then("I click create new btn")
    public void iClickCreateNewBtn() {
        DriverContext.waitForPageToLoad();
        CurrentPage = CurrentPage.as(EmployeeListPage.class).clickCreateNew();
    }

    @Step("I enter following details")
    @And("I enter following details")
    public void iEnterFollowingDetails(DataTable table) {
        CucumberUtil.convertDataTableToDict(table);
        CurrentPage.as(CreateEmployeePage.class).createEmployee(CucumberUtil.getCellValueWithRowIndex("Name", 2),
                CucumberUtil.getCellValueWithRowIndex("Salary",2),
                CucumberUtil.getCellValueWithRowIndex("DurationWorked",2),
                CucumberUtil.getCellValueWithRowIndex("Grade",2),
                CucumberUtil.getCellValueWithRowIndex("Email",2));
    }

    @Step("I click create button")
    @And("I click create button")
    public void iClickCreateButton() {
        CurrentPage.as(CreateEmployeePage.class).clickCreateButton();
    }
}
