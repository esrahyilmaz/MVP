package pages;

import Utility.CurrentDateTime;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.util.Set;

public class VerifyReceipt extends BaseClass {
	private static By viewReceiptBtn = By.xpath("(//span[.='Badge History']/..//div[.='Receipt']/../../../..//input[@value='View Receipt'])[1]");
	private static By viewOrderReceiptBtn=By.xpath("//span[.='Order History']/../..//input[@value='View Receipt']");
	private static By viewReceiptBtnDigitalPhysical= By.xpath("(//span[.='Badge History']/..//div[.='Receipt']/../../../..//input[@value='View Receipt'])[2]");
	private static String ActualCompanyName;
	private static String ActualAddress;
	private static String ActualCandidateName;
	private static String ActualOrderID;
	private static String ActualDateOrdered;
	private static String ActualBasePackageRate;
	private static String ActualBasePackageTax;
	private static String ActualSubTotal;
	private static String ActualTotal;
	private static String ActualAmountCharged;
	private static String ActualDate;
	private static String ActualStatus;

	public void receipt(String ExpectedCompanyName, String ExpectedAddress, String ExpectedBasePackageRate,
			String ExpectedBasePackageTax, String ExpectedSubTotal, String ExpectedTotal, String ExpectedAmountCharged,
			String ExpectedStatus) throws Exception {
		
		
		String Date = CurrentDateTime.SystemDateMMDD();
		String parent = driver.getWindowHandle();
		if(ExpectedCompanyName.equalsIgnoreCase("UniGroup, Inc.")) {
			clickElement(viewOrderReceiptBtn, "view receipt");
		}else {
		clickElement(viewReceiptBtn, "View Receipt");
		}
		wait(30);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!(handle.equalsIgnoreCase(parent))) {
				driver.switchTo().window(handle);
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Company')]/..//span)[last()]"))) {
					ActualCompanyName = driver.findElement(By.xpath("(//span[contains(.,'Company')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Address')]/..//span)[last()]"))) {
					ActualAddress = driver.findElement(By.xpath("(//span[contains(.,'Address')]/..//span)[last()]"))
							.getText();	
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Candidate')]/..//span)[last()]"))) {
					ActualCandidateName = driver.findElement(By.xpath("(//span[contains(.,'Candidate')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'ID')]/..//span)[last()]"))) {
					ActualOrderID = driver.findElement(By.xpath("(//span[contains(.,'ID')]/..//span)[last()]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Ordered')]/..//span)[last()]"))) {
					ActualDateOrdered = driver.findElement(By.xpath("(//span[contains(.,'Ordered')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Package Rate:')])[last()]/..//div)[last()]"))) {
					ActualBasePackageRate = driver
							.findElement(By.xpath("((//div[contains(.,'Package Rate:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Package Tax:')])[last()]/..//div)[last()]"))) {
					ActualBasePackageTax = driver
							.findElement(By.xpath("((//div[contains(.,'Package Tax:')])[last()]/..//div)[last()]"))
							.getText();
				}
//				if(AdditionalBilling.equalsIgnoreCase("Y")&&!(scenarioName.contains("NONHD"))) {
					if(verifyElementPresence(By.xpath("((//div[contains(.,'Subtotal:')])[last()-2]/..//div)[last()]"))) {
						ActualSubTotal = driver
								.findElement(By.xpath("((//div[contains(.,'Subtotal:')])[last()-2]/..//div)[last()]")).getText();
					
				} 
					if(verifyElementPresence(By.xpath("((//div[contains(.,'Subtotal:')])[last()]/..//div)[last()]"))&&ActualSubTotal.equalsIgnoreCase("")) {
						ActualSubTotal = driver
								.findElement(By.xpath("((//div[contains(.,'Subtotal:')])[last()]/..//div)[last()]")).getText();
					}
			
				
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Total:')])[last()]/..//div)[last()]"))) {
					ActualTotal = driver.findElement(By.xpath("((//div[contains(.,'Total:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[1]"))) {
					ActualAmountCharged = driver.findElement(By.xpath("(//tr)[2]//td[1]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[2]"))) {
					ActualDate = driver.findElement(By.xpath("(//tr)[2]//td[2]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[2]"))) {
					ActualDate = driver.findElement(By.xpath("(//tr)[2]//td[2]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[3]"))) {
					ActualCard = driver.findElement(By.xpath("(//tr)[2]//td[3]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[4]"))) {
					ActualStatus = driver.findElement(By.xpath("(//tr)[2]//td[4]")).getText();
					driver.close();
				}
								
			}
			
			driver.switchTo().window(parent);
		}

		if (ActualCompanyName.contains(ExpectedCompanyName)) {
			reportLog(Status.PASS, "Actual Company Name :["+ActualCompanyName+"] == Expected Company Name :["+ExpectedCompanyName+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Company Name :["+ActualCompanyName+"] != Expected Company Name :["+ExpectedCompanyName+"]", false);
		}

		if (ActualAddress.contains(ExpectedAddress)) {
			reportLog(Status.PASS, "Actual Address :["+ActualAddress+"] == Expected Address :["+ExpectedAddress+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Address :["+ActualAddress+"] != Expected Address :["+ExpectedAddress+"]", false);
		}

		if (ActualCandidateName.contains(existingFirstName)) {
			reportLog(Status.PASS, "Actual First Name :["+ActualCandidateName+"] == Expected First Name :["+ existingFirstName +"]", false);
		} else {
			reportLog(Status.FAIL, "Actual First Name :["+ActualCandidateName+"] != Expected First Name :["+ existingFirstName +"]", false);
		}

		if (ActualCandidateName.contains(existingLastName)) {
			reportLog(Status.PASS, "Actual Last Name :["+ActualCandidateName+"] == Expected Last Name :["+existingLastName+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Last Name :["+ActualCandidateName+"] != Expected Last Name :["+existingLastName+"]", false);
		}

		if (ActualOrderID.contains(OrderID)) {
			reportLog(Status.PASS, "Actual OrderID :["+ActualOrderID+"] == Expected OrderID :["+OrderID+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual OrderID :["+ActualOrderID+"] != Expected OrderID :["+OrderID+"]", false);
		}

		if (ActualDateOrdered.contains(Date)) {
			reportLog(Status.PASS, "Actual Date Ordered :["+ActualDateOrdered+"] == Expected Date Ordered :["+Date+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Date Ordered :["+ActualDateOrdered+"] != Expected Date Ordered :["+Date+"]", false);
		}

		if (ActualBasePackageRate.contains(ExpectedBasePackageRate)) {
			reportLog(Status.PASS, "Actual Base Package Rate :["+ActualBasePackageRate+"] == Expected Base Package Rate :["+ExpectedBasePackageRate+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Base Package Rate :["+ActualBasePackageRate+"] != Expected Base Package Rate :["+ExpectedBasePackageRate+"]", false);
		}

		if (ActualBasePackageTax.contains(ExpectedBasePackageTax)) {
			reportLog(Status.PASS, "Actual Base Package Tax :["+ActualBasePackageTax+"] == Expected Base Package Tax :["+ExpectedBasePackageTax+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Base Package Tax :["+ActualBasePackageTax+"] != Expected Base Package Tax :["+ExpectedBasePackageTax+"]", false);
		}

		if (ActualSubTotal.contains(ExpectedSubTotal)) {
			reportLog(Status.PASS, "Actual Sub Total :["+ActualSubTotal+"] == Expected Sub Total :["+ExpectedSubTotal+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Sub Total :["+ActualSubTotal+"] != Expected Sub Total :["+ExpectedSubTotal+"]", false);
		}

		if (ActualTotal.contains(ExpectedTotal)) {
			reportLog(Status.PASS, "Actual Total :["+ActualTotal+"] == Expected Total :["+ExpectedTotal+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Total :["+ActualTotal+"] != Expected Total :["+ExpectedTotal+"]", false);
		}

		if (ActualAmountCharged.contains(ExpectedAmountCharged)) {
			reportLog(Status.PASS, "Actual Amount Charged :["+ActualAmountCharged+"] == Expected Amount Charged :["+ExpectedAmountCharged+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Amount Charged :["+ActualAmountCharged+"] != Expected Amount Charged :["+ExpectedAmountCharged+"]", false);
		}

		if (ActualDate.contains(Date)) {
			reportLog(Status.PASS, "Actual Date :["+ActualDate+"] == Expected Date :["+Date+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Date :["+ActualDate+"] != Expected Date :["+Date+"]", false);
		}

		if(ActualCard.contains("XXXX-XXXX-XXXX-1111")&&scenarioName.contains("-Credit Card")) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		}else if(ActualCard.contains("Invoice")&&scenarioName.contains("-Sponsor Invoice")) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[Invoice]", false);
		}else if (ActualCard.contains("XXXX-XXXX-XXXX-1111")||ActualCard.contains("Invoice")&&!(scenarioName.contains("-Credit Card")&&scenarioName.contains("-Credit Card"))) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		} else {
			reportLog(Status.FAIL, "Actual Card :["+ActualCard+"] != Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		}

		if (ActualStatus.contains(ExpectedStatus)) {
			reportLog(Status.PASS, "Actual Status :["+ActualStatus+"] == Expected Status :["+ExpectedStatus+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Status :["+ActualStatus+"] != Expected Status :["+ExpectedStatus+"]", false);
		}

	}
	
	public void receiptOH(String ExpectedCompanyName, String ExpectedAddress, String ExpectedBasePackageRate,
			String ExpectedBasePackageTax, String ExpectedSubTotal, String ExpectedTotal, String ExpectedAmountCharged,
			String ExpectedStatus) throws Exception {
		
		
		String Date = CurrentDateTime.SystemDateMMDD();
		String parent = driver.getWindowHandle();
		
			clickElement(viewOrderReceiptBtn, "view receipt");
		
		wait(30);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!(handle.equalsIgnoreCase(parent))) {
				driver.switchTo().window(handle);
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Company')]/..//span)[last()]"))) {
					ActualCompanyName = driver.findElement(By.xpath("(//span[contains(.,'Company')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Address')]/..//span)[last()]"))) {
					ActualAddress = driver.findElement(By.xpath("(//span[contains(.,'Address')]/..//span)[last()]"))
							.getText();	
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Candidate')]/..//span)[last()]"))) {
					ActualCandidateName = driver.findElement(By.xpath("(//span[contains(.,'Candidate')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'ID')]/..//span)[last()]"))) {
					ActualOrderID = driver.findElement(By.xpath("(//span[contains(.,'ID')]/..//span)[last()]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Ordered')]/..//span)[last()]"))) {
					ActualDateOrdered = driver.findElement(By.xpath("(//span[contains(.,'Ordered')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Package Rate:')])[last()]/..//div)[last()]"))) {
					ActualBasePackageRate = driver
							.findElement(By.xpath("((//div[contains(.,'Package Rate:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Package Tax:')])[last()]/..//div)[last()]"))) {
					ActualBasePackageTax = driver
							.findElement(By.xpath("((//div[contains(.,'Package Tax:')])[last()]/..//div)[last()]"))
							.getText();
				}
//				if(AdditionalBilling.equalsIgnoreCase("Y")&&!(scenarioName.contains("NONHD"))) {
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Subtotal:')])[last()-2]/..//div)[last()]"))) {
					ActualSubTotal = driver
							.findElement(By.xpath("((//div[contains(.,'Subtotal:')])[last()-2]/..//div)[last()]")).getText();
				
			} 
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Subtotal:')])[last()]/..//div)[last()]"))&&ActualSubTotal.equalsIgnoreCase("")) {
					ActualSubTotal = driver
							.findElement(By.xpath("((//div[contains(.,'Subtotal:')])[last()]/..//div)[last()]")).getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Total:')])[last()]/..//div)[last()]"))) {
					ActualTotal = driver.findElement(By.xpath("((//div[contains(.,'Total:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[1]"))) {
					ActualAmountCharged = driver.findElement(By.xpath("(//tr)[2]//td[1]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[2]"))) {
					ActualDate = driver.findElement(By.xpath("(//tr)[2]//td[2]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[2]"))) {
					ActualDate = driver.findElement(By.xpath("(//tr)[2]//td[2]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[3]"))) {
					ActualCard = driver.findElement(By.xpath("(//tr)[2]//td[3]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[4]"))) {
					ActualStatus = driver.findElement(By.xpath("(//tr)[2]//td[4]")).getText();
					driver.close();
				}
								
			}
			
			driver.switchTo().window(parent);
		}

		if (ActualCompanyName.contains(ExpectedCompanyName)) {
			reportLog(Status.PASS, "Actual Company Name :["+ActualCompanyName+"] == Expected Company Name :["+ExpectedCompanyName+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Company Name :["+ActualCompanyName+"] != Expected Company Name :["+ExpectedCompanyName+"]", false);
		}

		if (ActualAddress.contains(ExpectedAddress)) {
			reportLog(Status.PASS, "Actual Address :["+ActualAddress+"] == Expected Address :["+ExpectedAddress+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Address :["+ActualAddress+"] != Expected Address :["+ExpectedAddress+"]", false);
		}

		if (ActualCandidateName.contains(existingFirstName)) {
			reportLog(Status.PASS, "Actual First Name :["+ActualCandidateName+"] == Expected First Name :["+ existingFirstName +"]", false);
		} else {
			reportLog(Status.FAIL, "Actual First Name :["+ActualCandidateName+"] != Expected First Name :["+ existingFirstName +"]", false);
		}

		if (ActualCandidateName.contains(existingLastName)) {
			reportLog(Status.PASS, "Actual Last Name :["+ActualCandidateName+"] == Expected Last Name :["+existingLastName+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Last Name :["+ActualCandidateName+"] != Expected Last Name :["+existingLastName+"]", false);
		}

		if (ActualOrderID.contains(OrderID)) {
			reportLog(Status.PASS, "Actual OrderID :["+ActualOrderID+"] == Expected OrderID :["+OrderID+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual OrderID :["+ActualOrderID+"] != Expected OrderID :["+OrderID+"]", false);
		}

		if (ActualDateOrdered.contains(Date)) {
			reportLog(Status.PASS, "Actual Date Ordered :["+ActualDateOrdered+"] == Expected Date Ordered :["+Date+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Date Ordered :["+ActualDateOrdered+"] != Expected Date Ordered :["+Date+"]", false);
		}

		if (ActualBasePackageRate.contains(ExpectedBasePackageRate)) {
			reportLog(Status.PASS, "Actual Base Package Rate :["+ActualBasePackageRate+"] == Expected Base Package Rate :["+ExpectedBasePackageRate+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Base Package Rate :["+ActualBasePackageRate+"] != Expected Base Package Rate :["+ExpectedBasePackageRate+"]", false);
		}

		if (ActualBasePackageTax.contains(ExpectedBasePackageTax)) {
			reportLog(Status.PASS, "Actual Base Package Tax :["+ActualBasePackageTax+"] == Expected Base Package Tax :["+ExpectedBasePackageTax+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Base Package Tax :["+ActualBasePackageTax+"] != Expected Base Package Tax :["+ExpectedBasePackageTax+"]", false);
		}

		if (ActualSubTotal.contains(ExpectedSubTotal)) {
			reportLog(Status.PASS, "Actual Sub Total :["+ActualSubTotal+"] == Expected Sub Total :["+ExpectedSubTotal+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Sub Total :["+ActualSubTotal+"] != Expected Sub Total :["+ExpectedSubTotal+"]", false);
		}

		if (ActualTotal.contains(ExpectedTotal)) {
			reportLog(Status.PASS, "Actual Total :["+ActualTotal+"] == Expected Total :["+ExpectedTotal+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Total :["+ActualTotal+"] != Expected Total :["+ExpectedTotal+"]", false);
		}

		if (ActualAmountCharged.contains(ExpectedAmountCharged)) {
			reportLog(Status.PASS, "Actual Amount Charged :["+ActualAmountCharged+"] == Expected Amount Charged :["+ExpectedAmountCharged+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Amount Charged :["+ActualAmountCharged+"] != Expected Amount Charged :["+ExpectedAmountCharged+"]", false);
		}

		if (ActualDate.contains(Date)) {
			reportLog(Status.PASS, "Actual Date :["+ActualDate+"] == Expected Date :["+Date+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Date :["+ActualDate+"] != Expected Date :["+Date+"]", false);
		}
		
		if(ActualCard.contains("XXXX-XXXX-XXXX-1111")&&scenarioName.contains("-Credit Card")) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		}else if(ActualCard.contains("Invoice")&&scenarioName.contains("-Sponsor Invoice")) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[Invoice]", false);
		}else if (ActualCard.contains("XXXX-XXXX-XXXX-1111")||ActualCard.contains("Invoice")&&!(scenarioName.contains("-Credit Card")&&scenarioName.contains("-Credit Card"))) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		}else if(ActualCard.contains("")&&scenarioName.contains("PABG")&&!(scenarioName.contains("-Credit Card"))) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[Blank]", false);
		}else {
			reportLog(Status.FAIL, "Actual Card :["+ActualCard+"] != Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		}

		if (ActualStatus.contains(ExpectedStatus)) {
			reportLog(Status.PASS, "Actual Status :["+ActualStatus+"] == Expected Status :["+ExpectedStatus+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Status :["+ActualStatus+"] != Expected Status :["+ExpectedStatus+"]", false);
		}

	}
	
	public void receiptDigital(String ExpectedCompanyName, String ExpectedAddress, String ExpectedBasePackageRate,
			String ExpectedBasePackageTax, String ExpectedSubTotal, String ExpectedTotal, String ExpectedAmountCharged,
			String ExpectedStatus) throws Exception {
		
		
		String Date = CurrentDateTime.SystemDateMMDD();
		String parent = driver.getWindowHandle();
		if(ExpectedCompanyName.equalsIgnoreCase("UniGroup, Inc.")) {
			clickElement(viewOrderReceiptBtn, "view receipt");
		}else {
		clickElement(viewReceiptBtnDigitalPhysical, "View Receipt");
		}
		wait(30);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!(handle.equalsIgnoreCase(parent))) {
				driver.switchTo().window(handle);
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Company')]/..//span)[last()]"))) {
					ActualCompanyName = driver.findElement(By.xpath("(//span[contains(.,'Company')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Address')]/..//span)[last()]"))) {
					ActualAddress = driver.findElement(By.xpath("(//span[contains(.,'Address')]/..//span)[last()]"))
							.getText();	
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Candidate')]/..//span)[last()]"))) {
					ActualCandidateName = driver.findElement(By.xpath("(//span[contains(.,'Candidate')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'ID')]/..//span)[last()]"))) {
					ActualOrderID = driver.findElement(By.xpath("(//span[contains(.,'ID')]/..//span)[last()]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Ordered')]/..//span)[last()]"))) {
					ActualDateOrdered = driver.findElement(By.xpath("(//span[contains(.,'Ordered')]/..//span)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Package Rate:')])[last()]/..//div)[last()]"))) {
					ActualBasePackageRate = driver
							.findElement(By.xpath("((//div[contains(.,'Package Rate:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Package Tax:')])[last()]/..//div)[last()]"))) {
					ActualBasePackageTax = driver
							.findElement(By.xpath("((//div[contains(.,'Package Tax:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(AdditionalBilling.equalsIgnoreCase("Y")&&!(scenarioName.contains("NONHD"))) {
					if(verifyElementPresence(By.xpath("((//div[contains(.,'Subtotal:')])[last()-2]/..//div)[last()]"))) {
						ActualSubTotal = driver
								.findElement(By.xpath("((//div[contains(.,'Subtotal:')])[last()-2]/..//div)[last()]")).getText();
					}
				}else {
					if(verifyElementPresence(By.xpath("((//div[contains(.,'Subtotal:')])[last()]/..//div)[last()]"))) {
						ActualSubTotal = driver
								.findElement(By.xpath("((//div[contains(.,'Subtotal:')])[last()]/..//div)[last()]")).getText();
					}
				}
				
				if(verifyElementPresence(By.xpath("((//div[contains(.,'Total:')])[last()]/..//div)[last()]"))) {
					ActualTotal = driver.findElement(By.xpath("((//div[contains(.,'Total:')])[last()]/..//div)[last()]"))
							.getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[1]"))) {
					ActualAmountCharged = driver.findElement(By.xpath("(//tr)[2]//td[1]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[2]"))) {
					ActualDate = driver.findElement(By.xpath("(//tr)[2]//td[2]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[2]"))) {
					ActualDate = driver.findElement(By.xpath("(//tr)[2]//td[2]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[3]"))) {
					ActualCard = driver.findElement(By.xpath("(//tr)[2]//td[3]")).getText();
				}
				if(verifyElementPresence(By.xpath("(//tr)[2]//td[4]"))) {
					ActualStatus = driver.findElement(By.xpath("(//tr)[2]//td[4]")).getText();
					driver.close();
				}
								
			}
			
			driver.switchTo().window(parent);
		}

		if (ActualCompanyName.contains(ExpectedCompanyName)) {
			reportLog(Status.PASS, "Actual Company Name :["+ActualCompanyName+"] == Expected Company Name :["+ExpectedCompanyName+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Company Name :["+ActualCompanyName+"] != Expected Company Name :["+ExpectedCompanyName+"]", false);
		}

		if (ActualAddress.contains(ExpectedAddress)) {
			reportLog(Status.PASS, "Actual Address :["+ActualAddress+"] == Expected Address :["+ExpectedAddress+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Address :["+ActualAddress+"] != Expected Address :["+ExpectedAddress+"]", false);
		}

		if (ActualCandidateName.contains(existingFirstName)) {
			reportLog(Status.PASS, "Actual First Name :["+ActualCandidateName+"] == Expected First Name :["+ existingFirstName +"]", false);
		} else {
			reportLog(Status.FAIL, "Actual First Name :["+ActualCandidateName+"] != Expected First Name :["+ existingFirstName +"]", false);
		}

		if (ActualCandidateName.contains(existingLastName)) {
			reportLog(Status.PASS, "Actual Last Name :["+ActualCandidateName+"] == Expected Last Name :["+existingLastName+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Last Name :["+ActualCandidateName+"] != Expected Last Name :["+existingLastName+"]", false);
		}

		if (ActualOrderID.contains(OrderID)) {
			reportLog(Status.PASS, "Actual OrderID :["+ActualOrderID+"] == Expected OrderID :["+OrderID+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual OrderID :["+ActualOrderID+"] != Expected OrderID :["+OrderID+"]", false);
		}

		if (ActualDateOrdered.contains(Date)) {
			reportLog(Status.PASS, "Actual Date Ordered :["+ActualDateOrdered+"] == Expected Date Ordered :["+Date+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Date Ordered :["+ActualDateOrdered+"] != Expected Date Ordered :["+Date+"]", false);
		}

		if (ActualBasePackageRate.contains(ExpectedBasePackageRate)) {
			reportLog(Status.PASS, "Actual Base Package Rate :["+ActualBasePackageRate+"] == Expected Base Package Rate :["+ExpectedBasePackageRate+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Base Package Rate :["+ActualBasePackageRate+"] != Expected Base Package Rate :["+ExpectedBasePackageRate+"]", false);
		}

		if (ActualBasePackageTax.contains(ExpectedBasePackageTax)) {
			reportLog(Status.PASS, "Actual Base Package Tax :["+ActualBasePackageTax+"] == Expected Base Package Tax :["+ExpectedBasePackageTax+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Base Package Tax :["+ActualBasePackageTax+"] != Expected Base Package Tax :["+ExpectedBasePackageTax+"]", false);
		}

		if (ActualSubTotal.contains(ExpectedSubTotal)) {
			reportLog(Status.PASS, "Actual Sub Total :["+ActualSubTotal+"] == Expected Sub Total :["+ExpectedSubTotal+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Sub Total :["+ActualSubTotal+"] != Expected Sub Total :["+ExpectedSubTotal+"]", false);
		}

		if (ActualTotal.contains(ExpectedTotal)) {
			reportLog(Status.PASS, "Actual Total :["+ActualTotal+"] == Expected Total :["+ExpectedTotal+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Total :["+ActualTotal+"] != Expected Total :["+ExpectedTotal+"]", false);
		}

		if (ActualAmountCharged.contains(ExpectedAmountCharged)) {
			reportLog(Status.PASS, "Actual Amount Charged :["+ActualAmountCharged+"] == Expected Amount Charged :["+ExpectedAmountCharged+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Amount Charged :["+ActualAmountCharged+"] != Expected Amount Charged :["+ExpectedAmountCharged+"]", false);
		}

		if (ActualDate.contains(Date)) {
			reportLog(Status.PASS, "Actual Date :["+ActualDate+"] == Expected Date :["+Date+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Date :["+ActualDate+"] != Expected Date :["+Date+"]", false);
		}

		if (ActualCard.contains("XXXX-XXXX-XXXX-1111")||ActualCard.contains("Invoice")) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		} else {
			reportLog(Status.FAIL, "Actual Card :["+ActualCard+"] != Expected Card :[XXXX-XXXX-XXXX-1111]", false);
		}

		if (ActualStatus.contains(ExpectedStatus)) {
			reportLog(Status.PASS, "Actual Status :["+ActualStatus+"] == Expected Status :["+ExpectedStatus+"]", false);
		} else {
			reportLog(Status.FAIL, "Actual Status :["+ActualStatus+"] != Expected Status :["+ExpectedStatus+"]", false);
		}

	}
	
	public void receiptTransactionID() throws Exception {
		
		String parent = driver.getWindowHandle();
		
			clickElement(viewOrderReceiptBtn, "view receipt");
		
		wait(30);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!(handle.equalsIgnoreCase(parent))) {
				driver.switchTo().window(handle);
				
				if(verifyElementPresence(By.xpath("(//span[contains(.,'Transaction')]/..//span)[last()]"))) {
					TransactionID = driver.findElement(By.xpath("(//span[contains(.,'Transaction')]/..//span)[last()]")).getText();
					driver.close();
				}else if(verifyElementPresence(By.xpath("(//tr)[2]//td[3]"))) {
					ActualCard = driver.findElement(By.xpath("(//tr)[2]//td[3]")).getText();
					driver.close();
				}				
			}			
			driver.switchTo().window(parent);
		}
		
		if(ActualCard==null) {
			ActualCard="";
		}
		
		if (ActualCard.contains("Invoice")) {
			reportLog(Status.PASS, "Actual Card :["+ActualCard+"] == Expected Card :[Invoice]", false);
		} else if (!(TransactionID.equalsIgnoreCase(""))) {
			reportLog(Status.PASS, "Transaction ID :["+TransactionID+"]", false);
		} else {
			reportLog(Status.FAIL, "Transaction ID is Empty", false);
		}		
		

	}
}
