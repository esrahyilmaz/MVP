package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.awt.*;

public class CAMyadvantage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();
	Robot robot;
	String randomFirstName;
	String randomlastName;
	String uID;

	// Instant check

	By instantCheck = By.xpath("//*[@id=\"tab_instant\"]");
	By startInstant_btn = By.xpath("//*[@id=\"startNow1\"]/a/img");
	By instantCheckData = By.xpath("//div[@id='main_bkg1']");

	// Premium check
	By premiumCheck = By.xpath("//*[@id=\"tab_premium\"]");
	By startPremium_btn = By.xpath("//a[@href='preloadPremiumCheckRegistration.do']");
	By premiumCheckData = By.xpath("//div[@id='main_bkg2']");

	// single check

	By singleCheck = By.xpath("//*[@id=\"tab_single\"]");
	By startSingle_btn = By.xpath("//a[@href='preloadSingleSearchRegistration.do']");
	By identityVerification_rdbtn = By.xpath("//*[@id='729']");
	By singleCheckData = By.xpath("//div[@id='main_bkg3']");

	// resume check
	By resumeCheck = By.xpath("//*[@id=\"tab_resume\"]");
	By startResume_btn = By.xpath("//a[@href='preloadResumeCheckRegistration.do']");
	By resumeCheck_EmploymentVerification = By.xpath("//*[@id=\"763\"]");
	By resumeCheck_EducationVerification = By.xpath("//*[@id=\"762\"]");
	By resumeCheckData = By.xpath("//div[@id='main_bkg4']");

	/// *[@id='firstName']

	// order your Myadvantage

	By firstName_field = By.xpath("//*[@id='firstName']");
	By middleName_field = By.xpath("//*[@id='middleName']");
	By middleNameYes_radioBtn = By.xpath("//input[@name='middleNameRequired' and @title='Yes']");
	By middleNameNo_radioBtn = By.xpath("//input[@name='middleNameRequired' and @title='No']");
	By lastName_field = By.xpath("//*[@id='lastName']");
	By ssn = By.xpath("//input[@name='ssn']");
	By dob = By.xpath("//input[@name='dob']");
	By address1_field = By.xpath("//input[@name='addressForm.addrLine1']");

	By city_field = By.xpath("//*[@id='addressForm.cityName']");
	By state_dropdown = By.xpath("//select[@name='addressForm.stateCode']");
	By zipCode = By.xpath("//*[@id='addressForm.zipCode']");
	By areaCode = By.xpath("//input[@id='addressForm.zipCode4']");
	By submit_btn = By.xpath("//input[@value = 'SUBMIT']");
	// *[@id="startNow3"]/a/img

	// order your my advantage report

	By createUserId_field = By.xpath("//input[@name = 'vevaUser.vuUserLoginId']");
	By createPassword = By.xpath("//input[@name = 'vevaUser.vuPassword']");
	By reEnterPassword = By.xpath("//input[@name = 'password2']");

	By email_field = By.xpath("//input[@name = 'email']");
	By secretQuestion = By.xpath("//select[@name = 'vevaUser.vuSecretQuestionId']");
	By secretAnswer = By.xpath("//input[@name = 'vevaUser.vuSecretAnswer']");
	By submitRegistration_Btn = By.xpath("//*[@id='selfContractorRegistrationForm']/table/tbody/tr[11]/td[2]/input");

	// person information -- premeium check
	// employment verification
	By employerform_txt = By.xpath("//*[@id='empForm.employerName']");
	By currentEmployer_rdbtn = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input[1]");
	By addressform_txt = By.xpath("//*[@id='empForm.addressForm.addrLine1']");
	// *[@id="empForm.businessType"] for premium
	By cityForm_txt = By.xpath("//*[@id='empForm.addressForm.cityName']");
	// *[@id="empForm.addressForm.cityName"]
	By stateForm_txt = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/select");
	By zipCodeForm_txt = By.xpath("//*[@id='empForm.addressForm.zipCode']");
	By fromDate_txt = By.xpath("//*[@id='empForm.fromDate']");// *[@id="empForm.fromDate"]
	By toDate_txt = By.xpath("//*[@id='empForm.toDate']");

	By title_txt = By.xpath("//*[@id='empForm.title']");
	By superwiser_txt = By.xpath("//*[@id='empForm.supervisorName']");
	By superwiserTitle_txt = By.xpath("//*[@id='empForm.supervisorTitle']");
	By superwiserPhone_txt = By.xpath("//*[@id='empForm.supervisorPhone']");
	By duties_txt = By.xpath("//*[@id='empForm.duties']");
	By addEmploymentEntry_btn = By.xpath("//input[@name='save']");

	// education verification
	By schoolEducation_txt = By.xpath("//*[@id='eduForm.schoolName']");
	By cityEducation_txt = By.xpath("//*[@id='eduForm.addressForm.cityName']");
	By stateEducation_txt = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[11]/td[2]/select");
	By StateEducationDD=By.xpath("//*[@name='eduForm.addressForm.stateCode']");
	By didYouGraduateNo_btn = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[13]/td[2]/input[2]");
	By currentlyAttendingYes_btn = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[6]/td[4]/input[1]");
	By fieldOfStudy_txt = By.xpath("//*[@id='eduForm.major']");
	By degreeType_drpdwn = By.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[9]/td[4]/select");
	By gpa_txt = By.xpath("//*[@id='eduForm.gpa']");
	By fromEducation_txt = By.xpath("//*[@id='eduForm.from']");
	By addEducationEntry_btn = By
			.xpath("//*[@id='peopleFormTable']/tbody/tr[3]/td/table/tbody/tr[15]/td/table/tbody/tr[2]/td/b/input");

	By next_btn = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[2]/td/b/input");

	// payment
	// information======================================================================================

	By orderPaymentBtn = By.xpath("/html/body/div/table/tbody/tr/td/form/table/tbody/tr[8]/td/input[1]");
	By paymentDdl = By.xpath("/html/body/div/table/tbody/tr/td/form/table/tbody/tr[5]/td[2]/select");
	By invoiceCodeTxt = By.xpath("//*[@id='div_promo']/table/tbody/tr/td[2]/input");
	By cardTypeDdl = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[1]/td[2]/select");
	By cardNumberTxt = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[2]/td[2]/input");
	By cscNumberTxt = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[3]/td[2]/input");
	By expireMonthDdl = By.xpath("//*[@id='div_credit']/table/tbody/tr[5]/td[2]/select[1]");
	By expireYearDdl = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[5]/td[2]/select[2]");
	By reuseCreditCard = By.xpath("//*[@id='div_credit']/table/tbody/tr[6]/td[2]/select");
	By promocodeTB = By.xpath("//input[@name='promotionalCode']");
	By applyBtn = By.xpath("//input[@value='Apply']");

	// order confirmation
	By clickHere_link = By.xpath("//*[@id=\"helpText\"]/a");

	// login page
	By userId_field = By.xpath("//*[@id=\"userLoginIdToShow\"]");
	By password_field = By.xpath("//*[@id=\"passwordToShow\"]");
	By signInBtn = By.xpath("//*[@id='btn_login']/a/img");

	// fcra page
	By acceptLegalAgreement_btn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr/td/form/input[2]");

	By acceptFCRAAgreement_btn = By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/form/input[2]");

	// order additional reports
	By orderAdditionalreports_btn = By.xpath("//*[@id=\"peopleForm\"]/table/tbody/tr[1]/td/input");
	By orderTable = By.xpath("//div[@id='resultsData']");

	// packages

	By identityVerification_package = By.xpath("//*[@id='729']");
	By resumeCheckEmploymentVerification_package = By.xpath("//*[@id='763']");

	// My results
	// a[contains(text(),'View Report')]
	By viewReport_link = By.xpath("//a[contains(text(),'View Report')]");
	By orderId = By.xpath("//a[contains(text(),'View Report')]");
	By orderDate = By.xpath("//a[contains(text(),'View Report')]");
	By orderStatus = By.xpath("//a[contains(text(),'View Report')]");
	By packageNameInResultsPage = By.xpath("//a[contains(text(),'View Report')]");

	private static By AdministrationTAB = By.xpath("(//a[.='> Administration'])[last()]");
	private static By AddNewUserTAB = By.xpath("//a[.='Add New User']");
	private static By SearchUserTAB = By.xpath("//a[.='Search Users']");

	// validate promocode

	private static By OrderAdditionalReportsBTN = By.xpath("//input[@name='orderBGC']");
	private static By PremiumCheckChkBox = By.xpath("//input[@name='vevaPackage.packageId' and @id='500']");
	private static By InstantCheckChkBox = By.xpath("//input[@name='vevaPackage.packageId' and @id='510']");
	private static By ResumeCheckChkBox = By.xpath("//input[@name='vevaPackage.packageId' and @id='763']");
	private static By SingleCheckChkBox = By.xpath("//input[@name='vevaPackage.packageId' and @id='737']");
	private static By nextBtn = By.xpath("//input[@value='Next']");
	private static By cancelBtn = By.xpath("//input[@value='Cancel']");
	private static By logoutBtn=By.xpath("//a[.='Logout']");

