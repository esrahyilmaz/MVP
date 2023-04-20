package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUICreatePerson extends BaseClass {
	
	By peopleIcon = By.xpath("(//*[contains(@data-icon, 'id-badge')])[last()]");
	By peopleiconSection = By.xpath("//*[contains(@data-icon,'id-badge')])[last()-1]");
	
	By personFirstName = By.xpath("//*[contains(@formcontrolname, 'firstName')]");
	By personLastName = By.xpath("//*[contains(@formcontrolname, 'lastName')]");
	By personMiddleName = By.xpath("//*[contains(@formcontrolname, 'middleName')]");
	By callingCode = By.xpath("//select[@id='calling-code']");
	By phoneNum = By.xpath("//input[@id='phoneNumber']");

	By personEmail = By.xpath("//input[@data-xf-qa-id='VW-POPI-PEA']");
	By personConfirmEmail = By.id("emailAddressConfirm");
	By UDF1 = By.xpath("//input[@data-xf-qa-id='CF-UDF-IDX-1']");
	By UDF2 = By.xpath("//input[@data-xf-qa-id='CF-UDF-IDX-2']");
	By personCountry = By.xpath("//*[(@id = 'country-field')]");
	By personCity = By.xpath("//*[(@id = 'city')]");
	By personState = By.id("region-field");
	
	//EA Person page
	By eaCountry = By.xpath("//select[@id='ea-country-field']");
	By eaAddress = By.xpath("//input[@placeholder='Address Line 1 *']");
	By eaCity = By.xpath("//input[@id='ea-city']");
	By eaState = By.xpath("//select[@id='state-field']");
	By eaZipCode = By.xpath("//input[@data-xf-qa-id='PI-WPCODE']");
	
    By EADOB= By.xpath("//fadv-date-picker[@data-xf-qa-id='VW-POPI-DOB']");
	
	By SSNCreatePerson= By.xpath("//input[@id='documentNumber']");
	By ConfirmSSNCreatePerson= By.xpath("//input[@id='confirmDocumentNumber']");
	
	By identifyCountry = By.xpath("//div[@class='form-row']//select[@id='country-field']");
	By identifyDocumentType = By.xpath("//select[@id='documentType']");
	
	
	By middleNameYesButton = By.xpath("//*[@data-xf-qa-id='VW-POPS-MIDDLE-RADIO-Y']");
	By middleNameNoButton = By.xpath("//*[@data-xf-qa-id='VW-POPS-MIDDLE-RADIO-N']");
	By MiddleName = By.xpath("//input[@id='bc-primary-middle-name-text']");
	By SecondaryMiddleName = By.xpath("//input[@id='bc-secondary-middle-name-text']");
	By PhoneNumber =By.xpath("//input[@id='bc-primary-phone-text']");
	By SecondaryPhoneNumber =By.xpath("//input[@id='bc-secondary-phone-text']");
	By bbMiddleName = By.xpath("//input[@id='bb-middle-text']");
	By BusinessContaMiddleName = By.xpath("//input[@id='middleNameYes']");
	By BusinessContaSecondaryMiddleName = By.xpath("//input[@id='secondaryMiddleNameYes']");
	By personNextButton =  By.cssSelector(".btn.btn-primary.btn-order.ml-1");
	By personCancelButton =  By.xpath("//button[@data-xf-qa-id='VW-POPI-BTN-CANCEL']");
}