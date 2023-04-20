package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class AddUser extends BaseClass{

	private static By currentPasswordTB=By.xpath("//input[@name='currentPassword']");
	private static By userIdTB=By.xpath("//input[@name='userLoginId']");
	private static By newPasswordTB=By.xpath("//input[@name='password']");
	private static By reEnterNewPasswordTB=By.xpath("//input[@name='confirmPassword']");
	private static By firstNameTB=By.xpath("//input[@name='firstName']");
	private static By lastNameTB=By.xpath("//input[@name='lastName']");
	private static By emailTB=By.xpath("//input[@name='email']");
	private static By statusDD=By.xpath("//td[.='Status']/..//select");
	private static By RoleDD=By.xpath("//td[.='* Role']/..//select");
	private static By saveBTN=By.xpath("//input[@value='SAVE']");
	private static By passwordTB=By.id("passwordToShow");
	private static By confirmPasswordTB=By.id("confirmPasswordToShow");
	private static By resetBTN=By.xpath("//input[@value='RESET']");
	private static By secretQtnDD=By.xpath("//td[.='* Secret Question ']/..//select");
	private static By secretAnsTB=By.xpath("//input[@name='secretAnswer']");
	
	public void addUser(String UserID, String password,String firstName,String lastName,String email,String Status,String role){
		
		if(verifyElementPresence(currentPasswordTB)) {
			EnterText(currentPasswordTB, "Current Password", CurrentPasswordUser);
		}
		
		if(verifyElementPresence(userIdTB)) {
			EnterText(userIdTB, "user id", UserID);
		}
		
		if(verifyElementPresence(newPasswordTB)) {
			EnterText(newPasswordTB, "new password", password);
			String value=password;			
			CurrentPasswordUser=value;
		}
		
		if(verifyElementPresence(reEnterNewPasswordTB)) {
			EnterText(reEnterNewPasswordTB, "Confirm new password", password);
		}
		
		if(verifyElementPresence(firstNameTB)) {
			EnterText(firstNameTB, "first name", firstName);
		}
		
		if(verifyElementPresence(lastNameTB)) {
			EnterText(lastNameTB, "last name", lastName);
		}
		
		if(verifyElementPresence(emailTB)) {
			EnterText(emailTB, "email", email);
		}
		
		if(verifyElementPresence(statusDD)) {
			selectDropDown(statusDD, Status, "Status");
		}
		
		if(verifyElementPresence(RoleDD)) {
			selectDropDown(RoleDD, role, "Role");
		}
		
		if(scenarioName.contains("AddVendor-Verify-HD")&&!(scenarioName.contains("AddVendor-Verify-HD-UAT"))) {
			clickElement(By.xpath("//*[@id='21']"), "HDE");
			clickElement(By.xpath("//*[@id='22']"), "HDI");
		}
		
		if(scenarioName.contains("AddVendor-Verify-HD-UAT")) {
			clickElement(By.xpath("//*[@id='3']"), "HDE");
			clickElement(By.xpath("//*[@id='9']"), "HDI");
			clickElement(By.xpath("//*[@id='2']"), "The Home Depot");
		}
		
		if(verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
	}
	
	public void resetPassword() {
		
		String value="Password@1234";
		
		CurrentPasswordUser=value;
		
		if(verifyElementPresence(passwordTB)) {
			EnterText(passwordTB, "password", value);
		}
		
		if(verifyElementPresence(confirmPasswordTB)) {
			EnterText(confirmPasswordTB, "confirm password", value);
		}
		
		if(verifyElementPresence(resetBTN)) {
			clickElement(resetBTN, "reset");
		}
	}
	
	public void setSecretQTN(String Question,String Answer) {
		
		if(verifyElementPresence(currentPasswordTB)) {
			EnterText(currentPasswordTB, "Current Password", CurrentPasswordUser);
		}
		
		if(verifyElementPresence(secretQtnDD)) {
			selectDropDown(secretQtnDD, Question, "secret question");
		}
		
		if(verifyElementPresence(secretAnsTB)) {
			EnterText(secretAnsTB, "secret answer", Answer);
		}
		
		if(verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
	}
}
