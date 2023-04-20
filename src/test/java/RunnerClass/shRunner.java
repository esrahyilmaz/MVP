package RunnerClass;


import helpers.BaseClass;
import helpers.CalendarHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/"
        , glue = {"stepDefinition"}
        , plugin = {"pretty"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"}
        , tags = "@regression2_03 or @regression2_03"
)
public class shRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        BaseClass.runnerName = this.getClass().getSimpleName();
        BaseClass.reportFile = CalendarHelper.getTime() + "_" + BaseClass.runnerName + ".html";
    }

}