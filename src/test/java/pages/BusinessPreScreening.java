package pages;

import Utility.CurrentDateTime;
import Utility.DeleteFile;
import Utility.HandlePopUp;
import Utility.ReadFile;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class BusinessPreScreening extends BaseClass {

	private static By companyNameTB = By.xpath("//input[@name='prescreenVendor.name']");
	private static By address1TB = By.xpath("//input[@name='address.addrLine1']");
	private static By cityTB = By.xpath("//input[@name='address.cityName']");
	private static By stateDD = By.xpath("//select[@name='address.stateCode']");
	private static By zipTB = By.xpath("//input[@name='address.zipCode']");
	private static By phoneNumberTB = By.xpath("//input[@name='prescreenVendor.phoneNumber']");
	private static By OrderBTN=By.xpath("//input[@value='ORDER']");
	private static By PrintBtn=By.xpath("//input[@value='PRINT CURRENT RECEIPT']");
	private static By searchCompanyNameTB=By.xpath("//input[@name='name']");
	private static By OrderStatusDD=By.xpath("//select[@name='businessReportStatus']");
	private static By fromDateImg=By.xpath("//input[@name='fromOrderDate']/..//img[1]");
	private static By toDateImg=By.xpath("//input[@name='fromOrderDate']/..//img[2]");
	private static By searchBTN=By.xpath("//input[@value='Search']");
	private static By clearBTN=By.xpath("//input[@value='Clear']");
	
	//Batch Load
	private static By XLStemplateLink=By.xpath("//a[contains(@href,'.xls')]");
	private static By CSVtemplateLink=By.xpath("//a[contains(@href,'.csv')]");
	private static By BatchXLStemplateLink=By.xpath("(//a[contains(@href,'.xls')])[last()]");

	String companyName;
	String Address1;
	String City;
	String State;
	String Zip;
	String phone;
	double total=0;
	double totalPayment=0;
	
	ArrayList<String> Package=new ArrayList<String>();
	HashMap<String,String> PricePackage=new HashMap<String,String>();

	public void orderReport(String companyName, String Address1, String City, String State, String Zip, String phone,String StateSF) {
		this.companyName = companyName;
		this.Address1 = Address1;
		this.City = City;
		this.State = StateSF;
		this.Zip = Zip;
		this.phone = phone;

		if (verifyElementPresence(companyNameTB)) {
			EnterText(companyNameTB, "Company Name", companyName);
		}

		if (verifyElementPresence(address1TB)) {
			EnterText(address1TB, "Address1", Address1);
		}

		if (verifyElementPresence(cityTB)) {
			EnterText(cityTB, "City", City);
		}

		if (verifyElementPresence(stateDD)) {
			selectDropDown(stateDD, State, "State");
		}

		if (verifyElementPresence(zipTB)) {
			EnterText(zipTB, "ZIP", Zip);
		}

		if (verifyElementPresence(phoneNumberTB)) {
			EnterText(phoneNumberTB, "Phone Number", phone);
		}

	}

	public void selectReportComponents(String value) {
		if (verifyElementPresence(By.xpath("(//td[contains(.,'" + value + "')])[last()]/..//input[@type='checkbox']"))) {
			clickElement(By.xpath("(//td[contains(.,'" + value + "')])[last()]/..//input[@type='checkbox']"), value);
			String price1=driver.findElement(By.xpath("(//td[contains(.,'"+value+"')])[last()]/..//td[4]")).getText();
			String price=price1.replaceAll(" ", "");
			price=price.substring(1);
			total=total+Double.parseDouble(price);
			Package.add(value);
			PricePackage.put(value, price);
		}
	}
	
	public void verifyBusinessPaymentDetailPage() {
		verifyTextPresence(companyName);
		verifyTextPresence(Address1);
		verifyTextPresence(City);
		verifyTextPresence(State);
		verifyTextPresence(Zip);
		verifyTextPresence(phone);
		
		for(String text:Package) {
			String price=driver.findElement(By.xpath("(//td[contains(.,'"+text+"')])[last()]/..//td[2]")).getText();
			price=price.substring(1);
			totalPayment=totalPayment+Double.parseDouble(price);
		}
		if(total==totalPayment) {
			String ActualTotal=driver.findElement(By.xpath("((//b[contains(.,'Total')])[last()]/../..//b)[last()]")).getText();
			String Invoice=driver.findElement(By.xpath("((//b[contains(.,'Invoice')])[last()]/../..//td)[last()]")).getText();
			String ExpectedTotal=""+total;
			if(ActualTotal.contains(ExpectedTotal) && ActualTotal.equalsIgnoreCase(Invoice)) {
				reportLog(Status.PASS, "Expected Total ["+ExpectedTotal+"] Actual Total ["+ActualTotal+"] INVOICE ["+Invoice+"]", true);
			}else {
				reportLog(Status.FAIL, "Total is not Matching", true);
			}	
		}else {
			reportLog(Status.FAIL, "Total is not Matching", true);
		}
		
		if(verifyElementPresence(OrderBTN)) {
			clickElement(OrderBTN, "Order");
		}
		
		new HandlePopUp().handlePopUp();
	}
	
	public void verifyBusinessOrderConfirmationPage() throws Exception {
		
		String Date=CurrentDateTime.SystemDateMMDD().toString();
		
		verifyTextPresence(companyName);
		verifyTextPresence(Address1);
		verifyTextPresence(City);
		verifyTextPresence(State);
		verifyTextPresence(Zip);
		verifyTextPresence(phone);
		
		if(verifyElementPresence(By.xpath("(//*[contains(.,'Prescreen report for "+companyName+" Company has been successfully ordered')])[last()]"))) {
			reportLog(Status.PASS, "Prescreen report for "+companyName+" Company has been successfully ordered is present", true);
		}else {
			reportLog(Status.FAIL, "Prescreen report for "+companyName+" Company has been successfully ordered is not present", true);
		}
		
		if(verifyElementPresence(By.xpath("//b[.='Order Details for:']/../..//b[.='"+companyName+"']")) && verifyElementPresence(By.xpath("//b[contains(.,'Company Name:')]/../..//td[contains(.,'"+companyName+"')]"))) {
			reportLog(Status.PASS, "Company Name is present", true);
		}else {
			reportLog(Status.FAIL, "Company Name is not present", true);
		}
		
		if(verifyElementPresence(By.xpath("//b[contains(.,'Order Date:')]/../..//td[.='"+Date+"']"))) {
			reportLog(Status.PASS, "Order Date is present", true);
		}else {
			reportLog(Status.FAIL, "Order Date is not present", true);
		}
		
		OrderID=driver.findElement(By.xpath("(//b[contains(.,'Order ID:')]/../..//td)[last()]")).getText();
		if(!(OrderID==null)||!(OrderID.equalsIgnoreCase(""))) {
			reportLog(Status.PASS, "Order ID is present "+OrderID, true);
		}else {
			reportLog(Status.FAIL, "Order ID is not present "+OrderID, true);
		}
		
		if(verifyElementPresence(By.xpath("(//td[contains(.,'Payment Method:')])[last()]/..//td[contains(.,'Invoiced')]"))) {
			reportLog(Status.PASS, "Payment Method Invoice is present", true);
		}else {
			reportLog(Status.FAIL, "Payment Type Invoice is not present", true);
		}
		
		for(String text:Package) {
			String price=driver.findElement(By.xpath("(//td[contains(.,'"+text+"')])[last()]/..//td[2]")).getText();
			price=price.substring(1);
			String pricepak=PricePackage.get(text);
			if(verifyElementPresence(By.xpath("(//td[contains(.,'"+text+"')])[last()]/..//td[contains(.,'"+pricepak+"')]"))) {
				reportLog(Status.PASS, "Component ["+text+"] Price ["+pricepak+"]", true);
			}else {
				reportLog(Status.FAIL, "Component and its respective price is not present", true);
			}
		}
		if(total==totalPayment) {
			String ActualTotal=driver.findElement(By.xpath("((//b[contains(.,'Total')])[last()]/../..//b)[last()]")).getText();
			String Invoice=driver.findElement(By.xpath("((//b[contains(.,'Invoice')])[last()]/../..//td)[last()]")).getText();
			String ExpectedTotal=""+total;
			if(ActualTotal.contains(ExpectedTotal) && ActualTotal.equalsIgnoreCase(Invoice)) {
				reportLog(Status.PASS, "Expected Total ["+ExpectedTotal+"] Actual Total ["+ActualTotal+"] INVOICE ["+Invoice+"]", true);
			}else {
				reportLog(Status.FAIL, "Total is not Matching", true);
			}	
		}else {
			reportLog(Status.FAIL, "Total is not Matching", true);
		}
		
	}
	
public void verifyBusinessPrintReceipt() throws Exception {
	
	String parent = driver.getWindowHandle();
	if(verifyElementPresence(PrintBtn)) {
		clickElement(PrintBtn, "PRINT CURRENT RECEIPT");
	}
	reportLog(Status.INFO, "VERIFING RECEIPT ", false);
	wait(30);
	Set<String> allWindowHandles = driver.getWindowHandles();
	ArrayList<String> Windows=new ArrayList<String>();
	for (String handle : allWindowHandles) {
		Windows.add(handle);
	}
		if (!(Windows.get(2)==null)||!(Windows.get(2).equalsIgnoreCase(""))) {
			driver.switchTo().window(Windows.get(2));
			
			String Date=CurrentDateTime.SystemDateMMDD().toString();
			
			verifyTextPresence(companyName);
			verifyTextPresence(Address1);
			verifyTextPresence(City);
			verifyTextPresence(State);
			verifyTextPresence(Zip);
			verifyTextPresence(phone);
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'Prescreen report for "+companyName+" Company has been successfully ordered')])[last()]"))) {
				reportLog(Status.PASS, "Prescreen report for "+companyName+" Company has been successfully ordered is present", true);
			}else {
				reportLog(Status.FAIL, "Prescreen report for "+companyName+" Company has been successfully ordered is not present", true);
			}
			
			if(verifyElementPresence(By.xpath("//b[.='Order Details for:']/../..//b[.='"+companyName+"']")) && verifyElementPresence(By.xpath("//b[contains(.,'Company Name:')]/../..//td[contains(.,'"+companyName+"')]"))) {
				reportLog(Status.PASS, "Company Name is present", true);
			}else {
				reportLog(Status.FAIL, "Company Name is not present", true);
			}
			
			if(verifyElementPresence(By.xpath("//b[contains(.,'Order Date:')]/../..//td[.='"+Date+"']"))) {
				reportLog(Status.PASS, "Order Date is present", true);
			}else {
				reportLog(Status.FAIL, "Order Date is not present", true);
			}
			
			OrderID=driver.findElement(By.xpath("(//b[contains(.,'Order ID:')]/../..//td)[last()]")).getText();
			if(!(OrderID==null)||!(OrderID.equalsIgnoreCase(""))) {
				reportLog(Status.PASS, "Order ID is present "+OrderID, true);
			}else {
				reportLog(Status.FAIL, "Order ID is not present "+OrderID, true);
			}
			
			if(verifyElementPresence(By.xpath("(//td[contains(.,'Payment Method:')])[last()]/..//td[contains(.,'Invoiced')]"))) {
				reportLog(Status.PASS, "Payment Method Invoice is present", true);
			}else {
				reportLog(Status.FAIL, "Payment Type Invoice is not present", true);
			}
			
			for(String text:Package) {
				String price=driver.findElement(By.xpath("(//td[contains(.,'"+text+"')])[last()]/..//td[2]")).getText();
				price=price.substring(1);
				String pricepak=PricePackage.get(text);
				if(verifyElementPresence(By.xpath("(//td[contains(.,'"+text+"')])[last()]/..//td[contains(.,'"+pricepak+"')]"))) {
					reportLog(Status.PASS, "Component ["+text+"] Price ["+pricepak+"]", true);
				}else {
					reportLog(Status.FAIL, "Component and its respective price is not present", true);
				}
			}
			if(total==totalPayment) {
				String ActualTotal=driver.findElement(By.xpath("((//b[contains(.,'Total')])[last()]/../..//b)[last()]")).getText();
				String Invoice=driver.findElement(By.xpath("((//b[contains(.,'Invoice')])[last()]/../..//td)[last()]")).getText();
				String ExpectedTotal=""+total;
				if(ActualTotal.contains(ExpectedTotal) && ActualTotal.equalsIgnoreCase(Invoice)) {
					reportLog(Status.PASS, "Expected Total ["+ExpectedTotal+"] Actual Total ["+ActualTotal+"] INVOICE ["+Invoice+"]", true);
				}else {
					reportLog(Status.FAIL, "Total is not Matching", true);
				}	
			}else {
				reportLog(Status.FAIL, "Total is not Matching", true);
			}
			
			driver.close();
		}		
	
	driver.switchTo().window(parent);
		
		
	}

		public void verifySearchReport() throws Exception {
			
			String day=new CurrentDateTime().SystemDateDay();
			
			if (day.equalsIgnoreCase("01")) {
		    	day ="1";
		    }
		    else if (day.equalsIgnoreCase("02")) {
		    	day ="2";
		    }
		    else if (day.equalsIgnoreCase("03")) {
		    	day ="3";
		    }
		    else if (day.equalsIgnoreCase("04")) {
		    	day ="4";
		    }
		    else if (day.equalsIgnoreCase("05")) {
		    	day ="5";
		    }
		    else if (day.equalsIgnoreCase("06")) {
		    	day ="6";
		    }
		    else if (day.equalsIgnoreCase("07")) {
		    	day ="7";
		    }
		    else if (day.equalsIgnoreCase("08")) {
		    	day ="8";
		    }
		    else if (day.equalsIgnoreCase("09")) {
		    	day ="9";
		    }
			
			if(verifyElementPresence(searchCompanyNameTB)) {
				EnterText(searchCompanyNameTB, "Company Name", companyName);
			}
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "In Process", "In Process");
			}
			
			if(verifyElementPresence(fromDateImg)) {
				clickElement(fromDateImg, "From Date");
				clickElement(By.xpath("//td[.='"+day+"']"), "Today's Date");
			}
			
			if(verifyElementPresence(toDateImg)) {
				clickElement(toDateImg, "To Date");
				clickElement(By.xpath("(//td[.='"+day+"'])[last()]"), "Today's Date");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			if(verifyElementPresence(By.xpath("//a[contains(.,'"+companyName+"')]"))) {
				reportLog(Status.PASS, "Company name Record is present", true);
			}else {
				reportLog(Status.FAIL, "Company name Record is not present", true);
			}
			verifyTextPresence("1 prescreening businesses found. Displaying all the prescreening businesses.");
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "Acknowledged", "Acknowledged");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			verifyTextPresence("No record found.");
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "Not Acknowledged", "Not Acknowledged");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			verifyTextPresence("No record found.");
			
			if(verifyElementPresence(clearBTN)) {
				clickElement(clearBTN, "Clear");
			}
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "In Process", "In Process");
			}
			
			if(verifyElementPresence(fromDateImg)) {
				clickElement(fromDateImg, "From Date");
				clickElement(By.xpath("//div[.='�']"), "Previous Month");
				clickElement(By.xpath("//td[.='1']"), "1 st");
			}
			
			if(verifyElementPresence(toDateImg)) {
				clickElement(toDateImg, "To Date");				
				clickElement(By.xpath("(//td[.='"+day+"'])[last()]"), "Today's Date");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			if(verifyElementPresence(By.xpath("//a[contains(.,'"+companyName+"')]"))) {
				reportLog(Status.PASS, "Company name Record is present", true);
			}else {
				reportLog(Status.FAIL, "Company name Record is not present", true);
			}
			
			int size=driver.findElements(By.xpath("//a[.='view report']")).size();
			verifyTextPresence(size+" prescreening businesses found. Displaying all the prescreening businesses.");
			
		}
		
