package stepsdefinition;

import com.eleks.framework.base.DriverContext;
import com.eleks.framework.utils.CucumberUtil;
import com.eleks.framework.utils.DbUtil;
import com.eleks.framework.utils.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import page.CreateEmployeePage;
import page.EmployeeListPage;
import page.HomePage;
import page.ManageUsersPage;

import static com.eleks.framework.base.Base.CurrentPage;

public class EmployeeSteps {

    private static final Logger LOGGER = Logger.getLogger(EmployeeSteps.class);

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
        LOGGER.debug("I enter following details");
        SessionFactory sessionFactory = DbUtil.setup();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CucumberUtil.convertDataTableToDict(table);
        User user = new User(CucumberUtil.getCellValueWithRowIndex("Name", 1),
                CucumberUtil.getCellValueWithRowIndex("Salary", 1),
                CucumberUtil.getCellValueWithRowIndex("DurationWorked", 1),
                CucumberUtil.getCellValueWithRowIndex("Grade", 1),
                CucumberUtil.getCellValueWithRowIndex("Email", 1));
        session.save(user);
        transaction.commit();
        user = session.get(User.class, 1);
        CurrentPage.as(CreateEmployeePage.class).createEmployee(user.getName(), user.getSalary(),
                user.getDurationWorked(), user.getGrade(), user.getEmail());
        DbUtil.exit(session, sessionFactory);
    }

    @Step("I click create button")
    @And("I click create button")
    public void iClickCreateButton() {
        CurrentPage.as(CreateEmployeePage.class).clickCreateButton();
    }

    @Step("I click manage users link")
    @And("I click manage users link")
    public void iClickManageUsersLink() {
        CurrentPage = CurrentPage.as(HomePage.class).clickManageUsers();
        DriverContext.waitForPageToLoad();
    }

    @Then("I select role")
    public void iSelectRole(DataTable table) {
        CucumberUtil.convertDataTableToDict(table);
        CurrentPage.as(ManageUsersPage.class).
                selectRole(CucumberUtil.getCellValueWithRowIndex("Role", 1));
    }
}
