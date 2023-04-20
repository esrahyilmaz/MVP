package pages;

import Utility.CurrentDateTime;
import Utility.ExcelReader;
import Utility.PdfReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

import java.util.List;

public class CACommon extends BaseClass {

	CALoginPage caLogin = new CALoginPage();
	CAVendorPage caVendor = new CAVendorPage();
	CAOrderPage caOrderPage = new CAOrderPage();
	CAPeoplePage caPeople = new CAPeoplePage();
	CAPersonStatus caPersonStatus = new CAPersonStatus();
	CAPaymentDetails caPaymentDetails = new CAPaymentDetails();
	CAPersonalPage caPersonalPage = new CAPersonalPage();
	PdfReader pdf = new PdfReader();
	CurrentDateTime dateTime = new CurrentDateTime();
	CAVendorRegistrationPage caVendorRegistration = new CAVendorRegistrationPage();
	CASelfRegistrationPage caSelfContractorRegistarion = new CASelfRegistrationPage();
	NewUIVendorRegistrationPage newUIVendorRegis = new NewUIVendorRegistrationPage();
	ExcelReader _dataRepo = new ExcelReader();
	DatabaseClass DB=new DatabaseClass();
	public static String StatusfromUI;
	public static String newOrderID=null;
	public static String expDate=null;
	public static String orderDate=null;
	public static String badgeNumber=null;
//	private Random rand=new Random();

	
	
	public String Value;

	/** @category Wait method for each and every page **/

	public void waitObject(String waitTime) throws Exception {
		int wait = Integer.parseInt(waitTime);
		implicitlyWait(wait);
	}

	/**
	 * @author shekarcg
	 * @category Click on Package Radio Button for each and every page
	 * 
	 **/
	public void clickLink(String linktext, String Page) throws Exception {
		try {
			switch (linktext.toLowerCase()) {
			case "click here to register as service provider":
				clickElementWithWait(caLogin.vendorRegLink, "Clicked on Vendor Registartion Link");
				break;
			case "vendor name":
				/*By vendorNameLink = By.xpath("//a[contains(text(),'" + _dataRepo.getData("vendorName") +"')]");
				By othervendorNameLink = By.xpath("//a[contains(text(),'" + _dataRepo.getData("otherVendorName") +"')]");
				if(verifyElementPresence(othervendorNameLink)) {
					System.out.println("Vendor Name Xpath is ::"+othervendorNameLink);
					clickElementWithWait(othervendorNameLink, "Click on Vendor Name Link");
				}
				else if(verifyElementPresence(vendorNameLink)) {
					System.out.println("Vendor Name Xpath is ::"+vendorNameLink);
				    clickElementWithWait(vendorNameLink, "Click on Vendor Name Link");
				}
				else {*/
				if(scenarioName.contains("DigitalBadge")) {
					clickElementWithWait(caVendor.vendorNameLink2, "Clicked on vendor Name Link");
				}else {
					clickElementWithWait(caVendor.vendorNameLink, "Clicked on vendor Name Link");
				}
//				}
				break;
			case "people name":
				clickElementWithWait(caPeople.peopleNameLink, "Click on People Name Link");
				break;
			case "people name2":
				clickElementWithWait(caPeople.peopleName2Link, "Click on People Name 2 Link");
				break;
			case "ordername":
				clickElementWithWait(caOrderPage.orderNameLink, "Click on Order Name");
				break;
			case "service provider for the allpro1":
				clickElementWithWait(caSelfContractorRegistarion.selfContractorLink,
						"Click on the self contractor Link");
				break;
			case "schedule":
				clickElementWithWait(caOrderPage.scheduleLink, "click on Scehdule Link");
				break;
			case "forgot password":
				clickElementWithWait(caLogin.forgetPasswordLink, "Clicked on Forget Password Link");
				break;			
			case "login":
				clickElementWithWait(newUIVendorRegis.loginOnComPage, "Clicked on Login button Link");
				break;
			}
			logStepInfo("Clicked on Link :-"+linktext);
			reportLog(Status.PASS,"Clicked on Link :-"+linktext, true);

			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in clickLink():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in clickLink():- "+ex.getMessage(), true);
			}

	}

	/**
	 * @author shekarcg
	 * @Category signature on Canvas
	 * 
	 * 
	 **/
	public void canvasSignatureFunction() throws Exception {
		actionPerform(caVendorRegistration.electronicSignTextArea, "Draw on Signature Canvas");
	}

	/**
	 * @author shekarcg
	 * @category uploading File into application
	 **/

	public void uploadFileIntoApplication(String fileName, String value, String Page) throws Exception {
		try {
			if (value.equalsIgnoreCase("Upload Photo")) {
				uploadFile(caPersonStatus.chooseFileBtn, "clicked on Choose File button", fileName);
				clickElementWithWait(caPersonStatus.uploadFileBtn, "uploaded SuccessFully!!!");
			} else if (value.equalsIgnoreCase("Add Photo")) {
				uploadFile(caPersonStatus.addFileBtn, "clicked on Choose File button", fileName);
				clickElementWithWait(caPersonStatus.addFileUploadBtn, "uploaded SuccessFully!!!");
			} else if (value.equalsIgnoreCase("Self Add Photo")) {
				uploadFile(caPersonStatus.scAddFileBtn, "Clicked on Self Contract choose file button", fileName);
				clickElementWithWait(caPersonStatus.scFileUploadBtn, "uploaded Successfully!!!");
			}
		} catch (Exception e) {
			System.out.println("Error occured in Page ::" + e.getMessage());
		}
	}

