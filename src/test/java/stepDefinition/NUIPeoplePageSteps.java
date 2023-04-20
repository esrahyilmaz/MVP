package stepDefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.NUIPeoplePage;
import pages.NUIProgramOwnerWorkflowPeoplePage;
import seleniumhelper.BaseClass;

public class NUIPeoplePageSteps extends BaseClass {
    NUIPeoplePage nuiPeoplePage=new NUIPeoplePage();
    //todo remove this object and migrate to program owner
    NUIProgramOwnerWorkflowPeoplePage nuiProgramOwnerWorkflowPeoplePage=new NUIProgramOwnerWorkflowPeoplePage();

    @And("^I place a new people order with \"([^\"]*)\"$")
    public void iPlaceANewPeopleOrderWith(String paymentMethod) throws Throwable {
        nuiPeoplePage.newOrder(paymentMethod);
    }
    @And("^I should see element \"([^\"]*)\" for \"([^\"]*)\" for People$")
    public void I_should_see_element_on_(String Value, String identifier) throws Exception {
        wait(3);
        switch (identifier.toLowerCase()) {
            case "person status accordion search":
                wait(3);
                int counters = 0;
                if (verifyElementPresence(nuiPeoplePage.noResultsFoundPeoplePage)) {
                    reportLog(Status.PASS, "No Result Found", false);
   //                 break;
                } 
                //else {
        //            WebElement nextPageButton = driver.findElement(nuiPeoplePage.nextPageButton);
          //          do {
                else if (!nuiPeoplePage.isValidFilteringStatusDisplayed(nuiPeoplePage.personStatusLocatorVendor, Value)) {
                            counters++;
                            logStepInfo("Page " + counters + " is Invalid");
                            reportLog(Status.FAIL, "Page " + counters + " is Invalid", true);
                            return;
                        }
       //               counters++;
        //                logStepInfo("Page " + counters + " is Valid");
                   //     nextPageButton.click();
 //                   } while (nuiPeoplePage.pageHasNext());
//                    logStepInfo("All statuses are valid");
//                    reportLog(Status.PASS, "All statuses are valid", true);
 //                   break;
   //             }
    
            case "compliance accordion search":
                wait(3);
                int countersCompliance = 0;
                if (verifyElementPresence(nuiPeoplePage.noResultsFoundPeoplePage)) {
                    reportLog(Status.PASS, "No Result Found", false);
                    break;
                } else {
                    WebElement nextPageButton = driver.findElement(nuiPeoplePage.nextPageButton);
                    do {
                        if (!nuiPeoplePage.isValidFilteringStatusDisplayed(nuiPeoplePage.complianceStatusLocatorVendor, Value)) {
                            countersCompliance++;
                            logStepInfo("Page " + countersCompliance + " is Invalid");
                            reportLog(Status.FAIL, "Page " + countersCompliance + " is Invalid", true);
                            return;
                        }
                        countersCompliance++;
                        logStepInfo("Page " + countersCompliance + " is Valid");
                        nextPageButton.click();
                    } while (nuiPeoplePage.pageHasNext());
                    logStepInfo("All compliance statuses are valid");
                    reportLog(Status.PASS, "All compliance statuses are valid", true);
                    break;
                }
            case "screening accordion search":
                wait(3);
                int countersScreening = 0;
                if (verifyElementPresence(nuiPeoplePage.noResultsFoundPeoplePage)) {
                    reportLog(Status.PASS, "No Result Found", false);
                    break;
                } else {
                    WebElement nextPageButton= driver.findElement(nuiPeoplePage.nextPageButton);
                    do {
                        if(!nuiPeoplePage.isValidFilteringStatusDisplayed(nuiPeoplePage.screeningStatusLocatorVendor, Value)){
                            countersScreening++;
                            logStepInfo("Page "+countersScreening+" is Invalid");
                            reportLog(Status.FAIL, "Page "+countersScreening+" is Invalid", true);
                            return;
                        }
                        countersScreening++;
                        logStepInfo("Page "+countersScreening+" is Valid");
                        nextPageButton.click();
                    }while (nuiPeoplePage.pageHasNext());
                    logStepInfo("All complieance statuses are valid");
                    reportLog(Status.PASS, "All compliance statuses are valid", true);
                    break;
                }
            case "checkbox checked":
                if(Value.equalsIgnoreCase("skip")){
                    logStepInfo("Step skipped");
                    return;
                }
                String checked = ((JavascriptExecutor) driver).executeScript("return document.getElementById('" + Value + "').checked==true;").toString();
                System.out.println("JS checkbox check: " + checked);
                if (checked.equalsIgnoreCase("true")) {
                    reportLog(Status.PASS, "Element is checked", false);
                } else {
                    reportLog(Status.FAIL, "Element is unchecked", false);
                    break;
                }
                break;

            //todo migrate to Program Owner
            case "provider name filter":
                if (verifyElementPresence(nuiProgramOwnerWorkflowPeoplePage.providerNameFilter)) {
                    String providerFilter = driver.findElement(nuiProgramOwnerWorkflowPeoplePage.providerNameFilter).getAttribute("value");
                    Assert.assertEquals(providerName, providerFilter);
                    verifyElementPresence(nuiProgramOwnerWorkflowPeoplePage.providerNameFilterSelected, "Provider Name Filter marked as selected.");
                    logStepInfo("Provider Name Filter is validated!");
                    reportLog(Status.PASS, "Provider Name Filter is validated!", true);
                } else {
                    logStepInfo("Provider Name Filter is NOT displayed!");
                    reportLog(Status.FAIL, "Provider Name Filter is NOT displayed!", true);
                }
                break;
        }
    }

}
