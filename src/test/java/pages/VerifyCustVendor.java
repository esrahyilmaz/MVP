package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VerifyCustVendor extends BaseClass{
	
	private static By AdministrationTAB=By.xpath("(//a[.='> Administration'])[last()-1]");
	private static By AddNewUserTAB=By.xpath("//a[.='Add New User']");
	private static By PeopleTAB=By.xpath("(//a[.='> People'])[last()]");
	private static By AddNewPersonTAB=By.xpath("//a[.='Add New Person']");
	private static By SearchUserTAB=By.xpath("//a[.='Search Users']");
	private static By RoleDD=By.xpath("//select[@name='role']");
	private static By StatusDD=By.xpath("//select[@name='enabled']");
	private static By SearchBTN=By.xpath("//input[@value='SEARCH']");

	public void presentOfAdmin() {
		if(verifyElementPresence(AdministrationTAB)) {
			clickElement(AdministrationTAB, "Administration");
			reportLog(Status.PASS, "Administration TAB is present", false);
		}else {
			reportLog(Status.FAIL, "Administration TAB is not present", false);
		}
		
		if(verifyElementPresence(SearchUserTAB)) {
			reportLog(Status.PASS, "SearchUser TAB is present", false);
		}else {
			reportLog(Status.FAIL, "SearchUser TAB is not present", false);
		}
		
		if(verifyElementPresence(AddNewUserTAB)) {
			reportLog(Status.PASS, "AddNewUser TAB is present", false);
		}else {
			reportLog(Status.FAIL, "AddNewUser TAB is not present", false);
		}
	}
	
	public void absentOfAdmin() {
		if(verifyElementPresence(AdministrationTAB)) {
			clickElement(AdministrationTAB, "Administration");
			reportLog(Status.PASS, "Administration TAB is present", false);
		}else {
			reportLog(Status.FAIL, "Administration TAB is not present", false);
		}
		
		verifyElementNotPresence(AddNewUserTAB, "Add new user");
	}
	
	public void addUser() {
		clickElement(AddNewUserTAB, "Add new User");
	}
	
	public void presentOfaddPerson() {
		
		if(verifyElementPresence(PeopleTAB)) {
			clickElement(PeopleTAB, "PeopleTAB");
			reportLog(Status.PASS, "People TAB is present", false);
		}else {
			reportLog(Status.FAIL, "People TAB is not present", false);
		}
		
		if(verifyElementPresence(AddNewPersonTAB)) {
			reportLog(Status.PASS, "AddNewPerson TAB is present", false);
		}else {
			reportLog(Status.FAIL, "AddNewPerson TAB is not present", false);
		}
	}
	
	public void absentOfaddPerson() {
		if(verifyElementPresence(PeopleTAB)) {
			clickElement(PeopleTAB, "Administration");
			reportLog(Status.PASS, "People TAB is present", false);
		}else {
			reportLog(Status.FAIL, "People TAB is not present", false);
		}
		
		verifyElementNotPresence(AddNewPersonTAB, "Add new Person");
	}
	
	public void searchUser() {
		clickElement(SearchUserTAB, "Search User");
	}
	
	public void searchUserWithRolesAndStatus(String Role, String Status) {
		
		if(verifyElementPresence(RoleDD)) {
			selectDropDown(RoleDD, Role, Role);
		}
		
		if(verifyElementPresence(StatusDD)) {
			selectDropDown(StatusDD, Status, Status);
		}
		
		if(verifyElementPresence(SearchBTN)) {
			clickElement(SearchBTN, "Search");
		}

	}
}
