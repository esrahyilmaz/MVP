package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CASelfRegistrationPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	public By selfContractorLink = By.xpath("(//*[@id=\"clickhere_text\"]/a)[2]");
	public By legalFirstNameTxt = By.xpath("//*[@id=\"firstName\"]");
	public By legalMiddleNameTxt = By.xpath("//*[@id=\"middleName\"]");
	public By legalLastNameTxt = By.xpath("//*[@id=\"lastName\"]");
	public By middleNameRadio = By
			.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[7]/td[2]/input[1]");
	public By suffixTxt = By.xpath("//*[@id=\"nameSuffix\"]");
	public By DOBTxt = By.xpath("//*[@id=\"dob\"]");
	public By screeningRegulatoryDDL = By.xpath("//*[@id=\"ref2\"]");
	public By screeningQualifiedTxt = By.xpath("//*[@id=\"ref1\"]");
	public By fieldNumber3DDL = By.xpath("//*[@id=\"userField3\"]");
	public By address1Txt = By.xpath("//*[@id=\"addressForm.addrLine1\"]");
	public By citytxt = By.xpath("//*[@id=\"addressForm.cityName\"]");
	public By stateDDL = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[21]/td[2]/select");
	public By zipTxt = By.xpath("//*[@id=\"addressForm.zipCode\"]");
	public By continueBtn = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[24]/td[2]/input");
	public By msgTxt = By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[5]/td/b");
	public By nextBtn = By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[10]/td/input");
	public By yesBtn = By
			.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td[1]/input");
	public By createProfileLbl = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[3]/td/b");
	public By mockLbl = By
			.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr/td/table/tbody/tr[2]/td/b");
	public By printBtn = By.xpath("/html/body/table[2]/tbody/tr[4]/td/input");

	public By userIdTxt = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[4]/td[2]/input");
	public By passwordTxt = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[5]/td[2]/input");
	public By repasswordTxt = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[6]/td[2]/input");
	public By EmailTxt = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[7]/td[2]/input");
	public By secretAnswerTxt = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[10]/td[2]/input");
	public By secretQuestionDDL = By
			.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[9]/td[2]/select");

	public void selfRegistration() throws Exception {
		
		try {
		String FirstName = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
		String LastName = _dataRepo.getData("LastName") + Random_StringGenerator(8);
		String MiddleName = _dataRepo.getData("MiddleName") + Random_StringGenerator(8);

		EnterText(legalFirstNameTxt, "First Name added to textbox", FirstName);
		EnterText(legalLastNameTxt, "Last Name added to textbox", LastName);
		EnterText(legalMiddleNameTxt, "First Name added to textbox", MiddleName);
		clickElementWithWait(middleNameRadio, "Click on Yes Middle Name button");
		EnterText(suffixTxt, "suffix added to textbox", _dataRepo.getData("Suffix"));
		EnterText(DOBTxt, "suffix added to textbox", _dataRepo.getData("DOB"));
		EnterText(screeningQualifiedTxt, "suffix added to textbox", _dataRepo.getData("QualifiedScreening"));
		selectDropDown(screeningRegulatoryDDL, _dataRepo.getData("RegulatoryScreening"),
				"Selected Regulatory from Drop Down");
		selectDropDown(fieldNumber3DDL, _dataRepo.getData("fieldNumber3"), "Selected Field Nmuber3 from Drop Down");
		EnterText(address1Txt, "Address added to textbox", (_dataRepo.getData("Address")));
		EnterText(citytxt, "city added to textbox", (_dataRepo.getData("City")));
		selectDropDown(stateDDL, _dataRepo.getData("State"), "Selected Vendor State from Drop Down");
		EnterText(zipTxt, "Zip code added to textbox", (_dataRepo.getData("ZipCode")));

		logStepInfo("Self Registration completed!!!");
		reportLog(Status.PASS,"Self Registration completed!!!", true);

		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in selfRegistration():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in selfRegistration():- "+ex.getMessage(), true);
		}

	}
	

	public void profileRegistration()  throws Exception{
		try {
		String UserName = _dataRepo.getData("UserID") + Random_StringGenerator(5);
		EnterText(userIdTxt, "User Name entered", UserName);
		EnterText(passwordTxt, "Password Entered", PropertyFileReader.getProperty("CustHDPassword"));
		EnterText(repasswordTxt, "Password Re-Entered", PropertyFileReader.getProperty("CustHDPassword"));
		EnterText(EmailTxt, "Email ID Entered", _dataRepo.getData("Email"));
		selectDropDown(secretQuestionDDL, _dataRepo.getData("secretQuestion"), "Secret Question selected");
		EnterText(secretAnswerTxt, "Answer Entered", _dataRepo.getData("secretAnswer"));
		
		logStepInfo("Profile Registration completed!!!");
		reportLog(Status.PASS,"Profile Registration completed!!!", true);

		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in profileRegistration():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in profileRegistration():- "+ex.getMessage(), true);
		}
	}

}