public void viewReport() throws Exception {
			
			int size=0;
			String day=new CurrentDateTime().SystemDateDay();
			String Parent=driver.getWindowHandle();
			
			if (day.equalsIgnoreCase("01")) {
		    	day ="1";
		    }
		    else if (day.equalsIgnoreCase("02")) {
		    	day ="2";
		    }
		    else if (day.equalsIgnoreCase("03")) {
		    	day ="3";
		    }
		    else if (day.equalsIgnoreCase("04")) {
		    	day ="4";
		    }
		    else if (day.equalsIgnoreCase("05")) {
		    	day ="5";
		    }
		    else if (day.equalsIgnoreCase("06")) {
		    	day ="6";
		    }
		    else if (day.equalsIgnoreCase("07")) {
		    	day ="7";
		    }
		    else if (day.equalsIgnoreCase("08")) {
		    	day ="8";
		    }
		    else if (day.equalsIgnoreCase("09")) {
		    	day ="9";
		    }
			
			if(verifyElementPresence(searchCompanyNameTB)) {
				EnterText(searchCompanyNameTB, "Company Name", companyName);
			}
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "In Process", "In Process");
			}
			
			if(verifyElementPresence(fromDateImg)) {
				clickElement(fromDateImg, "From Date");
				clickElement(By.xpath("//td[.='"+day+"']"), "Today's Date");
			}
			
			if(verifyElementPresence(toDateImg)) {
				clickElement(toDateImg, "To Date");
				clickElement(By.xpath("(//td[.='"+day+"'])[last()]"), "Today's Date");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			if(verifyElementPresence(By.xpath("//a[contains(.,'"+companyName+"')]"))) {
				reportLog(Status.PASS, "Company name Record is present", true);
			}else {
				reportLog(Status.FAIL, "Company name Record is not present", true);
			}
			verifyTextPresence("1 prescreening businesses found. Displaying all the prescreening businesses.");
			
			clickElement(By.xpath("//a[.='view report']"), "view report");
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
				if (!(handle.equalsIgnoreCase(Parent))) {
					driver.switchTo().window(handle);
					size=driver.findElements(By.xpath("//td[contains(.,'NEW')]")).size();
					if(size==4) {
						reportLog(Status.PASS, "Report Status is 'New' for the Record", true);
					}else {
						reportLog(Status.FAIL, "Report Status is not 'New' for all the Record", true);
					}
					driver.close();
				}
			}
			driver.switchTo().window(Parent);
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "Acknowledged", "Acknowledged");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			verifyTextPresence("No record found.");
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "Not Acknowledged", "Not Acknowledged");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			verifyTextPresence("No record found.");
			
			if(verifyElementPresence(clearBTN)) {
				clickElement(clearBTN, "Clear");
			}
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "Acknowledged", "Acknowledged");
			}
			
			if(verifyElementPresence(fromDateImg)) {
				clickElement(fromDateImg, "From Date");
				String Year=CurrentDateTime.SystemDateYear();
				int years=Integer.parseInt(Year);
				years=years-2019;
				for(int i=1;i<=years;i++) {
					clickElement(By.xpath("//div[.='�']"), "Previous Year");
				}
				String month=CurrentDateTime.SystemDateMonth1();
				int months=Integer.parseInt(month);
				if(months>=9) {
					for(int i=1;i<=5;i++) {
						clickElement(By.xpath("//div[.='�']"), "Previous Month");
					}
				}
				clickElement(By.xpath("//td[.='1']"), "1 st Date");
			}
			
			if(verifyElementPresence(toDateImg)) {
				clickElement(toDateImg, "To Date");				
				clickElement(By.xpath("(//td[.='"+day+"'])[last()]"), "Today's Date");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			
			size=driver.findElements(By.xpath("//a[.='view report']")).size();
			verifyTextPresence(size+" prescreening businesses found. Displaying all the prescreening businesses.");
			
			clickElement(By.xpath("//a[.='view report']"), "view report");
			Set<String> allWindowHandles1 = driver.getWindowHandles();
			for (String handle1 : allWindowHandles1) {
				if (!(handle1.equalsIgnoreCase(Parent))) {
					driver.switchTo().window(handle1);
					size=driver.findElements(By.xpath("//td[contains(.,'COMPLETE')]")).size();
					if(size==4) {
						reportLog(Status.PASS, "Report Status is 'COMPLETE' for the Record", true);
					}else {
						reportLog(Status.FAIL, "Report Status is not 'COMPLETE' for all the Record", true);
					}
					driver.close();
				}
			}
			driver.switchTo().window(Parent);
			
			if(verifyElementPresence(OrderStatusDD)) {
				selectDropDown(OrderStatusDD, "Not Acknowledged", "Not Acknowledged");
			}
			
			if(verifyElementPresence(searchBTN)) {
				clickElement(searchBTN, "search");
			}
			
			size=driver.findElements(By.xpath("//a[.='view report']")).size();
			verifyTextPresence(size+" prescreening businesses found. Displaying all the prescreening businesses.");
			
			clickElement(By.xpath("//a[.='view report']"), "view report");
			Set<String> allWindowHandles2 = driver.getWindowHandles();
			for (String handle2 : allWindowHandles2) {
				if (!(handle2.equalsIgnoreCase(Parent))) {
					driver.switchTo().window(handle2);
					size=driver.findElements(By.xpath("//td[contains(.,'COMPLETE')]")).size();
					if(size==4) {
						reportLog(Status.PASS, "Report Status is 'COMPLETE' for the Record", true);
					}else {
						reportLog(Status.FAIL, "Report Status is not 'COMPLETE' for all the Record", true);
					}
					driver.close();
				}
			}		
			driver.switchTo().window(Parent);
		}

