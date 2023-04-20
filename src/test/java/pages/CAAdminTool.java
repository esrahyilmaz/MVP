package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import seleniumhelper.BaseClass;

public class CAAdminTool extends BaseClass {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	ExcelReader _dataRepo = new ExcelReader();
	public static String mobile=Random_NumberGenerator(10);
	By userName = By.id("username");
	By password = By.id("password");
	By login_btn = By.xpath("//div/span/input[@type='submit' and @value='Login']");
	// search customer
	By searchCustomer_txt = By.id("searchName");
	By search_btn = By.name("_action_Search");
	By lockheedMartin_link = By
			.xpath("//td[contains(text(),'LOCKHEED MARTIN')]/preceding-sibling::td/a[contains(text(),'14')]");
	By amazon_link = By
			.xpath("//td[contains(text(),'Amazon Air Freight Partners')]/preceding-sibling::td/a[contains(text(),'2935')]");
	By aspen_link = By
			.xpath("//td[contains(text(),'ASPEN GROVE SOLUTIONS')]/preceding-sibling::td/a[contains(text(),'1281')]");
	By property_xtdforce_registration_ui= By
			.xpath("//td[contains(text(),'XTDFORCE_REGISTRATION_UI')]/preceding-sibling::td/a");
	By enable_pre_registration_page_link = By.xpath(
			"//td[contains(text(),'ENABLE_PRE_REGISTRATION_PAGE')]/preceding-sibling::td/a[contains(text(),'10701')]");
	By edit_btn = By.name("_action_Edit");
	By value_field = By.id("VCP_VALUE");
	By update_btn = By.name("_action_update");
	By home_Btn = By.xpath("/html/body/div[5]/span[1]/a");
	// go back in page
	By pre_registraion_page_email_link = By.xpath(
			"//td[contains(text(),'PRE_REGISTRATION_PAGE_EMAIL')]/preceding-sibling::td/a[contains(text(),'10702')]");
	By pre_registraion_page_contact_num_link = By.xpath(
			"//td[contains(text(),'PRE_REGISTRATION_PAGE_CONTACT_NUM')]/preceding-sibling::td/a[contains(text(),'10703')]");
	// By login_btn = By.xpath("(//input[@value='Login']");

