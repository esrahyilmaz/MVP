package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import constants.PeopleSearchColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import seleniumhelper.BaseClass;

import java.util.*;
import java.util.stream.Collectors;

public class NUIPeoplePage extends BaseClass {
	NUICreatePerson nuiCreatePersonPage = new NUICreatePerson();
	NUIShoppingCartPage nuiShoppingCartPage = new NUIShoppingCartPage();
	NUIPackageSelectionPage nuiPackageSelectionPage = new NUIPackageSelectionPage();
	NUIPaymentMethodPage nuiPaymentMethodPage = new NUIPaymentMethodPage();
	NUIOrderSubmissionPage nuiOrderSubmissionPage = new NUIOrderSubmissionPage();
	ExcelReader _dataRepo = new ExcelReader();

	public By firstName = By.xpath("//*[@placeholder='First Name']");
	public By lastName = By.xpath("//*[@placeholder='Last Name']");
	public By sSN = By.xpath("//*[@placeholder='Social Security Number']");
	
	public By serachButton = By.xpath("//*[@id='search-btn']");
	public By orderDateAsc = By.xpath("//th[@data-name='orderDate' and @data-order='desc']");
	public By firstAccordion = By.cssSelector("#panel-0 > td:nth-child(2)");
	By peopleTable = By.xpath("//xf-people-search//table");
	By peopleActionButton = By.xpath("//*[@id='button-nested']"); 
	
	By peopleSetStatusButton = By.xpath("//*[@id='dropdown-nested']/li/a");  //[@aria-expanded = 'false']");
	By peopleNewOrderButtonProd = By.xpath("//*[@id=\"dropdown-nested\"]/button");
	By peopleNewOrderButton = By.xpath("//li[@class='dropdown-item btn']");
	
	By peopleStatusesActive = By.xpath("//*[@class='dropdown-item btn' and text()='Active']");
	By peopleStatusesInactive = By.xpath("//*[@class='dropdown-item btn' and text()='Inactive']");  
	By peopleStatusesTerminated = By.xpath("//*[@class='dropdown-item btn' and text()='Terminated']");
	By peopleStatusesClickable = By.xpath("//ul/li/button[not(@disabled= '')]");
	
	By addPeopleButton = By.xpath("//*[contains (@class, 'cta btn btn-primary add-people-btn')]");
	
	By continueButton = By.xpath("//button[text()='Continue ']");
	
	By peopleFilterButton = By.xpath("//*[@id='filter-btn']");
	By peopleFilterCheckButton = By.xpath("//*[@id='check-btn']");
	By outsideFilterButton=By.xpath("//div[@id='filter-container']");
	By dateRangePicker=By.xpath("//*[@id=\"order-date\"]");
	By completionDateRangePicker=By.xpath("//*[@id=\"completion-date\"]");
	By filterActiveCheckButton=By.xpath("//*[@id=\"Active\"]");
	By filterInactiveCheckButton=By.xpath("//*[@id=\"Inactive\"]");
	By filterTerminatedCheckButton=By.xpath("//*[@id=\"Terminated\"]");
	By filterCompliantCheckButton=By.xpath("//*[@id=\"Compliant\"]");
	By filterActionRequiredCheckButton=By.xpath("//*[@id=\"Action Required\"]");
	By filterNeedsReviewCheckButton=By.xpath("//*[@id=\"Needs Review\"]");
	By filterNonCompliantCheckButton=By.xpath("//*[@id=\"Non-Compliant\"]");
	By filterPendingCheckButton=By.xpath("//*[@id=\"Pending\"]");
	By filterCompletedCheckButtonScreening=By.xpath("//*[@id=\"Completed\"]");
	By filterPendingCheckButtonScreening=By.xpath("//*[@id=\"Pending\"]");
//	public By nextPageButton=By.cssSelector("body > xf-root > xf-in-layout > div > main > xf-people-search > div:nth-child(2) > xf-table-pagination > div > pagination > ul > li.pagination-next.page-item > a > fa-icon");
	public By nextPageButton=By.cssSelector(".pagination-next");
//	public By nextPageButtonDisabled=By.cssSelector("body > xf-root > xf-in-layout > div > main > xf-people-search > div:nth-child(2) > xf-table-pagination > div > pagination > ul > li.pagination-next.page-item.disabled");
	public By nextPageButtonDisabled=By.cssSelector("body > xf-root > xf-in-layout > div > main > xf-people-search > div:nth-child(2) > xf-table-pagination > div > pagination > ul > li.pagination-next.page-item.disabled");
	public By filterButton = By.xpath("//*[@id='filter-btn']");
	public By actionFilterCheckbox = By.xpath("//label[text()='Active']/preceding-sibling::input[@id='checkbox-0']");
	public By confirmFilterButton = By.xpath("//*[@id='check-btn']");
	public By actionButtonDisabled= By.cssSelector("#action-btn>button[disabled]");
	public By actionButton=By.cssSelector("#button-nested");
	public By tableRow=By.xpath("//tr[contains(@id,'panel')]");
	public By complianceStatusLocatorVendor=By.xpath("//*[contains(@id,'panel')]/td[3]");
	public By screeningStatusLocatorVendor=By.xpath("//*[contains(@id,'panel')]/td[4]");
	public By personStatusLocatorVendor=By.xpath("//*[contains(@id,'panel')]/td[9]");
	public By noResultsFoundPeoplePage=By.xpath("//*[text()='No Results Found']");
	private Map<String, String> colorsMap = new HashMap<>();


