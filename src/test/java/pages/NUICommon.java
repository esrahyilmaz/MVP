package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.Unirest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumhelper.BaseClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class NUICommon extends BaseClass {

	NUIAdministrationPage nuiAdministrationPage = new NUIAdministrationPage();
	NUILoginPage nuiLoginPage = new NUILoginPage();
	NUIPeoplePage nuiPeoplePage = new NUIPeoplePage();
	NUIHomePage nuiHomePage = new NUIHomePage();
	NUICreatePerson nuiCreatePersonPage = new NUICreatePerson();
	NUIShoppingCartPage nuiShoppingCartPage = new NUIShoppingCartPage();
	NUIPackageSelectionPage nuiPackageSelectionPage = new NUIPackageSelectionPage();
	NUIPaymentMethodPage nuiPaymentMethodPage = new NUIPaymentMethodPage();
	NUIOrderSubmissionPage nuiOrderSubmissionPage = new NUIOrderSubmissionPage();
	NUIProgramOwnerWorkflowPeoplePage nuiProgramOwner = new NUIProgramOwnerWorkflowPeoplePage();
	NUIVendorOnboarding nuiVendorOnboarding = new NUIVendorOnboarding();
	ExcelReader _dataRepo = new ExcelReader();
	NUIXtdConnect NewUIXtdConnect = new NUIXtdConnect();
	NewUIVendorRegistrationPage VendorRegisPage = new NewUIVendorRegistrationPage();
	NewUIVendorPaymentPage PaymentPage = new NewUIVendorPaymentPage();
	NUITaxIntegration nuiTaxIntegration = new NUITaxIntegration();
	NUIForgotPasswordPage nuiForgotPasswordPage = new NUIForgotPasswordPage();
	public By msgModal = By.xpath("//*[@class='modal fade in show' and @aria-hidden='false']");
	public By msgErrorModal = By.xpath("//div[@style='display: block;' and @class='modal fade in show']");

	String randomUpdatedName;
	String getStatus;
	int rowCheckbox;
	String atributeValue;
	public String dateBefores;
	public String dateAfters;

	// -------------------------Click action-------------------------//

	public void clickButton(String value, String Page) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			switch (Page.toLowerCase()) {
			
			case "vendor onboarding":
			if (value.equalsIgnoreCase("NEXT")) {
				clickElementWithWait((By.xpath("(//button[contains (., 'Next')])[last()]")), value);
			} else if (value.equalsIgnoreCase("SUBMIT")) {
				clickElementWithWait((By.xpath("(//button[contains (., 'Submit')])[last()]")), value);
			}			
			break;	
			case "signup":
				if (value.equalsIgnoreCase("Sign up")) {
					clickElementWithWait(VendorRegisPage.VendorSignUp, "Sign up button");
				} else if (value.equalsIgnoreCase("Let's Begin!")) {
					clickElementWithWait(VendorRegisPage.letsBegin , "Let's Begin button");
				}
				break;

			case "login":
				if (value.equalsIgnoreCase("login")) {
					clickElementWithWait(nuiLoginPage.loginButton, "log in button");
					logStepInfo("Click on " + value);
				}
				break;

			case "profiledashboard":
				if (value.equalsIgnoreCase("view profile")) {
					By viewProfile = By.xpath("//input[@class='btn bggreen']");
					if (verifyElementPresence(viewProfile)) {
					wait(5);
					clickElementWithWait(By.xpath("//input[@class='btn bggreen']"), "View Profile");
					logStepInfo("Click on " + value);
					}
				}
				break;
				
			case "dashboard":
				if (value.equalsIgnoreCase("Needs Review")) {
					clickElementWithWait(By.xpath("//p[contains(@class, 'card-title') and text()='Needs Review']"), value);
				} else if (value.equalsIgnoreCase("Non-Compliant")){
					 clickElementWithWait(By.xpath("//p[contains(@class, 'card-title') and text()='Non-Compliant']"), value);
				} else if (value.equalsIgnoreCase("Pending")) {
					clickElementWithWait(By.xpath("//p[contains(@class, 'card-title') and text()='Pending']"), value);
				}else if (value.equalsIgnoreCase("Action Required")) {
					clickElementWithWait(By.xpath("//p[contains(@class, 'card-title') and text()='Action Required']"), value);
				}else if (value.equalsIgnoreCase("Expired")) {
					clickElementWithWait(By.xpath("//p[contains(@class, 'card-title') and text()='Expired']"), value);
				}else if (value.equalsIgnoreCase("Active Providers")) {
					clickElementWithWait(By.xpath("//div[@class='card-body']//p[contains(@class, 'card-title') and text()='Active Providers']"), value);
				}
				break;
			case "customer order":
				if (value.contains("Select Option for Customer Order")) {
					clickElementWithWait(NewUIXtdConnect.CutomerOrderSelectOption, "customer order select options");
				} else if (value.equalsIgnoreCase("Select Option for Email to Applicant")){
					 clickElementWithWait(By.xpath("//button[@id='invite-btn']"), value);
				} 
				break;

			case "notice":
				if (value.equalsIgnoreCase("i certify")) {
					clickElementWithWait(nuiLoginPage.certifyButton, "Legal agreement Button");
				}
				break;
			case "administration":
				if (value.equalsIgnoreCase("new user")) {
					clickElementWithWait(nuiAdministrationPage.newUserButton, "New User button on Administration Page");
				} else if (value.equalsIgnoreCase("save")) {
					clickElementWithWait(nuiAdministrationPage.addNewUserButton,
							"Add New User button for creating new user");
				} else if (value.equalsIgnoreCase("update")) {
					clickElementWithWait(nuiAdministrationPage.userUpdateButton,
							"Add New User button for creating new user");
				} else if (value.equalsIgnoreCase("Action")) {
					clickElementWithWait(nuiAdministrationPage.userActionButton,
							"Action button on Administration Page");
				} else if (value.equalsIgnoreCase("Edit User")) {
					clickElementWithWait(nuiAdministrationPage.userEditNavButton,
							"Edit button on Administration Page ");
				} else if (value.equalsIgnoreCase("search")) {
					clickElementWithWait(nuiAdministrationPage.searchButton, "Search button for searching user");
				}else if (value.equalsIgnoreCase("update user")) {
					WebElement element = driver.findElement(By.xpath("//button[@id='updateUser' and contains(text(), 'Update user')]"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element);
						
				} else if (value.equalsIgnoreCase("Cancel")) {
					clickElementWithWait(nuiAdministrationPage.userCancleButton, "Cancel button for searching user");

				} else if (value.equalsIgnoreCase("Save Card")) {
					clickElementWithWait(nuiAdministrationPage.SaveCreditCardCheckbox, "Save Credit Card Checkbox on Your Payments");
					clickElementWithWait(nuiAdministrationPage.saveCreditCard, "Save Credit Card on Your Payments");

				} else {
					wait(2);
					By xpath = By.xpath("//*[contains(text(),'" + value + "')]");
					System.out.println("Button xpath is ::" + xpath);
					clickElementWithWait(xpath, value + " button");
				}
				break;

			case "people":

				if (value.equalsIgnoreCase("Action")) {
					clickElementWithWait(nuiPeoplePage.peopleActionButton, "Action button on People Page");

				} else if (value.equalsIgnoreCase("Set Status")) {
					clickElementWithWait(nuiPeoplePage.peopleSetStatusButton, "Set Status button on People Page ");

				} else if (value.equalsIgnoreCase("New Order")) {
					clickElementWithWait(nuiPeoplePage.peopleNewOrderButton, "New order button on People Page ");

				} else if (value.equalsIgnoreCase("New Order PROD")) {
					clickElementWithWait(nuiPeoplePage.peopleNewOrderButtonProd, "New order button on People Page ");

				} else if (value.equalsIgnoreCase("Active")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.peopleStatusesActive)).click();
					clickElementWithWait(nuiPeoplePage.peopleStatusesActive, "Active button");
				} else if (value.equalsIgnoreCase("Inactive")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.peopleStatusesInactive)).click();
					clickElementWithWait(nuiPeoplePage.peopleStatusesInactive, "Inactive button");

				} else if (value.equalsIgnoreCase("Terminated")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.peopleStatusesTerminated)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.peopleStatusesTerminated, "Terminated button");

				} else if (value.equalsIgnoreCase("search")) {
					clickOnElementUsingActions(nuiPeoplePage.serachButton, "Search button for searching user");
//					clickElementWithWait(nuiPeoplePage.serachButton, "Search button for searching user");
					wait(1);

//					if (verifyElementPresence(nuiPeoplePage.orderDateAsc))
//					wait(2);
//						{clickElementWithWait(nuiPeoplePage.orderDateAsc, "Sort by latest created user for searched user");
//							logStepInfo("Order Date accordion clicked");
//						}

				} else if (value.equalsIgnoreCase(" Create Order ")) {
					wait(2);
					clickElementWithWait(nuiPeoplePage.addPeopleButton, "Add People on People Page");

				} else if (value.equalsIgnoreCase("logout")) {
					clickElementWithWait(nuiHomePage.profileIcon, "Click on Profile icon");
					clickElementWithWait(nuiHomePage.logOutNui, "Click on Logout icon");
				} else if (value.equalsIgnoreCase("continue")) {
					clickElementWithWait(nuiPeoplePage.continueButton, "Click on Continue button");
				} else if (value.equalsIgnoreCase("filter")) {
//					waitForInvisibilityOfElement(By.cssSelector("#loader"));
//					wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.peopleFilterButton)).click();
					clickElementJS(nuiPeoplePage.peopleFilterButton, "Filter button on People Page ");

				} else if (value.equalsIgnoreCase("filter complete")) {
//					waitForInvisibilityOfElement(By.cssSelector("#loader"));
					clickElementWithWait(nuiPeoplePage.peopleFilterCheckButton,
							"Filter complete button on People Page ");

				} else if (value.equalsIgnoreCase("outside filter")) {
					clickElementWithWait(nuiPeoplePage.outsideFilterButton, "Outside filter button on People Page ");

				} else if (value.equalsIgnoreCase("date range picker")) {
					clickElementWithWait(nuiPeoplePage.dateRangePicker, "Date range picker button on People Page ");

				} else if (value.equalsIgnoreCase("completion date range picker")) {
					clickElementWithWait(nuiPeoplePage.completionDateRangePicker,
							"Completion date range picker button on People Page ");
					System.out.println("Completion date range picker button on People Page");

				} else if (value.equalsIgnoreCase("ActiveCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterActiveCheckButton)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterActiveCheckButton, "Active button");

				} else if (value.equalsIgnoreCase("InactiveCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterInactiveCheckButton)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterInactiveCheckButton, "Inactive button");

				} else if (value.equalsIgnoreCase("TerminatedCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterTerminatedCheckButton)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterTerminatedCheckButton, "Terminated button");

				} else if (value.equalsIgnoreCase("CompliantCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterCompliantCheckButton)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterCompliantCheckButton, "Compliant button");

				} else if (value.equalsIgnoreCase("NonCompliantCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterNonCompliantCheckButton)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterNonCompliantCheckButton, "Non-Compliant button");

				} else if (value.equalsIgnoreCase("PendingCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterCompleteCheckButtonScreening)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterPendingCheckButton, "Complete button");

				} else if (value.equalsIgnoreCase("CompletedCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterCompleteCheckButtonScreening)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterCompletedCheckButtonScreening, "Complete button");

				} else if (value.equalsIgnoreCase("PendingCheckScreening")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterPendingCheckButtonScreening)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterPendingCheckButtonScreening, "Pending button");

				}else if (value.equalsIgnoreCase("ActionRequiredCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterPendingCheckButtonScreening)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterActionRequiredCheckButton, "Action Required button");

				}else if (value.equalsIgnoreCase("NeedsReviewCheck")) {
					// wait.until(ExpectedConditions.elementToBeClickable(nuiPeoplePage.filterPendingCheckButtonScreening)).click();
					wait(1);
					clickElementWithWait(nuiPeoplePage.filterNeedsReviewCheckButton, "Needs Review button");

				}else if (value.equalsIgnoreCase("skipcheck")) {
					logStepInfo("Step Skipped");
					return;

				} else if (value.equalsIgnoreCase("ClearCheckboxCompliance")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.getElementById('Active').checked=false");
					js.executeScript("document.getElementById('Inactive').checked=false");
					js.executeScript("document.getElementById('Terminated').checked=false");
					js.executeScript("document.getElementById('Compliant').checked=false");
					js.executeScript("document.getElementById('Non-Compliant').checked=false");
					js.executeScript("document.getElementById('Pending').checked=false");
					js.executeScript("document.getElementById('Needs Review').checked=false");

				}else if(value.contains("ClickablePill")){
					clickElement(nuiPeoplePage.clickableFilterPill(value),value+"Clickable Pill");
				}
				break;

			case "create person":
				if (value.equalsIgnoreCase("Middle Name Yes")) {
					clickElementWithWait(nuiCreatePersonPage.middleNameYesButton, "Person Has Middle Name Button");

				} else if (value.equalsIgnoreCase("Next")) {
					clickElement(nuiCreatePersonPage.personNextButton, "Next button on Create Person Page");
					logStepInfo("Next button on Create Person Page is clicked");
					System.out.println("Next button on Create Person Page is clicked");
					if(!verifyElementPresence(nuiPackageSelectionPage.packageSelectionPageHeader)){
							wait(2);
							clickOnElementUsingActions(nuiCreatePersonPage.personNextButton, "Next button on Create Person Page");
							logStepInfo("Next button on Create Person Page is clicked with actions");
						System.out.println("Next button on Create Person Page is clicked with actions");
					}
				} else if (value.equalsIgnoreCase("Cancel")) {
					clickElementWithWait(nuiCreatePersonPage.personCancelButton, "Cancel button on Create Person Page");
				}
				break;
			case "package selection":
				if (value.equalsIgnoreCase("search")) {
					clickElementWithWait(nuiPackageSelectionPage.searchIconPackage,	"Search button on Package Selection page");

				} else if (value.equalsIgnoreCase("Previous")) {
					clickElementWithWait(nuiPackageSelectionPage.previousPackageButton, "Previous button on Package Selection Page");

				} else if (value.equalsIgnoreCase("Add to Cart")) {
					clickElementWithWait(nuiPackageSelectionPage.addToCartShoppingButton, "Add to Cart button on Package Selection Page");
				}
				break;

			case "shopping cart":
				if (value.equalsIgnoreCase("search")) {
					clickElementWithWait(nuiShoppingCartPage.searchIconShoppingCart,
							"Search button on Shopping Cart page");

				} else if (value.equalsIgnoreCase("delete")) {
					clickElementWithWait(nuiShoppingCartPage.deleteIconShoppingCart,
							"Delete icon on Shopping Cart Page");

				} else if (value.equalsIgnoreCase("Yes")) {
					clickElementWithWait(nuiShoppingCartPage.deletePkgPopupButtonYes,
							"Yes button on Popup for delete Package");

				} else if (value.equalsIgnoreCase("No")) {
					clickElementWithWait(nuiShoppingCartPage.deletePkgPopupButtonNo,
							"No button on Popup for delete Package");

				} else if (value.equalsIgnoreCase("Add Another Package")) {
					clickElementWithWait(nuiShoppingCartPage.addAnotherPkgButton,
							"Add Another Package button on Shopping Cart Page");

				} else if (value.equalsIgnoreCase("Checkout")) {
					clickElementWithWait(nuiShoppingCartPage.checkoutShoppingCartButton,
							"Checkout button on Shopping Cart Page");
				
				} else if (value.equalsIgnoreCase("Authorize")) {
					clickElementWithWait(nuiShoppingCartPage.authorizeTickBox, "Authorize TickBox on Shopping Cart Page");
				}				
				break;

			case "payment method":
				if (value.equalsIgnoreCase("Next button on PP")) {
					wait(1);
					clickElementWithWait(nuiPaymentMethodPage.addNextButtonCC, "Next button on Payment Page");
					wait(5);

				} else if (value.equalsIgnoreCase("Submit Payment")) {
					clickElementWithWait(nuiPaymentMethodPage.submitPaymentButton, "Submit Payment clicked");
				}else if (value.equalsIgnoreCase("Next")) {
					clickElementWithWait(nuiPaymentMethodPage.NextButtonOnPaymentpage, "Next button clicked on payment page");
				}else if (value.equalsIgnoreCase("Close")) {
					clickElementWithWait(nuiPaymentMethodPage.CloseButtonOnRevisedModal, "Close button on Reviced consumed Credit card clicked");
				}
				break;

			case "order submission":
				if (value.equalsIgnoreCase("Return to People Page")) {
					clickElementWithWait(nuiOrderSubmissionPage.returnToPeopleButton, "Return to People Page button on Order Confirmation Page");
				}
				break;

			case "program owner":
				if (value.equalsIgnoreCase("search")) {
					wait(1);
					clickElementWithWait(nuiProgramOwner.searchIcon, "Search for Provider on Program Owner Page");
				}
				break;

			case "Sign up":
				clickElementWithWait(VendorRegisPage.VendorSignUp, "Click on Sign up button");
				break;

			case "outstanding":
				if (value.equalsIgnoreCase("Checkout Button")) {
					By oustandingBalance = By.xpath("//*[@class='btn btn-primary']");
					clickElementWithWait(oustandingBalance, "Click on Checkout button");
				} else if (value.equalsIgnoreCase("Submit Payment")) {
					By submitPaymentButton = By.xpath(
							"//button[contains(@data-xf-qa-id, 'VW-POPM-BTN-NEXT') and contains(text(), 'Submit Payment')]");
					clickElementWithWait(submitPaymentButton, "Click on Submit Payment Button");
				}
				logStepInfo("I clicked on button: " + value);
				reportLog(Status.PASS, "Clicked on button: " + value, false);
				break;

			case "tax integration taxable":
//				if ((SponsorLvl.equalsIgnoreCase("Credit Card")) | (VendorLvl.equalsIgnoreCase("Credit Card"))) {
				if ((((propertyValueAT.equalsIgnoreCase("Credit Card")) && ((propertyValuePM.equalsIgnoreCase("Null"))
						|| (propertyValuePM.equalsIgnoreCase("Credit Card")) || (propertyValuePM.equalsIgnoreCase(""))))
						|| ((propertyValuePM.equalsIgnoreCase("Credit Card"))))) {
					clickElementWithWait(nuiShoppingCartPage.checkoutShoppingCartButton, "Checkout button on Shopping Cart Page");
					logStepInfo("Tax validation on Program Payment Screen");
					reportLog(Status.PASS, "Tax validation on Program Payment Screen", false);
					nuiTaxIntegration.TaxIntegrationYes();
				} else {
					logStepInfo("Program Payment is not Credit Card");
					reportLog(Status.PASS, "Without tax validation on Program Payment Screen - no Credit Card", false);

				}
				break;

			case "tax integration non-taxable":
//				if ((SponsorLvl.equalsIgnoreCase("Credit Card")) | (VendorLvl.equalsIgnoreCase("Credit Card"))) {
				if ((((propertyValueAT.equalsIgnoreCase("Credit Card")) && ((propertyValuePM.equalsIgnoreCase("Null"))
						|| (propertyValuePM.equalsIgnoreCase("Credit Card")) || (propertyValuePM.equalsIgnoreCase(""))))
						|| ((propertyValuePM.equalsIgnoreCase("Credit Card"))))) {
					clickElementWithWait(nuiShoppingCartPage.checkoutShoppingCartButton, "Checkout button on Shopping Cart Page");
					logStepInfo("Tax validation on Program Payment Screen");
					reportLog(Status.PASS, "Tax validation on Program Payment Screen", false);
					nuiTaxIntegration.TaxIntegrationNo();
				} else {
					logStepInfo("Program Payment is not Credit Card");
					reportLog(Status.PASS, "Without tax validation on Program Payment Screen - no Credit Card", false);

				}
				break;

			case "Business Signature":
				if (value.equalsIgnoreCase("Clear Signature")) {
					clickElementWithWait(nuiVendorOnboarding.clearSignatureBtn,
							"Clear Signature button on Business Signature page");

				}
				break;

			case "Password Reset":
				if (value.equalsIgnoreCase("Submit")) {
					clickElementWithWait(nuiForgotPasswordPage.submit, "Submitt button on Password Reset page");

				} else if (value.equalsIgnoreCase("Return to Login")) {
					clickElementWithWait(nuiForgotPasswordPage.returnToLogin,
							"Clear Signature button on Password Reset page");

				}
				break;

			case "business contact":
				if (value.equalsIgnoreCase("Go Back")) {
					clickElementWithWait(VendorRegisPage.goBackButton, "Go Back button on Business Contact Page");
				}else if(value.equalsIgnoreCase("expandSecondarypage")) {
					clickElementWithWait(VendorRegisPage.SecondaryBusinessContact, "Clicked to expand Secondary on Business Contact Page");
				}
				break;
			case "page business contact":
				 if (value.equalsIgnoreCase("middleNameYes")) {
					clickElementWithWait(nuiCreatePersonPage.BusinessContaMiddleName, "Person Has Middle Name Button");
				} else if(value.equalsIgnoreCase("SecondaryMiddleNameYes")) {
					clickElementWithWait(nuiCreatePersonPage.BusinessContaSecondaryMiddleName, "Person Has Middle Name Button");
				} 
				break;
			case "Initial":
				if (value.equalsIgnoreCase("Previous")) {
					clickElementWithWait(VendorRegisPage.previousButton, "Go Back button on Business Contact Page");
				}
				break;
			case "business billing":
				if (value.equalsIgnoreCase("primaryContactCheckbox")) {
					clickElementWithWait(VendorRegisPage.PrimaryContactCheckbox, "Primary billing contact checkbox");
				}else if (value.equalsIgnoreCase("CheckboxBillingAddress")) {
					clickElementWithWait(VendorRegisPage.billingAddressSameRadio, "My billing address checkbox");
				}if (value.equalsIgnoreCase("middleNameYes")) {
					clickElementWithWait(VendorRegisPage.MiddleNameYes, "Middle name selected");
				}
				break;
			case "XtdConnect":
				if (value.equalsIgnoreCase("Off")) {
					clickElementWithWait(NewUIXtdConnect.OptOutOff, "XtdConnect Opt-Out Switch Off");
				}else if (value.equalsIgnoreCase("ON")) {
					clickElementWithWait(NewUIXtdConnect.OptOutON, "XtdConnect Opt-Out Switch ON");
				}else if (value.equalsIgnoreCase("Next")) {
					clickElementWithWait(NewUIXtdConnect.NextBtnOnXtdConnect, "XtdConnect Next Button");
				}else if (value.equalsIgnoreCase("Cancel")) {
					clickElementWithWait(NewUIXtdConnect.CancelBtnOnXtdConnect, "XtdConnect Next Button");
				}else if (value.equalsIgnoreCase("Order New Package")) {
					By NewOrderButton = By.xpath("//button[@data-xf-qa-id='VW-POPI-BTN-ORDER']");
					clickElementWithWait(NewOrderButton, "Order New Package Button");
				}else if (value.equalsIgnoreCase("XtdConnect")) {
					By xpath = By.xpath("//tr[@id='panel-0']//td[@data-label='Compliance Status']//div[@class='badge badge-pill xtd-connect-badge']");
					System.out.println("Button xpath is ::" + xpath);
					clickElementWithWait(xpath, value + " button");
					//clickElementWithWait(NewUIXtdConnect.XtdConnectLogoOnPeoplePage, "Order New Package Button");
				}else if (value.equalsIgnoreCase("Close")) {
					clickElementWithWait(NewUIXtdConnect.XtdConnectCloseOnModal, "Order New Package Button");
				}else {
					logStepInfo("button not clickable");
					System.out.println("Button xpath is not clickable");
					reportLog(Status.PASS, "Without tax validation on Program Payment Screen - no Credit Card", false);

				}
				break;
			case "home":
				if(value.equalsIgnoreCase("profile icon")){
						clickElement(nuiHomePage.profileIcon,"Profile Icon on Home Page");
				}
				if(value.equalsIgnoreCase("help center")){
					clickElement(nuiHomePage.helpCenter,"Help Center Icon on Home Page");
				}
				break;
				default:
//				By CreatedXPATH = createDynamicXpath("button", value, "xpath created");
			By xpath = By.xpath("//*[contains(text(),'" + value + "')]");
			System.out.println("Button xpath is ::" + xpath);
			clickElementWithWait(xpath, value + " button");
				break;
			}

			takeScreenshot();
		} catch (

		Exception e) {
			e.getMessage();
		}

	}

	public void clickMenuButton(String menubutton) throws Exception {
		try {
			if (menubutton.equalsIgnoreCase("Administration")) {
				clickElementWithWait(nuiHomePage.adminstrationLink, "Administration button");

			} else if (menubutton.equalsIgnoreCase("User Management")) {
				clickElementWithWait(nuiHomePage.userManagmentLink, "User Managment button ");

			} else if (menubutton.equalsIgnoreCase("Your Payments")) {
				clickElementWithWait(nuiHomePage.userYourPaymentsLink, "Your Payments drop down button ");

			} else if (menubutton.equalsIgnoreCase("People")) {
				wait(2);
				clickElement(nuiHomePage.peopleLink, "People Button");

			} else if (menubutton.equalsIgnoreCase("Dashboard")) {
				clickElementWithWait(nuiHomePage.dashboardLink, "People Button");
			}else if (menubutton.equalsIgnoreCase("Providers")) {
				wait(2);
			clickElement(nuiHomePage.providersLink, "Providers Button");
			wait(2);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickPaginationSingleArrow(String value, String Page) throws Exception {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			List<WebElement> pagination = driver
					.findElements(By.xpath("//li[contains(@class,'pagination-page page-item')]/a"));

			String paginationDisabled;
			String paginationClickable;
			String paginationPresent;
			switch (value) {
			case "next":
				paginationDisabled = "pagination-next page-item disabled";
				paginationClickable = "pagination-next page-item";
				paginationPresent = "last";

				break;
			default:
				paginationDisabled = "pagination-prev page-item disabled";
				paginationClickable = "pagination-prev page-item";
				paginationPresent = "first";
				break;

			}
			for (int i = 0; i < 100; i++) {
				if (verifyElementPresence(By.xpath("//li[contains(@class,'" + paginationDisabled + "')]/a"))) {
					System.out.println("User is present on " + paginationPresent + " page.");
					reportLog(Status.PASS, "User is present on " + paginationPresent + " page.", false);
					break;
				} else {
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//li[@class='" + paginationClickable + "']/a")));
					wait(3);
					driver.findElement(By.xpath("//li[@class='" + paginationClickable + "']/a")).click();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickPaginationDoubleArrow(String value, String page) {
		try {

			By paginationXpath;

			if (value.equalsIgnoreCase("GoToLast")) {
				paginationXpath = By.xpath("//li[@class='pagination-last page-item']/a");
			} else {
				paginationXpath = By.xpath("//li[@class='pagination-first page-item']/a");
			}
			clickElementWithWait(paginationXpath, "Click on:" + value);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickCheckbox(String value, String Page) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait(2);

			switch (Page.toLowerCase()) {

			case "administration":
				clickElementWithWait(By.xpath("(//table/tbody/tr/td[position()=1]/div/input)[1]"),
						"individual in User Table on Administration Page");
				existingUserID = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
				break;

			case "people":
				List<WebElement> checkXpath = driver.findElements(By.xpath("//table/tbody/tr/td[1]/div/input"));
				for (int i = 0; i <= checkXpath.size(); i++) {

					String atributeValue = "panel-" + i;
					By statusXpath = By.xpath("//*[@id='" + atributeValue + "']/td[8]/div");
					By personNameXpath = By.xpath("//*[@id='" + atributeValue + "']/td[2]/a");

					if (value.equalsIgnoreCase("Previous")) {
						wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id='" + atributeValue + "']/td[1]/div/input")))
								.click();
						System.out.println("click on Previous checkbox on People Search");
						break;

					} else if (value.equalsIgnoreCase("first")) {
						String personTxt = driver.findElement(personNameXpath).getText();
						existingFullName = personTxt;
						clickElementWithWait(By.xpath("//tr[@id='panel-0']//input[@id='checkbox2']"),
								"click on People Table on People Search");
						break;

					} else if (value.contains("filter")) {
						value = value.replaceAll("filter ", "");
						clickElementWithWait(
								By.xpath("//label[text()='" + value + "']/preceding-sibling::input[@class='checkbox']"),
								"click on checkbox on filter section");
						break;
					} else {
						String statusTxt = driver.findElement(statusXpath).getText();

						if (statusTxt.equalsIgnoreCase(value)) {
							WebElement check = driver
									.findElement(By.xpath("//*[@id='" + atributeValue + "']/td[1]/div/input"));
							check.click();
							break;
						}
					}
				}
				break;
			case "payment method":
				clickElementWithWait(By.xpath("//input[@data-xf-qa-id = 'CCC-CHKBOX-SPM']"),
						"Save Credit Card is selected");
				break;
			
			case "shopping cart":
				clickElementWithWait(nuiShoppingCartPage.deletePkgPopupCheckbox, "Don't ask me again checkbox selected.");
				break;

			case "business billing":
				clickElementWithWait(VendorRegisPage.billingAddressSameRadio,
						"My billing address is the same as my business address");
				break;
			case "xtdconnect":
			if(value.equalsIgnoreCase("xtdconnectconsent")) {	
				clickElementWithWait(NewUIXtdConnect.xtdConnectConsenttickbox, "XtdConnect Consent Checkbox");
				}break;	
				}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void clickRadioButton(String buttonText) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait(3);
			if (buttonText.toLowerCase().contains("package")) {
				List<WebElement> radioBtnXpath = driver.findElements(By.xpath("//table/tbody/tr"));

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr")));
				for (int i = 1; i <= radioBtnXpath.size(); i++) {

					By pkgNameXpath = By.xpath("//table/tbody/tr[" + i + "]/td[2]/div[@class='packageName']/strong");
					wait.until(ExpectedConditions.presenceOfElementLocated(pkgNameXpath));
					String pkgNameTxt = driver.findElement(pkgNameXpath).getText();

					if (pkgNameTxt.equalsIgnoreCase(buttonText)) {
						By radioBtn = (By.xpath("//table/tbody/tr[" + i + "]/td[1]/div/xf-checked-radio"));
//						radioBtn.click();
						clickElement(radioBtn, "clicked on radio button");
						break;
					}
				}
			} else if (buttonText.toLowerCase().equalsIgnoreCase("first")) {
				By radioBtn = (By.xpath("//table/tbody/tr[4]/td[1]/div/xf-checked-radio"));
				clickElementWithWait(radioBtn, "Clicked on first package");
			} else if (buttonText.toLowerCase().equalsIgnoreCase("first pkg")) {
				By radioBtn = (By.xpath("//table/tbody/tr/td[1]/div/xf-checked-radio/div/div"));
				wait(2);
				clickElementWithWait(radioBtn, "Clicked on first package");
			} else if (buttonText.toLowerCase().equalsIgnoreCase("new")) {
				By radioBtn = (By.xpath("(//xf-checked-radio)[last()]"));
				clickElementWithWait(radioBtn, "Clicked on radiobutton - Use a new payment method");

			} else if (buttonText.toLowerCase().equalsIgnoreCase("first credit card")) {
				By radioBtn = (By.xpath("//*[@data-xf-qa-id = 'CCP-CS-TOKEN-RADIO-0']"));
				clickElementWithWait(radioBtn, "Clicked on radiobutton - First existing credit card");

			} else if (buttonText.toLowerCase().equalsIgnoreCase("use new payment method")) {
				By radioBtn = (By.xpath("//*[contains(@data-xf-qa-id,'CCP-CS-RADIO-NEW')]"));
				clickElementWithWait(radioBtn, "Clicked on Use a new payment method");

			} else if (buttonText.toLowerCase().equalsIgnoreCase("Primary Contact")) {
				By radioBtn = (By.xpath("//*[@id= 'checkbox']"));
				// clickElementWithWait(radioBtn, "Clicked on radiobutton - Primary Contact");
				WebElement element = driver.findElement(radioBtn);
				Actions act = new Actions(driver);
				act.moveToElement(element).click().build().perform();
			}

		} catch (Exception e) {
			System.out.println("Except is in following object ::" + e);
		}
	}

	public void clickOnComplStatus(String hyperlink) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait(3);

			List<WebElement> tableRow = driver.findElements(By.xpath("//tr[@class='a-panel']"));
			System.out.println(tableRow.size());
			String existingPersonName;
			String statusPersonTxt;
			if (existingMiddleName != null) {
				existingPersonName = existingFirstName + " " + existingMiddleName + " " + existingLastName;
			} else {
				existingPersonName = existingFirstName + " " + existingLastName;
			}
			System.out.println(existingPersonName);

			for (int i = 0; i <= tableRow.size(); i++) {
				String atributeValue = "panel-" + i;
				System.out.println(atributeValue);
				statusPersonTxt = wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id='" + atributeValue + "']/td[2]")))
						.getText();
				System.out.println(statusPersonTxt);

				if (statusPersonTxt.equals(existingPersonName)) {
					By statusLinkXpath = By.xpath("//*[@id='" + atributeValue + "']/td[3]/div" + hyperlink);
					// WebElement statusLinkButton = driver.findElement(statusLinkXpath);
					wait.until(ExpectedConditions.presenceOfElementLocated(statusLinkXpath)).click();
					reportLog(Status.PASS, "Hyperlink is clicked.", true);
					logStepInfo("Hyperlink is clicked.");
					// statusLinkButton.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Except is in following object ::" + e);
		}
	}

	public void clickOnComplStatusScreening(String hyperlink) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait(3);

			List<WebElement> tableRow = driver.findElements(By.xpath("//tr[@class='a-panel']"));
			System.out.println(tableRow.size());
			String existingPersonName;
			String statusPersonTxt;
			if (existingMiddleName != null) {
				existingPersonName = existingFirstName + " " + existingMiddleName + " " + existingLastName;
			} else {
				existingPersonName = existingFirstName + " " + existingLastName;
			}
			System.out.println(existingPersonName);

			for (int i = 0; i <= tableRow.size(); i++) {
				String atributeValue = "panel-" + i;
				System.out.println(atributeValue);
				statusPersonTxt = wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id='" + atributeValue + "']/td[2]")))
						.getText();
				System.out.println(statusPersonTxt);

				if (statusPersonTxt.equals(existingPersonName)) {
					By statusLinkXpath = By.xpath("//*[@id='" + atributeValue + "']/td[4]/div" + hyperlink);
					// WebElement statusLinkButton = driver.findElement(statusLinkXpath);
					wait.until(ExpectedConditions.presenceOfElementLocated(statusLinkXpath)).click();
					reportLog(Status.PASS, "Hyperlink is clicked.", true);
					logStepInfo("Hyperlink is clicked.");
					// statusLinkButton.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Except is in following object ::" + e);
		}
	}

	public void clickOnComplStatusPA(String hyperlink) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait(3);

			List<WebElement> tableRow = driver.findElements(By.xpath("//tr[@class='a-panel']"));
			System.out.println(tableRow.size());
			String existingPersonName;
			String statusPersonTxt;
			if (pANewMiddleName != null) {
				existingPersonName = pANewFirstName + " " + pANewMiddleName + " " + pANewLastName;
			} else {
				existingPersonName = pANewFirstName + " " + pANewLastName;
			}
			System.out.println(existingPersonName);

			for (int i = 0; i <= tableRow.size(); i++) {
				String atributeValue = "panel-" + i;
				System.out.println(atributeValue);
				statusPersonTxt = wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id='" + atributeValue + "']/td[2]")))
						.getText();
				System.out.println(statusPersonTxt);

				if (statusPersonTxt.equals(existingPersonName)) {
					By statusLinkXpath = By.xpath("//*[@id='" + atributeValue + "']/td[3]/div" + hyperlink);
					// WebElement statusLinkButton = driver.findElement(statusLinkXpath);
					wait.until(ExpectedConditions.presenceOfElementLocated(statusLinkXpath)).click();
					reportLog(Status.PASS, "Hyperlink is clicked.", true);
					logStepInfo("Hyperlink is clicked.");
					// statusLinkButton.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Except is in following object ::" + e);
		}
	}

	public void prePopulatedValue(String value, String Page) throws Exception {
		try {
			if (value.contains("PrePopulatedAddressOnBB")) {
				String BBCountry = driver.findElement(VendorRegisPage.BillingCountry).getAttribute("value");
				if (BBCountry.equals("1: US")) {
					BBCountry = "United States";
				}
				String BBAddress = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('billingAddressLineOne').value;");
				System.out.println("Actuall Street address: " + BBAddress);
				System.out.println("Expected Street address: " + existingBusinessInfoAddress);

				String BBCity = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('billingCity').value;");
				System.out.println("Actuall city: " + BBCity);
				System.out.println("Expected city: " + existingBusinessInfoCity);

				String BBState = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('billingRegion').getAttribute('value');");
				System.out.println("Actual state: " + BBState);
				System.out.println("Expected state: " + existingBusinessInfoState);

				String BBZip = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('billingPostalCode').value;");
				System.out.println("Actual zip code: " + BBZip);
				System.out.println("Expected zip code: " + existingBusinessInfoZip);

				Assert.assertTrue(existingBusinessInfoAddress.contains(BBAddress),
						"Street Address is the same as expected");
				Assert.assertTrue(existingBusinessInfoCity.contains(BBCity), "Cite is the same as expected");
				Assert.assertTrue(existingBusinessInfoState.contains(BBState), "State is the same as expected");
				Assert.assertTrue(existingBusinessInfoZip.contains(BBZip), "Zip CODE is the same as expected");

				logStepInfo("Pre-populated Informations is valid");
				reportLog(Status.PASS, "Pre-populated all Information are Present", false);
			} else {
				logStepInfo("Pre-populated Informations is invalid");
				reportLog(Status.FAIL, "Pre-populated all information is incorrect ", false);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	public void clickOnAccordion() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait(3);

			List<WebElement> tableRow = driver.findElements(By.xpath("//tr[@class='a-panel']"));
			String existingPersonName;
			String statusPersonTxt;
			if (existingMiddleName != null) {
				existingPersonName = existingFirstName + " " + existingMiddleName + " " + existingLastName;
			} else {
				existingPersonName = existingFirstName + " " + existingLastName;
			}
			System.out.println(existingPersonName);

			for (int i = 0; i <= tableRow.size(); i++) {
				String atributeValue = "panel-" + i;
				System.out.println(atributeValue);
				statusPersonTxt = wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id='" + atributeValue + "']/td[2]")))
						.getText();
				System.out.println(statusPersonTxt);

				if (statusPersonTxt.equals(existingPersonName)) {
					By statusLinkXpath = By.xpath("//*[@id='" + atributeValue + "']/td[9]");
					// WebElement statusLinkButton = driver.findElement(statusLinkXpath);
					wait.until(ExpectedConditions.presenceOfElementLocated(statusLinkXpath)).click();
					reportLog(Status.PASS, "Compliance status is clicked.", true);
					// statusLinkButton.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Except is in following object ::" + e);
		}
	}

	// -------------------------Search action-------------------------//

	// existing values from adding user

	public void searchUserByValue(String value, String pageName) {
		try {
			wait(3);

			By searchXpath;
			switch (pageName.toLowerCase()) {
			case "administration":
				if (value.equalsIgnoreCase("FN")) {
					searchText = existingFirstName;
					searchXpath = nuiAdministrationPage.firstNameText;
				} else if (value.equalsIgnoreCase("LN")) {
					searchText = existingLastName;
					searchXpath = nuiAdministrationPage.lastNameText;
				} else if (value.equalsIgnoreCase("email")) {
					searchText = existingEmail;
					searchXpath = nuiAdministrationPage.emailText;
				} else {
					searchText = Random_StringGenerator(5);
					searchXpath = nuiAdministrationPage.firstNameText;
				}
				break;

			case "people":
				if (value.equalsIgnoreCase("FN")) {
					searchText = existingFirstName;
					searchXpath = nuiPeoplePage.firstName;
				} else if (value.equalsIgnoreCase("LN")) {
					searchText = existingLastName;
					searchXpath = nuiPeoplePage.lastName;
				} else if (value.equalsIgnoreCase("SSN")) {
//					searchText = _dataRepo.getData("SSN");
					searchText = existingSSN.substring(existingSSN.length() - 4);
					searchXpath = nuiPeoplePage.sSN;
				} else {
					searchText = Random_StringGenerator(5);
					searchXpath = nuiPeoplePage.firstName;
				}
				break;

			case "package selection":
				if (value.equalsIgnoreCase("package")) {
					searchText = _dataRepo.getData("Package");
					searchXpath = nuiPackageSelectionPage.searchPackage;
					packageName = searchText;
				} else {
					searchText = Random_StringGenerator(5);
					searchXpath = nuiPackageSelectionPage.searchPackage;
				}
				break;

			case "shopping cart":
				if (value.equalsIgnoreCase("package")) {
					searchText = _dataRepo.getData("Package");
					searchXpath = nuiShoppingCartPage.searchShoppingCart;
					packageName = searchText;
				} else {
					searchText = Random_StringGenerator(5);
					searchXpath = nuiShoppingCartPage.searchShoppingCart;
				}
				break;

			case "program owner":
				if (value.equalsIgnoreCase("Provider")) {
					searchText = "AutoVendor";
//							_dataRepo.getData("ActiveProvider");
					providerName = searchText;
					searchXpath = nuiProgramOwner.searchField;

				} else {
					searchText = Random_StringGenerator(5);
					searchXpath = nuiProgramOwner.searchField;
				}
				break;

			default:
				searchText = value;
				searchXpath = nuiPackageSelectionPage.searchPackage;
			}

			EnterText(searchXpath, "enter search by ", searchText);

			reportLog(Status.PASS, "Searching a user by " + searchText, true);
			reportLog(Status.PASS, "Searching a user", true);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// multiple search values

	public void searchUserByMultiValue(String[] values, String pageName) {
		try {

			By searchXpath = null;

			switch (pageName.toLowerCase()) {
			case "administration":
				searchTextFN = null;
				searchTextLN = null;
				searchTextEmail = null;
//				searchText = null;
				// searchTextSsn = null;
				for (String value : values) {
					if (value.contains("FN")) {
						searchTextFN = existingFirstName;
						searchXpath = nuiAdministrationPage.firstNameText;
						EnterText(searchXpath, "enter search by ", searchTextFN);
						searchText += searchTextFN + " ";

					} else if (value.contains("LN")) {
						searchTextLN = existingLastName;
//						existingLastName;
						searchXpath = nuiAdministrationPage.lastNameText;
						EnterText(searchXpath, "enter search by ", searchTextLN);
						searchText += searchTextLN + " ";

					} else if (value.contains("Email")) {
						searchTextEmail = existingEmail;
						searchXpath = nuiAdministrationPage.emailText;
						EnterText(searchXpath, "enter search by ", searchTextEmail);
						searchText += searchTextEmail + " ";

					} else if (value.contains("SSN")) {
						searchTextSsn = existingSSN.substring(existingSSN.length() - 4);
						searchXpath = nuiPeoplePage.sSN;
						EnterText(searchXpath, "enter search by ", searchTextSsn);
						searchText += searchTextSsn + " ";
					}
				}
				reportLog(Status.PASS, "Searching a user by multisearch", true);
				reportLog(Status.PASS, "Searching a user", true);
				break;

			case "people":
				searchTextFN = null;
				searchTextLN = null;
				searchTextSsn = null;
				searchText = "";

				for (String value : values) {
					if (value.contains("FN")) {
//						existingfirstName= "TestSanityYBL";
//						existingMiddleName = "JuneFWB";
//						searchTextFN = _dataRepo.getData("FirstName");
						searchTextFN = existingFirstName;
						searchXpath = nuiAdministrationPage.firstNameText;
						EnterText(searchXpath, "enter search by ", searchTextFN);
						searchText = searchText + " " + searchTextFN + " ";

					} else if (value.contains("LN")) {

//						existingLastName = "NineBBI";
						searchTextLN = existingLastName;
						searchXpath = nuiAdministrationPage.lastNameText;
						EnterText(searchXpath, "enter search by ", searchTextLN);
						searchText = searchText + " " + searchTextLN + " ";

					} else if (value.contains("SSN")) {
						searchTextSsn = existingSSN.substring(existingSSN.length() - 4);
//						searchTextSsn = existingSSN.substring(5, 9);
						searchXpath = nuiPeoplePage.sSN;
						EnterText(searchXpath, "enter search by ", searchTextSsn);
						searchText = searchText + " " + searchTextSsn;

					}
				}
				reportLog(Status.PASS, "Searching a user by multisearch", true);
				reportLog(Status.PASS, "Searching a user", true);
				break;
				
			case "pow":
				searchTextFN = null;
				searchTextLN = null;
				searchText = null;
				for (String value : values) {
					if (value.contains("FN")) {
						searchTextFN = existingFirstName;
						searchXpath = nuiAdministrationPage.firstNameText;
						EnterText(searchXpath, "enter search by ", searchTextFN);
						searchText = searchTextFN + " ";
					} else if (value.contains("LN")) {
						searchTextLN = existingLastName;
						searchXpath = nuiAdministrationPage.lastNameText;
						EnterText(searchXpath, "enter search by ", searchTextLN);
						searchText += searchTextLN;
					}
				}
				reportLog(Status.PASS, "Searching a user by multisearch", true);
				reportLog(Status.PASS, "Searching a user", true);
				break;
			default:
				throw new Exception("No such Page");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// --------------Search all data in table trough pagination using public
	// fields---------------//

	public boolean pageRowVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			By rowElement = null;
			switch (pageName.toLowerCase()) {

			case "administration":
				String name = existingFirstName + " " + existingLastName;
				String role = existingRole.substring(0, 1).toUpperCase() + existingRole.substring(1).toLowerCase();
				if (identifierValue.equalsIgnoreCase("createdUser")) {
					rowElement = By.xpath("//table/tbody/tr[td[position()=2 and contains(text(), '" + name
							+ "')] and td[position()=4 and contains(text(), '" + existingEmail + "')]]");
				} else {
					rowElement = By.xpath("//table/tbody/tr[td[contains(text(), '" + name
							+ "')] and td[contains(text(), '" + existingUserID + "')] " + "and td[contains(text(), '"
							+ existingEmail + "')] and td[contains(text(), '" + role + "')] "
							+ "and td/div[contains(text(), '" + existingStatus + "')]]");
				}
			break;
			case "xtdconnect":
				String FullName = _dataRepo.getData("FullName");
				String lastfourSSN = _dataRepo.getData("lastfourSSN");
				if (identifierValue.equalsIgnoreCase("xtdConnectUser")) {
					rowElement = By.xpath("//tr[//a[contains(text(),'" +FullName+"')] and td[contains(text(),'"+lastfourSSN+"')]]");
					System.out.println("Order is present");
				} else {
					rowElement = By.xpath("//table/tbody/tr[td[contains(text(), '" + FullName
							+ "')] and td[contains(text(), '" + existingUserID + "')] " + "and td[contains(text(), '"
							+ existingssnNumber + "')] and td[contains(text(), '" + lastfourSSN + "')] "
							+ "and td/div[contains(text(), '" + existingStatus + "')]]");
					System.out.println("Order is Not present");
				}
			break;
			case "xtdconnectModal":
				String FLName = _dataRepo.getData("FullName");
				if (identifierValue.equalsIgnoreCase("xtdConnectUserModal")) {
					rowElement = By.xpath("(//h6[normalize-space()='" +FLName+"'])[1]");
					System.out.println("Order is present");
				} else {
					rowElement = By.xpath("//table/tbody/tr[td[contains(text(), '" + FLName + "')]]");
					System.out.println("Order is Not present");
				}
			break;

			default:
				throw new Exception("No such Page");

			}

			WebDriverWait wait = new WebDriverWait(driver, 10);
			By xpathPagination = By
					.xpath("//ul[@class='pagination']/li[contains(@class,'pagination-page page-item')]/a");
			wait.until(ExpectedConditions.presenceOfElementLocated(xpathPagination));
			List<WebElement> pagination = driver.findElements(xpathPagination);

			for (int i = 1; i <= pagination.size(); i++) {
				wait(4);
				Boolean isPresent = driver.findElements(rowElement).size() > 0;
				if (isPresent == true) {
//					System.out.println("User is present in User table - " + rowElement);
					reportLog(Status.PASS, "User is present in User table - " + rowElement, true);
					return true;
				} else {
					reportLog(Status.FAIL, "User isn't present in User table - " + rowElement, true);
					WebElement xpathPage = driver.findElement(By.xpath(
							"//ul[@class='pagination']/li[contains(@class,'pagination-page page-item')]/a[contains(text(),'"
									+ i + "')]"));
					wait(2);
					xpathPage.click();
				}

			}
		} catch (Exception ex) {
			logStepInfo("Failed - Error in function pageRowVerifyWithValue: " + ex.getMessage());
			reportLog(Status.FAIL, "Failed in this Step -check logs for more details:- " + ex.getMessage(), false);
			scenarioFailed();
		}
		return false;
	}

	// -------------------------Validations-------------------------//
	public void pageButtonVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			wait(2);
			switch (pageName.toLowerCase()) {
			case "administration":
				if (identifierValue.equalsIgnoreCase("search")) {
					verifyElementValue(nuiAdministrationPage.searchButton, identifierValue);
				} else if (identifierValue.equalsIgnoreCase("Action")) {
					verifyElementPresence(nuiAdministrationPage.userActionButton, identifierValue);
				} else if (identifierValue.equalsIgnoreCase("Edit User")) {
					verifyElementPresence(nuiAdministrationPage.userEditNavButton, identifierValue);
					// Monika added this for CC Payment Method Page
				} else if (identifierValue.equalsIgnoreCase("Save Card")) {
					verifyElementPresence(nuiAdministrationPage.saveCreditCard, identifierValue);
				}
				reportLog(Status.PASS, "Button verify with value " + identifierValue, false);
				break;
			case "business confirmation":
				wait(2);
				if (identifierValue.contains("Edit")) {
					identifierValue = identifierValue.replaceAll(" Edit", "");
					By xpath = By.xpath("//*[contains(text(),'Edit') and contains(@id,'" + identifierValue + "')]");
					verifyElementText(xpath, "Edit");
				} else {
					By xpath = By.xpath("//*[contains(text(),'" + identifierValue + "')]");
					verifyElementPresence(xpath);
					reportLog(Status.PASS, "Button verify with value " + identifierValue, false);
				}
				reportLog(Status.PASS, "Button verify with value " + identifierValue, false);
				break;
			
			case "Payment Method":
				if (identifierValue.contains("Use a new payment method")) {
					verifyElementPresence(nuiPaymentMethodPage.useNewPaymentMethod);
				} else {
					By xpath = By.xpath("//*[contains(text(),'" + identifierValue + "')]");
					verifyElementPresence(xpath);
					reportLog(Status.PASS, "Button verify with value " + identifierValue, false);
				}
				reportLog(Status.PASS, "Button verify with value " + identifierValue, false);
				break;
							
			default:
//				By createdXPATH = createDynamicXpath("button", identifierValue, "Xpath for title created");
				By xpath = By.xpath("//*[contains(text(),'" + identifierValue + "')]");
				verifyElementPresence(xpath);
				reportLog(Status.PASS, "Button verify with value " + identifierValue, false);
			}

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
			reportLog(Status.FAIL, "Button not verify with value " + identifierValue + " " + ex.getMessage(), false);
		}

	}

	public void menuButtonVerifyPresent(String buttonName) throws Exception {
		try {
			By createdXPATH = createDynamicXpath("menu", buttonName, "Xpath for title created");

			if (buttonName.equalsIgnoreCase("search")) {
				verifyElementPresence(nuiAdministrationPage.searchButton, buttonName);
			} else if (buttonName.equalsIgnoreCase("User Management") || buttonName.equalsIgnoreCase("Your Payments")) {
				createdXPATH = createDynamicXpath("sub-menu", buttonName, "Xpath for title created");
			}

			wait(2);
			verifyElementPresence(createdXPATH, buttonName);

//			verifyElementPresentClass(createdXPATH, "menuItem");	

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

	public void TextVerifyPresent(String value, String pageName) throws Exception {
		try {

			switch (pageName.toLowerCase()) {
			case "order confirmation":
				if (verifyElementPresence(By.xpath("//table/tbody/tr[1]/td/b"))) {
					if (!(driver.findElement(By.xpath("//table/tbody/tr[1]/td/b")).getText()).isEmpty()) {
						reportLog(Status.PASS, "Element Present and not empty " + value, false);
					}
				} else {
					reportLog(Status.FAIL, "Element Not Present " + value, false);
				}
				break;

			case "payment method":
				By ccType = By.xpath("//*[contains(@class, 'bg-cards-" + value + "')]");

				if (value.contains("visa")) {
					verifyElementPresence(ccType);
					reportLog(Status.PASS, "Element is Present: " + value, false);
				} else if (value.contains("master")) {
					verifyElementPresence(ccType);
					reportLog(Status.PASS, "Element is Present: " + value, false);
				} else if (value.contains("amex")) {
					verifyElementPresence(ccType);
					reportLog(Status.PASS, "Element is Present: " + value, false);
				} else {
					reportLog(Status.FAIL, "Element Not Present: " + value, false);
				}
				break;

			case "administration":
				if (value.equalsIgnoreCase("Role")) {
					verifyElementPresence(By.xpath("//*[contains (@data-label, 'Role')]"));
					String vendorRole = driver.findElement(By.xpath("//*[contains (@data-label, 'Role')]")).getText();
					if (!(vendorRole).isEmpty()) {
						reportLog(Status.PASS, "Role value is present: " + vendorRole, false);
						logStepInfo("Role value is present: " + vendorRole);
					}
					else {
					reportLog(Status.FAIL, "Role is not present", false);
					}
				} else if (value.equalsIgnoreCase("Status")) {
					verifyElementPresence(By.xpath("//*[contains (@data-label, 'Status')]"));
					String vendorStatus= driver.findElement(By.xpath("//*[contains (@data-label, 'Status')]")).getText();
					if (!(vendorStatus).isEmpty()) {
						reportLog(Status.PASS, "Vendor Status value is present: " + vendorStatus, false);
						logStepInfo("Vendor Status value is present: " + vendorStatus);
					}
					else {
					reportLog(Status.FAIL, "Vendor Status is not present", false);
					}		
				}
				break;	
				
			default:
				if (verifyElementPresence(By.xpath("//*[contains(text(),'" + value + "')]"))) {
					reportLog(Status.PASS, "Element Present " + value, false);
				} else {
					reportLog(Status.FAIL, "Element Not Present " + value, false);
				}
				break;
			}

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

	public void pageObjectVerifyWithValueNotPresent(String identifierName, String identifierValue, String pageName)
			throws Exception {
		try {
			By createdXPATH;
			if (identifierName.equalsIgnoreCase("menubutton")) {
				createdXPATH = createDynamicXpath("menu", identifierValue, "Xpath for title created");
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

	public void VerifyIdentifierWithValue(String identifierValue, String Value) throws Exception {
		try {

			By createdXPATH = By.xpath("[contains(text(),'" + Value + "')]");
			System.out.println("Created Xpath is ::" + createdXPATH);
			verifyElementText(createdXPATH, Value);

		} catch (Exception ex) {
			System.out.println("error in following line::" + ex.getMessage());
		}
	}

	public void pageTextVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			String existingValue = null;
			By xpathFields;
			switch (pageName.toLowerCase()) {
			case "administration":
				wait(2);
				if (identifierValue.contains("At least")) {
					xpathFields = By.xpath(
							"//small[contains(text(),'" + identifierValue + "')]/fa-icon/*[@data-icon='check-circle']");
					verifyElementText(xpathFields, identifierValue);
				}
				break;

			case "order confirmation":
				if (identifierValue.equalsIgnoreCase("Vendor email")) {
					existingValue = _dataRepo.getData(identifierValue);
					xpathFields = By.xpath("//table/tbody/tr[3]/td/b");

				} else if (identifierValue.equalsIgnoreCase("Paid via")) {
					existingValue = _dataRepo.getData(identifierValue);
					xpathFields = By.xpath("//table/tbody/tr[2]/td/b");

				} else if (identifierValue.equalsIgnoreCase("Credit Card Number")) {
					existingValue = ccNumberMask;
					xpathFields = By.xpath("//table/tbody/tr[2]/td/b");

				} else if (identifierValue.contains("Transaction Number")) {
					String transactionNumber = driver.findElement(By.xpath("//table/tbody/tr[1]/td/b")).getText();
					existingValue = transactionNumber;
					xpathFields = By.xpath("//table/tbody/tr[1]/td/b");

				} else {
					existingValue = identifierValue;
					xpathFields = By.xpath("//*[contains(text(),'" + existingValue + "')]");
				}
				
				verifyElementText(xpathFields, existingValue);
				break;

			case "package selection":
				wait(2);
				if (identifierValue.equalsIgnoreCase("Price")) {
					existingValue = _dataRepo.getData("Price");
					xpathFields = By.xpath("//td/*[text()=' $" + existingValue + " ']");
					verifyElementText(xpathFields, existingValue);
				}
				break;

			case "shopping cart":
				wait(2);
				if (identifierValue.contains("existing")) {
					String searchValue = identifierValue.replace("existing ", "");
					xpathFields = By.xpath("//*[@data-label='" + searchValue + "']");

				}else if (identifierValue.equalsIgnoreCase("person")) {
						 existingValue = existingFirstName + " " + existingLastName;
						xpathFields = By.xpath("//*[contains(text(),'" + existingValue + "')]");
					} 
//						else {
//						existingValue = _dataRepo.getData(searchValue);
//					}
//
//				} 
			else if (identifierValue.contains("Package Name")) {
					existingValue = _dataRepo.getData("Package");
					xpathFields = By.xpath("//*[contains (text(), '" + existingValue + "')]");
					
				} else if (identifierValue.equalsIgnoreCase("Subtotal")) {
					existingValue = packagePrice;
					// existingValue= _dataRepo.getData("Price");
					// packagePrice = existingValue;
					xpathFields = By.xpath("//*[text()='Subtotal:$" + existingValue + "']");

				} else if (identifierValue.equalsIgnoreCase("Tax")) {
					existingValue = _dataRepo.getData("Tax");
					xpathFields = By.xpath("(//*[text()='Tax: $" + existingValue + "'])[1]");
					
				} else if (identifierValue.equalsIgnoreCase("Order Total")) {
					TaxAmount = driver.findElement(By.xpath("//*[contains(@class, 'card-text') and contains(., 'Tax')]")).getText();
					//TaxAmount = TaxAmount.replace("Tax: $", "").trim();
					TaxAmount = TaxAmount.substring(TaxAmount.length() - 4);
					System.out.println(TaxAmount);
					double total = Double.parseDouble(packagePrice) + Double.parseDouble(TaxAmount);
					existingValue = String.format("%,.2f", total);
					System.out.println("total: " + existingValue);
					xpathFields = By.xpath("//*[text()='Order Total: $" + existingValue + "']");

				} else {
					existingValue = identifierValue;
					xpathFields = By.xpath("//*[contains(text(),'" + existingValue + "')]");
				}
				verifyElementText(xpathFields, existingValue);
				break;

			case "payment method":
				wait(2);
				if (identifierValue.equalsIgnoreCase("Subtotal")) {
					existingValue = packagePrice;
					xpathFields = By.xpath("//*[text()='Subtotal :$" + existingValue + "']");
					
				} else if (identifierValue.equalsIgnoreCase("Subtotal_VendorOnboarding")) {
					existingValue = _dataRepo.getData("Price_VO");
					packagePrice = existingValue;
					xpathFields = By.xpath("//*[text()='Subtotal : $" + existingValue + "']");	

				} else if (identifierValue.equalsIgnoreCase("Tax")) {
					existingValue = _dataRepo.getData("Tax");
					xpathFields = By.xpath("//*[text()='Tax : $" + existingValue + "']");
					
				} else if (identifierValue.equalsIgnoreCase("Tax_VendorOnboarding")) {
					existingValue = _dataRepo.getData("Tax_VO");
					xpathFields = By.xpath("//*[text()='Tax : $" + existingValue + "']");	

				} else if (identifierValue.contains("Order Total")) {
					TaxAmount = driver.findElement(By.xpath("//*[contains(@class, 'card-text') and contains(., 'Tax')]")).getText();
					TaxAmount = TaxAmount.substring(TaxAmount.length() - 4);
					//TaxAmount = TaxAmount.replace("Tax: $", "").trim();
					System.out.println(TaxAmount);
					double total = Double.parseDouble(packagePrice) + Double.parseDouble(TaxAmount);
					existingValue = String.format("%,.2f", total);
					System.out.println("total: " + existingValue);
					orderTotal = existingValue;
					xpathFields = By.xpath("//*[text()='Order Total : $" + existingValue + "']");

				} else {
					existingValue = identifierValue;
					xpathFields = By.xpath("//*[contains(text(),'" + existingValue + "')]");
				}
				verifyElementText(xpathFields, existingValue);
				break;	
				
				
			case "outstanding balance":
				if (identifierValue.equalsIgnoreCase("Name")) {
					existingValue = existingFirstName + " " + existingLastName;
					xpathFields = By.xpath("//*[text()='" + existingValue + "']");

				} else if (identifierValue.contains("Date")) {
					String now = LocalDate.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("MM-dd-yyyy")).replaceAll("-", "/");
					System.out.println(now);
					existingValue = now;
					xpathFields = By.xpath("//*[text()='"+existingValue+"']");
					

				} else if (identifierValue.contains("Additional Charge")) {
					existingValue = _dataRepo.getData("Package");
					xpathFields = By.xpath("//*[text()='"+existingValue+"']");
				
				} else if (identifierValue.contains("Balance Outstanding")) {
					existingValue = orderTotal;
					xpathFields = By.xpath("//*[text()='$"+existingValue+"']");	
					
				} else {
					existingValue = identifierValue;
					xpathFields = By.xpath("//*[contains(text(),'" + existingValue + "')]");
				}
				verifyElementText(xpathFields, existingValue);
				break;
				
			case "business signature":
				wait(5);
				xpathFields = By.xpath("//form");
				if (identifierValue.contains("Business Description")) {
					existingValue = existingBusinessDesc;
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.contains("Employment Purpose")) {
					existingValue = "YES";
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.equalsIgnoreCase("Name")) {
					existingValue = existingBusinesContactName;
					// exhibit A
					reportLog(Status.INFO, "Verifying element " + existingValue + " in exhibit A", false);
					verifyElementText(xpathFields, existingValue);
					// before exhibit A
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.contains("Title")) {
					existingValue = existingBusinessTitle;
					// exhibit A
					reportLog(Status.INFO, "Verifying element " + existingValue + " in exhibit A", false);
					verifyElementText(xpathFields, existingValue);
					// before exhibit A
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.contains("Date")) {
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					existingValue = formatter.format(date);
					// first paragraph
					reportLog(Status.INFO, "Verifying element " + existingValue + " in first paragraph", false);
					verifyElementText(xpathFields, existingValue);
					// exhibit A
					reportLog(Status.INFO, "Verifying element " + existingValue + " in exhibit A", false);
					verifyElementText(xpathFields, existingValue);
					// before exhibit A client
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A for client",
							false);
					verifyElementText(xpathFields, existingValue);
					// before exhibit A provider
					reportLog(Status.INFO, "Verifying element " + existingValue + " in exhibit A for Service Provider",
							false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.contains("Client")) {
					existingValue = existingBusinessName;
					// first paragrph
					reportLog(Status.INFO, "Verifying element " + existingValue + " in first paragraph", false);
					verifyElementText(xpathFields, existingValue);
					// before exhibit A
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.contains("Address")) {
					existingValue = existingBusinessAddress;
					reportLog(Status.INFO, "Verifying element " + existingValue + " in first paragraph", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.contains("Sponsor")) {
					existingValue = driver.getTitle();
					reportLog(Status.INFO, "Verifying element " + existingValue + " in second paragraph", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.equalsIgnoreCase("Provider Name")) {
					existingValue = "Bret T. Jardine";
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.equalsIgnoreCase("Provider Title")) {
					existingValue = "EVP, General Counsel";
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.equalsIgnoreCase("Service Provider")) {
					existingValue = "First Advantage Enterprise Screening Corporation";
					reportLog(Status.INFO, "Verifying element " + existingValue + " before exhibit A", false);
					verifyElementText(xpathFields, existingValue);

				} else {
					existingValue = identifierValue;
					xpathFields = By.xpath("//*[contains(text(),'" + existingValue + "')]");
					verifyElementText(xpathFields, existingValue);
				}

				break;

			case "business confirmation":
				wait(2);
				String[] value = identifierValue.split("-");
				if (identifierValue.equalsIgnoreCase("Business Information-Name")) {
					existingValue = existingBusinessName;
				} else if (identifierValue.equalsIgnoreCase("Billing Contact Information-Name")) {
					existingValue = existingBusinesContactName;
				} else if (identifierValue.equalsIgnoreCase("Business Information-Doing Business As")) {
					existingValue = exisingDoingBusinessAs.trim();
				} else if (value[1].equalsIgnoreCase("Email")) {
					existingValue = existingBusinessContactEmail;
				} else if (value[1].equalsIgnoreCase("Address")) {
					existingValue = existingBusinessAddress;
				} else {
					existingValue = existingBusinesContactName;
				}
				// System.out.println(existingValue);

				if (value[1].equalsIgnoreCase("Address")) {
					String[] values = existingValue.split(",");

					xpathFields = By.xpath("(//*[contains(text(),'" + value[0] + "')]//following::div[contains(text(),'"
							+ value[1] + "')]//following-sibling::p)[1]");
					String existingValueAddress1 = values[0];
					verifyElementText(xpathFields, existingValueAddress1);

					xpathFields = By.xpath("(//*[contains(text(),'" + value[0] + "')]//following::div[contains(text(),'"
							+ value[1] + "')]//following-sibling::p/following-sibling::p)[2]");
					String extstingValueAddress2 = values[1].trim() + "," + values[2] + values[3];
					verifyElementText(xpathFields, extstingValueAddress2);

				} else {
					xpathFields = By.xpath("(//*[contains(text(),'" + value[0] + "')]//following::div[contains(text(),'"
							+ value[1] + "')]//following-sibling::p)[1]");
					// System.out.println(driver.findElement(xpathFields).getText());
					verifyElementText(xpathFields, existingValue);
				}

				break;

			case "Registration Complete":
				if (identifierValue.equalsIgnoreCase("Welcome")) {
					existingValue = "Welcome to First Advantage,";
					xpathFields = By.xpath("//*[contains (text(), 'Welcome to First Advantage,')]");
					verifyElementText(xpathFields, existingValue);

				} else if (identifierValue.equalsIgnoreCase("Vendor User Name")) {
					existingValue = existingBusinesContactName;
					xpathFields = By.xpath("//div/div[2]/div/h5[2]");
					verifyElementText(xpathFields, existingValue);
				}
				break;
			default:

				System.out.println("Idnetifier is :: " + identifierValue);
				By createdXPATH = createDynamicXpath("title", identifierValue, "Xpath for title created");
				System.out.println("Created Xpath is :: " + createdXPATH);
				verifyElementText(createdXPATH, identifierValue);
				break;
			}
		} catch (Exception ex) {
			System.out.println("error in following line::" + ex.getMessage());
		}
	}

	public void verifyTableValue(String condition, String tableName, String ColumnName, String ColumnValue)
			throws Exception {

		String result = null;
		String xColName;
		String xColVal;
		List<WebElement> table = driver.findElements(By.xpath("//th"));
		WebDriverWait wait = new WebDriverWait(driver, 20);

		for (int i = 1; i <= table.size(); i++) {

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + ColumnName + "')]")));
			xColName = driver.findElement(By.xpath("//th[contains(text(),'" + ColumnName + "')]")).getText();

			if (xColName.equalsIgnoreCase(ColumnName)) {
				wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'" + ColumnName + "')]/following::tr[1]/td[" + i + "]")));
				xColVal = driver
						.findElement(
								By.xpath("//*[contains(text(),'" + ColumnName + "')]/following::tr[1]/td[" + i + "]"))
						.getText();
				if (xColVal.equalsIgnoreCase(ColumnValue)) {
					result = "Present";
					break;
				} else {
					result = "Absent";
				}
			}
		}

		if (result.equalsIgnoreCase("Present") && condition.equalsIgnoreCase("Present")) {
			reportLog(Status.PASS, "Colum Value is present in User table - " + ColumnValue, true);
		} else if (result.equalsIgnoreCase("Absent") && condition.equalsIgnoreCase("Absent")) {
			reportLog(Status.PASS, "Colum Value is not present in User table - " + ColumnValue, true);
		} else if (result.equalsIgnoreCase("Present") && condition.equalsIgnoreCase("Absent")) {
			reportLog(Status.FAIL, "Colum Value is present in User table - " + ColumnValue, true);
		} else if (result.equalsIgnoreCase("Absent") && condition.equalsIgnoreCase("Present")) {
			reportLog(Status.FAIL, "Colum Value is not present in User table - " + ColumnValue, true);
		}

	}

	public String verifyStatusExistingPerson(String condition, String status) throws Exception {

		String result = null;
		List<WebElement> rowXpath = driver.findElements(By.xpath("//table/tbody/tr"));
		for (int i = 0; i <= rowXpath.size(); i++) {

			String atributeValue = "panel-" + i;
			By statusXpath = By.xpath("//*[@id='" + atributeValue + "']/td[8]/div");
			By personNameXpath = By.xpath("//*[@id='" + atributeValue + "']/td[2]");
			String statusTxt = driver.findElement(statusXpath).getText();
			String personTxt = driver.findElement(personNameXpath).getText();

			if (personTxt.equalsIgnoreCase(existingFullName)) {
				if (statusTxt.equalsIgnoreCase(status)) {
					return result = "Present";
				} else {
					return result = "Absent";
				}
			}

		}

//		if (result.equalsIgnoreCase("Present") && condition.equalsIgnoreCase("Present")) {
//			reportLog(Status.PASS, "Person status value is present for " + existingFullName, true);
//		} else if (result.equalsIgnoreCase("Absent") && condition.equalsIgnoreCase("Absent")) {
//			reportLog(Status.PASS, "Person status value is not present for " + existingFullName, true);
//		} else if (result.equalsIgnoreCase("Present") && condition.equalsIgnoreCase("Absent")) {
//			reportLog(Status.FAIL, "Person status value is present for " + existingFullName, true);
//		} else if (result.equalsIgnoreCase("Absent") && condition.equalsIgnoreCase("Present")) {
//			reportLog(Status.FAIL, "Person status value is not present for " + existingFullName, true);
//		}
		return result;

	}

	public void pageMessage(String identifyerName, String identifierText, String pageName) throws Exception {
		try {
			switch (identifyerName.toLowerCase()) {
			case "errormsg-newui": {
				if (pageName.equalsIgnoreCase("create person")) {
					wait(2);
					By message = By.xpath("(//*[contains(@class,'d-block') and contains(text(),'"+ identifierText +"')])");
					String MessageTxt = driver.findElement(message).getText();
					verifyMessageTxt(MessageTxt, identifierText);
				} else {
					wait(2);
					By message = By.xpath("(//*[contains(@class,'text-danger') and contains(text(),'"+ identifierText +"')])");
					String MessageTxt = driver.findElement(message).getText();
					verifyMessageTxt(MessageTxt, identifierText);
				}

				reportLog(Status.PASS, "Element Present " + identifierText, false);
				logStepInfo("See " + identifierText);
			}
				break;
			case "xtdConnectErrormsg-newui": {
				if (pageName.equalsIgnoreCase("XtdConnect")) {
					wait(2);
					By message = By.xpath("(//*[contains(@class,'d-block') and contains(text(),'"+ identifierText +"')])");
					String MessageTxt = driver.findElement(message).getText();
					verifyMessageTxt(MessageTxt, identifierText);
				} else {
					wait(2);
					By message = By.xpath("(//*[contains(@class,'text-danger') and contains(text(),'"+ identifierText +"')])");
					String MessageTxt = driver.findElement(message).getText();
					verifyMessageTxt(MessageTxt, identifierText);
				}

				reportLog(Status.PASS, "Element Present " + identifierText, false);
				logStepInfo("See " + identifierText);
			}
				break;

			case "successMessage-newui": {
				By message = By.xpath("//*[@id='successMessages']");
				String MessageTxt = driver.findElement(message).getText();
				verifyMessageTxt(MessageTxt, identifierText);
				reportLog(Status.PASS, "Element Present " + identifierText, false);
				logStepInfo("See " + identifierText);
			}
				break;

			default:
				break;

			}
		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
			reportLog(Status.FAIL, "Element NOT Present " + identifierText, false);
		}
	}

	public void pageMessageForElement(String identifyerName, String identifierText, String identifierElement,
			String pageName) throws Exception {
		try {
			switch (identifyerName.toLowerCase()) {
			case "errormsg-newui": {
				if (pageName.equalsIgnoreCase("Payment method")) {
					if (identifierElement.contains("First Name")) {
						By message = By
								.xpath("//div[3]/div[2]/div[1]/small[contains(text(),'" + identifierText + "')]");
						String MessageTxt = driver.findElement(message).getText();
						verifyMessageTxt(MessageTxt, identifierText);
					} else if (identifierElement.contains("Last Name")) {
						By message = By
								.xpath("//div[3]/div[2]/div[2]/small[contains(text(),'" + identifierText + "')]");
						String MessageTxt = driver.findElement(message).getText();
						verifyMessageTxt(MessageTxt, identifierText);
					} else if (identifierElement.contains("CC Number")) {
						By message = By.xpath("//div[3]/xf-credit-card/form/div[1]/div/small[contains(text(),'"
								+ identifierText + "')]");
						String MessageTxt = driver.findElement(message).getText();
						verifyMessageTxt(MessageTxt, identifierText);
					} else if (identifierElement.contains("MM")) {
						By message = By.xpath("//div[3]/xf-credit-card/form/div[2]/div[1]/div/small[contains(text(),'"
								+ identifierText + "')]");
						String MessageTxt = driver.findElement(message).getText();
						verifyMessageTxt(MessageTxt, identifierText);

					} else if (identifierElement.contains("YY")) {
						LocalDate local_time = LocalDate.now();
						DateTimeFormatter format_localTime = DateTimeFormatter.ofPattern("yy");
						String localDate = local_time.format(format_localTime);

						// if ()

						By message = By.xpath("//div[3]/xf-credit-card/form/div[2]/div[2]/div/small[contains(text(),'"
								+ identifierText + "')]");
						String MessageTxt = driver.findElement(message).getText();
						verifyMessageTxt(MessageTxt, identifierText);

					} else if (identifierElement.contains("CSC")) {
						By message = By
								.xpath("//div[3]/xf-credit-card/form/div[2]/div[4]/div[2]/small[contains(text(),'"
										+ identifierText + "')]");
						String MessageTxt = driver.findElement(message).getText();
						verifyMessageTxt(MessageTxt, identifierText);
					}
					String errormsg = "Error message: " + identifierElement + " for " + identifierText;
					logStepInfo("See " + errormsg);
					reportLog(Status.PASS, "Element Present " + errormsg, false);
				}
			}
				break;

			default:
				break;

			}
		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
			reportLog(Status.FAIL, "Element NOT Present " + identifierText, false);
		}
	}

	public void passBarVerifyWithValue(String identifierValue, String pageName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (verifyElementPresence(By.xpath("//*[contains(text(),'" + identifierValue + "')]"))) {
				By passBar = By.xpath("//div[@class='mx-1 empty-bar']/div[not(@hidden)]");
				wait.until(ExpectedConditions.presenceOfElementLocated(passBar));
				int passBarCount = driver.findElements(passBar).size();
				switch (identifierValue) {
				case "Very Weak":
					if (passBarCount == 1) {
						System.out.println("Password Bar is present with " + passBarCount + " bar.");
						reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
					}
					break;
				case "Weak":
					if (passBarCount == 2) {
						System.out.println("Password Bar is present with " + passBarCount + " bar.");
						reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
					}
					break;
				case "Moderate":
					if (passBarCount == 3) {
						System.out.println("Password Bar is present with " + passBarCount + " bar.");
						reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
					}
					break;
				case "Strong":
					if (passBarCount == 4) {
						System.out.println("Password Bar is present with " + passBarCount + " bar.");
						reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
					}
					break;
				case "Very Strong":
					if (passBarCount == 5) {
						System.out.println("Password Bar is present with " + passBarCount + " bar.");
						reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
					}
					break;
				default:
					passBar = By.xpath("//div[@class='mx-1 empty-bar']/div[@hidden]");
					passBarCount = driver.findElements(passBar).size();
					if (passBarCount == 5) {
						System.out.println("Password Bar is present with " + passBarCount + " bar.");
						reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
					}
					break;
				}

			} else {
				reportLog(Status.FAIL, "Element Not Present " + identifierValue, false);
			}

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

	// -------------------------Enter text-------------------------//
	public void enterText(String Value, String textField, String pageName) throws Exception {
		try {

			wait(2);
			if (textField.equalsIgnoreCase("FN")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				} else if (Value.equalsIgnoreCase("empty")) {
					Value = "              ";
				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("FirstName") + Random_StringGenerator(3);
					existingFirstName = Value;
				} else if (Value.equalsIgnoreCase("validprod")) {
					Value = _dataRepo.getData("FirstName");
					existingFirstName = Value;
				} else if (Value.equalsIgnoreCase("min")) {
					Value = Random_StringGenerator(1);
				} else if (Value.equalsIgnoreCase("present")) {
					Value = existingFirstName;
				} else if (Value.equalsIgnoreCase("random")) {
					Value = Random_StringGenerator(5);
					existingFirstName = Value;
				}else if (Value.equalsIgnoreCase("CompliantOrder")) {
					Value = _dataRepo.getData("FirstName");
					existingFirstName = Value;
				}else if (Value.equalsIgnoreCase("NonCompliantOrder")) {
							Value = _dataRepo.getData("FirstName") + Random_StringGenerator(3);
							existingFirstName = Value;
					}
				
				System.out.println("Value of " + textField + " ::" + Value);

				if (pageName.equalsIgnoreCase("Administration")) {
					EnterText(nuiAdministrationPage.firstNameField, "Vendor FN entered", Value);
				} else if (pageName.equalsIgnoreCase("Your Payments")) {
					EnterText(nuiCreatePersonPage.personFirstName, "Vendor FN entered", Value);
				} else if (pageName.equalsIgnoreCase("create person")) {
					EnterText(nuiCreatePersonPage.personFirstName, "Vendor FN entered", Value);
				} else if (pageName.equalsIgnoreCase("payment method")) {
					EnterText(nuiCreatePersonPage.personFirstName, "User FN entered", Value); 
				} else if (pageName.equalsIgnoreCase("pow")) {
					EnterText(nuiCreatePersonPage.personFirstName, "Vendor FN entered", existingFirstName);
				} else if (pageName.equalsIgnoreCase("User Profile")) {
					EnterText(VendorRegisPage.SelffirstNm, "Vendor FN entered", Value);
				}else if (pageName.equalsIgnoreCase("XtdConnect")) {
					EnterText(NewUIXtdConnect.xtdFirstName, "FirstName entered", Value);
				}
			}
			
			
			else if (textField.equalsIgnoreCase("LN")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				} else if (Value.equalsIgnoreCase("empty")) {
					Value = "              ";
				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("LastName") + Random_StringGenerator(3);
					existingLastName = Value;
				} else if (Value.equalsIgnoreCase("validprod")) {
					Value = _dataRepo.getData("LastName");
					existingLastName = Value;
				} else if (Value.equalsIgnoreCase("min")) {
					Value = Random_StringGenerator(1);
				} else if (Value.equalsIgnoreCase("present")) {
					Value = existingLastName;
				} else if (Value.equalsIgnoreCase("random")) {
					Value = Random_StringGenerator(5);
					existingLastName = Value;
				} else if (Value.equalsIgnoreCase("CompliantOrder")) {
					Value = _dataRepo.getData("lastName");
					existingLastName = Value;
				} else if (Value.equalsIgnoreCase("NonCompliantOrder")) {
						Value = _dataRepo.getData("lastName")+ Random_StringGenerator(3);
						existingLastName = Value;
				}				
				
				System.out.println("Value of " + textField + " ::" + Value);
				if (pageName.equalsIgnoreCase("Administration")) {
					EnterText(nuiAdministrationPage.lastNameField, "Vendor LN entered", Value);
				} else if (pageName.equalsIgnoreCase("create person")) {
					EnterText(nuiCreatePersonPage.personLastName, "Vendor LN entered", Value);
				} else if (pageName.equalsIgnoreCase("pow")) {
					EnterText(nuiCreatePersonPage.personLastName, "Vendor LN entered", existingLastName);
				} else if (pageName.equalsIgnoreCase("payment method")) {
					EnterText(nuiCreatePersonPage.personLastName, "User LN entered", Value); 
				} else if (pageName.equalsIgnoreCase("Your Payments")) {
					EnterText(nuiCreatePersonPage.personLastName, "Vendor FN entered", Value);
				} else if (pageName.equalsIgnoreCase("User Profile")) {
					EnterText(VendorRegisPage.SelflastNm, "Vendor LN entered", Value);
				} else if (pageName.equalsIgnoreCase("XtdConnect")) {
					EnterText(NewUIXtdConnect.xtdLastName, "Last entered", Value);
				}
			}

			else if (textField.equalsIgnoreCase("MN")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("MiddleName") + Random_StringGenerator(3);
					existingMiddleName = Value;

				} else if (Value.equalsIgnoreCase("validprod")) {
					Value = _dataRepo.getData("MiddleName");
					existingMiddleName = Value;

				} else if (Value.equalsIgnoreCase("min")) {
					Value = Random_StringGenerator(1);
				}
				System.out.println("Value of " + textField + " ::" + Value);
				EnterText(nuiCreatePersonPage.personMiddleName, "Vendor MN entered", Value);

			}
			else if (textField.equalsIgnoreCase("MiddleName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(nuiCreatePersonPage.MiddleName, "Vendor Middle name entered", Value);
			}
			else if (textField.equalsIgnoreCase("SecondaryMiddleName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(nuiCreatePersonPage.SecondaryMiddleName, "Vendor Middle name entered", Value);
			}
			else if(textField.equalsIgnoreCase("PhoneNumber")){
				 if(Value.equalsIgnoreCase("invalidPhoneNumber")) {
					Value = Random_NumberGenerator(9);
				}
					EnterText(nuiCreatePersonPage.PhoneNumber, "invalid Phone number entered", Value);
			}
			else if(textField.equalsIgnoreCase("SecondaryPhoneNumber")) {
				 if(Value.equalsIgnoreCase("invalidSecondaryPhoneNumber")) {
					Value = Random_NumberGenerator(9);
				} 
				EnterText(nuiCreatePersonPage.SecondaryPhoneNumber, "invalid Phone number entered", Value);
			}
			else if(textField.equalsIgnoreCase("bbMiddleName")) {
				 if(Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				} 
				EnterText(nuiCreatePersonPage.bbMiddleName, "Business billing Middle name entered", Value);
			}
			else if (textField.equalsIgnoreCase("UserID")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(31);
				} else if (Value.equalsIgnoreCase("min")) {
					Value = Random_StringGenerator(3);
				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("UserID") + Random_NumberGenerator(4);
					existingUserID = Value;
				} else if (Value.equalsIgnoreCase("validprod")) {
					Value = _dataRepo.getData("UserID");
					existingUserID = Value;
				} else if (Value.equalsIgnoreCase("existingprod")) {
					Value = existingUserID;
				}

				System.out.println("Value of " + textField + " ::" + Value);
				EnterText(nuiAdministrationPage.userIDField, "Vendor UserID entered", Value);
			}

			else if (textField.equalsIgnoreCase("email")) {
				if (Value.equalsIgnoreCase("invalid")) {
					Value = Random_StringGenerator(5) + "@";

				} else if (Value.equalsIgnoreCase("min")) {
					Value = Random_StringGenerator(1) + "@";

				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("Email");
					existingEmail = Value;
				} else if (Value.equalsIgnoreCase("random")) {
					Value = _dataRepo.getData("Email").replace("@", Random_NumberGenerator(4) + "@");
					existingEmail = Value;
				}

				if (pageName.equalsIgnoreCase("Administration")) {
					EnterText(nuiAdministrationPage.emailField, "Vendor Email entered", Value);
				} else if (pageName.equalsIgnoreCase("create person")) {
					EnterText(nuiCreatePersonPage.personEmail, "Vendor Email entered", Value);
				} else if (pageName.equalsIgnoreCase("Forgot password")) {
					EnterText(VendorRegisPage.emailOnforgotpassword, "Vendor email entered", Value);
					System.out.println("Value of " + textField + " ::" + Value);
				} else if (pageName.equalsIgnoreCase("Outlook")) {
					EnterText(By.xpath("//*[@name='loginfmt']"), "Vendor email entered", Value);
					System.out.println("Value of " + textField + " ::" + Value);
				}

			}

			else if (textField.equalsIgnoreCase("re-enter email")) {
				if (Value.equalsIgnoreCase("valid")) {
					Value = existingEmail;
				}else if (Value.equalsIgnoreCase("invalid")) {
					Value = Random_StringGenerator(5) + "@";
				} else if (Value.equalsIgnoreCase("min")) {
					Value = Random_StringGenerator(1) + "@";
				}
				EnterText(nuiCreatePersonPage.personConfirmEmail, "Vendor re-entered Email", Value);
			}

			else if (textField.equalsIgnoreCase("User Defined Field1")) {
				if (Value.equalsIgnoreCase("valid")) {
					Value = Random_StringGenerator(20);
				}
				EnterText(nuiCreatePersonPage.UDF1, "User Defined Field1", Value);
				
			}else if (textField.equalsIgnoreCase("User Defined Field2")) {
				if (Value.equalsIgnoreCase("valid")) {
					Value = Random_StringGenerator(20);
				}
				EnterText(nuiCreatePersonPage.UDF2, "User Defined Field2", Value);
			}
			else if (textField.equalsIgnoreCase("calling code")) {
				Value = _dataRepo.getData("CallingCode");
				selectDropDown(nuiCreatePersonPage.callingCode, Value, "Calling Code selected");
			}

			else if (textField.equalsIgnoreCase("phone number")) {
				Value = _dataRepo.getData("PhoneNumber");
				EnterText(nuiCreatePersonPage.phoneNum, "Phone Number entered", Value);
			}

			else if (textField.equalsIgnoreCase("role")) {
				if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("Role");
					existingRole = Value;
				} else {
					existingRole = Value;

				}
				System.out.println("Value of " + textField + " ::" + Value);
				selectDropDown(nuiAdministrationPage.roleDropList, Value, "Vendor Status selected");
			}

			else if (textField.equalsIgnoreCase("status")) {
				if (Value.equalsIgnoreCase("Inactive")) {
					existingStatus = Value;
				} else {
					Value = _dataRepo.getData("Status");
					System.out.println("Value of " + textField + " ::" + Value);
				}

				selectDropDown(nuiAdministrationPage.statusDropList, Value, "Vendor Role selected");
			}

			else if (textField.equalsIgnoreCase("password") || textField.equalsIgnoreCase("confirm password")) {
				if (Value.equalsIgnoreCase("invalid")) {
					Value = Random_StringGenerator(5);
				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("Password");
					existingPassword = Value;
				} else if (Value.equalsIgnoreCase("same")) {
					Value = existingPassword;
				} else {
					if (existingPassVal != null) {
						existingPassVal = existingPassVal + Value;
						existingPassword = existingPassVal;
					} else {
						existingPassVal = Value;
						existingPassword = existingPassVal;
					}
				}
				System.out.println("Value of " + textField + " ::" + Value);
				if (textField.equalsIgnoreCase("password")) {
					if (pageName.equalsIgnoreCase("Outlook")) {
						EnterText(By.xpath("//*[@name=\"passwd\"]"), "Vendor Password entered", existingPassword);
					} else {
						EnterText(nuiAdministrationPage.passwordField, "Vendor Password entered", existingPassword);
					}

				} else {
					EnterText(nuiAdministrationPage.confirmPassField, "Vendor Password entered", Value);
				}
			} else if (textField.equalsIgnoreCase("password reset")
					|| textField.equalsIgnoreCase("confirm password reset")) {
				if (Value.equalsIgnoreCase("valid")) {
					Value = "Password@" + Random_NumberGenerator(5);
					existingPassword = Value;
				} else if (Value.equalsIgnoreCase("same")) {
					Value = existingPassword;
				}

				System.out.println("Value of " + textField + " ::" + Value);
				if (textField.equalsIgnoreCase("password reset")) {
					EnterText(nuiForgotPasswordPage.frgtPasswordField, "Vendor Password entered", existingPassword);
				} else {
					EnterText(nuiForgotPasswordPage.frgtConfirmPasswordField, "Vendor Password entered",
							existingPassword);
				}
//			} else if (textField.equalsIgnoreCase("SNN")) {
//				if (Value.equalsIgnoreCase(">9<")) {
//					Value = Random_NumberGenerator(8);
//				}
//				EnterText(VendorRegisPage.snn, "Business snn entered", Value);

			} else if (textField.equalsIgnoreCase("FirstName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(VendorRegisPage.busiContactFirstName, "Business contact page fn entered", Value);

			}  else if (textField.equalsIgnoreCase("SecondaryFirstName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(VendorRegisPage.SecondarybusiContactFirstName, "Business contact page fn entered", Value);
			
		}else if (textField.equalsIgnoreCase("lastName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(VendorRegisPage.busiContactLastName, "Business contact page last name entered", Value);

			} else if (textField.equalsIgnoreCase("SecondarylastName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(VendorRegisPage.SecondarybusiContactLastName, "Business contact page last name entered", Value);
		
		}else if (textField.equalsIgnoreCase("Title")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(21);
				}
				EnterText(VendorRegisPage.busiContactTitle, "busiContact Title contact page entered", Value);

			}else if (textField.equalsIgnoreCase("SecondaryTitle")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(21);
				}
				EnterText(VendorRegisPage.SecondarybusiContactTitle, "busiContact Title contact page entered", Value);
 
			}
			else if (textField.equalsIgnoreCase("bbFirstName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(VendorRegisPage.billingContactFirstName, "Business billing page first name entered", Value);

		}else if (textField.equalsIgnoreCase("bblastName")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(51);
				}
				EnterText(VendorRegisPage.billingContactLastName, "Business billing last name entered", Value);
				
		}else if (textField.equalsIgnoreCase("bbTitle")) {
				if (Value.equalsIgnoreCase("max")) {
					Value = Random_StringGenerator(21);
				}
				EnterText(VendorRegisPage.billingContactTitle, "busiContact Title contact page entered", Value);

		}else if (textField.equalsIgnoreCase("Business Name")) {
				if (Value.equalsIgnoreCase("random")) {
					Value = _dataRepo.getData("Business Name") + Random_StringGenerator(5);
					existingBusinessName = Value;
					VendorName = Value;
				}
				EnterText(VendorRegisPage.businessName, "Business contact page last name entered", Value);
		}
			 else if (textField.contains("CardNumber")) {
				if (Value.contains("invalid")) {
					ccNumber = _dataRepo.getData(textField);
					if (Value.equalsIgnoreCase("invalidsupporter")) {
						Value = ccNumber.substring(0, 4);
					} else if (Value.equalsIgnoreCase("invalidCC")) {
						Value = ccNumber.substring(0, 5) + Random_NumberGenerator(11);
					} else if (Value.equalsIgnoreCase("invalidlength")) {
						Value = ccNumber.substring(0, 15);
					}
					EnterText(PaymentPage.CreditCardNumber, "Invalid Credit Card Number entered", Value);

				} else if (Value.equalsIgnoreCase("valid")) {
					ccNumber = _dataRepo.getData(textField);

					int i = 0;
					StringBuffer temp = new StringBuffer();
					while (i < (ccNumber.length())) {
						if (i > ccNumber.length() - 5) {
							temp.append(ccNumber.charAt(i));
						} else {
							temp.append("x");
						}
						i++;
						{
							ccNumberMask = temp.toString();
						}
					}

					String ccNumberFirst = ccNumber.substring(0, 5);
					ccNumberEnding = ccNumber.substring(ccNumber.length() - 4);
					PropertyFileReader.setProperty("ccNumberEnding", ccNumberEnding);
					if (ccNumberFirst.equals("41111")) {
						ccType = "Visa";
					} else if (ccNumberFirst.equals("54545")) {
						ccType = "Mastercard";
					} else if (ccNumberFirst.equals("37144")) {
						ccType = "Amex";
					}

					PropertyFileReader.setProperty("ccType", ccType);
					wait(1);
					EnterText(PaymentPage.CreditCardNumber, "Credit Card Number entered", ccNumber);

				} else if (Value.equalsIgnoreCase("declined")) {
					Value = "4387751111111046";
					EnterText(PaymentPage.CreditCardNumber, "Declined Credit Card Number entered", Value);
				}

			} else if (textField.equalsIgnoreCase("CSC")) {
				if (Value.equalsIgnoreCase("InvalidCSCNumber")) {
					Value = Random_NumberGenerator(2);
					EnterText(PaymentPage.CCcssNumberTxt, "Invalid CSC Number entered", Value);
				} else if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("CSC");
					EnterText(PaymentPage.CCcssNumberTxt, "CSC Number entered", Value);
				}
			}

			else if (textField.equalsIgnoreCase("MM")) {
				if (Value.equalsIgnoreCase("valid")) {
					ccMonth = _dataRepo.getData("MM");
//					Random random=new Random();
//					int dropdown=random.nextInt(10);
					selectDropDown(PaymentPage.ccexpireMonth, String.valueOf(ccMonth), "Month selected");
					//EnterText(PaymentPage.ccexpireMonth, "Expired Month entered", ccMonth);
				}
			}

			else if (textField.equalsIgnoreCase("YY")) {
				if (Value.equalsIgnoreCase("valid")) {
					ccYear = _dataRepo.getData("YY");
					ccExypiry = ccMonth + "/" + ccYear;
					PropertyFileReader.setProperty("ccExypiry", ccExypiry);
//					Random random=new Random();
//					int year=random.nextInt(10);
					selectDropDown(PaymentPage.ccexpireYear, String.valueOf(ccYear), "Year selected");
					//EnterText(PaymentPage.ccexpireYear, "Expired Year entered", ccYear);
				}
			}

			else if (textField.equalsIgnoreCase("Country")) {
				if (verifyElementPresence (nuiCreatePersonPage.personCountry)) {
					if (Value.equalsIgnoreCase("valid")) {
						Value = _dataRepo.getData("Country");
					} else {
						existingCountry = Value;
					}
					System.out.println("Value of " + textField + " ::" + Value);
					selectDropDown(nuiCreatePersonPage.personCountry, Value, "Vendor Country selected");
					if (Value.equalsIgnoreCase("United States")) {
						Value = "1: US";
						existingCountry = Value;
					}
				} 
			}
			else if (textField.equalsIgnoreCase("eaCountry")) {
				if(Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("Country");
				}
				if(pageName.equalsIgnoreCase("create person")){
					selectDropDown(nuiCreatePersonPage.eaCountry, Value, "Customer Entered Country name ");
				}else if(pageName.equalsIgnoreCase("identification form")){
					Value = "UNITED STATES";
					selectDropDown(nuiCreatePersonPage.identifyCountry, Value, "Customer Entered Country name ");
				}
			}
			else if (textField.equalsIgnoreCase("eaAddress1")) {
				if (Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("Address");
					EnterText(nuiCreatePersonPage.eaAddress, "Customer Entered Address1 name ", Value);
				}
			}
			else if (textField.equalsIgnoreCase("City")) {
				if (verifyElementPresence (nuiCreatePersonPage.personCity)) {
					if (Value.equalsIgnoreCase("valid")) {
						Value = _dataRepo.getData("City");
						existingCity = Value;
					} else {
						existingCity = Value;
					}
					EnterText(nuiCreatePersonPage.personCity, "Vendor Entered City", Value);
				}
			}
			else if (textField.equalsIgnoreCase("eaCity")) {
				if(Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("City");
				}
				if(pageName.equalsIgnoreCase("create person")){
					EnterText(nuiCreatePersonPage.eaCity, "Customer Entered Country name ", Value);
				}
			}
			else if (textField.equalsIgnoreCase("Document Type")) {
				if(Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("Document Type");
				}
				if(pageName.equalsIgnoreCase("identification form")){
					selectDropDown(nuiCreatePersonPage.identifyDocumentType, Value, "Customer Entered Document Type ");
				}
			}
			else if (textField.equalsIgnoreCase("Document Number")) {
				if (Value.equalsIgnoreCase("CompliantOrder")) {
				Value = _dataRepo.getData("SSN");
				existingssnNumber = Value;
				}
				if (pageName.equalsIgnoreCase("XtdConnect")) {
				EnterText(NewUIXtdConnect.xtdDocumentNumber, "SNN entered", Value);
		        }else if (pageName.equalsIgnoreCase("identification form")) {
				EnterText(nuiCreatePersonPage.SSNCreatePerson, "SNN entered", Value);
		        }
	    	}
			else if (textField.equalsIgnoreCase("re-enter Document Number")) {
				if (Value.equalsIgnoreCase("CompliantOrder")) {
					Value = existingssnNumber;
				}
				EnterText(nuiCreatePersonPage.ConfirmSSNCreatePerson, "SNN entered", Value);
			}
			
			else if (textField.equalsIgnoreCase("Date Of Birth")) {
		     	if (Value.equalsIgnoreCase("CompliantOrder")) {
		         	Value = _dataRepo.getData("DOB");
		     //    	existingssnNumber = Value;
		     	}
		     	System.out.println("Value of " + textField + " ::" + Value);
		      if (pageName.equalsIgnoreCase("XtdConnect")) {
			EnterText(NewUIXtdConnect.dobw, "DOB entered", Value);
           	}else if (pageName.equalsIgnoreCase("create person")) {
				EnterText(nuiCreatePersonPage.EADOB, "DOB entered", Value);
           	}
		}
			else if (textField.equalsIgnoreCase("eaZipCode")) {
		     	if (Value.equalsIgnoreCase("valid")) {
		         	Value = "23229";
                    EnterText(nuiCreatePersonPage.eaZipCode, "zip code entered", Value);
                    System.out.println("Value of " + textField + " ::" + Value);
				}	
			}
			else if (textField.equalsIgnoreCase("State")) {
				if (verifyElementPresence (nuiCreatePersonPage.personState)) {
					if (Value.equalsIgnoreCase("valid")) {
						Value = _dataRepo.getData("State");
						existingState = Value;
					} else {
						existingState = Value;
					}
					System.out.println("Value of " + textField + " ::" + Value);
					selectDropDown(nuiCreatePersonPage.personState, Value, "Vendor State selected");
					if (Value.equalsIgnoreCase("South Dakota")) {
						Value = "48: SD";
						existingState = Value;
					} else if (Value.equalsIgnoreCase("Pennsylvania")) {
						Value = "PA";
						existingState = Value;
					}
				
				}
			}
			else if (textField.equalsIgnoreCase("eaState")) {
				if(Value.equalsIgnoreCase("valid")) {
					Value = _dataRepo.getData("State");
					existingState = Value;
					
				}else {
					existingState = Value;
				}
				System.out.println("Value of " + textField + " ::" + Value);
				if(pageName.equalsIgnoreCase("create person")){
					selectDropDown(nuiCreatePersonPage.eaState, Value, "Customer State selected");
				}	
			
		} else {
				By fieldValue = createDynamicXpath("field", textField, "xpath for created for " + textField + "");
				EnterText(fieldValue, "Text enetered in " + textField + " ", Value);
				}
			
				
		} catch (Exception e) {
			e.getMessage();
		}
		takeScreenshot();
	}


	public void clearAllFields(String value) throws Exception {
		try {

			if (value.equalsIgnoreCase("Edit User")) {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(nuiAdministrationPage.requiredFields));
				List<WebElement> allFields = driver.findElements(nuiAdministrationPage.requiredFields);
				for (int i = 0; i < allFields.size(); i++) {
					wait(1);
					new Actions(driver).click(allFields.get(i)).pause(200).keyDown(Keys.CONTROL).sendKeys("a")
							.keyUp(Keys.CONTROL).pause(200).sendKeys(Keys.BACK_SPACE).perform();
				}
			} else if (value.equalsIgnoreCase("Payment Method")) {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(PaymentPage.paymentMethodFields));
				List<WebElement> allFields = driver.findElements(PaymentPage.paymentMethodFields);
				for (int i = 0; i < allFields.size(); i++) {
					wait(1);
					new Actions(driver).click(allFields.get(i)).pause(200).keyDown(Keys.CONTROL).sendKeys("a")
							.keyUp(Keys.CONTROL).pause(200).sendKeys(Keys.BACK_SPACE).perform();
				}
			}
			reportLog(Status.PASS, "Clear all fields", false);
		} catch (Exception e) {
			System.out.println("error in following Lines::" + e.getMessage());
		}

	}

	/**
	 * @author marovimo 06/06/2021 -- Clear of one field
	 **/
	public void clearFeld(String field, String page) throws Exception {
		try {
			if (field.equalsIgnoreCase("FN")) {
				// WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement textField = driver.findElement(nuiCreatePersonPage.personFirstName);
				textField.sendKeys(Keys.CONTROL, Keys.chord("a"));
				textField.sendKeys(Keys.BACK_SPACE);
			} else if (field.equalsIgnoreCase("MN")) {
				WebElement textField = driver.findElement(nuiCreatePersonPage.personMiddleName);
				textField.sendKeys(Keys.CONTROL, Keys.chord("a"));
				textField.sendKeys(Keys.BACK_SPACE);
			} else if (field.equalsIgnoreCase("LN")) {
				WebElement textField = driver.findElement(nuiCreatePersonPage.personLastName);
				textField.sendKeys(Keys.CONTROL, Keys.chord("a"));
				textField.sendKeys(Keys.BACK_SPACE);
			} else if (field.equalsIgnoreCase("Search field")) {
				if (page.equalsIgnoreCase("Shopping Cart")) {
					WebElement textField = driver.findElement(nuiShoppingCartPage.searchShoppingCart);
					textField.sendKeys(Keys.CONTROL, Keys.chord("a"));
					textField.sendKeys(Keys.BACK_SPACE);
				} else if (page.equalsIgnoreCase("Package Selection")) {
					WebElement textField = driver.findElement(nuiPackageSelectionPage.searchPackage);
					textField.sendKeys(Keys.CONTROL, Keys.chord("a"));
					textField.sendKeys(Keys.BACK_SPACE);
				}
			}

			reportLog(Status.PASS, "Filed is cleared", false);
		} catch (Exception e) {
			System.out.println("error in following Lines::" + e.getMessage());
		}
	}

	public void detailsPreFiled(String page) throws Exception {
		try {

			if (page.equalsIgnoreCase("Edit User")) {
				By allFieldsEditWin = By.xpath("//*[contains(@data-xf-qa-id,'add-edit-user')]");
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(allFieldsEditWin));
				List<WebElement> allFields = driver.findElements(allFieldsEditWin);

				JavascriptExecutor js = (JavascriptExecutor) driver;

				for (int i = 0; i < allFields.size(); i++) {
					wait(2);
					String field = (String) ((js).executeScript("return arguments[0].value", allFields.get(i)));
					System.out.println(field);
					Boolean isPresent = !field.isEmpty();
					if (isPresent == true) {
						System.out.println("Field has value " + field);
					} else {
						reportLog(Status.FAIL, "Empty field: " + field, false);
						break;
					}
				}
			}
			reportLog(Status.PASS, "All fields are pre-filled", false);
		} catch (Exception e) {
			System.out.println("error in following Lines::" + e.getMessage());
		}

	}

	public void textboxVerifyPresent(String identifierValue, String pageName) throws Exception {
		try {
			wait(2);
			if (verifyElementPresence(By.xpath("//*[contains(@placeholder,'" + identifierValue + "')]"))) {
				reportLog(Status.PASS, "Element Present " + identifierValue, false);
				logStepInfo("See " + identifierValue);

			} else {
				reportLog(Status.FAIL, "Textbox is not present: " + identifierValue, false);
			}

		} catch (Exception e) {
			System.out.println("error in following Lines::" + e.getMessage());
		}
	}

	/**
	 * @author marovimo 08/06/2021 -- Information on Page
	 **/
	public void verifyPageInformations(String page) throws Exception {
		try {
			if (page.contains("create person")) {

				String FN = driver.findElement(nuiCreatePersonPage.personFirstName).getAttribute("value");
				String MN = driver.findElement(nuiCreatePersonPage.personMiddleName).getAttribute("value");
				String LN = driver.findElement(nuiCreatePersonPage.personLastName).getAttribute("value");
				String Email = driver.findElement(nuiCreatePersonPage.personEmail).getAttribute("value");
				String ConfEmail = driver.findElement(nuiCreatePersonPage.personConfirmEmail).getAttribute("value");
				String Country = driver.findElement(nuiCreatePersonPage.personCountry).getAttribute("value");
				String City = driver.findElement(nuiCreatePersonPage.personCity).getAttribute("value");
				String State = driver.findElement(nuiCreatePersonPage.personState).getAttribute("value");

				Assert.assertEquals(FN, existingFirstName);
				Assert.assertEquals(MN, existingMiddleName);
				Assert.assertEquals(LN, existingLastName);
				Assert.assertEquals(Email, existingEmail);
				Assert.assertEquals(ConfEmail, existingEmail);
				Assert.assertEquals(Country, existingCountry);
				Assert.assertEquals(City, existingCity);
				System.out.println("Attribute value: " + State + " Existing Value: " + existingState);
				Assert.assertEquals(State, existingState);

				logStepInfo("Comparing Informations");
				reportLog(Status.PASS, "All Information are Present", false);

			} else if (page.contains("Business Billing")) {

				// Business Contact
				String FN = driver.findElement(VendorRegisPage.busiContactFirstName).getAttribute("value");
				String LN = driver.findElement(VendorRegisPage.busiContactLastName).getAttribute("value");
				String Title = driver.findElement(VendorRegisPage.busiContactTitle).getAttribute("value");
				String Email = driver.findElement(VendorRegisPage.busiContactEmail).getAttribute("value");
				String Country = driver.findElement(VendorRegisPage.busiCountry).getAttribute("value");
				if (Country.equals("1: US")) {
					Country = "United States";
				}
				String CallingCode = driver.findElement(VendorRegisPage.countryCode).getAttribute("value");
				if (CallingCode.equals("1: +1")) {
					CallingCode = "1";
				}
				String PhoneNumber = driver.findElement(VendorRegisPage.billingContactPhoneNumber)
						.getAttribute("value");

				// Business Address
				String BBCountry = driver.findElement(VendorRegisPage.busiCountry).getAttribute("value");
				if (BBCountry.equals("1: US")) {
					BBCountry = "United States";
				}
				String BBAddress = driver.findElement(VendorRegisPage.billingAddress).getAttribute("value");
				String BBCity = driver.findElement(VendorRegisPage.billingCity).getAttribute("value");
				String BBState = driver.findElement(VendorRegisPage.billingState).getAttribute("value");
				switch (BBState) {
				case "11: GA":
					BBState = "Georgia";
					break;
				case "47: SD":
					BBState = "South Dakota";
					break;
				default:
					break;
				}
				String BBZip = driver.findElement(VendorRegisPage.billingZipCode).getAttribute("value");

				Assert.assertEquals(FN, existingBusinesContactFirstName);
				Assert.assertEquals(LN, existingBusinesContactLastName);
				Assert.assertEquals(Title, existingBusinessTitle);
				Assert.assertEquals(Email, existingBusinessContactEmail);
				Assert.assertEquals(Country, existingBusinesContactCountry);
				Assert.assertEquals(CallingCode, existingBusinesContactCode);
				Assert.assertEquals(PhoneNumber, existingBusinesContactPN);

				Assert.assertEquals(BBCountry, existingBusinessInfoCountry);
				Assert.assertEquals(BBAddress, existingBusinessInfoAddress);
				Assert.assertEquals(BBCity, existingBusinessInfoCity);
				Assert.assertEquals(BBState, existingBusinessInfoState);
				Assert.assertEquals(BBZip, existingBusinessInfoZip);

				logStepInfo("Comparing Informations");
				reportLog(Status.PASS, "All Information are Present", false);

			} else if (page.contains("Business Information")) {

				String BusinessName = driver.findElement(VendorRegisPage.businessName).getAttribute("value");
				Assert.assertEquals(BusinessName, existingBusinessName);
				logStepInfo("Comparing Informations");
				reportLog(Status.PASS, "Business name is changed to: " + BusinessName, false);

			} else if (page.contains("User Profile")) {
				String firstNm = driver.findElement(VendorRegisPage.firstNm).getAttribute("value");
				String lastNm = driver.findElement(VendorRegisPage.lastNm).getAttribute("value");
				String email = driver.findElement(VendorRegisPage.email).getAttribute("value");
				String userID = driver.findElement(VendorRegisPage.userID).getAttribute("value");
				String Questions = driver.findElement(VendorRegisPage.secretQ).getAttribute("value");
				String Answers = driver.findElement(VendorRegisPage.secretAnswer).getAttribute("value");
				
				Assert.assertEquals(firstNm, existingUserProfileFirstName);
				Assert.assertEquals(lastNm, existingUserProfileLastName);
				Assert.assertEquals(email, existingUserProfileEmail);
				Assert.assertEquals(userID, existingQuestions);
				Assert.assertEquals(Questions, existingQuestions);
				Assert.assertEquals(Answers, existingAnswers);
				
				logStepInfo("Comparing Informations");
				reportLog(Status.PASS, "All Information are Present", false);
			
			} else {
				logStepInfo("Comparing Informations");
				reportLog(Status.FAIL, "All Elements are not Present ", false);
				}
			
		} catch (Exception e) {
			System.out.println("error in following Lines::" + e.getMessage());
		}
	}

	public void clickLink(String value, String Page) throws Exception {
		switch (Page.toLowerCase()) {
//		case "payment method": {
//			List<WebElement> existingCCards = driver.findElements(By.xpath("//div[@class='card-row p-1 ng-star-inserted']"));
//			existingCCards.forEach(e->System.out.println(e.getText()+"Credit Caaaardsss !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"));
//			int max=existingCCards.size();
//			for (int i = 1; i <= max; i++) {
//				String ccAddedExpected = driver.findElement(By.xpath("//xf-card-selection/div/div[2]/div/div[" + i + "]")).getText();
////				String ccAddedExpected = existingCCards.get(i).getText();
//				String ccAdded = ccType + " ending in " + ccNumberEnding + "\n(expires " + ccExypiry + ")\nRemove";
//				logStepInfo(ccAddedExpected+" "+ccAdded);
//				if (ccAdded.equalsIgnoreCase(ccAddedExpected)) {
//					wait(2);
//					WebElement removeCCLink=existingCCards.get(i-1).findElement(By.xpath(".//a"));
//					removeCCLink.click();
//					i--;
//					max--;
////					logStepInfo("Credit Card is removed: " + ccAdded);
////					reportLog(Status.PASS, "Credit card is removed!", false);
////					break;
//					logStepInfo("Credit Card is removed!"+ ccAdded+"=="+ccAddedExpected);
//				} else {
//					logStepInfo("Credit Card isn't removed: " + ccAdded+"=="+ccAddedExpected);
////					reportLog(Status.INFO, "Credit card isn't removed!", false);
//				}
//			}
//			reportLog(Status.PASS, "Credit card is removed!", false);
//		}
		
		case "payment method": {
			List<WebElement> existingCCards = driver.findElements(By.xpath("//div[@class='card-row p-1 ng-star-inserted']"));
			int max=existingCCards.size();
			for (int i = 0; i < max; i++) {
		//		String ccAddedExpected = driver.findElement(By.xpath("//xf-card-selection/div/div[2]/div/div[" + i + "]")).getText();

				existingCCards.get(i).click();
				logStepInfo("Credit Card is removed!");
			}
			reportLog(Status.PASS, "Credit card is removed!", false);
		}
			break;

			case "program owner":
				By activePeopleLink = By.xpath("//*[contains (@data-label, 'Name') and contains (., '"+ providerName +"')]/following::td[@data-label = 'Active People']/a");
				if (verifyElementPresence(activePeopleLink)) {
					clickElement(activePeopleLink, "Active People Link");
					logStepInfo("Click on Active People link for Provder: " +providerName);
					reportLog(Status.PASS, "Click on Active People Link for Provider", false);
				} else {
					logStepInfo("Failed click on Active People link for Provder: " +providerName);
					reportLog(Status.FAIL, "Failed click on Active People Link for Provider", false);
				}
				break;
			case "remove credit cards": {
				System.out.println("ENTERED REMOVE CREDIT CARDS !!!!!!!!!!!!!");
				List<WebElement> exisitingCards = driver.findElements(By.xpath("//div[@class='card-row p-1']"));
				int max=exisitingCards.size();
				for (int i = 1; i <= max; i++) {
					By removeLink = By.xpath("//div[" + i + "]/div/div/div[2]/span/a");
					wait(2);
					WebElement removeCCLink = driver.findElement(removeLink);
					removeCCLink.click();
					i--;
					max--;
					if(max==0){
						break;
					}
					logStepInfo("Credit Card has been removed");
				}
				logStepInfo("Credit Cards have been removed!");
				reportLog(Status.PASS, "Credit card is removed!", false);
			}
			case "remove credit cards ordering": {
				System.out.println("REMOVE CREDIT CARD ORDERINGGGGGG !!!!!!!!!!!!!");
				List<WebElement> exisitingCards = driver.findElements(By.xpath("//div[@class='card-row p-1 ng-star-inserted']"));
				int max=exisitingCards.size();
				for (WebElement existingCreditCard:exisitingCards){
					WebElement removeCC=existingCreditCard.findElement(By.xpath(".//a"));
					removeCC.click();
				}
				logStepInfo("Credit Cards have been removed!");
				reportLog(Status.PASS, "Credit card is removed!", false);
			}
			break;
			case "person details": 
				if(value.equalsIgnoreCase("XtdConnectOrder")) {
					By PersonNameLink = By.cssSelector("tr[id='panel-0'] a[class='person-details-redirect']");

				clickElement(PersonNameLink, "xtdconnect Person Link");
					logStepInfo("Click on xtdconnect person: "+ value);
					reportLog(Status.PASS, "Click on xtdconnect person: ", false);
				}else {
						  System.out.println("Person Name is not clickable");
						  reportLog(Status.FAIL, "Person Name  is not clickable", false);
							logStepInfo("Person Name is not clickable");
				}
			break;
			default:
			clickElement(By.xpath("(//a[contains(.,'" + value + "')])[last()]"), value);
		}
	}

	public void clearCache() throws Exception {
		//String deleteApi = "https://ua.ca.fadv.com/api/branding/cache?sponsor={customer}";
		String deleteApi = "https://qcsa.fadv.net/api/branding/cache?sponsor={customer}";
		// qcsavc --> for 10 and 7
		Unirest.delete(deleteApi).routeParam("customer", "AYFTest").asJson();
		driver.navigate().refresh();
		reportLog(Status.PASS, "Cache is clear!", false);
	}
	public void ClickableButton(String value, String PageName) throws Exception {
		WebElement button = driver.findElement(NewUIXtdConnect.OrderBtn);
		Boolean isClickable = button.isEnabled();
		if (isClickable) {
		  System.out.println("Order New Package button is clickable");
		  reportLog(Status.PASS, "Order New Package button is clickable", false);
			logStepInfo("Order New Package button is clickable");
		} else {
		  System.out.println("Order New Package button is not clickable");
		  reportLog(Status.FAIL, "Order New Package button is clickable", false);
			logStepInfo("Order New Package button is clickable");
		}
	
	
	
	}
	
	
	public void isInputFieldPrepopulated(String value, String expectedValue, String pageName) {
		
		  try {
			 switch (pageName.toLowerCase()) {
			case "create person":
		    WebElement firstName = driver.findElement(NewUIXtdConnect.firstNameOnPS);
		    WebElement lastName = driver.findElement(NewUIXtdConnect.lastNameOnPS);
		    
		    if (firstName.getAttribute("value").equals(expectedValue)) {
		      System.out.println("Input field is pre-populated with: " + expectedValue);
		      reportLog(Status.PASS, "Input field FirsName is pre-populated with: "+ expectedValue, false);
				logStepInfo("Input field is FirsName pre-populated with: "+ expectedValue);
		    } else if (lastName.getAttribute("value").equals(expectedValue)) {
			      System.out.println("Input field LastName is pre-populated with: " + expectedValue);
			      reportLog(Status.PASS, "Input field LastName is pre-populated with: "+ expectedValue, false);
					logStepInfo("Input field is pre-populated with: "+ expectedValue);
			} else {
		      System.out.println("Input field is not pre-populated with: " + expectedValue);
		      reportLog(Status.FAIL, "Input field is Not pre-populated with: "+ expectedValue, false);
				logStepInfo("Input field is Not pre-populated with: "+ expectedValue);
		    }
			 }
		  } catch (Exception e) {
				e.getMessage();
				 System.out.println("Input field with id " + expectedValue + " does not exist");
		
		  }
		}
}
