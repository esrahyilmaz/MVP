package seleniumhelper;

import Report.ReportUtils;
import Utility.CurrentDateTime;
import Utility.PropertyFileReader;
import Utility.ReportUpload;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import helpers.EventListener;
import helpers.ReportHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sridharbandi.HtmlCsRunner;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.aventstack.extentreports.Status.*;
import static org.testng.Assert.fail;

//************************ MINDTREE QA AUTOMATION TEAM **************************************//

public class BaseClass extends CurrentDateTime {

	public static String AccessibilityReport;
	public static HtmlCsRunner htmlCsRunner;
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(BaseClass.class.getName());
	public static int counter;
	public static int screenshotCounter;
	public String screenshotPath;
	protected static String reportPath = null;
	protected static String reportPathDir = null;
	public static String scenarioName;
	public static String DB;
	public static String CustomerName;
	public static String CustomerURL;
	public static String URL;
	public static String taxableState;
	public static String propertyValueAT;
	public static String propertyValue;
	public static String propertyValuePM;
	public static String SSN;
	public static String ssn = "";
	public static String principalLegalFirstName = "";
	public static String principalLegalLastName = "";
	public static String FirstName = "";
	public static String LastName = "";
	public static String CrewFirstName = "";
	public static String CrewLastName = "";
	public static String OrderID;
	public static String WebURL;

	public static String providerName;
	public static String providerAddress1;
	public static String providerAddress2;
	public static String providerCity;
	public static String providerState;
	public static String providerZipCode;
	public static String providerCountry;

	public static String peopleSearchWithoutFilter;
	public static String peopleSearchWithFilter;

	public static String OrderRefID;
	public static String PeopleID;
	public static String ResponseXML;
	public static String Firstname;
	public static String Lastname;
	public static String EmailBody;
	public static String DigitalBadgeLink;
	public static String BatchFirstName;
	public static String pANewFirstName;
	public static String pANewLastName;
	public static String pANewMiddleName;

	public static String existingFirstName;
	public static String existingLastName;
	public static String existingMiddleName;
	public static String existingFullName;
	public static String existingssnNumber;
	public static String existingphoneNumber;
	public static String existingEmail;
	public static String existingSSN;
	public static String existingName;
	public static String existingUserID;
	public static String existingPassword;
	public static String existingPassVal;
	public static String existingRole;
	public static String existingStatus;
	public static String existingCountry;
	public static String existingCity;
	public static String existingState;

	public static String ccNumber;
	public static String ccMonth;
	public static String ccYear;
	public static String ccNumberEnding;
	public static String ccType;
	public static String ccExypiry;
	public static String ccNumberMask;
	public static double siteCreditAmount;
	public static Integer siteCreditOrderID;

	public static String exisingDoingBusinessAs;
	public static String existingBusinessContactEmail;
	public static String existingBusinessDesc;
	public static String existingBusinesContactName;
	public static String existingBusinesContactFirstName;
	public static String existingBusinesContactLastName;
	public static String existingBusinesContactCountry;
	public static String existingBillingContactName;
	public static String existingBusinesContactCode;
	public static String existingBusinesContactPN;
	public static String existingBusinessTitle;
	public static String existingBusinessName;
	public static String existingBusinessAddress;
	public static String existingBusinessInfoCountry;
	public static String existingBusinessInfoAddress;
	public static String existingBusinessInfoCity;
	public static String existingBusinessInfoState;
	public static String existingBusinessInfoZip;

	public static String existingUserProfileFirstName;
	public static String existingUserProfileLastName;
	public static String existingUserProfileEmail;
	public static String existingQuestions;
	public static String existingAnswers;

	public static String userFirstName;
	public static String userNameLogin;
	public static String profileId;
	public static String searchText;
	public static String searchTextFN;
	public static String searchTextLN;
	public static String searchTextMN;

	public static String searchTextEmail;
	public static String searchTextSsn;
	public static String outstandingTotal;
	public static String TransactionID;
	public static String InvoiceNO;
	public static String CurrentPasswordUser;
	public static String UserIDUserAdmin;
	public static String UserIDUserSummary;
	public static String UserIDUserUpdate;
	public static String UserIDUserView;
	public static String crwValue;
	public static String LocationID;
	public static String LocationIDold;
	public static String valuefromUI;
	public static String QRcodeUUID;
	public static String AdditionalBilling;
	public static String BadgeNumber;
	public static String DigitalOptional;
	public static String VendorID;
	public static String VendorName;
	public static String VendorIDold = "";
	public static String VendorIDold2 = "";
	public static String CreditCardInput;
	public static String CreditCardOutput;
	public static String TotalAmount;
	public static String TaxAmount;
	public static String taxProperty;
	public static String ActualCard;
	public static String ShoppingCart;
	public static String VendorNameNonHD;
	public static String VendorLastNameNonHD;
	public static String EmailID;
	public static String vendorEmail;
	public static ExtentTest test;
	public static ExtentReports report;
	public static String ReportScenarioDirectory;
	public static String ReportpathServer;
	public static String ReportpathLocal;
	public static String ReportStatus;
	public static String userName;
	public static String password;
	public static String packageName;
	public static String packagePrice;
	public static String additionalBillingPrice;
	public static String additionalBillingFlag;
	public static String orderTotal;
	public static String vendorStateCd;
	public static String HomePage;
	public static String EAsearch;
	public static String CaseSearch;
	public static String CaseQueue;
	public static String GlobalSearch;
	public static String NonCircun;
	public static String Circum;
	public static String Manual;
	public static String NotificationSubject;
	public static String NotificationEmail;
	public static String LeagalBusinessName;
	public static String AgreementfilePath;
	public static String EmaillogfilePath;
	public static String NotificationUserFirstName;
	public static String NotificationUserLastName;
	public static String NotificationUserEmail;
	public static String NotificationOrderDate;
	public static String NotificationComplianceStatus;
	public static String NotificationPackageName;
	public static String sendBadgeStatus;
	public static String CrTPassword;
	public static String SecretQuestion;
	public static String SecretAnswer;
	public static String PAOutputLog;
	public static String PAInviteLink;
	public static String VendorApiLink;
	public static String countryPA;
	public static String paAddress1;
	public static String paZipCode;
	public static String paState;
	public static String paCity;
	public static String paDOB;
	public static String paDate;
	public static String paCountryCode;
	public static String paRegion;
	public static String paMunicipality;
	public static String CustID;
	public static String Promocode1;
	public static String Promocode2;
	public static String adopAndSign;
	public static String ScreenShotpathServer;
	public static String ScreenShotpathLocal;
	public static String ReportScreenShotDirectory;

