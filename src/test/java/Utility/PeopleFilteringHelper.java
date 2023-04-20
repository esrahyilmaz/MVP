package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PeopleFilteringHelper {
    WebDriver driver;
    public PeopleFilteringHelper(WebDriver driver){
        this.driver=driver;
    }
    public Boolean isValidFilteringStatusDisplayed(By element, String status){
        return driver.findElements(element).stream().allMatch(x -> status.contains(x.getText()));
    }
}
