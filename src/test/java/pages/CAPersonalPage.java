package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAPersonalPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	public By personInformationLbl = By.xpath("/html/body/table/tbody/tr/td[2]/div/b");

	public By aliasNoRadio = By.xpath("//*[@id='peopleFormTable']/tbody/tr[1]/td/table/tbody/tr[6]/td[2]/input[2]");
	public By aliasYRadio = By.xpath("//*[@id='peopleFormTable']/tbody/tr[1]/td/table/tbody/tr[6]/td[2]/input[1]");
	public By aliasFirstNameTxt = By.xpath("//*[@id='aliasForm.firstName']");
	public By aliasMiddleNameTxt = By.xpath("//*[@id='aliasForm.middleName']");
	public By aliasLastNameTxt = By.xpath("//*[@id='aliasForm.lastName']");
	public By suffixTxt = By.xpath("//*[@id='aliasForm.suffix']");
	public By addAliasNameBtn = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[1]/td/table/tbody/tr[15]/td/table/tbody/tr[2]/td/b/input");

	public By schoolNameTxt = By.xpath("//*[@id='eduForm.schoolName']");
	public By currentAttendingNRadio = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[6]/td[4]/input[2]");
	public By currentAttendingYRadio = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[6]/td[4]/input[1]");
	public By campustxt = By.xpath("//*[@id='eduForm.campusName']");
	public By educationTypeDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[2]/td/table/tbody/tr[7]/td[4]/select");
	public By phoneTxt = By.xpath("//*[@id='eduForm.phone']");
	public By studyTxt = By.xpath("//*[@id='eduForm.major']");
	public By addressTxt = By.xpath("//*[@id='eduForm.addressForm.addrLine1']");
	public By degreeDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[2]/td/table/tbody/tr[9]/td[4]/select");
	public By cityTxt = By.xpath("//*[@id='eduForm.addressForm.cityName']");
	public By gpaTxt = By.xpath("//*[@id='eduForm.gpa']");
	public By stateDdl = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[11]/td[2]/select");
	public By fromTxt = By.xpath("//*[@id='eduForm.from']");
	public By toTxt = By.xpath("//*[@id='eduForm.to']");
	public By countryDdl = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[12]/td[2]/select");
	public By graduateYRadio = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[13]/td[2]/input[1]");
	public By graduateNRadio = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[13]/td[2]/input[2]");
	public By graduateDate = By.xpath("//*[@id='eduForm.graduationdate']");
	public By addEducationEntryBtn = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[15]/td/table/tbody/tr[2]/td/b/input");

	public By addressNRadio = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input[2]");
	public By addressYRadio = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input[1]");
	public By countyPrevDdl = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[6]/td[2]/select");
	public By addressPrevTxt = By.xpath("//*[@id='prevAddressForm.addrLine1']");
	public By cityPrevTxt = By.xpath("//*[@id='prevAddressForm.cityName']");
	public By statePrevDdl = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[10]/td[2]/select");
	public By zipCodeTxt = By.xpath("//*[@id='prevAddressForm.zipCode']");
	public By addPrevAddressBtn = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[12]/td/table/tbody/tr[2]/td/b/input");

	public By nxtBtn = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/b/input");
	public By nxtBtn1 = By.xpath("//input[@value='NEXT']");
	public By dlNumberTxt = By.xpath("//*[@id=\"driverLicNum\"]");
	public By dlStateDdl = By.xpath("//*[@id='peopleFormTable']/tbody/tr/td/table/tbody/tr[5]/td[2]/select");
	public By AddressSearchTxt = By.xpath("//*[@id=\"sitesSearchAddress\"]");
	public By TerminationDate=By.xpath("//*[@id='t_trigger_c']");
	public By CalenderSelect=By.xpath("//*[@class='day selected today']");
	public By CalenderSelectWeekend=By.xpath("//*[@class='day selected today weekend']");
	public By EditInfoBtn=By.xpath("//*[@value=\"EDIT INFORMATION\"]");
	public By activeStatusDdl = By.xpath("//*[@id=\"inactiveReasonCd\"]");
	public By saveBtn=By.xpath("//*[@value=\"SAVE\"]");
	
	
	
	/**
	 * @author mishrbik
	 * @category Change the person Status  
	 * @param status of the person which need to change 
	 **/
	
	public void ChangePersonStatus(String status) throws Exception{
			try {
			clickElementWithWait(EditInfoBtn, "click on edit informaiton button");
			if(status.equalsIgnoreCase("Terminated")) {
				clickElement(TerminationDate, "calendar Clicked");
				if(verifyElementPresence(CalenderSelect)) {
					clickElementWithWait(CalenderSelect, "Calendra Selected");
				}else {
					clickElementWithWait(CalenderSelectWeekend, "Calendra Selected");
				}
				
			}
			selectDropDown(activeStatusDdl, status, "click to select the status");
			clickElementWithWait(saveBtn, "click to save informaiton");
		
			reportLog(Status.PASS,"Person status changed to "+status, true);
			logStepInfo("Person status changed to "+status);
			}
			catch(Exception e) {
				e.getMessage();
				logStepInfo("Failed - to changed status " + e.getMessage());
				reportLog(Status.FAIL, "Failed - to changed status " + e.getMessage(), true);
				scenarioFailed();
				}
	}
	
	
	
	public void addPersonInfo() throws Exception{
		try {
		String FirstName = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
		String LastName = _dataRepo.getData("LastName") + Random_StringGenerator(8);
		String MiddleName = _dataRepo.getData("MiddleName") + Random_StringGenerator(8);
		String phoneNumber = Random_NumberGenerator(10);

		
		
		// if(_dataRepo.getData("alias").equalsIgnoreCase("Yes")) {
		clickElementWithWait(aliasYRadio, "Click on Yes alias Name button");
		EnterText(aliasFirstNameTxt, "First Name added to textbox", FirstName);
		EnterText(aliasMiddleNameTxt, "Middle Name added to textbox", MiddleName);
		EnterText(aliasLastNameTxt, "Last Name added to textbox", LastName);
		EnterText(suffixTxt, "Name suffix added to textbox", (_dataRepo.getData("Suffix")));
		clickElementWithWait(addAliasNameBtn, "Add Alias Name Button Clicked");
		/*
		 * } else { clickElementWithWait(aliasNoRadio,
		 * "Click on No alias Name button"); }
		 */

		EnterText(schoolNameTxt, "school Name added to textbox", (_dataRepo.getData("SchoolName")));
		EnterText(campustxt, "campus added to textbox", (_dataRepo.getData("Campus")));
		EnterText(phoneTxt, "phone number added to textbox", phoneNumber);
		EnterText(studyTxt, "study added to textbox", (_dataRepo.getData("Study")));
		EnterText(addressTxt, "address added to textbox", (_dataRepo.getData("Address")));
		EnterText(cityTxt, "city added to textbox", (_dataRepo.getData("City")));
		selectDropDown(stateDdl, _dataRepo.getData("State"), "Selected state from Drop Down");
		selectDropDown(countryDdl, _dataRepo.getData("Country"), "Selected country from Drop Down");
		clickElementWithWait(graduateYRadio, "Graduated Yes radio Button");
		EnterText(graduateDate, "Graduation Date added to textbox",
				_dataRepo.getData("GraduateDate"));

		/*
		 * if(_dataRepo.getData("CurrentAttending").equalsIgnoreCase("Yes")) {
		 * clickElementWithWait(currentAttendingYRadio,
		 * "Click on Yes Currently attending button"); } else {
		 */
		clickElementWithWait(currentAttendingNRadio, "Click on No Currently attending button");
		// }
		selectDropDownByIndex(educationTypeDdl, "2", "Selected Education Type from Drop Down");
		EnterText(studyTxt, "study added to textbox", _dataRepo.getData("Study"));
		selectDropDownByIndex(degreeDdl, "2", "Selected Personal Degree from Drop Down");
		EnterText(gpaTxt, "Name added to textbox", (_dataRepo.getData("Gpa")));
		EnterText(fromTxt, "Name added to textbox", (_dataRepo.getData("From")));
		EnterText(toTxt, "Name added to textbox", (_dataRepo.getData("To")));
		clickElementWithWait(addEducationEntryBtn, "Add Education Entry Button Clicked");

		// if(_dataRepo.getData("AddressOption").equalsIgnoreCase("Yes") {
		clickElementWithWait(addressYRadio, "Click on Yes Currently attending button");
		// selectDropDown(countyPrevDdl, _dataRepo.getData("County"),
		// "Selected Pevious Country from Drop Down");
		EnterText(addressPrevTxt, "Previous Address added to textbox", _dataRepo.getData("Address"));
		EnterText(cityPrevTxt, "city Name added to textbox", _dataRepo.getData("City"));
		selectDropDown(statePrevDdl, _dataRepo.getData("State"), "State Name added to textbox");
		EnterText(zipCodeTxt, "zip code added to textbox", _dataRepo.getData("ZipCode"));
		clickElementWithWait(addPrevAddressBtn, "Add Previous Address Button Clicked");

		/*
		 * } else { clickElementWithWait(currentAttendingNRadio,
		 * "Click on No Currently attending button"); }
		 */
	
		logStepInfo("Add Person Information completed!!!");
		reportLog(Status.PASS,"Add Person Information completed!!!", true);

		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in addPersonInfo():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in addPersonInfo():- "+ex.getMessage(), true);
		}		
	}
}