	public static String adminToolCookies = "";

	public By SecretAnswerTB = By.xpath("//input[@name='userRecertSecretAnswer']");
	public By RectifyBTN = By.xpath("//input[@value='RECERTIFY']");

	Map<String, Object> prefs = new HashMap<String, Object>();
	ChromeOptions options = new ChromeOptions();
	JavascriptExecutor javaScriptExecutor=(JavascriptExecutor) driver;

	public static EventFiringWebDriver eventFiringWebDriver;
	public static EventListener eventListener;

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public BaseClass() {
		try {
			PropertyConfigurator
					.configure(System.getProperty("user.dir") + PropertyFileReader.getProperty("log4j.path"));
		} catch (IOException e) {
			reportLog(FAIL, e.getMessage(), false);


		}
	}

	public static EventFiringWebDriver setEventDriver() {
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		setEventListener(eventFiringWebDriver);
		return eventFiringWebDriver;
	}


	public static void setEventListener(EventFiringWebDriver eventFiringWebDriver) {
		// Create an instance of your event listener class
		eventListener = new EventListener();

		// Register the event listener
		eventFiringWebDriver.register(eventListener);
	}

	/********* report information *********************************/
	public void initReportDir() {
		try {
			/*ReportWriter report=new ReportWriter();
			report.createReport();*/
			String reportDir = System.getProperty("user.dir") + "\\extentreport-results";
			reportPathDir = reportDir + "\\" + getDate();
			reportPath = reportPathDir + "\\Report_" + getTime();
			createFolder(reportPath);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function initReportDir(): " + e.getMessage());
			reportLog(FAIL, "Failed to create report directory: " + e.getMessage(), false);
			scenarioFailed();
		}
	}

