package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

import java.util.List;

public class NUIProgramOwnerWorkflowPeoplePage extends BaseClass {
    DatabaseClass databaseClass = new DatabaseClass();
    ExcelReader _dataRepo = new ExcelReader();

    public By nextPageButton = By.cssSelector("body > xf-root > xf-in-layout > div > main > xf-people-search > div:nth-child(2) > xf-table-pagination > div > pagination > ul > li.pagination-next.page-item > a > fa-icon");
    public By searchField = By.cssSelector("#providerName");
    public By searchIcon = By.cssSelector("#searchIcon");
    public By locationTile = By.xpath("//div[contains (@class, 'card-body') and contains (., 'Location')]");
    public By providerAddress1Xpath = By.xpath("//p[@class = 'card-text'][1]");
    public By providerAddress2Xpath = By.xpath("//p[@class = 'card-text'][2]");
    public By providerCityStateZipXpath = By.xpath("//p[@class = 'card-text'][3]");
    public By providerCountryXpath = By.xpath("//p[@class = 'card-text'][4]");
    public By accordionProvider = By.xpath("//td[@data-label = 'Name']");
    public By statusApplicant = By.xpath("//button[@value = 'APPLICANT']");
    public By statusActive = By.xpath("//button[@value = 'ACTIVE']");
    public By statusInactive = By.xpath("//button[@value = 'INACTIVE']");
    public By statusTerminated = By.xpath("//button[@value = 'TERMINATED']");
    public By providerNameFilter = By.xpath("//input[contains (@placeholder, 'Provider Name')]");
    public By providerNameFilterSelected = By.xpath("//input[contains (@placeholder, 'Provider Name')]/following-sibling::fa-icon");
    public By providerSearchBar=By.cssSelector("#providerName");
    public By ActivePeopleProviderQCSAVC=By.cssSelector("#panel-66364 > td.active-people-data.text-right > a > span");
    public By checkboxProvider=By.cssSelector(".a-panel input[type='checkbox']");
    public By providerPageActionButton=By.id("dropdownMenuButton");
    public By providerPageLengthOfService=By.cssSelector("td.lengthOfService");





    public void tableValidation(String pageName) {
        if (pageName.equalsIgnoreCase("Program Owner")) {
            String[] columnsProgramOwmner = {"Name", "Active People", "Length of Service", "Status"};
            for (String column : columnsProgramOwmner) {
                By columnNameXpath = By.xpath("//th[contains (., '" + column + "')]");
                if (verifyElementPresence(columnNameXpath)) {
                    logStepInfo("Table column '" + column + "' is present!");
                    reportLog(Status.PASS, "Table column " + column + " is present!", false);
                } else {
                    reportLog(Status.FAIL, "Table column " + column + " is not present!", false);
                }
            }
        } else if (pageName.equalsIgnoreCase("Program Owner - People Search")) {
            String columnsProgramOwner = "Provider Name";
            By columnNameXpath = By.xpath("//th[contains (., '" + columnsProgramOwner + "')][1]");
            if (verifyElementPresence(columnNameXpath)) {
                logStepInfo("Table column '" + columnsProgramOwner + "' is present!");
                reportLog(Status.PASS, "Table column " + columnsProgramOwner + " is present!", false);
            } else {
                reportLog(Status.FAIL, "Table column " + columnsProgramOwner + " is not present!", false);
            }
        }
    }

    public void activePeopleNumber() throws Exception {
        String query = "Select_ActivePeople";
        String provider = "AutoVendor";
//                _dataRepo.getData("ActiveProvider");
        String activePeopleDBNumber = databaseClass.getActivePeopleProgramOwner(query, provider);

        By activePeopleUI = By.xpath("//*[contains (@data-label, 'Name') and contains (., '" + provider + "')]/following::td[@data-label = 'Active People']");
        String activePeopleUINumber = driver.findElement(activePeopleUI).getText();

        if (activePeopleDBNumber.equals(activePeopleUINumber)) {
            logStepInfo("Comparing Active People for Provider");
            reportLog(Status.PASS, "Provider Active People Validated", false);
        } else {
            reportLog(Status.FAIL, "Provider Active People Differs from DB", false);
        }

        By activePeopleHyperlink = By.xpath("//*[contains (@data-label, 'Name') and contains (., '" + provider + "')]/following::td[@data-label = 'Active People']/a");
        verifyElementPresence(activePeopleHyperlink, "Active People Number is Hyperlinked");
    }

    public void accordionValidation() throws Exception {

        try {
            clickElement(accordionProvider, "Provider Accordion");
            reportLog(Status.PASS, "Provider Accordion Clicked!", false);
        } catch (Exception e) {
            reportLog(Status.FAIL, "Provider Accordion Not Clicked!", false);
        }

        if (verifyElementPresence(locationTile)) {
            logStepInfo("Provider Location Tile is displayed!");
            reportLog(Status.PASS, "Provider Location Tile is displayed!", true);
        } else {
            reportLog(Status.FAIL, "Provider Location Tile isn't displayed!", true);
        }

        String query = "Select_ProviderLocation";
        String provider = _dataRepo.getData("ActiveProvider");
        //test_data = "VendorInvoice";
        databaseClass.getProviderLocation(query, provider);

        String providerCityStateZipDB = providerCity + ", " + providerState + ", " + providerZipCode;

        if (providerCountry.equalsIgnoreCase("US")) {
            providerCountry = "UNITED STATES";
        }

        if (providerAddress2 == null) {
            providerAddress2 = "";
        }

        String providerAddress1UI = driver.findElement(providerAddress1Xpath).getText();
        String providerAddress2UI = driver.findElement(providerAddress2Xpath).getText();
        String providerCityStateZipUI = driver.findElement(providerCityStateZipXpath).getText();
        String providerCountryUI = driver.findElement(providerCountryXpath).getText();

        try {
            Assert.assertEquals(providerAddress1, providerAddress1UI);
            Assert.assertEquals(providerAddress2, providerAddress2UI);
            Assert.assertEquals(providerCityStateZipDB, providerCityStateZipUI);
            Assert.assertEquals(providerCountry, providerCountryUI);

            logStepInfo("Provider Location is verified!");
            reportLog(Status.PASS, "Provider Location is verified!", true);
        } catch (Exception e) {
            reportLog(Status.FAIL, "Provider Location doesn't match database", false);
        }
    }

