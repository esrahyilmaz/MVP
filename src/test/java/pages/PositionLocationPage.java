package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import seleniumhelper.BaseClass;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class PositionLocationPage extends BaseClass{
	
	public void verifyPositionLocation(String Country,String City,String State) {
		
		String ActualCity=driver.findElement(By.xpath("(//b[.='Position/Hire Location']/../../..//td)[41]")).getText();
		String ActualState=driver.findElement(By.xpath("(//b[.='Position/Hire Location']/../../..//td)[43]")).getText();
		String ActualCountry=driver.findElement(By.xpath("(//b[.='Position/Hire Location']/../../..//td)[45]")).getText();
		
		if(ActualCity.equalsIgnoreCase(City)) {
			reportLog(Status.PASS, "Position Location City Actual-->["+ActualCity+"] Expected-->["+City+"]", true);
		}else {
			reportLog(Status.FAIL, "Position Location City Actual-->["+ActualCity+"] Expected-->["+City+"]", true);
		}
		
		if(ActualState.equalsIgnoreCase(State)) {
			reportLog(Status.PASS, "Position Location State Actual-->["+ActualState+"] Expected-->["+State+"]", true);
		}else {
			reportLog(Status.FAIL, "Position Location State Actual-->["+ActualState+"] Expected-->["+State+"]", true);
		}

		if(ActualCountry.equalsIgnoreCase(Country)) {
			reportLog(Status.PASS, "Position Location Country Actual-->["+ActualCountry+"] Expected-->["+Country+"]", true);
		}else {
			reportLog(Status.FAIL, "Position Location Country Actual-->["+ActualCountry+"] Expected-->["+Country+"]", true);
		}
	}

	public void getValuePositionLocation(String xmlFilePath,String ExpectedCountry,String ExpectedState,String ExpectedCity) throws XPathExpressionException {
        try {
        	 
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
 
            Document document = documentBuilder.parse(xmlFilePath);
 
            // Get tag value
            
            XPath xPath = XPathFactory.newInstance().newXPath();
			Node Country = (Node) xPath.compile("//PositionLocations//CountryCode").evaluate(document, XPathConstants.NODE);
			String ActualCountry=Country.getTextContent();
			if(ActualCountry==null||ActualCountry.equalsIgnoreCase("")) {
				ActualCountry="null";
			}
			if(ActualCountry.equalsIgnoreCase(ExpectedCountry)) {
				reportLog(Status.PASS, "Expected Country-->["+ExpectedCountry+"] Actual Country-->["+ActualCountry+"]", false);
			}else {
				reportLog(Status.FAIL, "Expected Country-->["+ExpectedCountry+"] Actual Country-->["+ActualCountry+"]", false);
			}
			
			Node State = (Node) xPath.compile("//PositionLocations//Region").evaluate(document, XPathConstants.NODE);
			String ActualState=State.getTextContent();
			if(ActualState==null||ActualState.equalsIgnoreCase("")) {
				ActualState="null";
			}
			if(ActualState.equalsIgnoreCase(ExpectedState)) {
				reportLog(Status.PASS, "Expected State-->["+ExpectedState+"] Actual State-->["+ActualState+"]", false);
			}else {
				reportLog(Status.FAIL, "Expected State-->["+ExpectedState+"] Actual State-->["+ActualState+"]", false);
			}
			
			Node City = (Node) xPath.compile("//PositionLocations//Municipality").evaluate(document, XPathConstants.NODE);
			String ActualCity=City.getTextContent();
			if(ActualCity==null||ActualCity.equalsIgnoreCase("")) {
				ActualCity="null";
			}
			if(ActualCity.equalsIgnoreCase(ExpectedCity)) {
				reportLog(Status.PASS, "Expected City-->["+ExpectedCity+"] Actual City-->["+ActualCity+"]", false);
			}else {
				reportLog(Status.FAIL, "Expected City-->["+ExpectedCity+"] Actual City-->["+ActualCity+"]", false);
			}
               
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }  catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
	}
}
