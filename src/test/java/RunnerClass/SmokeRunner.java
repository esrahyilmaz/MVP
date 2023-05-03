package RunnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import seleniumhelper.BaseClass;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinition"},
        tags = "@Smoke",
        plugin = {"pretty"
                , "json:target/cucumber-reports/cucumber.json"
                , "junit:target/cucumber-reports/cucumber.xml"}
        , monochrome = false
)
public class SmokeRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void afterSuite() {
        try {
            if (BaseClass.driver != null)
                BaseClass.driver.quit();
            BaseClass.eventFiringWebDriver.quit();
        } catch (Exception e) {
            System.err.println("Unable to close webdriver");
        }
    }
}