	//todo has to be split into multiple pages

	/**
	 * method that covers the people ordering workflow end to end, only PA integration
	 * @param paymentMethod
	 * @throws Exception
	 */
	public void newOrder(String paymentMethod) throws Exception {
		try {
			clickElementWithWait(nuiCreatePersonPage.middleNameYesButton, "Person Has Middle Name Button");

			String Value = _dataRepo.getData("FirstName") + Random_StringGenerator(3);
			existingFirstName = Value;
			EnterText(nuiCreatePersonPage.personFirstName, "User FN entered", Value);

			Value = _dataRepo.getData("MiddleName") + Random_StringGenerator(3);
			existingMiddleName = Value;
			EnterText(nuiCreatePersonPage.personMiddleName, "User MN entered", Value);

			Value = _dataRepo.getData("LastName") + Random_StringGenerator(3);
			existingLastName = Value;
			EnterText(nuiCreatePersonPage.personLastName, "User LN entered", Value);

			Value = _dataRepo.getData("Email").replace("@", Random_NumberGenerator(4) + "@");
			existingEmail = Value;
			EnterText(nuiCreatePersonPage.personEmail, "User Email entered", Value);
			EnterText(nuiCreatePersonPage.personConfirmEmail, "User re-entered Email", Value);

			wait(1);
			if (verifyElementPresence(nuiCreatePersonPage.personCountry)) {
				Value = _dataRepo.getData("Country");
				EnterTextWithoutDelete(nuiCreatePersonPage.personCountry, "Vendor Entered Country", Value);
			}

			if (verifyElementPresence(nuiCreatePersonPage.personCity)) {
				Value = _dataRepo.getData("City");
				EnterTextWithoutDelete(nuiCreatePersonPage.personCity, "Vendor Entered City", Value);
			}

			if (verifyElementPresence(nuiCreatePersonPage.personState)) {
				Value = _dataRepo.getData("State");
				EnterTextWithoutDelete(nuiCreatePersonPage.personState, "Vendor Entered State", Value);
			}
//		wait(2);
			clickElement(nuiCreatePersonPage.personNextButton, "Next button on Create Person Page");

			searchText = _dataRepo.getData("Package");
			packageName = searchText;
			EnterText(nuiPackageSelectionPage.searchPackage, "enter search by ", searchText);
			clickElementWithWait(nuiPackageSelectionPage.searchIconPackage, "Search button on Package Selection page");
			By radioBtn = (By.xpath("//table/tbody/tr/td[1]/div/xf-checked-radio"));
			clickElementWithWait(radioBtn, "Clicked on first package");
			clickElementWithWait(nuiPackageSelectionPage.addToCartShoppingButton, "Add to Cart button on Package Selection Page");

			if (paymentMethod.equalsIgnoreCase("Credit Card")) {
				clickElementWithWait(nuiShoppingCartPage.authorizeTickBox, "Authorize TickBox on Shopping Cart Page");
			}

			clickElementWithWait(nuiShoppingCartPage.checkoutShoppingCartButton, "Checkout button on Shopping Cart Page");

			if (paymentMethod.equalsIgnoreCase("Credit Card")) {
				wait(1);

				radioBtn = (By.xpath("//xf-checked-radio[@data-xf-qa-id=\"'CCP-CS-RADIO-NEW'\"]"));
				clickElementWithWait(radioBtn, "Clicked on radiobutton - Use a new payment method");

				EnterText(nuiCreatePersonPage.personFirstName, "User FN entered", existingFirstName);
				EnterText(nuiCreatePersonPage.personLastName, "User LN entered", existingLastName);

				ccNumber = _dataRepo.getData("CardNumberVisa");
				EnterText(nuiPaymentMethodPage.creditCardNumber, "Credit Card Number entered", ccNumber);

				ccMonth = _dataRepo.getData("MM");
				selectDropDownByIndex(nuiPaymentMethodPage.expiryMonthCC, "5", "Month selected");

				ccYear = _dataRepo.getData("YY");
				selectDropDownByIndex(nuiPaymentMethodPage.expiryYearCC, "11", "Year selected");

				Value = _dataRepo.getData("CSC");
				EnterText(nuiPaymentMethodPage.cSCNumber, "CSC Number entered", Value);

//			wait(1);
				clickElementWithWait(nuiPaymentMethodPage.addNextButtonCC, "Next button on Payment Page");
			}

			clickElementWithWait(nuiOrderSubmissionPage.returnToPeopleButton, "Return to People Page button on Order Confirmation Page");

			reportLog(Status.PASS, "Adding a new order Passed!", false);
			logStepInfo("Adding a new order Passed!");

		} catch (Exception e) {
			reportLog(Status.FAIL, "Adding a new order Failed!" + e.getMessage(), false);
			logStepInfo("Adding a new order Failed!" + e.getMessage());
		}
	}