//========================================================================================================================		

	public void orderYourMyAdvantageReport() {
		try {
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;

			String ssnNumber = "87878" + Random_NumberGenerator(4);

			EnterText(firstName_field, "enter first name", _dataRepo.getData("firstName") + tmpFirstName);
			EnterText(lastName_field, "enter last name", _dataRepo.getData("lastName"));
			wait(2);
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName_field, "enter middle name", _dataRepo.getData("middleName"));

			if (scenarioName.contains("My Advantage Promocode validation")) {
				EnterText(ssn, "enter ssn", SSN);
			} else {
				EnterText(ssn, "enter ssn", ssnNumber);
			}
			EnterText(dob, "enter dob", _dataRepo.getData("dob"));

			EnterText(address1_field, "enter the address", _dataRepo.getData("address1"));
			EnterText(city_field, "enter city name", _dataRepo.getData("city"));
			selectDropDownByValue(state_dropdown, "GA", "click to select value");
			EnterText(zipCode, "enter zip code", _dataRepo.getData("pin"));

			clickElementWithWait(submit_btn, "click on submit button");
			reportLog(Status.PASS, "User information provided", true);
		} catch (Exception e) {
		}
	}

	public void createUserId() {

		try {
			String userID = "8787" + Random_NumberGenerator(5);
			uID = userID;
			EnterText(createUserId_field, "enter to create user Id", userID);
			EnterText(createPassword, "enter password", _dataRepo.getData("Password"));
			EnterText(reEnterPassword, "enter password", _dataRepo.getData("Password"));
			if (scenarioName.contains("My Advantage Promocode validation")) {
				EnterText(email_field, "enter email", EmailID);
				selectDropDownByValue(secretQuestion, "2", "click to select value");
				EnterText(secretAnswer, "enter ssn", _dataRepo.getData("secretAnswer"));
			} else {
				EnterText(email_field, "enter email", _dataRepo.getData("email"));
				selectDropDownByValue(secretQuestion, "2", "click to select value");
				EnterText(secretAnswer, "enter ssn", _dataRepo.getData("secretAnswer"));
			}

			takeScreenshot();
			clickElementWithWait(submitRegistration_Btn, "click on continue button");
			reportLog(Status.PASS, "New User id created", true);

		} catch (Exception e) {

		}
	}

	public void createUserIdForSingleSearch() {

		try {
			String userID = "8787" + Random_NumberGenerator(5);
			uID = userID;
			EnterText(createUserId_field, "enter to create user Id", userID);
			EnterText(createPassword, "enter password", _dataRepo.getData("Password"));
			EnterText(reEnterPassword, "enter password", _dataRepo.getData("Password"));
			EnterText(email_field, "enter email", _dataRepo.getData("email"));
			selectDropDownByValue(secretQuestion, "2", "click to select value");
			EnterText(secretAnswer, "enter ssn", _dataRepo.getData("secretAnswer"));
			clickElementWithWait(identityVerification_package, "select the package");
			clickElementWithWait(submitRegistration_Btn, "click on continue button");
			reportLog(Status.PASS, "User id created for single search", true);

		} catch (Exception e) {

		}
	}

	public void createUserIdForResumeCheck() {

		try {
			String userID = "8787" + Random_NumberGenerator(5);
			uID = userID;
			EnterText(createUserId_field, "enter to create user Id", userID);
			EnterText(createPassword, "enter password", _dataRepo.getData("Password"));
			EnterText(reEnterPassword, "enter password", _dataRepo.getData("Password"));
			EnterText(email_field, "enter email", _dataRepo.getData("email"));
			selectDropDownByValue(secretQuestion, "2", "click to select value");
			EnterText(secretAnswer, "enter ssn", _dataRepo.getData("secretAnswer"));
			clickElementWithWait(resumeCheckEmploymentVerification_package, "select the package");
			clickElementWithWait(submitRegistration_Btn, "submit button");

			reportLog(Status.PASS, "User id created for resume check", true);

		} catch (Exception e) {

		}
	}

	public void employmentVerification() {
		try {
			EnterText(employerform_txt, "enter to create user Id", _dataRepo.getData("employer"));
			clickElementWithWait(currentEmployer_rdbtn, "click to select yes radio button");
			EnterText(addressform_txt, "enter the address", _dataRepo.getData("address1"));
			EnterText(cityForm_txt, "enter city name", _dataRepo.getData("city"));
			selectDropDownByValue(stateForm_txt, "GA", "clxick to select value");
			EnterText(zipCodeForm_txt, "enter zip code", _dataRepo.getData("pin"));
			EnterText(fromDate_txt, "select the employment starting date", _dataRepo.getData("from"));
			EnterText(title_txt, "enter to provide the job title", _dataRepo.getData("title"));
			EnterText(superwiser_txt, "enter to provide superwiser", _dataRepo.getData("superwiser"));
			EnterText(superwiserTitle_txt, "enter to create user Id", _dataRepo.getData("superwiserTitle"));
			EnterText(superwiserPhone_txt, "enter to create user Id", _dataRepo.getData("superwiserPhone"));
			EnterText(duties_txt, "enter to provide details", _dataRepo.getData("duties"));

			takeScreenshot();
			clickElementWithWait(addEmploymentEntry_btn, "click on the button");
			reportLog(Status.PASS, "Employment verification completed", true);

		} catch (Exception e) {

		}
	}

	public void employmentVerificationForResumeCheck() {
		try {
			EnterText(employerform_txt, "enter to create user Id", _dataRepo.getData("employer"));
			clickElementWithWait(currentEmployer_rdbtn, "click to select yes radio button");
			EnterText(addressform_txt, "enter the address", _dataRepo.getData("address1"));
			EnterText(cityForm_txt, "enter city name", _dataRepo.getData("city"));
			selectDropDownByValue(stateForm_txt, "GA", "clxick to select value");
			EnterText(zipCodeForm_txt, "enter zip code", _dataRepo.getData("pin"));
			EnterText(fromDate_txt, "select the employment starting date", _dataRepo.getData("from"));
			EnterText(title_txt, "enter to provide the job title", _dataRepo.getData("title"));
			EnterText(superwiser_txt, "enter to create user Id", _dataRepo.getData("superwiser"));
			EnterText(superwiserTitle_txt, "enter to create user Id", _dataRepo.getData("superwiserTitle"));
			EnterText(superwiserPhone_txt, "enter to create user Id", _dataRepo.getData("superwiserPhone"));
			EnterText(duties_txt, "enter to provide details", _dataRepo.getData("duties"));

			takeScreenshot();
			clickElementWithWait(next_btn, "click on the button");
			reportLog(Status.PASS, "Employment verification completed for resume check", true);

		} catch (Exception e) {

		}
	}

	public void educationVerification() {
		try {
			EnterText(schoolEducation_txt, "enter school name", _dataRepo.getData("school"));
			// EnterText(address1_field, "enter the address",
			// _dataRepo.getData("address1"));
			if(verifyElementPresence(stateEducation_txt)) {
				selectDropDownByValue(stateEducation_txt, "GA", "click to select value");
			}else if(verifyElementPresence(StateEducationDD)) {
				selectDropDownByValue(StateEducationDD, "GA", "click to select value");
			}
			EnterText(cityEducation_txt, "enter city name", _dataRepo.getData("city"));
			
			// EnterText(zipCode, "enter zip code", _dataRepo.getData("pin"));
			clickElementWithWait(didYouGraduateNo_btn, "click to select");
			clickElementWithWait(currentlyAttendingYes_btn, "click to select");
			EnterText(fieldOfStudy_txt, "enter the field of study", _dataRepo.getData("fieldOfStudy1"));
			selectDropDownByValue(degreeType_drpdwn, "Bachelors", "clxick to select value");
			EnterText(fromEducation_txt, "provide the education starting date", _dataRepo.getData("from"));

			takeScreenshot();
			clickElementWithWait(addEducationEntry_btn, "click on instant check");

			clickElementWithWait(next_btn, "click on instant check");
			reportLog(Status.PASS, "Education verification completed", true);

		} catch (Exception e) {

		}
	}

	public void invoicePaymentOrderConfirmation() {
		try {
			if (scenarioName.contains("My Advantage Promocode validation")) {
				EnterText(promocodeTB, "enter Promocode", Promocode1);
				clickElement(applyBtn, "Apply");
				verifyTextPresence("$9.95");
			}
			selectDropDownByValue(paymentDdl, "P", "click to select value");
			EnterText(invoiceCodeTxt, "enter Promocode", "PROMOCODE");

			takeScreenshot();
			clickElementWithWait(orderPaymentBtn, "click on continue button");

			takeScreenshot();
			clickElementWithWait(clickHere_link, "click on continue button");

			takeScreenshot();
			reportLog(Status.PASS, "Payment done by invoice", true);

		} catch (Exception e) {

		}
	}

	public void creditCardPaymentOrderConfirmation() {
		try {
			selectDropDownByValue(paymentDdl, "C", "click to select value");
			selectDropDownByValue(cardTypeDdl, "Visa", "click to select value");
			EnterText(cardNumberTxt, "enter card number", _dataRepo.getData("cardNumber"));
			EnterText(cscNumberTxt, "enter csc number", _dataRepo.getData("cscNumber"));
			selectDropDownByValue(expireMonthDdl, "03", "click to select value");
			selectDropDownByValue(expireYearDdl, "2030", "click to select value");
			wait(2);
			takeScreenshot();
			clickElementWithWait(orderPaymentBtn, "click on continue button");
			wait(2);
			takeScreenshot();
			if(verifyElementPresence(clickHere_link)) {
				clickElementWithWait(clickHere_link, "click on continue button");
			}			

			takeScreenshot();
			reportLog(Status.PASS, "Payment done by credit card", true);

		} catch (Exception e) {

		}
	}

	public void signIn() {
		try {
			takeScreenshot();
			EnterText(userId_field, "enter user ID", uID);
			EnterText(password_field, "enter the password", _dataRepo.getData("Password"));
			takeScreenshot();
			clickElementWithWait(signInBtn, "click on the sign in button");
			takeScreenshot();
			if (verifyElementPresence(SecretAnswerTB)) {
				EnterText(SecretAnswerTB, "Secret Answer","red");
				clickElement(RectifyBTN, "Rectify");
			}
			if (verifyElementPresence(SecretAnswerTB)) {
				EnterText(SecretAnswerTB, "Secret Answer","blue");
				clickElement(RectifyBTN, "Rectify");
			}
			if(verifyElementPresence(acceptLegalAgreement_btn)) {
				clickElementWithWait(acceptLegalAgreement_btn, "click to accept legal agreement");
				takeScreenshot();
			}		
			clickElementWithWait(acceptFCRAAgreement_btn, "click to accept FCRA agreement");
			takeScreenshot();
			orderValidationMyAd();
			System.out.println("after sign in >>>>>>>>>>>>>>>>>>>>>");
			reportLog(Status.PASS, "User is signed in", true);

		} catch (Exception e) {

		}
	}

	// =========================Instant check method
	// ===================================

	public void instantCheck() {
		try {

			clickElementWithWait(instantCheck, "click on instant check");
			String instantCheckDataValidation = driver.findElement(instantCheckData).getText();
			System.out.println(instantCheckDataValidation);

			Assert.assertTrue(instantCheckDataValidation.contains("Get Started Now with"));
			Assert.assertTrue(instantCheckDataValidation.contains("Instant Check"));
			Assert.assertTrue(instantCheckDataValidation.contains("$24.95"));
			Assert.assertTrue(instantCheckDataValidation.contains("Package Includes:"));
			Assert.assertTrue(instantCheckDataValidation.contains("Identity authentication"));
			Assert.assertTrue(instantCheckDataValidation.contains("Nationwide criminal search using"));
			Assert.assertTrue(instantCheckDataValidation.contains("the First Advantage� National Criminal File"));
			reportLog(Status.PASS, "validated instant check data", true);

			clickElementWithWait(startInstant_btn, "click on instant check");

			reportLog(Status.PASS, "Instant check selected", true);

		} catch (Exception e) {

		}
	}

	// =========================Premium check method
	// ===================================

	public void premiumCheck() {
		try {
			driver.navigate().refresh();
			clickElementWithWait(premiumCheck, "click on premium check");
			String premiumCheckDataValidation = driver.findElement(premiumCheckData).getText();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + premiumCheckDataValidation);
			verifyStringContainsText(premiumCheckDataValidation, "Premium Check");
			verifyStringContainsText(premiumCheckDataValidation, "$64.95");
			verifyStringContainsText(premiumCheckDataValidation, "Package Includes:");
			verifyStringContainsText(premiumCheckDataValidation, "Identity authentication");
			verifyStringContainsText(premiumCheckDataValidation, "Nationwide criminal search using");
			verifyStringContainsText(premiumCheckDataValidation, "the First Advantage� National Criminal File");
			verifyStringContainsText(premiumCheckDataValidation, "Additional County Criminal Searches");
			verifyStringContainsText(premiumCheckDataValidation, "Education Verification");
			verifyStringContainsText(premiumCheckDataValidation, "Employment Verificatio");
			reportLog(Status.PASS, "validated premium check data", true);

			clickElementWithWait(startPremium_btn, "click on premium check button");
			reportLog(Status.PASS, "Premium check selected", true);
		} catch (Exception e) {

		}
	}

	// =========================Single searches method
	// ===================================

	public void singleSearches() {
		try {
			driver.navigate().refresh();
			clickElementWithWait(singleCheck, "click on single check ");
			String singleSearchDataValidation = driver.findElement(singleCheckData).getText();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + singleSearchDataValidation);
			verifyStringContainsText(singleSearchDataValidation, "Single Searches");
			verifyStringContainsText(singleSearchDataValidation, "Starting at $10.00");
			verifyStringContainsText(singleSearchDataValidation, "Access fees may apply");
			verifyStringContainsText(singleSearchDataValidation,
					"Choose one from a selection of nine market leading background products, including: verification of identity, education qualifications, employment and professional credentials; criminal searches such as First Advantage National Criminal File, US State Sexual Offender Search, US County Criminal Search, US Federal Criminal Search and a Reference Check.");

			reportLog(Status.PASS, "validated single search data", true);

			clickElementWithWait(startSingle_btn, "click on single searches button");
			reportLog(Status.PASS, "Single searches selected", true);
		} catch (Exception e) {

		}
	}

	// =========================Resume check method
	// ===================================

	public void resumeCheck() {
		try {
			driver.navigate().refresh();
			clickElementWithWait(resumeCheck, "click on resume check");
			String resumeCheckDataValidation = driver.findElement(resumeCheckData).getText();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + resumeCheckDataValidation);
			verifyStringContainsText(resumeCheckDataValidation, "Resume Check");
			verifyStringContainsText(resumeCheckDataValidation, "Starting at $24.95");
			verifyStringContainsText(resumeCheckDataValidation,
					"First Advantage� Resume Check distinguishes you from other job candidates by pre-verifying details of your resume through a trusted, market-leading employment screening provider. It adds credibility to your social networking profile by certifying details provided are correct and current.");
			verifyStringContainsText(resumeCheckDataValidation,
					"Each Resume Check package includes either an education verification or an employment verification but also includes an Online Certificate provided through a URL. You can link this to your online social networking profile or include in your resume.");
			verifyStringContainsText(resumeCheckDataValidation,
					"NOTE: Your Resume Check certificate will expire exactly one year after your original certificate is issued, but can be easily renewed.");

			reportLog(Status.PASS, "validated resume check data", true);

			clickElementWithWait(startResume_btn, "click on resume check button");
			reportLog(Status.PASS, "Resume check selected", true);
		} catch (Exception e) {

		}
	}

	public void orderValidationMyAd() {
		try {
			String orderValidation = driver.findElement(orderTable).getText();
//					System.out.println("Print Order table "+ orderValidation);
//					Assert.assertTrue("Status should be in progress", orderValidation.contains("Order Id Order Date Order Status Package Name Actions"));
//					Assert.assertTrue("Status should be in progress", orderValidation.contains("In Progress"));

			if (orderValidation.contains("In Progress")) {
				reportLog(Status.PASS, "the status is :-> In progress", true);
			} else {
				reportLog(Status.FAIL, "status might be empty", true);
			}

		} catch (Exception e) {

		}
	}

	public void presentOfAdmin() {
		if (verifyElementPresence(AdministrationTAB)) {
			clickElement(AdministrationTAB, "Administration");
			reportLog(Status.PASS, "Administration TAB is present", false);
		} else {
			reportLog(Status.FAIL, "Administration TAB is not present", false);
		}

		if (verifyElementPresence(SearchUserTAB)) {
			reportLog(Status.PASS, "SearchUser TAB is present", false);
		} else {
			reportLog(Status.FAIL, "SearchUser TAB is not present", false);
		}

		if (verifyElementPresence(AddNewUserTAB)) {
			reportLog(Status.FAIL, "AddNewUser TAB is present", false);
		} else {
			reportLog(Status.PASS, "AddNewUser TAB is not present", false);
		}
	}

	public void validatePromocode() {
		clickElement(OrderAdditionalReportsBTN, "Order Additional Report");
		clickElement(InstantCheckChkBox, "Instant Check box");
		clickElement(nextBtn, "Next");
		verifyTextPresence("14.00");
		EnterText(promocodeTB, "enter Promocode", Promocode1);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code is already used.");
		EnterText(promocodeTB, "enter Promocode", Promocode2);
		clickElement(applyBtn, "Apply");
		verifyTextPresence("$9.95");
		clickElement(cancelBtn, "cancel");
		clickElement(OrderAdditionalReportsBTN, "Order Additional Report");
		clickElement(PremiumCheckChkBox, "Premium check");
		clickElement(nextBtn, "Next");
		employmentVerification();
		educationVerification();
		verifyTextPresence("14.00");
		EnterText(promocodeTB, "enter Promocode", Promocode1);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code not found");
		EnterText(promocodeTB, "enter Promocode", Promocode2);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code not found");
		EnterText(promocodeTB, "enter Promocode", "");
		selectDropDownByValue(paymentDdl, "P", "click to select value");
		EnterText(invoiceCodeTxt, "enter Promocode", "PROMOCODE");
		clickElementWithWait(orderPaymentBtn, "click on continue button");
		clickElement(logoutBtn, "Logout");
		signIn();
		clickElement(OrderAdditionalReportsBTN, "Order Additional Report");
		clickElement(ResumeCheckChkBox, "resume check");
		clickElement(nextBtn, "Next");
		employmentVerificationForResumeCheck();
		verifyTextPresence("14.00");
		EnterText(promocodeTB, "enter Promocode", Promocode1);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code not found");
		EnterText(promocodeTB, "enter Promocode", Promocode2);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code not found");
		EnterText(promocodeTB, "enter Promocode", "");
		creditCardPaymentOrderConfirmation();
		clickElement(logoutBtn, "Logout");
		signIn();
		clickElement(OrderAdditionalReportsBTN, "Order Additional Report");
		clickElement(SingleCheckChkBox, "Single check");
		clickElement(nextBtn, "Next");
		verifyTextPresence("14.00");
		EnterText(promocodeTB, "enter Promocode", Promocode1);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code is already used.");
		EnterText(promocodeTB, "enter Promocode", Promocode2);
		clickElement(applyBtn, "Apply");
		verifyTextPresence("$9.95");
		creditCardPaymentOrderConfirmation();
		clickElement(logoutBtn, "Logout");
		signIn();
		clickElement(OrderAdditionalReportsBTN, "Order Additional Report");
		clickElement(SingleCheckChkBox, "Single check");
		clickElement(nextBtn, "Next");
		EnterText(promocodeTB, "enter Promocode", Promocode2);
		clickElement(applyBtn, "Apply");
		verifyWarningTextPresence("Promo code is already used.");
		clickElement(cancelBtn, "cancel");
	}
}