	public void createFolder(String path) {
		// File file = new
		// File(System.getProperty("user.dir")+"//target//Reports//"+ReportUtils.getDate());
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Folder is created!");
			}
		} else {
			System.out.println("Failed to create folder!");
		}
	}

	public static void reportInfo(String message) {
		System.out.println(message);
		Reporter.log(message);

	}

	/******* report fail ********************************************/
	public static void reportFail(String message) {
		System.out.println("Fail:" + message);
		Reporter.log("Fail: " + message);
	}

	public void logStepInfo(String message) {
		counter++;
		logger.info("Step " + counter + ")" + message);
	}

	public void reportLog(Status status, String message, boolean screenshot) {
		try {
			String UploadScreenShot = PropertyFileReader.getProperty("UploadScreenShot");
			if (UploadScreenShot.equalsIgnoreCase("YES")) {
				if (screenshot) {
					wait(1);
					String sPath = takeScreenshot();
					ScreenShotpathLocal = sPath;
					ReportUtils.repLog.log(status, "<a href='" + sPath + "'>" + message + "</a>");
					String repoStatus = status.toString();
					if (repoStatus.equalsIgnoreCase("PASS")) {
						test.log(PASS, "<a target = '_blank' href='" + ScreenShotpathServer + "'>" + message + "</a>");
					} else if (repoStatus.equalsIgnoreCase("FAIL")) {
						test.log(FAIL, "<a target = '_blank' href='" + ScreenShotpathServer + "'>" + message + "</a>");
					} else if (repoStatus.equalsIgnoreCase("INFO")) {
						test.log(INFO, "<a target = '_blank' href='" + ScreenShotpathServer + "'>" + message + "</a>");
					}
					ReportUpload.uploadScreenShotToServer();
				} else {
					ReportUtils.repLog.log(status, message);
					String repoStatus = status.toString();
					if (repoStatus.equalsIgnoreCase("PASS")) {
						test.log(PASS, message);
					} else if (repoStatus.equalsIgnoreCase("FAIL")) {
						test.log(FAIL, message);
					} else if (repoStatus.equalsIgnoreCase("INFO")) {
						test.log(INFO, message);
					}
				}
			} else {
				if (screenshot) {
					wait(1);
					String sPath = takeScreenshot();
					ReportUtils.repLog.log(status, "<a href='" + sPath + "'>" + message + "</a>");
				} else {
					ReportUtils.repLog.log(status, message);
				}
				String repoStatus = status.toString();
				if (repoStatus.equalsIgnoreCase("PASS")) {
					test.log(PASS, message);
				} else if (repoStatus.equalsIgnoreCase("FAIL")) {
					test.log(FAIL, message);
				} else if (repoStatus.equalsIgnoreCase("INFO")) {
					test.log(INFO, message);
				}
			}

		} catch (Exception e) {
			logStepInfo("Failed - Error in function reportLog(): " + e.getMessage());
			logStepInfo(message);
			reportLog(FAIL, "Failed - Error in function reportLog() - check logs for more details : " + e.getMessage(), false);
		}
	}


	/**
	 * Chrome Browser Initialization
	 */
	public void initBrowser(String _browser, String scenarioName) {
		try {
			ReportUtils.createScenario(scenarioName);
			switch (_browser) {
				case "Chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					//    		options.setHeadless(true);
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + PropertyFileReader.getProperty("chromeDriver.path"));
					driver = new ChromeDriver(options);
//				driver = new ChromeDriver();
					driver = setEventDriver();
//				eventFiringWebDriver.manage().window().setSize(new Dimension(1600,900));
//				eventFiringWebDriver.manage().window().fullscreen();
					//For accessibility testing
					htmlCsRunner = new HtmlCsRunner(driver);
					logStepInfo("Chrome Browser Opened Successfully - " + _browser);
					reportLog(PASS, "Chrome Browser Opened Successfully - " + _browser, false);
					break;
				case "Firefox":
					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir") + PropertyFileReader.getProperty("firefoxDriver.path"));
					driver = new FirefoxDriver();
					setEventDriver();
					eventFiringWebDriver.manage().window().maximize();
					logStepInfo("Firefox Browser Opened Successfully - " + _browser);
					reportLog(PASS, "Firefox Browser Opened Successfully - " + _browser, false);
					break;
				case "Internet Explorer":
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + PropertyFileReader.getProperty("IEDriver.path"));
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
					logStepInfo("Internet Explorer Browser Opened Successfully - " + _browser);
					reportLog(PASS, "Internet Explorer Browser Opened Successfully - " + _browser, false);
				break;
			default:
				logStepInfo("Incorrect browser info provided. - " + _browser
						+ ". Please check for the supported browser details.");
				scenarioFailed();
				break;
			}

		} catch (Exception e) {
			logStepInfo("Failed - Error in function initBrowser(): " + e.getMessage());
			reportLog(FAIL, "Failed to open browser" + e.getMessage(), true);
			scenarioFailed();
		}

	}

	public void loadUrl(String url) {
		try {
			driver.get(url);
			logStepInfo("Navigated to url - " + url);
			reportLog(PASS, "Navigated To Application", false);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function loadUrl():" + e.getMessage());
			reportLog(FAIL, "Unable to Launch url - " + url + "error message is ::" + e.getMessage(), false);
			scenarioFailed();
		}
	}

	/**
	 * ***********Click to Element Method *******************
	 */

	public WebElement createElement(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
			return ele;
		} catch (Exception e) {
			logStepInfo("Failed - Error in function createElement(): " + e.getMessage());
			reportLog(FAIL,
					"Failed - Error in function createElement() - check logs for more details" + e.getMessage(), false);
			return null;

		}
	}

	public void verifyElementText(By element, String text) {
		String actualText = "";
		try {
			actualText = createElement(element).getText();
			if (actualText.contains(text)) {
				reportLog(PASS, "Expected text is verified- " + text, true);
				logStepInfo("Expected text is verified " + text);
			} else {
				reportLog(FAIL, "Expected text is not verified- " + text, true);
				logStepInfo("Expected text is not verified " + text);
			}
//			logStepInfo("Expected text is verified " + text);
		} catch (Error e) {
			logStepInfo("Failed - Text is not matching : Expected- " + text + " and Actual- " + actualText);
			reportLog(FAIL, "Text is not matching - Expected- " + text + " and Actual- " + actualText
					+ "Error message is in : " + e.getMessage(), true);
			scenarioFailed();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function verifyElementText(): " + e.getMessage());
			reportLog(FAIL, "Failed - Error in function verifyElementText() - check logs for more details"
					+ " \n Error message is in" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	/**
	 * @throws Exception
	 * @author shekarcg
	 * @category verify element present by xpath
	 ***/
	public void verifyElementPresentClass(By element, String expectedAttribute) {
		String actualAttribute = "";
		try {
			actualAttribute = driver.findElement(element).getAttribute("class");
			Assert.assertTrue(expectedAttribute.contains(actualAttribute), "element is present");
			reportLog(PASS, "Expected element is verified" + expectedAttribute, true);
			logStepInfo("Expected text is verified" + expectedAttribute);
		} catch (Error e) {
			logStepInfo("Failed - Text is not matching : Expected- " + expectedAttribute + " and Actual- "
					+ actualAttribute);
			reportLog(FAIL, "Text is not matching - Expected- " + expectedAttribute + " and Actual- "
					+ actualAttribute + "Error Message:" + e.getMessage(), true);
			scenarioFailed();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function verifyElementText(): " + e.getMessage());
			reportLog(FAIL,
					"Failed - Error in function verifyElementText() - check logs for more details:" + e.getMessage(),
					true);
			scenarioFailed();
		}
	}

	/**
	 * @author shekarcg Created for validating Button value
	 **/

	public void verifyElementValue(By element, String text) {
		String actualText = "";
		try {
			actualText = createElement(element).getAttribute("value");
			System.out.println("actual text is ::" + actualText);
			Assert.assertTrue(actualText.contains(text), "Text Matched");
			reportLog(PASS, "Expected text is verified- " + text, true);
			logStepInfo("Expected text is verified" + text);
		} catch (Error e) {
			logStepInfo("Failed - Text is not matching : Expected- " + text + " and Actual- " + actualText);
			reportLog(FAIL, "Text is not matching - Expected- " + text + " and Actual- " + actualText, true);
			scenarioFailed();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function verifyElementText(): " + e.getMessage());
			reportLog(FAIL,
					"Failed - Error in function verifyElementText() - check logs for more details" + e.getMessage(),
					true);
			scenarioFailed();
		}
	}

	public void verifyElementLink(By element, String text) {
		String actualText = "";
		try {
			actualText = createElement(element).getText();
			System.out.println("actual text is ::" + actualText);
			Assert.assertTrue(actualText.contains(text), "Text Matched");
			reportLog(PASS, "Expected text is verified- " + text, true);
			logStepInfo("Expected text is verified" + text);
		} catch (Error e) {
			logStepInfo("Failed - Text is not matching : Expected- " + text + " and Actual- " + actualText);
			reportLog(FAIL, "Text is not matching - Expected- " + text + " and Actual- " + actualText, true);
			scenarioFailed();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function verifyElementText(): " + e.getMessage());
			reportLog(FAIL,
					"Failed - Error in function verifyElementText() - check logs for more details" + e.getMessage(),
					true);
			scenarioFailed();
		}
	}

	public void scrollDown(int range) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0," + range + ")");
			logStepInfo("Scroll Down the page By Range - " + range);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function scrollDown(): " + e.getMessage());
			reportLog(FAIL,
					"Failed - Error in function scrollDown() - check logs for more details" + e.getMessage(), false);
			scenarioFailed();
		}
	}

	public boolean verifyElementPresence(By element) {
		try {
//			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(10))
//					.pollingEvery(Duration.ofSeconds(1))
//					.ignoring(Exception.class);
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			boolean status = driver.findElement(element).isDisplayed();
			reportLog(PASS, "Expected Element is present", false);
			logStepInfo("Expected text is present");
			return status;

		} catch (Exception e) {
			reportLog(INFO, "Expected Element is not present", false);
			logStepInfo("Expected Element is not present");
			return false;

		}
	}
	public boolean verifyElementPresenceBoolean(By element, String outputMessage) {
		try {
//			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(10))
//					.pollingEvery(Duration.ofSeconds(1))
//					.ignoring(Exception.class);
//			WebDriverWait wait=new WebDriverWait(driver, 10);
//			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			boolean status = driver.findElement(element).isDisplayed();
			reportLog(PASS, outputMessage, false);
			logStepInfo(outputMessage);
			return status;

		} catch (Exception e) {
			reportLog(INFO, outputMessage, false);
			logStepInfo(outputMessage);
			return false;

		}
	}

	public boolean verifyElementPresence(WebElement parentElement, By childElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, childElement));
