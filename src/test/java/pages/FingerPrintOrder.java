package pages;

import Utility.CurrentDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumhelper.BaseClass;


public class FingerPrintOrder extends BaseClass{
	
	private static By AddressTB=By.xpath("//*[@id='sitesSearchAddress']");
	private static By SearchBtn=By.xpath("//input[@value='Search']");
	private static By ScheduleLink=By.xpath("(//a[.='Schedule'])[2]");
	private static By SaveScheduleBtn=By.xpath("//*[@id='SaveScheduleButton']");
	private static By ChangeSiteBtn=By.xpath("//input[@value=''Change Site]");
	private static By OfferDateTB=By.xpath("//input[@name='OfferDate']");
	private static By RaceDD=By.xpath("//select[@name='Race']");
	private static By EyeColorDD=By.xpath("//select[@name='Eye_Color']");
	private static By HairColorDD=By.xpath("//select[@name='Hair_Color']");
	private static By PlaceOfBirthDD=By.xpath("//select[@name='Place_of_Birth']");
	private static By CitizenshipDD=By.xpath("//select[@name='Citizenship']");
	private static By DobTB=By.xpath("//input[@name='Date_of_Birth(MM/DD/YYYY)']");
	private static By HeightInFeetDD=By.xpath("//select[@name='Height_in_Feet']");
	private static By HeightInInchesDD=By.xpath("//select[@name='Height_in_Inches']");
	private static By WeightInPoundsTB=By.xpath("//input[@name='Weight_in_Pounds']");
	private static By GenderDD=By.xpath("//select[@name='Gender']");
	private static By PhotoIdTypeDD=By.xpath("//select[@name='Photo_Id_Type']");
	private static By PhotoIdWhereIssuedDD=By.xpath("//select[@name='Photo_Id_Where_Issued']");
	private static By PhotoIdNumberTB=By.xpath("//input[@name='Photo_Id_Number']");
	private static By NextBtn=By.xpath("//input[@value='Next']");
	private static By FpAppDateDD=By.xpath("//select[@name='FPRINTApptDate']");
	private static By FpAppTimeDD=By.xpath("(//th[.='Finger Print Appointment']/..//select)[3]");
	
//	private static By EmailAddressTB=By.xpath("//input[@name='emailAddress']");
//	private static By ConfirmEmailAddressTB=By.xpath("//input[@name='confirmEmailAddress']");
//	private static By PhoneNumberTB=By.xpath("//input[@name='phoneNumber']");
//	private static By NextBtn=By.xpath("//input[@value='NEXT']");
//	private static By DrugTestChkbox=By.xpath("//input[@id='INPUT_URIFULDOT']");
	
	public void schedule(String Race,String EyeColor,String HairColor,String PlaceOfBirth,String Citizenship,String Dob,String HeightInFeet,String HeightInInches, String WeightInPounds,String Gender,String PhotoIdType,String PhotoIdIssued,String PhotoIdNumber) throws Exception {
		WebElement Frame=driver.findElement(By.xpath("//iframe[@name='schPortletFrame']"));
		driver.switchTo().frame(Frame);
		String value =null;
		
		wait(30);
		
		if(verifyElementPresence(ChangeSiteBtn)) {
			EnterText(OfferDateTB, "Offer Date", CurrentDateTime.SystemDateMMDD());
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
			clickElement(ChangeSiteBtn, "Change Site");
			wait(30);
		}
			
		
		if(verifyElementPresence(AddressTB)) {
//			EnterText(AddressTB, "Address", "3655 Nantucket Island Dr, Port Orange, FL 32129, USA");
			EnterText(AddressTB, "Address", "4275 Johns Creek Pkwy STE B, Suwanee, GA 30024, USA");
		}
		
//		if(verifyElementPresence(DrugTestChkbox)) {
//			clickElement(DrugTestChkbox, "DrugTestCheckBox");
//		}
		if(verifyElementPresence(SearchBtn)) {
			clickElement(SearchBtn, "search");
		}
		wait(30);
		if(verifyElementPresence(ScheduleLink)) {
			clickElement(ScheduleLink, "schedule");
		}
		
		wait(20);
		
		value=Race;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(RaceDD, value, "Race");
		}
		
		value=EyeColor;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(EyeColorDD, value, "EyeColor");
		}
		
		value=HairColor;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(HairColorDD, value, "HairColor");
		}
		
		value=PlaceOfBirth;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(PlaceOfBirthDD, value, "PlaceOfBirth");
		}
		
		value=Citizenship;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(CitizenshipDD, value, "Citizenship");
		}
		
		value=Dob;
		if(!(value==null)|| !(value.isEmpty())) {
			EnterText(DobTB, "Dob", value);
		
		}
		
		
		value=HeightInFeet;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(HeightInFeetDD, value, "HeightInFeet");
		}
		
		value=HeightInInches;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(HeightInInchesDD, value, "HeightInInches");
		}
		
		value=WeightInPounds;
		if(!(value==null)|| !(value.isEmpty())) {
			EnterText(WeightInPoundsTB, "WeightInPounds", value);
		
		}
		
		value=Gender;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(GenderDD, value, "Gender");
		}
		
		value=PhotoIdType;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(PhotoIdTypeDD, value, "PhotoIdType");
		}
		
		value=PhotoIdIssued;
		if(!(value==null)|| !(value.isEmpty())) {
			selectDropDown(PhotoIdWhereIssuedDD, value, "PhotoIdIssued");
		}
		
		value=PhotoIdNumber;
		if(!(value==null)|| !(value.isEmpty())) {
			EnterText(PhotoIdNumberTB, "PhotoIdNumber", value);
		}
		clickElement(NextBtn, "Next");
		
		wait(20);
		if(verifyElementPresence(SaveScheduleBtn)) {
			EnterText(OfferDateTB, "Offer Date", CurrentDateTime.SystemDateMMDD());
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
		}
		wait(3);
		if(verifyElementPresence(FpAppDateDD)) {
			selectDropDownByIndex(FpAppDateDD, "2", "FpAppoinmentDate");
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
		}
		wait(3);
		if(verifyElementPresence(FpAppTimeDD)) {
			selectDropDownByIndex(FpAppTimeDD, "2", "FpAppoinmentTime");
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
		}
		wait(3);
		if(verifyElementPresence(SaveScheduleBtn)) {
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
			clickElement(SaveScheduleBtn, "save schedule");
		}
		wait(5);
		verifyTextPresence("Schedule has been tentatively saved.");
		
		driver.switchTo().parentFrame();
	}
	
		
		
		}
		
	

	
	
	


