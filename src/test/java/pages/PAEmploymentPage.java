package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

	

public class PAEmploymentPage extends BaseClass {

	private static By empVerificationNextBtn = By.xpath("//button[contains(text(), 'NEXT') and @data-id='empVerificationNext_0']");
	private static By employmentDropList = By.xpath("//select[@name='empCategory']");
	private static By empCategoryNextBtn = By.xpath("//button[contains(text(), 'NEXT') and @data-id='empCategoryNext_0']");
	private static By countryWorkField = By.xpath("//custom-select[@controlname='countryName']/div/ng-select/div/div/div/input");
	private static By empCountryNextBtn = By.xpath("//button[contains(text(), 'NEXT') and @data-id='empCountryNext_0']");
	private static By cityInp = By.xpath("//custom-select[@controlname='city']/div/ng-select/div/div/div/input");
	private static By stateInp = By.xpath("//custom-select[@controlname='stateName']/div/ng-select/div/div/div/input");
	private static By empCityStateNextBtn = By.xpath("//button[contains(text(), 'NEXT') and @data-id='empCityStateNext_0']");
	private static By noContactThemBtn = By.xpath("//button[@data-id='empVerifyConfirmNoContact_0']");
	private static By yesContactThemBtn = By.xpath("//button[@data-id='empVerifyConfirmYesContact_0']");
	private static By employerField = By.xpath("//custom-select[@controlname='companyName']/div/ng-select/div/div/div/input");
	private static By empCompNameNextBtn = By.xpath("//button[contains(text(), 'NEXT') and @data-id='empCompanyNameNext_0']");
	private static By empSlideCalendar = By.xpath("//pa-date-picker[@id='empJobFrom_0']/div/div/input");
	private static By empJobPeriodNextBtn = By.xpath("//button[contains(text(), 'NEXT') and @data-id='empJobPeriodNext_0']");
	private static By jobTitleField = By.xpath("//*[@id=\"empjobTitle_0\"]");
	private static By empJobTitleNextBtn = By.xpath("//button[@data-id='empJobTitleNext_0']");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");
	
	
	public void enterEmploymentSection(String employmentInfo, String state, String city, String employerName, String startMonth,
			String startYear, String jobTitle) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);


			if (verifyElementPresence(iUnderstandBtn)) {
				clickElement(iUnderstandBtn,"I Understand" );
				logStepInfo("I Understand Button clicked : "+"I Understand");
			} else {
				logStepInfo("I Understand Button Not clicked : "+"I Understand");
			}
			
			clickElement(empVerificationNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
            
			wait(2);
			wait.until(ExpectedConditions.presenceOfElementLocated(employmentDropList));
			selectDropDown(employmentDropList, employmentInfo, "Employment Information selected");
			logStepInfo("Employment Information selected : " + employmentInfo);
            
			clickElement(empCategoryNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(countryWorkField, "Country");
			EnterText(countryWorkField, "Country", countryPA);
			clickElement(By.xpath("//div[contains(text(),'"+countryPA+"')]"), "Country");
			logStepInfo("Country Entered : " + countryPA);
			
			clickElement(empCountryNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");

			clickElement(stateInp, "State");
			EnterText(stateInp, "State", state);
			clickElement(By.xpath("//div[contains(text(),'"+state+"')]"), "State");
			logStepInfo("State Entered : " + state);

			clickElement(cityInp, "City");
			EnterText(cityInp, "City", city);
			clickElement(By.xpath("//div[contains(text(),'"+city.toUpperCase()+"')]"), "City");
			logStepInfo("City Entered : " + city);
			
			clickElement(empCityStateNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(noContactThemBtn, "DON'T CONTACT THEM");
			logStepInfo("Don't contact current employer Button clicked : " + "DON'T CONTACT THEM");
			
			wait(2);
			clickElement(employerField, "Name of employer");
			EnterText(employerField, "Name of employer", employerName);
			logStepInfo("Employer Name Entered : " + employerName);
			
			clickElement(empCompNameNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");

			clickElement(empSlideCalendar, "Start Employment");
			logStepInfo("Start Employment field clicked : " + "Start Employment");
			EnterText(empSlideCalendar, "Start Month", startMonth);
			logStepInfo("Start Month Entered : " + startMonth);

			driver.findElement(empSlideCalendar).sendKeys(Keys.TAB);
			
			driver.findElement(empSlideCalendar).sendKeys(startYear);
			logStepInfo("Start Year Entered : " + startYear);

			clickElement(empJobPeriodNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");

			clickElement(jobTitleField, "Job Title");
			EnterText(jobTitleField, "Job Title", jobTitle);
			logStepInfo("Job Title Entered : " + jobTitle);
			
			clickElement(empJobTitleNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn,"I Understand" );
//				logStepInfo("I Understand Button clicked : "+"I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}
			
			clickElement(iUnderstandBtn, "I Understand");
			logStepInfo("I Understand Button clicked : " + "I Understand");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Profile Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Profile Page :- " + ex.getMessage(), true);
		}
	}



}
