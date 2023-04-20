package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

public class CALoginPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	// -------------------------Page Title-------------------------//
		By loginTitle = By.xpath("//*[text()='Sign Into Your Account']");
		
		By logoutBtn=By.xpath("//a[text()='Log Out']");
		By noticeTitle = By.xpath("//*[text()='NOTICE']");
		public By recertificationTitle = By.xpath("//*[text()='User Recertification']");
		By firstAdvantageTitle = By.xpath("//*[text()='First 	Advantage�']");
		public By sessionOverrideTitle = By.xpath("//b[text()='Session Override']");
		By vendorErrorPage = By.xpath("//*[contains(text(),'Your company already has a contractor account')]");

		// -------------------------Page Text-------------------------//
		By userIDText = By.xpath("//input[@id='userLoginIdToShow']");
		By passwordText = By.xpath("//input[@id='passwordToShow']");
		public By secretAnswerText = By.xpath("//input[@name='userRecertSecretAnswer']");
		By warningFCRAText = By.xpath("//*[@id='errorMessages']");

		// -------------------------Page Button-------------------------//

		By logInBtn = By.xpath("//*[@id='login_main_button']/a");
		By acceptFCRABtn = By.xpath("//*[@id='fca_agreement_id']");
		By acceptLegalAgreementBtn=By.xpath("//input[@value='ACCEPT LEGAL AGREEMENT']");
		By acceptLegalAgreementMyadvantageBtn=By.xpath("//input[@value='ACCEPT FCRA AGREEMENT']");
		By declineFCRABtn = By.xpath("/html/body/table/tbody/tr/td[2]/form/input[3]");
		By acceptFCRAchkBox=By.xpath("//input[@name='acceptFCRA']");
		By roasterUpToDatechkBox=By.xpath("//input[@name='rosterIsUpToDate']");
		By continueBTN=By.xpath("//input[@name='accept']");
		public By proceedwithLoginBtn = By.xpath("//*[@id='proceed_login_divid']");
		public By proceedwithLoginMyadvantageBtn = By.xpath("//input[@value='Proceed with Login']");
		public By recertifyBtn = By.xpath("//input[@value='RECERTIFY']");
		By submitBtn = By.xpath("//*[@id='leftCol']/form/div/input");
		By nextBtn = By.xpath("/html/body/div[2]/div/form/input[2]");

		By cartBtn = By.xpath("//*[@id=\"shoppingCart\"]");

		// -------------------------Page Drop Downs-------------------------//
		By OrganizationDdl = By.xpath("//*[@id=\"leftCol\"]/form/div[2]/select");
		By lobDdl = By.xpath("//*[@name='lobId']");
		By BackgroundScoreDD=By.xpath("//select[@name='voCaseScore']");

		// -------------------------Page Label-------------------------//
		By lobLbl = By.xpath("//*[@id='leftCol']/form/div");
		By userIDLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td");
		By OkBtn = By.xpath("//button[.='Ok']");
		By returnToLoginBtn = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/input");

		By submitHOMEDEPOTRBtn = By.xpath("//*[@id='leftCol']/form/div[3]/input");
		By submitFRGTBtn = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[7]/td/input[1]");
		By signInBtn = By.xpath("//div[@id='btn_login']//img");

		By vendorRegLink = By.xpath("//*[@id='clickhere_text']/a");
		By forgetPasswordLink = By.xpath("//*[@id=\"login_main_forgot\"]/a");
		

		By declineFcraBtn = By.xpath("//input[@name='decline']");
		By errorMsg = By.xpath("//div[@id='errorMessages']");

		By notificationDDL = By
				.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr/td/form/table[2]/tbody/tr[3]/td[2]/select");
		By tempBadgeNotificationDDL = By.xpath("//*[@name='tempBadgeNotification']");
		/**
		 * @author mishrbik
		 * @category menu header xpaths
		 **/
		By homeBtn = By.xpath("//*[@id=\"menuHeaderId\"]/tbody/tr/td[1]/a");

		By vendorMenuBtn = By.xpath("(//a[contains(text(),'> Vendor')])[1]");
		By searchVendorBtn = By.xpath("//a[contains(text(),'Search Vendor')]");
		By peopleMenuBtn = By.xpath("(//a[contains(text(),'People')])[1]");
		By peopleSearchBtn = By.xpath("//a[contains(text(),'Search People')]");
		By addNewPeopleMenuBtn = By.xpath("//a[contains(text(),'Add New Person')]");
		By addExistingPeopleMenuBtn = By.xpath("//a[contains(text(),'Add Existing Person')]");
		By peopleBatchLoadMenuBtn = By.xpath("//a[contains(text(),'People Batch Load')]");
		By orderMenuBtn = By.xpath("(//a[contains(text(),'Order')])[1]");
		By orderSearchBtn = By.xpath("//a[contains(text(),'Search Order')]");

		By unselectVendorBtn = By.xpath("//*[@id=\"menu2\"]/table/tbody/tr[2]/td/a");

		By reportMenuBtn = By.xpath("//*[@id=\"menuHeaderId\"]/tbody/tr/td[5]/a");
		By vendorComplianceReportMenuBtn = By.xpath("//*[@id=\"menu4\"]/table/tbody/tr[1]/td/a");
		By scheduledReportMenuBtn = By.xpath("//*[@id=\"menu4\"]/table/tbody/tr[2]/td/a");
		By dashboardReportMenuBtn = By.xpath("//*[@id=\"menu4\"]/table/tbody/tr[3]/td/a");
		By dashboardReportMenuProdBtn = By.xpath("//a[@href='viewDashboardReports.do']");
		By activeBadgeReportBtn = By.xpath("//a[.='Active Badge Report']");
		By specialReportMenuBtn = By.xpath("//*[@id=\"menu4\"]/table/tbody/tr[4]/td/a");
		By backgroundReportMenuBtn = By.xpath("//*[@id=\"menu4\"]/table/tbody/tr[5]/td/a");
		// By
		// upcomingRenewalReportMenuBtn=By.xpath("//*[@id=\"menu4\"]/table/tbody/tr[3]/td/a");

		By administrationMenuBtn = By.xpath("//*[@id=\"menuHeaderId\"]/tbody/tr/td[7]/a");
		By searchUserMenuBtn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[1]/td/a");
		By contactMenuBtn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[3]/td/a");
		By addNewUserMenuBtn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[2]/td/a");
		By emailPreferencesMenuBtn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[4]/td/a");
		By profileMenuBtn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[5]/td/a");
		By userfieldConfigMenuBtn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[6]/td/a");
		By ClientOrderReportLink=By.xpath("//a[.='Client Order Report']");
		
		By adminMenuBtn = By.xpath("//*[@id=\"menuHeaderId\"]/tbody/tr/td[6]/a");
		By profileMenu2Btn = By.xpath("//*[@id=\"menu1\"]/table/tbody/tr[4]/td/a");
		
		By BusinessPreScreeningLink=By.xpath("//a[.='> Business Pre-Screening']");
		By ReportLink=By.xpath("//a[.='> Report']");
		By OrderReportLink=By.xpath("//a[.='Order Reports']");
		By SearchReportLink=By.xpath("//a[.='Search Reports']");
		By VendorComplianceReportLink=By.xpath("//a[.='Vendor Compliance Report']");
		By BusinessProcessingLoadLink=By.xpath("//a[.='BusinessProcessing load']");
		By AdminstrationLink=By.xpath("//td//a[.='> Administration']");
	// ***********************************Function from login
	// pages***********************************//

	String randomString = Random_StringGenerator(8);
	PropertyFileReader _config = new PropertyFileReader();
	DatabaseClass database=new DatabaseClass();
	By userID;
	

	public void login(String ApplicationName, String checkFor) throws Exception {
		try {
				
			if(scenarioName.contains("DigitalBadge_")) {
				 userID = By.id("userLoginIdToShow");
			}else {
				 userID = createDynamicXpath("text", "User ID", "User Id xpath");
			}
			
			By userPassword = createDynamicXpath("text", "Password", "Password Entered");

			if (checkFor.equalsIgnoreCase("valid")) {
				switch (ApplicationName.toLowerCase()) {
				
				case "aspenvendoruser":
					userName = PropertyFileReader.getProperty("AspenUserNameVendorUser");
					password = PropertyFileReader.getProperty("AspenPasswordVendorUser");
					CurrentPasswordUser=password;
					
					break;
				case "vendoruserproduction":
					database.getLogin(ApplicationName);
					break;
				case "nonhomedepotcustusernotification":
					userName = PropertyFileReader.getProperty("NotificationNONHDuser");
					password = PropertyFileReader.getProperty("NotificationNONHDpw");
					CurrentPasswordUser=password;
					break;
				case "homedepotcustusernotification":
					userName = PropertyFileReader.getProperty("NotificationHDuser");
					password = PropertyFileReader.getProperty("NotificationHDpw");
					CurrentPasswordUser=password;
					break;
				case "homedepotcustusernonotification":
					userName = PropertyFileReader.getProperty("NoNotificationHDcustuser");
					password = PropertyFileReader.getProperty("NoNotificationHDcustpw");
					CurrentPasswordUser=password;
					break;
				case "homedepotvendorusernonotification":
					userName = PropertyFileReader.getProperty("NoNotificationHDvendoruser");
					password = PropertyFileReader.getProperty("NoNotificationHDvendorpw");
					CurrentPasswordUser=password;
					break;
				case "nonhomedepotcustusernonotification":
					userName = PropertyFileReader.getProperty("NoNotificationNONHDcustuser");
					password = PropertyFileReader.getProperty("NoNotificationNONHDcustpw");
					CurrentPasswordUser=password;
					break;
				case "nonhomedepotvendorusernonotification":
					userName = PropertyFileReader.getProperty("NoNotificationNONHDvendoruser");
					password = PropertyFileReader.getProperty("NoNotificationNONHDvendorpw");
					CurrentPasswordUser=password;
					break;
				case "homedepotamritavenuser":
					userName = PropertyFileReader.getProperty("AmritaVenUser");
					password = PropertyFileReader.getProperty("AmritaPassword");
					break;
				case "lockinmartinvendoruser":
					userName = PropertyFileReader.getProperty("LockinMartinUserNameVendorUser");
					password = PropertyFileReader.getProperty("LockinMartinPasswordVendorUser");
					break;
				case "operationuser":
					database.getLogin(ApplicationName);
					break;
				case "lowesvendoruser":
					userName = PropertyFileReader.getProperty("LowesUserNameVendorUser");
					password = PropertyFileReader.getProperty("LowesPasswordVendorUser");
					break;
				case "kaiservendoruser":
					userName = PropertyFileReader.getProperty("KaiserUserNameVendorUser");
					password = PropertyFileReader.getProperty("KaiserPasswordVendorUser");
					break;
				case "kaisercustuser":
					userName = PropertyFileReader.getProperty("KaiserUserNameCustUser");
					password = PropertyFileReader.getProperty("KaiserPasswordCustUser");
					break;
				case "homedepotvendoruser":
					userName = PropertyFileReader.getProperty("CustHDUserNameVendorUser");
					password = PropertyFileReader.getProperty("CustHDPasswordVendorUser");
					CurrentPasswordUser=password;
					break;
				case "homedepotvendoruseruat":
					userName = PropertyFileReader.getProperty("CustHDUserNameVendorUserUAT");
					password = PropertyFileReader.getProperty("CustHDPasswordVendorUserUAT");
					CurrentPasswordUser=password;
					break;
				case "homedepotcustuseruat":
					userName = PropertyFileReader.getProperty("CustHDUserNameCustUserUAT");
					password = PropertyFileReader.getProperty("CustHDPasswordCustUserUAT");
					CurrentPasswordUser=password;
					break;
				case "homedepotcustuser":
					userName = PropertyFileReader.getProperty("CustHDUserNameCustUser");
					password = PropertyFileReader.getProperty("CustHDPasswordCustUser");
					CurrentPasswordUser=password;
					break;
				case "nonhomedepotvendoruser":
					userName = PropertyFileReader.getProperty("CustNONHDUserNameVendorUser");
					password = PropertyFileReader.getProperty("CustNONHDPasswordVendorUser");
					CurrentPasswordUser=password;
					break;
				case "nonhomedepotcustuser":
					userName = PropertyFileReader.getProperty("CustNONHDUserNameCustUser");
					password = PropertyFileReader.getProperty("CustNONHDPasswordCustUser");
					CurrentPasswordUser=password;
					break;
				case "useradmin":
					userName = UserIDUserAdmin;
					password = CurrentPasswordUser;
					break;
				case "userview":
					userName = UserIDUserView;
					password = CurrentPasswordUser;
					break;
				case "userupdate":
					userName = UserIDUserUpdate;
					password = CurrentPasswordUser;
					break;
				case "usersummary":
					userName = UserIDUserSummary;
					password = CurrentPasswordUser;
					break;
				case "homedepot":
					userName = PropertyFileReader.getProperty("CustHDUserName");
					password = PropertyFileReader.getProperty("CustHDPassword");
					break;
				case "homedepot1":
					userName = PropertyFileReader.getProperty("CustHDUserName1");
					password = PropertyFileReader.getProperty("CustHDPassword1");
					break;
				case "homedepot2":
					userName = PropertyFileReader.getProperty("CustHDUserName2");
					password = PropertyFileReader.getProperty("CustHDPassword2");
					break;
				case "homedepot3":
					userName = PropertyFileReader.getProperty("CustHDUserName3");
					password = PropertyFileReader.getProperty("CustHDPassword3");
					break;
				case "homedepot4":
					userName = PropertyFileReader.getProperty("CustHDUserName4");
					password = PropertyFileReader.getProperty("CustHDPassword4");
					break;
				case "homedepot5":
					userName = PropertyFileReader.getProperty("CustHDUserName5");
					password = PropertyFileReader.getProperty("CustHDPassword5");
					break;
				case "homedepot6":
					userName = PropertyFileReader.getProperty("CustHDUserNameUAT");
					password = PropertyFileReader.getProperty("CustHDPasswordUAT");
					break;
					
				case "homedepotvendor":
					userName = PropertyFileReader.getProperty("VenHDUserName");
					password = PropertyFileReader.getProperty("VenHDPassword");
					CurrentPasswordUser=password;
					break;
				case "aspengrove":
					userName = PropertyFileReader.getProperty("CustAspenUserName");
					password = PropertyFileReader.getProperty("CustAspenPassword");
					break;
				case "aspengrovevendor":
					userName = PropertyFileReader.getProperty("VenAsepenUserName");
					password = PropertyFileReader.getProperty("VenAsepenPassword");
					break;
				case "fadv":
					database.getLogin(ApplicationName);
					break;

				default:
					System.out.println("Please enter valid application name !!!");
					break;
				}
				
				
				
				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);

			} else if (checkFor.equalsIgnoreCase("AlphaUser")) {
				userName = Random_StringGenerator(8);
				password = userName;

				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
			} else if (checkFor.equalsIgnoreCase("NumericUser")) {
				userName = Random_NumberGenerator(8);
				password = userName;

				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);

			} else if (checkFor.equalsIgnoreCase("AlphaNumeric")) {
				userName = Random_NumberGenerator(3) + Random_StringGenerator(5);
				password = userName;

				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);

			} else if (checkFor.equalsIgnoreCase("Random")) {
				userName = randomString;
				password = randomString;

				EnterText(userID, "Enter username", userName);
				EnterText(userPassword, "Enter Password", password);
				
			} else if (checkFor.equalsIgnoreCase("onlyUser")) {
				userName = Random_StringGenerator(8);
				EnterText(userID, "Enter username", userName);

			} else if (checkFor.equalsIgnoreCase("onlyPassword")) {
				driver.findElement(userID).clear();
				password = Random_StringGenerator(8);
				EnterText(userPassword, "Enter Password", password);
				
			}else if (checkFor.equalsIgnoreCase("validUserName")) {
				userName = PropertyFileReader.getProperty("CustHDUserName");
				EnterText(userID, "Enter username", userName);		
			}else {
				System.out.println("Invalid request sending::" + checkFor);
			}

			logStepInfo("Log in  completed!!!"+userName);
			reportLog(Status.PASS,"Log in  completed!!!"+userName, true);

			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in login():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in login():- "+ex.getMessage(), true);
			}
	}

	public void secretQuestion() throws Exception {
		try {
			EnterText(secretAnswerText, "userRecertSecretAnswer", "blue");
			clickElementWithWait(recertifyBtn, "Click on Re certify");
			
			logStepInfo("Secret Question Answered!!!");
			reportLog(Status.PASS,"Secret Question Answered!!!", true);

		}

		catch (Exception ex) {
			logStepInfo("Exception occured in secretQuestion():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in secretQuestion():- "+ex.getMessage(), true);

		}
	}

	public void checkDeclineFCRA() {
		try {
			clickElementWithWait(declineFcraBtn, "Click on decline FCRA agreement button");
			verifyElementPresence(errorMsg);
			
			logStepInfo("Decline FCRA Error Message Verified!!!");
			reportLog(Status.PASS,"Decline FCRA Error Message Verified!!!", true);


		} catch (Exception ex) {
			logStepInfo("Exception occured in checkDeclineFCRA():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in checkDeclineFCRA():- "+ex.getMessage(), true);
		}
	}
}