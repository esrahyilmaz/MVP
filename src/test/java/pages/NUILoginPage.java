package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import seleniumhelper.BaseClass;

public class NUILoginPage extends BaseClass {
	
	ExcelReader _dataRepo = new ExcelReader();
	
	By userID = By.xpath("//*[@placeholder='User ID']");
	By userPassword = By.xpath("//*[@placeholder='Password']");
	By loginButton = By.xpath("//*[@id=\"submit\"]");
    By frgtPassLink = By.xpath("//*[@id=\"forgotPassword\"]");
	By certifyButton = By.cssSelector("button.shadow");
		
	String randomString = Random_StringGenerator(8);
	String passwordVariable;

	public void loginNUI(String ApplicationName, String checkFor) throws Exception {
		try {

			
//			if (checkFor.equalsIgnoreCase("valid")) {
				switch (ApplicationName.toLowerCase()) {
				case "qcsavc sponsor summary":
						passwordVariable="NewUIAutomationPassword";
						userName = PropertyFileReader.getProperty("NewUIQcsavcSponsorSummaryUser");
						password = PropertyFileReader.getProperty("NewUIQcsavcSponsorSummaryPassword");
						break;
				case "qcsavc sponsor":
						passwordVariable="NewUIAutomationPassword";
						userName = PropertyFileReader.getProperty("NewUIQcsavcSponsorUser");
						password = PropertyFileReader.getProperty("NewUIQcsavcSponsorPassword");
						break;
				
				case "automation sponsor":
					passwordVariable="NewUIAutomationPassword";
					userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorUser");
					password = PropertyFileReader.getProperty("NewUIAutoqcsSponsorPassword");
					break;
				
				case "automation sponsor view":
					passwordVariable="NewUIAutomationPassword";
					userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorViewUser");
					password = PropertyFileReader.getProperty("NewUIAutoqcsSponsorViewPassword");
					break;
					
				case "automation sponsor update":
					passwordVariable="NewUIAutomationPassword";
					userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorUpdateUser");
					password = PropertyFileReader.getProperty("NewUIAutoqcsSponsorUpdatePassword");
					break;
					
				case "automation sponsor summary":
					passwordVariable="NewUIAutomationPassword";
					userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorSummaryUser");
					password = PropertyFileReader.getProperty("NewUIAutoqcsSponsorSummaryPassword");
					break;
				
				case "autoqcs":
					passwordVariable="NewUIAutomationPassword";
					userName = PropertyFileReader.getProperty("NewUIAutoqcsUser");
					password = PropertyFileReader.getProperty("NewUIAutoqcsPassword");
					break;
				
				case "qcsavc":
					passwordVariable="NewUIAutomationPassword";
					userName = PropertyFileReader.getProperty("NewUIQcsavcUser");
					password = PropertyFileReader.getProperty("NewUIQcsavcPassword");
					break;
					
				case "newuiamazon":
					passwordVariable="NewUIAmazonPassword";
					userName = PropertyFileReader.getProperty("NewUIAmazonUser");
					password = PropertyFileReader.getProperty("NewUIAmazonPassword");
					break;
				
				case "newuiamazon1":
					passwordVariable="NewUIAmazonPassword1";
					userName = PropertyFileReader.getProperty("NewUIAmazonUser1");  
					password = PropertyFileReader.getProperty("NewUIAmazonPassword1"); 
					break;
				
				case "ayfuat":
					passwordVariable="NewUIAYFPasswordUAT";
					userName = PropertyFileReader.getProperty("NewUIAYFUserUAT"); 
					password = PropertyFileReader.getProperty("NewUIAYFPasswordUAT"); 
					break;
										
				case "newuiamazonuat":
					passwordVariable="NewUIAmazonPasswordUAT";
					userName = PropertyFileReader.getProperty("NewUIAmazonUserUAT"); 
					password = PropertyFileReader.getProperty("NewUIAmazonPasswordUAT"); 
					break;
					
				case "newuiallpro":
					passwordVariable="AllproAdminVenPass";
					userName = PropertyFileReader.getProperty("AllproAdminVenUser"); 
					password = PropertyFileReader.getProperty("AllproAdminVenPass"); 
					break;
					
				case "newuirole":
					userName = existingUserID;
					password = existingPassword;
					break;
				
				case "newuisummary":
					passwordVariable="NewUIAutoPasswordSummary";
					userName = PropertyFileReader.getProperty("NewUIAutoUserSummary");
					password = PropertyFileReader.getProperty("NewUIAutoPasswordSummary");
					break;
				
				case "newuiview":
					passwordVariable="NewUIAutoPasswordView";
					userName = PropertyFileReader.getProperty("NewUIAutoUserView");
					password = PropertyFileReader.getProperty("NewUIAutoPasswordView");
					break;
					
				case "newuiupadte":
					passwordVariable="NewUIAutoPasswordUpdate";
					userName = PropertyFileReader.getProperty("NewUIAutoUserUpdate");
					password = PropertyFileReader.getProperty("NewUIAutoPasswordUpdate");
					break;

				case "newuiproductionadmin":
					passwordVariable="NewUIProductionAdminPassword";
					userName = PropertyFileReader.getProperty("NewUIProductionAdminUser");
					password = PropertyFileReader.getProperty("NewUIProductionAdminPassword");
					break;	
					
				case "newuiproductionview":
					passwordVariable="NewUIProductionViewPassword";
					userName = PropertyFileReader.getProperty("NewUIProductionViewUser");
					password = PropertyFileReader.getProperty("NewUIProductionViewPassword");
					break;
					
				case "newuiproductionupdate":
					passwordVariable="NewUIProductionUpdatePassword";
					userName = PropertyFileReader.getProperty("NewUIProductionUpdateUser");
					password = PropertyFileReader.getProperty("NewUIProductionUpdatePassword");
					break;
					
				case "newuiproductionsummary":
					passwordVariable="NewUIProductionSummaryPassword";
					userName = PropertyFileReader.getProperty("NewUIProductionSummaryUser");
					password = PropertyFileReader.getProperty("NewUIProductionSummaryPassword");
					break;
				
				case "newuioutstanding":
					userName = _dataRepo.getData("UserID");
					password = _dataRepo.getData("Password");
					break;	
					
				case "newuionboardedvendor":
					userName = PropertyFileReader.getProperty("VendorUserID");
					password = PropertyFileReader.getProperty("VendorPassword");
//					userName = existingUserID;
//					password = existingPassword; 
					break;
					
				case "newuictadmin":
					passwordVariable="NewUIProductionAdminPassword";
					userName = PropertyFileReader.getProperty("NewUICTAdminUser");
					password = PropertyFileReader.getProperty("NewUICTAdminPassword");
					break;	
					
					
				default:
					System.out.println("Please enter valid application name !!!");
					break;
				}
				
			if (checkFor.equalsIgnoreCase("valid")) {		
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}else if (checkFor.equalsIgnoreCase("UserID")) {
				userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorUser");
				existingUserID= userName;
				EnterText(userID, "Enter username", userName);
		
			}else if (checkFor.equalsIgnoreCase("onlyUser")) {
				if (ApplicationName.equalsIgnoreCase("automation sponsor")) {
					userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorUser");
				} else {
					userName = PropertyFileReader.getProperty("NewUIAutoqcsUser");
				}
				existingUserID= userName;
				EnterText(userID, "Enter username", userName);

			} else if (checkFor.equalsIgnoreCase("onlyPassword")) {
				new Actions(driver).click(driver.findElement(userID))
				.pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.pause(200).sendKeys(Keys.BACK_SPACE).perform();
				password = PropertyFileReader.getProperty("NewUIAutoqcsPassword");
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("validPassword")) {
//				password = PropertyFileReader.getProperty("NewUIAutoqcsPassword");
				userName = randomString;
				EnterText(userPassword, "Enter Password", password);
				EnterText(userID, "Enter username", userName);
			}
			
			else if (checkFor.equalsIgnoreCase("validUserName")) {
//				userName = PropertyFileReader.getProperty("NewUIAutoqcsUser");
				password = Random_StringGenerator(3)+ Random_NumberGenerator(3);
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			//neka vu�e iz excel-a
			
			else if (checkFor.equalsIgnoreCase("Sponsor")) {
				userName = "AutoSponsor";
				password = "Password@123";
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("Invidual")) {
				userName = "CaIndividual";
				password = "Password@123";
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("Disabled")) {
				userName = "AutoDisabled";
				password = "Password@123";
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("Inactive")) {
				userName = "AutoDisabled";
				password = "Password@123";
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("Random")) {
				userName = randomString;
				password = randomString;
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("ValidLogin") | checkFor.equalsIgnoreCase("Sponsor not set to NewUI")) {
				if (ApplicationName.equalsIgnoreCase("automation sponsor")) {
					userName = PropertyFileReader.getProperty("NewUIAutoqcsSponsorUser");
					password = PropertyFileReader.getProperty("NewUIAutoqcsSponsorPassword");
				}
				else {
				userName = PropertyFileReader.getProperty("NewUIAutoqcsUser");
				password = PropertyFileReader.getProperty("NewUIAutoqcsPassword");
				}
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			else if (checkFor.equalsIgnoreCase("Reseted")) {
				
				PropertyFileReader.setProperty(passwordVariable,existingPassword);
				password = existingPassword;
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			}
			
			logStepInfo("Log in completed!!!" + userName);
			reportLog(Status.PASS, "Log in completed!!!" + userName, true);
		
		}catch (Exception ex) {
			logStepInfo("Exception occured in login():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in login():- " + ex.getMessage(), true);
		}
	}
}
