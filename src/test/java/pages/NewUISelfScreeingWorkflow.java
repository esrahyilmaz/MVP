package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NewUISelfScreeingWorkflow extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();
	
	//SelfScreening Personal Information Page	
		 By PFirstName = By.xpath("//input[@data-xf-qa-id='PI-FN']");
		 By PLastName = By.xpath("//input[@data-xf-qa-id='VW-POPI-LLN']");
		 By PDOB = By.xpath("//input[@data-xf-qa-id='VW-POPI-DOB']");
		 By PDOBYearBox = By.xpath("//button[@class='current']");
		 By PDOBYear = By.xpath("(//td[@class='ng-star-inserted'])[1]");
		 By PDOBMonth = By.xpath("(//td[@class='ng-star-inserted'])[1]");
		 By PDOBDay = By.xpath("(//td[@class='ng-star-inserted'])[11]");
		 By PEmail = By.xpath("(//input[@data-xf-qa-id='VW-POPI-PEA'])[1]");
		 By PConfirmEmail = By.xpath("(//input[@data-xf-qa-id='VW-POPI-PEA'])[2]");
		 
		private By PCountryNameText = By.xpath("(//select[@id='country-field'])[1]");
		private By PAdress1 = By.xpath("(//input[@data-xf-qa-id='VW-POPI-CPEA'])[1]");
		private By PAddress2 = By.xpath("//input[@id='street-two-field']");
		private By PState = By.xpath("//select[@data-xf-qa-id='PI-WSTATE']");
		private By PCity = By.xpath("//input[@data-xf-qa-id='PI-WCITY']");
		private By PZipCode = By.xpath("//input[@data-xf-qa-id='PI-WPCODE']");
		
		//Identification Document
		private By PCountryNameText2 = By.xpath("(//select[@id='country-field'])[2]");
		private By PDocumentType = By.xpath("//select[@data-xf-qa-id='ID-WDOCTYPE']");
		private By PDocumentNumber = By.xpath("//input[@id='documentNumber']");
		private By PConfirmDocumentNumber = By.xpath("//input[@id='confirmDocumentNumber']");
		
		
		public void addPersonalInfo() throws Exception {

	   try {
		String PFirstNameText = _dataRepo.getData("first name") + Random_StringGenerator(3);
		String PLastNameText = _dataRepo.getData("last name") + Random_StringGenerator(3);
		String PEmailText = _dataRepo.getData("emailId");
		String PConfirmEmailText = _dataRepo.getData("emailId");
		
		String PCountryName = _dataRepo.getData("CountryName");
		String Address1 = _dataRepo.getData("Address1");
		String State = _dataRepo.getData("State");
		String City = _dataRepo.getData("City");
		String ZipCode = Random_NumberGenerator(5);
		
		String PCountryName2 = _dataRepo.getData("CountryName");
		String DocumentType = _dataRepo.getData("Document Type");
		String DocumentNumber = _dataRepo.getData("Document Number");
		String ConfirmDocumentNumber = _dataRepo.getData("Document Number");
		
		EnterText(PFirstName, "First Name entered", PFirstNameText);
		EnterText(PLastName, "Last Name Entered", PLastNameText);
		clickElement(PDOB, "DOB Entered");
		clickElement(PDOBYearBox, "DOB Year Selected");
		clickElement(PDOBYear, "DOB Year Selected");
		clickElement(PDOBMonth, "DOB Month Selected");
		clickElement(PDOBDay, "DOB Day Selected");
		
		EnterText(PEmail, "Email Entered", PEmailText);
		EnterText(PConfirmEmail, "Password Entered", PConfirmEmailText);
		selectDropDown(PCountryNameText, PCountryName, "country selected");
		EnterText(PAdress1, "Address is entered", Address1);
		selectDropDown(PState, State, "State/Region is Entered");
		EnterText(PCity, "City is entered", City);
		EnterText(PZipCode, "ZipCode is Entered", ZipCode);
		
		selectDropDown(PCountryNameText2, PCountryName2, "Identification country selected");
		selectDropDown(PDocumentType, DocumentType, "Document type selected");
		EnterText(PDocumentNumber, "Document number is entered", DocumentNumber);
		EnterText(PConfirmDocumentNumber, "Confirm document number is entered", ConfirmDocumentNumber);
	
		reportInfo("Add New user completed!!!");
		reportLog(Status.PASS, "Add New user completed!!!", true);
	   }catch (Exception ex) {
			reportInfo("Exception occured in addNewPeople():- " + ex.getMessage());
			reportLog(Status.FAIL, "Add New person Failed!!!:- " + ex.getMessage(), true);
		}
		}


}