public void businessProcessLoad() {
	
	ReadFile rf=new ReadFile();
	
	if(verifyElementPresence(XLStemplateLink)) {
		clickElement(XLStemplateLink, "XLS Template");
		wait(10);
	String file="business_prescreen_template_3.xls";
	String path="C:\\Users\\shekarcg\\Downloads\\"+file;
	String content=rf.read(path);
	if(!(content==null || content.equalsIgnoreCase(""))) {
		reportLog(Status.PASS, "file "+file+" is downloaded and can be opened", false);
		DeleteFile.delete(path);
	}else {
		reportLog(Status.FAIL, "file "+file+" is not downloaded or can't be opened", false);
	}
	}
	
	if(verifyElementPresence(CSVtemplateLink)) {
		clickElement(CSVtemplateLink, "XLS Template");
		wait(10);
	String file="business_load_template.csv";
	String path="C:\\Users\\shekarcg\\Downloads\\"+file;
	String content=rf.read(path);
	if(!(content==null || content.equalsIgnoreCase(""))) {
		reportLog(Status.PASS, "file "+file+" is downloaded and can be opened", false);
		DeleteFile.delete(path);
	}else {
		reportLog(Status.FAIL, "file "+file+" is not downloaded or can't be opened", false);
	}
	}
	
}

