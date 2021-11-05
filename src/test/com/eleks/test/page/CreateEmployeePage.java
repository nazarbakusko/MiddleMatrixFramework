package com.eleks.test.page;

import com.eleks.framework.base.BasePage;
import com.eleks.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateEmployeePage extends BasePage {

    @FindBy(how = How.ID, using = "Name")
    public WebElement txtName;

    @FindBy(how = How.ID, using = "Salary")
    public WebElement txtSalary;

    @FindBy(how = How.ID, using = "DurationWorked")
    public WebElement txtDurationWorked;

    @FindBy(how = How.ID, using = "Grade")
    public WebElement txtGrade;

    @FindBy(how = How.ID, using = "Email")
    public WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//input[@value = 'Create']")
    public WebElement btnCreateEmployee;

    public void clickCreateButton() {
        DriverContext.waitForElementVisible(btnCreateEmployee);
        btnCreateEmployee.click();
    }

    public void createEmployee(String name, String salary, String duration, String grade, String email) {
        DriverContext.waitForElementVisible(txtEmail);
        txtName.sendKeys(name);
        txtSalary.sendKeys(salary);
        txtDurationWorked.sendKeys(duration);
        txtGrade.sendKeys(grade);
        txtEmail.sendKeys(email);
    }
}
