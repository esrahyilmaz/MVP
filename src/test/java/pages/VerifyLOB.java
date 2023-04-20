package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VerifyLOB extends BaseClass{
	
	private By lobDD=By.xpath("//select[@name='lobId']");
	private By OrganisationDD=By.xpath("//select[@name='orgId']");
	private By submitBtn=By.xpath("//input[@value='SUBMIT']");
	private By VerifyText=By.xpath("//td[@width=\"*\"]/b");
	
	public void selectLOB(String LOB) {
		
		if(verifyElementPresence(lobDD)){
			selectDropDown(lobDD, LOB, "LOB");
		}
		
		if(verifyElementPresence(submitBtn)){
			clickElement(submitBtn, "Submit");
		}
	}
	
	public void selectOrganisation(String orgName) {
		if(verifyElementPresence(OrganisationDD)){
			selectDropDown(OrganisationDD, orgName, "Organisation Name");
		}
		if(scenarioName.contains("Production")) {
			String text=driver.findElement(By.xpath("//div[@class='black9']")).getText();
            
            if(text.contains("You are currently in "+orgName)) {
                           reportLog(Status.PASS, text, true);
            }else {
                           reportLog(Status.FAIL, text, true);
            }
		}
		
	}

}
