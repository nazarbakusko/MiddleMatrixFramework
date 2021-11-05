package com.eleks.test.stepsdefinition;

import com.eleks.framework.utils.CucumberUtil;
import com.eleks.test.page.CreateEmployeePage;
import com.eleks.test.page.EmployeeListPage;
import com.eleks.test.page.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import java.util.List;

import static com.eleks.framework.base.Base.CurrentPage;

public class EmployeeSteps {

    @Step("I click employeeList link")
    @And("I click employeeList link")
    public void iClickEmployeeListLink() throws InterruptedException {
        CurrentPage = CurrentPage.as(HomePage.class).clickEmployeeList();
        Thread.sleep(3000);
    }

    @Step("I click create new btn")
    @Then("I click create new btn")
    public void iClickCreateNewBtn() throws InterruptedException {
        CurrentPage = CurrentPage.as(EmployeeListPage.class).clickCreateNew();
        Thread.sleep(3000);
    }

    @Step("I enter following details")
    @And("I enter following details")
    public void iEnterFollowingDetails(DataTable table) throws InterruptedException {
        //List<List<String>> cells = table.cells();
        /*CurrentPage.as(CreateEmployeePage.class).createEmployee(cells.get(1).get(0), cells.get(1).get(1), cells.get(1).get(2),
                cells.get(1).get(3), cells.get(1).get(4));*/
        CucumberUtil.convertDataTableToDict(table);
        CurrentPage.as(CreateEmployeePage.class).createEmployee(CucumberUtil.getCellValue("Name"),
                CucumberUtil.getCellValue("Salary"),
                CucumberUtil.getCellValue("DurationWorked"),
                CucumberUtil.getCellValue("Grade"),
                CucumberUtil.getCellValue("Email"));
        Thread.sleep(3000);
    }

    @Step("I click create button")
    @And("I click create button")
    public void iClickCreateButton() throws InterruptedException {
        CurrentPage.as(CreateEmployeePage.class).clickCreateButton();
        Thread.sleep(3000);
    }
}
