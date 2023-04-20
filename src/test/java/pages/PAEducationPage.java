package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import seleniumhelper.BaseClass;

public class PAEducationPage extends BaseClass {
	
	private static By eduTypeDropList = By.xpath("//select[@id='educationtype']");
	private static By eduTypeNextBtn = By.xpath("//button[@data-id='educationTypeNext_0']");
	private static By countryEduField = By.xpath("//input[@id='eduCountryTextField0']");
	private static By eduCountryNextBtn = By.xpath("//button[@data-id='educationCountryNext_0']");
	private static By cityInp = By.xpath("//input[@id='eduCity_0']");
	private static By stateInp = By.xpath("//input[@id='eduState_0']");
	private static By eduStateCityNextBtn = By.xpath("//button[@data-id='educationStateNext_0']");
	private static By institutionEduField = By.xpath("//input[@id='eduInsTextField0']");
	private static By eduInstitutionNextBtn = By.xpath("//button[@data-id='educationInstituteNext_0']");
	private static By eduConfirmationYesBtn = By.xpath("//button[@data-id='educationConfirmYes_0']");
	private static By eduConfirmationNoBtn = By.xpath("//button[@data-id='educationConfirmNo_0']");
	private static By eduConfirmationStillInSchoolBtn = By.xpath("//button[@data-id='educationConfirmStillSchool_0']");
	private static By eduSlideCalendar = By.xpath("//pa-date-picker[@id='fromyear0']/div/div/input");
	private static By eduGraduationDateNextBtn = By.xpath("//button[@data-id='educationYearNext_0']");
	private static By degreeTypeDropList = By.xpath("//select[@id='educationqualification']");
	private static By eduDegreeTypeNextBtn = By.xpath("//button[@data-id='educationQualificationTypeNext_0']");
	private static By eduStartSlideCalendar = By.xpath("//pa-date-picker[@id='eduStartdate0']/div/div/input");
	private static By eduEndSlideCalendar = By.xpath("//pa-date-picker[@id='eduEnddate0']/div/div/input");
	private static By eduDateNextBtn = By.xpath("//button[@data-id='educationstartdateNext_0']");
	private static By studyField = By.xpath("//*[@id=\"eduQualiTextfield0\"]");
	private static By eduStudytBtn = By.xpath("//button[@data-id='educationQualificationNext_0']");
	private static By eduNoOtherDegreeBtn = By.xpath("//button[@data-id='educationFinalStepNo_0']");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");

	public void enterEducationSection(String educationType, String state, String city, String institutionName, String endMonth,
			String endYear, String degreeType, String startMonth, String startYear, String fieldOfStudy) {

		try {

			if (verifyElementPresence(iUnderstandBtn)) {
				clickElement(iUnderstandBtn,"I Understand" );
				logStepInfo("I Understand Button clicked : "+"I Understand");
			} else {
				logStepInfo("I Understand Button Not clicked : "+"I Understand");
			} 
			
			selectDropDown(eduTypeDropList, educationType, "Education Type selected");
			logStepInfo("Education Type selected : " + educationType);
			
			clickElement(eduTypeNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(countryEduField, "Country");
			EnterText(countryEduField, "Country", countryPA);
			logStepInfo("Country Entered : " + countryPA);
			
			clickElement(eduCountryNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(stateInp, "State");
			EnterText(stateInp, "State", state);
			logStepInfo("State Entered : " + state);

			clickElement(cityInp, "City");
			EnterText(cityInp, "City", city);
			logStepInfo("City Entered : " + city);
			
			clickElement(eduStateCityNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(institutionEduField, "Institution Name");
			EnterText(institutionEduField, "Institution Name", institutionName);
			logStepInfo("Institution Name Entered : " + institutionName);

			clickElement(eduInstitutionNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(eduConfirmationYesBtn, "Yes");
			logStepInfo("Yes Button clicked : " + "Yes");
			
			clickElement(eduSlideCalendar, "Graduate date");
			logStepInfo("Graduate date field clicked : " + "Graduate date");
			EnterText(eduSlideCalendar, "Graduate date Month", endMonth);
			logStepInfo("Graduate date Month Entered : " + endMonth);

			driver.findElement(eduSlideCalendar).sendKeys(Keys.TAB);
			
			driver.findElement(eduSlideCalendar).sendKeys(endYear);
			logStepInfo("Graduate date Year Entered : " + endYear);
			
			clickElement(eduGraduationDateNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			wait(2);
			selectDropDown(degreeTypeDropList, degreeType, "Degree / Certificate Type selected");
			logStepInfo("Degree / Certificate Type selected : " + degreeType);
			
			clickElement(eduDegreeTypeNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(eduStartSlideCalendar, "Start Education");
			logStepInfo("Start Education field clicked : " + "Start Education");
			EnterText(eduStartSlideCalendar, "Start Education Month", startMonth);
			logStepInfo("Start Education Month Entered : " + startMonth);

			driver.findElement(eduStartSlideCalendar).sendKeys(Keys.TAB);
			
			driver.findElement(eduStartSlideCalendar).sendKeys(startYear);
			logStepInfo("Start Education Year Entered : " + startYear);
			
			clickElement(eduEndSlideCalendar, "End Education");
			logStepInfo("End Education field clicked : " + "End Education");
			EnterText(eduEndSlideCalendar, "End Education Month", endMonth);
			logStepInfo("End Education Month Entered : " + endMonth);

			driver.findElement(eduEndSlideCalendar).sendKeys(Keys.TAB);
			
			driver.findElement(eduEndSlideCalendar).sendKeys(endYear);
			logStepInfo("End Education Year Entered : " + endYear);
			
			clickElement(eduDateNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(studyField, "Study Name");
			EnterText(studyField, "Study Name", fieldOfStudy);
			logStepInfo("Study Name Entered : " + fieldOfStudy);
			
			clickElement(eduStudytBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(eduNoOtherDegreeBtn, "No");
			logStepInfo("No Button clicked : " + "No");
			
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