public void peopleRoasterBatch() {
	
	ReadFile rf=new ReadFile();
	
	if(verifyElementPresence(XLStemplateLink)) {
		clickElement(XLStemplateLink, "XLS Template");
		wait(10);
	String file="people_load_template_3.xls";
	String path="C:\\Users\\shekarcg\\Downloads\\"+file;
	String content=rf.read(path);
	if(!(content==null || content.equalsIgnoreCase(""))) {
		reportLog(Status.PASS, "file "+file+" is downloaded and can be opened", false);
		DeleteFile.delete(path);
	}else {
		reportLog(Status.FAIL, "file "+file+" is not downloaded or can't be opened", false);
	}
	}
	
	if(verifyElementPresence(CSVtemplateLink)) {
		clickElement(CSVtemplateLink, "XLS Template");
		wait(10);
	String file="people_load_template.csv";
	String path="C:\\Users\\shekarcg\\Downloads\\"+file;
	String content=rf.read(path);
	if(!(content==null || content.equalsIgnoreCase(""))) {
		reportLog(Status.PASS, "file "+file+" is downloaded and can be opened", false);
		DeleteFile.delete(path);
	}else {
		reportLog(Status.FAIL, "file "+file+" is not downloaded or can't be opened", false);
	}
	}
	
	if(verifyElementPresence(BatchXLStemplateLink)) {
		clickElement(BatchXLStemplateLink, "XLS Template");
		wait(10);
	String file="people_load_template_3.xls";
	String path="C:\\Users\\shekarcg\\Downloads\\"+file;
	String content=rf.read(path);
	if(!(content==null || content.equalsIgnoreCase(""))) {
		reportLog(Status.PASS, "file "+file+" is downloaded and can be opened", false);
		DeleteFile.delete(path);
	}else {
		reportLog(Status.FAIL, "file "+file+" is not downloaded or can't be opened", false);
	}
	}
}
}
