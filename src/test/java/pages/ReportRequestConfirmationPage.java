package pages;

import Utility.CurrentDateTime;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumhelper.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportRequestConfirmationPage extends BaseClass {

	private static By RequestReportBtn = By.xpath("//input[@value='Request Report']");

	public void verifyReport() throws Exception {

		if (verifyElementPresence(RequestReportBtn)) {
			clickElement(RequestReportBtn, "request report");
		}

		String date = CurrentDateTime.SystemDateMMDD().toString();
		if (verifyElementPresence(
				By.xpath("//td[.='Vendor Compliance']/..//td[.='" + date + "']/..//td[.='Processing']"))) {
			reportLog(Status.PASS, "Report is present", true);
		} else {
			reportLog(Status.FAIL, "Report is not present", true);
		}
	}

	public void verifyActiveBadgeReport() throws Exception {
		int No = 0;
		String TodayDate1 = CurrentDateTime.getDateRepo().toString();
		List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));
		int count = elements.size();
		for (int i = 1; i <= count; i++) {
			String ActualDate = driver.findElement(By.xpath("(//table/tbody/tr/td[8])[" + i + "]")).getText();
			// Create SimpleDateFormat object
			SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");

			// Get the two dates to be compared
			Date d1 = sdfo.parse(ActualDate);
			Date d2 = sdfo.parse(TodayDate1);
			 if (d1.compareTo(d2) < 0) {

				// When Date d1 < Date d2
				System.out.println("Date1 is before Date2");
				reportLog(Status.FAIL, "Badge Expiration date is lesser than today ", true);
				No = 1;
			}
		}
		if (No == 0) {
			reportLog(Status.PASS, "Badge Expiration date is Greater than today ", true);
		}
	}
}