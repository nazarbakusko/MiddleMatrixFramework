package com.eleks.test.stepsdefinition;

import com.eleks.framework.base.Base;
import com.eleks.framework.utils.ExcelUtil;
import com.eleks.test.page.HomePage;
import com.eleks.test.page.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginSteps extends Base {

    @And("I ensure application opened")
    public void iEnsuredApplicationOpened() {
        CurrentPage = getInstance(HomePage.class);
        Assert.assertTrue("The login page is not loaded", CurrentPage.as(HomePage.class).isLogin());
    }

    @Then("I click login link")
    public void iClickLoginLink() throws InterruptedException {
        //Navigation to login page
        CurrentPage = CurrentPage.as(HomePage.class).clickLogin();
        //TODO
        Thread.sleep(3000);
    }

    @When("I enter UserName and Password")
    public void iEnterUserNameAndPassword(DataTable table) {
        List<List<String>> cells = table.cells();
        CurrentPage.as(LoginPage.class).loginM(cells.get(1).get(0), cells.get(1).get(1));
    }

    @Then("I click login button")
    public void iClickLoginButton() throws InterruptedException {
        //Navigation tot home page
        CurrentPage = CurrentPage.as(LoginPage.class).clickLoginM();
        //TODO
        Thread.sleep(3000);
    }

    @Then("I should see the username with hello")
    public void iShouldSeeTheUsernameWithHello() {
        Assert.assertEquals("The user is not admin", CurrentPage.as(HomePage.class).getLoggedInUser(), "Hello admin!");
    }

}
