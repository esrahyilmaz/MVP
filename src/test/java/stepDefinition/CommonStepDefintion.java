package stepDefinition;

import Report.ReportWriter;
import Utility.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import seleniumhelper.AHKActions;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommonStepDefintion extends BaseClass {


    CALoginPage cALoginPage = new CALoginPage();
    NUILoginPage nuiLoginPage = new NUILoginPage();
    RobotFunction robot = new RobotFunction();
    CACommon caCommon = new CACommon();
    NUICommon nuiCommon = new NUICommon();
    NUIAdministrationPage nuiAdministrationPage = new NUIAdministrationPage();
    NUIHomePage nuiHomePage = new NUIHomePage();
    NUIPeoplePage nuiPeoplePage = new NUIPeoplePage();
    NUIShoppingCartPage nuiShoppingCartPage = new NUIShoppingCartPage();
    NUITaxIntegration nuiTaxIntegration = new NUITaxIntegration();
    NewUI_AdminTool nuiAdminTool = new NewUI_AdminTool();
    NUIProgramOwnerWorkflowPeoplePage nuiProgramOwner = new NUIProgramOwnerWorkflowPeoplePage();
    PdfReader pdf = new PdfReader();
    CAVendorRegistrationPage caVendorReg = new CAVendorRegistrationPage();
    CASelfRegistrationPage caSelfReg = new CASelfRegistrationPage();
    CAPersonalPage caPersonalPage = new CAPersonalPage();
    CAPaymentDetails caPayment = new CAPaymentDetails();
    CAAddPerson caAddPerson = new CAAddPerson();
    CAPeoplePage caPeople = new CAPeoplePage();
    CAOrderPage caOrderPage = new CAOrderPage();
    CAAdminTool caAdmin = new CAAdminTool();
    CAOneToManyHD caOneToMany = new CAOneToManyHD();
    CATaxFunctionality caTax = new CATaxFunctionality();
    CAPersonStatus1 caPersonStatus1 = new CAPersonStatus1();
    AcceptTheForms af = new AcceptTheForms();
    CAExistingPerson caExistingPerson = new CAExistingPerson();
    CAVendorPage caVendor = new CAVendorPage();
    CAPackages caPackages = new CAPackages();
    CAMyadvantage caMyad = new CAMyadvantage();
    ReportWriter _report = new ReportWriter();
    AHKActions _ahk = new AHKActions();
    DatabaseClass databaseClass = new DatabaseClass();
    ShopingCart shopingCart = new ShopingCart();
    ExcelReader _dataRepo;
    //ExcelReader _dataRepo = new ExcelReader();
    TxtWriter _Txt = new TxtWriter();
    EmptyCart ec = new EmptyCart();
    HandlePopUp hp = new HandlePopUp();
    SearchPersonBySSN sps = new SearchPersonBySSN();
    UpadtePhoto up = new UpadtePhoto();
    CommonXMLupdates cxu = new CommonXMLupdates();
    WebServiceUtils wsu = new WebServiceUtils();
    CheckBackgroundReport cbr = new CheckBackgroundReport();
    Util uti = new Util();
    VerifyDigitalBadge vdb = new VerifyDigitalBadge();
    DigitalBadgePhysicalBadge dpb = new DigitalBadgePhysicalBadge();
    VerifyReceipt vr = new VerifyReceipt();
    VerifyCustVendor vcv = new VerifyCustVendor();
    AddUser au = new AddUser();
    VerifyLegalAgreement vla = new VerifyLegalAgreement();
    VerifyPersonStatusDetailPage vpsdp = new VerifyPersonStatusDetailPage();
    VerificationCreditCard vcc = new VerificationCreditCard();
    PaymentPageLockheadMartin pplm = new PaymentPageLockheadMartin();
    VerifyLOB vlob = new VerifyLOB();
    BatchOrder bo = new BatchOrder();
    ValidationProd vp = new ValidationProd();
    PositionLocationPage plp = new PositionLocationPage();
    ValidationUserProfile vup = new ValidationUserProfile();
    PersonInformation pi = new PersonInformation();
    BusinessPreScreening bps = new BusinessPreScreening();
    ReportRequestConfirmationPage rrc = new ReportRequestConfirmationPage();
    VendorRegistrationPage vrp = new VendorRegistrationPage();
    ClientOrderReportPage corp = new ClientOrderReportPage();
    LoginPageEA LPEA = new LoginPageEA();
    WalmartPerformance wal = new WalmartPerformance();
    Email mail = new Email();
    ContinuousMonitoringValidations cmv = new ContinuousMonitoringValidations();
    VendorRegistrationPageXML vreg = new VendorRegistrationPageXML();
    VendorThankyouPage vty = new VendorThankyouPage();
    SetVendorPrefrenceOperationUser svp = new SetVendorPrefrenceOperationUser();
    NotificationConfigurations nc = new NotificationConfigurations();
    PALoginPage pal = new PALoginPage();
    PACountryPage pac = new PACountryPage();
    PAESignPage pae = new PAESignPage();
    PANoticePage pan = new PANoticePage();
    PAProfilePage pap = new PAProfilePage();
    PAResidencePage par = new PAResidencePage();
    PAEmploymentPage paem = new PAEmploymentPage();
    PAEducationPage paed = new PAEducationPage();
    PALicensePage pali = new PALicensePage();
    PAIdentityPage pai = new PAIdentityPage();
    PACriminalPage paci = new PACriminalPage();
    PAAdditionalPage paa = new PAAdditionalPage();
    PAAdditionalInformationPage paad = new PAAdditionalInformationPage();
    PAReviewPage pare = new PAReviewPage();
    PADocumentUploadPage pad = new PADocumentUploadPage();
    PeopleFilteringHelper peopleFilteringHelper = new PeopleFilteringHelper(driver);
    Api api = new Api();


    NUIXtdConnect NewUIXtdConnect = new NUIXtdConnect();
    VerifyVendorHeader verifylogo = new VerifyVendorHeader();
    VerifyFadvSupportLinkFooter VerifyFadvSupportLink = new VerifyFadvSupportLinkFooter();
    NewUIVendorRegistrationPage VendorRegistration = new NewUIVendorRegistrationPage();
    errormessageValidationPage errorMessageOnUserProfilePage = new errormessageValidationPage();
    NewUIVendorPaymentPage NewUIPayment = new NewUIVendorPaymentPage();
    NewUISelfScreeingWorkflow SelfScreeningPages = new NewUISelfScreeingWorkflow();

    static String randomString = Random_StringGenerator(8);
    static String fileName;
    public static String DBValue;
    public static String inputValue;
    public static String OldDate;
    private static String OrderIdandURL = "";
    private static String VendorApiURL = "";
    private String xmlPath = "";
    private String SalesForceID = "";
    private String PayTO = "";
    private String Name = "";
    private String DBAname = "";
    private String UserID = "";
    private String Password = "";
    private String principalSSN = "";
    private String CrewSSN = "";
    private NUIProgramOwnerWorkflowPeoplePage programOwnerWorkflowPeoplePage = new NUIProgramOwnerWorkflowPeoplePage();
    private String providerNamePeopleSearch;
    private List<String> values = new ArrayList<>();
    private String uniqueVendorLengthOfService;
    private int custID;
    private String startOfService;
    private String endOfService;
    private String hyperlinkURL;

    private static int bDS = 1;

    public static String searchResultStateBefore;
    public static String searchResultStateAfter;

    private By LogoutBTN = By.xpath("//a[.='Log Out']");
    public By ssnYRadio = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[8]/td[2]/input[1]");
    final String hexRed = "#e00000";
    final String hexGreen = "#37a47a";
    final String hexBlue = "#3e82c8";
    final String hexGrey = "#838383";
    final String hexOrange = "#f18a00";
    List<WebElement> checkboxSizeAdmin = new ArrayList<WebElement>();
    List<WebElement> checkboxSize = new ArrayList<WebElement>();
    String dateBefores;
    String dateAfters;
    String dateBeforeCompletions;
    String dateAfterCompletions;
    WebElement userStatus;
    WebElement currentAccordion;

    public CommonStepDefintion() {
        System.out.println("*********************************************************************");

    }

    /**
     * @throws Exception
     * @author shekarcg
     * @category Report Generation and initialization of Browser
     **/
    @Before
    public void beforeHook(Scenario scenario) throws Exception {
        scenarioName = scenario.getName();
        _dataRepo = new ExcelReader();
        initReportDir();
//        String Scenario1 = scenarioName;
//        Scenario1 = Scenario1.replaceAll(":", "_");
//        String Scenario2 = Scenario1.replace(" ", "_");
//        String Scenario3 = Scenario2.replace("-", "_");
//        String Scenario4 = Scenario3.replace("+", "_");
//        String Scenario = Scenario4.replace("(", "_");
//        Scenario = Scenario.replace(")", "_");
        String Scenario = scenarioName.replaceAll("/[^A-Z0-9]+/ig", "_");
        String ReportpathLocal = reportPathDir + "\\" + Scenario + ".html";
        String month = CurrentDateTime.SystemDateMonth();
        String year = CurrentDateTime.SystemDateYear();
        String monthYear = month + year;
        String Day = CurrentDateTime.SystemDateDay();
        ReportScenarioDirectory = "BDD_Reports/" + monthYear + "/" + Day + "/"
                + PropertyFileReader.getProperty("ReportType");
        ReportScreenShotDirectory = "BDD_Reports/" + monthYear + "/" + Day + "/"
                + PropertyFileReader.getProperty("ReportType") + "/" + Scenario;
        report = new ExtentReports();
        test = report.createTest(scenarioName);
        ReportpathServer = PropertyFileReader.getProperty("ReportpathServer") + ReportScenarioDirectory + "/" + Scenario
                + ".html";
        AccessibilityReport = PropertyFileReader.getProperty("ReportpathServer") + ReportScenarioDirectory + "/" + Scenario
                + ".html";
        System.out.println("Report Location is ::" + reportPath);
        System.out.println("Report Server Location is ::" + ReportpathServer);
    }

    @After
    public void afterHook(Scenario scenario) throws Exception {
        System.out.println(scenario.getStatus());
//		_report.CreateResultExcel(scenarioResult);
        System.out.println("Write into Execution Result....");
        //For accessibility testing

        htmlCsRunner.generateHtmlReport();
    }

    @Given("^I initialize Browser$")
    public void browswerInit() throws Exception {
        String _broswer = PropertyFileReader.getProperty("broswerName");
        initBrowser(_broswer, scenarioName);
    }

    @When("^I clear temp folder and kill Browser$")
    public void clearTemp() throws Exception {
        clearTempFolder();
    }

    @When("^I am executing \"([^\"]*)\"$")
    public void tcID(String TCName) throws Exception {
        String[] scenario = scenarioName.split("_");
        PropertyFileReader.setProperty("sheetName", scenario[0]);
        System.out.println("SheetName is : " + PropertyFileReader.getProperty("sheetName"));
        logStepInfo("Scenarios covered: " + System.lineSeparator() + scenario[1].toString());
        reportLog(Status.INFO, "Scenarios covered: " + System.lineSeparator() + scenario[1].toString(), false);
        if (TCName.contains("Verification-Scenario")) {

        }
    }

    @Then("^I close browser$")
    public void closeAllBrowser() throws Exception {
        closeBrowser();
        //     clearTemp();
        System.out.println("*********************************************************************");

    }

    @When("^I navigate to \"([^\"]*)\" application$")
    public void applicationURL(String applicationName) throws Exception {
        String url;

        if (applicationName.equalsIgnoreCase("Autoqcs"))
            url = "https://qcsa.fadv.net/login?s=autoqcs";

        else if (applicationName.equalsIgnoreCase("NewUI Vendor Registration"))
            url = "https://qcsa.fadv.net/login?s=autoqcs";
        else if (applicationName.equalsIgnoreCase("DrugTest"))
            url = "https://ua.ca.fadv.com/login?s=usecasefour";

        else if (applicationName.equalsIgnoreCase("NewUI Vendor Registration-without Fee"))
            url = "https://qcsa.fadv.net/login?s=autoqcs";
        else if (applicationName.equalsIgnoreCase("NewUI Vendor Registration-with Fee"))
            url = "https://qcsa.fadv.net/login?s=qcsavc";

        else if (applicationName.equalsIgnoreCase("NewUI API Vendor Registration"))
            url = "https://qcsa.fadv.net/?onboarding=9c7bcbeabe5145d3b3846bad49688044";
        else if (applicationName.equalsIgnoreCase("NewUI Vendor Registration - Sing Up"))
            url = "https://qcsa.fadv.net/login?s=autoqcs";
        else if (applicationName.equalsIgnoreCase("SelfScreeningWorkflow"))
            url = "https://qcsa.fadv.net/login?s=autoqcs";
        else if (applicationName.equalsIgnoreCase("Vendor On boarding NewUI Prod Sanity"))
            url = "https://qcsa.fadv.net/login?s=amazonafp";
//			url = "https://ca.fadv.com/login?s=TESTXTDFORCE";
        else if (applicationName.equalsIgnoreCase("Vendor Reg"))
            url = _dataRepo.getData("OtherURL");
        else if (applicationName.equalsIgnoreCase("EA"))
            url = "https://enterprise.fadv.com";
        else if (applicationName.equalsIgnoreCase("Agreement Page"))
            url = AgreementfilePath;
        else if (applicationName.equalsIgnoreCase("Emaillog page"))
            url = EmaillogfilePath;
        else if (applicationName.equalsIgnoreCase("PALanuchUrl"))
            url = PAInviteLink;
        else if (applicationName.equalsIgnoreCase("AutoQcsaVendorApi"))
            url = VendorApiURL;

        else if (applicationName.equalsIgnoreCase("PAInviteLanuchUrl"))
            url = "https://pa-intl-qa.fadv.net/#/invite/?key=" + profileId;
        else if (applicationName.equalsIgnoreCase("PAInviteLanuchUrlUAT"))
            url = "https://pa-ua.fadv.com/#/invite/?key=" + profileId;
        else if (applicationName.equalsIgnoreCase("PAInviteLanuchUrlPROD"))
            url = "https://pa.fadv.com/#/invite/?key=" + profileId;
        else if (applicationName.equalsIgnoreCase("PAInviteLanuchUrlCT"))
            url = "https://pa-test.fadv.com/#/invite/?key=" + profileId;

        else if (applicationName.equalsIgnoreCase("UAT"))
            url = "https://ua.ca.fadv.com/login?s=AYFTest";
            //url = "https://ua.ca.fadv.com/login?s=amazonafp";
        else if (applicationName.equalsIgnoreCase("Outlook"))
            url = "https://outlook.live.com/owa/?nlp=1";
        else if (applicationName.equalsIgnoreCase("NewUI0"))
            url = "https://qcsa.fadv.net/login?s=amazonafp";
        else if (applicationName.equalsIgnoreCase("Admin tool-QCSA"))
            url = "https://qcsa-admin.fadv.net";
        else if (applicationName.equalsIgnoreCase("Admin tool-QCSB"))
            url = "https://qcsb-admin.fadv.net";
        else if (applicationName.equalsIgnoreCase("Admin tool-UAT"))
            url = "https://uaxtdforce-admin.fadv.net";
        else if (applicationName.equalsIgnoreCase("Admin tool"))
            url = _dataRepo.getData("other.url");
        else if (applicationName.equalsIgnoreCase("Mailinator"))
            url = "https://www.mailinator.com/";
        else
            url = _dataRepo.getData("page.url");

        URL = url;
        System.out.println("URL::" + url);
        driver.manage().deleteAllCookies();

//		loadUrl(url);
        wait(2);
        loadUrl(url);
        if (url.contains("?hd")) {
            CustID = "1296";
        } else if (url.contains("?unigroup")) {
            CustID = "215";
        } else if (url.contains("?clickstaff")) {
            CustID = "1346";
        } else if (url.contains("?lockheed")) {
            CustID = "14";
        } else if (url.contains("?aspengrove")) {
            CustID = "1281";
        } else if (url.contains("?allpro1")) {
            CustID = "13";
        } else if (url.contains("amazonafp")) {
            CustID = "2935";
        } else {
            CustID = "1296";
        }

        if (url.contains("qcsa")) {
            DB = "QCSA";
        } else if (url.contains("qcsb")) {
            DB = "QCSB";
        } else if (url.contains("https://ca.fadv.com")) {
            DB = "PROD";
        } else if (url.contains("https://test.ca.fadv.com")) {
            DB = "CT";
        } else if (url.contains("https://ua.ca.fadv.com/")) {
            DB = "UAT";
        }

        if (applicationName.contains("NewUI")) {
            CustomerName = driver.getTitle();
            System.out.println("cust name::" + CustomerName);
        }


    }

    /**
     
     * @author shekarcg
     * @category Log in validation and Log in to application
     */
    @When("^I log in to \"([^\"]*)\" application with \"([^\"]*)\" Credentials$")
    public void logInApplication(String ApplicationName, String checkFor) throws Exception {
        cALoginPage.login(ApplicationName, checkFor);
    }

    /**
     
     * @author marovimo
     * @category Log in validation and Log in to application NewUI
     */
    @When("^I log in to \"([^\"]*)\" New UI application with \"([^\"]*)\" Credentials$")
    public void i_log_in_to_New_UI_application_with_Credentials(String ApplicationName, String checkFor)
            throws Exception {
        nuiLoginPage.loginNUI(ApplicationName, checkFor);

    }

    @When("^Enter AccountNumber and UserName for Login to EA$")
    public void enter_AccountNumber_and_UserName_for_Login_to_EA() throws Exception {

        reportLog(Status.INFO, "***************** ^Enter AccountNumber and UserName for Login to EA$ *****************",
                false);

        String AccountNO = _dataRepo.getData("AccountNO");
        String UserName = _dataRepo.getData("UserName");
        String env = _dataRepo.getData("Environment");
        LPEA.login(AccountNO, UserName, env);
    }

    /**
     * @author shekarcg
     * @category windows movement in script
     */
    @When("^I \"([^\"]*)\" page$")
    public void windowsMovement(String actionName) throws Exception {
        if (actionName.equalsIgnoreCase("refresh")) {
            driver.navigate().refresh();
            wait(3);
        } else if (actionName.equalsIgnoreCase("back")) {
            driver.navigate().back();
            driver.navigate().refresh();
        } else {
            System.out.println("invalid action asked to perform::" + actionName);
        }
    }

    /**
     * @author shekarcg
     * @category waiting in script
     */
    @When("^I wait for \"([^\"]*)\" Seconds$")
    public void waitTime(String time) throws Exception {
        caCommon.waitObject(time);
    }

    /**
     * @author shekarcg
     * @category click on objects
     * @param identifier and Value of the identifier
     *
     */
    /**
     * @author gerguran
     * @category added 4 cases -->"menubutton-newui" "button-newui" "checkbox"
     * "pagination"
     **/
    @When("^I click on \"([^\"]*)\" \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void clickOject(String identifier, String value, String Page) throws Exception {
        switch (identifier.toLowerCase()) {
            case "pagination":
                List<WebElement> pagination = driver
                        .findElements(By.xpath("//li[contains(@class,'pagination-page page-item')]"));
                if (pagination.size() > 1) {
                    if (value.equalsIgnoreCase("next") || value.equalsIgnoreCase("previous")) {
                        nuiCommon.clickPaginationSingleArrow(value, Page);
                    } else {
                        nuiCommon.clickPaginationDoubleArrow(value, Page);
                    }
                } else {
                    reportLog(Status.PASS, "User is present on first page and pagination have 1 page", false);
                }

                break;
            case "linktext":
                caCommon.clickLink(value, Page);
                break;
            case "link":
                nuiCommon.clickLink(value, Page);
                break;
            case "signupbutton":
                nuiCommon.clickButton(value, Page);
                break;
            case "menubutton":
                caCommon.clickMenuButton(value);
                break;
            case "menubutton-newui":
                nuiCommon.clickMenuButton(value);
                break;
            case "button":
                if (value.equalsIgnoreCase("NEXT") || value.equalsIgnoreCase("SUBMIT") || value.equalsIgnoreCase("Let's Begin! ")) {
                    if (verifyElementPresence(By.xpath("//input[@value='NEXT']"))) {
                        clickElement(By.xpath("//input[@value='NEXT']"), "Next");
                    } else if (verifyElementPresence(By.xpath("//input[@value='SUBMIT']"))) {
                        clickElement(By.xpath("//input[@value='SUBMIT']"), "SUBMIT");

                    } else if (verifyElementPresence(By.xpath("//button[@class='btn btn-primary btn-order ml-1']"))) {
                        clickElement(By.xpath("//button[@class='btn btn-primary btn-order ml-1']"), "NEXT");

                    } else if (verifyElementPresence(By.xpath("//button[@type='submit']"))) {
                        clickElement(By.xpath("//button[@type='submit']"), "SUBMIT");

                    } else if (verifyElementPresence(By.xpath("//button[@class='shadow btn btn-primary btn-vendor']"))) {
                        clickElement(By.xpath("//button[@class='shadow btn btn-primary btn-vendor']"), "SUBMIT");

                    } else {
                        caCommon.clickButton(value, Page);
                    }

                } else if (verifyElementPresence(By.xpath("//*[contains(text(),'Let's Begin! ')]"))) {
                    clickElementWithWait(By.xpath("//*[contains(text(),'Let's Begin! ')]"), "Let's Begin! ");
                } else if (verifyElementPresence(By.xpath("//button[@id='reset-password-btn']"))) {
                    clickElementWithWait(VendorRegistration.ResestButton, "Click on Reset To reset the password");
                } else if (verifyElementPresence(By.xpath("(//button[@type='button'])[2]"))) {
                    clickElementWithWait(VendorRegistration.ReturnButton, "Click on Return To login");
                } else if (verifyElementPresence(By.xpath("//button[normalize-space()='Connect']"))) {
                    clickElementWithWait(NewUIXtdConnect.xtdConnectADDBtn, "XtdConnect Connect Button");
                } else {
                    caCommon.clickButton(value, Page);
                }
                break;
            case "button-edit":
                if (value.equalsIgnoreCase("Edit")) {
                    if (verifyElementPresence(By.xpath("(//button[contains(text(), 'Edit')])[1]"))) {
                        clickElement(By.xpath("(//button[contains(text(), 'Edit')])[1]"), "Edit");
                    } else if (verifyElementPresence(By.xpath("(//button[contains(text(), 'Edit')])[2]"))) {
                        clickElement(By.xpath("(//button[contains(text(), 'Edit')])[2]"), "Edit");
                    }
                }
                break;
            case "button-editb":
                if (value.equalsIgnoreCase("Edit")) {
                    if (verifyElementPresence(By.xpath("(//button[contains(text(), 'Edit')])[2]"))) {
                        clickElement(By.xpath("(//button[contains(text(), 'Edit')])[2]"), "Edit");
                    }
                }
                break;
            case "button-edits":
                if (value.equalsIgnoreCase("Edit")) {
                    if (verifyElementPresence(By.xpath("(//button[contains(text(), 'Edit')])[4]"))) {
                        clickElement(By.xpath("(//button[contains(text(), 'Edit')])[4]"), "Edit");
                    }
                }
                break;
            case "button-editc":
                if (value.equalsIgnoreCase("Edit")) {
                    if (verifyElementPresence(By.xpath("(//button[contains(text(), 'Edit')])[3]"))) {
                        clickElement(By.xpath("(//button[contains(text(), 'Edit')])[3]"), "Edit");
                    } else if (verifyElementPresence(By.xpath("(//button[contains(text(), 'Edit')])[6]"))) {
                        clickElement(By.xpath("(//button[contains(text(), 'Edit')])[6]"), "Edit");
                    }
                }
                break;
            case "tickbox":
                clickElement(VendorRegistration.adopAndSign, "click on adop and sign tick box");
                break;
            case "button-newui":
                nuiCommon.clickButton(value, Page);
                break;
            case "checkbox":
                nuiCommon.clickCheckbox(value, Page);
                break;
            case "packageradiobutton":
                caOrderPage.clickPackageRadioButton(value);
                break;
            case "canvas":
                caCommon.canvasSignatureFunction();
                break;
            case "person name":
                nuiCommon.clickLink(value, Page);
                break;
            case "radiobutton":
                caCommon.clickRadioButton(value);
                break;
            case "radiobutton-newui":
                nuiCommon.clickRadioButton(value);
                break;
            case "order status":
                if (value.equalsIgnoreCase("hyperlink")) {
                    value = "/div/a";
                } else {
                    value = "/div";
                }
                nuiCommon.clickOnComplStatus(value);
                break;
            case "order status screening":
                if (value.equalsIgnoreCase("hyperlink")) {
                    value = "/div/a";
                } else {
                    value = "/div";
                }
                nuiCommon.clickOnComplStatusScreening(value);
                break;
            case "order status pa":
                if (value.equalsIgnoreCase("hyperlink")) {
                    value = "/div/a";
                } else {
                    value = "/div";
                }
                nuiCommon.clickOnComplStatusPA(value);
                break;
            case "icon":
                clickElement(NewUIPayment.CCcssNumberTxt, "Clicked on CSS Information Icon");
                break;
            case "indicator":
                if (value.equalsIgnoreCase("XtdConnectLogo")) {
                    clickElement(NewUIXtdConnect.XtdConnectLogoOnPeoplePage, "clickable XtdConnect Logo On People Page");
                }
                break;
            default:
                System.out.println("identifier is not listed on the case::" + identifier);
                break;
        }
    }

    @And("^I should validate \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void i_should_validate_something_on_something_page(String value, String Page) throws Throwable {
        if (Page.contains("Business Billing")) {
            nuiCommon.prePopulatedValue(value, Page);
        }
    }

    /**
     * @author shekarcg
     * @category WINESP task perform
     ***/

    @When("^I launch WinESP application$")
    public void launchWinESP() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        _ahk.loginCitrix();
        _ahk.AHKTaskPerform();
    }

    @Then("^I \"([^\"]*)\" orderID in AHK file$")
    public void changeOrderID(String valueAction) throws Exception {
        if (valueAction.equalsIgnoreCase("Set")) {
            _Txt.WriteTxtFile(PropertyFileReader.getProperty("AHK.path") + "HomeDepo.ahk", "orderID",
                    PropertyFileReader.getProperty("OrderRefID"));
        } else if (valueAction.equalsIgnoreCase("ReSet")) {
            _Txt.WriteTxtFile(PropertyFileReader.getProperty("AHK.path") + "HomeDepo.ahk",
                    PropertyFileReader.getProperty("OrderRefID"), "orderID");
        }
    }

    /**
     * @author shekarcg
     * @category upload file in to the application
     ***/
    @When("^I upload \"([^\"]*)\" in \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void uploadOject(String fileName, String value, String Page) throws Exception {
        String _FileName = _dataRepo.getData(fileName);
        caCommon.uploadFileIntoApplication(_FileName, value, Page);

    }

    /**
     * @author shekarcg
     * @category get Data from UI
     ***/
    @When("^I get data \"([^\"]*)\" from the \"([^\"]*)\" Page$")
    public void getFieldValue(String fieldName, String Page) throws Exception {
        caCommon.getData(fieldName, Page);

    }

    @When("^I get \"([^\"]*)\" value from the \"([^\"]*)\" Page$")
    public void getValue(String fieldName, String Page) throws Exception {
        caCommon.getUIData(fieldName, Page);

    }

    /**
     * @author shekarcg
     * @category Table validation for Order Table and Badge table present
     ***/

    @Then("^I should see \"([^\"]*)\" column \"([^\"]*)\" value \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void verifyTableColumnValuePresent(String tableName, String ColumnName, String ColumnValue, String PageName)
            throws Exception {
        /**
         * @author gerguran
         * @category Table column validation for NEWUI
         * @param tablename ,Column Name and Column value
         *
         ***/
        if (PageName.equalsIgnoreCase("NewUI")) {
            nuiCommon.verifyTableValue("Present", tableName, ColumnName, ColumnValue);
        } else {
            caCommon.verifyTableValue("Present", tableName, ColumnName, ColumnValue);
        }
    }

    /**
     * @author shekarcg
     * @category Table validation for Order Table and Badge table absent
     ***/
    @Then("^I should not see \"([^\"]*)\" column \"([^\"]*)\" value \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void verifyTableColumnValueNotPresent(String tableName, String ColumnName, String ColumnValue,
                                                 String PageName) throws Exception {
        if (PageName.equalsIgnoreCase("NewUI")) {
            nuiCommon.verifyTableValue("Absent", tableName, ColumnName, ColumnValue);
        } else {
            caCommon.verifyTableValue("Absent", tableName, ColumnName, ColumnValue);
        }

    }

    /**
     * @author shekarcg
     * @category Validate the presence of identifiers as per the Value
     * @param idenifier Name and Value
     *
     ***/
    /**
     * @author gerguran
     * @category added 5 case "password bar" "row" "menubutton-newui" "text-newui"
     * "errormessage-newui"
     **/

    @Then("^I should see \"([^\"]*)\" named as \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void VerifyWithValue(String identifierName, String identifierValue, String pageName) throws Exception {

        if (identifierValue.equalsIgnoreCase("VendorName")) {
            identifierValue = _dataRepo.getData("vendorName");
            System.out.println("_Value is ::" + identifierValue);
        } else if (identifierValue.equalsIgnoreCase("organizationName")) {
            identifierValue = _dataRepo.getData("organizationName");
            System.out.println("_Value is ::" + identifierValue);
        }
        switch (identifierName.toLowerCase()) {
            case "password bar":
                nuiCommon.passBarVerifyWithValue(identifierValue, pageName);
                break;
            case "title":
                caCommon.pageTitleVerifyWithValue(identifierValue, pageName);
                break;
            case "menubutton":
                caCommon.menuButtonVerifyPresent(identifierValue);
                break;
            case "menubutton-newui":
                nuiCommon.menuButtonVerifyPresent(identifierValue);
                break;
            case "text":
                caCommon.pageTextVerifyWithValue(identifierValue, pageName);
                break;
            case "text-newui":
                nuiCommon.pageTextVerifyWithValue(identifierValue, pageName);
                break;
            case "element":
                nuiCommon.TextVerifyPresent(identifierValue, pageName);
                break;
            case "button":
                caCommon.pageButtonVerifyWithValue(identifierValue, pageName);
                break;
            case "button-newui":
                nuiCommon.pageButtonVerifyWithValue(identifierValue, pageName);
                break;
            case "row":
//			nuiCommon.pageRowVerifyWithValue(identifierValue, pageName);
                if (nuiCommon.pageRowVerifyWithValue(identifierValue, pageName) == false) {
                    reportLog(Status.FAIL, "Object is not present '" + identifierValue + "'", false);
                    logStepInfo("Object is not present '" + identifierValue + "");
                } else {
                    reportLog(Status.PASS, "Object is present - '" + identifierValue + "'", true);
                }
                break;
            case "textbox":
                nuiCommon.textboxVerifyPresent(identifierValue, pageName);
            case "column":
                caCommon.pageColumnVerifyWithValue(identifierValue, pageName);
                break;
            case "popup":
                alertTextValidatation(identifierValue);
                break;
            case "errormessage":
                caCommon.pageMessage(identifierName, identifierValue);
                break;
            case "errormsg-newui":
                nuiCommon.pageMessage(identifierName, identifierValue, pageName);
                break;
            case "xtdConnectErrormsg-newui":
                nuiCommon.pageMessage(identifierName, identifierValue, pageName);
                break;
            case "successmessage":
                caCommon.pageMessage(identifierName, identifierValue);
                break;

            default:
                System.out.println("identifier is not present ::" + identifierName);
        }
    }

    @And("^I select \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void Selecting(String value, String page) throws Throwable {
        if (page.equalsIgnoreCase("Business Information")) {
            VendorRegistration.selectingValue(value);
            logStepInfo("Object is present ");
        } else if (page.equalsIgnoreCase("Business Contact")) {
            VendorRegistration.selectingValue(value);
            logStepInfo("Object is present ");
        } else if (page.equalsIgnoreCase("Secondary Business Contact")) {
            VendorRegistration.selectingSecondaryCountry(value);
            logStepInfo("Object is present ");
        } else if (page.equalsIgnoreCase("Business Billing")) {
            VendorRegistration.selectingValue(value);
            logStepInfo("Object is present ");
        } else {
            reportLog(Status.PASS, "Object is not present - '", true);
        }
    }

    /**
     * @author shekarcg
     * @category validation for object as button or text or Title absent
     * @param object name and object Value
     *
     ***/

    /**
     * @author gerguran
     * @category added same validation for NewUI
     ***/

    @Then("^I should not see \"([^\"]*)\" named as \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void VerifyWithValueNotPresent(String identifierName, String identifierValue, String pageName)
            throws Exception {
        if (pageName.contains("newui")) {
            if (identifierName.equalsIgnoreCase("row")) {
                if (nuiCommon.pageRowVerifyWithValue(identifierValue, pageName) == false) {
                    reportLog(Status.PASS, "Object is not present '" + identifierValue + "'", false);
                    logStepInfo("Object is not present '" + identifierValue + "");
                }
            }
            nuiCommon.pageObjectVerifyWithValueNotPresent(identifierName, identifierValue, pageName);
        } else {
            caCommon.pageObjectVerifyWithValueNotPresent(identifierName, identifierValue, pageName);
        }
    }

    @Then("^I should see \"([^\"]*)\" named as \"([^\"]*)\" for \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void VerifyWithValueForElement(String identifierName, String identifierValue, String identifierElement,
                                          String pageName) throws Exception {
        switch (identifierName.toLowerCase()) {
            case "errormsg-newui":
                nuiCommon.pageMessageForElement(identifierName, identifierElement, identifierValue, pageName);
                break;
            default:
                System.out.println("identifier is not present ::" + identifierName);
        }
    }

    /**
     * @author shekarcg
     * @category validation for object as button present
     ***/
    @Then("^I should see \"([^\"]*)\" value \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void VerifyIdenitifierWithValue(String identifierName, String Value, String pageName) throws Exception {

        caCommon.VerifyIdentifierWithValue(identifierName, Value);

    }

    /**
     * @param textValue and text field
     * @author shekarcg
     * @category enter text in specified field
     ***/
    @When("^I enter \"([^\"]*)\" value for \"([^\"]*)\" textbox on \"([^\"]*)\" Page$")
    public void textInput(String textValue, String textField, String pageName) throws Exception {
        if (textValue.equalsIgnoreCase("OrderID")) {
            textValue = CACommon.valuefromUI;
            OrderID = CACommon.valuefromUI;
        } else if (textValue.equalsIgnoreCase("random")) {
            textValue = Random_StringGenerator(3) + Random_NumberGenerator(8);
        } else if (textValue.equalsIgnoreCase("randomnumber")) {
            textValue = Random_NumberGenerator(10);
        } else {
            textValue = _dataRepo.getData(textValue);
            System.out.println("_Value is ::" + textValue);
        }
        caCommon.enterText(textValue, textField, pageName);
    }

    /**
     * @param textValue and text field
     * @author gerguran
     * @category enter text in specified field
     ***/
    @When("^I enter \"([^\"]*)\" value for \"([^\"]*)\" textbox on \"([^\"]*)\" Page NewUI$")
    public void textInputNui(String textValue, String textField, String pageName) throws Exception {
        if (textValue.equalsIgnoreCase("existing")) {
            databaseClass.getDBConnection(DB);
            DBValue = databaseClass.DBSelect(textField, "1");
            System.out.println("Result is ::" + DBValue);
            databaseClass.closeConnection();
            if (textField.equalsIgnoreCase("fn")) {
                existingFirstName = DBValue;
            } else if (textField.equalsIgnoreCase("ln")) {
                existingLastName = DBValue;
            } else if (textField.equalsIgnoreCase("email")) {
                existingEmail = DBValue;
            }
            nuiCommon.enterText(DBValue, textField, pageName);

        } else {
            nuiCommon.enterText(textValue, textField, pageName);
        }
    }

    /**
     * @param ddlValue to be selected and Name of Drop down
     * @author shekarcg
     * @category Select from drop down
     *****/

    @When("^I select \"([^\"]*)\" from \"([^\"]*)\" dropdown on \"([^\"]*)\" Page$")
    public void selectFromDropDown(String ddlValue, String ddlName, String Page) throws Exception {
        String _value = null;
        if (ddlValue.equalsIgnoreCase("Credit Card")) {
            _value = ddlValue;
        } else if (ddlValue.equalsIgnoreCase("Invoice Code")) {
            _value = ddlValue;
        } else if (ddlValue.equalsIgnoreCase("BackgroundScore")) {
            _value = "Eligible";
        } else {
            _value = _dataRepo.getData(ddlValue);
        }
        caCommon.selectDropDown(ddlName, _value, Page);
    }

    /**
     * @author shekarcg
     * @category Save file to location
     *****/
    @When("^I save the file$")
    public void savePrint() throws Exception {
        caCommon.saveFile();
    }

    /**
     * @author shekarcg
     * @category download file to location
     *****/
    @When("^I download the \"([^\"]*)\" file$")
    public void downloadFile(String pageName) throws Exception {
        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            System.out.println(handle);
            driver.switchTo().window(handle);
        }
        fileName = reportPath + "\\TempBadge.PDF";
        robot.saveFile(fileName);
        driver.switchTo().window(parent);

    }

    /**
     * @author shekarcg
     * @category get Data from UI
     ***/

    @When("^I get \"([^\"]*)\" with input value \"([^\"]*)\" in \"([^\"]*)\" page$")
    public void getDatabaseValue(String queryName, String input, String pageName) throws Exception {

        databaseClass.getDBConnection(DB);

        if (input.equalsIgnoreCase("orderid")) {
            inputValue = CACommon.valuefromUI;
            PropertyFileReader.setProperty("OrderID", input);
        } else if (input.equalsIgnoreCase("TestCaseName")) {
            String[] scenario = scenarioName.split("_");
            inputValue = scenario[1];
        } else if (input.equalsIgnoreCase("UserName")) {
            inputValue = userName;
        } else {
            inputValue = input;
        }

        System.out.println("input is ::" + inputValue);

        DBValue = databaseClass.DBSelect(queryName, inputValue);
//		if (queryName.equalsIgnoreCase("Select_OrderRefID")) {
//			PropertyFileReader.setProperty("OrderRefID", DBValue);
//			_dataRepo.writeExcel(inputValue, 2);
//			_dataRepo.writeExcel(DBValue, 3);
//		} else if (queryName.equalsIgnoreCase("Select_OrderID")) {
//			PropertyFileReader.setProperty("OrderID", DBValue);
//			CACommon.valuefromUI = DBValue;
//			_dataRepo.writeExcel(inputValue, 2);
//			_dataRepo.writeExcel(DBValue, 3);
//		}
        if (pageName.equalsIgnoreCase("Administration")) {
            if (queryName.equalsIgnoreCase("Select_FirstName")) {
                existingFirstName = DBValue;
            } else if (queryName.equalsIgnoreCase("Select_LastName")) {
                existingLastName = DBValue;
            } else if (queryName.equalsIgnoreCase("Select_Email")) {
                existingEmail = DBValue;
            }
        } else if (pageName.equalsIgnoreCase("Dashboard")) {
            userFirstName = DBValue;
        } else {
            if (queryName.equalsIgnoreCase("Select_FirstNamePS")) {
                existingFirstName = DBValue;
            } else if (queryName.equalsIgnoreCase("Select_LastNamePS")) {
                existingLastName = DBValue;
            } else if (queryName.equalsIgnoreCase("Select_SSNPS")) {
                existingSSN = DBValue;
            }
        }
        System.out.println("Result is ::" + DBValue);
        databaseClass.closeConnection();
    }

    @When("^I update \"([^\"]*)\" database using \"([^\"]*)\" query with input value \"([^\"]*)\"$")
    public void UpdateTableDatabase(String databaseName, String queryName, String input) throws Exception {
        databaseClass.getDBConnection(databaseName);

        if (input.equalsIgnoreCase("orderid") || input.equalsIgnoreCase("custid")) {
            inputValue = CACommon.valuefromUI;
            if (inputValue == null) {
                inputValue = OrderID;
            }
        } else {
            inputValue = input;
        }

        System.out.println("input is ::" + inputValue);

        databaseClass.DBUpdate(queryName, inputValue);
        databaseClass.closeConnection();
    }

    /**
     * @author shekarcg
     * @category validating PDF
     *****/
    @Then("^I validate \"([^\"]*)\" file contains \"([^\"]*)\"$")
    public void pdfFileContentValidation(String Name, String expectedContent) throws Exception {
        System.out.println("file Name is : " + fileName);
        wait(5);
        caCommon.validatePdfWithExpectedText(fileName, expectedContent);
    }

    @When("^I make the person \"([^\"]*)\"$")
    public void makePersonStatus(String status) throws Exception {
        caPersonalPage.ChangePersonStatus(status);
    }

    /**
     * @author gerguran
     * @category checking empty fields
     **/

    @When("^I check User Details with all entries are pre-filled in \"([^\"]*)\" Page$")
    public void checkDetailsPreFilled(String pageName) throws Exception {
        nuiCommon.detailsPreFiled(pageName);
    }

    /**
     * @author shekarcg
     * @category fill multiple data in multiple fields required in registration
     * @param page name
     *
     *****/
    /**
     * @author gerguran
     * @category added 2 cases: "New User" "Edit User"
     **/

    @When("^I fill details in \"([^\"]*)\" page$")
    public void fillDetailsPage(String pageName) throws Exception {
        if (pageName.equalsIgnoreCase("Vendor Registration")) {
            caVendorReg.VendorRegistration();
        } else if (pageName.equalsIgnoreCase("Person Information")) {
            caPersonalPage.addPersonInfo();
        } else if (pageName.equalsIgnoreCase("Individual Registration")) {
            caSelfReg.selfRegistration();
        } else if (pageName.equalsIgnoreCase("Add New Person")) {
            caPeople.addNewPeople();
        } else if (pageName.equalsIgnoreCase("Add First Person")) {
            nc.addFirstPerson();
        } else if (pageName.equalsIgnoreCase("Add Second Person")) {
            nc.addSecondPerson();
        } else if (pageName.equalsIgnoreCase("Add Same Person")) {
            caPeople.addSamePeople();
        } else if (pageName.equalsIgnoreCase("Profile Registration")) {
            caSelfReg.profileRegistration();
        } else if (pageName.equalsIgnoreCase("Add Existing Person")) {
            caPeople.addExistingPerson();
        } else if (pageName.equalsIgnoreCase("Payment Information")) {
            caPayment.processPayment();
        } else if (pageName.equalsIgnoreCase("Vendor Payment Information")) {
            NewUIPayment.VendorPayment();
        } else if (pageName.equalsIgnoreCase("New User")) {
            nuiAdministrationPage.addNewUser();
        } else if (pageName.equalsIgnoreCase("Edit User")) {
            nuiAdministrationPage.editUser(pageName);
        } else {
            System.out.println("Invalid page Name Entered!!!!");
        }
    }

    @When("^I fill details in \"([^\"]*)\" page for \"([^\"]*)\"$")
    public void fillPageDetails(String pageName, String pageElement) throws Exception {
        if (pageName.equalsIgnoreCase("Payment Information")) {
            caPayment.processPaymentValidation(pageElement);
        } else if (pageName.equalsIgnoreCase("Administration - New User")) {
            nuiAdministrationPage.addNewUser();
        } else {
            System.out.println("Invalid page Name Entered!!!!");
        }
    }

    @When("^I check the existing order in \"([^\"]*)\" Page$")
    public void checkCartOrder(String PageName) throws Exception {
        caCommon.CheckOrder(PageName);
    }

    /***
     * ************************************************************************************************************
     *
     * @category Bhuvnesh Functions
     *
     *           ************************************************************************************************************
     ***/
    @Then("^I click on Add person from people menu and fill the details$")
    public void i_click_on_Add_person_from_people_menu_and_fill_the_details() throws Exception {
        caAddPerson.addPerson();

    }

    @Then("^I search the person from person menu$")
    public void i_search_the_person_from_person_menu() throws Exception {
        caAddPerson.searchPerson();

    }

    @When("^I log in to CA admin tool select customer Lockheed Martin$")
    public void i_log_in_to_CA_admin_tool_select_customer_Lockheed_Martin() throws Exception {
        caAdmin.loginAdminTool();
        caAdmin.selectCustomer();

    }

    @When("^I log in to CA admin tool select customer \"([^\"]*)\"$")
    public void i_log_in_to_CA_admin_tool_select_customer(String customer) throws Exception {
        caAdmin.loginAdminTool();
        caAdmin.selectCustomer(customer);

    }

    @When("^I de-Configure pre registration$")
    public void i_de_Configure_pre_registration() throws Exception {
        caAdmin.enableAndDisable_pre_registration_page("N");
    }

    @When("^I Configure pre registration$")
    public void i_Configure_pre_registration() throws Exception {
        caAdmin.enableAndDisable_pre_registration_page("Y");

    }

    @When("^I de-Configure property xtdforce_registration_ui$")
    public void i_de_Configure_xtdforce_registration_ui() throws Exception {
        caAdmin.enableAndDisable_xtdforce_registration_ui("N");
    }

    @When("^I Configure property xtdforce_registration_ui$")
    public void i_Configure_xtdforce_registration_ui() throws Exception {
        caAdmin.enableAndDisable_xtdforce_registration_ui("Y");

    }

    @When("^I configue customer support number and email Id$")
    public void i_configue_customer_support_number_and_email_Id() throws Exception {
        caAdmin.pre_registraion_page_email();
        caAdmin.pre_registraion_page_contact_num();
    }

    @Then("^I edit the person information$")
    public void i_edit_the_person_information() throws Exception {
        caAddPerson.editPersonInfo();

    }

    @Then("^I provide the payment details through credit card and validate Tax text$")
    public void i_provide_the_payment_details_through_credit_card_and_validate_Tax_text() throws Exception {
        caTax.creditCardPaymentOrderConfirmation();
    }

    @Then("^verify the tax details$")
    public void verify_the_tax_details() throws Exception {

        caTax.taxValidation();

    }

    @When("^I select the drug package and provide details$")
    public void i_select_the_drug_package_and_provide_details() throws Exception {
        caTax.packageDrug();
    }

    @When("^I login to HomeDepot and search a vendor$")
    public void i_login_to_HomeDepot_and_search_a_vendor() throws Exception {
        caOneToMany.signInHomeDepot();
        caOneToMany.acceptAgreement();
        caOneToMany.searchVendor();
    }

    @When("^I add a new person and validate$")
    public void i_add_a_new_person_and_validate() throws Exception {
        caOneToMany.addPersonHomeDepo();
    }

    @Then("^I add the person to the roster$")
    public void i_add_the_person_to_the_roster() throws Exception {
        caOneToMany.rosterAddPersonValidation("Yes");
    }

    @Then("^I add the same person again$")
    public void i_add_the_same_person_again() throws Exception {
        caOneToMany.searchVendor();
        caOneToMany.addPersonHomeDepo();
    }

    @When("^I complete the order process$")
    public void i_complete_the_order_process() throws Exception {
        caPackages.beginOrderProcess();

    }

    @When("^Validate add person with same ssn$")
    public void validate_add_person_with_same_ssn() throws Exception {
        caOneToMany.validateAddPersonWithSameSsn();
    }

    @Then("^verify the SSN error message$")
    public void verify_the_SSN_error_message() throws Exception {
        caOneToMany.verifySsnErrorMsg();

    }

    @Then("^I validate the roster for yes no options$")
    public void i_validate_the_roster_for_yes_no_options() throws Exception {
        caOneToMany.rosterAddPersonValidation("No");
        caOneToMany.addPersonHomeDepo();
        caOneToMany.rosterAddPersonValidation("Yes");
        caOneToMany.personStatusValidation();
    }

    @Then("^I add the existing person from add existing person$")
    public void i_add_the_existing_person_from_add_existing_person() throws Exception {
        caOneToMany.searchVendor();
        caExistingPerson.addExistingPerson();
        caExistingPerson.verifyAddExistingPerson();
    }

    @When("^I add the photo badge and edit information$")
    public void i_add_the_photo_badge_and_edit_information() throws Exception {
        caPersonStatus1.editPersoninformationHD();
    }

    @When("^I validate the edit information$")
    public void i_validate_the_edit_information() throws Exception {

        caPersonStatus1.validateEditInformationHD();
    }

    @Then("^I select another LOB and vendor inside it$")
    public void i_select_another_LOB_and_vendor_inside_it() throws Exception {
        caOneToMany.selectLobHDIandSelectVendor();
    }

    @When("^I add the existing person to verify which is not existing$")
    public void i_add_the_existing_person_to_verify_which_is_not_existing() throws Exception {
        caExistingPerson.addExistingPersonWithoutAlreadyExisting();

    }

    @Then("^I validate decline FCRA agreement$")
    public void i_validate_decline_FCRA_agreement() throws Exception {
        cALoginPage.checkDeclineFCRA();
    }

    @Then("^I validate vendor page$")
    public void i_validate_vendor_page() throws Exception {
        caVendor.verifyVendorPage();

    }

    @When("^I verify warning fields$")
    public void i_click_on_add_Person_from_preson_menu_and_verify_fields() throws Exception {
        caAddPerson.addPersonVerify();
    }

    @Then("^I search the person$")
    public void i_search_the_person() throws Exception {
        caAddPerson.searchUpdatedPerson();
    }

    @Then("^I make the person inactive$")
    public void i_make_the_person_inactive() throws Exception {
        caAddPerson.inActivePerson();
    }

    @Then("^I verify begin order process button should be inactive$")
    public void i_verify_begin_order_process_button_should_be_inactive() throws Exception {
        caAddPerson.checkBeginOrderButtonActive();
    }

    @When("^I verify the packages available$")
    public void i_verify_the_packages_available() throws Exception {
        // caMyad.instantCheck();

    }

    @Then("^I click on Instant check and provide person details$")
    public void i_click_on_Instant_check_and_provide_person_details() throws Exception {
        caMyad.instantCheck();
        caMyad.orderYourMyAdvantageReport();

    }

    @Then("^I provide user Id and password$")
    public void i_provide_user_Id_and_password() throws Exception {

        caMyad.createUserId();
    }

    @Then("^I provide user Id and password for single search$")
    public void i_provide_user_Id_and_password_for_single_search() throws Exception {
        caMyad.createUserIdForSingleSearch();
    }

    @Then("^I provide user Id and password for resume check$")
    public void i_provide_user_Id_and_password_for_resume_check() throws Exception {
        caMyad.createUserIdForResumeCheck();
    }

    @Then("^I complete the payment for Instant check$")
    public void i_complete_the_payment_for_Instant_check() throws Exception {
        caMyad.invoicePaymentOrderConfirmation();

    }

    @Then("^Validate Promocode$")
    public void Validate_Promocode() throws Exception {
        caMyad.validatePromocode();
        databaseClass.validatePromocodeDB();
    }

    @Then("^I sign in using the credentials$")
    public void i_sign_in_using_the_credentials() throws Exception {
        caMyad.signIn();
    }

    @Then("^I click on Premium check and provide person details$")
    public void i_click_on_Premium_check_and_provide_person_details() throws Exception {
        caMyad.premiumCheck();
        caMyad.orderYourMyAdvantageReport();
    }

    @Then("^I click on Single check and provide person details$")
    public void i_click_on_Single_check_and_provide_person_details() throws Exception {
        caMyad.singleSearches();
        caMyad.orderYourMyAdvantageReport();
    }

    @Then("^I click on Resume check and provide person details$")
    public void i_click_on_Resume_check_and_provide_person_details() throws Exception {
        caMyad.resumeCheck();
        caMyad.orderYourMyAdvantageReport();
    }

    @Then("^I provide employment and educaitonal details$")
    public void i_provide_employment_and_educaitonal_details() throws Exception {
        caMyad.employmentVerification();
        caMyad.educationVerification();
    }

    @Then("^I provide employment details for resume check$")
    public void i_provide_employment_details_for_resume_check() throws Exception {
        caMyad.employmentVerificationForResumeCheck();
    }

    @When("^Validate existing person with same ssn but different name$")
    public void validate_existing_person_with_same_ssn_but_different_name() throws Exception {
        caOneToMany.searchVendor();
        caExistingPerson.addExistingPersonWithDifferentNameButSameSSN();

    }

    @Then("^I verify shopping cart button for \"([^\"]*)\" order$")
    public void i_verify_shopping_cart_button(String orderNumber) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        shopingCart.shoppingCartBtn(orderNumber);
    }

    @Then("^close Existing Packages$")
    public void close_Existing_Packages() throws Exception {
        ec.empty();
    }

    @Then("^Handle Popup$")
    public void Handle_Popup() throws Exception {
        hp.handlePopUp();
    }

    @Then("^Search Person By SSN$")
    public void Search_Person_By_SSN() throws Exception {
        sps.searchPersonByssn();
    }

    @Then("^Update Photo and Status$")
    public void update_Photo_and_Status(DataTable dataTable) throws Exception {
        String file = dataTable.values().get(0);

        PeopleID = up.updatePhoto(file);
    }

    @Then("^Execute Query of Photo Valid$")
    public void execute_Query_of_Photo_Valid() throws Exception {
        databaseClass.photoValid(PeopleID);
    }

    @Then("^POST Push back XML$")
    public void post_Push_back_XML(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String postURL = data.get(1).get(2);
        System.out.println(postURL);
        String Score = data.get(1).get(1);
        if (OrderRefID == null) {
            OrderRefID = "";
        }
        if (OrderRefID.equalsIgnoreCase("") || OrderRefID == null) {
            OrderRefID = Random_NumberGenerator(8);
        }

        cxu.pushBackUpdate(xmlPath, OrderID, OrderRefID, existingFirstName, existingLastName, SSN, Score);

        String response = wsu.sendPostRequest(postURL, xmlPath);
        System.out.println(response);
        ResponseXML = response;

    }

    @Then("^Verify Success Message In Response$")
    public void Verify_Success_Message_In_Response() throws Exception {
        cbr.verifyMessage(ResponseXML);
    }

    @Then("^wait for some seconds$")
    public void wait_for_some_seconds() throws Exception {
        wait(100);
    }

    @Then("^Refresh The Page$")
    public void Refresh_The_Page() throws Exception {
        driver.navigate().refresh();
    }

    @Then("^Run Update print Badge Status$")
    public void Run_Update_print_Badge_Status() throws Exception {
        databaseClass.updatePrintBadgeStatus();
    }

    @Then("^wait for Order Replacement Badge Button$")
    public void wait_for_Order_ReplacementBadge_Button() throws Exception {
        WebElement OrderReplacement = driver
                .findElement(By.xpath("(//*[contains(.,'ORDER REPLACEMENT BADGE')])[last()]"));
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOf(OrderReplacement));
    }

    @Then("^Make Badge Status as Printed$")
    public void Make_Badge_Status_as_Printed() throws Exception {
        databaseClass.badgeStatus(OrderID);
    }

    @Then("^Start JOB$")
    public void start_JOB() throws Exception {
        databaseClass.startJob();
    }

    @And("^Accept The Forms$")
    public void Accept_The_Forms() throws Exception {
        af.accept();
    }

    @Then("^Mail Body from OrderID$")
    public void Mail_Body_from_OrderID() throws Exception {
        databaseClass.getEmailBody(OrderID);
    }

    @Then("^Launch the DigitalBadge Link$")
    public void Launch_the_DigitalBadge_Link() throws Exception {
        uti.getDigitalBadgeLink(EmailBody);

        BadgeNumber = driver.findElement(By.xpath("//td[.='DIGITAL']/..//td[3]")).getText();
        driver.get(DigitalBadgeLink);
    }

    @Then("^Verify Digital Badge Details$")
    public void Verify_Digital_Badge_Details(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String Vendor = data.get(1).get(0);
        if (scenarioName.contains("Rescreening_") || scenarioName.contains("QRcode_")) {
            vdb.verifyRescreening(Vendor);
        } else {
            vdb.verify(Vendor);
        }
        driver.navigate().refresh();
    }

    @Then("^Verify Badge History Table$")
    public void Verify_Badge_History_Table(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String BadgeType = data.get(1).get(0);
        String BadgeStatus = data.get(1).get(1);
        vdb.verifyTable(BadgeType, BadgeStatus);
    }

    @Then("^EnableDisable Digital Badge$")
    public void EnableDisable_Digital_Badge(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String vendor = data.get(1).get(0);
        String value = data.get(1).get(1);
        databaseClass.enableDisbaleDigitalBadge(vendor, value);
    }

    @Then("^Click Logout$")
    public void Click_Logout() throws Exception {
        clickElement(LogoutBTN, "Logout");
        hp.handlePopUp();

    }

    /**
     * @author gerguran logout
     *****/

    @Then("^Click Logout NewUI$")
    public void clickLogoutNewUI() throws Exception {
        wait(3);
        clickElementWithWait(nuiHomePage.profileIcon, "Profile Icon");
        clickElementWithWait(nuiHomePage.logOutNui, "Logout");
    }

    @Then("^Verify Badge History Table Non Digital$")
    public void Verify_Badge_History_Table_Non_Digital(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String status = data.get(1).get(0);
        vdb.verifyTableNonDB(status);
    }

    @Then("^I should not see Text \"([^\"]*)\"$")
    public void I_should_not_see_Text(String Text) throws Exception {
        verifyTextNotPresence(Text);
    }

    @Then("^I should see Text \"([^\"]*)\"$")
    public void I_should_see_Text(String Text) throws Exception {
        // if (Text.equalsIgnoreCase("Name")) {
        if (Text.equalsIgnoreCase("PeopleName")) {
            Text = existingFirstName + " " + existingLastName;
        } else if (Text.equalsIgnoreCase("UserID")) {
            Text = userName;
        } else if (Text.equalsIgnoreCase("Notification User Name")) {
            Text = "Dear " + NotificationUserFirstName + " " + NotificationUserLastName + "";
        } else if (Text.equalsIgnoreCase("Notification Name")) {
            Text = "The compliance status has been updated for " + existingFirstName + " " + existingLastName + "";
        } else if (Text.equalsIgnoreCase("Notification Order ID")) {
            Text = OrderID;
        } else if (Text.equalsIgnoreCase("Notification Order Date")) {
            Text = NotificationOrderDate;
        } else if (Text.equalsIgnoreCase("Notification Package Name")) {
            Text = NotificationPackageName;
        } else if (Text.equalsIgnoreCase("Notification Status")) {
            Text = NotificationComplianceStatus;
        }
        wait(2);
        verifyTextPresence(Text);
    }

    @Then("^EnableDisable Digital Badge Customer Level$")
    public void EnableDisable_Digital_Badge_Customer_Level(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String value = data.get(1).get(0);
        DigitalOptional = value;
        String value1 = "";
        String value2 = "";
        if (value.equalsIgnoreCase("1")) {
            value1 = "N";
            value2 = "Y";
        } else if (value.equalsIgnoreCase("2")) {
            value1 = "Y";
            value2 = "N";
        } else if (value.equalsIgnoreCase("3")) {
            value1 = "N";
            value2 = "N";
        }
        databaseClass.enableDisbaleDigitalBadgeCustomer(value1, value2);
    }

    @And("^I should not see element \"([^\"]*)\"$")
    public void I_should_not_see_element(String Value) throws Exception {
        if (Value.equalsIgnoreCase("View Receipt")) {
            verifyElementNotPresence(By.xpath(
                            "((//span[.='Badge History']/..//div[.='Receipt']/../../../..//tr)[2]//td)[9]//input[@value='View Receipt']"),
                    Value);
        } else if (Value.equalsIgnoreCase("SEND BADGE")) {
            verifyElementNotPresence(By.xpath("//input[contains(@value,\"SEND BADGE\")]"), Value);
        } else if (Value.equalsIgnoreCase("Principle Package")) {
            verifyElementNotPresence(By.xpath("(//input[@name='vevaPackage.packageId'])[3]"), Value);
        } else if (Value.equalsIgnoreCase("NewYork Package")) {
            verifyElementNotPresence(By.xpath("(//input[@name='vevaPackage.packageId'])[1]"), Value);
        } else if (Value.equalsIgnoreCase("Rescreen")) {
            verifyElementNotPresence(By.xpath("((//td[contains(.,'Semi-Annual Screening')])[last()]/..//td)[1]"),
                    Value);
        } else if (Value.equalsIgnoreCase("Position Hire")) {
            verifyElementNotPresence(By.xpath("//select[@name='addressForm.positionLocCountryCode']"),
                    "Position Country");
            verifyElementNotPresence(By.xpath("//input[@name='addressForm.positionLocCityName']"), "Position City");
            verifyElementNotPresence(By.xpath("//select[@name='addressForm.positionLocStateCode']"), "Position State");
        } else if (Value.equalsIgnoreCase("Position Hire Person Status")) {
            verifyElementNotPresence(By.xpath(
                            "//td[contains(.,'State/Region:')]/../../..//td[contains(.,'City/Municipality:')]/../../..//td[contains(.,'Country:')]/../../..//b[contains(.,'Position/Hire Location')]"),
                    Value);
        } else if (Value.equalsIgnoreCase("Monitoring Status")) {
            verifyElementNotPresence(By.xpath("//select[@name='monitoringStatus']//option[.='Select:']"),
                    Value + " Select");
            verifyElementNotPresence(By.xpath("//select[@name='monitoringStatus']//option[.='Enabled']"),
                    Value + " Enabled");
            verifyElementNotPresence(By.xpath("//select[@name='monitoringStatus']//option[.='Not Enabled']"),
                    Value + " Not Enabled");
        } else if (Value.equalsIgnoreCase("Monitoring Status:")) {
            verifyElementNotPresence(By.xpath("//td[.='Monitoring Status:']"), Value);
        } else if (Value.equalsIgnoreCase("Profile Status")) {
            verifyElementNotPresence(By.xpath("(//*[contains(.,'Email Sent')])[14]"));
            verifyElementNotPresence(By.xpath("(//*[contains(.,'Consent Accepted')])[14]"));
            verifyElementNotPresence(By.xpath("(//*[contains(.,'Completed')])[14]"));

        } else if (Value.equalsIgnoreCase("Package Price Tag")) {
            verifyElementNotPresence(By.xpath("//*[contains(@class,'price-tag price-tag-desktop')]"));
        } else if (Value.equalsIgnoreCase("Background Tile")) {
            verifyElementNotPresence(By.xpath("//table/tbody/tr[2]/td/div/div/section/xf-order-card/div/span[2]/div"));
        }
//
//		else if (Value.contains("Status")) {
//			verifyElementNotPresence(By.xpath("//th[contains(text(),'"+Value+"') and @hidden]"));
//
//		}
        else if (Value.equalsIgnoreCase("new credit card")) {
            By newCreditCard = By.xpath("//*[@class = 'text-secondary d-inline-flex flex-wrap' and contains(., '"
                    + ccType + "') and contains(., '" + ccNumberEnding + "') and contains(., '" + ccExypiry + "')]");
            wait(2);
            verifyElementNotPresence(newCreditCard);

        } else if (Value.equalsIgnoreCase("compliance hyperlink")) {
            int rowcounter = driver.findElements(By.xpath("//tr[@class='a-panel']")).size();
            for (int i = 0; i < rowcounter; i++) {
                verifyElementNotPresence(By.xpath("//*[@id='panel-" + i + "']/td[3]/div/div/a"));
            }

        } else if (Value.equalsIgnoreCase("Screening Status") || Value.equalsIgnoreCase("Compliance")) {
            verifyElementNotPresence(By.xpath("(//th[contains(.,'" + Value + "') and not(@hidden)])[last()]"));

        } else if (Value.equalsIgnoreCase("dashboard")) {
            verifyElementNotPresence(By.xpath("//*[text()='Dashboard']"));

        } else if (Value.equalsIgnoreCase("administration")) {
            verifyElementNotPresence(nuiHomePage.adminstrationLink);

        } else if (Value.equalsIgnoreCase("your payments")) {
            verifyElementNotPresence(nuiHomePage.userYourPaymentsLink);

        } else if (Value.equalsIgnoreCase("Payment Method Page")) {
            verifyElementNotPresence(By.xpath("//div[contains(@class, 'step') and contains (., 'Payment Method')]"));

        } else if (Value.equalsIgnoreCase("Personal information")) {
            verifyElementNotPresence(By.xpath("//div//P[@class='form-label' and contains (text(), 'Personal Information')]"));

        } else {
            By xpath = By.xpath("(//*[@*[contains(.,'" + Value + "')]])[last()]");
            verifyElementNotPresence(xpath);
        }
    }

    /**
     * @throws Exception
     * @author gerguran verify text with hover
     *****/
    @And("^I hover over \"([^\"]*)\" on \"([^\"]*)\" and should see \"([^\"]*)\"$")
    public void hoverOver(String identifier, String page, String text) throws Exception {
        if (page.equalsIgnoreCase("New User")) {
            String xpathTxt = "//i[@triggers='mouseenter:mouseleave']";
            hoverTextValidatation(identifier, xpathTxt, text);
        } else if (page.equalsIgnoreCase("Edit User")) {
            String xpathTxt = "//i[@triggers='mouseenter:mouseleave']";
            hoverTextToolTip(identifier, xpathTxt, text);
        } else if (page.equalsIgnoreCase("update tooltip")) {
            String xpathTxt = "//button[contains(text(), 'Cancel')]";
            hoverTextToolTip(identifier, xpathTxt, text);
        } else if (page.equalsIgnoreCase("Role Info")) {
            String xpathTxt = "//i[@triggers='mouseenter:mouseleave']";
            hoverTextValidatation(identifier, xpathTxt, text);
            Actions action = new Actions(driver);
            action.moveByOffset(15, -15).perform();
        }
    }

    @And("^I compare value in \"([^\"]*)\" with picked up value from table$")
    public void compareValues(String page) throws Exception {
        if (page.equalsIgnoreCase("Edit User")) {

            String UserIdText = (String) ((JavascriptExecutor) driver)
                    .executeScript("return document.getElementById('user-name-field').value;");
            System.out.println("Angular " + UserIdText);
            System.out.println("Existing " + existingUserID);
            Assert.assertTrue(existingUserID.contains(UserIdText), "User ID is the same");
            System.out.println("User ID is the same from table.");
            reportLog(Status.PASS, "User ID is the same from table.", false);
        }

    }

    @And("^I should not see element \"([^\"]*)\" for \"([^\"]*)\"$")
    public void I_should_not_see_element_on(String Value, String identifier) throws Exception {
        wait(3);

        switch (identifier.toLowerCase()) {

            case "searched person":
                String result = nuiCommon.verifyStatusExistingPerson("Absent", Value);

                if (result.equalsIgnoreCase("Absent")) {
                    reportLog(Status.PASS, "Person status value is not present for " + existingFullName + " as expected",
                            true);
                } else if (result.equalsIgnoreCase("Present")) {
                    reportLog(Status.FAIL, "Person status value is present for " + existingFullName + " not as expected",
                            true);
                }

                break;

            case "disabled":

                if (!verifyElementPresence(By.xpath("(//*[contains(text(),'" + Value + "') and @disabled])[last()]"))) {
                    System.out.println("Element " + Value + " is not disabled");
                    reportLog(Status.PASS, "Element " + Value + " is not disabled", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is disabled", false);
                }
                break;

            case "POW":
                if (Value.contains("Package Price Label")) {
                    verifyElementNotPresence(By.xpath("//table/thead/tr/th[3][contains(text(),'Price')]"));
                } else if (Value.contains("Package Name")) {
                    verifyElementNotPresence(By.xpath("//tr[1]/td[2]"));
                } else if (Value.contains("Package select checkbox")) {
                    verifyElementNotPresence(By.xpath("//div[contains(@class, 'checked-radio')]"));
                } else if (Value.contains("Summary")) {
                    verifyElementNotPresence(By.xpath("//*[contains (@class, 'summary-item') and contains(., 'Summary')]"));
                } else if (Value.contains("Subtotal")) {
                    verifyElementNotPresence(
                            By.xpath("//*[contains (@class, 'summary-price-details') and contains(., 'Subtotal')]"));
                } else if (Value.contains("Tax")) {
                    verifyElementNotPresence(
                            By.xpath("//*[contains (@class, 'summary-price-details') and contains(., 'Tax')]"));
                } else if (Value.contains("Order total")) {
                    verifyElementNotPresence(
                            By.xpath("//*[contains (@class, 'text-primary') and contains(., 'Order Total')]"));
                }
                break;
            case "filter pill":

                if (verifyElementNotPresent(
                        By.xpath("//button[@class='filter-pill' and @disabled and text()='" + Value + "']"))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is not present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is present", false);
                }
                break;
            case "checkbox checked":
                String checked = ((JavascriptExecutor) driver).executeScript("return document.getElementById('" + Value + "').checked==true;").toString();
                if (checked.equalsIgnoreCase("false")) {
                    reportLog(Status.PASS, "Element is unchecked", false);
                } else {
                    reportLog(Status.FAIL, "Element is checked", false);
                    break;
                }
                break;
        }
    }

    /**
     * @author gerguran verify element with options
     *****/

    @And("^I should see element \"([^\"]*)\" for \"([^\"]*)\"$")
    public void I_should_see_element_on(String Value, String identifier) throws Exception {
        wait(3);
        List<WebElement> pagination;
        switch (identifier.toLowerCase()) {

            case "searched provider":
                nuiProgramOwner.providerStatus(Value);
                break;

            case "searched person":
                if (Value.equalsIgnoreCase("Active") || Value.equalsIgnoreCase("Inactive") || Value.equalsIgnoreCase("Terminated")) {
                    String result = nuiCommon.verifyStatusExistingPerson("Present", Value);
                    if (result.equalsIgnoreCase("Present")) {
                        reportLog(Status.PASS, "Person status value is present for " + existingFullName, true);
                    } else if (result.equalsIgnoreCase("Absent")) {
                        reportLog(Status.FAIL, "Person status value is not present for " + existingFullName, true);
                    }
                } else if (Value.equalsIgnoreCase("Provider Name")) {
                    nuiProgramOwner.verifyProviderNameForPeople();
                }
                break;

            case "green tick mark":
                int numValue = Integer.parseInt(Value.replaceAll(" completed sections", ""));
                List<WebElement> xpath = driver.findElements(By.xpath("//xf-section-marker/div/div[2]/div/a/div/i[2]"));
                int numXpath = xpath.size();

                if (numValue == numXpath) {
                    System.out.println("Element " + Value + " is present as " + identifier);
                    reportLog(Status.PASS, "Element " + Value + " is present as " + identifier, false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present as " + identifier, false);
                }
                break;

            case "background tile":

                if (verifyElementPresence(
                        By.xpath("//div[contains(@class,'badge-primary') and contains(text(),'" + Value + "')]"))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present", false);
                }
                break;

            case "compliance status":

                if (verifyElementPresence(
                        By.xpath("//td[@data-label='" + identifier + "']//*[contains(text(),'" + Value + "')]"))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present", false);
                }
                break;

            case "screening status":

                if (verifyElementPresence(
                        By.xpath("//td[@data-label='" + identifier + "']//*[contains(text(),'" + Value + "')]"))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present", false);
                }
                break;

            case "status":

                if (verifyElementPresence(By.xpath("//th[contains(text(),'" + Value + "') and not(@hidden)]"))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present", false);
                }
                break;

            case "displayed":

                if (verifyElementPresence(By.xpath("(//*[contains(@class,'" + Value.toLowerCase() + "')])[last()]"))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present", false);
                }
                break;

            case "filter pill":
                if (Value.equalsIgnoreCase("Provider Name")) {
                    //String providerName = _dataRepo.getData("ActiveProvider");
                    By providerNamePill = By.xpath("//*[contains (@class, 'active-filters')]//span[contains (., '" + providerName + "')]");
                    if (verifyElementPresence(providerNamePill)) {
                        logStepInfo("Provider: " + providerName + " is present as pill");
                        reportLog(Status.PASS, "Provider: " + providerName + " is present as pill", false);
                    }
                } else if (Value.equalsIgnoreCase("Vendor Name")) {
                    By vendorNamePill = By.xpath("//button[@class='filter-pill' and @disabled and text()='Vendor: " + providerName + "']");
                    if (verifyElementPresence(vendorNamePill)) {
                        logStepInfo("Vendor: " + providerName + " is present as pill");
                        reportLog(Status.PASS, "Vendor: " + providerName + " is present as pill", false);
                    }
                } else if (Value.equalsIgnoreCase("skip")) {
                    logStepInfo("Step skipped");
                    return;
                } else if (verifyElementPresence(nuiPeoplePage.filterPill(Value))) {
                    System.out.println("Element " + Value + " is present");
                    reportLog(Status.PASS, "Element " + Value + " is present", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not present", false);
                }
                break;

            case "disabled":

                if (verifyElementPresence(By.xpath("(//*[contains(text(),'" + Value + "') and @disabled])[last()]"))) {
                    System.out.println("Element " + Value + " is disabled");
                    reportLog(Status.PASS, "Element " + Value + " is disabled", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not disabled", false);
                }
                break;

            case "link url":
                wait(2);
                String URL = driver.getCurrentUrl();
                String text = null;
                if (Value.contains("Needs Review")) {
                    text = "screening=nr";

                } else if (Value.contains("Non-Compliant")) {
                    text = "screening=nc";

                } else if (Value.contains("Pending")) {
                    text = "screening=ip";

                } else if (Value.contains("Action Required")) {
                    text = "screening=ar";

                } else if (Value.contains("Expired")) {
                    text = "screening=ex";

                } else if (Value.contains("Active Providers")) {
                    text = "provider-search";

                }

                if (URL.contains(text)) {
                    reportLog(Status.PASS, "Expected text is verified- " + text, true);
                    logStepInfo("Expected text is verified " + text);
                } else {
                    reportLog(Status.FAIL, "Expected text is not verified- " + text, true);
                    logStepInfo("Expected text is not verified " + text);
                }
                break;

            // checking both double and single arrow next
            case "next button":
                pagination = driver.findElements(By.xpath("//li[contains(@class,'pagination-page page-item')]"));
                if (pagination.size() > 1) {
                    if (verifyElementPresence(By.xpath(
                            "//li[@class='pagination-next page-item disabled']//following::li[@class='pagination-last page-item disabled']"))) {
                        System.out.println("User is present on last page.");
                        reportLog(Status.PASS, "User is present on last page.", false);
                    } else {
                        //          reportLog(Status.FAIL, "User is not present on last page.", false);
                    }
                } else {
                    reportLog(Status.PASS, "Next button is disabled", false);
                }
                break;

            // checking both double and single arrow previous
            case "previous button":
                pagination = driver.findElements(By.xpath("//li[contains(@class,'pagination-page page-item')]"));
                if (pagination.size() > 1) {
                    if (verifyElementPresence(By.xpath(
                            "//li[@class='pagination-first page-item disabled']//following::li[@class='pagination-prev page-item disabled']"))) {
                        System.out.println("User is present on first page.");
                        reportLog(Status.PASS, "User is present on first page.", false);
                    } else {
                        //         reportLog(Status.FAIL, "User is not present on first page.", false);
                    }
                } else {
                    reportLog(Status.PASS, "Previous button is disabled", false);
                }
                break;

            case "action button":
                if (verifyElementPresence(By.xpath("//button[@id='dropdownMenuButton' and contains(@disabled,'')]"))) {
                    System.out.println("Action Button is disabled");
                    reportLog(Status.PASS, "Action button should be disabled.", false);
                } else {
                    reportLog(Status.FAIL, "Action button shouldn't be disabled.", false);
                }
                break;

            case "userid field":
                if (verifyElementPresence(By.xpath("//input[@id='user-name-field' and contains(@disabled,'')]"))) {
                    System.out.println("UserID field is read only");
                    reportLog(Status.PASS, "UserID field is read only", false);
                } else {
                    reportLog(Status.FAIL, "UserID field is read only", false);
                }
                break;

            case "password messages":
                if (Value.contains("At least")) {
                    By xpathFields = By
                            .xpath("//small[contains(text(),'" + Value + "')]/fa-icon/*[@data-icon='check-circle']");
                    verifyElementPresence(xpathFields, Value);
                    System.out.println("Js message checked");
                    reportLog(Status.PASS, "JS error message is present", false);
                }
                break;

            case "POW icon":
                if (Value.contains("add people icon")) {
                    verifyElementPresence(By.xpath("(//*[contains(@data-icon,'id-badge')])[last()]"));
                    // By.xpath("//div[contains(@class, 'tile')]")
                    reportLog(Status.PASS, "Add icon is present ", false);

                } else if (Value.contains("shopping cart menu button count two")) {
                    verifyElementPresence(By.xpath("//button[@class='profile action-profile-btn ng-star-inserted']//i[@data-count = '2']"));
                    reportLog(Status.PASS, "shopping cart menu button icon with count is present ", false);

                } else if (Value.contains("shopping cart menu button count One")) {
                    verifyElementPresence(By.xpath("//button[@class='profile action-profile-btn ng-star-inserted']//i[@data-count = '1']"));
                    reportLog(Status.PASS, "shopping cart menu button icon with count is present  ", false);

                } else if (Value.contains("shopping cart menu button icon with Count Zero")) {
                    verifyElementPresence(By.xpath("//button[@class='profile action-profile-btn ng-star-inserted']//i[@data-count = '0']"));
                    reportLog(Status.PASS, "shopping cart menu button icon is present ", false);

                } else if (Value.contains("add people icon Section")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-icon,'id-badge')])[last()-1]"));
                    reportLog(Status.PASS, "Add icon in Section bar is present ", false);

                } else if (Value.contains("package icon")) {
                    verifyElementPresence(By.xpath("(//*[contains(@data-icon,'boxes')])[last()]"));
                    reportLog(Status.PASS, "Package icon is present ", false);

                } else if (Value.contains("package icon Section")) {
                    verifyElementPresence(By.xpath("(//*[contains(@data-icon,'boxes')])[last()-1]"));
                    reportLog(Status.PASS, "Package icon in Section bar is present ", false);

                } else if (Value.contains("shopping cart icon")) {
                    verifyElementPresence(By.xpath("(//*[contains(@data-icon,'shopping-cart')])[last()]"));
                    reportLog(Status.PASS, "Package icon is present ", false);

                } else if (Value.contains("shopping cart icon Section")) {
                    verifyElementPresence(By.xpath("(//*[contains(@data-icon,'shopping-cart')])[last()-1]"));
                    reportLog(Status.PASS, "Package icon in Section bar is present ", false);

                } else if (Value.contains("delete icon")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-icon,'trash-alt')])"));
                    reportLog(Status.PASS, "Package icon in Section bar is present ", false);

                } else if (Value.contains("Accordion Shopping Cart")) {
                    verifyElementPresence(By.xpath("//*[@class='actionBtnCell ng-tns-c96-1']"));
                    reportLog(Status.PASS, "Package icon in Section bar is present ", false);

                } else if (Value.contains("credit card icon")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-icon,'credit-card')])[last()]"));
                    reportLog(Status.PASS, "Payment Method icon in Section bar is present ", false);

                } else if (Value.contains("credit card icon Section")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-icon,'credit-card')])[last()-1]"));
                    reportLog(Status.PASS, "Payment Method icon in Section bar is present ", false);

                } else if (Value.contains("order confirmation icon")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-icon,'check')])[last()]"));
                    reportLog(Status.PASS, "Payment Method icon in Section bar is present ", false);

                } else if (Value.contains("order confirmation Section")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-icon,'check')])[last()-1]"));
                    reportLog(Status.PASS, "Payment Method icon in Section bar is present ", false);

                } else {
                    reportLog(Status.FAIL, "Icon isn't present", false);
                }
                break;

            case "Vendor Onboarding":
                if (Value.contains("Check - User Profile")) {
                    verifyElementPresence(By.xpath("//div[1]/a/div/i[2]"));
                    reportLog(Status.PASS, "User Profile Check mark is present ", false);
                } else if (Value.contains("Check - Business Information")) {
                    verifyElementPresence(By.xpath("//div[2]/a/div/i[2]"));
                    reportLog(Status.PASS, "Business Information Check mark is present ", false);
                } else if (Value.contains("Check - Business Contact")) {
                    verifyElementPresence(By.xpath("//div[3]/a/div/i[2]"));
                    reportLog(Status.PASS, "Business Contact Check mark is present ", false);
                } else if (Value.contains("Check - Business Billing")) {
                    verifyElementPresence(By.xpath("//div[4]/a/div/i[2]"));
                    reportLog(Status.PASS, "Business Billing Check mark is present ", false);
                } else if (Value.contains("Check - Business Confirmation")) {
                    verifyElementPresence(By.xpath("//div[5]/a/div/i[2]"));
                    reportLog(Status.PASS, "Business Confirmation Check mark is present ", false);
                } else if (Value.contains("Check - Business Credit Card")) {
                    verifyElementPresence(By.xpath("//div[6]/a/div/i[2]"));
                    reportLog(Status.PASS, "Business Credit Card mark is present ", false);
                } else if (Value.contains("Check - Business Signature")) {
                    verifyElementPresence(By.xpath("//div[7]/a/div/i[2]"));
                    reportLog(Status.PASS, "Business Signature Check mark is present ", false);
                } else {
                    reportLog(Status.FAIL, "Check mark isn't present", false);
                }
                break;

            case "POW":
                if (Value.contains("Package select checkbox")) {
                    verifyElementPresence(By.xpath("//div[contains(@class, 'checked-radio')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else if (Value.contains("Package Name")) {
                    verifyElementPresence(By.xpath("//*[contains(@class,'packageName')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else if (Value.contains("Package Description")) {
                    verifyElementPresence(By.xpath("//*[contains(@class,'package-description')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else if (Value.contains("Package Price Tag")) {
                    verifyElementPresence(By.xpath("//*[contains(@class,'price-tag price-tag-desktop')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else if (Value.contains("Person Name Label")) {
                    verifyElementPresence(By.xpath("//th[contains(@class, 'ng-tns-c96-1') and contains(text(),'Person')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else if (Value.contains("Package Name Label")) {
                    verifyElementPresence(
                            By.xpath("//th[contains(@class, 'ng-tns-c96-1') and contains(text(),'Package')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else if (Value.contains("Package Price Label")) {
                    verifyElementPresence(By.xpath("//th[contains(@class, 'ng-tns-c96-1') and contains(text(),'Price')]"));
                    reportLog(Status.PASS, "Element is present ", false);
                } else {
                    System.out.println("Element on Summary table not present");
                    reportLog(Status.FAIL, "Element isn't present", false);
                }
                break;

            case "outstanding balance":
                if (Value.contains("outstanding message")) {
                    // outstandingTotal = _dataRepo.getData("Payment_Total");
                    outstandingTotal = orderTotal;
                    String outstandingMessage = driver.findElement(By.xpath("//h6/strong")).getText();
                    String outstandingMassageCompare = driver.findElement(By.xpath("//*[contains(text(),'You have an outstanding balance of  $" + outstandingTotal + "')]")).getText();
                    if (outstandingMessage.equals(outstandingMassageCompare)) {
                        reportLog(Status.PASS, "Element Present " + Value, false);
                        logStepInfo("See " + Value);
                    } else {
                        reportLog(Status.FAIL, "Element Not Present " + Value, false);
                    }

//                } else if (Value.contains("outstanding balance value")) {
//                    String outstandingBlanace = driver.findElement(By.xpath("//tr/td[5]")).getText();
//                    if (outstandingTotal.equals(outstandingBlanace)) {
//                        reportLog(Status.PASS, "Element Present " + Value, false);
//                        logStepInfo("See " + Value);
//                    } else {
//                        reportLog(Status.FAIL, "Element Not Present " + Value, false);
//                    }

                } else {
                    reportLog(Status.FAIL, "Element isn't present", false);
                }
                break;

            case "fcra":
                verifyElementPresence(By.xpath("/html/body/xf-root/xf-fcra/div/div/div[2]/section/div/div/p"));
                String ExistingFcra = driver
                        .findElement(By.xpath("/html/body/xf-root/xf-fcra/div/div/div[2]/section/div/div/p")).getText();
                String ExpectedFcra = PropertyFileReader.getProperty("FCRA");
                assertEquals(ExistingFcra, ExpectedFcra);
                reportLog(Status.PASS, "FCRA text matches", false);
                break;

            case "payment method":
                if (Value.equalsIgnoreCase("credit card")) {
                    String ccAddedUI = driver.findElement(By.xpath("//*[@class = 'text-secondary d-inline-flex flex-wrap' and contains(., '" + ccExypiry + "')]")).getText();
                    String ccAddedExpected = ccType + " ending in " + ccNumberEnding + "\n(expires " + ccExypiry + ")";
                    assertEquals(ccAddedUI, ccAddedExpected);
                    reportLog(Status.PASS, "New CC is present", false);

                } else if (Value.equalsIgnoreCase("credit card vendor reg")) {

                    String expiry = PropertyFileReader.getProperty("ccExypiry");
                    String type = PropertyFileReader.getProperty("ccType");
                    String ending = PropertyFileReader.getProperty("ccNumberEnding");

                    String ccAddedUI = driver.findElement(By.xpath("//*[@class = 'text-secondary d-inline-flex flex-wrap' and contains(., '" + expiry + "')]")).getText();
                    String ccAddedExpected = type + " ending in " + ending + "\n(expires " + expiry + ")";
                    assertEquals(ccAddedUI, ccAddedExpected);
                    reportLog(Status.PASS, "New CC is present", false);


                } else if (Value.contains("primary cc radiobutton")) {

                    List<WebElement> existingCCards = driver
                            .findElements(By.xpath("//xf-card-selection/div/div[2]/div/div"));
                    for (int i = 0; i < existingCCards.size(); i++) {
                        int ccCounter = i + 1;
                        By radioButton = By.xpath("//xf-checked-radio[contains(@data-xf-qa-id, 'CCP-CS-TOKEN-RADIO-" + i + "')]/div[@class='checked-radio active']");
                        String ccAddedExpected = driver
                                .findElement(By.xpath("//xf-card-selection/div/div[2]/div/div[" + ccCounter + "]"))
                                .getText();
                        String ccAddedUI = ccType + " ending in " + ccNumberEnding + "\n(expires " + ccExypiry
                                + ")\nRemove";

                        if (verifyElementPresence(radioButton)) {
                            System.out.println(ccAddedUI + " == " + ccAddedExpected + "line 2208 Common Step Defnition");
                            assertEquals(ccAddedUI, ccAddedExpected);
                            logStepInfo("radiobuton present:" + ccAddedUI);
                            reportLog(Status.PASS, "RadioButton is selected next to new CC", false);
                            break;
                        }
                    }
                } else {
                    reportLog(Status.FAIL, "Element isn't present", false);
                }
                break;
            case "needs review":
                if (verifyElementPresence(By.xpath("//*[text()='Needs Review']"))) {
                    reportLog(Status.PASS, "Element is checked", false);
                } else {
                    reportLog(Status.FAIL, "Element is unchecked", false);
                }
                if (verifyElementPresence(By.xpath("//*[text()=' " + Value + " ']"))) {
                    reportLog(Status.PASS, "Need review is " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Value is " + Value, false);
                }
                break;
            case "non-compliant":
                if (verifyElementPresence(By.xpath("//*[text()='Non-Compliant']"))) {
                    reportLog(Status.PASS, "Element is checked", false);
                } else {
                    reportLog(Status.FAIL, "Element is unchecked", false);
                }
                if (verifyElementPresence(By.xpath("//*[text()=' " + Value + " ']"))) {
                    reportLog(Status.PASS, "Need review is " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Value is " + Value, false);
                }
                break;
            case "Pending":
                if (verifyElementPresence(By.xpath("//*[text()='Pending']"))) {
                    reportLog(Status.PASS, "Element is checked", false);
                } else {
                    reportLog(Status.FAIL, "Element is unchecked", false);
                }
                if (verifyElementPresence(By.xpath("//*[text()=' " + Value + " ']"))) {
                    reportLog(Status.PASS, "Need review is " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Value is " + Value, false);
                }
                break;

            case "profile icon":
                databaseClass.getLoginUserName(userName);
                if (verifyElementPresence(By.xpath("//p[contains (@class, 'name') and contains (text(), '" + userNameLogin + "')]"))) {
                    reportLog(Status.PASS, "UserName is present in Profile Icon", false);
                } else {
                    reportLog(Status.FAIL, "UserName is not present in Profile Icon", false);
                }
                break;

            case "shopping cart":
                String legalizeLanguage = " By clicking \"Checkout\" I hereby, authorize and request First Advantage to charge my credit card for balances due for services rendered which may include later incurred additional court access or fees related to the services.  This authorization will remain in effect for a period of 90 days. ";
                verifyTextPresence(legalizeLanguage);
                reportLog(Status.PASS, "Legalize Language on shopping cart is present for Credit Card", false);
                break;

            case "readonly":
                if (Value.equalsIgnoreCase("Credit Card Number")) {
                    verifyElementPresence(By.xpath("//input[contains(@data-xf-qa-id, 'CCC-INPUT-CN') and @readonly]"));
                    reportLog(Status.PASS, "Credit Card Field is readonly", false);
                } else if (Value.equalsIgnoreCase("YY")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-xf-qa-id, 'CCC-SELECT-EXP-M') and @disabled]"));
                    reportLog(Status.PASS, "Year Field is readonly", false);
                } else if (Value.equalsIgnoreCase("MM")) {
                    verifyElementPresence(By.xpath("//*[contains(@data-xf-qa-id, 'CCC-SELECT-EXP-Y') and @disabled]"));
                    reportLog(Status.PASS, "Month Field is readonly", false);
                } else {
                    reportLog(Status.FAIL, "Element isn't readonly" + Value, false);
                }
                break;
            case "Disabled":
                if (verifyElementPresence(By.xpath("//button[contains(text(),'" + Value + "') and @disabled]"))) {
                    System.out.println("Element " + Value + " is disabled");
                    reportLog(Status.PASS, "Element " + Value + " is disabled", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not disabled", false);
                }
                break;
            case "element disabled":
                if (verifyElementPresence(By.xpath("//div[@class='px-0 col-sm-12 disabled']"))) {
                    System.out.println("Element " + Value + " is disabled and working as expected");
                    reportLog(Status.PASS, "Element " + Value + " is disabled and working as expected", false);
                } else {
                    reportLog(Status.FAIL, "Element " + Value + " is not disabled", false);
                }
                break;

            default:
                break;
        }
    }

    /**
     * @author gerguran added 6 case --> "search" "by search" "success message" "by
     * multi search" "pagination" "error message"
     *****/
    //todo dismantle this class into multiple pages
    @And("^I should see element \"([^\"]*)\"$")
    public void I_should_see_element(String Value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        switch (Value) {

            case "Here's your profile":
                if (verifyElementPresence(By.xpath("(//h3[contains(text(),'" + pANewFirstName + "')])[last()-1]"))) {
                    reportLog(Status.PASS, "Element is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "logout":
                if (verifyElementPresence(By.xpath("//*[@id=\"logout\"]/span"))) {
                    reportLog(Status.PASS, "Element is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Select Options Modal":
                if (verifyElementPresence(By.xpath("//div[@class='modal fade in show']//div[@class='modal-md absolute-modal']"))) {
                    reportLog(Status.PASS, "Chosing modal Element is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Chosing modal Element Not Present " + Value, false);
                }
                break;
            case "profile icon":
                if (verifyElementPresence(By.xpath("//i[contains(@class,'fa-user')]"))) {
                    reportLog(Status.PASS, "Profile Icon is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Profile Icon is not displayed " + Value, false);
                }
                break;
            case "forgot password link":
                if (verifyElementPresence(By.xpath("//div/font/span/div/a[contains(@href,'https')]"))) {
                    reportLog(Status.PASS, "Element is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Profile ID":
                wait(2);
                if (verifyElementPresence(By.xpath(
                        "//div[not(contains(@style,'display'))]/div/section/xf-order-card/div/span/div/div[1]/p[position()=2 and string-length(text()) > 0]"))) {
                    reportLog(Status.PASS, "Element is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Adopt and Sign unselected":
                if (verifyElementPresence(
                        By.xpath("//small[@class='text-danger d-block']//preceding::label[contains(text(),'"
                                + Value.replaceAll(" unselected", "") + "')]"))) {
                    reportLog(Status.PASS, "Checkbox is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Logo":

                if (verifyElementPresence(By.xpath("//div[contains(@class,'company-logo')]/img"))) {
                    reportLog(Status.PASS, "Logo is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Logo - forgot password":

                if (verifyElementPresence(By.xpath("//img[@class='brand-image']"))) {
                    reportLog(Status.PASS, "Logo is displayed", false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Today's Date":
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String todaysDate = formatter.format(date);
                if (verifyElementPresence(By.xpath("//div[@class='agreement-box']/div[2]/p/span"))) {
                    String existingTodaysDate = driver.findElement(By.xpath("//div[@class='agreement-box']/div[2]/p/span"))
                            .getText();
                    assertEquals(existingTodaysDate, todaysDate);
                    reportLog(Status.PASS, "Date has correct today's date", false);
                    logStepInfo("See " + Value + " " + existingTodaysDate);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Background Tile":
                if (verifyElementPresence(
                        By.xpath("//table/tbody/tr[2]/td/div/div/section/xf-order-card/div/span[2]/div"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "login page":
                wait(5);
                if (verifyElementPresence(By.xpath("//*[@class='login-page-panel']"))) {
                    reportLog(Status.PASS, "Element Present " + Value, true);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, true);
                }
                break;

            case "Hello message!":
                wait(5);
                if (verifyElementPresence(
                        By.xpath("//*[contains(text(),'Hi " + userFirstName + " ! Here is your dashboard.')]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "People":
                if (verifyElementPresence(By.xpath("//*[@class='table-header' and contains(.,'People')]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "xtdconnect banner":
                if (verifyElementPresence(By.xpath("//*[@class='form-body w-100 ng-star-inserted' and //div[@class = 'p-2 align-self-center mr-auto xtdConnect-header-img']]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "XtdConnect Opt-In ON":
                if (verifyElementPresence(NewUIXtdConnect.OptOutON)) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "XtdConnect Opt-Out Off":
                if (verifyElementPresence(NewUIXtdConnect.OptOutOff)) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "calenderIcon":
                WebElement hostElement = driver.findElement(By.cssSelector(".date-picker__calendar-icon"));
                WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].shadowRoot", hostElement);
                WebElement button = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].querySelector('your-button-xpath')", shadowRoot);

                if (button.isEnabled()) {
                    System.out.println("Button is clickable");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Button is not clickable");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            //payment summary table
            case "Person Name Label":
                if (verifyElementPresence(By.xpath("//*[@class='ng-tns-c201-3' and contains(text(), ' Person ')]"))) {
                    System.out.println("Element Person Name Label is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Element Person Name Label is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Package Name Label":
                if (verifyElementPresence(By.xpath("//*[@class='ng-tns-c201-3' and contains(text(), ' Package ')]"))) {
                    System.out.println("Element Package Name Label is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Element Package Name Label is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Package Price Label":
                if (verifyElementPresence(By.xpath("//*[@class='ng-tns-c201-3 ng-star-inserted' and contains(text(), ' Price ')]"))) {
                    System.out.println("Element Price Name Label is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Element Price Name Label is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Summary":
                if (verifyElementPresence(By.xpath("(//*[contains(text(),'Summary')])[1]"))) {
                    System.out.println("Element on Summary table is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Element on Summary table is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Subtotal":
                ExpectedCondition<String> SubtotalAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        WebElement subtotal = driver.findElement(By.xpath("(//*[contains(text(),'Subtotal')])[1]"));            //*[@class = 'card-text ng-tns-c426-3' and contains(., 'Subtotal:')]"));
                        if (subtotal.isDisplayed()) {
                            return subtotal.getText();
                        }
                        return null;
                    }
                };
                String SubtotalElement = wait.until(SubtotalAppears);
                System.out.println("Element is present = " + SubtotalElement);
                reportLog(Status.PASS, "Element Present " + SubtotalElement, false);
                logStepInfo("See " + SubtotalElement);
                break;
            case "Tax":
                ExpectedCondition<String> TaxAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        WebElement Tax = driver.findElement(By.xpath("(//*[contains(text(),'Tax')])[1]"));    //*[@class = 'card-text ng-tns-c426-3' and contains(., 'Tax')]"));
                        if (Tax.isDisplayed()) {
                            return Tax.getText();
                        }
                        return null;
                    }
                };
                String TaxElement = wait.until(TaxAppears);
                System.out.println("Element is present = " + TaxElement);
                reportLog(Status.PASS, "Element Present " + TaxElement, false);
                logStepInfo("See " + TaxElement);
                break;
            case "Applied Credit":
                ExpectedCondition<String> appliedCredit = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        WebElement appliedCreditElement = driver.findElement(By.xpath("(//*[contains(text(),'Applied Credit')])[1]"));            //*[@class = 'card-text ng-tns-c426-3' and contains(., 'Subtotal:')]"));
                        if (appliedCreditElement.isDisplayed()) {
                            return appliedCreditElement.getText();
                        }
                        return null;
                    }
                };
                String appliedCreditAmount = wait.until(appliedCredit);
                System.out.println("Element is present = " + appliedCreditAmount);
                reportLog(Status.PASS, "Element Present " + appliedCreditAmount, false);
                logStepInfo("See " + appliedCreditAmount);
                break;
            case "Order Total Site Credit Applied":
                ExpectedCondition<String> OrderTotalSiteCAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        WebElement OrderTotal = driver.findElement(By.xpath("(//*[contains(text(),'Order Total')])[1]"));   //*[contains(@class, 'text-primary') and contains(., 'Order Total')]"));
                        if (OrderTotal.isDisplayed()) {
                            return OrderTotal.getText();
                        }
                        return null;
                    }
                };
                String OrderTotalWithSiteCElement = wait.until(OrderTotalSiteCAppears);
                assertEquals("Order Total: $0.00", OrderTotalWithSiteCElement);
                System.out.println("Element is present = " + OrderTotalWithSiteCElement);
                reportLog(Status.PASS, "Element Present (" + OrderTotalWithSiteCElement + ")", false);
                logStepInfo("See " + OrderTotalWithSiteCElement);
                break;
            case "Order Total":
                ExpectedCondition<String> OrderTotalAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        WebElement OrderTotal = driver.findElement(By.xpath("(//*[contains(text(),'Order Total')])[1]"));   //*[contains(@class, 'text-primary') and contains(., 'Order Total')]"));
                        if (OrderTotal.isDisplayed()) {
                            return OrderTotal.getText();
                        }
                        return null;
                    }
                };
                String OrderTotalElement = wait.until(OrderTotalAppears);
                System.out.println("Element is present = " + OrderTotalElement);
                reportLog(Status.PASS, "Element Present (" + OrderTotalElement + ")", false);
                logStepInfo("See " + OrderTotalElement);
                break;
            case "Warning":
                if (verifyElementPresence(By.xpath("//*[@class = 'text-secondary' and contains(., 'Warning')]"))) {
                    System.out.println("Element warning is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Element warning is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Warning text":
                if (verifyElementPresence(By.xpath("//*[@class = 'd-flex warning-subtext text-center']"))) {
                    System.out.println("Element warning text is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("Element warning text is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "XtdConnect Logo On People Page":
                if (verifyElementPresence(By.xpath("//tr[@id='panel-0']//td[@data-label='Compliance Status']//div[@class='badge badge-pill xtd-connect-badge']"))) {
                    System.out.println("XtdConnectLogo is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("XtdConnectLogo is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "XtdConnect Logo on Modal":
                wait(3);
                if (verifyElementPresence(By.xpath("//img[@alt='XTD Connect Logo']"))) {
                    System.out.println("XtdConnectLogo at indicator is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("XtdConnectLogo is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "XtdConnect Logo On person details":
                if (verifyElementPresence(By.xpath("//div[@class='float-left']//div[contains(text(),'XtdConnect')]"))) {
                    System.out.println("XtdConnectLogo at person details is present");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("XtdConnectLogo at person details is Not present");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "search":
                wait(3);
                if (verifyElementPresence(By.xpath("//*[contains(@id,'search-btn')]"))) {
                    System.out.println("Search icon is present.");
                    reportLog(Status.PASS, "Search icon is present.", false);
                } else {
                    reportLog(Status.FAIL, "Search icon Not Present ", false);
                }
                break;

            case "hyperlink":
                if ((new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2))) {
                    System.out.println("Hyperlink is present.");
                    reportLog(Status.PASS, "Hyperlink is present.", false);

                    // get window handlers as list
                    List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
                    // switch to new tab
                    driver.switchTo().window(browserTabs.get(1));
                    hyperlinkURL = driver.getCurrentUrl();
                    logStepInfo("Hyperlink URL is:" + hyperlinkURL);
                    // check is it correct page opened or not (e.g. check page's title)
                    // ...
                    // then close tab and get back
                    driver.close();
                    driver.switchTo().window(browserTabs.get(0));

                } else {
                    reportLog(Status.FAIL, "Hyperlink not present ", false);
                }
                break;
            case "xtdConnect toast notification":
                wait(3);////div[@class='ng-tns-c123-4 ng-trigger ng-trigger-items ng-star-inserted']
                if (verifyElementPresence(By.xpath("//div[@id='toast-0']"))) {
                    System.out.println("xtdConnect toast notification is poping on-screen");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    logStepInfo("See " + Value);
                } else {
                    System.out.println("xtdConnect toast notification is Not present");
                    reportLog(Status.FAIL, " Element Not Present " + Value, false);
                }
                break;
            case "pagination":
                wait(3);
                scrollDown(3000);
                if (verifyElementPresence(By.xpath("//*[contains(@class,'" + Value + "')]"))) {
                    System.out.println("Pagination is present.");
                    reportLog(Status.PASS, "Pagination is present.", false);
                } else {
                    reportLog(Status.FAIL, "Pagination Not Present ", false);
                }
                break;
            case "by search":
                wait(3);
                if (verifyElementPresence(By.xpath("//*[contains(text(),'" + searchText + "')]"))) {

//				driver.navigate().refresh();
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, true);
                }
                break;
            case "by multi search":
                if (existingMiddleName != null) {
                    existingFullName = searchTextFN + " " + existingMiddleName + " " + searchTextLN;
                } else {
                    existingFullName = searchTextFN + " " + searchTextLN;
                }
                System.out.println(existingFullName);
                wait(5);
                if (verifyElementPresence(By.xpath("//tr[td[contains(text(),'" + existingFullName
                        + "')] and td [contains(text(),'" + searchTextEmail + "')]]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else if (verifyElementPresence(By.xpath("//tr[td[contains(text(),'" + existingFullName
                        + "')] and td [contains(text(),'" + searchTextSsn + "')]]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else if (verifyElementPresence(By.xpath("//tr[td[contains(text(),'" + searchTextFN
                        + "')] and td [contains(text(),'" + searchTextSsn + "')]]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);

                } else if (verifyElementPresence(By.xpath("//tr[@id='panel-0']//a[@class='person-details-redirect'][normalize-space()='" + existingFullName + "']"))) {

                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else if (verifyElementPresence(By.xpath("//tr[td[contains(text(),'" + searchTextLN
                        + "')] and td [contains(text(),'" + searchTextSsn + "')]]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);

                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "success message":
                wait.until(ExpectedConditions.presenceOfElementLocated(nuiCommon.msgModal));
                if (verifyElementPresence(nuiCommon.msgModal)) {
                    System.out.println("Message Present.");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    System.out.println("Message Not Present.");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "successfully connected message":
                ExpectedCondition<String> toastSuccessMessageAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        // Get the toast message element
                        WebElement toastElement = driver.findElement(By.xpath("//div[@class='toast-body ng-tns-c377-1']//p[@class='ng-tns-c377-1']"));
                        if (toastElement.isDisplayed()) {
                            // If the toast message is displayed, return the text
                            return toastElement.getText();


                        }
                        // If the toast message is not displayed, return null
                        return null;
                    }
                };

                // Wait for the toast message to appear and retrieve the text
                String toastSucessMessage = wait.until(toastSuccessMessageAppears);
                reportLog(Status.PASS, "Element Present " + toastSucessMessage, false);
                System.out.println("Toast Message: " + toastSucessMessage);
                break;
            case "Unsuccessfully connected Error message":
                ExpectedCondition<String> toastErrorMessageAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        // Get the toast message element
                        WebElement toastElement = driver.findElement(By.xpath("//div[@class='toast-body ng-tns-c377-1']//p[@class='ng-tns-c377-1']"));
                        if (toastElement.isDisplayed()) {
                            // If the toast message is displayed, return the text
                            return toastElement.getText();


                        }
                        // If the toast message is not displayed, return null
                        return null;
                    }
                };

                // Wait for the toast message to appear and retrieve the text
                String toastErrorMessage = wait.until(toastErrorMessageAppears);
                reportLog(Status.PASS, "Element Present " + toastErrorMessage, false);
                System.out.println("Toast Message: " + toastErrorMessage);
                break;
            case "Notice message on toast notification":
                ExpectedCondition<String> NoticeMessageAppears = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        // Get the toast message element   //div[@class='ng-tns-c123-4 ng-trigger ng-trigger-items ng-star-inserted']
                        WebElement toastElement = driver.findElement(By.xpath("//p[contains(text(),'To add another order you will need to checkout or clear your shopping cart')]"));
                        if (toastElement.isDisplayed()) {
                            // If the toast message is displayed, return the text
                            return toastElement.getText();
                            //p[contains(text(),'To add another order you will need to checkout or ')]

                        }
                        // If the toast message is not displayed, return null
                        return null;
                    }
                };

                // Wait for the toast message to appear and retrieve the text
                String NoticeMessage = wait.until(NoticeMessageAppears);
                reportLog(Status.PASS, "Toast message Present on-screen:    " + NoticeMessage, false);
                System.out.println("Toast Message:    " + NoticeMessage);
                break;
            case "Order Total Revised Modal":
                ExpectedCondition<String> orderTotalRevisedModal = new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        // Get the toast message element
                        WebElement ModalElement = driver.findElement(By.xpath("//div[@class='modal-content simple-modal']"));
                        if (ModalElement.isDisplayed()) {
                            // If the toast message is displayed, return the text
                            return ModalElement.getText();


                        }
                        // If the toast message is not displayed, return null
                        return null;
                    }
                };

                // Wait for the toast message to appear and retrieve the text
                String orderTotalConsumedMessages = wait.until(orderTotalRevisedModal);
                reportLog(Status.PASS, "Element Present " + orderTotalConsumedMessages, false);
                System.out.println("Toast Message: " + orderTotalConsumedMessages);
                break;
            case "error message":
                wait.until(ExpectedConditions.presenceOfElementLocated(nuiCommon.msgErrorModal));
                if (verifyElementPresence(nuiCommon.msgErrorModal)) {
                    System.out.println("Message Present " + Value);
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    System.out.println("Message Not Present " + Value);
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "View Receipt":
                if (verifyElementPresence(By.xpath(
                        "((//span[.='Badge History']/..//div[.='Receipt']/../../../..//tr)[2]//td)[9]//input[@value='View Receipt']"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Principle Package":
                if (verifyElementPresence(By.xpath("(//input[@name='vevaPackage.packageId'])[3]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Disabled Physical Badge":
                if (verifyElementPresence(
                        By.xpath("(//input[@disabled='disabled']/..//span[contains(.,'Physical Badge')])[last()-1]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                    clickElement(By.xpath("//input[@value='Cancel']"), "Cancel");
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Invalid Badge":
                if (verifyElementPresence(By.xpath("//div[contains(@class,'row bg-overlay-invalid')]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Monitoring Status":
                if (verifyElementPresence(By.xpath("//select[@name='monitoringStatus']//option[.='Select:']"))
                        && verifyElementPresence(By.xpath("//select[@name='monitoringStatus']//option[.='Enabled']"))
                        && verifyElementPresence(By.xpath("//select[@name='monitoringStatus']//option[.='Not Enabled']"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Profile Status":
                if (verifyElementPresence(By.xpath("(//*[contains(.,'Email Sent')])[14]"))) {
                    reportLog(Status.PASS, "Element Present " + Value + ": Email Sent", false);

                } else if (verifyElementPresence(By.xpath("(//*[contains(.,'Consent Accepted')])[14]"))) {
                    reportLog(Status.PASS, "Element Present " + Value + ": Consent Accepted", false);

                } else if (verifyElementPresence(By.xpath("(//*[contains(.,'Completed')])[14]"))) {
                    reportLog(Status.PASS, "Element Present " + Value + ": Completed", false);

                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Yes Text":
                if (verifyElementPresence(By.xpath("(//th/..//div/../../../..//tr/td[6][contains(.,'Yes')])[last()]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);

                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "No Text":
                if (verifyElementPresence(By.xpath("(//th/..//div/../../../..//tr/td[6][contains(.,'No')])[last()]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);

                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;

            case "Position Hire Person Status":
                if (verifyElementPresence(By.xpath(
                        "//td[contains(.,'State/Region:')]/../../..//td[contains(.,'City/Municipality:')]/../../..//td[contains(.,'Country:')]/../../..//b[contains(.,'Position/Hire Location')]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "filter button":
                if (verifyElementPresence(By.xpath(
                        "//*[@id=\"filter-btn\"]"))) {
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Sign up":
                if (verifyElementPresence(By.xpath("//button[@data-xf-qa-id='LOGIN-SIGNUP-BTN']"))) {
                    System.out.println("Sign up botton is present.");
                    reportLog(Status.PASS, "Element Present " + Value, false);
                } else {
                    System.out.println("Sign up botton is not present.");
                    reportLog(Status.FAIL, "Element Not Present " + Value, false);
                }
                break;
            case "Disabled Primary Contact Radiobutton":
                if (verifyElementPresence(
                        By.xpath("//xf-business-billing/div/div/div[3]/div/section/div[1]/div/div/div[2]"))) {
                    reportLog(Status.PASS, "Primary Contact is disabled", false);
                } else {
                    reportLog(Status.FAIL, "Primary Contact is not disabled", false);
                }
                break;
            case "Action Button":
                if (!verifyElementPresence(nuiPeoplePage.actionButtonDisabled)) {
                    verifyElementPresence(nuiPeoplePage.actionButton, "Action Button is present");
                } else {
                    scenarioFailed();
                }
            case "Providers":
                wait(2);
                if (verifyElementPresence(nuiHomePage.providersLinkElement)) {
                    reportLog(Status.PASS, "Providers button is Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Providers button is Not Present " + Value, false);
                }
                break;
            case "Provider pagination":
                if (verifyElementPresence(nuiHomePage.providerPagination)) {
                    reportLog(Status.PASS, "Providers pagination is Present " + Value, false);
                } else {
                    reportLog(Status.FAIL, "Providers pagination is Not Present " + Value, false);
                }
                break;
            case "Provider pill":
                if (verifyElementPresenceBoolean(By.xpath("//*[text()='Provider: " + providerName + "']"), "Vendor pill verified")) {
                    reportLog(Status.PASS, "Vendor pill is rendering vendor " + providerName, false);
                } else {
                    reportLog(Status.FAIL, "Vendor pill is rendering vendor " + providerName, false);
                }
            case "Help Center":
                verifyElementPresence(nuiHomePage.helpCenter, "Help Center in Profile Icon");
                break;
        }

    }

    @Then("^I Select \"([^\"]*)\" radio button$")
    public void I_Should_Select_Radio_Button(String Value) throws Exception {
        dpb.selectBadge(Value);
    }

    @Then("^I Verify Order Summary Page$")
    public void I_Verify_Order_Summary_Page(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String BadgeType = data.get(1).get(0);
        String PackagePrice = data.get(1).get(1);
        String Tax = data.get(1).get(2);
        String Total = data.get(1).get(3);
        dpb.verifyOrderSummary(BadgeType, PackagePrice, Tax, Total);
    }

    @Then("^Verify Order Confirmation Page$")
    public void Verify_Order_Confirmation_Page(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String BadgeType = data.get(1).get(0);
        String Total = data.get(1).get(1);

        dpb.badgeOrderConfirmation(BadgeType, Total);
    }

    @Then("^Verify Receipt$")
    public void Verify_Receipt(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String ExpectedCompanyName = data.get(1).get(0);
        String ExpectedAddress = data.get(1).get(1);
        String ExpectedBasePackageRate = data.get(1).get(2);
        String ExpectedBasePackageTax = data.get(1).get(3);
        TaxAmount = ExpectedBasePackageTax;
        String ExpectedSubTotal = data.get(1).get(4);
        String ExpectedTotal = data.get(1).get(5);
        String ExpectedAmountCharged = data.get(1).get(6);
        TotalAmount = ExpectedAmountCharged;
        String ExpectedStatus = data.get(1).get(7);

        vr.receipt(ExpectedCompanyName, ExpectedAddress, ExpectedBasePackageRate, ExpectedBasePackageTax,
                ExpectedSubTotal, ExpectedTotal, ExpectedAmountCharged, ExpectedStatus);
    }

    @Then("^Verify Receipt Digital$")
    public void Verify_Receipt_Digital(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String ExpectedCompanyName = data.get(1).get(0);
        String ExpectedAddress = data.get(1).get(1);
        String ExpectedBasePackageRate = data.get(1).get(2);
        String ExpectedBasePackageTax = data.get(1).get(3);
        TaxAmount = ExpectedBasePackageTax;
        String ExpectedSubTotal = data.get(1).get(4);
        String ExpectedTotal = data.get(1).get(5);
        String ExpectedAmountCharged = data.get(1).get(6);
        TotalAmount = ExpectedAmountCharged;
        String ExpectedStatus = data.get(1).get(7);

        vr.receiptDigital(ExpectedCompanyName, ExpectedAddress, ExpectedBasePackageRate, ExpectedBasePackageTax,
                ExpectedSubTotal, ExpectedTotal, ExpectedAmountCharged, ExpectedStatus);
    }

    @Then("^Verify Receipt Order History$")
    public void Verify_Receip_Order_History(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String ExpectedCompanyName = data.get(1).get(0);
        String ExpectedAddress = data.get(1).get(1);
        String ExpectedBasePackageRate = data.get(1).get(2);
        String ExpectedBasePackageTax = data.get(1).get(3);
        TaxAmount = ExpectedBasePackageTax;
        String ExpectedSubTotal = data.get(1).get(4);
        String ExpectedTotal = data.get(1).get(5);
        String ExpectedAmountCharged = data.get(1).get(6);
        TotalAmount = ExpectedAmountCharged;
        String ExpectedStatus = data.get(1).get(7);
        if (AdditionalBilling == null) {
            databaseClass.getAdditionalBilling();
        }
        if (AdditionalBilling.equalsIgnoreCase("Y")) {
//			if(!(scenarioName.contains("VendorRegistration-HD")||(scenarioName.contains("NONHD")))) {
            if (!(scenarioName.contains("VendorRegistration-HD"))) {
                double amount = Double.parseDouble(ExpectedBasePackageRate) + 10;
                ExpectedBasePackageRate = "" + amount;
                TaxAmount = ExpectedBasePackageTax;
                ExpectedSubTotal = "" + amount;
                ExpectedTotal = "" + amount;
                ExpectedAmountCharged = "" + amount;
                TotalAmount = ExpectedAmountCharged;
            }
        }

        if (scenarioName.contains("Batch")) {
            BatchFirstName = driver
                    .findElement(By.xpath("(//td[contains(.,'First Name:')]/..//td[@class='dispValue'])[1]")).getText();
            existingFirstName = BatchFirstName;
        }

        if (!(ExpectedCompanyName.equalsIgnoreCase("Assign Amount"))) {
            vr.receiptOH(ExpectedCompanyName, ExpectedAddress, ExpectedBasePackageRate, ExpectedBasePackageTax,
                    ExpectedSubTotal, ExpectedTotal, ExpectedAmountCharged, ExpectedStatus);
        }

    }

    @Then("^Verify Digital Badge Paid Flag$")
    public void Verify_Digital_Badge_Paid_Flag(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String Expected = data.get(1).get(0);

        databaseClass.orderPaidFlag(OrderID, Expected);
    }

    @Then("^Execute Rescreen Queries$")
    public void Execute_Rescreen_Queries() throws Exception {
        String day = SystemDateDay();
        String month = SystemDateMonth2();
        String year = SystemDateYear().substring(2);
        int month1 = Integer.parseInt(month);
        int year1 = Integer.parseInt(year);
        String month2 = "";

        if (month1 > 6) {
            month1 = month1 - 6;
        } else if (month1 == 6) {
            month1 = 12;
            year1 = year1 - 1;
        } else if (month1 == 5) {
            month1 = 11;
            year1 = year1 - 1;
        } else if (month1 == 4) {
            month1 = 10;
            year1 = year1 - 1;
        } else if (month1 == 3) {
            month1 = 9;
            year1 = year1 - 1;
        } else if (month1 == 2) {
            month1 = 8;
            year1 = year1 - 1;
        } else if (month1 == 1) {
            month1 = 7;
            year1 = year1 - 1;
        }

        if (month1 == 1) {
            month2 = "JAN";
        } else if (month1 == 2) {
            month2 = "FEB";
        } else if (month1 == 3) {
            month2 = "MAR";
        } else if (month1 == 4) {
            month2 = "APR";
        } else if (month1 == 5) {
            month2 = "MAY";
        } else if (month1 == 6) {
            month2 = "JUN";
        } else if (month1 == 7) {
            month2 = "JUL";
        } else if (month1 == 8) {
            month2 = "AUG";
        } else if (month1 == 9) {
            month2 = "SEP";
        } else if (month1 == 10) {
            month2 = "OCT";
        } else if (month1 == 11) {
            month2 = "NOV";
        } else if (month1 == 12) {
            month2 = "DEC";
        }

        if (month1 == 3 || month1 == 2 || month1 == 1) {
            OldDate = day + "-" + month2 + "-" + year1;
        } else {
            OldDate = day + "-" + month2 + "-" + year1;
        }

        databaseClass.rescreenUpdate(OrderID, OldDate);
    }

    @Then("^Get OrderID Of Rescreen$")
    public void Get_OrderID_Of_Rescreen() throws Exception {
        String order = driver.findElement(By.xpath("((//td[contains(.,'Semi-Annual Screening')])[last()]/..//td)[1]"))
                .getText();
        OrderID = order.replaceAll(" ", "");
    }

    @Then("^Start Compliance Job$")
    public void Start_Compliance_Job() throws Exception {
        databaseClass.startComplianceJob();
    }

    @When("^I Rectify Login$")
    public void I_Rectify_Login() throws Exception {
        String answer = _dataRepo.getData("secretAnswer");
        if (verifyElementPresence(SecretAnswerTB)) {
            EnterText(SecretAnswerTB, "Secret Answer", answer);
            clickElement(RectifyBTN, "Rectify");
        }
    }

    @Then("^Verify presence of Add new User and Add$")
    public void Verify_presence_of_Add_new_User_and_Add(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String ShouldPresent = data.get(1).get(0);
        String addUser = data.get(1).get(1);
        String addPerson = data.get(1).get(2);

        if (addPerson.equalsIgnoreCase("YES")) {
            vcv.presentOfaddPerson();
        } else if (addPerson.equalsIgnoreCase("NO")) {
            vcv.absentOfaddPerson();
        }

        if (ShouldPresent.equalsIgnoreCase("YES")) {
            vcv.presentOfAdmin();
        } else if (ShouldPresent.equalsIgnoreCase("NO")) {
            vcv.absentOfAdmin();
        }

        if (addUser.equalsIgnoreCase("YES")) {
            vcv.addUser();
        }
    }

    @Then("^Add User \"([^\"]*)\"$")
    public void add_User(String role) throws Exception {

        String UserID = "";
        String password = "Password@123";
        String firstName = "AUTOFIRST_" + Random_StringGenerator(4);
        String lastName = "AUTOLAST_" + Random_StringGenerator(4);
        String email = _dataRepo.getData("Email");

        if (role.equalsIgnoreCase("ADMIN")) {
            UserID = "AUTOMATIONADMIN" + Random_NumberGenerator(4);
            UserIDUserAdmin = UserID;
        } else if (role.equalsIgnoreCase("SUMMARY")) {
            UserID = "AUTOMATIONSUMMARY" + Random_NumberGenerator(4);
            UserIDUserSummary = UserID;
        } else if (role.equalsIgnoreCase("UPDATE")) {
            UserID = "AUTOMATIONUPDATE" + Random_NumberGenerator(4);
            UserIDUserUpdate = UserID;
        } else if (role.equalsIgnoreCase("VIEW")) {
            UserID = "AUTOMATIONVIEW" + Random_NumberGenerator(4);
            UserIDUserView = UserID;
        }

        au.addUser(UserID, password, firstName, lastName, email, "Enabled", role);
    }

    @Then("^Reset Password for New User$")
    public void Reset_Password_for_New_User() throws Exception {
        au.resetPassword();
    }

    @Then("^I Set Secret Question$")
    public void I_Set_Secret_Question() throws Exception {
        String Question = _dataRepo.getData("secretQuestion");
        String Answer = _dataRepo.getData("secretAnswer");
        au.setSecretQTN(Question, Answer);
    }

    @When("^I Verify Legal Agreements \"([^\"]*)\"$")
    public void verifyLegalAgreement(String value) throws Exception {
        String custID = "";
        if (scenarioName.contains("-HD-")) {
            custID = "1296";
        } else if (scenarioName.contains("-NONHD-")) {
            custID = "215";
        }
        databaseClass.getCRWstatus(custID);

        String errorMsg1 = _dataRepo.getData("errorMsg1");
        String errorMsg2 = _dataRepo.getData("errorMsg2");
        String errorMsg3 = _dataRepo.getData("errorMsg3");

        switch (value) {

            case "CRW ExistingUser":
                if (crwValue.equalsIgnoreCase("Y")) {
                    vla.crwenabledExistingUser(errorMsg1, errorMsg2);
                } else if (crwValue.equalsIgnoreCase("N")) {
                    vla.crwdisabledExistingUser(errorMsg1);
                }

                break;
            case "CRW NewUser":
                if (crwValue.equalsIgnoreCase("Y")) {
                    vla.crwenabledNewUser(errorMsg1, errorMsg2, errorMsg3);
                } else if (crwValue.equalsIgnoreCase("N")) {
                    vla.crwdisabledNewUser(errorMsg1, errorMsg3);
                }
                break;

        }
    }

    @Then("^Update DA Flow xml$")
    public void Update_DA_Flow_xml(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String Score = data.get(1).get(1);
        String FirstName = data.get(1).get(2);
        String LastName = data.get(1).get(3);
        String ReferenceID = data.get(1).get(4);
        String ssn = data.get(1).get(5);

        if (FirstName.equalsIgnoreCase("YES")) {
            existingFirstName = "Automation" + Random_StringGenerator(5);
        }

        if (LastName.equalsIgnoreCase("YES")) {
            existingLastName = "Automation" + Random_StringGenerator(5);
        }

        if (ReferenceID.equalsIgnoreCase("YES")) {
            OrderRefID = Random_NumberGenerator(9);
        }

        if (ssn.equalsIgnoreCase("YES")) {
            SSN = Random_NumberGenerator(9);
        }

        cxu.daUpdate(xmlPath, OrderRefID, existingFirstName, existingLastName, SSN, Score);

    }

    @Then("^POST xml$")
    public void POST_xml(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String postURL = data.get(1).get(1);

        String response = wsu.sendPostRequest(postURL, xmlPath);
        logStepInfo(response);
        ResponseXML = response;
    }

    @Then("^Verify FirstName LastName SSN Order Date and Complete Date in Person Status Detail Page$")
    public void Verify_FirstName_LastName_SSN_Order_Date_and_Complete_Date_in_Person_Status_Detail_Page()
            throws Exception {
        vpsdp.verify();
    }

    @Then("^Get peopleID$")
    public void Get_peopleID() throws Exception {
        PeopleID = up.getPeopleID();
    }

    @Then("^Verify LocationID from DB$")
    public void Verify_LocationID_from_DB(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();

        String Update = data.get(1).get(0);
        databaseClass.getLocationID(Update);
    }

    @Then("^Compare LocationID$")
    public void Compare_LocationID() throws Exception {
        if (LocationIDold == null) {
            LocationIDold = "";
        }
        if (LocationIDold.equalsIgnoreCase("")) {
            LocationIDold = LocationID;
            reportLog(Status.PASS, "Location ID is " + LocationIDold, false);
        } else {
            if (LocationIDold.contentEquals(LocationID)) {
                reportLog(Status.PASS, "Location ID is not Changed and present", false);
            } else {
                reportLog(Status.FAIL, "Location ID is Changed or not present", false);
            }
        }
    }

    @And("^ExecuteTestScenario$")
    public void executetestscenario(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        for (int i = 0; i < 1; i++) {
            String testname1 = data.get(i).get(0);
            reportLog(Status.INFO, " '" + testname1 + "' ", false);
        }
    }

    @Then("^Get OrderID$")
    public void Get_OrderID() throws Exception {
        String order;
        if (scenarioName.contains("DigitalBadge_")) {
            order = driver.findElement(By.xpath("((//div[contains(.,'Order Id')])/../../../..//td)[16]")).getText();
        } else {
            order = driver.findElement(By.xpath("((//div[contains(.,'Order Id')])/../../../..//td)[17]")).getText();
        }

        OrderID = order.replaceAll(" ", "");
        valuefromUI = OrderID;
    }

    @Then("^Get OrderID First$")
    public void Get_OrderID_First() throws Exception {
        String order = driver.findElement(By.xpath("((//div[contains(.,'Order Id')])/../../../..//td)[1]")).getText();
        OrderID = order.replaceAll(" ", "");
        valuefromUI = OrderID;
    }

    @When("^I make the vendor \"([^\"]*)\" for \"([^\"]*)\"$")
    public void makevendorStatus(String status, String vendor) throws Exception {
        String value = "";
        if (status.equalsIgnoreCase("Inactive")) {
            value = "INACTIVE";
        } else if (status.equalsIgnoreCase("active")) {
            value = "ACTIVE";
        }
        databaseClass.inactiveActiveVendorStatus(value, vendor);
    }

    @Then("^verify VO_ORDERED_BY and VO_USER_MODIFIED Coloumns$")
    public void verify_VO_ORDERED_BY_and_VO_USER_MODIFIED_Coloumns(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();

        String ExpectedOrderBy = data.get(1).get(0);
        String ExpectedUserModified = data.get(1).get(1);
        databaseClass.getOrderByUserModified(ExpectedOrderBy, ExpectedUserModified);
    }

    @Then("^Get QR Code UUID$")
    public void Get_QR_Code_UUID() throws Exception {
        databaseClass.getQRcodeUUID();
    }

    @Then("^Navigate to \"([^\"]*)\" Page$")
    public void navigate(String value) throws Exception {
        if (value.equalsIgnoreCase("Forward")) {
            driver.navigate().forward();
            driver.navigate().refresh();
        } else if (value.equalsIgnoreCase("Previous")) {
            driver.navigate().back();
            driver.navigate().refresh();
        } else {
            driver.get(value);
        }
    }

    @Then("^I should see Warning Text \"([^\"]*)\"$")
    public void I_should_see_Warning_Text(String Text) throws Exception {
        if (Text.equalsIgnoreCase("Name")) {
            Text = existingFirstName + " " + existingLastName;
        }
        verifyWarningTextPresence(Text);
    }

    @Then("^I should not see Warning Text \"([^\"]*)\"$")
    public void I_should_not_see_Warning_Text(String Text) throws Exception {

        verifyWarningTextNotPresence(Text);
    }

    @Then("^Update NewYork Package$")
    public void Update_NewYork_Package(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();

        String value1 = data.get(1).get(0);
        String value2 = data.get(1).get(1);
        databaseClass.enableDisbaleNYPackage(value1, value2);
    }

    @Then("^Execute Query for Compliance Expiry$")
    public void Execute_Query_for_Compliance_Expiry() throws Exception {
        databaseClass.ExpireCompliant();
    }

    @Then("^Verify Compliance Expiry$")
    public void Verify_Compliance_Expiry() throws Exception {
        String ActualDate = driver.findElement(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[2]"))
                .getText().replaceAll(" ", "");
        String ExpectedDate = CurrentDateTime.geDayBeforetYesterdayDate1();
        if (ActualDate.equalsIgnoreCase(ExpectedDate)) {
            reportLog(Status.PASS, "Expected Date:[" + ExpectedDate + "] Actual Date:[" + ActualDate + "]", true);
        } else {
            reportLog(Status.FAIL, "Expected Date:[" + ExpectedDate + "] Actual Date:[" + ActualDate + "]", true);
        }
    }

    @Then("^Update Compliance Status$")
    public void Update_Compliance_Status() throws Exception {
        databaseClass.updateCompliant();
    }

    @Then("^Start Rescreening Job$")
    public void Start_Rescreening_Job() throws Exception {
        databaseClass.startRescreeningJob();
    }

    @When("^I Select The Vendor \"([^\"]*)\"$")
    public void I_Select_The_Vendor(String value) throws Exception {
        clickElement(By.xpath("//a[contains(.,'" + value + "')]"), value);
    }

    @When("^I Select The Vendor \"([^\"]*)\" with SalesForceID \"([^\"]*)\"$")
    public void I_Select_The_Vendor_with_SalesForceID(String value, String salesForce) throws Exception {
        clickElement(By.xpath("(//td[contains(.,'" + salesForce + "')])[last()]/..//a[contains(.,'" + value + "')]"),
                value);
    }

    @Then("^Get VendorID from OrderID$")
    public void Get_VendorID_from_OrderID() throws Exception {
        databaseClass.getVendorIDFromOrder();
    }

    @Then("^Get VendorID from Vendor Name$")
    public void Get_VendorID_from_Vendor_Name() throws Exception {
        databaseClass.getVendorIDFromVendorName();
    }

    @Then("^Store VendorID and Compare$")
    public void Store_VendorID_and_Compare() throws Exception {

        if (VendorIDold.equalsIgnoreCase("")) {
            VendorIDold = VendorID;
        } else {
            VendorIDold2 = VendorID;
        }

        if (!(VendorIDold.equalsIgnoreCase("")) && !(VendorIDold2.equalsIgnoreCase(""))) {

            if (VendorIDold.equalsIgnoreCase(VendorIDold2)) {
                reportLog(Status.FAIL, "Vendor ID is Same", false);
            } else {
                reportLog(Status.PASS, "Vendor ID is Different", false);
            }
        }
    }

    @Then("^wait Until Compliance Status is \"([^\"]*)\"$")
    public void wait_Until_Compliance_Status_is(String value) throws Exception {
        for (int i = 1; i <= 40; i++) {
            wait(20);
            driver.navigate().refresh();
            String ActualStatus = driver
                    .findElement(By.xpath("(//td[contains(.,'Compliance Status:')])[last()]/..//td[2]")).getText()
                    .replaceAll(" ", "");
            if (ActualStatus.equalsIgnoreCase(value)) {
                reportLog(Status.PASS, "Compliance Status is " + ActualStatus + " in " + i * 20 + " Seconds", true);
                break;
            } else if (i == 40) {
                reportLog(Status.FAIL, "Compliance Status is " + ActualStatus + " in " + i * 20 + " Seconds", true);
            }
        }

    }

    @Then("^wait Until Rescreening Order is Present$")
    public void wait_Until_Rescreening_Order_is_Present() throws Exception {
        for (int i = 1; i <= 100; i++) {
            wait(20);
            driver.navigate().refresh();
            if (verifyElementPresence(By.xpath("((//td[contains(.,'Semi-Annual Screening')])[last()]/..//td)[1]"))) {
                reportLog(Status.PASS, "Rescreenin Triggered in " + i * 20 + " Seconds", true);
                break;
            } else if (i == 100) {
                reportLog(Status.FAIL, "Rescreenin not Triggered in " + i * 20 + " Seconds", true);
            }
        }

    }

    @Then("^wait Until second Rescreening Order is Present$")
    public void wait_Until_second_Rescreening_Order_is_Present() throws Exception {
        for (int i = 1; i <= 50; i++) {
            wait(20);
            driver.navigate().refresh();
            if (verifyElementPresence(
                    By.xpath("(//span[.='Order History']/..//td[contains(.,'Semi-Annual Screening')])[2]"))) {
                reportLog(Status.PASS, "Rescreenin Triggered in " + i * 20 + " Seconds", true);
                break;
            } else if (i == 50) {
                reportLog(Status.FAIL, "Rescreenin not Triggered in " + i * 20 + " Seconds", true);
            }
        }

    }

    @Then("^Get Credit Card Data from DB$")
    public void Get_Credit_Card_Data_from_DB(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();

        String OrderID = data.get(1).get(0);
        String TransactionID = data.get(1).get(1);
        String Invoice = data.get(1).get(2);
        String VendorName = data.get(1).get(3);

        if (OrderID.equalsIgnoreCase("YES") && TransactionID.equalsIgnoreCase("NO") && Invoice.equalsIgnoreCase("NO")
                && VendorName.equalsIgnoreCase("NO")) {
            if (scenarioName.contains("GlobalOrder")) {
                databaseClass.getCreditCardDetailsGlobal();
            } else {
                databaseClass.getCreditCardDetails();
            }
        } else if (OrderID.equalsIgnoreCase("YES") && TransactionID.equalsIgnoreCase("YES")
                && Invoice.equalsIgnoreCase("YES") && VendorName.equalsIgnoreCase("NO")) {
            databaseClass.getCreditCardDetailsTranctionID();
        } else if (OrderID.equalsIgnoreCase("NO") && TransactionID.equalsIgnoreCase("NO")
                && Invoice.equalsIgnoreCase("NO") && VendorName.equalsIgnoreCase("YES")) {
            databaseClass.getCreditCardDetailsVendorName();
        }

    }

    @Then("^Verify Logs Coloumn$")
    public void Verify_Logs_Coloumn(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();

        String inputPath = data.get(1).get(0);
        String outputPath = data.get(1).get(1);
        if (scenarioName.contains("Batch")) {
            double amount = Double.parseDouble(TotalAmount);
            amount = amount * 5;
            TotalAmount = "" + amount;
        }

        String input = vcc.creditCardInput(CreditCardInput);
        new WriteFile().write(input, inputPath);
        String output = vcc.creditCardOutput(CreditCardOutput);
        new WriteFile().write(output, outputPath);
        reportLog(Status.INFO, "***********Input Log************", false);
        vcc.getValueInput(inputPath);
        reportLog(Status.INFO, "***********Output Log************", false);
        vcc.getValueOutput(outputPath);

    }

    @Then("^EnableDisale ShoppingCart$")
    public void EnableDisale_ShoppingCart(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();

        String custID = data.get(1).get(0);
        ShoppingCart = data.get(1).get(1);
        databaseClass.updateShoppingCart(custID, ShoppingCart);

    }

    @Then("^Get Data from Drug Table$")
    public void Get_Data_from_Drug_Table() throws Exception {
        databaseClass.getDrugTableDetails();
    }

    @Then("^Get Data from FP Table$")
    public void Get_Data_from_FP_Table() throws Exception {
        databaseClass.getFingerPrintDetails();
    }

    @Then("^Fill Payment Details for Lockheed Martin$")
    public void Fill_Payment_Details_for_Lockheed_Martin() throws Exception {
        String PaymentMethod = _dataRepo.getData("PaymentMethod");
        String CardType = _dataRepo.getData("CardType");
        String cardNumber = _dataRepo.getData("CardNumber");
        String cseNumber = "678";
        String ExpMonth = CurrentDateTime.SystemDateMonth1();
        int ExpYear1 = Integer.parseInt(CurrentDateTime.SystemDateYear()) + 2;
        String ExpYear = "" + ExpYear1;
        pplm.fillPayment(PaymentMethod, CardType, cardNumber, cseNumber, ExpMonth, ExpYear);
    }

    @Then("^Get Vendor Data From DB$")
    public void Get_Vendor_Data_From_DB(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String Scenario = data.get(1).get(0);
        databaseClass.getVendorData(Scenario);
    }

    @Then("^Select LOB$")
    public void Select_LOB(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String LOB = data.get(1).get(0);
        vlob.selectLOB(LOB);
    }

    @Then("^Select Organisation Name$")
    public void Select_Organisation_Name(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String OrgName = data.get(1).get(0);
        vlob.selectOrganisation(OrgName);
    }

    @Then("^Order Batch$")
    public void Order_Batch() throws Exception {
        bo.batchOrder();
    }

    @Then("^Update Digital Badge Price$")
    public void Update_Digital_Badge_Price(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String Price = data.get(1).get(0);
        databaseClass.updateDigitalBadgePrice(Price);
    }

    @Then("^Delete Email Of Person$")
    public void Delete_Email_Of_Person() throws Exception {
        databaseClass.deleteEmail();
    }

    @Then("^Update EmailID$")
    public void Update_EmailID() throws Exception {
        hp.handlePopUpRemoveEmail();
        dpb.updateEmail();
    }

    @Then("^Verify the Number of Digital Badge Records Which is Emailed are Success$")
    public void Verify_the_Number_of_Digital_Badge_Records_Which_is_Emailed_are_Success() throws Exception {
        vdb.verifyDigitalBadgeStatus();
    }

    @Then("^Verify Badge Number are Different$")
    public void Verify_Badge_Number_are_Different() throws Exception {
        vdb.verifyBadgeNumber();
    }

    @Then("^Verify Search People$")
    public void Verify_Search_People() throws Exception {
        vp.verifySearchPeople();
    }

    @Then("^Verify Middle Name \"([^\"]*)\"$")
    public void Verify_Middle_Name(String middleName) throws Exception {
        vp.verifyMiddleName(middleName);
    }

    @Then("^Save The Credentials \"([^\"]*)\"$")
    public void Save_The_Credentials(String Type) throws Exception {
        databaseClass.savePerformance(Type);
    }

    @Then("^I Select Country \"([^\"]*)\" from Position Location$")
    public void I_Select_Country(String Country) throws Exception {
        selectDropDown(By.xpath("//select[@name='addressForm.positionLocCountryCode']"), Country, Country);
    }

    @Then("^I Enter City \"([^\"]*)\" from Position Location$")
    public void I_Enter_City(String City) throws Exception {
        EnterText(By.xpath("//input[@name='addressForm.positionLocCityName']"), City, City);
    }

    @Then("^I Select State \"([^\"]*)\" from Position Location$")
    public void I_Select_State(String State) throws Exception {
        selectDropDown(By.xpath("//select[@name='addressForm.positionLocStateCode']"), State, State);
    }

    @Then("^Verify Position Location Country \"([^\"]*)\" City \"([^\"]*)\" State \"([^\"]*)\"$")
    public void Verify_Position_Location(String Country, String City, String State) throws Exception {
        plp.verifyPositionLocation(Country, City, State);
    }

    @And("^I fill SSN$")
    public void I_fill_SSN() throws Exception {
        if (verifyElementPresence(ssnYRadio))
            clickElementWithWait(ssnYRadio, "Clicked on Yes Radio button");
        EnterText(By.xpath("//input[@name='ssn']"), "SSN", SSN);
    }

    @And("^Verify Position Location DB$")
    public void Verify_Position_Location_DB(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String xmlPath = data.get(1).get(0);
        String Country = data.get(1).get(1);
        String State = data.get(1).get(2);
        String City = data.get(1).get(3);
        databaseClass.getPositionLocation(OrderID);
        plp.getValuePositionLocation(xmlPath, Country, State, City);
        databaseClass.getPositionLocationIndividual(Country, State, City);
    }

    @And("^Set Position Hire Property$")
    public void Set_Position_Hire_Property(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String value = data.get(1).get(0);
        databaseClass.updatePositionLocation(value);
    }

    @Then("^Verify the Number of Digital Badge Records Which is Emailed are Success Rescreeing$")
    public void Verify_the_Number_of_Digital_Badge_Records_Which_is_Emailed_are_Success_Rescreeing(DataTable values)
            throws Exception {
        List<List<String>> data = values.asLists();
        String Physical = data.get(1).get(0);
        String Digital = data.get(1).get(1);
        vdb.verifyDigitalBadgeStatusRescreening(Physical, Digital);
    }

    @And("^I click on \"([^\"]*)\"$")
    public void I_click_on(String value) throws Exception {
        if (value.equalsIgnoreCase("Report")) {
            clickElement(By.xpath("//*[@id='menuHeaderId']/tbody/tr/td[5]/a"), value);
            clickElement(By.xpath("//a[@href='viewDashboardReports.do']"), "Dashboard Report");
        } else if (value.equalsIgnoreCase("Log into Compliance")) {
            clickElement(By.xpath("//input[@value='" + value + "']"), value);
            wait(5);
            String parent = driver.getWindowHandle();
            ArrayList<String> list = new ArrayList<String>();
            list.addAll(driver.getWindowHandles());
            System.out.println(list.get(1).toString());
            String child = list.get(1).toString();
            driver.switchTo().window(child);
            driver.switchTo().window(parent);
            driver.close();
            driver.switchTo().window(child);
        } else if (value.equalsIgnoreCase("MiddleName Yes")) {
            clickElement(By.xpath("//input[@name='middleNameRequired' and @value='Y']"), value);
        } else if (value.equalsIgnoreCase("MiddleName No")) {
            clickElement(By.xpath("//input[@name='middleNameRequired' and @value='N']"), value);
        } else if (value.equalsIgnoreCase("Additional Billing Location No")) {
            clickElement(By.xpath("//input[@name='hasAddCtrySelected' and @title='No']"), value);
        } else if (value.equalsIgnoreCase("Checkout")) {
            DatabaseClass DB = new DatabaseClass();
            DB.getAdditionalBilling();
            if (AdditionalBilling.equalsIgnoreCase("Y") && !(scenarioName.contains("NONHD"))
                    && !(scenarioName.contains("Tax_CA") && !(scenarioName.contains("Compliance_CA")))) {
                clickElement(By.xpath("//input[@value='" + value + "']"), value);
            }
        } else if (value.equalsIgnoreCase("Compliant Eligible Record")) {
            clickElement(By.xpath("(//span[.='Compliant']/../../..//span[.='Eligible']/../../..//a)[1]"), "value");
        } else if (value.equalsIgnoreCase("Non-Compliant InEligible Record")) {
            clickElement(By.xpath("(//span[.='Non-Compliant']/../../..//span[.='Ineligible']/../../..//a)[1]"),
                    "value");
        } else if (value.equalsIgnoreCase("InProgress Eligible Record")) {
            clickElement(By.xpath("(//span[.='In Progress']/../../..//span[.='Eligible']/../../..//a)[1]"), "value");
        } else if (value.equalsIgnoreCase("I Agree")) {
            scrollDown(300);
            clickElement(By.id("registerBtn"), value);
        } else if (value.equalsIgnoreCase("Previous")) {
            scrollDown(300);
            clickElement(By.xpath("//input[@name='Previous']"), value);
        } else if (value.equalsIgnoreCase("Next")) {
            clickElement(By.xpath("//input[@id='idSIButton9']"), value);
        } else if (value.equalsIgnoreCase("expand Inbox")) {
            clickElement(By.xpath("//div[2]/div[2]/div/button"), value);
        } else if (value.equalsIgnoreCase("CA FADV Folder")) {
            clickElement(By.xpath("//div[@title='CA.DoNotReply@FADV.com']"), value);

        } else if (value.equalsIgnoreCase("Unread email Password Reset")) {
            value = value.replaceAll("Unread email ", "");
            By xpath = By.xpath("(//div[contains(@aria-label,'Unread')]//span[contains(text(),'" + value + "')])[1]");
            clickElement(xpath, value);

        } else if (value.equalsIgnoreCase("link from mail")) {
            By xpath = By.xpath("//div/font/span/div/a[contains(@href,'https')]");
            clickElement(xpath, value);

        } else if (value.equalsIgnoreCase("profile-icon")) {
            By xpath = By.xpath("//i[contains(@class,'fa-user')]");
            clickElementJS(xpath, value);
        } else if (value.equalsIgnoreCase("pgo-profile-icon")) {
//                By xpath = By.xpath("//div[@class='profile action-profile-btn open']");
//                clickElement(xpath, value);
            WebElement element = driver.findElement(By.xpath("//div[@class='profile action-profile-btn']"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);

        } else if (value.equalsIgnoreCase("logout")) {
            By xpath = By.xpath("//*[@id=\"logout\"]/span");
            clickElement(xpath, value);
        } else if (value.equalsIgnoreCase("pgo-logout")) {
//                By xpath = By.xpath("(//span[@class='flex-grow-1 mr-auto text-left logout-button'])[1]");
//                clickElement(xpath, value);
            WebElement element = driver.findElement(By.xpath("//span[@class='flex-grow-1 mr-auto text-left logout-button']"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);

        } else if (value.equalsIgnoreCase("Sign In")) {
            By xpath = By.xpath("//*[@type=\"submit\"]");
            clickElement(xpath, value);

        } else if (value.equalsIgnoreCase("Do not stay login")) {
            By xpath = By.xpath("//*[@type='button' and @value='No']");
            clickElement(xpath, value);

        } else if (value.equalsIgnoreCase("People")) {
            By xpath = By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/div[4]/li/div");
            clickElement(xpath, value);
        } else if (value.equalsIgnoreCase("Dashboard")) {
            By xpath = By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/div[1]/li/div");
            clickElement(xpath, value);
        } else {
            clickElement(By.xpath("//input[@value='" + value + "']"), value);
        }
    }

    @Then("^verify Credential Status$")
    public void verify_Credential_Status(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String salesForceID = data.get(1).get(0);
        String ExpectedText = data.get(1).get(1);
        String ActualText = driver
                .findElement(By.xpath("(//td[contains(.,'" + salesForceID + "')])[last()]/..//td[last()]")).getText();
        if (ActualText.equals(ExpectedText)) {
            reportLog(Status.PASS,
                    "Expected status is [" + ExpectedText + "] and Actual status is [" + ActualText + "]", true);
        } else {
            reportLog(Status.FAIL,
                    "Expected status is [" + ExpectedText + "] and Actual status is [" + ActualText + "]", true);
        }
    }

    @And("^I Validate UserProfile$")
    public void I_Validate_UserProfile() throws Exception {
        vup.validate();
    }

    @Then("^wait for \"([^\"]*)\" Seconds$")
    public void I_wait_for(String value) throws Exception {
        wait(Integer.parseInt(value));
    }

    @Then("^wait until Badge is Generated$")
    public void wait_Until_Badge_is_Generated() throws Exception {
        for (int i = 1; i <= 40; i++) {
            wait(20);
            driver.navigate().refresh();
            if (verifyElementPresence(By.xpath("//td[.='DIGITAL']"))) {
                reportLog(Status.PASS, "Badge is Generated in " + i * 20 + " Seconds", true);
                break;
            } else if (i == 40) {
                reportLog(Status.FAIL, "Badge is not Generated in " + i * 20 + " Seconds", true);
            }
        }
    }

    @Then("^Verify Number of Physical Badge in Order History to be \"([^\"]*)\"$")
    public void Verify_Number_of_Physical_Badge(String value) throws Exception {
        BadgeNumber = driver
                .findElement(By.xpath(
                        "//td[@class='dispLabelTextRight' and contains(.,'Badge Number')]/..//td[@class='dispValue']"))
                .getText();
        int size = driver.findElements(By.xpath("//span[.='Badge History']/..//tr//td[.='" + BadgeNumber + "']"))
                .size();
        if (size == Integer.parseInt(value)) {
            reportLog(Status.PASS, "Actual Physical Badge Record present is [" + size
                    + "] and Expected Physical Badge Record is [" + value + "]", true);
        } else {
            reportLog(Status.FAIL, "Actual Physical Badge Record present is [" + size
                    + "] and Expected Physical Badge Record is [" + value + "]", true);
        }
    }

    @Then("^wait until Physical Badge is Generated$")
    public void wait_Until_Physical_Badge_is_Generated() throws Exception {
        for (int i = 1; i <= 40; i++) {
            wait(20);
            driver.navigate().refresh();
            if (verifyElementPresence(By.xpath("(//span[.='Badge History']/..//tr)[2]"))) {
                reportLog(Status.PASS, "Badge is Generated in " + i * 20 + " Seconds", true);
                break;
            } else if (i == 40) {
                reportLog(Status.FAIL, "Badge is not Generated in " + i * 20 + " Seconds", true);
            }
        }
    }

    @Then("^Search Person By FN$")
    public void Search_Person_By_FN() throws Exception {
        sps.searchPersonByFN();
    }

    /**
     * @author gerguran
     * @category search by
     **/
    @Then("^Search table By \"([^\"]*)\" in \"([^\"]*)\" page$")
    public void Search_Person_By(String value, String pageName) throws Exception {
        if (value.contains("&")) {
            if (value.equalsIgnoreCase("FN & LN & Email")) {
                String[] searchValues = {"FN", "LN", "Email"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            } else if (value.equalsIgnoreCase("FN & LN")) {
                String[] searchValues = {"FN", "LN"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            } else if (value.equalsIgnoreCase("LN & Email")) {
                String[] searchValues = {"LN", "Email"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            } else if (value.equalsIgnoreCase("FN & Email")) {
                String[] searchValues = {"FN", "Email"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            } else if (value.equalsIgnoreCase("FN & LN & SSN")) {
                String[] searchValues = {"FN", "LN", "SSN"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            } else if (value.equalsIgnoreCase("FN & SSN")) {
                String[] searchValues = {"FN", "SSN"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            } else if (value.equalsIgnoreCase("LN & SSN")) {
                String[] searchValues = {"LN", "SSN"};
                nuiCommon.searchUserByMultiValue(searchValues, pageName);
            }
        } else {
            nuiCommon.searchUserByValue(value, pageName);
        }
    }

    @Then("^I fill details in Employment Information form on Person Information page$")
    public void Fill_employment_information_details_Person_information_Page() throws Exception {

        String Employer = "Auto_" + Random_StringGenerator(4);
        String BusinessType = "Auto_" + Random_StringGenerator(4);
        String Address1 = _dataRepo.getData("Address");
        String City = _dataRepo.getData("City");
        String State = _dataRepo.getData("State");
        String Zipcode = _dataRepo.getData("ZipCode");
        String Phone = Random_NumberGenerator(10);
        String fromdate = _dataRepo.getData("FromDate");
        String ToDate = _dataRepo.getData("ToDate");
        String Tittle = _dataRepo.getData("TittleEmp");
        String StartingPay = _dataRepo.getData("StartingPay");
        String EndingPay = _dataRepo.getData("EndingPay");
        String Supervisor = "Auto_" + Random_StringGenerator(4);
        String SupervisorTitle = _dataRepo.getData("SupervisorTitle");
        String SupervisorPhone = Random_NumberGenerator(10);
        String SupervisorPhoneExtn = Random_NumberGenerator(4);
        String StartingPayType = _dataRepo.getData("StartingPayType");
        String EndingPayType = _dataRepo.getData("EndingPayType");

        pi.addEmploymentInformation(Employer, BusinessType, Address1, City, State, Zipcode, Phone, fromdate, ToDate,
                Tittle, StartingPay, EndingPay, StartingPayType, EndingPayType, Supervisor, SupervisorTitle,
                SupervisorPhone, SupervisorPhoneExtn);

    }

    @And("^I fill details in Reference Information form on Person Information page$")
    public void Fill_reference_information_details_Person_information_Page() throws Exception {

        String Name = "Auto_" + Random_StringGenerator(4);
        String PrimaryPhoneNumber = Random_NumberGenerator(10);
        String AlternatePhoneNumber = Random_NumberGenerator(10);
        String PrimaryPhoneNumberExtn = Random_NumberGenerator(4);
        String AlternatePhoneNumberExtn = Random_NumberGenerator(4);
        String YearsYouHaveKnownReference = _dataRepo.getData("YearsKnown");
        String StateReference = _dataRepo.getData("StateRef");

        pi.referenceInformation(Name, PrimaryPhoneNumber, AlternatePhoneNumber, PrimaryPhoneNumberExtn,
                AlternatePhoneNumberExtn, YearsYouHaveKnownReference, StateReference);
    }

    @Then("^Fill Pre-Request Form$")
    public void Fill_Pre_Request_Form() throws Exception {
        String companyName = "Auto_" + Random_StringGenerator(7);
        String Address1 = _dataRepo.getData("Address");
        String City = _dataRepo.getData("City");
        String State = _dataRepo.getData("State");
        String Zip = _dataRepo.getData("ZipCode");
        String StateSF = _dataRepo.getData("StateSF");
        String phone = Random_NumberGenerator(10);
        bps.orderReport(companyName, Address1, City, State, Zip, phone, StateSF);
    }

    @Then("^Select Order Component \"([^\"]*)\"$")
    public void Select_Order_Component(String value) throws Exception {
        bps.selectReportComponents(value);
    }

    @Then("^Verify Business Pre-Screening Payment Detail Page and Place Order$")
    public void Verify_Business_Pre_Screening_Payment_Detail_Page_and_Place_Order() throws Exception {
        bps.verifyBusinessPaymentDetailPage();
    }

    @Then("^Verify Business Pre-Screening Order Confirmation Page$")
    public void Verify_Business_Pre_Screening_Order_Confirmation_Page() throws Exception {
        bps.verifyBusinessOrderConfirmationPage();
    }

    @Then("^Verify Business Pre-Screening Print Current Receipt$")
    public void Verify_Business_Pre_Screening_Print_Current_Receipt() throws Exception {
        bps.verifyBusinessPrintReceipt();
    }

    @Then("^Verify Search Report$")
    public void Verify_Search_Report() throws Exception {
        bps.verifySearchReport();
    }

    @Then("^Verify View Report$")
    public void Verify_View_Report() throws Exception {
        bps.viewReport();
    }

    @Then("^Verify Report Presence$")
    public void Verify_Report_Presence() throws Exception {
        rrc.verifyReport();
    }

    @Then("^Verify Active Badge Report$")
    public void Verify_Active_Badge_Report() throws Exception {
        rrc.verifyActiveBadgeReport();
    }

    @Then("^Search Person By \"([^\"]*)\" Status$")
    public void Search_Person_By_Statust(String value) throws Exception {
        sps.searchPersonByStatus(value);
    }

    @Then("^Verify the Person Information Page$")
    public void Verify_the_Person_Information_Page() throws Exception {
        pi.verifyPerson();
    }

    @Then("^I should Select \"([^\"]*)\" from Customer Name$")
    public void I_should_Select_from_Customer_Namet(String value) throws Exception {
        selectDropDown(By.xpath("//select[@name='dependentCustID']"), value, "Customer Name");
    }

    @Then("^I click Agree of \"([^\"]*)\"$")
    public void I_click_Agree(String value) throws Exception {
        if (value.equalsIgnoreCase("Installer Background Package")) {
            if (verifyElementPresence(By.xpath("//input[@name='agreed_15104']"))) {
                clickElement(By.xpath("//input[@name='agreed_15104']"), "Agree");
            }
            if (verifyElementPresence(By.xpath("//input[@name='agreed_15407']"))) {
                clickElement(By.xpath("//input[@name='agreed_15407']"), "Agree");
            }
            if (verifyElementPresence(By.xpath("//input[@name='agreed_15068']"))) {
                clickElement(By.xpath("//input[@name='agreed_15068']"), "Agree");
                clickElement(By.xpath("//input[@value='Next']"), "Next");
                clickElement(By.xpath("(//input[@value='N'])[last()]"), "No");
            }
        } else if (value.equalsIgnoreCase("Repair Background Package")) {
            clickElement(By.xpath("//input[@name='agreed_15367']"), "Agree");
            clickElement(By.xpath("//input[@name='copyToApplicant']"), "Agree");
        } else if (value.equalsIgnoreCase("Crew Package")) {
            clickElement(By.xpath("//input[@name='agreed_13767']"), "Agree");
        }
    }

    @Then("^Verify TransactionID in View Receipt$")
    public void Verify_TransactionID_in_View_Receipt() throws Exception {
        vr.receiptTransactionID();
    }

    @Then("^Verify presence of Search User and Search$")
    public void Verify_presence_of_Search_Users_and_Search(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String ShouldPresent = data.get(1).get(0);
        String searchUser = data.get(1).get(1);
        if (!(scenarioName.contains("SC34"))) {
            if (ShouldPresent.equalsIgnoreCase("YES")) {
                vcv.presentOfAdmin();
            } else if (ShouldPresent.equalsIgnoreCase("NO")) {
                vcv.absentOfAdmin();
            }
        }

        if (searchUser.equalsIgnoreCase("YES")) {
            vcv.searchUser();
        }
    }

    @Then("^Search User Role And Status$")
    public void Search_User_Role_And_Status(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String Role = data.get(1).get(0);
        String Status = data.get(1).get(1);

        vcv.searchUserWithRolesAndStatus(Role, Status);
    }

    @Then("^Verify Adminstration Tab Is Present$")
    public void Verify_Adminstration_Tab_Is_Present() throws Exception {
        caMyad.presentOfAdmin();
    }

    @And("^I click on Link \"([^\"]*)\"$")
    public void I_click_on_Link(String value) throws Exception {

        clickElement(By.xpath("(//a[contains(.,'" + value + "')])[last()]"), value);
    }

    @Then("^Fill Service Provider Profile$")
    public void Fill_Service_Provider_Profile() throws Exception {
        String UserID = "AutoTest" + Random_NumberGenerator(5);
        String Password = "Password@123";
        String SecretQtn = _dataRepo.getData("secretQuestion");
        String SecretAns = _dataRepo.getData("secretAnswer");
        vrp.serviceProviderProfile(UserID, Password, SecretQtn, SecretAns);
    }

    @Then("^Fill Business Information$")
    public void Fill_Business_Information() throws Exception {
        String BusinessCountry = _dataRepo.getData("Country");
        String LegalBusinessName = "AutoVendorTest" + Random_NumberGenerator(5);
        String DoingBusinessAs = "Test";
        String TypeOfBusiness = "Non-Profit";
        String ownerShipInfo = "QCTeam";
        String BusinessSSN = Random_NumberGenerator(9);
        String BusinessAddress1 = _dataRepo.getData("Address");
        String BusinessCity = _dataRepo.getData("City");
        String BusinessState = _dataRepo.getData("State");
        String BusinessZip = _dataRepo.getData("ZipCode");
        String BusinessPhone = Random_NumberGenerator(10);
        String BusinessDescription = "This is a Test Vendor for ABC Company";
        vrp.businessInformation(BusinessCountry, LegalBusinessName, DoingBusinessAs, TypeOfBusiness, ownerShipInfo,
                BusinessSSN, BusinessAddress1, BusinessCity, BusinessState, BusinessZip, BusinessPhone,
                BusinessDescription);
    }

    @Then("^Fill Business Questionnaire$")
    public void Fill_Business_Questionnaire() throws Exception {
        String BusinessRelation = "Cottonwood";
        String ContactPerson = "QC Team";
        vrp.businessQuestionnaire(BusinessRelation, ContactPerson);
    }

    @Then("^Fill Principal Contact Information$")
    public void Fill_Principal_Contact_Information() throws Exception {
        String PrincipalCountry = _dataRepo.getData("Country");
        String PrincipalAddress1 = _dataRepo.getData("Address");
        String PrincipalCity = _dataRepo.getData("City");
        String PrincipalState = _dataRepo.getData("State");
        String PrincipalZipCode = _dataRepo.getData("ZipCode");
        String PrincipalSSN = Random_NumberGenerator(9);
        String PrincipalDOB = "02/10/1993";
        String PrincipalFirstName = LeagalBusinessName;
        String PrincipalLastName = "AutoLastName" + Random_StringGenerator(5);
        String PrincipalTitle = _dataRepo.getData("Title");
        String PrincipalPhone = Random_NumberGenerator(10);
        String PrincipalEmail = _dataRepo.getData("Email");
        vrp.principalContactInformation(PrincipalCountry, PrincipalAddress1, PrincipalCity, PrincipalState,
                PrincipalZipCode, PrincipalSSN, PrincipalDOB, PrincipalFirstName, PrincipalLastName, PrincipalTitle,
                PrincipalPhone, PrincipalEmail);
    }

    @Then("^Fill Billing Contact Information$")
    public void Fill_Billing_Contact_Information() throws Exception {
        String BillingCountry = _dataRepo.getData("Country");
        String BillingAddress1 = _dataRepo.getData("Address");
        String BillingCity = _dataRepo.getData("City");
        String BillingState = _dataRepo.getData("State");
        String BillingZip = _dataRepo.getData("ZipCode");
        String BillingFirstName = "AutoFirstName" + Random_StringGenerator(5);
        String BillingLastName = "AutoLastName" + Random_StringGenerator(5);
        String BillingEmail = _dataRepo.getData("Email");
        vrp.billingContactInformation(BillingCountry, BillingAddress1, BillingCity, BillingState, BillingZip,
                BillingFirstName, BillingLastName, BillingEmail);
    }

    @Then("^Fill Secondary Contact Information$")
    public void Fill_Secondary_Contact_Information() throws Exception {
        String SecondaryFirstName = "AutoFirstName" + Random_StringGenerator(5);
        String SecondaryLastName = "AutoLastName" + Random_StringGenerator(5);
        String SecondaryEmail = _dataRepo.getData("Email");
        String SecondaryPhone = Random_NumberGenerator(10);
        vrp.secondaryContactInformation(SecondaryFirstName, SecondaryLastName, SecondaryEmail, SecondaryPhone);
    }

    @Then("^Fill Previous Conviction Information$")
    public void Fill_Previous_Conviction_Information() throws Exception {
        String value = "This is the Test Vendor for ABC Company";
        vrp.previousConviction(value);
    }

    @Then("^Validate Agreement Vendor Registration$")
    public void Validate_Agreement_Vendor_Registration() throws Exception {
        String CompanyName = _dataRepo.getData("vendorName");
        vrp.agreementPage(CompanyName);
    }

    @Then("^Validate Agreement Vendor Registration Notification$")
    public void Validate_Agreement_Vendor_Registration_Notification() throws Exception {
        String CompanyName = _dataRepo.getData("vendorName");
        vrp.agreementPageNotification(CompanyName);
    }

    @Then("^Verify Personal Information$")
    public void Verify_Personal_Information() throws Exception {
        vrp.verfyPersonalInformation();
    }

    @Then("^Validate Client Order Report Page$")
    public void Validate_Client_Order_Report_Page() throws Exception {
        corp.validateClientOrderReport();
    }

    @Then("^Verify Template Files$")
    public void Verify_Template_Files() throws Exception {
        bps.businessProcessLoad();
    }

    @Then("^Verify People Roaster Batch$")
    public void Verify_People_Roaster_Batch() throws Exception {
        bps.peopleRoasterBatch();
    }

    @Then("^I should see Text Table Row \"([^\"]*)\"$")
    public void I_should_see_Text_Table_Row(String Text) throws Exception {
        verifyTextPresenceTableRow(Text);
    }

    @Then("^I should not see Text Table Row \"([^\"]*)\"$")
    public void I_should_not_see_Text_Table_Row(String Text) throws Exception {
        verifyTextNotPresenceTableRow(Text);
    }

    @And("^I Select Person By Status \"([^\"]*)\"$")
    public void I_Select_The_Person_By_Status(String value) throws Exception {
        clickElementWithWait(By.xpath("(//a[contains(.,'" + value + "')]/../../..//a)[1]"), value);
    }

    @Then("^Calculate the time taken to load \"([^\"]*)\"$")
    public void Calculate_the_time_taken_to_load(String value) throws Exception {
        String Error = "";
        for (int i = 1; i <= 500; i++) {
            wait(1);
            int size = driver.findElements(By.xpath("(//div[.='Loading... Please Wait...'])[last()]")).size();
            if (size == 0) {
                reportLog(Status.PASS, value + " is Loaded in " + i + " Seconds", true);

                if (verifyElementPresence(By.xpath("//div[@class='Caption' and .='Error']"))) {
                    Error = driver
                            .findElement(By.xpath("(//div[@class='Caption' and .='Error']/../../../..//div)[last()-4]"))
                            .getText();
                }

                if (verifyElementPresence(By.xpath("//td[.='OK']"))) {
                    clickElement(By.xpath("//td[.='OK']"), "OK");
                }

                if (value.equalsIgnoreCase("Home Page")) {
                    if (Error.equalsIgnoreCase("")) {
                        HomePage = "" + i;
                    } else {
                        HomePage = Error;
                    }

                } else if (value.equalsIgnoreCase("EA Search")) {
                    if (Error.equalsIgnoreCase("")) {
                        EAsearch = "" + i;
                    } else {
                        EAsearch = Error;
                    }
                } else if (value.equalsIgnoreCase("Case Search")) {
                    if (Error.equalsIgnoreCase("")) {
                        CaseSearch = "" + i;
                    } else {
                        CaseSearch = Error;
                    }
                } else if (value.equalsIgnoreCase("Case Queue")) {
                    if (Error.equalsIgnoreCase("")) {
                        CaseQueue = "" + i;
                    } else {
                        CaseQueue = Error;
                    }
                } else if (value.equalsIgnoreCase("Global Search")) {
                    if (Error.equalsIgnoreCase("")) {
                        GlobalSearch = "" + i;
                    } else {
                        GlobalSearch = Error;
                    }
                } else if (value.equalsIgnoreCase("Ready for Review (NON Circumstance)")) {
                    if (Error.equalsIgnoreCase("")) {
                        NonCircun = "" + i;
                    } else {
                        NonCircun = Error;
                    }
                } else if (value.equalsIgnoreCase("Ready for Review (Circumstance)")) {
                    if (Error.equalsIgnoreCase("")) {
                        Circum = "" + i;
                    } else {
                        Circum = Error;
                    }
                } else if (value.equalsIgnoreCase("Ungraded Manual Review")) {
                    if (Error.equalsIgnoreCase("")) {
                        Manual = "" + i;
                    } else {
                        Manual = Error;
                    }
                }
                break;
            } else if (i == 500) {
                reportLog(Status.FAIL, value + " is not Loaded in " + i + " Seconds", true);
            }
        }

    }

    @Given("^Select \"([^\"]*)\" in \"([^\"]*)\" Tab$")
    public void select_in_Tab(String opt, String tab) throws Exception {
        wal.selectFromEATab(opt, tab);
    }

    @Then("^Send an Email$")
    public void Send_an_Email() throws Exception {
        mail.sendEmail();
    }

    @Then("^Select \"([^\"]*)\" as \"([^\"]*)\"$")
    public void I_Select_Status(String Status, String value) throws Exception {
        if (Status.equalsIgnoreCase("Monitoring Status")) {
            selectDropDown(By.xpath("//select[@name='monitoringStatus']"), value, "Monitoring Status");
        } else if (Status.equalsIgnoreCase("Aim Area")) {
            selectDropDownByIndex(By.xpath("//select[@name='relationsDataID']"), value, Status);
        }
    }

    @Then("^I Do \"([^\"]*)\" Validation for \"([^\"]*)\"$")
    public void I_Do_Validation(String SearchType, String value) throws Exception {
        if (SearchType.equalsIgnoreCase("Vendor Search")) {
            cmv.vendorSearchvalidation(value);
        } else if (SearchType.equalsIgnoreCase("People Search")) {
            cmv.peopleSearchvalidation(value);
        }
    }

    @Then("^Set Billing Preference as \"([^\"]*)\" for \"([^\"]*)\" Customer$")
    public void Set_Billing_Preference(String value, String Customer) throws Exception {
        if (Customer.equalsIgnoreCase("Home Depot")) {
            Customer = "1296";
        } else if (Customer.equalsIgnoreCase("Unigroup")) {
            Customer = "215";
        } else if (Customer.equalsIgnoreCase("Kaiser")) {
            Customer = "1346";
        } else if (Customer.equalsIgnoreCase("Lockeed Martin")) {
            Customer = "14";
        } else if (Customer.equalsIgnoreCase("Aspen")) {
            Customer = "1281";
        } else if (Customer.equalsIgnoreCase("Allpro")) {
            Customer = "13";
        } else if (Customer.equalsIgnoreCase("Amazon")) {
            Customer = "2935";
        }
        databaseClass.setBillingPreference(value, Customer);
    }

    @Then("^Set Billing Preference as \"([^\"]*)\" for \"([^\"]*)\" Vendor$")
    public void Set_Billing_PreferenceVendor(String value, String Vendor) throws Exception {

        databaseClass.setBillingPreferenceVendor(value, Vendor);
    }

    @Then("^Enable Billing Preference as for \"([^\"]*)\" Customer$")
    public void Enable_Billing_Preference(String Customer) throws Exception {
        if (Customer.equalsIgnoreCase("Home Depot")) {
            Customer = "1296";
        } else if (Customer.equalsIgnoreCase("Unigroup")) {
            Customer = "215";
        } else if (Customer.equalsIgnoreCase("Kaiser")) {
            Customer = "1346";
        } else if (Customer.equalsIgnoreCase("Lockeed Martin")) {
            Customer = "14";
        } else if (Customer.equalsIgnoreCase("Aspen")) {
            Customer = "1281";
        } else if (Customer.equalsIgnoreCase("Allpro")) {
            Customer = "13";
        } else if (Customer.equalsIgnoreCase("Amazon")) {
            Customer = "2935";
        }
        databaseClass.enableProgramBillng(Customer);
    }

    @Then("^Delete Billing Preference as for \"([^\"]*)\" Customer$")
    public void Delete_Billing_Preference(String Customer) throws Exception {
        if (Customer.equalsIgnoreCase("Home Depot")) {
            Customer = "1296";
        } else if (Customer.equalsIgnoreCase("Unigroup")) {
            Customer = "215";
        } else if (Customer.equalsIgnoreCase("Kaiser")) {
            Customer = "1346";
        } else if (Customer.equalsIgnoreCase("Lockeed Martin")) {
            Customer = "14";
        } else if (Customer.equalsIgnoreCase("Aspen")) {
            Customer = "1281";
        } else if (Customer.equalsIgnoreCase("Allpro")) {
            Customer = "13";
        } else if (Customer.equalsIgnoreCase("Amazon")) {
            Customer = "2935";
        }
        databaseClass.deleteProgramBillng(Customer);
    }

    @Then("^Update Package$")
    public void update_Package() throws Exception {
        databaseClass.updatePackage();
    }

    @Then("^Update XML$")
    public void Update_XML(DataTable values) throws Exception {

        reportLog(Status.INFO, "***************************^Update XML$***********************************", false);
        List<List<String>> data = values.asLists();
        String xmlPath = "";
        xmlPath = data.get(1).get(0);
        this.xmlPath = xmlPath;
        String Update = data.get(1).get(1);
        if (Update.equalsIgnoreCase("YES")) {
            if (SalesForceID.equalsIgnoreCase("")) {
                String SalesForceID = data.get(1).get(2);
                if (SalesForceID.equalsIgnoreCase("Random")) {
                    String num = Random_NumberGenerator(4);
                    SalesForceID = "QCTEST00A000C0AUT41" + num;
                    this.SalesForceID = SalesForceID;
                } else {
                    this.SalesForceID = SalesForceID;
                }
            }

            if (PayTO.equalsIgnoreCase("")) {
                String PayTO = data.get(1).get(3);
                if (PayTO.equalsIgnoreCase("Random")) {
                    String num = Random_NumberGenerator(2);
                    String txt = Random_StringGenerator(2);
                    PayTO = txt + num;
                    this.PayTO = PayTO;
                } else {
                    this.PayTO = PayTO;
                }
            }
            if (Name.equalsIgnoreCase("")) {
                String Name = data.get(1).get(4);
                if (Name.equalsIgnoreCase("Random")) {
                    String txt = Random_StringGenerator(10);
                    Name = txt;
                    this.Name = Name;
                } else {
                    this.Name = Name;
                }
            }
            if (DBAname.equalsIgnoreCase("")) {
                String DBAname = data.get(1).get(5);
                if (DBAname.equalsIgnoreCase("Random")) {
                    String txt = Random_StringGenerator(10);
                    DBAname = txt;
                    this.DBAname = DBAname;
                } else {
                    this.DBAname = DBAname;
                }
            }
            cxu.commonUpdate(xmlPath, SalesForceID, PayTO, Name, DBAname);
        }
    }

    @Then("^Post the Xchange XML$")
    public void post_the_Xchange_XML() throws Exception {

        reportLog(Status.INFO, "*************************** ^Post the Xchange XML$ ***********************************",
                false);

        String XchangeURL = _dataRepo.getData("XchangeURL");
        String response = "";
        response = wsu.sendPostRequest(XchangeURL, xmlPath);
        ResponseXML = response;
    }

    @Then("^Get orderid from BackGround Report$")
    public void get_orderid_from_BackGround_Report() throws Exception {

        reportLog(Status.INFO, "*********************** ^Get orderid from BackGround Report$ *************************",
                false);
        String OrderIdandURL = "";
        OrderIdandURL = cbr.getOrderandURL(ResponseXML);
//		    OrderIdandURL=OrderIdandURL.replaceAll("qcs.fadv.net", "qxtdforce.fadv.net");
        this.OrderIdandURL = OrderIdandURL;
        driver.get(OrderIdandURL);
    }

    @Then("^Agree and Continue to Registration$")
    public void agree_and_Continue_to_Registration() throws Exception {
        vreg.agreeAndContinue();
    }

    @Then("^Create profile$")
    public void create_profile() throws Exception {
        String UserID = _dataRepo.getData("UserID");
        if (UserID.equalsIgnoreCase("Random")) {
            UserID = "AUTO41" + Random_NumberGenerator(5);
            this.UserID = UserID;
        }
        String Password = _dataRepo.getData("Password");
        this.Password = Password;
        String FirstName = _dataRepo.getData("FirstName");
        if (FirstName.equalsIgnoreCase("Random")) {
            FirstName = Random_StringGenerator(10);
        }
        String LastName = _dataRepo.getData("LastName");
        if (LastName.equalsIgnoreCase("Random")) {
            LastName = Random_StringGenerator(10);
        }
        String Email = _dataRepo.getData("Email");
        String SecurityQTN = _dataRepo.getData("SecurityQTN");
        String Answer = _dataRepo.getData("Answer");

        if (verifyElementPresence(By.xpath("//input[@value='NEXT']"))) {
            clickElement(By.xpath("//input[@value='NEXT']"), "NEXT");
        }
        vreg.createProfile(UserID, Password, FirstName, LastName, Email, SecurityQTN, Answer);
    }

    @Then("^Fill Principle Contact Information$")
    public void fill_Principle_Contact_Information() throws Exception {
        String principalLegalFirstName = _dataRepo.getData("principalLegalFirstName");
        if (principalLegalFirstName.equalsIgnoreCase("Random")) {
            principalLegalFirstName = Random_StringGenerator(10);
            this.principalLegalFirstName = principalLegalFirstName;
        }
        String principalLegalLastName = _dataRepo.getData("principalLegalLastName");
        if (principalLegalLastName.equalsIgnoreCase("Random")) {
            principalLegalLastName = Random_StringGenerator(10);
            this.principalLegalLastName = principalLegalLastName;
        }
        String principalSuffix = _dataRepo.getData("principalSuffix");
        String principalSSN = _dataRepo.getData("principalSSN");
        if (principalSSN.equalsIgnoreCase("Random")) {
            principalSSN = "1" + Random_NumberGenerator(8);
            this.principalSSN = principalSSN;
        }
        String principalDOB = _dataRepo.getData("principalDOB");
        String principalPersonalEmail = _dataRepo.getData("principalPersonalEmail");
        String principalPhone = _dataRepo.getData("principalPhone");
        if (principalPhone.equalsIgnoreCase("Random")) {
            principalPhone = Random_NumberGenerator(10);
        }
        String principalDriverLicense = _dataRepo.getData("principalDriverLicense");
        if (principalDriverLicense.equalsIgnoreCase("Random")) {
            principalDriverLicense = Random_StringGenerator(3) + Random_NumberGenerator(5);
        }
        String principalDriverLicenseState = _dataRepo.getData("principalDriverLicenseState");

        vreg.principalContactInformation(principalLegalFirstName, principalLegalLastName, principalSuffix, principalSSN,
                principalDOB, principalPersonalEmail, principalPhone, principalDriverLicense,
                principalDriverLicenseState);
    }

    @Then("^Fill Principle Current Address$")
    public void fill_Principle_Current_Address() throws Exception {
        String principalCountry = _dataRepo.getData("principalCountry");
        String principalAddress1 = _dataRepo.getData("principalAddress1");
        String principalAddress2 = _dataRepo.getData("principalAddress2");
        String principalCity = _dataRepo.getData("principalCity");
        String principalState = _dataRepo.getData("principalState");
        String principalZipCode = _dataRepo.getData("principalZipCode");
        String principalZipcode2 = _dataRepo.getData("principalZipcode2");
        vreg.principalCurrentAddress(principalCountry, principalAddress1, principalAddress2, principalCity,
                principalState, principalZipCode, principalZipcode2);
    }

    @Then("^Fill Crew Contact Information$")
    public void fill_Crew_Contact_Information() throws Exception {
        String AddCrew = _dataRepo.getData("AddCrew");
        String CrewLegalFirstName = _dataRepo.getData("CrewLegalFirstName");
        if (CrewLegalFirstName.equalsIgnoreCase("Random")) {
            CrewLegalFirstName = Random_StringGenerator(9);
            this.CrewFirstName = CrewLegalFirstName;
        }
        String CrewLegalLastName = _dataRepo.getData("CrewLegalLastName");
        if (CrewLegalLastName.equalsIgnoreCase("Random")) {
            CrewLegalLastName = Random_StringGenerator(9);
            this.CrewLastName = CrewLegalLastName;
        }
        String CrewSufix = _dataRepo.getData("CrewSufix");
        String CrewSSN = _dataRepo.getData("CrewSSN");
        if (CrewSSN.equalsIgnoreCase("Random")) {
            CrewSSN = "1" + Random_NumberGenerator(8);
            this.CrewSSN = CrewSSN;
        }
        String CrewDOB = _dataRepo.getData("CrewDOB");
        String CrewEmailID = _dataRepo.getData("CrewEmailID");
        String CrewType = _dataRepo.getData("CrewType");
        vreg.CrewContactInformation(AddCrew, CrewLegalFirstName, CrewLegalLastName, CrewSufix, CrewSSN, CrewDOB,
                CrewEmailID, CrewType);
    }

    @Then("^Fill Crew Current Address$")
    public void fill_Crew_Current_Address() throws Exception {
        String CrewCountry = _dataRepo.getData("CrewCountry");
        String CrewAddress1 = _dataRepo.getData("CrewAddress1");
        String CrewAddress2 = _dataRepo.getData("CrewAddress2");
        String CrewCity = _dataRepo.getData("CrewCity");
        String CrewState = _dataRepo.getData("CrewState");
        String CrewZipCode = _dataRepo.getData("CrewZipCode");
        String CrewZipcode2 = _dataRepo.getData("CrewZipcode2");
        String Save = _dataRepo.getData("Save");
        vreg.CrewCurrentAddress(CrewCountry, CrewAddress1, CrewAddress2, CrewCity, CrewState, CrewZipCode, CrewZipcode2,
                Save);
    }

    @Then("^Submit Registration$")
    public void submit_Registration() throws Exception {
        vreg.submit();
    }

    @Then("^Verify Vendor Thank you Page$")
    public void Verify_Vendor_Thank_you_Page() throws Exception {
        vty.verifyThankyouPage(UserID, principalLegalFirstName, principalLegalLastName, CrewFirstName, CrewLastName);
    }

    @Then("^Update XML NONHD$")
    public void Update_XML_NONHD(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();
        this.xmlPath = data.get(1).get(0);
        String Comanyname = Random_StringGenerator(8);
        String Username = Random_StringGenerator(8);
        cxu.commonUpdateNONHD(xmlPath, Comanyname, Username);
    }

    @Then("^Set Billing Preference as \"([^\"]*)\" for \"([^\"]*)\" Vendor Using Operational User$")
    public void Set_Billing_PreferenceVendor_Using_Operational_User(String value, String Vendor) throws Exception {
        svp.setPreference(Vendor, value);
    }

    @Then("^Get Email Body and Subject for Process Name \"([^\"]*)\" and TO Email \"([^\"]*)\" for \"([^\"]*)\"$")
    public void get_Email_Body_and_Subject_for_Process_Name_and_TO_Email_for(String processName, String Email,
                                                                             String vendorType) throws Exception {
        if (vendorType.contains("Newly Registered Vendor")) {
            databaseClass.getEmailBodySubject(processName, Email);
        } else if (vendorType.contains("Confirm Registration")) {
            databaseClass.getEmailBodySubjectConfirmRegistration(processName, Email);
        }

    }

    @Then("^verify \"([^\"]*)\" present in Notification \"([^\"]*)\" for \"([^\"]*)\"$")
    public void verify_present_in_Notification_Email(String Expected, String Actual, String vendorType)
            throws Exception {
        if (vendorType.equalsIgnoreCase("Newly Registered Vendor")) {
            if (Expected.equalsIgnoreCase("Vendor Name") && !(Actual.contains("Subject"))) {
                Expected = ": " + VendorNameNonHD + " " + VendorLastNameNonHD + "";
            } else if (Expected.equalsIgnoreCase("Vendor ID")) {
                Expected = "Vendor Id : " + VendorID;
            } else if (Expected.equalsIgnoreCase("Email")) {
                Expected = "Email : " + _dataRepo.getData("Email");
            } else if (Expected.equalsIgnoreCase("Lockeed Martin")) {
                Expected = VendorNameNonHD + " has registered on the LOCKHEED MARTIN XtdForce website.";
            } else if (Expected.equalsIgnoreCase("Vendor Name") && Actual.contains("Subject")) {
                Expected = "XtdForceï¿½ -" + VendorNameNonHD + "- Newly Registered Vendor Account.";
            }

            if (Actual.equalsIgnoreCase("Email")) {
                Actual = NotificationEmail;
            } else if (Actual.equalsIgnoreCase("Subject")) {
                Actual = NotificationSubject;
            }
        } else if (vendorType.equalsIgnoreCase("Confirm Registration")) {
            if (Expected.equalsIgnoreCase("Vendor Name") && !(Actual.contains("Subject"))) {
                Expected = "Dear " + VendorNameNonHD + " " + VendorLastNameNonHD + "";
            } else if (Expected.equalsIgnoreCase("Invoice")) {
                Expected = "You will be Invoiced for : $300.00.";
            } else if (Expected.equalsIgnoreCase("Lockeed Martin")) {
                Expected = "Thank you for registering on LOCKHEED MARTIN's XtdForce website.";
            }

            if (Actual.equalsIgnoreCase("Email")) {
                Actual = NotificationEmail;
            } else if (Actual.equalsIgnoreCase("Subject")) {
                Actual = NotificationSubject;
            }
        }

        verifyStringContainsText(Actual, Expected);
    }

    @Then("^Get Agreement text from DB and store to file$")
    public void get_Agreement_text_from_DB_and_store_to_file() throws Exception {
        String Agreement = databaseClass.getAgreementText();
        AgreementfilePath = System.getProperty("user.dir") + PropertyFileReader.getProperty("Agreement.path");
        System.out.println(AgreementfilePath);
        new WriteFile().write(Agreement, AgreementfilePath);
    }

    @Then("^Check the configuration of Notification and Configure$")
    public void Check_the_configuration_of_Notification_and_Configure() throws Exception {
        nc.checkProfileConfig();
    }

    @Then("^I Get Person Status Detail$")
    public void I_Get_Person_Status_Detail() throws Exception {
        nc.getPersonDetail();
    }

    @Then("^Store Notifications Data to DB$")
    public void Store_Notifications_Data_to_DB() throws Exception {
        databaseClass.saveNotification();
    }

    @Then("^Get Notification Data From DB$")
    public void get_Notification_Data_From_DB() throws Exception {
        databaseClass.getNotificationData();
    }

    @Then("^verify Compliance table$")
    public void verify_Compliance_table() throws Exception {
        databaseClass.verifyComplianceTable();
    }

    @Then("^verify Email log table$")
    public void verify_Email_log_table() throws Exception {
        String Emaillog = databaseClass.getEmaillog();
        if (!(scenarioName.contains("NO-Notification") && Emaillog.equalsIgnoreCase(""))) {
            EmaillogfilePath = System.getProperty("user.dir") + PropertyFileReader.getProperty("Emaillog.path");
            System.out.println(EmaillogfilePath);
            new WriteFile().write(Emaillog, EmaillogfilePath);
        } else if (scenarioName.contains("NO-Notification") && !(Emaillog.equalsIgnoreCase(""))) {
            reportLog(Status.FAIL, "Notification is Present", false);
        }
    }

    @Then("^verify Order Confirmation CLOB$")
    public void verify_Order_Confirmation_clob(DataTable values) throws Exception {
        EmailBody = databaseClass.getOrderConfirmationClob();
        if (!(scenarioName.contains("NO-Notification") && EmailBody.equalsIgnoreCase(""))) {
            List<List<String>> data = values.asLists();
            String Sponsor = data.get(1).get(0);
            String Vendor = data.get(1).get(1);
            String Package = data.get(1).get(2);
            String Total = data.get(1).get(3);
            String PaymentMethod = data.get(1).get(4);

            nc.verifyOrderConfirmationMail(Sponsor, Vendor, Package, Total, PaymentMethod);
        } else if (scenarioName.contains("NO-Notification") && !(EmailBody.equalsIgnoreCase(""))) {
            reportLog(Status.FAIL, "Notification is Present", false);
        }
    }

    @Then("^verify reset password CLOB$")
    public void verify_reset_password_clob() throws Exception {
        EmailBody = databaseClass.getResetPasswordClob();
        nc.verifyResetPasswordCLOB();
    }

    @Then("^verify Principal Change CLOB$")
    public void verify_Principal_change_clob() throws Exception {
        EmailBody = databaseClass.getPrincipalClob();
        if (!(scenarioName.contains("NO-Notification") && EmailBody.equalsIgnoreCase(""))) {
            nc.verifyPrincipalChangeCLOB();
        } else if (scenarioName.contains("NO-Notification") && !(EmailBody.equalsIgnoreCase(""))) {
            reportLog(Status.FAIL, "Notification is Present", false);
        }
    }

    @Then("^Verify Digital Badge CLOB$")
    public void verify_Digital_Badge_clob() throws Exception {
        if (!(scenarioName.contains("NO-Notification") && EmailBody.equalsIgnoreCase(""))) {
            nc.verifyDigitalBagdeCLOB();
        } else if (scenarioName.contains("NO-Notification") && !(EmailBody.equalsIgnoreCase(""))) {
            reportLog(Status.FAIL, "Notification is Present", false);
        }
    }

    @Then("^Get PA Invite Link from OrderID$")
    public void Get_PA_Invite_Link_from_OrderID() throws Exception {
        databaseClass.getOrderOutputLog();
        cbr.getApplicantLinkAPI();
    }

    @Then("^Wait until Element Present \"([^\"]*)\"$")
    public void Wait_until_Element_Present(String value) throws Exception {
        List<WebElement> Element = null;
        for (int i = 1; i <= 300; i++) {
            wait(1);
            if (value.equalsIgnoreCase("Sign Up Page")) {
                Element = driver.findElements(By.xpath("//a[.='Sign in']"));
            } else if (value.equalsIgnoreCase("Sign In Page")) {
                Element = driver.findElements(By.xpath("//*[@id='loginInputPwd' or @id='inputSetPwd']"));
            } else if (value.equalsIgnoreCase("Country Page")) {
                Element = driver.findElements(
                        By.xpath("//h2[contains(.,'Please provide your current country of residence.')]"));
            } else if (value.equalsIgnoreCase("Country Page-test")) {
                Element = driver.findElements(
                        By.xpath("//h2[contains(.,'We need to capture 7 full year(s) of your address history.')]"));
            } else if (value.equalsIgnoreCase("ESign Page")) {
                Element = driver.findElements(By.xpath("//h4[contains(.,'simple electronic signature')]"));
            } else if (value.equalsIgnoreCase("Notice Page")) {
                Element = driver.findElements(
                        By.xpath("//b[contains(.,'Welcome, to begin your process we need you consent.')]"));
            } else if (value.equalsIgnoreCase("Notice Page UAT")) {
                Element = driver.findElements(By.xpath(
                        "//strong[contains(.,'NON-FAIR CREDIT REPORTING ACT ACKNOWLEDGMENTS AND AUTHORIZATIONS FOR BACKGROUND CHECK')]"));
            } else if (value.equalsIgnoreCase("FCRA Notice")) {
                Element = driver
                        .findElements(By.xpath("//strong[contains(.,'FCRA NOTICE REGARDING BACKGROUND VESTIGATION')]"));
            } else if (value.equalsIgnoreCase("Authorization Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'Authorization')]"));
            } else if (value.equalsIgnoreCase("Consent Page UAT")) {
                Element = driver.findElements(By.xpath(
                        "//strong[contains(.,'CALIFORNIA DISCLOSURE REGARDING INVESTIGATIVE CONSUMER REPORTS')]"));
            } else if (value.equalsIgnoreCase("Agreement Page")) {
                Element = driver.findElements(
                        By.xpath("//strong[contains(.,'FAIR CREDIT REPORTING ACT DISCLOSURE AND AUTHORIZATION')]"));
            } else if (value.equalsIgnoreCase("Profile Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'your identification')]"));

            } else if (value.equalsIgnoreCase("Profile Decline Page")) {
                Element = driver.findElements(By.xpath("//h3[contains(.,'YOUR PROFILE DATA')]"));

            } else if (value.equalsIgnoreCase("Residence Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'your address history')]"));
            } else if (value.equalsIgnoreCase("Current Residence Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'Where do you currently reside/stay?')]"));
            } else if (value.equalsIgnoreCase("Employment Page")) {
                Element = driver.findElements(By.xpath(
                        "//h2[contains(.,', do you have any employment information you would like to provide?')]"));
            } else if (value.equalsIgnoreCase("Education Page")) {
                Element = driver
                        .findElements(By.xpath("//h2[contains(.,', please provide your recent education details.')]"));
            } else if (value.equalsIgnoreCase("License Page")) {
                Element = driver.findElements(By.xpath("//h4[contains(.,'valid driver license')]"));
            } else if (value.equalsIgnoreCase("Identity Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'to your identification')]"));
            } else if (value.equalsIgnoreCase("Criminal Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'convicted of a crime')]"));
            } else if (value.equalsIgnoreCase("Additional Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'some additional information from you')]"));
            } else if (value.equalsIgnoreCase("AdditionalInfomartion Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'on the next section, please review and make any final edits to your information.')]"));
//                Element = driver.findElements(By.xpath("//h2[contains(.,'At least one of the searches we have been engaged to perform requires you to provide the information requested below. For example, gender may be required to be specified.')]"));
            } else if (value.equalsIgnoreCase("Review Page")) {
                Element = driver.findElements(By.xpath("//h2[contains(.,'Please review the information')]"));
            } else if (value.equalsIgnoreCase("DocumentUpload Page")) {
                Element = driver.findElements(By.xpath("(//button[contains(text(),'NEXT')])[2]"));
            } else if (value.equalsIgnoreCase("ProfileDashboard Page")) {
                Element = driver.findElements(By.xpath("//h5 [contains(.,'welcome to your profile dashboard')]"));
            } else if (value.equalsIgnoreCase("No modal")) {
                Element = driver.findElements(By.xpath("//div[@style='display: none;' and @class='modal fade']"));
            } else if (value.equalsIgnoreCase("Outlook Home Page")) {
                Element = driver.findElements(By.xpath("//*[@id=\"O365_AppName\"]/span"));
            } else if (value.equalsIgnoreCase("Unread email Password Reset")) {
                value = value.replaceAll("Unread email ", "");
                Element = driver.findElements(By.xpath("(//div[contains(@aria-label,'Unread')]//span[contains(text(),'" + value + "')])[1]"));
            } else if (value.equalsIgnoreCase("Business Signature")) {
                Element = driver.findElements(By.xpath("//*[contains(text(),'FIRST ADVANTAGE ENTERPRISE SCREENING CORPORATION')]7"));
            } else if (value.equalsIgnoreCase("View Profile")) {
                Element = driver.findElements(By.xpath("//div[@class= 'border-green pre-assessment b-shadow']"));
            }
            int size = Element.size();
            if (size > 0) {
                reportLog(Status.PASS, value + " is loaded in " + i + " Seconds", true);
                break;
            } else if (i == 300) {
                reportLog(Status.FAIL, value + " is not loaded in " + i + " Seconds", true);
            }
        }
    }

    @Then("^I open only a new tab$")
    public void OnlyNewTab() throws Exception {
//      String parent=driver.getWindowHandle();
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_T);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_T);
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com/','_blank');");
    }

    @Then("^I switch between tabs \"([^\"]*)\"$")
    public void switchTab(String value) throws Exception {
//      String parent=driver.getWindowHandle();
        wait(4);
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(driver.getWindowHandles());

//      System.out.println(list.get(1).toString());

        String parent = list.get(0).toString();
        String child = list.get(1).toString();

        if (value.equalsIgnoreCase("parent")) {
            driver.switchTo().window(parent);
        } else if (value.equalsIgnoreCase("child")) {
            driver.switchTo().window(child);
        }

    }

    @Then("^I close open tabs \"([^\"]*)\"$")
    public void closeOpenTab(String value) throws Exception {
//      String parent=driver.getWindowHandle();
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(driver.getWindowHandles());
        System.out.println(list.get(1).toString());
        String parent = list.get(0).toString();
        String child = list.get(1).toString();

        if (value.equalsIgnoreCase("parent")) {
            driver.switchTo().window(parent);
            driver.close();
            driver.switchTo().window(child);
        } else if (value.equalsIgnoreCase("child")) {
            driver.switchTo().window(child);
            driver.close();
            driver.switchTo().window(parent);
        }

    }

    @Then("^Verify Person Information in Person Status Detail Page$")
    public void Verify_Person_Information_in_Person_Status_Detail_Page() throws Exception {
        vpsdp.verify();
    }

    @Then("^Get OrderRefID$")
    public void Get_OrderRefID() throws Exception {
        databaseClass.getOrderRefId();
    }

    @Then("^Verify Quoteback Value for \"([^\"]*)\"$")
    public void verify_Quoteback_Value_For(String value) throws Exception {
        if (value.equalsIgnoreCase("OrderId")) {
            String qBValueXls = _dataRepo.getData("QuotebackValue1");
            String received = databaseClass.verifyQuotebackValue(value);
            if (qBValueXls.equalsIgnoreCase(received)) {
                reportLog(Status.PASS, "Quoteback Value is Present for : " + OrderID + " & " + value, false);

            } else if (received.equalsIgnoreCase("Empty")) {
                reportLog(Status.PASS, "Quoteback Value is Not Present for : " + OrderID + " & " + value, false);

            } else {
                reportLog(Status.FAIL, "Quoteback Value is Not Matching for : " + OrderID + " & " + value, false);
            }
        } else if (value.equalsIgnoreCase("ClientId")) {
            String qBValueXls = _dataRepo.getData("QuotebackValue2");
            String received = databaseClass.verifyQuotebackValue(value);
            if (qBValueXls.equalsIgnoreCase(received)) {
                reportLog(Status.PASS, "Quoteback Value is Present for : " + OrderID + " & " + value, false);

            } else {
                reportLog(Status.FAIL, "Quoteback Value is Not Matching for : " + OrderID + " & " + value, false);
            }
        } else if (value.equalsIgnoreCase("TransactionId")) {
            String qBValueXls = _dataRepo.getData("QuotebackValue3");
            String received = databaseClass.verifyQuotebackValue(value);
            if (qBValueXls.equalsIgnoreCase(received)) {
                reportLog(Status.PASS, "Quoteback Value is Present for : " + OrderID + " & " + value, false);

            } else {
                reportLog(Status.FAIL, "Quoteback Value is Not Matching for : " + OrderID + " & " + value, false);
            }
        }
    }

    @Then("^Set Position Hire Property Dynamic$")
    public void Set_Position_Hire_Property_Dynamic(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String value = data.get(1).get(0);
        String custId = data.get(1).get(1);
        databaseClass.updatePositionLocationDynamic(value, custId);
    }

    /**
     * @author gerguran
     * @category updated for NewUI
     **/

    @Then("^wait Until Profile Status is \"([^\"]*)\" for \"([^\"]*)\"$")
    public void wait_Until_Profile_Status_is(String value, String input) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        for (int i = 1; i <= 40; i++) {
            wait(5);
            driver.navigate().refresh();

            if (input.contains("Changed FML in PA")) {
                EnterText(nuiAdministrationPage.firstNameText, "enter search by ", pANewFirstName);
                EnterText(nuiAdministrationPage.lastNameText, "enter search by ", pANewLastName);
            } else {
                EnterText(nuiAdministrationPage.firstNameText, "enter search by ", existingFirstName);
                EnterText(nuiAdministrationPage.lastNameText, "enter search by ", existingLastName);
            }

            clickElementWithWait(nuiPeoplePage.serachButton, "Search button for searching user");
            clickOnAccordionJS();
//            By accordion=By.cssSelector("#panel-0 > td.table-arrow-container");
//            clickOnElementUsingActions(accordion,"accoridon clicked");

            By xpathActualStatus = By.xpath("(//div[contains(@style,'background-color')]//div[contains(text(),'" + value + "')])[1]");
            wait(3);
            String ActualStatus = driver.findElement(xpathActualStatus).getText();

            if (ActualStatus.equalsIgnoreCase(value)) {
                reportLog(Status.PASS, "Profile Status is " + ActualStatus + " in " + i * 20 + " Seconds", true);
                break;
            } else if (i == 40) {
                reportLog(Status.FAIL, "Profile Status is " + ActualStatus + " in " + i * 20 + " Seconds", true);
            }
        }

    }

    @Then("^Set Xtdforce Api Program Property$")
    public void Set_Xtdforce_Api_Program(DataTable values) throws Exception {
        List<List<String>> data = values.asLists();
        String value = data.get(1).get(0);
        String custId = data.get(1).get(1);
        databaseClass.updatePositionLocationDynamic(value, custId);
    }

    @When("^I fill details in PA \"([^\"]*)\" page$")
    public void fillDetailsPaPage(String pageName) throws Exception {
        if (pageName.equalsIgnoreCase("SignUp")) {
            CrTPassword = _dataRepo.getData("PAPassword");
            SecretQuestion = _dataRepo.getData("PASecretQuestion");
            SecretAnswer = _dataRepo.getData("secretAnswer");
            pal.logintoPAApplication(CrTPassword, SecretQuestion, SecretAnswer);

        } else if (pageName.equalsIgnoreCase("SignUp-UAT")) {
            CrTPassword = _dataRepo.getData("PAPassword");
            SecretQuestion = _dataRepo.getData("PASecretQuestion");
            SecretAnswer = _dataRepo.getData("secretAnswer");
            pal.logintoPAApplicationUAT(CrTPassword, SecretQuestion, SecretAnswer);

        } else if (pageName.equalsIgnoreCase("SignIn")) {
            CrTPassword = _dataRepo.getData("PAPassword");
            pal.signInIntoPAApplication(CrTPassword);

        } else if (pageName.equalsIgnoreCase("Country")) {
            countryPA = _dataRepo.getData("PACountry");
            pac.enterPACountry(countryPA);

        } else if (pageName.equalsIgnoreCase("ESign")) {
            pae.clickESignButton();

        } else if (pageName.equalsIgnoreCase("Notice-QC")) {
            pan.clickConsentButtonQC();

        } else if (pageName.equalsIgnoreCase("Notice-UAT1")) {
            pan.clickConsentButtonUAT1();

        } else if (pageName.equalsIgnoreCase("Notice-PROD&CT")) {
            pan.clickConsentButtonPROD();

        } else if (pageName.equalsIgnoreCase("NoticeDecline-PROD&CT")) {
            pan.clickConsentRejectButtonPROD();

        } else if (pageName.equalsIgnoreCase("Consent-UAT")) {
            pan.clickConsentButtonUAT2();

        } else if (pageName.equalsIgnoreCase("Agreement-UAT")) {
            pan.clickAgreeButtonUAT();

        } else if (pageName.equalsIgnoreCase("NoticeDecline")) {
            pan.clickConsentRejectButton();

        } else if (pageName.equalsIgnoreCase("NoticeDeclineUAT")) {
            pan.clickConsentRejectButtonUAT();

        } else if (pageName.equalsIgnoreCase("Profile")) {
            paDOB = _dataRepo.getData("DOB");
            String profileDob = paDOB.replace("/", "");
            pap.enterProfileSection(profileDob);

        } else if (pageName.equalsIgnoreCase("Profile-WithChanges")) {
            paDOB = _dataRepo.getData("DOB");
            pANewFirstName = _dataRepo.getData("PA_FirstName") + Random_StringGenerator(3);
            pANewLastName = _dataRepo.getData("PA_LastName") + Random_StringGenerator(3);
            pANewMiddleName = _dataRepo.getData("PA_MiddleName") + Random_StringGenerator(3);
            String profileDob = paDOB.replace("/", "");
            pap.enterProfileWithChanges(profileDob, pANewFirstName, pANewLastName, pANewMiddleName);

        } else if (pageName.equalsIgnoreCase("Residence")) {
//			test
//			paDOB = _dataRepo.getData("DOB");
//			test
            paAddress1 = _dataRepo.getData("Address");
            paZipCode = _dataRepo.getData("ZipCode");
            paState = _dataRepo.getData("State");
            paCity = _dataRepo.getData("City");
            String startMonth = paDOB.substring(0, 2);
            String startYear = paDOB.substring(6);
            par.enterResidenceSection(paAddress1, paZipCode, paState, paCity, startMonth, startYear);

        } else if (pageName.equalsIgnoreCase("Residence-UAT")) {
            paAddress1 = _dataRepo.getData("Address");
            paZipCode = _dataRepo.getData("ZipCode");
            paState = _dataRepo.getData("State");
            paCity = _dataRepo.getData("City");
            String startMonth = paDOB.substring(0, 2);
            String startYear = paDOB.substring(6);
            par.enterResidenceSectionUAT(paAddress1, paZipCode, paState, paCity, startMonth, startYear);

        } else if (pageName.equalsIgnoreCase("Employment")) {
//			test
//			paDOB = _dataRepo.getData("DOB");
//			countryPA = _dataRepo.getData("PACountry");
//			test
            paDate = _dataRepo.getData("GraduateEmployment Date");
            String employmentInfo = _dataRepo.getData("EmploymentInfo");
            String employerName = _dataRepo.getData("Employer");
            String startMonth = paDate.substring(0, 2);
            String startYear = paDate.substring(6);
            String jobTitle = _dataRepo.getData("JobTitle");
            paem.enterEmploymentSection(employmentInfo, paState, paCity, employerName, startMonth, startYear, jobTitle);

        } else if (pageName.equalsIgnoreCase("Education")) {

            // paDate = _dataRepo.getData("GraduateEmployment Date");
            // paDOB = _dataRepo.getData("DOB");
            // countryPA = _dataRepo.getData("PACountry");
            // paState = _dataRepo.getData("State");
            // paCity = _dataRepo.getData("City");

            String educationType = _dataRepo.getData("EducationType");
            String institutionName = _dataRepo.getData("InstitutionName");
            String endMonth = paDate.substring(0, 2);
            String endYear = paDate.substring(6);
            String degreeType = _dataRepo.getData("DegreeType");
            String startMonth = "9";
            String startYear = String.valueOf(Integer.valueOf(paDOB.substring(6)) + 18);
            String fieldOfStudy = _dataRepo.getData("FieldOfStudy");
            paed.enterEducationSection(educationType, paState, paCity, institutionName, endMonth, endYear, degreeType,
                    startMonth, startYear, fieldOfStudy);

        } else if (pageName.equalsIgnoreCase("License")) {
            String licenseNumb = Random_NumberGenerator(9);
            pali.enterLicenseSection(countryPA, paState, licenseNumb);


        } else if (pageName.equalsIgnoreCase("License-UAT")) {
            String licenseNumb = Random_NumberGenerator(9);
            pali.enterLicenseSectionUAT(countryPA, paState, licenseNumb);

//        } else if (pageName.equalsIgnoreCase("Identity-DT")) {
//            String SSNPrefix = _dataRepo.getData("SSN");
//            pai.enterIdentitySection(SSNPrefix);
        } else if (pageName.equalsIgnoreCase("Identity")) {
            pai.enterIdentitySection();

        } else if (pageName.equalsIgnoreCase("Criminal")) {
            paci.enterCriminalSection();

        } else if (pageName.equalsIgnoreCase("Additional")) {
            paa.enterAdditionalSection();

        } else if (pageName.equalsIgnoreCase("AdditionalInfomartion")) {
            paad.enterAdditionalInformationSection();

        } else if (pageName.equalsIgnoreCase("AdditionalInfomartion-UAT")) {
            paad.enterAdditionalInformationSectionUAT();

        } else if (pageName.equalsIgnoreCase("Review")) {
            pare.enterReviewSection();

        } else if (pageName.equalsIgnoreCase("DocumentUpload")) {
            pad.enterDocumUploadSection();

        } else if (pageName.equalsIgnoreCase("DocumentUpload-DT")) {
            pad.enterDocumUploadSectionDT();
        } else {
            System.out.println("Invalid page Name Entered!!!!");
        }
    }

    /**
     * @author Krishnit
     * @category Opens a new tab
     * @description Opens a new tab and closes the parent tab.
     **/
    @Then("^I open a new tab$")
    public void newTab() throws Exception {
        String parent = driver.getWindowHandle();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        wait(5);
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(driver.getWindowHandles());
        System.out.println(list.get(1).toString());
        String child = list.get(1).toString();
        driver.switchTo().window(child);
        driver.switchTo().window(parent);
        driver.close();
        driver.switchTo().window(child);
    }

    @Then("^Update CheckBadgeOrderStatusEx xml$")
    public void Update_Check_Badge_Order_Status_Ex_xml(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String companyId = data.get(1).get(1);
        String orderId = data.get(1).get(2);

        if (companyId.equalsIgnoreCase("YES")) {
            companyId = "21509";
        }

        if (companyId.equalsIgnoreCase("NO")) {
            companyId = Random_NumberGenerator(6);
        }

        if (orderId.equalsIgnoreCase("YES")) {
            orderId = OrderID;
        }

        if (orderId.equalsIgnoreCase("NO")) {
            orderId = Random_NumberGenerator(7);
            OrderID = orderId;
        }

        cxu.checkBadgeOrderStatusEx(xmlPath, companyId, orderId);
    }

    @Then("^Verify text \"([^\"]*)\" from Response As \"([^\"]*)\"$")
    public void verify_response_text(String text, String reportText) throws Exception {
        if (text.equalsIgnoreCase("OrderIdRandom")) {
            if (scenarioName.contains("BadgeOrder")) {
                if (bDS == 2) {// To verify whether digital badge enabled for checking badge status.
                    databaseClass.getDigitalBadgeEnableDisabled();
                }
                text = "<OrderId>" + OrderID + "</OrderId>";
                bDS++;
            } else {
                text = "<OrderId>" + OrderID + "</OrderId>";
            }

        }
        if (text.equalsIgnoreCase("BadgeStatusRandom")) {
            text = "<BadgeStatus>" + sendBadgeStatus + "</BadgeStatus>";
        }
        if (text.equalsIgnoreCase("BadgeNBRandom")) {
            databaseClass.getBadgeNumber();
            text = "<BadgeNumber>" + BadgeNumber + "</BadgeNumber>";
        }
        if (text.equalsIgnoreCase("PeopleIdRandom")) {
            text = "Person details Not found for People Id  " + PeopleID;
        }

        if (ResponseXML.contains(text)) {
            logStepInfo("Successfully Verified the Expected response :" + " " + reportText);
            reportLog(Status.PASS, "Successfully Verified the Expected response : " + reportText, false);
        } else {
            logStepInfo("The Expected Response is not Present :" + " " + reportText);
            reportLog(Status.FAIL, "The Expected Response is not Present :" + " " + reportText, false);
        }
    }

    @Then("^Update BadgeOrder xml$")
    public void Update_Badge_Order_xml(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String companyId = data.get(1).get(1);
        String orderId = data.get(1).get(2);
        String peopleId = data.get(1).get(3);

        if (companyId.equalsIgnoreCase("YES")) {
            companyId = "21509";
        }

        if (companyId.equalsIgnoreCase("NO")) {
            companyId = Random_NumberGenerator(6);
        }

        if (orderId.equalsIgnoreCase("YES")) {
            orderId = OrderID;
        }

        if (orderId.equalsIgnoreCase("NO")) {
            orderId = Random_NumberGenerator(7);
            OrderID = orderId;
        }

        if (peopleId.equalsIgnoreCase("YES")) {
            PeopleID = up.getPeopleID();
            peopleId = PeopleID;
        }

        if (peopleId.equalsIgnoreCase("NO")) {
            peopleId = Random_NumberGenerator(6);
            PeopleID = peopleId;
        }

        cxu.badgeOrder(xmlPath, companyId, orderId, peopleId);

    }

    @Then("^Update OrderReplacemnetBadge xml$")
    public void Update_Order_Replacement_Badge_xml(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String companyId = data.get(1).get(1);
        String orderId = data.get(1).get(2);
        String peopleId = data.get(1).get(3);

        if (companyId.equalsIgnoreCase("YES")) {
            companyId = "21509";
        }

        if (companyId.equalsIgnoreCase("NO")) {
            companyId = Random_NumberGenerator(6);
        }

        if (orderId.equalsIgnoreCase("YES")) {
            orderId = OrderID;
        }

        if (orderId.equalsIgnoreCase("NO")) {
            orderId = Random_NumberGenerator(7);
            OrderID = orderId;
        }

        if (peopleId.equalsIgnoreCase("YES")) {
            PeopleID = up.getPeopleID();
            peopleId = PeopleID;
        }

        if (peopleId.equalsIgnoreCase("NO")) {
            peopleId = Random_NumberGenerator(6);
            PeopleID = peopleId;
        }

        cxu.orderReplacemnetBadge(xmlPath, companyId, orderId, peopleId);

    }

    @Then("^Insert Promocode to DB$")
    public void Insert_Promocode_to_DB() throws Exception {
        databaseClass.setPromocode();
    }

    @Then("^Update PA Order xml$")
    public void Update_PA_Order_xml(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String FirstName = data.get(1).get(1);
        String LastName = data.get(1).get(2);
        String DateOfBirth = data.get(1).get(3);
        String EmailAddress = data.get(1).get(4);
        String GovernmentId = data.get(1).get(5);
        String PositionLocation = data.get(1).get(6);
        String PosLocCity = data.get(1).get(7);
        String SSNFlag = data.get(1).get(8);
        String NameType = data.get(1).get(9);
        String Address1 = data.get(1).get(10);
        String City = data.get(1).get(11);
        String State = data.get(1).get(12);
        String Zipcode = data.get(1).get(13);
        String CountryCode = "";
        String Region = "";
        String Municipality = "";
        String SSNProvided = "";

        if (FirstName.equalsIgnoreCase("YES")) {
            FirstName = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
            existingFirstName = FirstName;
        }

        if (LastName.equalsIgnoreCase("YES")) {
            LastName = _dataRepo.getData("LastName") + Random_StringGenerator(8);
            existingLastName = LastName;
        }

        if (DateOfBirth.equalsIgnoreCase("YES")) {
            DateOfBirth = _dataRepo.getData("DOB");
            if (scenarioName.contains("BGD")) {
                paDOB = DateOfBirth;
                String day = DateOfBirth.substring(0, 2);
                String month = DateOfBirth.substring(3, 5);
                String year = DateOfBirth.substring(6);
                DateOfBirth = year + "-" + month + "-" + day;
            }
        }

        if (EmailAddress.equalsIgnoreCase("YES")) {
            EmailAddress = Random_StringGenerator(7) + "@mailinator.com";
            EmailID = EmailAddress;

        }

        if (GovernmentId.equalsIgnoreCase("YES")) {
            GovernmentId = CurrentDateTime.SystemDateYear() + Random_NumberGenerator(5);
            SSN = GovernmentId;
        }

        if (PositionLocation.equalsIgnoreCase("YES")) {
            CountryCode = _dataRepo.getData("CountryCode");
            Region = _dataRepo.getData("StateSF");
            Municipality = _dataRepo.getData("PACity");
            paCountryCode = CountryCode;
            paRegion = Region;
            paMunicipality = Municipality;
        }

        if (PositionLocation.equalsIgnoreCase("YN")) {
            CountryCode = _dataRepo.getData("CountryCode");
            Region = _dataRepo.getData("StateSF");
            Municipality = PosLocCity;
        }

        if (PositionLocation.equalsIgnoreCase("YNB")) {
            CountryCode = _dataRepo.getData("CountryCode");
            Municipality = _dataRepo.getData("PACity");
        }

        if (scenarioName.contains("BGD")) {

            if (SSNFlag.equalsIgnoreCase("Y")) {
                SSNProvided = SSNFlag;
            }

            if (SSNFlag.equalsIgnoreCase("N")) {
                SSNProvided = SSNFlag;
            }
            if (Address1.equalsIgnoreCase("YES")) {
                paAddress1 = _dataRepo.getData("Address");

            }

            if (City.equalsIgnoreCase("YES")) {
                paCity = _dataRepo.getData("City");

            }

            if (State.equalsIgnoreCase("YES")) {
                paState = _dataRepo.getData("StateSF");

            }

            if (Zipcode.equalsIgnoreCase("YES")) {
                paZipCode = _dataRepo.getData("ZipCode");

            }
            if (countryPA == null) {
                countryPA = _dataRepo.getData("Country");
            }
        }
        cxu.PABGApiOrder(xmlPath, FirstName, LastName, DateOfBirth, EmailAddress, GovernmentId, CountryCode, Region,
                Municipality, SSNProvided, NameType, paAddress1, paCity, paState, paZipCode);

    }

    @Then("^Get the OrderID From Response xml$")
    public void Get_the_OrderID_From_Response_xml() throws Exception {
        cbr.getAPIorderID();
    }

    /**
     * @author hafizimo
     * @category get Data from xlsx
     ***/

    @And("^I should see Customer support \"([^\"]*)\" in the header$")
    public void i_should_see_customer_support_number_in_the_header(String Contact) throws Throwable {
        verifylogo.VerifyCustomerNumber();
        verifylogo.VerifyCustomerEmail();
    }

    @When("^I clear all fields in \"([^\"]*)\" Page$")
    public void clearAllFields(String value) throws Exception {
        if (value.equalsIgnoreCase("User Profile")) {
            errorMessageOnUserProfilePage.clearUserProfileAndContactPageFeilds(value);
        } else if (value.equalsIgnoreCase("Business Information")) {
            errorMessageOnUserProfilePage.clearBusinessFields(value);
        } else if (value.equalsIgnoreCase("Business Contact")) {
            errorMessageOnUserProfilePage.clearUserProfileAndContactPageFeilds(value);
        } else if (value.equalsIgnoreCase("Business Billing")) {
            errorMessageOnUserProfilePage.clearUserProfileAndContactPageFeilds(value);
        } else if (value.equalsIgnoreCase("Edit User")) {
            nuiCommon.clearAllFields(value);
        } else if (value.equalsIgnoreCase("Personal Information")) {
            errorMessageOnUserProfilePage.clearPersonalInfoFields(value);
        } else if (value.equalsIgnoreCase("Payment Method")) {
            nuiCommon.clearAllFields(value);
        }
    }

    @Then("^I should see the sponsor logo in the header \"([^\"]*)\"$")
    public void i_should_see_the_sponsor_logo_in_the_header(String logoName) throws Throwable {
        if (logoName.equalsIgnoreCase("VendorLogo")) {
            verifylogo.VerifyVendorLogo();
        } else {
            System.out.println("Invalid logo Entered!!!!");
        }
    }

    @Then("^I should see icon \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void i_should_see_icon_something_on_something_page(String IconName, String PageName) throws Throwable {
        if (IconName.equalsIgnoreCase("congratulationsLogo")) {
            verifylogo.CongratulationsLogo();
        } else if (IconName.equalsIgnoreCase("accountactivatedLogo")) {
            verifylogo.accountactivatedLogo();
        } else if (IconName.equalsIgnoreCase("EmailCommunicationLogo")) {
            verifylogo.EmailCommunicationLogo();
        } else {
            System.out.println("Invalid Icon !!!!");
        }
    }

    @Then("^I should click \"([^\"]*)\" in the footer$")
    public void i_should_click_something_in_the_footer(String FadvSupportLink) throws Throwable {
        if (FadvSupportLink.equalsIgnoreCase("SupportLink")) {
            String expectedUrl = driver.findElement(By.xpath("//a[@href='https://fadv.com/']")).getAttribute("href");
            String actualUrl = "https://fadv.com/";
            assertEquals(expectedUrl, actualUrl);
            logStepInfo("Fadv Support Link is clickable :-" + FadvSupportLink);
        } else if (FadvSupportLink.equalsIgnoreCase("FactActLink")) {
            String expectedUrl = driver.findElement(By.xpath("//a[@href='https://fadv.com/candidates/factact/']"))
                    .getAttribute("href");
            String actualUrl = "https://fadv.com/candidates/factact/";
            assertEquals(expectedUrl, actualUrl);
            logStepInfo("Fact Act Link is clickable :-" + FadvSupportLink);
        } else if (FadvSupportLink.equalsIgnoreCase("LegalLink")) {
            String expectedUrl = driver.findElement(By.xpath("//a[@href='https://fadv.com/legal-privacy-guarantee/']"))
                    .getAttribute("href");
            String actualUrl = "https://fadv.com/legal-privacy-guarantee/";
            assertEquals(expectedUrl, actualUrl);
            logStepInfo("Legal Link is clickable:-" + FadvSupportLink);
        } else if (FadvSupportLink.equalsIgnoreCase("PrivacyPolice")) {
            String expectedUrl = driver.findElement(By.xpath("//a[@href='https://fadv.com/privacy-policy/']"))
                    .getAttribute("href");
            String actualUrl = "https://fadv.com/privacy-policy/";
            assertEquals(expectedUrl, actualUrl);
            logStepInfo("Privacy Police Link is clickable :-" + FadvSupportLink);
        } else {
            logStepInfo("Invalid Link :-" + FadvSupportLink);
            System.out.println("Invalid Url Linked!!!!");
        }
    }

    @And("^I should see \"([^\"]*)\" in the footer of the page$")
    public void i_should_see_something_in_the_footer_of_the_page(String FadvTrademark) throws Throwable {
        if (FadvTrademark.equalsIgnoreCase("FadvTrademark")) {
            String expectedUrl = driver
                    .findElement(By.xpath("//h6[contains(text(), 'First Advantage, All Rights Reserved.')]"))
                    .getText();
            String actualUrl = "First Advantage, All Rights Reserved.";
            assertTrue(expectedUrl.contains(actualUrl));
            logStepInfo("Element is present :-" + FadvTrademark);
        } else {
            logStepInfo("Element is not :-" + FadvTrademark);
            System.out.println("Invalid First Advantage trademark!!!!");
        }
    }

    @When("^I should fill details in \"([^\"]*)\" page$")
    public void fillDetailsPage1(String pageName) throws Exception {
        if (pageName.equalsIgnoreCase("User Profile")) {

            String firstName = _dataRepo.getData("first name") + Random_StringGenerator(3);
            String lastName = _dataRepo.getData("last name") + Random_StringGenerator(3);
            String emailId = _dataRepo.getData("emailId");
            String userId = _dataRepo.getData("userId") + Random_StringGenerator(3) + Random_NumberGenerator(3);
            String password1 = _dataRepo.getData("password1");
            String secretQues = _dataRepo.getData("SecretQues");
            String secretAns = _dataRepo.getData("SecretAns");
            VendorRegistration.UserProfilePage(firstName, lastName, emailId, userId, password1, secretQues, secretAns);
            wait(2);

        } else if (pageName.equalsIgnoreCase("Business Information")) {
            wait(5);
            String BusinessName = _dataRepo.getData("Business Name");
            VendorName = BusinessName;
            String DoingBusnissAs = _dataRepo.getData("DoingBusnissAs");
            String BusniessType = _dataRepo.getData("Business Type");
            String OwnerShipInfo = _dataRepo.getData("OwnerShipInfo") + Random_StringGenerator(3);
            //	String SNN = _dataRepo.getData("SNN") + Random_NumberGenerator(7);
            String BusinessDescription = _dataRepo.getData("Business Description") + Random_StringGenerator(30);
            String CountryName = _dataRepo.getData("CountryName");
            String Address1 = _dataRepo.getData("Address1");
            String State = _dataRepo.getData("State");
            String City = _dataRepo.getData("City");
            String ZipCode = "57105";

            VendorRegistration.BusinessInformationPage(BusinessName, DoingBusnissAs, BusniessType, OwnerShipInfo,
                    BusinessDescription, CountryName, Address1, State, City, ZipCode);

            wait(2);

        } else if (pageName.equalsIgnoreCase("Business Information-taxable")) {
            wait(5);
            String BusinessName = _dataRepo.getData("Business Name");
            VendorName = BusinessName;
            String DoingBusnissAs = _dataRepo.getData("DoingBusnissAs");
            String BusniessType = _dataRepo.getData("Business Type");
            String OwnerShipInfo = _dataRepo.getData("OwnerShipInfo") + Random_StringGenerator(3);
            //String SNN = _dataRepo.getData("SNN") + Random_NumberGenerator(7);
            String BusinessDescription = _dataRepo.getData("Business Description") + Random_StringGenerator(30);
            String CountryName = _dataRepo.getData("CountryName");
            String Address1 = "1502 S Center Avenue";
            String State = "South Dakota";
            String City = "Sioux Falls";
            String ZipCode = "57105";

            VendorRegistration.BusinessInformationPage(BusinessName, DoingBusnissAs, BusniessType, OwnerShipInfo, BusinessDescription, CountryName, Address1, State, City, ZipCode);
            wait(2);

        } else if (pageName.equalsIgnoreCase("Business Information-non-taxable")) {
            wait(5);
            String BusinessName = _dataRepo.getData("Business Name");
            VendorName = BusinessName;
            String DoingBusnissAs = _dataRepo.getData("DoingBusnissAs");
            String BusniessType = _dataRepo.getData("Business Type");
            String OwnerShipInfo = _dataRepo.getData("OwnerShipInfo") + Random_StringGenerator(3);
            //	String SNN = _dataRepo.getData("SNN") + Random_NumberGenerator(7);
            String BusinessDescription = _dataRepo.getData("Business Description") + Random_StringGenerator(30);
            String CountryName = _dataRepo.getData("CountryName");
            String Address1 = "3701 Radio Park Drive";
            String State = "Georgia";
            String City = "Winder";
            String ZipCode = "30680";

            VendorRegistration.BusinessInformationPage(BusinessName, DoingBusnissAs, BusniessType, OwnerShipInfo, BusinessDescription, CountryName, Address1, State, City, ZipCode);
            wait(2);

        } else if (pageName.equalsIgnoreCase("Business Contact")) {
            String BusiContactFirstName = _dataRepo.getData("BusiContactFirstName") + Random_StringGenerator(3);
            String BusiContactLastName = _dataRepo.getData("BusiContactLastName") + Random_StringGenerator(3);
            String BusiContactTitle = _dataRepo.getData("BusiContactTitle");
            String BusiContactEmail = _dataRepo.getData("BusiContactEmail");
            String BusiCountry = _dataRepo.getData("BusiCountry");
            // String CountryCode = _dataRepo.getData("CountryCode");
            String BusiContactPhoneNumber = _dataRepo.getData("BusiContactPhoneNumber") + Random_NumberGenerator(7);
            VendorRegistration.BusinessContactPage(BusiContactFirstName, BusiContactLastName, BusiContactTitle,
                    BusiContactEmail, BusiCountry, BusiContactPhoneNumber);

        } else if (pageName.equalsIgnoreCase("Secondary Business Contact")) {
            String SecondaryBusiContactFirstName = _dataRepo.getData("BusiContactFirstName") + Random_StringGenerator(3);
            String secondaryBusiContactLastName = _dataRepo.getData("BusiContactLastName") + Random_StringGenerator(3);
            String secondaryBusiContactTitle = _dataRepo.getData("BusiContactTitle");
            String secondaryBusiContactEmail = _dataRepo.getData("BusiContactEmail");
            String secondaryBusiCountry = _dataRepo.getData("BusiCountry");
            // String CountryCode = _dataRepo.getData("CountryCode");
            String secondaryBusiContactPhoneNumber = _dataRepo.getData("BusiContactPhoneNumber") + Random_NumberGenerator(7);
            VendorRegistration.SecondaryBusinessCont(secondaryBusiContactLastName, secondaryBusiContactTitle, secondaryBusiContactEmail,
                    secondaryBusiCountry, secondaryBusiContactPhoneNumber);

        } else if (pageName.equalsIgnoreCase("Business Billing")) {
            String BusiContactFirstName = _dataRepo.getData("BusiContactFirstName") + Random_StringGenerator(3);
            String BusiContactLastName = _dataRepo.getData("BusiContactLastName") + Random_StringGenerator(3);
            String BusiContactTitle = _dataRepo.getData("BusiContactTitle");
            String BusiContactEmail = _dataRepo.getData("BusiContactEmail");
            String BusiCountry = _dataRepo.getData("BusiCountry");
            String CountryCode = _dataRepo.getData("CountryCode");
            String BusiContactPhoneNumber = _dataRepo.getData("BusiContactPhoneNumber") + Random_NumberGenerator(7);
            String CountryName = _dataRepo.getData("bbCountryName");
            String Address1 = _dataRepo.getData("bbAddress1");
            String City = _dataRepo.getData("bbCity");
            String State = _dataRepo.getData("bbState");
            String ZipCode = _dataRepo.getData("bbZipCode");
            VendorRegistration.businessBillingPage(BusiContactFirstName, BusiContactLastName, BusiContactTitle,
                    BusiContactEmail, BusiCountry, BusiContactPhoneNumber, CountryName, Address1, State, City, ZipCode);

        } else if (pageName.equalsIgnoreCase("Business Signature")) {
            VendorRegistration.businessSignaturePage(pageName);
        } else if (pageName.equalsIgnoreCase("Personal Information")) {
            SelfScreeningPages.addPersonalInfo();
        } else {
            System.out.println("Invalid page Name Entered!!!!");
        }
    }

    @When("^I set \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_Set_to(String Property, String value) throws Exception {
        if (Property.equalsIgnoreCase("XTDFORCE_REGISTRATION_UI")) {
            databaseClass.updateNewUIVendorConfigRegistration(value);
        } else if (Property.equalsIgnoreCase("vcp_value")) {
            databaseClass.updateNewUIVendorConfiguration(value);
        } else if (Property.equalsIgnoreCase("vcp_valueSelf")) {
            databaseClass.updateNewUISelfSccreeingConfigRegistration(value);
        } else if (Property.equalsIgnoreCase("vcp_valueCreditCard")) {
            databaseClass.updateNewUIVendLevelCreditCard(value);
        }
    }

    @Then("^I set Vendor Cost to \"([^\"]*)\"$")
    public void set_vendor_cost(String cost) throws Throwable {
        String custID = driver.getTitle();
        databaseClass.setVendorCost(cost, custID);
    }

    @Then("^I set Package Price to \"([^\"]*)\"$")
    public void set_package_price(String price) throws Throwable {
        String custID = driver.getTitle();
        String packageName = _dataRepo.getData("Package");
        String inputPkg = "%" + packageName + "%";
        String queryName = "Update_PackagePrice";
        databaseClass.setPackagePrice(queryName, price, inputPkg, custID);
    }

    @Then("^Get Credit Card Data from Database$")
    public void get_something_credit_card_data_from_database() throws Throwable {
        databaseClass.getVendorLevelCreditCardDetails();
    }

    //DataTable values
//	List<List<String>> data = values.asLists();
//
//	String ORDER_REFERENCE_ID = data.get(1).get(0);
//	String PAYMENT_TOKEN_ID = data.get(1).get(1);
//	String VENDOR_ID = data.get(1).get(2);
//	String PAYMENT_TOTAL = data.get(1).get(3);
//
//	if (ORDER_REFERENCE_ID.equalsIgnoreCase("YES") && PAYMENT_TOKEN_ID.equalsIgnoreCase("YES") && VENDOR_ID.equalsIgnoreCase("YES")
//			&& PAYMENT_TOTAL.equalsIgnoreCase("YES")) {
//			databaseClass.getVendorLevelCreditCardDetails();
//		}
//}
    @And("^Verify PlaceHolder Value for \"([^\"]*)\" on \"([^\"]*)\" Page$")
    public void Verify_PlaceHolder_Value_for(String value, String pageName) throws Throwable {
        if (pageName.equalsIgnoreCase("Administration")) {
            By xpathFields = By.xpath("//*[contains(@placeholder,'" + value + "')] | //option[contains(text(),'" + value
                    + "')]//parent::select");
            wait(1);
            verifyElementPresence(xpathFields, value);

        } else if (pageName.equalsIgnoreCase("Your Payments")) {
            By xpathFields = By.xpath("//label[@data-placeholder='" + value + "']");
            wait(1);
            verifyElementPresence(xpathFields, value);

        } else if (pageName.equalsIgnoreCase("XtdConnect")) {
            By xpathFields = By.xpath("//*[@placeholder='" + value + "']");
            wait(1);
            verifyElementPresence(xpathFields, value);
        } else if (pageName.equalsIgnoreCase("XtdConnectDOBTitle")) {
            By xpathFields = By.xpath("//fadv-date-picker[@ng-reflect-label='" + value + "']");
            wait(1);
            verifyElementPresence(xpathFields, value);
        } else if (pageName.equalsIgnoreCase("Business Information")) {
            By xpathFields = By.xpath("//input[@placeholder='" + value + "']");
            wait(1);
            verifyElementPresence(xpathFields, value);
        }


    }

    /**
     * @author marovimo 05/26/2021 -- Verify element by data-xf-qa-id
     *****/
    @When("^Verify Element \"([^\"]*)\" with data-xf-qa-id \"([^\"]*)\" for \"([^\"]*)\"$")
    public void verify_Element_with_data_xf_qa_id_for(String existing, String value, String name) throws Throwable {
        if (existing.equalsIgnoreCase("exist")) {
            By xpathFields = By.xpath("//*[contains(@data-xf-qa-id,'" + value + "')]");
            wait(1);
            verifyElementPresence(xpathFields, value);
        } else {
            By xpathFieldsPesonalInformationPage = By.id(value);
            wait(1);
            verifyElementNotPresence(xpathFieldsPesonalInformationPage, "Element on Person Information page" + value);
        }
    }

    @And("^I click on Accordion$")
    public void I_Click_On_Accordion() throws Throwable {

        clickElementWithWait(By.xpath("//*[@id=\"panel-0\"]/td[9]/fa-icon"), "Accordion");

    }

    @And("^Save search reslut state \"([^\"]*)\"$")
    public String Save_search_result_state(String value) throws Throwable {
        wait(2);
        int paginationCount = driver.findElements(By.xpath("//li[contains(@class,'pagination-page page-item')]/a"))
                .size();
        nuiCommon.clickPaginationDoubleArrow("GoToLast", "People");
        int rowLastPageCount = driver.findElements(By.xpath("//table/tbody/tr [@class='a-panel']")).size();
        if (value.equalsIgnoreCase("before")) {
            searchResultStateBefore = "Pagination Count:" + paginationCount + " Last Page Rows: " + rowLastPageCount;
            return searchResultStateBefore;
        } else {
            searchResultStateAfter = "Pagination Count:" + paginationCount + " Last Page Rows: " + rowLastPageCount;
            return searchResultStateAfter;
        }
    }

    @And("Compare search result state")
    public void Compare_search_result_state() throws Throwable {
        if (searchResultStateBefore.equalsIgnoreCase(searchResultStateAfter)) {
            reportLog(Status.PASS, "Search result without changes", false);
            System.out.println("Search result without changes");
        } else {
            reportLog(Status.PASS, "Search result with changes", false);
            System.out.println("Search result with changes");
        }

    }

    @Then("^I should click on \"([^\"]*)\"$")
    public void i_click_on_forgot_link(String value) throws Throwable {
        if (value.equalsIgnoreCase("Forgot password link")) {
            clickElementWithWait(VendorRegistration.NewUIForgotPasswordLink, "Clicked on Forget Password Link New UI");
        } else if (value.equalsIgnoreCase("Return to login")) {
            clickElementWithWait(VendorRegistration.ReturnButton, "Clicked on Return to login");
        }
    }

    @And("^I should enter valid \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void Email(String value, String page) throws Throwable {
        String emailId = _dataRepo.getData("Email");
        VendorRegistration.emailOnforgotPassword(emailId);
    }

    @Then("^verify the tax details on \"([^\"]*)\" Page$")
    public void verify_the_tax_details_on_something_page(String page) throws Throwable {
        switch (page.toLowerCase()) {
            case "people ordering taxable":
                nuiTaxIntegration.TaxIntegrationYes();
                break;

            case "people ordering non-taxable":
                nuiTaxIntegration.TaxIntegrationNo();
                break;

            default:
                NewUIPayment.VendorPaymentTaxValidation();
                break;
        }
    }

    @Then("^Get the ProfileId from UI$")
    public void Get_value_From_UI() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        profileId = wait
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//xf-order-card/div/span/div/div[1]/p[2]")))
                .getText().replace("#", "");
    }

    @Then("^Get the \"([^\"]*)\" From DB in \"([^\"]*)\"$")
    public void Get_value_From_DB(String value, String connDB) throws Throwable {

//	if (value.equalsIgnoreCase("ProfileId")) {
//		profileId= driver.findElement(By.xpath("//*[@id=\"panel-0\"]/td[9]/fa-icon")).getText().replace("#", "");
//	}

        if (value.equalsIgnoreCase("ProfileId")) {
            String firstName = _dataRepo.getData("FirstName");
            String lastName = _dataRepo.getData("LastName");
            databaseClass.getProfileId(firstName, lastName, connDB);
        }

        /**
         * @author marovimo
         * @category added else if for newly added Person
         **/
        else if (value.equalsIgnoreCase("NewProfileId")) {
            String firstName = existingFirstName;
            String lastName = existingLastName;
            databaseClass.getProfileId(firstName, lastName, connDB);

        } else if (value.equalsIgnoreCase("NewProfileId")) {
            databaseClass.getPersonName(userName, connDB);
        }
    }

    /**
     * @author marovimo 06/06/2021 -- Veva_Cust_Property Setting
     *****/
    @When("^I set property \"([^\"]*)\" to \"([^\"]*)\"$")
    public void I_set_property(String property, String value) throws Throwable {
        propertyValueAT = value;
        String custID = driver.getTitle();
        databaseClass.setVevaCustProperty(property, value, custID);
    }

    /**
     * @author marovimo 06/08/2021 -- Veva_Cust_Property Setting
     *****/
    @When("^I set Program Payment Method to \"([^\"]*)\" where Vendor \"([^\"]*)\"$")
    public void I_set_payment_method(String paymentMethod, int vendorID) throws Throwable {
        propertyValuePM = paymentMethod;
        databaseClass.setProgramPaymentVendor(paymentMethod, vendorID);
    }

    @When("^I set address for \"([^\"]*)\" state for Vendor \"([^\"]*)\"$")
    public void I_set_address_for_vendor(String tax, int vendorID) throws Throwable {
        taxableState = tax;
        databaseClass.setVendorAddress(tax, vendorID);
    }

    /**
     * @author marovimo 06/06/2021 -- Clearing one field
     *****/
    @When("^I clear \"([^\"]*)\" in \"([^\"]*)\" Page$")
    public void I_clear_field_in_page(String field, String page) throws Throwable {
        nuiCommon.clearFeld(field, page);
    }

    /**
     * @author marovimo 08/06/2021 -- Clearing one field
     *****/
    @When("^Verify Information on \"([^\"]*)\" Page$")
    public void Verify_information_on_page(String page) throws Throwable {
        nuiCommon.verifyPageInformations(page);
    }

    /**
     * @author marovimo 06/10/2021 -- Veva_User set locking
     *****/
    @When("^Set User to \"([^\"]*)\" locked for UserID \"([^\"]*)\"$")
    public void Set_user_to_unlocked(String flag, int userID) throws Throwable {
        databaseClass.setVevaUserlocked(flag, userID);
    }

    /**
     * @author marovimo 07/06/2021 -- Compliance Hyperlink
     *****/

    @When("^Verify Complianace Hyperlink with input value \"([^\"]*)\" for \"([^\"]*)\" status$")
    public void verify_Complianace_Hyperlink_with_input_value_for_status_for_DB(String input, String status)
            throws Throwable {
        String queryName = "Select_Compliance_Status";
        String complStatus = null;
        String caseScore = null;
        if (status.equalsIgnoreCase("Compliant")) {
            complStatus = "400";
            caseScore = "AND VO.CP_ORDER_UID IS NOT NULL AND VO.VO_CASE_SCORE IN ('Y')";
        } else if (status.equalsIgnoreCase("Not-Compliant")) {
            complStatus = "401";
            caseScore = "AND VO.CP_ORDER_UID IS NOT NULL AND VO.VO_CASE_SCORE IN ('N')";
        } else if (status.equalsIgnoreCase("Pending")) {
            complStatus = "403";
            caseScore = "AND VO.CP_ORDER_UID IS NOT NULL AND (VO.VO_CASE_SCORE NOT IN ('D') OR VO.VO_CASE_SCORE IS NULL)";
        } else {
            complStatus = "403";
            caseScore = "AND VO.CP_ORDER_UID IS NULL AND VO.VO_CASE_SCORE IS NULL";
        }

        if (input.equalsIgnoreCase("UserName"))
            inputValue = userName;
        databaseClass.getComplianceStatus(queryName, complStatus, inputValue, caseScore);
    }

    @And("^Verify value \"([^\"]*)\" on \"([^\"]*)\" Page for DB \"([^\"]*)\"$")
    public void verify_value_for_DB(String input, String page, String DB) throws Throwable {

        if (input.equalsIgnoreCase("Price")) {
            By xpathFields;
            String queryName = "Select_pkg_price";
            String custID = driver.getTitle();
            String inputPkg = packageName;
            System.out.println(custID);
            System.out.println(inputPkg);

            // setting value of packagePrice from DB
            databaseClass.getPkgPrice(queryName, custID, inputPkg, DB);

            if (additionalBillingFlag.contains("Y")) {
                double packagePrice1 = Double.parseDouble(packagePrice);
                double additionalBillingPrice1 = Double.parseDouble(additionalBillingPrice);
                packagePrice1 = packagePrice1 + additionalBillingPrice1;
                packagePrice = String.valueOf(packagePrice1);
                packagePrice = String.format("%,.2f", packagePrice1);
            }

            if (page.equalsIgnoreCase("package selection")) {
                xpathFields = By.xpath("//td/*[text()=' $" + packagePrice + " ']");
            } else {
                xpathFields = By.xpath("//*[@data-label='" + input + "']");
            }

            verifyElementText(xpathFields, packagePrice);

        } else if (input.equalsIgnoreCase("Vendor email")) {

            By xpathFields = By.xpath("//table/tbody/tr[3]/td/b");
            String queryName = "Select_Vendor_email";
            databaseClass.getStateCodeVendorEmail(queryName, userName, DB);
            verifyElementText(xpathFields, vendorEmail);

        } else if (input.equalsIgnoreCase("Tax")) {

            if (page.equalsIgnoreCase("Vendor Registration")) {

                String state = existingBusinessAddress.replaceAll("^([^,]*,[^,]*),", "").substring(0, 3).trim();
                String property = "TAX_CALCULATION_ENABLE";
                databaseClass.getProperyValue(property);
                String states = PropertyFileReader.getProperty("TaxableStateCode");
                String noTax = "0.00";
                TaxAmount = driver.findElement(By.xpath("//p[contains(@class, 'card-text')]")).getText().replace("Tax: $", "").trim();

                if (states.contains(state) && propertyValue.contains("Y")) {
                    verifyStringNotContainsText(TaxAmount, noTax);
                    logStepInfo(TaxAmount);
                } else {
                    verifyStringContainsText(TaxAmount, noTax);
                    logStepInfo(TaxAmount);
                }

            } else {
                String queryName = "Select_vendor_statecd";
                String property = "TAX_CALCULATION_ENABLE";
                databaseClass.getStateCodeVendorEmail(queryName, userName, DB);
                databaseClass.getProperyValue(property);
                String states = PropertyFileReader.getProperty("TaxableStateCode");
                System.out.println(states);
                String noTax = "0.00";
                if (page.contains("Payment Method")) {
                    TaxAmount = driver.findElement(By.xpath("//p[contains(@class, 'card-text')]")).getText().replace("Tax: $", "").trim();
                } else {
                    TaxAmount = driver.findElement(By.xpath("//xf-shopping-cart/div/div/div[3]/div[3]/div[2]/div/div[2]/div[1]/p")).getText().replace("Tax: $", "").trim();
                }
                // If sate is taxable UI tax amount isn't = 0.00
                if (states.contains(vendorStateCd) && propertyValue.contains("Y")) {
                    verifyStringNotContainsText(TaxAmount, noTax);
                    // If sate is non-taxable UI tax amount is = 0.00
                } else {
                    verifyStringContainsText(TaxAmount, noTax);
                }
            }
        }
    }

    @When("^I Execute \"([^\"]*)\"$")
    public void i_Execute(String Scenario) throws Exception {
        reportLog(Status.INFO, "<b>" + Scenario + "</b>", true);
    }

    @When("^Turn off default filter$")
    public void turnOffFilter() throws Exception {
        clickElementWithWait(nuiPeoplePage.filterButton, "Filter button on People Page");
        clickElementWithWait(nuiPeoplePage.actionFilterCheckbox, "Filter button on People Page");
        clickElementWithWait(nuiPeoplePage.confirmFilterButton, "Filter button on People Page");
    }

    @When("I get Person for \"([^\"]*)\" status")
    public void iGetValuesStatus(String Value) throws Exception {

        String[] searchValues = _dataRepo.getData(Value + " Name").split(" ");

        existingFirstName = searchValues[0];
        existingLastName = searchValues[1];
    }

    @Then("^Get the UserId from UI$")
    public void Get_userid_From_UI() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        existingUserID = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@data-label='User ID'])[1]")))
                .getText();
    }

    @Then("^I Sign in Signature box$")
    public void I_Sign_in_Signature_box() throws Throwable {
        wait(2);
        By ConvasSign = By.xpath("//*[@id = 'bs-signature-pad']");
        if (verifyElementPresence(ConvasSign)) {
            WebElement canvasElement = driver.findElement(ConvasSign);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", canvasElement);
        }
        actionPerform(ConvasSign, "Draw on Signature Canvas");
        logStepInfo("Signature Entered : " + "Sign");
    }

    @When("^I get details of \"([^\"]*)\" from UI$")
    public void Get_person_details_From_UI(String Value) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By nameXpath;
        String[] name = null;
        String existingSSNValue = null;
        if (Value.equalsIgnoreCase("Person")) {
            By ssnXpath = By.xpath("(//tr/td[contains(@data-label,'Name')]//following::td[contains(@data-label,'Social Security') and string-length(text()) > 0])[last()]");
            wait(3);
            if (verifyElementPresence(ssnXpath)) {
                existingSSNValue = wait.until(ExpectedConditions.presenceOfElementLocated(ssnXpath)).getText();
                existingSSN = existingSSNValue;

                nameXpath = By.xpath("(//td[contains(@data-label,'Social Security') and string-length(text()) > 0]//preceding::td[contains(@data-label,'Name')])[last()]");
                name = wait.until(ExpectedConditions.presenceOfElementLocated(nameXpath)).getText().split(" ");
                logStepInfo("SSN value is present.");
            } else {
                existingSSN = "";
                nameXpath = By.xpath("(//tr/td[contains(@data-label,'Name')])[1]");
                name = wait.until(ExpectedConditions.presenceOfElementLocated(nameXpath)).getText().split(" ");
                logStepInfo("SSN value is not present.");
            }

        } else if (Value.equalsIgnoreCase("User")) {
            By emailXpath = By
                    .xpath("(//td[contains(@data-label,'Name')]//following::td[contains(@data-label,'Email')])[1]");
            existingEmail = wait.until(ExpectedConditions.presenceOfElementLocated(emailXpath)).getText();
            nameXpath = By
                    .xpath("(//td[contains(@data-label,'Email')]//preceding::td[contains(@data-label,'Name')])[1]");
            name = wait.until(ExpectedConditions.presenceOfElementLocated(nameXpath)).getText().split(" ");
        }

        existingFirstName = name[0];
        if (name.length > 2) {
            existingMiddleName = name[1];
            existingLastName = name[2];
            existingFullName = searchTextFN + " " + existingMiddleName + " " + searchTextLN;
        } else {
            existingLastName = name[1];
            existingFullName = searchTextFN + " " + searchTextLN;
        }

    }

    @When("^I get existing data of \"([^\"]*)\"$")
    public void Get_data_From_excel(String Value) throws Throwable {

        if (Value.equalsIgnoreCase("Completed Profile Person")) {
            existingFirstName = PropertyFileReader.getProperty("FirstNameCompletedProfile");
            existingLastName = PropertyFileReader.getProperty("LastNameCompletedProfile");

        } else {
            existingFirstName = PropertyFileReader.getProperty("FirstNameNonCompletedProfile");
            existingLastName = PropertyFileReader.getProperty("LastNameNonCompletedProfile");

        }

    }

    @Then("^I set existing data of \"([^\"]*)\"$")
    public void set_data_From_excel(String Value) throws Throwable {

        if (Value.equalsIgnoreCase("New User")) {

            PropertyFileReader.setProperty("NewUINewUser", existingUserID);
            System.out.println("UserID of User : " + existingUserID);

            PropertyFileReader.setProperty("NewUINewUserPass", existingPassword);
            System.out.println("Password of User : " + existingPassword);

        } else if (Value.equalsIgnoreCase("Completed Profile Person")) {

            if (Value.contains("clear")) {
                PropertyFileReader.setProperty("FirstNameCompletedProfile", null);
                System.out.println("First Name of Completed Profile Person is set to null");

                PropertyFileReader.setProperty("LastNameCompletedProfile", null);
                System.out.println("Last Name of Completed Profile Person is set to null");
            } else {
                PropertyFileReader.setProperty("FirstNameCompletedProfile", existingFirstName);
                System.out.println("First Name of Completed Profile Person : " + existingFirstName);

                PropertyFileReader.setProperty("LastNameCompletedProfile", existingLastName);
                System.out.println("Last Name of Completed Profile Person : " + existingLastName);
            }

        } else {
            PropertyFileReader.setProperty("FirstNameNonCompletedProfile", existingFirstName);
            System.out.println("First Name of Non Completed Profile Person : " + existingFirstName);

            PropertyFileReader.setProperty("LastNameNonCompletedProfile", existingLastName);
            System.out.println("Last Name of Non Completed Profile Person : " + existingLastName);

        }

    }

    @Then("^Send an Email NewUI$")
    public void Send_an_Email_Prod_NewUI() throws Exception {
        mail.sendEmailwithJSNewUI();
        //mail.sendEmail();


    }

    @Then("I set Additional Billing Flag to \"([^\"]*)\" and Additional Billing Price to \"([^\"]*)\"$")
    public void set_additional_billing(String Flag, String Price) throws Throwable {

        String custID = driver.getTitle();
        String packageName = _dataRepo.getData("Package");
        String inputPkg = "%" + packageName + "%";
        String queryName = "Update_AdditonalBilling";
        databaseClass.setAdditionalBillingPrice(queryName, custID, inputPkg, Flag, Price);
    }

    @When("^I log in to admin tool select customer \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_log_in_to_admin_tool_select_customer(String customer, String env) throws Exception {
        nuiAdminTool.loginAdminTool(env);
        nuiAdminTool.selectCustomer(customer);
    }

    @When("^I update Property \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_update_property_admin_tool(String propertyName, String propertyValue) throws Exception {
        nuiAdminTool.changePropertyValue(propertyName, propertyValue);
    }

    @When("^I edit Customer Preference \"([^\"]*)\" to \"([^\"]*)\" in Admin tool$")
    public void i_update_customer_preference(String customerPreference, String preferenceValue) throws Exception {
        nuiAdminTool.edit_customer_preferences(customerPreference, preferenceValue);
    }

    @When("^I change Package property \"([^\"]*)\" to \"([^\"]*)\" in Admin tool$")
    public void I_change_Property(String property, String value) throws Exception {
        nuiAdminTool.edit_package(property, value);
    }

    @When("^I clear the cache$")
    public void I_clear_cache() throws Exception {
        nuiCommon.clearCache();
    }


    public boolean CompareDates(Date dateBefore, Date dateAfter, Date dateNow) {
        if (dateBefore.before(dateNow) && dateAfter.after(dateNow) || dateAfter.equals(dateNow)
                || dateBefore.equals(dateNow)) {
            return true;
        }
        return false;
    }

    @And("^I search for \"([^\"]*)\"$")
    public void EnterValuePeopleSearch(String value) {
        existingFirstName = value;
//        existingFirstName = value.split(" ")[0];
        By firstName = By.xpath("//*[@id=\"first-input\"]");
        EnterText(firstName, "First Name entered " + existingFirstName, existingFirstName);
//        existingLastName = value.split(" ")[1];
//        existingssnNumber=value.split(" ")[2];
//        EnterText(nuiAdministrationPage.firstNameText, "First Name", existingfirstName);
//        EnterText(nuiAdministrationPage.lastNameText, "Last Name", existingLastName);
//        EnterText(nuiAdministrationPage.SSNText, "SSN", existingssnNumber);
    }

    @And("^I verify \"([^\"]*)\" for Administration$")
    public void verifyButtonColoringAdministration(String identifier) {
        int counter = 0, total = 0;
        wait(2);
        while (true) {
            wait(2);
            checkboxAvailiableAdmin();
            System.out.println(checkboxSizeAdmin.size());
            total += checkboxSizeAdmin.size();
            for (int i = 1; i <= checkboxSizeAdmin.size(); i++) {
                WebElement statusElement = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]/div"));
                if (nuiPeoplePage.buttonColoring(statusElement)) {
                    counter++;
                }
            }
//            if (verifyElementPresence(nuiAdministrationPage.nextPageButtonDisabledAdministration)) {
//                break;
//            }
            //    clickElement(nuiAdministrationPage.nextPageButtonAdministration, "Next Page Button");
            //   wait(2);
            break;
        }
        if (counter == total) {
            reportLog(Status.PASS, "Status colors are matching with expected color ", false);
        } else {
            reportLog(Status.FAIL, "Unexpected color", false);
        }
    }

    public void checkboxAvailiableAdmin() {
        checkboxSizeAdmin = driver.findElements(By.xpath("//*[@type='checkbox']"));
    }

    @And("^I verify \"([^\"]*)\" for People$")
    public void verifyButtonColoring(String identifier) {
        switch (identifier.toLowerCase()) {
            case "compliance button coloring":
                int counterCompliance = 0, totalCompliance = 0;
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalCompliance += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        WebElement statusElementCompliance = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div"));
                        WebElement statusElementPerson = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[9]"));
                        if (nuiPeoplePage.buttonColoring(statusElementPerson) && nuiPeoplePage.buttonColoring(statusElementCompliance)) {
                            counterCompliance++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }
                if (counterCompliance == totalCompliance) {
                    reportLog(Status.PASS, "There are no unexpected colors", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected color", false);
                }
                break;
            case "screening button coloring":
                int counterScreening = 0, totalScreening = 0;
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalScreening += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        WebElement statusElementScreening = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div"));
                        WebElement statusElementPerson = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[8]/div"));
                        WebElement accordionClick = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[9]"));
                        if (nuiPeoplePage.buttonColoring(statusElementPerson) && nuiPeoplePage.buttonColoringScreening(statusElementScreening, accordionClick, atributeValue)) {
                            counterScreening++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }
                if (counterScreening == totalScreening) {
                    reportLog(Status.PASS, "There are no unexpected colors", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected color", false);
                }
                break;
        }
    }

    //counts checkboxes on people page
    public void checkboxAvailiable() {
        checkboxSize = driver.findElements(By.cssSelector("#checkbox2"));
    }

    public boolean contains(String value, String status) {
        String[] splitValue = value.split(",");
        for (int i = 0; i < splitValue.length; i++) {
            if (splitValue[i].equals(status)) {
                return true;
            }
        }
        return false;
    }

    @And("^I select Date \"([^\"]*)\" \"([^\"]*)\"$")
    public void selectDate(String range, String date) {
        String dateMonth = date.split(" ")[0];
        String dateDay = date.split(" ")[1];
        String dateYear = date.split(" ")[2];
        By daterangepicker = By.cssSelector("body > bs-daterangepicker-container > div > div > div > div > bs-days-calendar-view:nth-child(1) > bs-calendar-layout > div.bs-datepicker-head > bs-datepicker-navigation-view > button:nth-child(3)");
        clickElement(daterangepicker, "Date Range Picker clicked");
//        if (verifyElementPresence(By.xpath("//bs-days-calendar-view[1]//button[@type='button' and @class='current']"))) {
//            driver.findElement(By.xpath("//bs-days-calendar-view[1]//button[@type='button' and @class='current']")).click();
//        }
//        if it cant find year button, uncomment

        By dateYearButton = By.xpath("/html/body/bs-daterangepicker-container/div/div/div/div/bs-years-calendar-view[1]/bs-calendar-layout/div[2]/table/tbody//span[text()='" + dateYear + "']/parent::td");
        clickElement(dateYearButton, "Date Year clicked");
        By dateMonthButton = By.xpath("/html/body/bs-daterangepicker-container/div/div/div/div/bs-month-calendar-view[1]//span[text()='" + dateMonth + "']");
        clickElement(dateMonthButton, "Date Month clicked");
        By dateDayButton = By.xpath(
                "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]//span[text()='" + dateDay + "' and @class='ng-star-inserted']");
        clickElement(dateDayButton, "Date Day clicked");
        if (range.equalsIgnoreCase("from")) {
            dateBefores = date;
        } else if (range.equalsIgnoreCase("from completion")) {
            dateBeforeCompletions = date;
        } else if (range.equalsIgnoreCase("to completion")) {
            dateAfterCompletions = date;
        }
        dateAfters = date;
    }

    @And("^I should see element \"([^\"]*)\" for \"([^\"]*)\" for Program Owner$")
    public void I_should_see_element_on_ProgramOwner(String Value, String identifier) throws Exception {
        wait(3);
        List<WebElement> pagination;
        switch (identifier.toLowerCase()) {
            case "person status accordion search":
                wait(3);
                int counter = 0, total = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.FAIL, "No Result Found", false);
                    break;
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    System.out.println(checkboxSize.size());
                    wait(2);
                    total += checkboxSize.size();
                    for (int i = 0; i < 5; i++) {
                        String searchValuePersonStatus = Value;
                        String atributeValue = "panel-" + i;
                        String personStatusElement = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[9]/div"))
                                .getText();
                        if (contains(searchValuePersonStatus, personStatusElement)) {
                            System.out.println("Status is correct at: " + atributeValue);
                            counter++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }

                if (counter == total) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "compliance accordion search":
                wait(3);
                int counters = 0, totals = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totals += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String searchValueComplianceStatus = Value;
                        String atributeValue = "panel-" + i;
                        String complianceStatusElement = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div")).getText();
                        if (contains(searchValueComplianceStatus, complianceStatusElement)) {
                            counters++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }

                if (counters == totals) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "screening accordion search":
                wait(3);
                int countersc = 0, totalsc = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    System.out.println("while enetered");
                    totalsc += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String searchValueComplianceStatus = Value;
                        String atributeValue = "panel-" + i;
                        String complianceStatusElement = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div")).getText();
                        if (contains(searchValueComplianceStatus, complianceStatusElement)) {
                            countersc++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }

                if (countersc == totalsc) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "checkbox checked":
                String checked = ((JavascriptExecutor) driver).executeScript("return document.getElementById('" + Value + "').checked==true;").toString();
                if (checked.equalsIgnoreCase("true")) {
                    reportLog(Status.PASS, "Element is checked", false);
                } else {
                    reportLog(Status.FAIL, "Element is unchecked", false);
                    break;
                }
                break;
            default:
                break;
        }
    }

    @And("^I should see element \"([^\"]*)\" for People$")
    public void I_should_see_element_on_People(String identifier) throws Exception {
        switch (identifier.toLowerCase()) {
            case "date accordion search":
                wait(2);
                int counterDate = 0, totalDate = 0;
                wait(2);
                SimpleDateFormat dates = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                Date dateAfter = dates.parse(dateAfters);
                Date dateBefore = dates.parse(dateBefores);
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(3);
                    checkboxAvailiable();
                    wait(2);
                    totalDate += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String OrderDate = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[5]"))
                                .getText();
                        Date dateNow = dates.parse(OrderDate);
                        if (CompareDates(dateBefore, dateAfter, dateNow)) {
                            counterDate++;
                        } else {
                            System.out.println("Date out of scope");
                            break;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (counterDate == totalDate) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "completion date accordion search":
                wait(2);
                int completionCounter = 0, completionTotal = 0;
                wait(2);
                SimpleDateFormat dateCompletion = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                Date dateAfterCompletion = dateCompletion.parse(dateAfterCompletions);
                Date dateBeforeCompletion = dateCompletion.parse(dateBeforeCompletions);
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    completionTotal += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String OrderDate = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[6]"))
                                .getText();
                        Date dateNow = dateCompletion.parse(OrderDate);
                        if (CompareDates(dateBeforeCompletion, dateAfterCompletion, dateNow)) {
                            completionCounter++;
                        } else {
                            System.out.println("Date out of scope");
                            break;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (completionCounter == completionTotal) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
        }
    }

    @And("^I should see element \"([^\"]*)\" \"([^\"]*)\" for \"([^\"]*)\" for People$")
    public void I_should_see_element_on(String FirstValue, String SecondValue, String identifier) throws ParseException {
        switch (identifier.toLowerCase()) {
            case "person status and compliance accordion search":
                wait(3);
                int counterpc = 0, totalpc = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalpc += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String searchValuePersonStatus = FirstValue;
                        String searchValueComplianceStatus = SecondValue;
                        String atributeValue = "panel-" + i;
                        String personStatusElement = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[8]/div"))
                                .getText();
                        String complianceStatusElement = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div")).getText();
                        if (contains(searchValueComplianceStatus, complianceStatusElement) && contains(searchValuePersonStatus, personStatusElement)) {
                            counterpc++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (counterpc == totalpc) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "person status compliance order date completion date accordion search":
                wait(3);
                int counterpcs = 0, totalpcs = 0;
                SimpleDateFormat dates = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                Date dateAfter = dates.parse(dateAfters);
                Date dateBefore = dates.parse(dateBefores);
                Date dateAfterCompletion = dates.parse(dateAfterCompletions);
                Date dateBeforeCompletion = dates.parse(dateBeforeCompletions);
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalpcs += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String searchValuePersonStatus = FirstValue;
                        String searchValueComplianceStatus = SecondValue;
                        String atributeValue = "panel-" + i;
                        String personStatusElement = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[8]/div"))
                                .getText();
                        String complianceStatusElement = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div")).getText();
                        String OrderDate = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[5]"))
                                .getText();
                        Date dateNow = dates.parse(OrderDate);
                        String completionOrderDate = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[6]"))
                                .getText();
                        Date completionDateNow = dates.parse(completionOrderDate);
                        if (contains(searchValueComplianceStatus, complianceStatusElement) && contains(searchValuePersonStatus, personStatusElement) && CompareDates(dateBefore, dateAfter, dateNow) && CompareDates(dateBeforeCompletion, dateAfterCompletion, completionDateNow)) {
                            counterpcs++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (counterpcs == totalpcs) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            default:
                break;
        }
    }

    @And("^I choose a random user to search$")
    public void chooseRandomUser() {
        Random random = new Random();
        int rand = random.nextInt(29);
        String attribute = "panel-" + rand;
        WebElement user = driver.findElement(By.xpath("//*[@id='" + attribute + "']/td[2]"));
        WebElement ssn = driver.findElement(By.xpath("//*[@id='" + attribute + "']/td[7]"));
        System.out.println(ssn.getText());
        System.out.println(user.getText().split(" ").length);
        if (user.getText().split(" ").length > 2) {
            existingFirstName = user.getText().split(" ")[0];
            existingMiddleName = user.getText().split(" ")[1];
            existingLastName = user.getText().split(" ")[2];
            if (ssn.getText() != null) {
                existingssnNumber = ssn.getText().replaceAll("[*-]", "");
                System.out.println(existingssnNumber);
            } else {
                existingssnNumber = " ";
            }
        } else {
            existingFirstName = user.getText().split(" ")[0];
            existingLastName = user.getText().split(" ")[1];
            if (ssn.getText() != null) {
                existingssnNumber = ssn.getText().replaceAll("[*-]", "");
                System.out.println(existingssnNumber);
            } else {
                existingssnNumber = " ";
            }
        }

    }

    /**
     * Still not implementable since we dont have enough users, so for now only first user is chosen
     */
    @And("^I choose a random Providers page user to search and verify the query result is valid$")
    public void chooseRandomUserProvidersPage() {
        Random random = new Random();
        //   int rand = random.nextInt(29);
        //int rand = 1;
        WebElement user = driver.findElement(By.xpath("//*[contains(@id,'panel')]/td[2]"));//[" + rand + "]
        System.out.println(user.getAttribute("outerHTML"));
        System.out.println(user.getText());
        String[] providerName = user.getText().trim().split(" ");
        for (String search : providerName) {
            System.out.println(search);
            EnterText(nuiHomePage.providerSearch, "Provider search " + search, search);
            clickElement(nuiHomePage.searchIcon, "Search Icon on Providers page clicked");
            if (verifyProviderSearchResult(search)) {
                reportLog(Status.PASS, "Results are inline with query", false);
            } else {
                reportLog(Status.FAIL, "Results are Not Inline with query", true);
                scenarioFailed();
            }
        }
    }

    @And("^I verify Action Button and change the user status to \"([^\"]*)\"$")
    public void changeStatus(String status) {
        By checkbox = By.xpath("(//input[@id='checkbox2'])[1]");
        clickElement(checkbox, "checkbox is clicked");
        if (!verifyElementPresence(nuiPeoplePage.actionButtonDisabled)) {
            verifyElementPresence(nuiPeoplePage.actionButton, "Action Button is present");
        } else {
            scenarioFailed();
        }
        By actionButtonStatuses = By.xpath("//li//button[contains(text(),'" + status + "')]");
        clickOnElementUsingActions(actionButtonStatuses, "Status changed to " + status);
    }

    public boolean verifyAccordionContent(String iterator) {
        By accordionTileProfile = By.xpath("//*[@id='" + iterator + "']/following-sibling::tr[@class='panel-content'][1]//span[contains(text(),'Profile')]");
        By accordionTileBackground = By.xpath("//*[@id='" + iterator + "']/following-sibling::tr[@class='panel-content'][1]//span[contains(text(),'Background')]");
        wait(2);
        if (verifyElementPresence(accordionTileProfile) || verifyElementPresence(accordionTileBackground)) {
            System.out.println("Element found at index: " + iterator);
            return true;
        }
        System.out.println("Element not found at index: " + iterator);
        return false;
    }

    @And("^I should see valid tile cards in accordion")
    public void verifyAccordionisDisplayed() {
        wait(3);
        int counterpcs = 0, totalpcs = 0;
        if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
            reportLog(Status.PASS, "No Result Found", false);
        }
        while (true) {
            wait(2);
            checkboxAvailiable();
            wait(2);
            totalpcs += checkboxSize.size();
            for (int i = 0; i < checkboxSize.size(); i++) {
                String attribute = "panel-" + i;
                By accordion = By.xpath("//*[@id='" + attribute + "']/td[10]");
                clickElement(accordion, "accordion is clicked");
                if (verifyAccordionContent(attribute)) {
                    counterpcs++;
                }
            }
            if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                break;
            }
            clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
        }
        if (counterpcs == totalpcs) {
            reportLog(Status.PASS, "There are no unexpected results", false);
        } else {
            reportLog(Status.FAIL, "Unexpected results", false);
        }
    }

    @And("^I should see element \"([^\"]*)\" \"([^\"]*)\" for \"([^\"]*)\" for Program Owner$")
    public void I_should_see_element_on_ProgramOwner(String searchValuePersonStatus, String searchValueScreeningComplianceStatus, String identifier) throws ParseException {
        switch (identifier.toLowerCase()) {
            case "person status and compliance accordion search":
                wait(3);
                int counterpc = 0, totalpc = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    System.out.println(checkboxSize.size());
                    wait(2);
                    totalpc += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String personStatusElement = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[9]/div"))
                                .getText();
                        String complianceStatusElement = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div")).getText();
                        if (contains(searchValueScreeningComplianceStatus, complianceStatusElement) && contains(searchValuePersonStatus, personStatusElement)) {
                            counterpc++;
                        }

                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (counterpc == totalpc) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "person status and screening accordion search":
                wait(3);
                int counterScreening = 0, totalScreening = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(3);
                    checkboxAvailiable();
                    System.out.println(checkboxSize.size());
                    wait(2);
                    totalScreening += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String personStatusElement = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[9]/div"))
                                .getText();
                        String screeningStatusElement = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div")).getText();
                        if (contains(searchValueScreeningComplianceStatus, screeningStatusElement) && contains(searchValuePersonStatus, personStatusElement)) {
                            counterScreening++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (counterScreening == totalScreening) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            default:
                break;
        }
    }

    @And("^I validate \"([^\"]*)\" search results for Program Owner$")
    public void programOwnerSearchResults(String criteria) {
        switch (criteria) {
            case "FN,LN,SSN":
                wait(3);
                int counterpc = 0, totalpc = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.FAIL, "No Result Found", true);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalpc += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String personName = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[2]"))
                                .getText();
                        String ssn = driver
                                .findElement(By.xpath("//*[@id='" + atributeValue + "']/td[7]")).getText().replaceAll("[*-]", "");
                        System.out.println(existingssnNumber);
                        if (existingssnNumber.length() > 1) {
                            if (personName.contains(existingFirstName) && personName.contains(existingLastName) && ssn.equals(existingssnNumber)) {
                                counterpc++;
                            }
                        } else {
                            if (personName.contains(existingFirstName) && personName.contains(existingLastName)) {
                                counterpc++;
                            }
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                }
                if (counterpc == totalpc) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            default:
                break;
        }
    }

    public boolean verifyProviderSearchResult(String searchValue) {
        List<WebElement> results = driver.findElements(By.xpath("//*[contains(@id,'panel')]"));
        int counter = 0;
        for (WebElement result : results) {
            if (result.getText().contains(searchValue)) {
                counter++;
            } else {
                reportLog(Status.FAIL, "Wrong provider search result", true);
            }
        }
        if (counter == results.size()) {
            return true;
        }
        return false;
    }

    @And("^I verify user not in Providers list returns No Results Found$")
    public void verifyProviderUserNotFound() throws Exception {
        String user = Random_StringGenerator(12);
        EnterText(nuiHomePage.providerSearch, "Random user entered", user);
        clickElement(nuiHomePage.searchIcon, "Search Icon on Providers page clicked");
        wait(2);
        if (verifyElementPresence(nuiHomePage.noResultFoundElement)) {
            reportLog(Status.PASS, "No results are found", false);
        } else {
            reportLog(Status.FAIL, "Results found", true);
        }
    }

    @And("^I verify hyperlink for \"([^\"]*)\" user$")
    public void verifyHyperlink(String user) {
        switch (user) {
            case "Admin Screening":
                wait(3);
                int countersc = 0, totalsc = 0;
                By popUpBackButton = (By.xpath("//modal-container//*[contains(text(),'Back')]"));
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalsc += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
//                        By accordion=By.xpath("//*[@id='" + atributeValue + "']/td[10]");
                        WebElement accordion = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[10]"));
                        WebElement providerName = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[2]"));
//                        clickOnElementUsingActions(accordion, "Accordion activated at index " + i);
                        clickElement(accordion, "Accordion activated at index " + i);
                        if (verifyComplianceScreeningHyperlinkActive(atributeValue)) {
//                            By hyperlink=By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a");
                            WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a"));
                            clickElement(hyperlink, "Hyperlink is clicked");
                            clickElement(popUpBackButton, "Hyperlink pop up activated and clicked Back");
                            countersc++;
                        } else {
                            try {
                                WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a"));
                                reportLog(Status.FAIL, "Hyperlink is displayed on invalid Element at" + i, true);
                            } catch (Exception e) {
                                System.out.println("Hyperlink Not Found for provider " + providerName.getText());
                                countersc++;
                            }
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickOnElementUsingActions(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }

                if (countersc == totalsc) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "Admin Compliance":
                wait(3);
                int countercm = 0, totalcm = 0;
                By popUpBackButtonCompliance = (By.xpath("//modal-container//*[contains(text(),'Back')]"));
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalcm += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        WebElement accordion = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[10]"));
                        clickElement(accordion, "Accordion activated at index " + i);
                        if (verifyComplianceScreeningHyperlinkActive(atributeValue)) {
                            WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div/div/a"));
                            clickElement(hyperlink, "Hyperlink is clicked");
                            clickElement(popUpBackButtonCompliance, "Hyperlink pop up activated and clicked Back");
                            countercm++;
                        } else {
                            try {
                                WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a"));
                                reportLog(Status.FAIL, "Hyperlink is displayed on invalid Element at" + i, true);
                            } catch (Exception e) {
                                System.out.println("Hyperlink Not Found at index " + i);
                                countercm++;
                            }
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }

                if (countercm == totalcm) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "Summary Screening":
                wait(3);
                int counterSummaryScreening = 0, totalSummaryScreening = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalSummaryScreening += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        try {
                            WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a"));
                            reportLog(Status.FAIL, "Hyperlink is displayed on invalid Element at" + i, true);
                        } catch (Exception e) {
                            System.out.println("Hyperlink Not Found at index " + i);
                            counterSummaryScreening++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }
                if (counterSummaryScreening == totalSummaryScreening) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "Summary Compliance":
                wait(3);
                int counterSummaryCompliance = 0, totalSummaryCompliance = 0;
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.PASS, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalSummaryCompliance += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        try {
                            WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div/div/a"));
                            reportLog(Status.FAIL, "Hyperlink is displayed on invalid Element at" + i, true);
                        } catch (Exception e) {
                            System.out.println("Hyperlink Not Found at index " + i);
                            counterSummaryCompliance++;
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }
                if (counterSummaryCompliance == totalSummaryCompliance) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "Provider Hyperlink":
                wait(3);
                int counterProvider = 0, totalProvider = 0;
                By popUpBackButtonProvider = (By.xpath("//modal-container//*[contains(text(),'Back')]"));
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.INFO, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalProvider += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String providerName = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[2]")).getText();
//                        WebElement accordion = driver.findElement(By.xpath("(//td[@class='table-arrow-container'])["+atributeValue+1+"]"));
                        By accordion = By.xpath("//*[@id='" + atributeValue + "']/td[10]");
                        clickOnElementUsingActions(accordion, "Accordion activated at index " + i);
//                        clickElement(accordion, "Accordion activated for Provider " + providerName);
                        if (verifyComplianceScreeningHyperlinkActive(atributeValue)) {
                            WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div/div/a"));
                            try {
                                clickElement(hyperlink, "Hyperlink is active for provider" + providerName);
                                clickElement(popUpBackButtonProvider, "Hyperlink pop up activated and clicked Back");
                                counterProvider++;
                            } catch (ElementClickInterceptedException e) {
                                reportLog(Status.INFO, "Element click intercepted", false);
                                clickElement(hyperlink, "Hyperlink is active for provider" + providerName);
                            }
                        } else {
                            try {
                                driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[3]/div/div/a"));
                                reportLog(Status.INFO, "Hyperlink is displayed on invalid Element at" + providerName, true);
                            } catch (Exception e) {
                                reportLog(Status.INFO, "Hyperlink Not Found at Order " + providerName, true);
                                counterProvider++;
                            }
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    System.out.println("SKIPPED IF STATEMENT!!!!!!!!!!!!!!!!");
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }

                if (counterProvider == totalProvider) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            case "Provider Hyperlink Screening":
                wait(3);
                int counterProviderScreenig = 0, totalProviderScreening = 0;
                By popUpBackButtonProviderScreening = (By.xpath("//modal-container//*[contains(text(),'Back')]"));
                if (verifyElementPresence(By.xpath("//*[text()='No Results Found']"))) {
                    reportLog(Status.INFO, "No Result Found", false);
                }
                while (true) {
                    wait(2);
                    checkboxAvailiable();
                    wait(2);
                    totalProviderScreening += checkboxSize.size();
                    for (int i = 0; i < checkboxSize.size(); i++) {
                        String atributeValue = "panel-" + i;
                        String providerName = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[2]")).getText();
//                        WebElement accordion = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[10]"));
                        By accordion = By.xpath("//*[@id='" + atributeValue + "']/td[10]");
                        clickOnElementUsingActions(accordion, "Accordion activated at index " + i);
//                        clickElement(accordion, "Accordion activated for Provider " + providerName);
                        if (verifyComplianceScreeningHyperlinkActive(atributeValue)) {
                            WebElement hyperlink = driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a"));
                            clickElement(hyperlink, "Hyperlink is active for provider" + providerName);
                            clickElement(popUpBackButtonProviderScreening, "Hyperlink pop up activated and clicked Back");
                            counterProviderScreenig++;
                        } else {
                            try {
                                driver.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[4]/div/div/a"));
                                reportLog(Status.INFO, "Hyperlink is displayed on invalid Element at" + providerName, true);
                            } catch (Exception e) {
                                reportLog(Status.INFO, "Hyperlink Not Found at Order " + providerName, true);
                                counterProviderScreenig++;
                            }
                        }
                    }
                    if (verifyElementPresence(nuiPeoplePage.nextPageButtonDisabled)) {
                        break;
                    }
                    clickElement(nuiPeoplePage.nextPageButton, "Next Page Button");
                    wait(2);
                }

                if (counterProviderScreenig == totalProviderScreening) {
                    reportLog(Status.PASS, "There are no unexpected results", false);
                } else {
                    reportLog(Status.FAIL, "Unexpected results", false);
                }
                break;
            default:
                break;
        }
    }

    public boolean verifyComplianceScreeningHyperlinkActive(String iterator) {
        By accordionTileProfile = By.xpath("//*[@id='" + iterator + "']/following-sibling::tr[@class='panel-content'][1]//span[contains(text(),'Profile')]");
        By accordionTileBackground = By.xpath("//*[@id='" + iterator + "']/following-sibling::tr[@class='panel-content'][1]//span[contains(text(),'Background')]");
        wait(2);
        if (verifyElementPresence(accordionTileProfile) && verifyElementPresence(accordionTileBackground)) {
            return true;
        }
        return false;
    }

    @Then("^Get URL Link from Api post$")
    public void get_url_link_from_api_post() throws Throwable {
        String VendorURL = "";
        VendorURL = cbr.getOrderandURL(ResponseXML);
        this.VendorApiURL = VendorURL;
        driver.get(VendorURL);
    }

    @Then("^Update AutoQcsa xml Order$")
    public void Update_AutoQcsa_xml_Order(DataTable values) throws Exception {

        List<List<String>> data = values.asLists();

        String xmlPath = data.get(1).get(0);
        String FirstName = data.get(1).get(1);
        String LastName = data.get(1).get(2);
//         String DateOfBirth = data.get(1).get(3);
//         String EmailAddress = data.get(1).get(4);
//         String GovernmentId = data.get(1).get(5);
//         String PositionLocation = data.get(1).get(6);
//         String PosLocCity = data.get(1).get(7);
//         String SSNFlag = data.get(1).get(8);
//         String NameType = data.get(1).get(9);
//         String Address1 = data.get(1).get(10);
//         String City = data.get(1).get(11);
//         String State = data.get(1).get(12);
//         String Zipcode = data.get(1).get(13);
//         String CountryCode="";
//         String Region="";
//         String Municipality="";
//         String SSNProvided="";


        if (FirstName.equalsIgnoreCase("YES")) {
            FirstName = _dataRepo.getData("first name") + Random_StringGenerator(8);
            existingFirstName = FirstName;
        }

        if (LastName.equalsIgnoreCase("YES")) {
            LastName = _dataRepo.getData("last name") + Random_StringGenerator(8);
            existingLastName = LastName;
        }

//         if(DateOfBirth.equalsIgnoreCase("YES")) {
//               DateOfBirth=_dataRepo.getData("DOB");
//               if (scenarioName.contains("BGD")) {
//                    paDOB=DateOfBirth;
//                    String day=DateOfBirth.substring(0,2);
//                    String month=DateOfBirth.substring(3,5);
//                    String year=DateOfBirth.substring(6);
//                        DateOfBirth=year+"-"+month+"-"+day;
//               }
//         }
//
//         if(EmailAddress.equalsIgnoreCase("YES")) {
//               EmailAddress=Random_StringGenerator(7) + "@mailinator.com";
//               EmailID=EmailAddress;
//
//
//         }
//
//         if(GovernmentId.equalsIgnoreCase("YES")) {
//               GovernmentId =CurrentDateTime.SystemDateYear()+Random_NumberGenerator(5);
//               SSN=GovernmentId;
//         }
//
//          if(PositionLocation.equalsIgnoreCase("YES")) {
//               CountryCode=_dataRepo.getData("CountryCode");
//               Region=_dataRepo.getData("StateSF");
//               Municipality=_dataRepo.getData("PACity");
//               paCountryCode=CountryCode;
//               paRegion=Region;
//               paMunicipality=Municipality;
//         }
//
//          if(PositionLocation.equalsIgnoreCase("YN")) {
//               CountryCode=_dataRepo.getData("CountryCode");
//               Region=_dataRepo.getData("StateSF");
//               Municipality=PosLocCity;
//         }
//
//          if(PositionLocation.equalsIgnoreCase("YNB")) {
//               CountryCode=_dataRepo.getData("CountryCode");
//               Municipality=_dataRepo.getData("PACity");
//         }
//
//         if (scenarioName.contains("BGD")) {
//
//               if(SSNFlag.equalsIgnoreCase("Y")) {
//                    SSNProvided=SSNFlag;
//               }
//
//               if(SSNFlag.equalsIgnoreCase("N")) {
//                    SSNProvided=SSNFlag;
//               }
//               if(Address1.equalsIgnoreCase("YES")) {
//                     paAddress1=_dataRepo.getData("Address");
//
//               }
//
//               if(City.equalsIgnoreCase("YES")) {
//                     paCity=_dataRepo.getData("City");
//
//               }
//
//               if(State.equalsIgnoreCase("YES")) {
//                     paState=_dataRepo.getData("StateSF");
//
//               }
//
//               if(Zipcode.equalsIgnoreCase("YES")) {
//                     paZipCode=_dataRepo.getData("ZipCode");
//
//               }
//               if (countryPA==null) {
//                     countryPA=_dataRepo.getData("Country");
//               }

        //      cxu.PABGApiOrder(xmlPath, FirstName, LastName, DateOfBirth, EmailAddress, GovernmentId, CountryCode, Region, Municipality, SSNProvided, NameType, paAddress1, paCity, paState, paZipCode);
        cxu.ApiOrder(xmlPath, FirstName, LastName);
    }

    @And("^I validate \"([^\"]*)\" for \"([^\"]*)\" Page$")
    public void iValidateForPage(String element, String pageName) throws Exception {
        switch (element.toLowerCase()) {
            case "password":
                nuiAdministrationPage.passwordValidation();
                break;
            case "required fields":
                nuiAdministrationPage.fieldValidation();
                break;
            case "active people number":
                nuiProgramOwner.activePeopleNumber();
                break;
            case "accordion":
                nuiProgramOwner.accordionValidation();
            default:
                break;
        }
    }

    @And("^Validate \"([^\"]*)\" Search Table columns$")
    public void validateProgramOwnerSearchTableColumns(String pageName) throws Exception {
        nuiProgramOwner.tableValidation(pageName);
    }

    @And("^I set \"([^\"]*)\" to \"([^\"]*)\" for \"([^\"]*)\" Page$")
    public void iSetToForPage(String element, String value, String pageName) throws Throwable {
        switch (element.toLowerCase()) {
            case "provider status":
                nuiProgramOwner.setProviderStatus(value);
                break;
            default:
                break;
        }
    }

    @And("^I GET total number of People without filter for \"([^\"]*)\"$")
    public void iGETTotalNumberOfPeopleWithoutFilterFor(String pageName) throws Throwable {
        api.getTotalNumberOfPeopleWithoutFilter(pageName);
    }

    @And("^I GET total number of People for \"([^\"]*)\" filter for \"([^\"]*)\"$")
    public void iGETTotalNumberOfPeopleForFilterFor(String filter, String pageName) throws Throwable {
        api.getTotalNumberOfPeopleWithFilter(filter, pageName);
    }

    @And("^I GET total number of People for \"([^\"]*)\" \"([^\"]*)\" filter for \"([^\"]*)\"$")
    public void iGETTotalNumberOfPeopleForFilterFor(String status, String filter, String pageName) throws Throwable {
        api.getTotalNumberOfPeopleWithFilter(status, filter, pageName);
    }

    @And("^I Validate \"([^\"]*)\" Filter for \"([^\"]*)\" Page$")
    public void iValidateFilterForPage(String filter, String pageName) throws Throwable {
        nuiProgramOwner.validateFilter(filter, pageName);
    }

    @And("^I Validate no Filter for \"([^\"]*)\" Page$")
    public void iValidateNoFilterForPage(String pageName) throws Throwable {
        nuiProgramOwner.validateNoFilter(pageName);

    }

    @And("^I search for Provider \"([^\"]*)\"$")
    public void iSearchForProvider(String providerName) {
        if (providerName.equalsIgnoreCase("unique")) {
            EnterText(programOwnerWorkflowPeoplePage.providerSearchBar, "Provider Search Bar", uniqueVendorLengthOfService);
            clickElement(programOwnerWorkflowPeoplePage.searchIcon, "Search Icon On Provider Page");
            reportLog(Status.PASS, "Provider " + uniqueVendorLengthOfService + " found!", false);
            logStepInfo("Provider " + uniqueVendorLengthOfService + " found!");
        } else {
            EnterText(programOwnerWorkflowPeoplePage.providerSearchBar, "Provider Search Bar", "Pradeepnithin");
            clickElement(programOwnerWorkflowPeoplePage.ActivePeopleProviderQCSAVC, "Active people hyperlink");
        }
    }

    @And("^I update credentials status to \"([^\"]*)\" for default vendor$")
    public void iUpdateCredentialsStatusToForDefaultVendor(String status) throws Exception {
        databaseClass.updateCredentialsStatus(status);
    }

    @And("^I search for provider$")
    public void iSearchForProvider() {
        WebElement providerSearch = driver.findElement(By.xpath("//*[@id='panel-29']/td[9]/div"));
        providerName = providerSearch.getText().trim();
        DatabaseClass.providerName = providerSearch.getText().trim();
        reportLog(Status.INFO, "Provider selected: " + providerNamePeopleSearch, false);
        By providerSearchPeople = By.xpath("//*[@id='filter-container']/div[3]/div/div[1]/input");
        EnterText(providerSearchPeople, "Provider Search Bar", providerName);
        Actions keyEnter = new Actions(driver);
        keyEnter.sendKeys(Keys.chord(Keys.ENTER)).perform();
    }

    @And("^I verify the provider results$")
    public void iVerifyTheProviderResults() {
        int page = 0;
        By providerNames = By.xpath("//td[8]");
        while (true) {
            waitUntilPageIsRefreshed(providerNames);
            List<WebElement> results = driver.findElements(providerNames);
            for (WebElement result : results) {
                if (!providerName.equals(result.getText())) {
                    reportLog(Status.FAIL, "Invalid Provider" + result.getText(), true);
                    break;
                }
            }
            reportLog(Status.PASS, "All results are valid at page " + page, false);
            if (verifyElementPresenceBoolean(nuiPeoplePage.nextPageButtonDisabled, "There are no more pages left")) {
                break;
            }
            clickElementJS(nuiPeoplePage.nextPageButton, "Next Page Button is clicked");
            waitUntilPageIsRefreshed(providerNames);
            page++;
        }
        reportLog(Status.PASS, "All providers match " + providerName, false);
    }

    @And("^I store data$")
    public void iStoreData() {
        boolean status = true;
        waitForPageToLoad();
        values.clear();
        List<WebElement> elements = driver.findElements(nuiPeoplePage.tableRow);
        elements.forEach(x -> values.add(x.getText()));
        List<String> tryList = new ArrayList<>();
        while (nuiPeoplePage.pageHasNext()) {
            clickOnElementUsingActions(nuiPeoplePage.nextPageButton, "Next Page Button is clicked");
            waitForPageToLoad();
            List<WebElement> elementsCurrent = driver.findElements(By.xpath("//tr[contains(@id,'panel')]"));
            elementsCurrent.forEach(x -> values.add(x.getText()));
        }
    }

    public void iterateThroughPages() {
        while (!verifyElementPresenceBoolean(nuiPeoplePage.nextPageButtonDisabled, "Verifying pages left")) {
            clickElementJS(nuiPeoplePage.nextPageButton, "Next Page Button is clicked");
            waitForPageToLoad();
        }
    }

    @And("^I verify Compliance or Screening Status is \"([^\"]*)\"$")
    public void iVerifyComplianceScreeningStatusIs(String status) {
        int statusNumber = 0;
        int index = 0;
        String wrongStatus = " ";
        for (int i = 0; i < values.size(); i++) {
            if (status.contains(values.get(i).split("\\r?\\n")[1])) {
                statusNumber++;
            } else {
                index = i;
                wrongStatus = values.get(i).split("\\r?\\n")[1].trim();
                reportLog(Status.FAIL, "Statuses are NOT inline with query at index " + index + " with status " + wrongStatus, false);
                break;
            }
        }
        if (statusNumber == values.size()) {
            reportLog(Status.PASS, "All statuses are inline with query", false);
        } else {
            reportLog(Status.FAIL, "Statuses are NOT inline with query", false);
        }
    }

    @And("^I search for Credit card \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void iSearchForCreditCard(String card, String number, String expiry) {
        ccType = card;
        ccNumberEnding = number;
        ccExypiry = expiry;
    }

    @When("^Set \"([^\"]*)\" to \"([^\"]*)\" for \"([^\"]*)\" Customer$")
    public void setToForCustomer(String property, String value, String custID) throws Throwable {
        api.setAdminToolProperty(property, value, custID);
    }

    @And("^Get \"([^\"]*)\" from API$")
    public void getFromAPI(String value) throws Exception {
        api.getDataForUser(value);
    }

    @And("^I click on \"([^\"]*)\" filter pill on People Page$")
    public void iClickOnFilterPillOnPeoplePage(String Status) {
        By filterPill = By.xpath("//button[@class='filter-pill' and text()='" + Status + " " + "']");
        clickElement(filterPill, "Filter pill " + Status + " has been clicked and removed");
    }


    @Then("^Set Site Credit \"([^\"]*)\"$")
    public void setSiteCredit(String siteCreditState) throws Exception {
        if (siteCreditState.equalsIgnoreCase("OFF"))
            databaseClass.setSiteCreditToZero(siteCreditState);
        else if (siteCreditState.equalsIgnoreCase("ON"))
            databaseClass.rollbackSiteCreditState(siteCreditState);
        else if (siteCreditState.equalsIgnoreCase("PartialAmount"))
            databaseClass.partialSiteCredit(siteCreditState);
        else
            System.out.println("Invalid Site Credit State!!");
    }

    /**
     * @param custID
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     * @author prsatomi
     * Gets unique vendor from a specific customer using the customers id
     */
    @And("^I get a unique provider from Customer \"([^\"]*)\"$")
    public void iGetAUniqueProviderFromCustomer(int custID) throws SQLException, IOException, ClassNotFoundException {
        this.custID = custID;
        uniqueVendorLengthOfService = databaseClass.uniqueVendorDB(custID);
        reportLog(Status.PASS, "Unique Provider " + uniqueVendorLengthOfService + " found!", false);
        logStepInfo("Unique Provider " + uniqueVendorLengthOfService + " found!");
    }

    /**
     * @param status- Person Status to which the current status will be changed, options are:
     *                Active,Applicant,Inactive,Terminated
     * @author prsatomi
     * Changes Provider status of a specific provider using the Actions button on Provider Page
     */
    @And("^I change Provider Status to \"([^\"]*)\"$")
    public void iChangeProviderStatusTo(String status) {
        By providerPageActionButtonDropdownStatusLocal = By.xpath("//button[contains(@class,'dropdown-button')and contains(text(),'" + status + "')]");
        clickOnElementUsingActions(programOwnerWorkflowPeoplePage.checkboxProvider, "Checkbox on Provider Page");
        clickElement(programOwnerWorkflowPeoplePage.providerPageActionButton, "Provider Page Actions Button");
        clickElement(providerPageActionButtonDropdownStatusLocal, "Provider Page status" + status);
        reportLog(Status.PASS, "Provider Status changed to " + status, false);
        logStepInfo("Provider Status changed to " + status);
    }

    /**
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     * @author prsatomi
     * Sets variables startOfService and endOfService to current START_OF_SERVICE and END_OF_SERVICE Database columns of
     * specific vendor, in order for them to be used for comparison in iVerifyProviderLengthOfService() method
     */
    @And("^I set Provider Length of Service$")
    public void iVerifyCurrentProviderLengthOfService() throws SQLException, IOException, ClassNotFoundException {
        List<String> lengthOfService = databaseClass.lengthOfServiceDB(custID, uniqueVendorLengthOfService);
        startOfService = lengthOfServiceNotNull(lengthOfService.get(0));
        endOfService = lengthOfServiceNotNull(lengthOfService.get(1));
        logStepInfo("verifying current start and end date: Start Date:" + startOfService + " End Date: " + endOfService);
        reportLog(Status.INFO, "Start of service: " + startOfService + " End Of Service: " + endOfService, false);
    }


    @And("^I verify Provider Length of Service \"([^\"]*)\"$")
    public void iVerifyProviderLengthOfService(String path) throws Exception {
        List<String> lengthOfService = databaseClass.lengthOfServiceDB(custID, uniqueVendorLengthOfService);
        switch (path.toLowerCase()) {
            case "calculation active to applicant":
                String currentStartOfService = lengthOfServiceNotNull(lengthOfService.get(0));
                String currentEndOfService = lengthOfServiceNotNull(lengthOfService.get(1));
                if (startOfService.equalsIgnoreCase(currentStartOfService) && !endOfService.equalsIgnoreCase(currentEndOfService)) {
                    logStepInfo("Start of service: " + startOfService + " equals Current: " + currentStartOfService + " and End Of Service: " + endOfService + " isn't equal to Current: " + currentEndOfService);
                    reportLog(Status.PASS, "Start of service: " + startOfService + " equals Current: " + currentStartOfService + " and End Of Service: " + endOfService + " isn't equal to Current: " + currentEndOfService, false);
                } else {
                    logStepInfo("Start of service: " + startOfService + " isn't equal to Current: " + currentStartOfService + " and End Of Service: " + endOfService + " is equal to Current: " + currentEndOfService);
                    reportLog(Status.FAIL, "Start of service: " + startOfService + " isn't equal to Current: " + currentStartOfService + " and End Of Service: " + endOfService + " is equal to Current: " + currentEndOfService, true);
                    scenarioFailed();
                }
                break;
            case "calculation is the same":
                String sameCurrentStartOfService = lengthOfServiceNotNull(lengthOfService.get(0));
                String sameCurrentEndOfService = lengthOfServiceNotNull(lengthOfService.get(1));
                if (startOfService.equalsIgnoreCase(sameCurrentStartOfService) && endOfService.equalsIgnoreCase(sameCurrentEndOfService)) {
                    logStepInfo("Start of service: " + startOfService + " equals Current: " + sameCurrentStartOfService + "and End Of Service: " + endOfService + " equals Current: " + sameCurrentEndOfService);
                    reportLog(Status.PASS, "Start of service: " + startOfService + " equals Current: " + sameCurrentStartOfService + "and End Of Service: " + endOfService + " equals Current: " + sameCurrentEndOfService, false);
                } else {
                    logStepInfo("Start of service: " + startOfService + " isn't equal to Current: " + sameCurrentStartOfService + "and End Of Service: " + endOfService + " isn't equal to Current: " + sameCurrentEndOfService);
                    reportLog(Status.FAIL, "Start of service: " + startOfService + " isn't equal to Current: " + sameCurrentStartOfService + "and End Of Service: " + endOfService + " isn't equal to Current: " + sameCurrentEndOfService, true);
                    scenarioFailed();
                }
                break;
            case "calculation has stopped":
                String stoppedCurrentStartOfService = lengthOfServiceNotNull(lengthOfService.get(0));
                String stoppedCurrentEndOfService = lengthOfServiceNotNull(lengthOfService.get(1));
                if (stoppedCurrentStartOfService.equalsIgnoreCase("null") && stoppedCurrentEndOfService.equalsIgnoreCase("null")) {
                    logStepInfo("Start of service: " + startOfService + " isn't equal to Current: " + stoppedCurrentStartOfService + " and End Of Service: " + endOfService + " isn't equal to Current: " + stoppedCurrentEndOfService);
                    reportLog(Status.PASS, "Start of service: " + startOfService + " isn't equal to Current: " + stoppedCurrentStartOfService + " and End Of Service: " + endOfService + " isn't equal to Current: " + stoppedCurrentEndOfService, false);
                } else {
                    logStepInfo("Start of service: " + startOfService + " is equal to Current: " + stoppedCurrentStartOfService + " and End Of Service: " + endOfService + " is equal to Current: " + stoppedCurrentEndOfService);
                    reportLog(Status.FAIL, "Start of service: " + startOfService + " is equal to Current: " + stoppedCurrentStartOfService + " and End Of Service: " + endOfService + " is equal to Current: " + stoppedCurrentEndOfService, true);
                    scenarioFailed();
                }
                break;
            case "calculation has started from null":
                String startedCurrentStartOfService = lengthOfServiceNotNull(lengthOfService.get(0));
                String startedCurrentEndOfService = lengthOfServiceNotNull(lengthOfService.get(1));
                String lengthOfServiceTableValue = driver.findElement(programOwnerWorkflowPeoplePage.providerPageLengthOfService).getText();
                if (!startOfService.equalsIgnoreCase(startedCurrentStartOfService) && endOfService.equalsIgnoreCase("null") && lengthOfServiceTableValue.contains("1 month")) {
                    logStepInfo("Start of service: " + startOfService + " isn't equal to Current: " + startedCurrentStartOfService + " and End Of Service: " + endOfService + " equals Current: " + startedCurrentEndOfService);
                    logStepInfo("Length of service is showing 1 month");
                    reportLog(Status.PASS, "Start of service: " + startOfService + " isn't equal to Current: " + startedCurrentStartOfService + " and End Of Service: " + endOfService + " equals Current: " + startedCurrentEndOfService + " and is showing 1 month on UI", false);
                } else {
                    logStepInfo("Start of service: " + startOfService + "is equal to Current: " + startedCurrentStartOfService + " and End Of Service: " + endOfService + " isn't equal to Current: " + startedCurrentEndOfService);
                    logStepInfo("Length of service isn't showing 1 month");
                    reportLog(Status.FAIL, "Start of service: " + startOfService + "is equal to Current: " + startedCurrentStartOfService + " and End Of Service: " + endOfService + " isn't equal to Current: " + startedCurrentEndOfService + " and isn't showing 1 month on UI", true);
                    scenarioFailed();
                }
                break;
            case "calculation has started from beginning":
                String startedCurrentStartOfServiceNew = lengthOfServiceNotNull(lengthOfService.get(0));
                String startedCurrentEndOfServiceNew = lengthOfServiceNotNull(lengthOfService.get(1));
                String lengthOfServiceTableValueNew = driver.findElement(programOwnerWorkflowPeoplePage.providerPageLengthOfService).getText();
                if (!startedCurrentStartOfServiceNew.equals("null") && !endOfService.equalsIgnoreCase(startedCurrentEndOfServiceNew) && lengthOfServiceTableValueNew.contains("1 month")) {
                    logStepInfo("Start of service: " + startOfService + " is more or equal to Current: " + startedCurrentStartOfServiceNew + " and End Of Service: " + endOfService + " isn't equal Current: " + startedCurrentEndOfServiceNew);
                    logStepInfo("Length of service is showing 1 month");
                    reportLog(Status.PASS, "Start of service: " + startOfService + " is more or equal to Current: " + startedCurrentStartOfServiceNew + " and End Of Service: " + endOfService + " isn't equal Current: " + startedCurrentEndOfServiceNew + " and is showing 1 month on UI", false);
                } else {
                    logStepInfo("Start of service: " + startOfService + "is less than Current: " + startedCurrentStartOfServiceNew + " and End Of Service: " + endOfService + " is equal to Current: " + startedCurrentEndOfServiceNew);
                    logStepInfo("Length of service isn't showing 1 month");
                    reportLog(Status.FAIL, "Start of service: " + startOfService + "is less than Current: " + startedCurrentStartOfServiceNew + " and End Of Service: " + endOfService + " is equal to Current: " + startedCurrentEndOfServiceNew + " and isn't showing 1 month on UI", true);
                    scenarioFailed();
                }
                break;
            default:
                throw new Exception("Wrong provider Length Of Service Calculation Case");
        }
    }

    public String lengthOfServiceNotNull(String result) {
        if (result == null) {
            return "null";
        }
        return result.split(" ")[0];
    }

    /**
     * @param hyperlink-hyperlink which is supposed to be opened via Story
     * @author prsatomi
     * Verifies current open hyperlink(hyperlinkURL) with the planned hyperlink(hyperlink)
     */
    @And("^I verify hyperlink URL \"([^\"]*)\"$")
    public void iVerifyHyperlinkURL(String hyperlink) {
        if (hyperlinkURL.contains(hyperlink)) {
            reportLog(Status.PASS, "Hyperlink is verified", false);
            logStepInfo("Hyperlink " + hyperlink + " matches " + hyperlinkURL);
        } else {
            logStepInfo("Hyperlink " + hyperlink + " does not match " + hyperlinkURL);
            reportLog(Status.FAIL, "Hyperlink is incorrect", true);
        }
    }

    /**
     * @param personStatus-discerns which person status will be queried for
     * @throws Exception
     * @author prsatomi
     * Invokes a GET method which returns the totaln number of individulas under a specific person status,
     * options are:"needsReview","nonCompliant","compliant","inProgress"
     */
    @And("^I GET dashboard query numbers for \"([^\"]*)\"$")
    public void iGETDashboardQueryNumbersFor(String personStatus) throws Exception {
        api.getDasboardResults(personStatus);
    }

    @And("^I search for Provider on Admin Page$")
    public void iSearchForProviderOnAdminPage() {
        EnterText(nuiAdministrationPage.firstNameText, "First Name Field Administration", existingFirstName);
        EnterText(nuiAdministrationPage.lastNameText, "Last Name Field Administration", existingLastName);
        EnterText(nuiAdministrationPage.emailText, "Email Field Administration", existingEmail);
        clickElement(nuiAdministrationPage.searchButton, "Administration Page Search Button");
    }

    @And("^I search for xtdconnect order on people Page$")
    public void iSearchForxtdconnectorderonpeoplePage() {
        String firstName = _dataRepo.getData("FirstName");
        String lastName = _dataRepo.getData("LastName");
        String SSN = _dataRepo.getData("SSN");

        EnterText(nuiPeoplePage.firstName, "First Name Field people", firstName);
        EnterText(nuiPeoplePage.lastName, "Last Name Field people", lastName);
        EnterText(nuiPeoplePage.sSN, "Email Field people", SSN);
        clickElement(nuiPeoplePage.serachButton, "People Page Search Button");
    }

    @And("^I should validate \"([^\"]*)\" button is clickable on \"([^\"]*)\" Page$")
    public void ishouldvalidatesomethingbuttonisclickableonsomethingpage(String value, String pageName) throws Throwable {
        if (pageName.equalsIgnoreCase("xtdConnect")) {
            nuiCommon.ClickableButton(value, pageName);
        } else {
            System.out.println("Invalid page Name Entered!!!!");
        }
    }

    @And("^I should see \"([^\"]*)\" textbox for \"([^\"]*)\" value on \"([^\"]*)\" Page NewUI$")
    public void ishouldseesomethingvalueforsomethingtextboxonsomethingpagenewui(String textFields, String value, String pageName) throws Throwable {
        if (textFields.equalsIgnoreCase("FirsName")) {
            nuiCommon.isInputFieldPrepopulated(value, _dataRepo.getData("FirstName"), pageName);
        } else if (textFields.equalsIgnoreCase("LastName")) {
            nuiCommon.isInputFieldPrepopulated(value, _dataRepo.getData("LastName"), pageName);
        } else {
            System.out.println("Invalid text field Entered!!!!");
        }

    }

}



