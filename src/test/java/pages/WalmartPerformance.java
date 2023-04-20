
package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WalmartPerformance extends BaseClass {

	private By empScreenTab = By.id("EE_MENU_BG_SCREENING");
	private By caseManagementTAb=By.xpath("//*[@id='EE_MENU_CASE_MANAGEMENT']");
	private By searchOrder = By.id("EE_MENU_SEARCH_ORDERS");
	private By searchCase=By.xpath("//*[@id='EE_MENU_CASE_MANAGEMENT_SEARCH']");
	private By searchBtn = By.xpath("(//td[.='Search'])[last()]");
	private By casesInQueue = By.id("EE_MENU_CASE_MANAGEMENT_QUEUE");

	private By search_fromDate = By.xpath("(.//input[@id='ORDER_VIEWING_SEARCH_FROM_LBL'])[1]");
	private By search_toDate = By.xpath("(.//input[@id='ORDER_VIEWING_SEARCH_TO_LBL'])[1]");
	
	private By search_fromDateCM = By.xpath(".//input[@id='CM_SEARCH_CM_SEARCH_FROM']");
	private By search_toDateCM = By.xpath(".//input[@id='CM_SEARCH_CM_SEARCH_TO']");
	
	private By globalSearchTB=By.xpath("//input[contains(@class,'globalSearch')]");
	private By globalSearchBTN=By.xpath("//button[.='Search']");
	
	private By readyForReviewNCLink=By.xpath("//a[.='Ready for Review (NON Circumstance)']");
	private By readyForReviewCirLink=By.xpath("//a[.='Ready for Review (Circumstance)']");
	private By ManualReviewLink=By.xpath("//a[.='Ungraded Manual Review']");

	public void selectFromEATab(String opt, String tab) throws Exception  {
		if (tab.equalsIgnoreCase("EmployeeBcgScreen")) {
			if(verifyElementPresence(empScreenTab)) {
				clickElement(empScreenTab, "EA tab");
			}
			if (opt.equalsIgnoreCase("SearchOrders"))
			{
				clickElement(searchOrder, "Search Orders");
				enterSearchDates();
				clickElement(searchBtn, "search button");
			}
		}else if(tab.equalsIgnoreCase("Case Management")) {
			if(verifyElementPresence(caseManagementTAb)) {
				clickElement(caseManagementTAb, "Case Management tab");
			}
			
			if (opt.equalsIgnoreCase("Case Search")){
				clickElement(searchCase, "Search Case");
				enterSearchDatesCM();
				clickElement(searchBtn, "search button");
			}
		}else if(tab.equalsIgnoreCase("Case Management")) {
			 if(opt.equalsIgnoreCase("Case Queue")){
				clickElement(casesInQueue, "Case Queue");
			}
		}else if(tab.equalsIgnoreCase("Global Search")) {
			 if(opt.equalsIgnoreCase("Global Search")){
				 EnterText(globalSearchTB, "Global Search", "Adams");
				clickElement(globalSearchBTN, "Global Search");
			}
		}else if(tab.equalsIgnoreCase("Case Management")) {
			if (opt.equalsIgnoreCase("Ready for Review (NON Circumstance)")){
				clickElement(searchCase, "Search Case");
				clickElement(readyForReviewNCLink, "Ready for Review (NON Circumstance)");
			}
		}else if(tab.equalsIgnoreCase("Case Management")) {
			if (opt.equalsIgnoreCase("Ready for Review (Circumstance)")){
				clickElement(searchCase, "Search Case");
				clickElement(readyForReviewCirLink, "Ready for Review (Circumstance)");
			}
		}else if(tab.equalsIgnoreCase("Case Management")) {
			if (opt.equalsIgnoreCase("Ungraded Manual Review")){
				clickElement(searchCase, "Search Case");
				clickElement(ManualReviewLink, "Ungraded Manual Review");
			}
		}
	}

	

	private void enterSearchDates() throws ParseException {
		LocalDate today=LocalDate.now();  //get current date
		LocalDate todayMinus7=today.minusDays(30);//-30 days from current date
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		String dateMinus7=dtf.format(todayMinus7);//formatted to dd/mmm/yyy pattern
		String dateToday=dtf.format(today);
		
		reportLog(Status.INFO, "From date : " +dateMinus7  , true);
		reportLog(Status.INFO, "To date : " +dateToday  , true);
		
		EnterText(search_fromDate, "from date field", dateMinus7);
		EnterText(search_toDate, "to date field", dateToday);
		
		System.out.println("From date : " +dateMinus7 );
		System.out.println("To date : " +dateToday );
		
	}
	private void enterSearchDatesCM() throws ParseException {
		LocalDate today = LocalDate.now(); // get current date
		LocalDate todayMinus7 = today.minusDays(30);// -15 days from current date

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		String dateMinus7 = dtf.format(todayMinus7);// formatted to dd/mmm/yyy pattern
		String dateToday = dtf.format(today);

		reportLog(Status.INFO, "From date : " + dateMinus7, true);
		reportLog(Status.INFO, "To date : " + dateToday, true);

		EnterText(search_fromDateCM, "from date field", dateMinus7);
		clickElement(search_toDateCM, "to date");
		EnterText(search_toDateCM, "to date field", dateToday);

		System.out.println("From date : " + dateMinus7);
		System.out.println("To date : " + dateToday);

	}
	

}
