package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import seleniumhelper.BaseClass;

public class CAPersonStatus1 extends BaseClass{
	ExcelReader _dataRepo=new ExcelReader();
	CAAddPerson caPerson= new CAAddPerson();
	CAOneToManyHD caOneToMany= new CAOneToManyHD();
	public static String randomFirstName=null;
	public static String randomUpdatedName=null;
	public static String ssnNumber=null;
	int count =0;
	public static String fName = randomFirstName;
	public static String ssnExisting;
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	
	By beginOrderProcessBtn=By.xpath("//input[@name='orderBGC']");
	By personStatusLbl=By.xpath("/html/body/table/tbody/tr/td[2]/div/b");
	 By editInformation_Btn	= By.xpath("//input[@name='edit']");
	 By beginOrderProcess_Btn	= By.xpath("//input[@name='orderBGC']");
	 By submitBadge_Btn	= By.xpath("//input[@name='submitBP']");		
	
	 By titlePersonStatusPage	= By.xpath("//b[contains(text(),'Person Status Detail')]");
	 
	 
	// submit photo badge
	 By choose_Btn	= By.xpath("//*[@id='uploadBadgePhotoForm']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input[1]");
	 By uploadPhoto_Btn	= By.xpath("//input[@value='Upload Photo']");
	 By previous_Btn	= By.xpath("//input[@value='Previous']");
	 
	 // hidden ssn
	
	 By ssn_Hidden	= By.xpath("//input[@type='hidden' and @name='isSSNRequired']");
	 
	 //Methods===================================================================================================
	 public void addPhotoBadgeHD() {
			try {
		
			clickElementWithWait(submitBadge_Btn, "click to submit photo badge");
				
			driver.findElement(choose_Btn).sendKeys("C:\\Users\\sharmabh\\Pictures\\Saved Pictures\\download.jpg");

			clickElementWithWait(uploadPhoto_Btn,"click to upload photo");
			clickElementWithWait(previous_Btn, "click to go back on person status");
			reportLog(Status.PASS, "Photo badge is added", true);

			Boolean status = verifyElementPresence(beginOrderProcess_Btn);
			reportLog(Status.PASS, "Begin order process button is present", true);

			System.out.println(status);
			takeScreenshot();
		}catch(Exception e) {
		
	
			}
		}
	 
	 public void editPersoninformationHD() {
		 try {
				if(randomFirstName==null) { 
					 randomFirstName = _dataRepo.getData("firstName")+Random_StringGenerator(4);
					 ssnNumber = "878" + Random_NumberGenerator(6);
						
						fName=randomFirstName ;
						ssnExisting=ssnNumber;
						System.out.println("print fname "+ fName);
						}
						wait(2);
					
					clickElementWithWait(editInformation_Btn, "click on the edit information button");
					
					EnterText(caPerson.legalfirstName_field, "enter first name",randomFirstName ); 
					EnterText(caPerson.legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
					wait(2);
					clickElementWithWait(caPerson.middleNameYes_radioBtn, "click on middle name yes radion button");
					EnterText(caPerson.middleName, "enter middle name", _dataRepo.getData("middleName"));
					EnterText(caPerson.ssn, "enter ssn", ssnNumber);
				
					EnterText(caPerson.dob, "enter dob", _dataRepo.getData("dob"));
					EnterText(caPerson.email, "enter email", _dataRepo.getData("email"));	
					selectDropDownByValue(caPerson.typeHomeDepo, "E", "click to select the type");
					selectDropDownByIndex(caPerson.vendorLocations_drpdown, "1", "location");
					EnterText(caPerson.address1_field, "enter address details", _dataRepo.getData("address1"));	
					EnterText(caPerson.cityHomeDepo_txt, "enter city name", _dataRepo.getData("city"));
					selectDropDownByValue(caPerson.state_dropdown, _dataRepo.getData("stateCode"),"select state");
					EnterText(caPerson.zipCode, "enter zip code", _dataRepo.getData("pin")); 	
					wait(2);
					takeScreenshot();
					 	
					clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
					wait(1);
					if(driver.findElement(caPerson.ignoreAddress_chkBox).isDisplayed()) {
						clickElementWithWait(caPerson.ignoreAddress_chkBox, "click on ignore address checkbox");
						clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
					}
					wait(2);
					takeScreenshot();
					Assert.assertTrue("Person should be added and it should navigate to person status page",driver.findElement(titlePersonStatusPage).isDisplayed() );
					reportLog(Status.PASS, "Person information is edited", true);

					
		 }catch(Exception e) {
			 
		 }
	 }
	
	 public void validateEditInformationHD() {
		 try {
			 clickElementWithWait(editInformation_Btn, "click on the edit information button");
			String firstName = driver.findElement(caPerson.legalfirstName_field).getAttribute("readonly");
			String lastName = driver.findElement(caPerson.legalLastName_field).getAttribute("readonly");
			String middleName = driver.findElement(caPerson.middleName).getAttribute("readonly");
			String ssn = driver.findElement(ssn_Hidden).getAttribute("type");
			String dob = driver.findElement(caPerson.dob).getAttribute("readonly");
			String address1 = driver.findElement(caPerson.address1_field).getAttribute("readonly");
			
			System.out.println("print read only values>>>>>>>>>>>>>>>> "+ firstName+lastName+middleName+ssn+dob+address1);
		 		Assert.assertEquals(firstName,"true");
		 		Assert.assertEquals(lastName,"true");
		 		Assert.assertEquals(middleName,"true");
		 		Assert.assertEquals(ssn,"hidden");
		 		Assert.assertEquals(dob,"true");
		 		
		 	}catch(Exception e) {
				
		 	}
	 }
}
