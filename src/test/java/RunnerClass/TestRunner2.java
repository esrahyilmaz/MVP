package RunnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = {"stepDefinition" },

        tags = "@FilteringOnPersonStatus",
        //tags = {"},
        //tags = {""},

        plugin = { "pretty", "html:target/cucumber-reports","rerun:rerun/failed_scenarios.txt"},
        monochrome = true
)

public class TestRunner2 extends AbstractTestNGCucumberTests {
}