	/**
	 * @author shekarcg
	 * @category Click on Radio Button by visible text
	 * @param buttonText
	 *            text
	 * 
	 * 
	 **/
	public void clickRadioButton(String buttonText) throws Exception {
		try {
			if (buttonText.equalsIgnoreCase("no"))
				clickElementWithWait(caVendorRegistration.secondaryContactNRadio, "clicked on No radio button");

		} catch (Exception e) {
			System.out.println("Except is in following object ::" + e);
		}
	}

	/**
	 * @author shekarcg
	 * @category Click on Menu Button by visible text
	 * @param button
	 *            text
	 * 
	 **/
	public void clickMenuButton(String menubutton) throws Exception {
		try {
			if (menubutton.equalsIgnoreCase("vendor")) {
				clickElementWithWait(caLogin.vendorMenuBtn, "click on Vendor button");
				clickElement(caLogin.searchVendorBtn, "Search Vendor clicked ");
			} else if (menubutton.equalsIgnoreCase("cart")) {
				clickElementWithWait(caLogin.cartBtn, "Clicked on Cart button");
			} else if (menubutton.equalsIgnoreCase("order")) {
				clickElementWithWait(caLogin.orderMenuBtn, "Clicked on Order Button");
				clickElementWithWait(caLogin.orderSearchBtn, "Clicked on Order Button");
			} else if (menubutton.equalsIgnoreCase("people")) {
				clickElementWithWait(caLogin.peopleMenuBtn, "Clicked on People Button");
				clickElementWithWait(caLogin.peopleSearchBtn, "Clicked on PeopleSearch  Button");
			} else if (menubutton.equalsIgnoreCase("Search Users")) {
				clickElementWithWait(caLogin.administrationMenuBtn, "Clicked on Admin Button");
				clickElementWithWait(caLogin.searchUserMenuBtn, "Clicked on Search User  Button");
			} else if (menubutton.equalsIgnoreCase("Contact")) {
				clickElementWithWait(caLogin.administrationMenuBtn, "Clicked on Admin Button");
				clickElementWithWait(caLogin.contactMenuBtn, "Clicked on Search User  Button");
			} else if (menubutton.equalsIgnoreCase("Client Order Report")) {
				clickElementWithWait(caLogin.AdminstrationLink, "Clicked on Admin Button");
				clickElementWithWait(caLogin.ClientOrderReportLink, "Clicked on Cllient Order Report  Link");
			}else if (menubutton.equalsIgnoreCase("Unselect Vendor")) {
				clickElementWithWait(caLogin.vendorMenuBtn, "click on log in button");
				clickElement(caLogin.unselectVendorBtn, "Un select Vendor clicked ");
			} else if (menubutton.equalsIgnoreCase("Add New Person")) {
				clickElementWithWait(caLogin.peopleMenuBtn, "Clicked on People Button");
				clickElementWithWait(caLogin.addNewPeopleMenuBtn, "Clicked on Add New People Button");
			} else if (menubutton.equalsIgnoreCase("Add Existing Person")) {
				clickElementWithWait(caLogin.peopleMenuBtn, "Clicked on People Button");
				clickElementWithWait(caLogin.addExistingPeopleMenuBtn, "Clicked on Add Existing People Button");
			} else if (menubutton.equalsIgnoreCase("Profile")) {
				clickElementWithWait(caLogin.adminMenuBtn, "Clicked on Administration Button");
				clickElementWithWait(caLogin.profileMenu2Btn, "Clicked on Profile Button");
			} else {
				clickElementWithWait(caLogin.homeBtn, "Clicked on Home Button");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickButton(String value, String Page) throws Exception {
		try {
			switch (Page.toLowerCase()) {
		
			case "login":
				if (value.equalsIgnoreCase("recertify"))
					clickElementWithWait(caLogin.recertifyBtn, "Clicked on Recertify Button");
				else if (value.equalsIgnoreCase("submit"))
					clickElementWithWait(caLogin.submitHOMEDEPOTRBtn, "Click on Submit button of HOME DEPOT");
				else if (value.equalsIgnoreCase("Ok"))
					clickElementWithWait(caLogin.OkBtn, "Click on Ok button");
				else if (value.equalsIgnoreCase("RETURN TO LOGIN"))
					clickElementWithWait(caLogin.returnToLoginBtn, "Click on Return To Login button");
				else if (value.equalsIgnoreCase("SUBMIT FRGT"))
					clickElementWithWait(caLogin.submitFRGTBtn, "Click on Return To Submit button");
				else if (value.equalsIgnoreCase("invalid-Login"))
					clickElementWithWait(caLogin.logInBtn, "click on log in button");	
				else if (verifyElementPresence(SecretAnswerTB)) {
					EnterText(SecretAnswerTB, "Secret Answer","red");
					clickElement(RectifyBTN, "Rectify");
				}	
				else if (verifyElementPresence(SecretAnswerTB)) {
					EnterText(SecretAnswerTB, "Secret Answer","blue");
					clickElement(RectifyBTN, "Rectify");
				}
				else
					clickElementWithWait(caLogin.logInBtn, "click on log in button");
				
			
				break;
			case "notice":
				if (value.equalsIgnoreCase("ACCEPT FCRA AGREEMENT")) {
					if(verifyElementPresence(caLogin.acceptLegalAgreementBtn)) {
						clickElementWithWait(caLogin.acceptLegalAgreementBtn, "Click on Legal agreement Button");
						wait(3);
						}
					if(verifyElementPresence(caLogin.proceedwithLoginBtn)) {
						clickElementWithWait(caLogin.proceedwithLoginBtn, "Click on Proceed Button");
					}
					if(verifyElementPresence(caLogin.acceptFCRABtn)) {
					clickElementWithWait(caLogin.acceptFCRABtn, "Click on FCRA agreement Button");
					wait(3);
					}
					if(verifyElementPresence(caLogin.acceptFCRAchkBox)) {
						clickElementWithWait(caLogin.acceptFCRAchkBox, "Click on FCRA chreck box");
						wait(3);
						clickElementWithWait(caLogin.roasterUpToDatechkBox, "Click on roaster uo to date button");
						wait(3);
						clickElementWithWait(caLogin.continueBTN, "Click on continue to dashboard Button");
					}
					
				}else if (value.equalsIgnoreCase("DECLINE FCRA AGREEMENT"))
					clickElementWithWait(caLogin.declineFCRABtn, "Click on FCRA agreement Button");
				break;
			case "vendors":
				if (value.equalsIgnoreCase("AspenSearch"))
					clickElementWithWait(caVendor.AspensearchBtn, "click on search button on Vendor Page");
				else if (value.equalsIgnoreCase("Search"))
					clickElementWithWait(caVendor.homeDepotSearchBtn, "click on search button on Vendor Page");
				break;
			case "people":
				if (value.equalsIgnoreCase("save")) {
					clickElementWithWait(caPeople.saveBtn, "click on Save button on People Page");
						if(driver.findElement(caPeople.ignoreAddress_chkBox).isDisplayed()) {
							clickElementWithWait(caPeople.ignoreAddress_chkBox, "click on ignore address checkbox");
							clickElementWithWait(caPeople.saveBtn, "click on continue button");
						}
				}
				else if(value.equalsIgnoreCase("YES")) {
							clickElementWithWait(caPeople.ExistingPersonYesBtn, "Clicked on yes button");
						}
				else
					clickElementWithWait(caPeople.searchBtn, "click on search button on People Page");
				break;
			case "order detail":
				if (value.equalsIgnoreCase("next"))
					clickElementWithWait(caOrderPage.nextBtn, "clicked on Next button pf Order Page");
				else if (value.equalsIgnoreCase("continue"))
					clickElementWithWait(caOrderPage.continueBtn, "clicked on Next button pf Order Page");
				else if (value.equalsIgnoreCase("ok")) {
					if(verifyElementPresence(By.xpath("((//div[contains(.,'Transaction Id:')])[last()]/..//b)[3]"))) {
						TransactionID=driver.findElement(By.xpath("((//div[contains(.,'Transaction Id:')])[last()]/..//b)[3]")).getText();
						reportLog(Status.PASS, "TransactionID is "+TransactionID, true);
					}else {
						reportLog(Status.INFO, "TransactionID is not displayed", true);
					}
					clickElementWithWait(caOrderPage.okBtnn, "clicked on OK button Order Page");
				}
				break;
			case "payment detail":
				clickElementWithWait(caPaymentDetails.orderBtn, "Clicked on Order Btn");
				break;
			case "agreements":
				if (value.equalsIgnoreCase("i agree")) {
					clickElementWithWait(caVendorRegistration.iAgreeBtn, "clicked on I agree Button");
				}
				break;
			case "verify your personal information":
				clickElementWithWait(caVendorRegistration.confirmBtn, "clicked on Confirm Button");
				break;
			case "person status detail":
				if (value.equalsIgnoreCase("Next")) {
					clickElementWithWait(caPersonStatus.nextBtn, "clicked on Next Button");
				}
				else if (value.equalsIgnoreCase("Continue")) {
					clickElementWithWait(caPersonStatus.continueBtn, "clicked on Continue Button");
				}else if (value.equalsIgnoreCase("Previous")) {
					if(verifyElementPresence(caPersonStatus.previousBtn)) {
						clickElementWithWait(caPersonStatus.previousBtn, "clicked on Previous Button");
					}else if(verifyElementPresence(caPersonStatus.previousBtn1)) {
						clickElementWithWait(caPersonStatus.previousBtn1, "clicked on Previous Button");
					}
				}
				else if (value.equalsIgnoreCase("SEND BADGE")) {
					clickElementWithWait(caPersonStatus.sendBadgeBtn, "clicked on SEND BADGE Button");
				}else {
					By CreatedXPATH = createDynamicXpath("button", value, "xpath created");
					clickElementWithWait(CreatedXPATH, "Created on button " + value + "");
				}
				break;
			case "person information":
				if(verifyElementPresence(caPersonalPage.nxtBtn)) {
					clickElementWithWait(caPersonalPage.nxtBtn, "Click on Next Button ");
				}else if(verifyElementPresence(caPersonalPage.nxtBtn1)) {
					clickElementWithWait(caPersonalPage.nxtBtn1, "Click on Next Button ");
				}
				
				break;
			case "order":
				clickElementWithWait(caOrderPage.searchOrderBtn, "Click on Search Button ");
				break;
			case "cart details":
				if (value.equalsIgnoreCase("Continue Ordering"))
					clickElementWithWait(caPaymentDetails.continueOrderingBtn, "Clicked on Continue Ordering Button");
				else if (value.equalsIgnoreCase("Checkout")) {
					DB.getAdditionalBilling();
//					if(AdditionalBilling.equalsIgnoreCase("Y")&& !(scenarioName.contains("NONHD"))&&!(scenarioName.contains("Tax_CA"))&&!(scenarioName.contains("Compliance_CA"))) {
					if(AdditionalBilling.equalsIgnoreCase("Y")) {
					clickElement(By.id("consent"),"consent");
					}
//					else if(verifyElementPresence(By.id("consent"))) {
//						clickElement(By.id("consent"),"consent");
//					}
					/*
					 * if(verifyElementPresence(By.xpath("//input[@name='consent']"))) {
					 * clickElement(By.xpath("//input[@name='consent']"),
					 * "Clicked consent check box"); }
					 */
					scrollDown(200);
					clickElementWithWait(caPaymentDetails.checkoutBtn, "Clicked on Check out button");
				}else if (value.equalsIgnoreCase("remove"))
					clickElementWithWait(caPaymentDetails.removeBtn, "Clicked on Remove Button");
				else if(value.equalsIgnoreCase("log out")) {
					clickElementWithWait(caLogin.logoutBtn, "Click on Log Out Button");
					driver.switchTo().alert().accept();
				}
				break;
			case "cart details Empty":
				if (value.equalsIgnoreCase("Checkout")) {					
					clickElementWithWait(caPaymentDetails.checkoutBtn, "Clicked on Check out button");
				}
				break;
			case "individual registration":
				if (value.equalsIgnoreCase("NEXT"))
					clickElementWithWait(caSelfContractorRegistarion.nextBtn, "Clicked on Next");
				else if (value.equalsIgnoreCase("YES"))
					clickElementWithWait(caSelfContractorRegistarion.yesBtn, "clicked on Yes Button");
				else if (value.equalsIgnoreCase("CONTINUE"))
					clickElementWithWait(caSelfContractorRegistarion.continueBtn, "clicked on Continue button");
				break;
			case "registration confirmation":
				clickElementWithWait(caSelfContractorRegistarion.printBtn, "clicked on Print button");
				break;
			default:
				By CreatedXPATH = createDynamicXpath("button", value, "xpath created");
				System.out.println("Button xpath is ::" + CreatedXPATH);
				break;
				
				
			}
			if (!value.equalsIgnoreCase("invalid-Login")) {
				 takeScreenshot();
			 }
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * @author shekarcg
	 * @category verify Title on each and every page
	 **/
	public void pageTitleVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			if (verifyElementPresence(caLogin.sessionOverrideTitle)) {
				clickElementWithWait(caLogin.proceedwithLoginBtn, "Clicked on proceed with login button");
			}
			if (verifyElementPresence(caLogin.recertificationTitle)) {
				Value = "blue";
				EnterText(caLogin.secretAnswerText, "Secret Answer entered", Value);
				clickElementWithWait(caLogin.recertifyBtn, "click on Recertify Button");
			}
			if (verifyElementPresence(caLogin.sessionOverrideTitle)) {
				clickElementWithWait(caLogin.proceedwithLoginBtn, "Clicked on proceed with login button");
			}
			if(identifierValue.equalsIgnoreCase("lobValue")) {
				identifierValue=_dataRepo.getData("lobValue");
			}
			By createdXPATH = createDynamicXpath("title", identifierValue, "Xpath for title created");
			verifyElementText(createdXPATH, identifierValue);

		} catch (Exception e) {
			System.out.println("Error occured in Page ::" + e.getMessage());

		}
		takeScreenshot();

	}

	public void pageTextVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			switch (pageName.toLowerCase()) {
			case "login":
				if (identifierValue.equalsIgnoreCase("Ok"))
					verifyElementText(caLogin.OkBtn, identifierValue);
				break;
			case "notice":
				verifyElementText(caLogin.warningFCRAText, identifierValue);
				break;
			case "user recertification":
				verifyElementText(caLogin.secretAnswerText, identifierValue);
				break;
			case "vendors":
				if (identifierValue.equalsIgnoreCase("Vendor Name"))
					verifyElementText(caVendor.vendorNameLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Vendor Account"))
					verifyElementText(caVendor.vendorAccountLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Contact First Name"))
					verifyElementText(caVendor.contactFirstNameLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Contact Last Name"))
					verifyElementText(caVendor.contactLastNameLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Vendor Status"))
					verifyElementText(caVendor.vendorStatusLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Report Status"))
					verifyElementText(caVendor.businessComponentStatusLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Report Expiration"))
					verifyElementText(caVendor.businessComponentExpirationLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Vendor Name Link"))
					verifyElementText(caVendor.vendorNameLink, identifierValue);
				else if (identifierValue.equalsIgnoreCase("VendorName"))
					verifyElementText(caVendor.vendorTextVal, identifierValue);
				break;
			case "people":
				if (identifierValue.equalsIgnoreCase("Vendor Name")) {
					identifierValue = _dataRepo.getData("vendorName");
					verifyElementText(caPeople.vendorNameLbl, identifierValue);
				} else {
					By createdXPATH = createDynamicXpath("title", identifierValue, "Xpath for title created");
					verifyElementText(createdXPATH, identifierValue);
				}
				break;
			case "order details":
				if (identifierValue.equalsIgnoreCase(
						"Select a package to view the package details and begin the ordering process:"))
					verifyElementText(caOrderPage.packageSelectiontxt, identifierValue);
				else if (identifierValue.equalsIgnoreCase(
						"Search for an order by First Name, Last Name, SSN, or any of the fields shown below.  To search for all orders, leave the fields blank and click 'Search.'"))
					verifyElementText(caOrderPage.orderPageLbl, identifierValue);
				break;
			case "cart details":
				if (identifierValue.equalsIgnoreCase("It looks like your cart is empty.")) {
					int countRemove;
					List<WebElement> ele=driver.findElements(caPaymentDetails.removeBtn);
					countRemove = ele.size();
					for(int i=0;i<countRemove;i++) {
//						clickElementWithWait(caPaymentDetails.removeBtn, "Clicked on Remove Button");
						ele.get(i).click();
						System.out.println("count of button is :: "+ countRemove);
				}			
					verifyElementText(caPaymentDetails.cartMessageLbl, identifierValue);
				}
				else if(identifierValue.equalsIgnoreCase("There are items in your cart which belongs to different vendors, in order to checkout items please select appropriate vendor")) {
					verifyElementText(caPaymentDetails.messageLbl,identifierValue);
				}
				
				break;
			case "person status detail":
				if (identifierValue.equalsIgnoreCase("Price:  $9.00"))
					verifyElementText(caPersonStatus.priceMsgLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("orderid"))
					verifyElementText(caPersonStatus.orderidTxt, valuefromUI);
				break;
			case "orders":
				verifyElementText(caOrderPage.orderIDColumn, identifierValue);
				break;
			case "individual registration":
				if (identifierValue.equalsIgnoreCase("Individual Registration"))
					verifyElementText(caSelfContractorRegistarion.createProfileLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("This is Mock service for bypassing Proid check"))
					verifyElementText(caSelfContractorRegistarion.mockLbl, identifierValue);
				else if (identifierValue.equalsIgnoreCase("Create Profile"))
					verifyElementText(caSelfContractorRegistarion.createProfileLbl, identifierValue);
				else
					verifyElementText(caSelfContractorRegistarion.msgTxt, identifierValue);
				break;
			
			 default:
				if (identifierValue.equalsIgnoreCase("mobileNo"))
					identifierValue = CAAdminTool.mobile;
				else if (identifierValue.equalsIgnoreCase("email"))
					identifierValue = _dataRepo.getData("Email");			
				else if (identifierValue.equalsIgnoreCase("Vendor Name"))
					identifierValue = _dataRepo.getData("vendorName");
				else if (identifierValue.equalsIgnoreCase("Other Vendor Name"))
					identifierValue = _dataRepo.getData("otherVendorName");			
				
				System.out.println("Idnetifier is :: "+identifierValue);
				
				if (pageName.equalsIgnoreCase("Business Information"))
				{
					By createdXPATH = createDynamicXpath("error", identifierValue, "Xpath for title created");
					System.out.println("Created Xpath is :: "+createdXPATH);
					verifyElementText(createdXPATH, identifierValue);
				}
				else {
				By createdXPATH = createDynamicXpath("title", identifierValue, "Xpath for title created");
				System.out.println("Created Xpath is :: "+createdXPATH);
				verifyElementText(createdXPATH, identifierValue);
				}
				break;
			}
			System.out.println("Verified text is ::" + identifierValue);
		} catch (Exception ex) {
			System.out.println("error in following line::" + ex.getMessage());
		}
	}

	public void VerifyIdentifierWithValue(String identifierValue, String Value) throws Exception {
		try {
			if(identifierValue.equalsIgnoreCase("Status:")) {
				By createdXPATH = By.xpath("(//*[contains(text(),'Status:')]/following::td[1])[2]");
				System.out.println("Created Xpath is ::" + createdXPATH);
				verifyElementText(createdXPATH, Value);
			}else {
			By createdXPATH = createDynamicXpath("value", identifierValue, "Xpath for title created");
			System.out.println("Created Xpath is ::" + createdXPATH);
			verifyElementText(createdXPATH, Value);
			}
		} catch (Exception ex) {
			System.out.println("error in following line::" + ex.getMessage());
		}
	}
	
	public void CheckOrder(String PageName) throws Exception {
		int countRemove;
		List<WebElement> ele = driver.findElements(caPaymentDetails.removeBtn);
		countRemove = ele.size();
		for (int i = 0; i < countRemove; i++) {
			ele.get(i).click();
			System.out.println("count of button is :: " + countRemove);
			clickElementWithWait(caPaymentDetails.removeBtn, "Clicked on Remove Button");
		}
	
	}
	public void verifyTableValue(String condition, String tableName, String ColumnName, String ColumnValue)
			throws Exception {
		String xString;
		By CreatedXPATH = null;
		if (tableName.equalsIgnoreCase("Badge History")) {
				switch (ColumnName) {
				case "Badge Status":
					xString = "//*[text()='Badge History']/following::tr[2]/td[3]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Order Date":
					xString = "//*[text()='Badge History']/following::tr[2]/td[4]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
//					orderDate=driver.findElement(CreatedXPATH).getText();
					break;
				case "Badge Number":
					xString = "//*[text()='Badge History']/following::tr[2]/td[5]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;					
				case "Issue Date":
					xString = "//*[text()='Badge History']/following::tr[2]/td[6]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Expiration Date":
					xString = "//*[text()='Badge History']/following::tr[2]/td[7]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");

					break;
				}
			} else if (tableName.equalsIgnoreCase("Order History")) {
				switch (ColumnName) {
				case "Order Id":
					xString="//*[contains(text(),'Order History')]/following::tr[2]/td[1]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Order Date":
					xString = "//*[contains(text(),'Order History')]/following::tr[2]/td[2]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Complete Date":
					xString = "//*[contains(text(),'Order History')]/following::tr[2]/td[3]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Package Name":
					xString = "//*[contains(text(),'Order History')]/following::tr[2]/td[4]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Compliance Impact?":
					xString = "//*[contains(text(),'Order History')]/following::tr[2]/td[5]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Badge Required":
					xString = "//*[contains(text(),'Order History')]/following::tr[2]/td[6]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Order Ref Id":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[2]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Service":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[3]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Order Status":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[4]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Ref Complete Date":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[5]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Case Status":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[6]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Case Score":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[7]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Ref Compliance Impact?":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[8]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				case "Profile Status":
					xString = "//*[contains(text(),'Order History')]/following::tr[5]/td[9]";
					CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
					break;
				}
			} else if (tableName.equalsIgnoreCase("Shopping Cart")) {
				xString = "//*[contains(text(),'" + ColumnName + "')]/following::div[7]";
				CreatedXPATH = createDynamicXpath("", xString, "xpath created for '" + ColumnName + "'");
			}
		
		
		if (ColumnValue.equalsIgnoreCase("SYSDATE")) {
			ColumnValue = dateTime.SystemDateMMDD();
		}else if(ColumnValue.equalsIgnoreCase("orderid")) {
			ColumnValue=valuefromUI;
		}else if(ColumnValue.equalsIgnoreCase("new order id")) {
			newOrderID=driver.findElement(By.xpath("//*[contains(text(),'Order History')]/following::tr[2]/td[1]")).getText();
			ColumnValue=newOrderID.trim();
			
		}else if(ColumnValue.equalsIgnoreCase("Badge Number")) {
			newOrderID=driver.findElement(By.xpath("//*[text()='Badge History']/following::tr[2]/td[5]")).getText();
			ColumnValue=badgeNumber.trim();
		}
		else if(ColumnValue.equalsIgnoreCase("Expiration Date")) {
			expDate=driver.findElement(By.xpath("//*[text()='Badge History']/following::tr[2]/td[7]")).getText();
			ColumnValue=expDate.trim();
		}
		
		
		
		if (condition.equalsIgnoreCase("Present")) {
			System.out.println("Created XPATH is ::" + CreatedXPATH);
			verifyElementText(CreatedXPATH, ColumnValue);
		} else if (condition.equalsIgnoreCase("Absent")) {
			System.out.println("Created XPATH is ::" + CreatedXPATH);
			verifyElementNotPresence(CreatedXPATH);

		}
	}
	public void pageButtonVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			switch (pageName.toLowerCase()) {
			case "notice":
				if (identifierValue.equalsIgnoreCase("ACCEPT FCRA AGREEMENT"))
					verifyElementValue(caLogin.acceptFCRABtn, identifierValue);
				else
					verifyElementValue(caLogin.declineFCRABtn, identifierValue);
				break;
			case "person status detail":
				if (identifierValue.equalsIgnoreCase("BEGIN ORDER PROCESS"))
					verifyElementValue(caPersonStatus.beginOrderProcessBtn, identifierValue);
				else if (identifierValue.equalsIgnoreCase("SUBMIT BADGE PHOTO"))
					verifyElementValue(caPersonStatus.submitBadgePhotoBtn, identifierValue);
				else if (identifierValue.equalsIgnoreCase("ORDER REPLACEMENT BADGE"))
					verifyElementValue(caPersonStatus.orderReplacementBadgeBtn, identifierValue);
				else if (identifierValue.equalsIgnoreCase("PRINT TEMPORARY BADGE"))
					verifyElementValue(caPersonStatus.printTempBadgeBtn, identifierValue);
				else if (identifierValue.equalsIgnoreCase("SEND BADGE"))
					verifyElementValue(caPersonStatus.sendBadgeBtn, identifierValue);
				else if(identifierValue.equalsIgnoreCase("OK"))
					verifyElementValue(caPersonStatus.okBtn, identifierValue);
				break;
			case "payment detail":
				if (identifierValue.equalsIgnoreCase("Order"))
					verifyElementValue(caOrderPage.orderBtn, identifierValue);
				else
					verifyElementValue(caOrderPage.orderMenuBtn, identifierValue);
				break;
			case "order details":
				verifyElementValue(caOrderPage.okBtn, identifierValue);
				break;
			case "individual registration":
				if (identifierValue.equalsIgnoreCase("Next"))
					verifyElementValue(caSelfContractorRegistarion.nextBtn, identifierValue);
				break;
			case "registration confirmation":
				verifyElementValue(caSelfContractorRegistarion.printBtn, identifierValue);
				break;
			default:
				By createdXPATH = createDynamicXpath("button", identifierValue, "Xpath for title created");
				verifyElementPresence(createdXPATH);
			}

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}

	}

	public void pageMessage(String identifyerName, String identifierText) throws Exception {
		try {
			if (identifyerName.equalsIgnoreCase("errorMessage")) {
				By message = By.xpath("//*[@id=\"errorMessages\"]");
				
				String MessageTxt = driver.findElement(message).getText();
				verifyMessageTxt(MessageTxt, identifierText);
	
			} else if (identifyerName.equalsIgnoreCase("successMessage")) {
				By message = By.xpath("//*[@id='successMessages']");
				String MessageTxt = driver.findElement(message).getText();
				verifyMessageTxt(MessageTxt, identifierText);
			}

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

	public void pageColumnVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			switch (pageName.toLowerCase()) {
			case "vendors":
				WebElement vendorElement = driver.findElement(caVendor.vendorTable);
				List<WebElement> rows = driver.findElements(caVendor.vendorTable);
				System.out.println("Count of Columns::" + rows.size());
				System.out.println();
				for (WebElement row : rows) {
					row.getText();
				}
				break;
			
			}
		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

	/**
	 * @author shekarcg
	 * @category verify object not present
	 **/

	public void menuButtonVerifyPresent(String buttonName) throws Exception {
		try {
			By createdXPATH = createDynamicXpath("title", buttonName, "Xpath for title created");
			
			if (scenarioName.contains("SmokeSuite")) {
				if (!verifyElementPresence(createdXPATH)) {
					if(buttonName.equalsIgnoreCase("Cart")) {	
	                    verifyElementPresence(caLogin.cartBtn, buttonName);
					}else {
						createdXPATH = createDynamicXpath("menubutton", buttonName, "Xpath for title created");
						verifyElementPresence(createdXPATH, buttonName);
					}
			}else {
				verifyElementPresence(createdXPATH, buttonName);
			}

			}
			else {
				verifyElementPresentClass(createdXPATH, "menuItem");	
			}
		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

	/**
	 * @author shekarcg
	 * @category verify object not present
	 **/

	public void pageObjectVerifyWithValueNotPresent(String identifierName, String identifierValue, String pageName)
			throws Exception {
		try {
			By createdXPATH;
			if (identifierName.equalsIgnoreCase("menubutton")) {
				createdXPATH = createDynamicXpath("title", identifierValue, "Xpath for title created");
			} else if (identifierName.equalsIgnoreCase("button")) {
				createdXPATH = createDynamicXpath("button", identifierValue, "Xpath for title created");

			} else {
				createdXPATH = createDynamicXpath("title", identifierValue, "Xpath for title created");
			}
			verifyElementNotPresence(createdXPATH);
			
			reportLog(Status.PASS, "Object is not present '" + identifierValue + "'", false); 
			logStepInfo("Object is not present '" + identifierValue + "");
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * @author shekarcg
	 * @category enter text on text box
	 **/
	public void enterText(String Value, String textField, String pageName) throws Exception {
		try {
			if (pageName.equalsIgnoreCase("vendors")) {
				if (textField.equalsIgnoreCase("Vendor Name"))
					System.out.println("Value of Vendor Name ::" + Value);
				EnterText(caVendor.vendorNameTxt, "Vendor Name entered", Value);
			} else if (pageName.equalsIgnoreCase("People")) {
				if (textField.equalsIgnoreCase("First Name")) {
					System.out.println("Value of Person Name ::" + Value);
					EnterText(caPeople.searchFirstName, "People Name entered", Value);
				} else if (textField.equalsIgnoreCase("Last Name")) {
					System.out.println("Value of Vendor Name ::" + Value);
					EnterText(caPeople.searchLastNameTxt, "People Name entered", Value);
				}
			} else if (pageName.equalsIgnoreCase("orders")) {
				if (textField.equalsIgnoreCase("OrderID")) {
					By orderID = By.xpath("//*[@id=\"orderId\"]");
					EnterText(orderID, "Enetered Order ID", valuefromUI);
				}
			} else if (pageName.equalsIgnoreCase("User Recertification")) {
				if (textField.equalsIgnoreCase("secret Answer")) {
					EnterText(caLogin.secretAnswerText, "Secret Answer entered", Value);
				}
			} else if (pageName.equalsIgnoreCase("Outlook")) {
				if (textField.equalsIgnoreCase("email")) {
					EnterText(By.xpath("//input[@name='loginfmt']"), "Email entered", Value);
				} 
			} else if (pageName.equalsIgnoreCase("Payment")) {
				if (textField.equalsIgnoreCase("* Invoice Code"))
					EnterText(caPaymentDetails.invoiceCodeTxt, "Invoice code entered", Value);
			} else if (pageName.equalsIgnoreCase("Person Informations")) {
				if (textField.equalsIgnoreCase("Address"))
					EnterText(caPersonalPage.AddressSearchTxt, "Invoice code entered", Value);
			} else if (pageName.equalsIgnoreCase("Payment Detail")) {
				if (textField.equalsIgnoreCase("Card Number"))
					EnterText(caPaymentDetails.cardNumberTxt, "Enter Card Number", Value);
				else if (textField.equalsIgnoreCase("CSC Number"))
					EnterText(caPaymentDetails.cssNumberTxt, "Enter csc Number", Value);
			}else if (pageName.equalsIgnoreCase("Add New Person")) {
				 if(Value.equalsIgnoreCase("existingSSN")){
					EnterText(caPeople.ssnTxt, "Entered SSN Value", caPeople.existingssnNumber);
				 }else if(textField.equalsIgnoreCase("SSN")) { 
					driver.findElement(caPeople.ssnTxt).clear();
				 }
			}else {
				By fieldValue = createDynamicXpath("text", textField, "xpath for created for " + textField + "");
				EnterText(fieldValue, "Text enetered in " + textField + " ", Value);
			}
		} catch (Exception e) {
			e.getMessage();

		}
		takeScreenshot();
	}

	/**
	 * @author shekarcg
	 * @category select drop down values
	 **/

	public void selectDropDown(String ddlName, String Value, String Page) throws Exception {
		try {
			if (ddlName.equalsIgnoreCase("Organization Name"))
				selectDropDown(caLogin.OrganizationDdl, Value, "Organization  drop down Selected Drop down value");
			else if (ddlName.equalsIgnoreCase("Background Score"))
				selectDropDown(caLogin.BackgroundScoreDD, Value, "selected background score");
			else if (ddlName.equalsIgnoreCase("lob"))
				selectDropDown(caLogin.lobDdl, Value, "LOB drop down Selected Drop down value");
			else if (ddlName.equalsIgnoreCase("* Payment Method(s)"))
				selectDropDown(caPaymentDetails.paymentDdl, Value, "Payment Mode selected from Drop down");
			else if (ddlName.equalsIgnoreCase("* DL State"))
				selectDropDown(caPersonalPage.dlStateDdl, Value, "DL State selected from drop down");
			else if (ddlName.equalsIgnoreCase("CardType")) {
				selectDropDown(caPaymentDetails.cardTypeDdl, Value, "Value of Card Number Selected from Excel");
			} else if (ddlName.equalsIgnoreCase("Expiration Month"))
				selectDropDownByIndex(caPaymentDetails.expireMonthDdl, Random_StringGenerator(1), "value of Month selected from Excel");
			else if (ddlName.equalsIgnoreCase("Expiration Year"))
				selectDropDownByIndex(caPaymentDetails.expireYearDdl, Random_StringGenerator(1), "Value of Year selected from Excel");
			else if (ddlName.equalsIgnoreCase("Re-use Credit Card?"))
				selectDropDown(caPaymentDetails.reuseCreditCard, Value, "Value of Year selected from Excel");
			else if (ddlName.equalsIgnoreCase("Payment Method"))
				selectDropDown(caVendorRegistration.paymentMethodDdl, Value, "Value selected from Excel");
			else if (ddlName.equalsIgnoreCase("Compliance Status"))
				selectDropDown(caPeople.compliantStatusDDl, Value, "Value for Compliant Status selected");
			else if (ddlName.equalsIgnoreCase("order submitted"))
				selectDropDown(caLogin.notificationDDL, Value, "Value for the notification drop down selected");
			else if (ddlName.equalsIgnoreCase("temp badge notification"))
				selectDropDown(caLogin.tempBadgeNotificationDDL, Value, "Value of Notification selected");
		} catch (Exception e) {
			e.getMessage();
		}
		takeScreenshot();

	}

	/**
	 * @author shekarcg
	 * @category get data from UI
	 **/
	public String getData(String identifier, String Page) throws Exception {
		try {
			valuefromUI = getValue(identifier);
			System.out.println("Value from UI is ::" + valuefromUI);
			return valuefromUI;
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public String getUIData(String identifier, String Page) throws Exception {
		try {
			By xpath=createDynamicXpath("value", identifier, "xpath for " + identifier + " ");
			StatusfromUI = driver.findElement(xpath).getText();
			System.out.println("Status from UI is ::" + StatusfromUI);
			_dataRepo.writeExcel(StatusfromUI,4);
			if(identifier.equalsIgnoreCase("Compliance Status")) {
				PropertyFileReader.setProperty("OrderStatus", StatusfromUI);
			}
		return StatusfromUI;
		} catch (Exception ex) {
			return ex.toString();
		}
	}
	
	/**
	 * @author shekarcg
	 * @category Save File Using Enter key
	 **/
	public String saveFile() {
		driver.findElement(caSelfContractorRegistarion.printBtn).sendKeys(Keys.ENTER);
		return null;

	}
	
	/**
	 * @author shekarcg
	 * @category validate PDF
	 * @param fileName
	 *            and expectedText
	 **/
	public void validatePdfWithExpectedText(String fileName, String expectedText) throws Exception {
		try {
			String actualText = pdf.getPdfData(fileName);
			if (expectedText.equalsIgnoreCase("Expire Date")) {
				expectedText = dateTime.addDaysToSystemDate("14");
			}
			else if (expectedText.equalsIgnoreCase("Expire Date-1")) {
				expectedText = dateTime.addDaysToSystemDate("-1");
			}

			Assert.assertTrue(actualText.contains(expectedText), "Text present");
			reportLog(Status.PASS, "Expected text is present in pdf file:- " + expectedText, true);
			logStepInfo("Expected text is present in pdf file:-" + expectedText);
		} catch (Exception ex) {
			ex.getMessage();
			logStepInfo("Failed - Text is not matching : Expected- " + expectedText);
			reportLog(Status.FAIL, "Text is not matching - Expected- " + expectedText, false);
			scenarioFailed();
		}
	}


	public void xmlUpload(String xmlFileName) throws Exception {
		/*
		 * XML2step.get(); XML2step.post();
		 */
	}
}
