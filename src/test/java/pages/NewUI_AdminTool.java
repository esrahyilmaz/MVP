package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import seleniumhelper.BaseClass;

public class NewUI_AdminTool extends BaseClass {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	ExcelReader _dataRepo = new ExcelReader();
	public static String mobile = Random_NumberGenerator(10);

	By userName = By.id("username");
	By password = By.id("password");
	By login_btn = By.xpath("//div/span/input[@type='submit' and @value='Login']");

	// search customer
	By searchCustomer_txt = By.id("searchName");
	By search_btn = By.name("_action_Search");

	// editing property
	By customer_link = By.xpath("//td[contains(text()," + CustomerName + ")]/preceding-sibling::td/a");
	By edit_btn = By.name("_action_Edit");
	By value_field = By.id("VCP_VALUE");
	By update_btn = By.xpath("//input[@class= 'save']");
	By home_Btn = By.xpath("/html/body/div[5]/span[1]/a");

	public void loginAdminTool(String env) {
		try {
			
			if (env.equalsIgnoreCase("QCSA")) {
				EnterText(userName, "username in admin tool", PropertyFileReader.getProperty("QSCAAdminToolUserName"));
				EnterText(password, "password in admin tool", PropertyFileReader.getProperty("QSCAAdminToolPassword"));
			} else if (env.equalsIgnoreCase("UAT")) {
				EnterText(userName, "username in admin tool", PropertyFileReader.getProperty("UATAdminToolUserName"));
				EnterText(password, "password in admin tool", PropertyFileReader.getProperty("UATAdminToolPassword"));
			}
			
			clickElementWithWait(login_btn, "login button");
			logStepInfo("log in to Admin tool completed!!!");
			reportLog(Status.PASS, "log in to Admin tool completed!!!", true);
		} catch (Exception ex) {
			logStepInfo("Exception occured in loginAdminTool():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in loginAdminTool():- " + ex.getMessage(), true);
		}
	}

	public void selectCustomer() {
		try {
			EnterText(searchCustomer_txt, "search for Customer", CustomerName);
			clickElementWithWait(search_btn, "search button");
			clickElementWithWait(customer_link, "the link to select customer: " + CustomerName);
			CustomerURL = driver.getCurrentUrl();
			reportLog(Status.PASS, "Customer is selected as: " + CustomerName, false);
			logStepInfo("Customer selection completed!!!");
			reportLog(Status.PASS, "Customer selection completed!!!", true);
		} catch (Exception ex) {
			logStepInfo("Exception occured in selectCustomer():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in selectCustomer():- " + ex.getMessage(), true);
		}
	}

	public void selectCustomer(String customer) {
		try {

			EnterText(searchCustomer_txt, "search for Customer", customer);
			clickElementWithWait(search_btn, "search button");
			clickElementWithWait(customer_link, "the link to select: " + customer);
			CustomerURL = driver.getCurrentUrl();
			reportLog(Status.PASS, "Customer is selected as " + customer, false);
			logStepInfo("Customer selection completed!");
		} catch (Exception ex) {
			logStepInfo("Exception occured in selectCustomer():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in selectCustomer():- " + ex.getMessage(), false);
		}
	}

	public void changePropertyValue(String propertyName, String propertyValue) {
		try {

			By propertyXpath = By.xpath("//td[contains(text(),'" + propertyName + "')]/preceding-sibling::td/a");
			By propertyXpathSelect = By.xpath("//select[@id = 'VCP_VALUE']");
			clickElementWithWait(propertyXpath, "update Property: " + propertyName);
			clickElementWithWait(edit_btn, "edit button");
					
			if (propertyName.contains("PROGRAM_PAYMENT_METHOD")) {
				if (propertyValue.contains("Credit Card")) {
					selectDropDown(propertyXpathSelect, "Credit Card", propertyValue);
					}
				else if (propertyValue.contains("Vendor Invoice")) {
					selectDropDown(propertyXpathSelect, "Vendor Invoice", propertyValue);
				} 		
				else {
					selectDropDown(propertyXpathSelect, "Sponsor Invoice", propertyValue);
				} 
				propertyValueAT = propertyValue;
				clickElementWithWait(update_btn, "update");
			}
			else {
				driver.findElement(value_field).clear();
				EnterText(value_field, "property value field", propertyValue);
				clickElementWithWait(update_btn, "update");
			}
			logStepInfo("Property updated!");
			reportLog(Status.PASS, "Property updated: " + propertyName + "to: " + propertyValue, true);

			loadUrl(CustomerURL);

		} catch (Exception ex) {
			logStepInfo("Exception occured in changePropertyValue():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in changePropertyValue():- " + ex.getMessage(), true);

		}
	}

	public void edit_customer_preferences(String customerPreference, String preferenceValue) {
		try {

			By propertyXpath = By.xpath("//input[contains(@id, '"+customerPreference+"')]");
			clickElementWithWait(edit_btn, "edit button");
			EnterText(propertyXpath, "enter value", preferenceValue);
			clickElementWithWait(update_btn, "click to update");
								
			reportLog(Status.PASS, "Updated Customer preference :" + customerPreference, false);
			logStepInfo("Updated Customer preference :" + customerPreference);

		} catch (Exception ex) {
			logStepInfo("Exception occured in edit_customer_preferences():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in edit_customer_preferences():- " + ex.getMessage(), true);
		}
	}

	public void edit_package(String property, String value) {
		try {

			String packageName = _dataRepo.getData("Package");
			By package_link = By.xpath("//td[contains(text(),'" + packageName + "')]/preceding-sibling::td/a");
			clickElementWithWait(package_link, "the link to select package");
			clickElementWithWait(edit_btn, "edit button");
			
			if (property.equalsIgnoreCase("ADDITIONAL EXPENSE")) {
				By propertyXpath = By.xpath("//select[contains(@name, 'ADDTL_EXPENSE_FLAG')]");
				EnterText(propertyXpath, "package property field", value);

			} else if (property.equalsIgnoreCase("ADDITIONAL EXPENSE PRICE")) {
				By propertyXpath = By.xpath("//input[contains(@id, 'ADDTL_EXPENSE')]");
				EnterText(propertyXpath, "package property field", value);
			
			} else if (property.equalsIgnoreCase("PRICE")) {
				By propertyXpath = By.xpath("//input[contains(@id, 'VP_PRICE')]");
				EnterText(propertyXpath, "package property field", value);
			}
						
			clickElementWithWait(update_btn, "update");
			logStepInfo("Package roperty updated!");
			reportLog(Status.PASS, "Package property updated: " + property + "to: " + value, true);

			loadUrl(CustomerURL);
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in edit_package():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in edit_package():- " + ex.getMessage(), true);
		}
	}
}
