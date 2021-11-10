package runner;

import com.eleks.framework.utils.ListenerUtil;
import io.cucumber.testng.*;
import io.qameta.allure.Description;
import org.testng.annotations.*;

@Listeners({ListenerUtil.class})
@CucumberOptions(features = {"src/test/java/features/"}, glue = {"stepsdefinition"}, plugin = {"pretty"})
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Check Login with correct username and password", dataProvider = "features", priority = 1, testName = "@LoginTest")
    @Description("Check Login with correct username and password")
    public void verifyLoginWithCorrectUsernameAndPassword(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @Test(description = "Create Employee with all details", dataProvider = "features", priority = 1, testName = "@EmployeeTest")
    @Description("Create Employee with all details")
    public void verifyCreateEmployeeWithAllDetails(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}