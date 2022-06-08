package runner;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import com.eleks.framework.base.DriverContext;
import com.eleks.framework.utils.ListenerUtil;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.qameta.allure.Description;
import org.testng.annotations.*;

@Listeners({ListenerUtil.class, UniversalVideoListener.class})
@CucumberOptions(features = {"src/test/java/features/"}, glue = {"stepsdefinition"}, plugin = {"pretty"})
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

//    @Test(description = "Check Login with correct username and password", dataProvider = "features", priority = 2, testName = "@LoginTest")
//    @Video
//    @Description("Create Employee with all details")
//    public void verifyLoginWithCorrectUsernameAndPassword(PickleWrapper pickleWrapper) {
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
//    }

    @Test(description = "Create Employee with all details", dataProvider = "features", priority = 1, testName = "@EmployeeTest")
    @Video(name = "Test")
    @Description("Create Employee with all details")
    public void verifyCreateEmployeeWithAllDetails(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

//    @Test(description = "Verify one author of the post", dataProvider = "features", priority = 3, testName = "@GetPostTest")
//    @Video
//    @Description("Verify one author of the post")
//    public void verifyOneAuthorOfThePost(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
//    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod()
    public void tearDownBrowser() {
        DriverContext.quitBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}