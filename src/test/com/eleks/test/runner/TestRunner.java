package com.eleks.test.runner;

import com.eleks.framework.utils.ListenerUtil;
import io.cucumber.testng.*;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.util.List;

@Listeners({ListenerUtil.class})
@CucumberOptions(features = {"src/test/com/eleks/test/features/"}, glue = {"com/eleks/test/stepsdefinition"}, plugin = {"pretty"})
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "features", priority = 1)
    @Description("Runs two Cucumber Scenarios")
    public void runTests(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
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