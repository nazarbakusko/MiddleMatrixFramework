package stepsdefinition;

import com.eleks.framework.base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;
import page.HomePage;
import page.LoginPage;

import java.util.List;

public class LoginSteps extends Base {

    @Step("I ensure application opened")
    @And("I ensure application opened")
    public void iEnsuredApplicationOpened() {
        CurrentPage = getInstance(HomePage.class);
        Assert.assertTrue("The login page is not loaded", CurrentPage.as(HomePage.class).isLogin());
    }

    @Step("I click login link")
    @Then("I click login link")
    public void iClickLoginLink() {
        //Navigation to login page
        CurrentPage = CurrentPage.as(HomePage.class).clickLogin();
    }

    @Step("I enter UserName and Password")
    @When("I enter UserName and Password")
    public void iEnterUserNameAndPassword(DataTable table) {
        List<List<String>> cells = table.cells();
        CurrentPage.as(LoginPage.class).loginM(cells.get(1).get(0), cells.get(1).get(1));
    }

    @Step("I click login button")
    @Then("I click login button")
    public void iClickLoginButton() throws InterruptedException {
        //Navigation to home page
        CurrentPage = CurrentPage.as(LoginPage.class).clickLoginM();
        Thread.sleep(2000);
    }

    @Step("I should see the username with hello")
    @Then("I should see the username with hello")
    public void iShouldSeeTheUsernameWithHello() {
        Assert.assertEquals("The user is not admin", CurrentPage.as(HomePage.class).getLoggedInUser(), "Hello admin!");
    }

}