	/**
	 * Returns filterPill locator depending on the filter pill in question
	 * @param filterPillQuery
	 * @return
	 */
	public By filterPill(String filterPillQuery){
		logStepInfo("Filter in question is: "+filterPillQuery);
		return By.id(filterPillQuery+"+desktop");
	}

	/**
	 * Splits string into value and adds wanted value to locator, can be done much better
	 * @param clickablePillQuery
	 * @return
	 */
	//todo do this better
	public By clickableFilterPill(String clickablePillQuery){
		String clickablePill= clickablePillQuery.replace("ClickablePill","");
		logStepInfo("Filter in question is: "+clickablePill);
		return By.id(clickablePill+"+desktop");
	}
	/**
	 * @authot prsatomi
	 * @param element
	 * @param status
	 * @return boolean
	 */
	public Boolean isValidFilteringStatusDisplayed(By element, String status){
		Set<String> statuses = new HashSet<>(Arrays.asList(status.split(",")));
		Set<String> foundStatuses=driver.findElements(element).stream().map(WebElement::getText).collect(Collectors.toSet());
		statuses.stream().forEach(System.out::println);
		foundStatuses.stream().forEach(System.out::println);
		return statuses.equals(foundStatuses);
	}

	/**
	 * Checks if next page button is availiable on People search Page
	 * @return boolean
	 */
	public boolean pageHasNext() {
		if (!verifyElementPresenceBoolean(nextPageButtonDisabled, "Verifying pages left")) {
			return true;
		}
		return false;
	}
	//todo bolje implementirati
	public boolean buttonColoringScreening(WebElement element, WebElement accordion, String iterator) {
		String text = element.getText();
		if (text.equals("Pending")) {
			if (Color.fromString(element.getCssValue("background-color")).asHex().equals(PeopleSearchColors.PENDING.getColor())) {
				return true;
		} else if (text.equals("Completed")) {
			wait(1);
			accordion.click();
			wait(1);
			String eligiblity = driver.findElement(By.xpath("//*[@id='" + iterator + "']/following-sibling::tr[@class='panel-content'][1]//div/div/div[@class='badge badge-pill badge-primary']")).getText().trim();
			System.out.println(eligiblity);
			if (eligiblity.equals("Ineligible")) {
				if (Color.fromString(element.getCssValue("background-color")).asHex().equals(PeopleSearchColors.TERMINATED.getColor())) {
					return true;
				}
			} else if (eligiblity.equals("Eligible")) {
				if (Color.fromString(element.getCssValue("background-color")).asHex().equals(PeopleSearchColors.ACTIVE.getColor())) {
					return true;
				}
			}
			if (Color.fromString(element.getCssValue("background-color")).asHex().equals(PeopleSearchColors.TERMINATED.getColor()) || Color.fromString(element.getCssValue("background-color")).asHex().equals(PeopleSearchColors.ACTIVE.getColor())) {
				return true;
			}
		}
			}
		return false;
	}

	/**
	 * Checks wheter the status from the element matches the correct color
	 * @param element
	 * @return
	 */
	public boolean buttonColoring(WebElement element) {
		String status = element.getText();
		String color = Color.fromString(element.getCssValue("background-color")).asHex();
		return peopleSearchColors().get(status).contains(color);
	}

	/**
	 * Provides ability to filter through colors
	 * @return Map<String,String> of key(status) and value(color)
	 */
	public Map<String,String> peopleSearchColors(){
		colorsMap.put(PeopleSearchColors.ACTIVE.getStatus(),PeopleSearchColors.ACTIVE.getColor());
		colorsMap.put(PeopleSearchColors.COMPLIANT.getStatus(),PeopleSearchColors.COMPLIANT.getColor());
		colorsMap.put(PeopleSearchColors.NON_COMPLIANT.getStatus(),PeopleSearchColors.NON_COMPLIANT.getColor());
		colorsMap.put(PeopleSearchColors.TERMINATED.getStatus(),PeopleSearchColors.TERMINATED.getColor());
		colorsMap.put(PeopleSearchColors.INACTIVE.getStatus(),PeopleSearchColors.INACTIVE.getColor());
		colorsMap.put(PeopleSearchColors.PENDING.getStatus(),PeopleSearchColors.PENDING.getColor());
		colorsMap.put(PeopleSearchColors.NEEDS_REVIEW.getStatus(),PeopleSearchColors.NEEDS_REVIEW.getColor());
		colorsMap.put(PeopleSearchColors.ACTION_REQUIRED.getStatus(),PeopleSearchColors.ACTION_REQUIRED.getColor());
		colorsMap.put(PeopleSearchColors.COMPLETED.getStatus(),PeopleSearchColors.COMPLETED.getColor());
		return colorsMap;
	}
}