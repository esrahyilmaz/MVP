package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIHomePage  extends BaseClass {
	
	// -----------------------Menu-(navigation)-------------------------//
	
	//*[@class='nav-item ng-star-inserted active']
	
	By peopleLink=By.xpath("//ul/div/li[contains (., 'People')]");
	public By adminstrationLink=By.xpath("//ul/div/li[contains (., 'Administration')]");
	By userManagmentLink=By.xpath("//*[contains(@class, 'dropdown-item')][contains(text(), 'User Management')]");
	public By userYourPaymentsLink=By.xpath("//*[contains(@class, 'dropdown-item')][contains(text(), 'Your Payments')]");
	By dashboardLink = By.xpath("//div[contains(text(),'Dashboard')]");
	public By providersLink=By.xpath("//*[text()='Providers']");
	public By providersLinkElement=By.xpath("//li/div[text()='Providers']");
	public By providerSearch=By.id("providerName");
	public By providerPagination=By.cssSelector("pagination.pagination");
	public By noResultFoundElement=By.cssSelector("span.primary-color");
//	public By searchIcon=By.cssSelector("div.search-icon");
	public By searchIcon=By.xpath("//fa-icon[@id='searchIcon']//*[name()='svg']");
	
	public By profileIcon = By.id("help-btn");
	public By logOutNui =  By.id("logout");
	public By helpCenter= By.xpath("//li[contains(text(),'Help Center')]");
	

}