    public void setProviderStatus(String value) throws Exception {
        try {
            clickProgramOwnerCheckbox();
            clickProgramOwnerActionButton();
            if (value.equalsIgnoreCase("Active")) {
                clickElement(statusActive, "Provider Status " + value);
                logStepInfo("Provider Status changed to: " + value);
                reportLog(Status.PASS, "Provider Status changed to: " + value, false);
            } else if (value.equalsIgnoreCase("Inactive")) {
                clickElement(statusInactive, "Provider Status " + value);
                logStepInfo("Provider Status changed to: " + value);
                reportLog(Status.PASS, "Provider Status changed to: " + value, false);
            } else if (value.equalsIgnoreCase("Applicant")) {
                clickElement(statusApplicant, "Provider Status " + value);
                logStepInfo("Provider Status changed to: " + value);
                reportLog(Status.PASS, "Provider Status changed to: " + value, false);
            } else {
                clickElement(statusTerminated, "Provider Status " + value);
                logStepInfo("Provider Status changed to: " + value);
                reportLog(Status.PASS, "Provider Status changed to: " + value, false);
            }
        } catch (Exception e) {
            reportLog(Status.FAIL, "Provider Status is NOT changed", false);
        }
    }

    public void clickProgramOwnerCheckbox() throws Exception {
        try {
            wait(2);
            ((JavascriptExecutor) driver).executeScript("document.querySelector('td.checkbox-holder > xf-checkbox > div > label').click()");
            logStepInfo("Checkbox for Provider clicked");
            reportLog(Status.PASS, "Checkbox for Provider clicked by JS Executer", false);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            reportLog(Status.FAIL, "Checkbox for Provider NOT clicked by JS Executer", false);
        }
    }

    public void clickProgramOwnerActionButton() throws Exception {
        By actionButton = By.xpath("//button[@id = 'dropdownMenuButton']");
        clickElement(actionButton, "Action button for selected Provider");
    }

    public void providerStatus(String Value) throws Exception {
        By providerStatusXpath = By.xpath("//*[contains (@data-label, 'Name') and contains (., '" + providerName + "')]/following::td[@data-label = 'Status'][last()]");
        String providerStatusUI = driver.findElement(providerStatusXpath).getText();
        if (providerStatusUI.equalsIgnoreCase(Value)) {
            logStepInfo("Provider Status is changed on UI!");
            reportLog(Status.PASS, "Provider Status change is validated on UI! Status is: " + Value, false);
        } else {
            logStepInfo("Provider Status is not changed on UI!");
            reportLog(Status.FAIL, "Provider Status change is NOT validated on UI! Status is: " + providerStatusUI, true);
        }
    }

    public void verifyProviderNameForPeople() throws Exception {
        String result = null;
        List<WebElement> rowXpath = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 0; i <= rowXpath.size(); i++) {
            String atributeValue = "panel-" + i;
            By providerNameXpath = By.xpath("//*[@id='" + atributeValue + "']/td[8]/div");
            By personNameXpath = By.xpath("//*[@id='" + atributeValue + "']/td[2]");
            String providerNameTxt = driver.findElement(providerNameXpath).getText();
            String personTxt = driver.findElement(personNameXpath).getText();

            if (personTxt.equalsIgnoreCase(existingFullName)) {
                if (providerNameTxt.equalsIgnoreCase(providerName)) {
                    logStepInfo("Provider Name for searched Person validated!");
                    reportLog(Status.PASS, "Provider Name for searched Person is validated! Provider Name is: " + providerName, false);
                } else {
                    logStepInfo("Provider Name for searched Person isn't validated!");
                    reportLog(Status.FAIL, "Provider Name for searched Person isn't validated! Provider Name is: " + providerName, false);
                }
                break;
            }
        }
    }

    public void validateFilter(String filter, String pageName) throws Exception {
       String filterPeopleNumberDB = databaseClass.getPeopleNumberFiltering(filter, pageName);

        if(peopleSearchWithFilter.equals(filterPeopleNumberDB)){
            logStepInfo("Validated filter: " + filter + "for People Search");
            reportLog(Status.PASS, "Validated filter: " + filter + "for People Search", false);
        } else {
            logStepInfo("Number of records for: " + filter + " filter do not match to DB!");
            reportLog(Status.FAIL, "Number of records for: " + filter + " filter do not match to DB!", false);
        }
    }

    public void validateNoFilter(String pageName) throws Exception {
        String filterPeopleNumberDB = databaseClass.getPeopleNumberWihtoutFiltering(pageName);

        if(peopleSearchWithoutFilter.equals(filterPeopleNumberDB)){
            logStepInfo("Validated records without filters for: " +pageName);
            reportLog(Status.PASS, "Validated records without filters for: " +pageName, false);
        } else {
            logStepInfo("Number of records do not match to DB for : " + pageName);
            reportLog(Status.FAIL, "Number of records do not match to DB for : " + pageName, false);
        }
    }
}