	// ========================================method=======================================================
	public void loginAdminTool() {
		try {
			System.out.println("User Name is ::" + _dataRepo.getData("page.UserName"));
			EnterText(userName, "enter username in admin tool", _dataRepo.getData("page.UserName"));
			EnterText(password, "enter password in admin tool", _dataRepo.getData("page.Password"));
			clickElementWithWait(login_btn, "click on login button");
		
			logStepInfo("log in to Admin tool completed!!!");
			reportLog(Status.PASS,"log in to Admin tool completed!!!", true);

			
		}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in loginAdminTool():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in loginAdminTool():- "+ex.getMessage(), true);
			}
	}

	public void selectCustomer() {
		try {
			EnterText(searchCustomer_txt, "enter customer name to search", _dataRepo.getData("organizationName"));
			clickElementWithWait(search_btn, "click on search button");
			clickElementWithWait(lockheedMartin_link, "click on the link to select lockheed Martin");
			reportLog(Status.PASS, "Customer is selected as Lockheed Martin", true);

			logStepInfo("Customer selection completed!!!");
			reportLog(Status.PASS,"Customer selection completed!!!", true);

			
		}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in selectCustomer():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in selectCustomer():- "+ex.getMessage(), true);
			}
	}
	
	public void selectCustomer(String customer) {
		try {
			EnterText(searchCustomer_txt, "enter customer name to search", _dataRepo.getData("organizationName"));
			clickElementWithWait(search_btn, "click on search button");
			if(customer.equalsIgnoreCase("Amazon Air Freight Partners")) {
				clickElementWithWait(amazon_link, "click on the link to select Amazon Air Freight Partners");
				reportLog(Status.PASS, "Customer is selected as Amazon Air Freight Partners", true);
			}
			else if(customer.equalsIgnoreCase("ASPEN GROVE SOLUTIONS")) {
				clickElementWithWait(aspen_link, "click on the link to select ASPEN GROVE SOLUTIONS");
				reportLog(Status.PASS, "Customer is selected as ASPEN GROVE SOLUTIONS", true);
			}

			logStepInfo("Customer selection completed!!!");
			reportLog(Status.PASS,"Customer selection completed!!!", true);

			
		}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in selectCustomer():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in selectCustomer():- "+ex.getMessage(), true);
			}
	}

	public void enableAndDisable_pre_registration_page(String yesOrNo) {
		try {
			clickElementWithWait(enable_pre_registration_page_link, "click on login button");
			clickElementWithWait(edit_btn, "click on edit button");
			driver.findElement(value_field).clear();
			if (yesOrNo == "Y") {
				EnterText(value_field, "enter Y in value", "Y");
				clickElementWithWait(update_btn, "click to update");
				
			logStepInfo("Enabled pre registration!!!");
			reportLog(Status.PASS,"Enabled pre registration!!!", true);

			} 
			else if (yesOrNo == "N") {
				EnterText(value_field, "enter Y in value", "N");
				clickElementWithWait(update_btn, "click to update");
			
				logStepInfo("Pre Registration Configuration Done!! ");
				reportLog(Status.PASS, "Disabled pre registration ", true);
			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in enableAndDisable_pre_registration_page():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in enableAndDisable_pre_registration_page():- "+ex.getMessage(), true);

		}
	}
	
	public void enableAndDisable_xtdforce_registration_ui(String yesOrNo) {
		try {
			clickElementWithWait(property_xtdforce_registration_ui, "click on login button");
			clickElementWithWait(edit_btn, "click on edit button");
			driver.findElement(value_field).clear();
			if (yesOrNo == "Y") {
				EnterText(value_field, "enter Y in value", "Y");
				clickElementWithWait(update_btn, "click to update");
				
			logStepInfo("Enabled pre registration!!!");
			reportLog(Status.PASS,"Enabled pre registration!!!", true);

			} 
			else if (yesOrNo == "N") {
				EnterText(value_field, "enter Y in value", "N");
				clickElementWithWait(update_btn, "click to update");
			
				logStepInfo("Pre Registration Configuration Done!! ");
				reportLog(Status.PASS, "Disabled pre registration ", true);
			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in enableAndDisable_pre_registration_page():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in enableAndDisable_pre_registration_page():- "+ex.getMessage(), true);

		}
	}

	public void pre_registraion_page_email() {
		try {
			clickElementWithWait(pre_registraion_page_email_link, "click on email button");
			clickElementWithWait(edit_btn, "click on edit button");
			driver.findElement(value_field).clear();
			EnterText(value_field, "enter email in value", _dataRepo.getData("Email"));
			clickElementWithWait(update_btn, "click to update");

			reportLog(Status.PASS, "Email updated as " + _dataRepo.getData("Email"), true);
			logStepInfo("Pre Registration Configuration Done!! ");

		} catch (Exception ex) {
			logStepInfo("Exception occured in pre_registraion_page_email():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in pre_registraion_page_email():- "+ex.getMessage(), true);
		}
	}

	public void pre_registraion_page_contact_num() {
		try {
			clickElementWithWait(home_Btn, "Clicked on Home button");
			selectCustomer();
			clickElementWithWait(pre_registraion_page_contact_num_link, "click on contact link");
			clickElementWithWait(edit_btn, "click on edit button");
			driver.findElement(value_field).clear();
			EnterText(value_field, "enter contact number in value", mobile);
			clickElementWithWait(update_btn, "click to update");
			
			logStepInfo("Pre Registration Configuration Done!! ");
			reportLog(Status.PASS, "Contact number updated as " + mobile, true);

		} catch (Exception ex) {
			logStepInfo("Exception occured in pre_registraion_page_contact_num():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in pre_registraion_page_contact_num():- "+ex.getMessage(), true);

		}
	}

}
