package RunnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
		glue = {"stepDefinition" },

		//tags = {"@UI-7-property"},
		//tags = {"@UI-10-property"},
		//tags = {"@UI-4-property"},
		
		//tags = {"@NewUI-7-VendorOnboarding"},
		//tags = {"@NewUI-7-VendorOnboardingLogin"},
		//tags = {"@NewUI-7-Additional-BillingZero"},
		//tags = {"@NewUI-7-Additional-BillingPrice"},
		
		//tags = {"@NewUI-10-VendorOnboarding"},
		//tags = {"@NewUI-10-VendorOnboardingLogin"},
		//tags = {"@NewUI-10-Additional-BillingZero"},
		//tags = {"@NewUI-10-Additional-BillingPrice"},
		
		//tags = {"@NewUI-4-VendorOnboarding"},
		//tags = {"@NewUI-4-VendorOnboardingLogin"},
		//tags = {"@NewUI-4-Additional-BillingZero"},
		//tags = {"@NewUI-4-Additional-BillingPrice"},
		
		//tags = {"@NewUI-7-PAFlow"},
		//tags = {"@NewUI-10-PAFlow"},
		//tags = {"@NewUI-4-PAFlow"},
		
		tags = "@NewUI-US-20182",
		
		
		plugin = { "pretty", "html:target/cucumber-reports","rerun:rerun/failed_scenarios.txt"},
		monochrome = true
		)

public class TestRunner1 extends AbstractTestNGCucumberTests {
	}