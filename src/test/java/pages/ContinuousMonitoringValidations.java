package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class ContinuousMonitoringValidations extends BaseClass{
	
	private static By enrollmentColoumn=By.xpath("//th[contains(.,'Enrollment Status')]/../../..//tr/td[9]");
	private static By monitoringColoumn=By.xpath("//th[contains(.,'Monitoring Status')]/../../..//tr/td[20]");

	public void vendorSearchvalidation(String Status){
		
		if(Status.equalsIgnoreCase("select")) {
			int size=driver.findElements(enrollmentColoumn).size();
			for(int i=1;i<=size;i++) {
				String text=driver.findElement(By.xpath("(//th[contains(.,'Enrollment Status')]/../../..//tr/td[9])["+i+"]")).getText();
				if(!(text.equalsIgnoreCase("")||text.equalsIgnoreCase("Enabled")||text.equalsIgnoreCase("Not Enabled"))) {
					reportLog(com.aventstack.extentreports.Status.FAIL, "Enrollment Status When selected "+Status+" is not as Expected", true);
					break;
				}
			}
		}
		
		if(Status.equalsIgnoreCase("Enabled")) {
			int size=driver.findElements(enrollmentColoumn).size();
			for(int i=1;i<=size;i++) {
				String text=driver.findElement(By.xpath("(//th[contains(.,'Enrollment Status')]/../../..//tr/td[9])["+i+"]")).getText();
				if(!(text.equalsIgnoreCase("Enabled"))) {
					reportLog(com.aventstack.extentreports.Status.FAIL, "Enrollment Status When selected "+Status+" is not as Expected", true);
					break;
				}
			}
		}
		
		if(Status.equalsIgnoreCase("Not Enabled")) {
			int size=driver.findElements(enrollmentColoumn).size();
			for(int i=1;i<=size;i++) {
				String text=driver.findElement(By.xpath("(//th[contains(.,'Enrollment Status')]/../../..//tr/td[9])["+i+"]")).getText();
				if(!(text.equalsIgnoreCase("Not Enabled"))) {
					reportLog(com.aventstack.extentreports.Status.FAIL, "Enrollment Status When selected "+Status+" is not as Expected", true);
					break;
				}
			}
		}
	}
	
public void peopleSearchvalidation(String Status){
		
		if(Status.equalsIgnoreCase("select")) {
			int size=driver.findElements(monitoringColoumn).size();
			for(int i=1;i<=size;i++) {
				String text=driver.findElement(By.xpath("(//th[contains(.,'Monitoring Status')]/../../..//tr/td[20])["+i+"]")).getText();
				if(!(text.equalsIgnoreCase("")||text.equalsIgnoreCase("Enabled")||text.equalsIgnoreCase("Not Enabled"))) {
					reportLog(com.aventstack.extentreports.Status.FAIL, "Monitoring Status When selected "+Status+" is not as Expected", true);
					break;
				}
			}
		}
		
		if(Status.equalsIgnoreCase("Enabled")) {
			int size=driver.findElements(monitoringColoumn).size();
			for(int i=1;i<=size;i++) {
				String text=driver.findElement(By.xpath("(//th[contains(.,'Monitoring Status')]/../../..//tr/td[20])["+i+"]")).getText();
				if(!(text.equalsIgnoreCase("Enabled"))) {
					reportLog(com.aventstack.extentreports.Status.FAIL, "Monitoring Status When selected "+Status+" is not as Expected", true);
					break;
				}
			}
		}
		
		if(Status.equalsIgnoreCase("Not Enabled")) {
			int size=driver.findElements(monitoringColoumn).size();
			for(int i=1;i<=size;i++) {
				String text=driver.findElement(By.xpath("(//th[contains(.,'Monitoring Status')]/../../..//tr/td[20])["+i+"]")).getText();
				if(!(text.equalsIgnoreCase("Not Enabled"))) {
					reportLog(com.aventstack.extentreports.Status.FAIL, "Monitoring Status When selected "+Status+" is not as Expected", true);
					break;
				}
			}
		}
	}
}
