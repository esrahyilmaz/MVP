package RunnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinition"},

        tags = "@NewUI-Administration-UserCreation",
//		tags\ = {"@SiteCreditPrerequisiteOFF"},
        //,@NewUI-PeopleSearch,@NewUIProgramOwnerWorkflow,@VendorOnboarding,@errorMessageReg"},
        //	@errorMessageReg
        //new work:@NewUI-Administration-UserCreation
        //@NewUI-US-20182

        plugin = {"pretty", "html:target/cucumber-reports", "rerun:rerun/failed_scenarios.txt"
                , "json:target/cucumber-reports/cucumber.json"
                , "junit:target/cucumber-reports/cucumber.xml"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}