//			boolean status = result.isDisplayed();
			reportLog(PASS, "Expected Element is present", false);
			logStepInfo("Expected text is present");
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void verifyElementPresence(By element, String value) {
		try {

			boolean status = driver.findElement(element).isDisplayed();
			if (status) {
				reportLog(PASS, "Expected Element is present - " + value, false);
				logStepInfo("Expected Element is present " + value);
			} else {
				reportLog(INFO, "Expected Element is not present - " + value, false);
				logStepInfo("Expected Element is not present " + value);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickElementWithWaitJS(By ele, String value) {
		try {
			WebElement element = driver.findElement(ele);
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				reportLog(PASS, value + "  by JS Executer ", true);
				logStepInfo(value + "  by JS Executer ");
			} else {
				reportLog(FAIL, "Element not clicked by JS Executer " + value, true);
				logStepInfo("Failed-Element Not clicked by JS Executer " + value);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}


	public void clickElementWithWait(By element, String objName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			createElement(element).click();
			reportLog(PASS, "Click on " + objName, false);
			logStepInfo("Click on " + objName);
		}catch (ElementClickInterceptedException e) {
			wait(3);
			createElement(element).click();
			logStepInfo("ElementClickInterceptedException:" + e.getMessage());
			reportLog(FAIL, "ElementClickInterceptedException - " + objName + "Error message is::" + e.getMessage(), true);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function clickElementWithWait():" + e.getMessage());
			reportLog(FAIL, "Element not clicked - " + objName + "Error message is::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public void clickElement(By element, String objName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.findElement(element).click();
			reportLog(PASS, "Click on " + objName, false);
			logStepInfo("Click on " + objName);
		} catch (ElementClickInterceptedException e) {
			wait(3);
			driver.findElement(element).click();
			logStepInfo("ElementClickInterceptedException: " + e.getMessage());
			reportLog(INFO, "ElementClickInterceptedException - " + objName + "Error message is::" + e.getMessage(), true);
		}catch (Exception e) {
			logStepInfo("Failed - Error in function clickElement(): " + e.getMessage());
			reportLog(FAIL, "Element not clicked - " + objName + "Error message is::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public void clickElement(WebElement element, String objName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			reportLog(PASS, "Click on " + objName, false);
			logStepInfo("Click on " + objName);
		} catch (ElementClickInterceptedException e){
			wait(3);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			reportLog(PASS, "Element Click Intercepted,Click on " + objName, false);
			logStepInfo("Element Click Intercepted,Click on " + objName);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function clickElement(): " + e.getMessage());
			reportLog(FAIL, "Element not clicked - " + objName + "Error message is::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public void clickElementJS(By ele, String value) {

		try {
			WebElement element = driver.findElement(ele);
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				reportLog(PASS, value + "  by JS Executer ", true);
				logStepInfo(value + "  by JS Executer ");
			} else {
				reportLog(FAIL, "Element not clicked by JS Executer " + value, true);
				logStepInfo("Failed-Element Not clicked by JS Executer " + value);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}


	public void clickOnAccordionJS() {
		try {
//			WebDriverWait wait = new WebDriverWait (driver, 3);
//			wait.until(ExpectedConditions.visibilityOfAllElements());
			wait(2);
			((JavascriptExecutor) driver).executeScript("document.querySelector('#panel-0 > td.table-arrow-container').click()");
			reportLog(PASS, "Accordion clicked by JS Executer ", false);
			logStepInfo("Acc by JS Executer ");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			reportLog(FAIL, "Accordion NOT clicked by JS Executer ", false);
		}
	}


	/**
	 * ******************* SendKeys Method********************
	 *
	 * @param element
	 * @param objName
	 * @param value
	 */
	public void EnterText(By element, String objName, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
//			driver.findElement(element).clear();

			WebElement textField = driver.findElement(element);
			textField.sendKeys(Keys.CONTROL, Keys.chord("a"));
			textField.sendKeys(Keys.BACK_SPACE);
			textField.sendKeys(value);


			if (objName.contains("Password") || objName.contains("username")) {
				reportLog(PASS, "Enter value 'XXXXXXXXX' in " + objName, true);
			} else {
				reportLog(PASS, "Enter value '" + value + "' in " + objName, true);
			}

			logStepInfo("Enter value '" + value + "' in " + objName);

		} catch (Exception e) {
			logStepInfo("Failed - Error in function EnterText(): " + e.getMessage());
			reportLog(FAIL,
					"Value '" + value + "' not entered in element - " + objName + "Error message is::" + e.getMessage(),
					true);
			scenarioFailed();
		}
	}

	public void EnterTextWithoutDelete(By element, String objName, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			WebElement textField = driver.findElement(element);
			textField.sendKeys(value);

			if (objName.contains("Password") || objName.contains("username")) {
				reportLog(PASS, "Enter value 'XXXXXXXXX' in " + objName, true);
			} else {
				reportLog(PASS, "Enter value '" + value + "' in " + objName, true);
			}

			logStepInfo("Enter value '" + value + "' in " + objName);

		} catch (Exception e) {
			logStepInfo("Failed - Error in function EnterText(): " + e.getMessage());
			reportLog(FAIL,
					"Value '" + value + "' not entered in element - " + objName + "Error message is::" + e.getMessage(),
					true);
			scenarioFailed();
		}
	}

	/**
	 * Select dropdown value by visibletext
	 */

	public void selectDropDown(By element, String visibleText, String objName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			Select select = new Select(driver.findElement(element));
			select.selectByVisibleText(visibleText);
			reportLog(PASS, "Select '" + visibleText + "' from dropdown " + objName, true);
			logStepInfo("Select '" + visibleText + "' from dropdown " + objName);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function selectDropDown(): " + e.getMessage());
			reportLog(FAIL, "Failed to select '" + visibleText + "'from dropdown - " + objName
					+ "Error message is::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public void selectDropDownByValue(By element, String value, String objName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			Select select = new Select(driver.findElement(element));
			select.selectByValue(value);
			reportLog(PASS, "Select value '" + value + "' from dropdown " + objName, false);
			logStepInfo("Select value '" + value + "' from dropdown " + objName);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function selectDropDown(): " + e.getMessage());
			reportLog(FAIL, "Failed to select value '" + value + "'from dropdown - " + objName
					+ "Error message is::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public void selectDropDownByIndex(By element, String index, String objName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			Select select = new Select(driver.findElement(element));
			select.selectByIndex(Integer.valueOf(index));
			reportLog(PASS, "Select option '" + index + "' from dropdown " + objName, false);
			logStepInfo("Select option '" + index + "' from dropdown " + objName);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function selectDropDown(): " + e.getMessage());
			reportLog(FAIL, "Failed to select option '" + index + "'from dropdown - " + objName
					+ "Error message is::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	/**
	 * ********************Close Application and Browser*****************
	 */
	public void closeBrowser() {
		try {
			htmlCsRunner.execute();
			driver.quit();
			reportLog(INFO, "Browser Closed", false);
			logStepInfo("Browser Closed");
			ReportUtils.endScenario();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function closeBrowser(): " + e.getMessage());
			reportLog(FAIL, "Unable to Close Browser" + e.getMessage(), false);
		}

	}

	/**
	 * ***** Sleep Function*********
	 */

	public void thread(int time) {

		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Implicitly wait
	 */
	public void implicitlyWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
			logStepInfo("Wait for " + timeInSeconds + " seconds");
		} catch (Exception e) {
			logStepInfo("Failed - Error in function wait(): " + e.getMessage());
			reportLog(FAIL, "Failed - Error in function wait() - check logs for more details" + e.getMessage(),
					false);
		}
	}

	public void scenarioFailed() {
		wait(3);
		closeBrowser();
		Assert.fail();
	}

	/**
	 * Random String Generator
	 */
	public static String Random_StringGenerator(int length) {
		String Random = "";
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < length; i++) {
			double a = Math.random();
			int x = (int) (a * 100);

			if (x > 25 && x < 52) {
				x = x - 26;
			} else if (x > 51 && x < 78) {
				x = x - 52;
			} else if (x > 77 && x < 99) {
				x = x - 78;
			} else {
				x = 1;
			}

			char letter = abc.charAt(x);
			Random = Random + String.valueOf(letter);
		}
		return Random;

	}

	/**
	 * Random Number Generator
	 */
	public static String Random_NumberGenerator(int length) {
		double number, value;
		int len;
		number = Math.random();

		StringBuffer s = new StringBuffer(length);
		s.append("1");
		for (int k = 0; k < length; k++) {
			s.append("0");
		}

		value = Double.parseDouble(s.toString());

		number = number * value;
		int random = (int) (number);
		String randomno = Integer.toString(random);
		len = randomno.length();

		if (len < length) {
			int diff = length - len;
			StringBuffer s1 = new StringBuffer(randomno);
			for (int k = 0; k < diff; k++) {
				s1.append("0");
			}
			randomno = s1.toString();
		}

		return randomno;

	}

	/**
	 * @author shekarcg
	 * @category Take Screenshot Local
	 **/
	public String takeScreenshot() {
		try {


			screenshotCounter++;
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);


			screenshotPath = reportPath + "//screenshot_" + screenshotCounter + ".png";
			ScreenShotpathServer = PropertyFileReader.getProperty("ReportpathServer") + ReportScreenShotDirectory + "/screenshot_" + screenshotCounter + ".png";
			File DestFile = new File(screenshotPath);
			FileUtils.copyFile(SrcFile, DestFile);
			return screenshotPath;
		} catch (Exception e) {
			return null;
		}
	}

	/*public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		return formatter.format(date);
	}

	public String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SSS");
		Date date = new Date();
		return formatter.format(date);
	}*/

	/**
	 * @author shekarcg
	 * @category action class functions
	 **/
	public void actionPerform(By element, String message) {
		try {
			driver.findElement(element);
			WebElement canvasElement = driver.findElement(element);
			wait(2);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", canvasElement);
			Actions builder = new Actions(driver);
			builder.clickAndHold(canvasElement).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50).moveByOffset(-50, -10).release().perform();
			reportLog(PASS, "Expected action  is performed- " + message, true);
			logStepInfo("Expected text is verified" + message);

		} catch (Exception e) {
			logStepInfo("Failed - Error in function takeScreenshot(): " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
		}

	}

	public String getValue(String element) {
		By xpath = createDynamicXpath("label", element, "xpath for " + element + " ");
		return driver.findElement(xpath).getText();
	}

	public void uploadFile(By element, String objName, String object) {

		try {
			String path = System.getProperty("user.dir") + "/input/" + object;
			createElement(element).sendKeys(path);

			reportLog(PASS, "Uploaded file to:- " + objName, false);
			logStepInfo("Uploaded File to " + objName);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function clickElementWithWait(): " + e.getMessage());
			reportLog(FAIL, "Element not clicked - " + objName + "Error Message is ::" + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public By createDynamicXpath(String identifier, String Value, String object) {
		String xpath = null;

		try {
			switch (identifier.toLowerCase()) {
				case "button":
					xpath = "//input[contains(@value,'" + Value + "')]";
					// createElement(By.xpath(xpath));
					break;
				case "text":
					xpath = "//*[contains(text(),'" + Value + "')]/following::td[1]/input[1]";
					break;
				case "title":
					xpath = "(//*[contains(text(),'" + Value + "')])[last()]";
					break;
				case "error":
					xpath = "//*[contains(text(),'" + Value + "')]";
					break;
				case "label":
					xpath = "//*[contains(text(),'" + Value + "')]/following::div[1]/b";
					break;
				case "value":
					xpath = "(//*[contains(text(),'" + Value + "')]/following::td[1])[last()]";
					break;
				case "menubutton":
					xpath = "(//a[contains(text(),'" + Value + "')])[1]";
					break;
				case "menu":
					xpath = "(//li/*[contains(text(),'" + Value + "')])[1]";
					break;
				case "sub-menu":
					xpath = "(//a[contains(text(),'" + Value + "')])[1]";
					break;
				default:
					xpath = Value;
			}
			By wElement = By.xpath(xpath);
			return wElement;
		} catch (Exception e) {
			logStepInfo("Failed - Error in function clickElementWithWait(): " + e.getMessage());
			reportLog(FAIL, "Error is occured for the " + object + "Error Message" + e.getMessage(), true);
			scenarioFailed();
			return null;
		}

	}

	/**
	 * @author gerguran
	 * @category verify text present by xpath in hover action
	 ***/

	public void hoverTextValidatation(String xpathElem, String identifier, String expectedText) throws Exception {
		try {

			WebElement element = driver.findElement(By.xpath(identifier));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();

			WebElement toolTipEle = driver.findElement(By.xpath("//*[@id='ngx-popover-0']"));
			//System.out.println(toolTipEle.getAttribute("outerHTML"));
			String toolTipTxt = toolTipEle.getText();

			System.out.println("text of tool tip window is ::" + toolTipTxt);

			Assert.assertEquals(expectedText, toolTipTxt);

			reportLog(PASS, "Expected Text  is present - " + expectedText, false);
			logStepInfo("Expected text is verified" + expectedText);


		} catch (Error e) {
			logStepInfo("Failed - Error in function hoverTextValidatation(): " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), false);
			scenarioFailed();
		}
	}

	public void alertTextValidatation(String expectedText) throws Exception {
		try {
			String alertText = driver.switchTo().alert().getText();
			System.out.println("text of alert windows is ::" + alertText);
			Assert.assertTrue(alertText.contains(expectedText), "text Matched");

			reportLog(PASS, "Expected Text  is present - " + expectedText, false);
			logStepInfo("Expected text is verified" + expectedText);
			thread(5);
			driver.switchTo().alert().accept();

		} catch (Error e) {
			logStepInfo("Failed - Error in function alertTextValidatation(): " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), false);
			scenarioFailed();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function alertTextValidatation(): " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), false);
			scenarioFailed();
		}
	}

	public void hoverTextToolTip(String xpathElem, String identifier, String expectedText) throws Exception {
		try {

			WebElement element = driver.findElement(By.xpath(identifier));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			
			WebElement toolTipEle = driver.findElement(By.xpath("//*[@id='ngx-popover-1']"));
			//System.out.println(toolTipEle.getAttribute("outerHTML"));
			String toolTipTxt = toolTipEle.getText();
	        
			System.out.println("text of tool tip window is ::"+toolTipTxt);
			
			Assert.assertEquals(expectedText, toolTipTxt);

			reportLog(PASS, "Expected Text  is present - " + expectedText, false);
			logStepInfo("Expected text is verified" + expectedText);

			
		}catch (Error e) {
				logStepInfo("Failed - Error in function hoverTextValidatation(): " + e.getMessage());
				reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), false);
				scenarioFailed();
			}
	}
	public void verifyElementNotPresence(By element) {
		try {
			Assert.assertEquals(0, driver.findElements(element).size());
			reportLog(PASS, "Expected Element is not present - " + element, true);
			logStepInfo("Expected text is verified" + element);

		} catch (Exception e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		} catch (Error e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		}
	}

	public boolean verifyElementNotPresent(By element) {
		try {
			Assert.assertEquals(0, driver.findElements(element).size());
			reportLog(PASS, "Expected Element is not present - " + element, true);
			logStepInfo("Expected text is verified" + element);
			return true;

		} catch (Exception e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		} catch (Error e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		}
		return false;
	}

	public void verifyMessageTxt(String MessageTxt, String expectedText) {
		try {
			Assert.assertTrue(MessageTxt.contains(expectedText), "Text Matched");
			reportLog(PASS, "Expected Element is present - " + expectedText, true);
			logStepInfo("Expected text is verified" + expectedText);
		} catch (Exception e) {
			logStepInfo("Expected Element is not  present, Error- " + e.getMessage());
			reportLog(FAIL, "Failed in this Step more details:- " + e.getMessage(), true);
			//scenarioFailed();
		} catch (Error e) {
			logStepInfo("Expected Element is not  present, Error- " + e.getMessage());
			reportLog(FAIL, "Failed in this Step more details:- " + e.getMessage(), true);
			//scenarioFailed();
		}
	}

	/**
	 * @throws Exception
	 * @author tprsa
	 * @category Clearing temp file and closing browser instance
	 ***/
	public void clearTempFolder() throws Exception {

		ProcessBuilder clearTempFolder= new ProcessBuilder("cmd","/c","clearTempCMD.bat");
		File dir=new File("src/test/resources/files");
		clearTempFolder.directory(dir);
		Process clearTempProcess=clearTempFolder.start();
	}

	public void verifyTextPresence(String Text) {
		try {
			wait(3);
			if (driver.findElement(By.xpath("(//*[contains(.,'" + Text + "')])[last()]")).isDisplayed()) {
				reportLog(PASS, "Expected text is present -->" + Text, false);
				logStepInfo("Expected text is present");

			} else {
				reportLog(FAIL, "Expected text is Not present -->" + Text, false);
				logStepInfo("Expected text is Not present");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyWarningTextPresence(String Text) {
		try {
			String ExpectedText = Text.replaceAll(" ", "");
			String ActualText = driver.findElement(By.xpath("//*[@id='errorMessages']")).getText().replaceAll(" ", "");
			if (ActualText.contains(ExpectedText)) {
				reportLog(PASS, "Expected text is present -->" + Text, false);
				logStepInfo("Expected text is present");

			} else {
				reportLog(FAIL, "Expected text is Not present -->" + Text, false);
				logStepInfo("Expected text is Not present");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyWarningTextNotPresence(String Text) {
		try {
			String ExpectedText = Text.replaceAll(" ", "");
			String ActualText = driver.findElement(By.xpath("//*[@id='errorMessages']")).getText().replaceAll(" ", "");
			if (ActualText.contains(ExpectedText)) {
				reportLog(FAIL, "Expected text is present -->" + Text, false);
				logStepInfo("Expected text is present");

			} else {
				reportLog(PASS, "Expected text is Not present -->" + Text, false);
				logStepInfo("Expected text is Not present");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTextNotPresence(String Text) {

		try {
			Assert.assertEquals(0, driver.findElements(By.xpath("(//*[contains(.,'" + Text + "')])[last()]")).size());

			reportLog(PASS, "Expected Text is not present - " + Text, true);
			logStepInfo("Expected text is verified" + Text);

		} catch (Exception e) {
			logStepInfo("Failed - Expected Text Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		} catch (Error e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		}

	}

	public void verifyElementNotPresence(By element, String Text) {

		try {
			Assert.assertEquals(0, driver.findElements(element).size());

			reportLog(PASS, "Expected Element is not present - " + Text, true);
			logStepInfo("Expected text is verified" + Text);

		} catch (Exception e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage()+" "+Text);
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage()+" "+Text, true);
			scenarioFailed();
		} catch (Error e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage()+" "+Text, true);
			scenarioFailed();
		}

	}

	public void verifyTextPresenceTableRow(String Text) {
		try {
			if (driver.findElement(By.xpath("(//th/..//div/../../../..//tr/td[5][contains(.,'" + Text + "')])[last()]")).isDisplayed()) {
				reportLog(PASS, "Expected text is present -->" + Text, false);
				logStepInfo("Expected text is present");

			} else {
				reportLog(FAIL, "Expected text is Not present -->" + Text, false);
				logStepInfo("Expected text is Not present");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTextNotPresenceTableRow(String Text) {

		try {
			Assert.assertEquals(0, driver.findElements(By.xpath("(//th/..//div/../../../..//tr/td[5][contains(.,'" + Text + "')])[last()]")).size());

			reportLog(PASS, "Expected Text is not present - " + Text, true);
			logStepInfo("Expected text is verified" + Text);

		} catch (Exception e) {
			logStepInfo("Failed - Expected Text Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		} catch (Error e) {
			logStepInfo("Failed - Expected Element Present:: " + e.getMessage());
			reportLog(FAIL, "Failed in this Step -check logs for more details:- " + e.getMessage(), true);
			scenarioFailed();
		}

	}

	public void verifyStringContainsText(String Actual, String Expected) {
		try {
			if (Actual.contains(Expected)) {
				reportLog(PASS, "Actual String [" + Actual + "] Contains Expected String [" + Expected + "]", false);
			} else {
				reportLog(FAIL, "Actual String [" + Actual + "] Does not Contains Expected String [" + Expected + "]", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyStringNotContainsText(String Actual, String Expected) {
		try {
			if (!Actual.contains(Expected)) {
				reportLog(PASS, "Actual String [" + Actual + "] Not Contains Expected String [" + Expected + "]", false);
			} else {
				reportLog(FAIL, "Actual String [" + Actual + "] Contains Expected String [" + Expected + "]", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * waits for 60 seconds (thread.sleep) until element size is above 0 (until element is found)
	 * @param element
	 */
	public boolean manualWaitElement(By element) {
		int size = 0;
		for (int i = 1; i <= 10; i++) {
			List<WebElement> ele = driver.findElements(element);
			size = ele.size();
			if (size > 0) {
				return true;
			}
			wait(1);
		}
		return false;
	}

	/**
	 * waits until elements are reattached to DOM for 5 sec
	 * @param element
	 */
	public void waitUntilPageIsRefreshed(By element){
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(element)));
	}
	public void waitForInvisibilityOfElement(By element){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	public void waitForPageToLoad(){
		String pageLoadStatus;
		JavascriptExecutor js;

		do{
			js=(JavascriptExecutor) driver;
			pageLoadStatus=(String) js.executeScript("return document.readyState");
			reportLog(INFO,"Page is loading", false);
		}while (!pageLoadStatus.equals("complete"));
		reportLog(INFO,"Page has loaded successfully",false);
	}
	public void clickOnElementUsingActions(By element, String message){
		Actions actions=new Actions(driver);
		try {
		actions.moveToElement(driver.findElement(element));
		actions.click().perform();
		reportLog(PASS,message,false);
		}catch (Exception e){
			logStepInfo(e.getMessage());
			reportLog(INFO,message+"NOT CLICKED",true);
		}
	}

	public void executeJSScript(String script, String message) {
		try {
			javaScriptExecutor.executeScript(script);
			reportLog(PASS, "Script executed" + message, false);
		} catch (Exception e) {
			e.printStackTrace();
			reportLog(INFO, "Script failes to execute" + message, true);
		}
	}

//	/**
//	 * Waiting, should be restricted to use
//	 *
//	 * @param seconds
//	 */
//	public static void wait(int seconds) {
//		try {
//			Thread.sleep(seconds * 1000);
//			reportInfo("Waited for " + seconds + " seconds");
//
//		} catch (Exception e) {
//			log.warn("Failed - Error in function wait(): " + e.getMessage());
//		}
//	}

	public static void loadUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
			reportInfo("Open URL: " + url);
			ReportHelper.customLogSuccess("Open URL: " + url);
		} catch (Exception e) {
			reportFail("Unable to open URL:" + url + " by error: " + e);
			fail();
		}

	}

	public boolean isExistElement(WebDriver driver, By by, int sec) {
		boolean exist = false;

		for (int i = 0; i < sec; i++) {
			try {
				WebElement element = driver.findElement(by);
				if (element != null) {
					exist = true;
					reportInfo("Element " + by + " exists");
					break;
				} else {
					reportInfo("Element " + by + " not exists");
					wait(1);
				}
			} catch (Exception e) {
				reportInfo("Element: " + by + " not found");
				wait(1);
			}
		}
		return exist;
	}

	public boolean isExistElement(WebDriver driver, By by) {
		return isExistElement(driver, by, 1);
	}

	public boolean isDisplayed(WebDriver driver, By by, int sec) {
		boolean displayed = false;
		for (int i = 0; i < sec; i++) {
			try {
				WebElement element = driver.findElement(by);
				if (element != null && element.isDisplayed()) {
					displayed = true;
					reportInfo("Element: " + by + " displayed");
					break;
				} else {
					reportInfo("Element: " + by + " not displayed");
					wait(1);
				}
			} catch (Exception e) {
				reportFail("Element: " + by + " not found");
				wait(1);
			}
		}
		return displayed;
	}

	public boolean isDisplayed(WebDriver driver, By by) {
		return isDisplayed(driver, by, 1);
	}

	public static void clickOnElement(WebDriver driver, By by) {
		try {
			driver.findElement(by).click();
			reportInfo("Click on element: " + by);
			ReportHelper.customLogSuccess("Click on element: " + by);
		} catch (Exception e) {
			reportFail("Unable click on element: " + by + " cause of error: " + e);
			fail();
		}
	}

	public static void enterTextToElement(WebDriver driver, By by, String text) {
		try {
			WebElement ele = driver.findElement(by);
			ele.clear();
			ele.sendKeys(text);
			reportInfo("Enter text: " + text + " to element: " + by);
			ReportHelper.customLogSuccess("Enter text: " + text + " to element: " + by);
		} catch (Exception e) {
			reportFail("Unable to enter text to element:" + by + " cause of error: " + e);
			fail();
		}
	}

	public static void takeScreenshot(WebDriver driver) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			ReportHelper.getScenario().attach(screenshot, "image/png", "Screenshot");
			reportInfo("Screenshot attached to report ");
		} catch (Exception e) {
			reportFail("Unable to attach screenshot: " + e);
		}
	}

	public static void setAttribute(WebDriver driver, By by, String attrName, String attrValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(by);
		js.executeScript("arguments[0].setAttribute('" + attrName + "', '" + attrValue + "')", ele);
	}
}