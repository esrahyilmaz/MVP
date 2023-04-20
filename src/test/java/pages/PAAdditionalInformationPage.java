package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PAAdditionalInformationPage extends BaseClass {
	
	private static By addlinfoPageNxtBtn = By.xpath("//div[@class='row fixedbtn']//div/button[text()='NEXT']");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");
//	private static By genederSelectMale = By.xpath("(//select[@name='gendertype']/option)[1]");
private static By genederSelectMale = By.xpath("//select/option[2]");

	public void enterAdditionalInformationSection() {
		try {

//			clickElement(iUnderstandBtn,"I Understand" );
//			logStepInfo("I Understand Button clicked : "+"I Understand");

//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn,"I Understand" );
//				logStepInfo("I Understand Button clicked : "+"I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}

//			clickElement(genederSelectMale, "Gender Select Male");
//			logStepInfo("Gender Selected as Male : " + "Gender Select");
//			clickElement(genederSelectMale, "Gender Select Male");
//			logStepInfo("Gender Selected as Male : " + "Gender Select");
//
//			clickElement(addlinfoPageNxtBtn, "Next");
//			logStepInfo("Next Button is Clicked : " + "Next");
//			By select=By.xpath("//select");
//			selectDropDownByIndex(select,"1","Select dropdown Male");

		//	JavascriptExecutor js= (JavascriptExecutor)driver;
//			executeJSScript("document.getElementById('d0f7b482-c5e8-2e35-e053-aa06fa0acc9b').selectedIndex=1;", "true");
//			System.out.println("index 1 selected");
//			executeJSScript("document.querySelector('#card-slide > international > div > dynamic-wotc > form > div > div > div.row.fixedbtn > div:nth-child(1) > button').disabled=false;", "true");
//			executeJSScript("document.querySelector('#card-slide > international > div > dynamic-wotc > form > div > div > div.row.fixedbtn > div:nth-child(1) > button').click();","true");
//
//			try {
//
//				clickElement(genederSelectMale, "Gender Select Male");
//				logStepInfo("Gender Selected as Male : " + "Gender Select");
//				clickElement(addlinfoPageNxtBtn, "Next");
//				logStepInfo("Next Button is Clicked : " + "Next");
//
//			} catch (Exception ex) {
//				logStepInfo("Exception occured in PA Additional Information Page:- " + ex.getMessage());
//				reportLog(Status.FAIL, "Exception occured in PA Additional Information Page :- " + ex.getMessage(), true);
//			} finally {
//			}
			clickElement(addlinfoPageNxtBtn, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Additional Information Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Additional Information Page :- " + ex.getMessage(), true);
		}
  }

    public void enterAdditionalInformationSectionUAT() {
		try {

			clickElement(By.xpath("//select"), "Select dropdown");

			clickElement(genederSelectMale, "Gender Select Male");
			logStepInfo("Gender Selected as Male : " + "Gender Select");

			clickElement(addlinfoPageNxtBtn, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Additional Information Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Additional Information Page :- " + ex.getMessage(), true);
		}
    }
}
