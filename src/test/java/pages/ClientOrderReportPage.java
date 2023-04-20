package pages;

import Utility.CurrentDateTime;
import Utility.HandlePopUp;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class ClientOrderReportPage extends BaseClass{

	HandlePopUp hp=new HandlePopUp();
	
	private static By GetReportBtn=By.xpath("//input[@value='GET REPORT']");
	private static By startDateImg=By.xpath("//b[.='Start Date: ']/../img");
	private static By endDateImg=By.xpath("//b[.='End Date:']/../img");
	private static By MiddleNameOptionDD=By.xpath("//select[@name='middleNameOption']");
	private static By previousMonthBtn=By.xpath("//div[.='�']");
	
	
	public void validateClientOrderReport() throws Exception {
		
		String Day=CurrentDateTime.SystemDateDay();
		
	    if (Day.equalsIgnoreCase("01")) {
	    	Day ="1";
	    }
	    else if (Day.equalsIgnoreCase("02")) {
	    	Day ="2";
	    }
	    else if (Day.equalsIgnoreCase("03")) {
	    	Day ="3";
	    }
	    else if (Day.equalsIgnoreCase("04")) {
	    	Day ="4";
	    }
	    else if (Day.equalsIgnoreCase("05")) {
	    	Day ="5";
	    }
	    else if (Day.equalsIgnoreCase("06")) {
	    	Day ="6";
	    }
	    else if (Day.equalsIgnoreCase("07")) {
	    	Day ="7";
	    }
	    else if (Day.equalsIgnoreCase("08")) {
	    	Day ="8";
	    }
	    else if (Day.equalsIgnoreCase("09")) {
	    	Day ="9";
	    }
		if(verifyElementPresence(GetReportBtn)) {
			clickElement(GetReportBtn, "Get Report");
		}
		
		hp.handlePopUp();
		
		if(verifyElementPresence(startDateImg)) {
			clickElement(startDateImg, "start Date Img");
		}
		
		if(verifyElementPresence(previousMonthBtn)) {
			clickElement(previousMonthBtn, "previous Month Btn");
		}
		
		if(verifyElementPresence(By.xpath("(//td[.='"+Day+"'])[last()]"))) {
			clickElement(By.xpath("(//td[.='"+Day+"'])[last()]"), Day);
		}
		
		if(verifyElementPresence(GetReportBtn)) {
			clickElement(GetReportBtn, "Get Report");
		}
		
		hp.handlePopUp();
		
		if(verifyElementPresence(endDateImg)) {
			clickElement(endDateImg, "End Date Img");
		}
		
		if(verifyElementPresence(By.xpath("(//td[.='"+Day+"'])[last()]"))) {
			clickElement(By.xpath("(//td[.='"+Day+"'])[last()]"), Day);
		}
		
		if(verifyElementPresence(GetReportBtn)) {
			clickElement(GetReportBtn, "Get Report");
		}
		
		hp.handlePopUp();
		
		if(verifyElementPresence(MiddleNameOptionDD)) {
			selectDropDown(MiddleNameOptionDD, "Yes", "Middle Name");
		}
		
		if(verifyElementPresence(GetReportBtn)) {
			clickElement(GetReportBtn, "Get Report");
		}
		
		int MiddleNameOptionAll=driver.findElements(By.xpath("(//tr[@class='data'])//td[7]")).size();
		
		for(int i=1;i<=MiddleNameOptionAll;i++) {
			
			String middleNameOption=driver.findElement(By.xpath("((//tr[@class='data'])//td[7])["+i+"]")).getText();
			String middleName=driver.findElement(By.xpath("((//tr[@class='data'])//td[5])["+i+"]")).getText();
			if(!(middleNameOption.equalsIgnoreCase("Y")) && middleName.equalsIgnoreCase("")) {
				reportLog(Status.FAIL, "Middle Name Option is N in the Row number "+i, true);
			}			
		}
		
		if(verifyElementPresence(MiddleNameOptionDD)) {
			selectDropDown(MiddleNameOptionDD, "No", "Middle Name");
		}
		
		if(verifyElementPresence(GetReportBtn)) {
			clickElement(GetReportBtn, "Get Report");
		}
		
		MiddleNameOptionAll=driver.findElements(By.xpath("(//tr[@class='data'])//td[7]")).size();
		
		for(int j=1;j<=MiddleNameOptionAll;j++) {
			
			String middleNameOption=driver.findElement(By.xpath("((//tr[@class='data'])//td[7])["+j+"]")).getText();
			String middleName=driver.findElement(By.xpath("((//tr[@class='data'])//td[5])["+j+"]")).getText();
			if(!(middleNameOption.equalsIgnoreCase("N")) && !(middleName.equalsIgnoreCase(""))) {
				reportLog(Status.FAIL, "Middle Name Option is Y in the Row number "+j, true);
			}			
		}
		
	}
}
