package Utility;

import com.aventstack.extentreports.Status;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import seleniumhelper.BaseClass;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class VerificationCreditCard extends BaseClass {

	public static String ModifiedTXTinput;
	public static String ModifiedTXT;

	public static String creditCardInput(String text) {
		ModifiedTXTinput = text.replaceAll("\"merchid\":", "<Datainput merchid=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"account\":", " account=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"expiry\":", " expiry=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"amount\":", " amount=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"currency\":", " currency=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"name\":", " name=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"capture\":", " capture=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"orderId\":", " orderId=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"ecomind\":", " ecomind=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"accttype\":", " accttype=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"userFields\":", " userFields=");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll("\"comment1\":\"CS - Background check package - ", "\"");
		ModifiedTXTinput = ModifiedTXTinput.replaceAll(",\"comment2\":", " comment2=");
		ModifiedTXTinput = ModifiedTXTinput.replace("{", "");
		ModifiedTXTinput = ModifiedTXTinput.replace("}", "");
		ModifiedTXTinput = ModifiedTXTinput.replace("comment2=\"CS - Account - ", "Account=\"");
		ModifiedTXTinput = ModifiedTXTinput.replace(". Tax: ", " \" Tax=\"");
		ModifiedTXTinput = ModifiedTXTinput.replace(". Cost: ", " \" Cost=\"");
		ModifiedTXTinput = ModifiedTXTinput + "></Datainput>";
		return ModifiedTXTinput;

	}

	public static String creditCardOutput(String text) {
		ModifiedTXT = text.replaceAll("\"account\":", "<Dataoutput account=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"batchid\":", " batchid=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"entrymode\":", " entrymode=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"ECommerce\":", " ECommerce=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"expiry\":", " expiry=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"retref\":", " retref=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"commcard\":", " commcard=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"respproc\":", " respproc=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"resptext\":", " resptext=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"token\":", " token=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"bintype\":", " bintype=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"cvvresp\":", " cvvresp=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"amount\":", " amount=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"merchid\":", " merchid=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"authcode\":", " authcode=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"respcode\":", " respcode=");
		ModifiedTXT = ModifiedTXT.replaceAll(",\"respstat\":", " respstat=");
		ModifiedTXT = ModifiedTXT.replace("{", "");
		ModifiedTXT = ModifiedTXT.replace("}", "");
		ModifiedTXT = ModifiedTXT + "></Dataoutput>";
		return ModifiedTXT;

	}

	public void getValueInput(String xmlFilePath) {
        try {
        	 
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
 
            Document document = documentBuilder.parse(xmlFilePath);
           
            // Get tag name
            Node tag = document.getElementsByTagName("Datainput").item(0);
 
            NamedNodeMap attribute = tag.getAttributes();
            Node merchid = attribute.getNamedItem("merchid");
            if(!(merchid.toString().equalsIgnoreCase("merchid=\"\""))) {
            	reportLog(Status.PASS, merchid.toString(), false);
            }else {
            	reportLog(Status.FAIL, merchid.toString(), false);	
            }
            
            Node account = attribute.getNamedItem("account");
            if(!(account.toString().equalsIgnoreCase("account=\"\""))) {
            	reportLog(Status.PASS, account.toString(), false);
            }else {
            	reportLog(Status.FAIL, account.toString(), false);	
            }
            
            
            Node expiry = attribute.getNamedItem("expiry");
            if(!(expiry.toString().equalsIgnoreCase("expiry=\"\""))) {
            	reportLog(Status.PASS, expiry.toString(), false);
            }else {
            	reportLog(Status.FAIL, expiry.toString(), false);	
            }
            
            
            Node amount = attribute.getNamedItem("amount");
            if(!(amount.toString().equalsIgnoreCase("amount=\"\""))&&amount.toString().contains(TotalAmount)) {
            	reportLog(Status.PASS, amount.toString(), false);
            }else {
            	reportLog(Status.FAIL, amount.toString(), false);	
            }
            
            
            Node currency = attribute.getNamedItem("currency");
            if(!(currency.toString().equalsIgnoreCase("currency=\"\""))) {
            	reportLog(Status.PASS, currency.toString(), false);
            }else {
            	reportLog(Status.FAIL, currency.toString(), false);	
            }
            
            
            Node name = attribute.getNamedItem("name");
            if(!(name.toString().equalsIgnoreCase("name=\"\""))) {
            	reportLog(Status.PASS, name.toString(), false);
            }else {
            	reportLog(Status.FAIL, name.toString(), false);	
            }
            
            
            Node capture = attribute.getNamedItem("capture");
            if(!(capture.toString().equalsIgnoreCase("capture=\"\""))) {
            	reportLog(Status.PASS, capture.toString(), false);
            }else {
            	reportLog(Status.FAIL, capture.toString(), false);	
            }
            if(scenarioName.contains("Batch")) {
    			int order=Integer.parseInt(OrderID);
    			order=order+4;
    			OrderID=""+order;
    		}
            
            Node orderId = attribute.getNamedItem("orderId");
            if(!(orderId.toString().equalsIgnoreCase("orderId=\"\""))&&orderId.toString().contains(OrderID)) {
            	reportLog(Status.PASS, orderId.toString(), false);
            }else {
            	reportLog(Status.FAIL, orderId.toString(), false);	
            }
            
            
            Node ecomind = attribute.getNamedItem("ecomind");
            if(!(ecomind.toString().equalsIgnoreCase("ecomind=\"\""))) {
            	reportLog(Status.PASS, ecomind.toString(), false);
            }else {
            	reportLog(Status.FAIL, ecomind.toString(), false);	
            }
            
            
            Node accttype = attribute.getNamedItem("accttype");
            if(!(accttype.toString().equalsIgnoreCase("accttype=\"\""))) {
            	reportLog(Status.PASS, accttype.toString(), false);
            }else {
            	reportLog(Status.FAIL, accttype.toString(), false);	
            }
            
            
            Node userFields = attribute.getNamedItem("userFields");
            if(!(userFields.toString().equalsIgnoreCase("userFields=\"\""))&&userFields.toString().contains(existingFirstName +" "+existingLastName)) {
            	reportLog(Status.PASS, userFields.toString(), false);
            }else {
            	reportLog(Status.FAIL, userFields.toString(), false);	
            }
            
            
            Node Account = attribute.getNamedItem("Account");
            if(!(Account.toString().equalsIgnoreCase("Account=\"\""))) {
            	reportLog(Status.PASS, Account.toString(), false);
            }else {
            	reportLog(Status.FAIL, Account.toString(), false);	
            }
            
            
            Node Tax = attribute.getNamedItem("Tax");
            if(!(Tax.toString().equalsIgnoreCase("Tax=\"\""))&&Tax.toString().contains(TaxAmount)||Tax.toString().contains(TaxAmount.substring(0, 3))) {
            	reportLog(Status.PASS, Tax.toString(), false);
            }else {
            	reportLog(Status.FAIL, Tax.toString(), false);	
            }
            
            if(TotalAmount.length()==4) {
            	TotalAmount=TotalAmount.substring(0, 3);
            }else if(TotalAmount.length()==5) {
            	TotalAmount=TotalAmount.substring(0, 4);
            }
            
            if(scenarioName.contains("Batch")) {
    			double amount1=Double.parseDouble(TotalAmount);
    			amount1=amount1/5;
    			TotalAmount=""+amount1;
    		}
            
            Node Cost = attribute.getNamedItem("Cost");
            if(!(Cost.toString().equalsIgnoreCase("Cost=\"\""))&&Cost.toString().contains(TotalAmount)) {
            	reportLog(Status.PASS, Cost.toString(), false);
            }else {
            	reportLog(Status.FAIL, Cost.toString(), false);	
            }
            
            
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }  catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
	}
	
	public void getValueOutput(String xmlFilePath) {
        try {
        	 
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
 
            Document document = documentBuilder.parse(xmlFilePath);
 
            // Get tag name
            Node tag = document.getElementsByTagName("Dataoutput").item(0);
 
            NamedNodeMap attribute = tag.getAttributes();
            Node account = attribute.getNamedItem("account");
            if(!(account.toString().equalsIgnoreCase("account=\"\""))) {
            	reportLog(Status.PASS, account.toString(), false);
            }else {
            	reportLog(Status.FAIL, account.toString(), false);	
            }
            if(!(scenarioName.contains("GlobalOrder"))) {
            	Node batchid = attribute.getNamedItem("batchid");
                if(!(batchid.toString().equalsIgnoreCase("batchid=\"\""))) {
                	reportLog(Status.PASS, batchid.toString(), false);
                }else {
                	reportLog(Status.FAIL, batchid.toString(), false);	
                }
            }
            
            
            
            Node entrymode = attribute.getNamedItem("entrymode");
            if(!(entrymode.toString().equalsIgnoreCase("entrymode=\"\""))) {
            	reportLog(Status.PASS, entrymode.toString(), false);
            }else {
            	reportLog(Status.FAIL, entrymode.toString(), false);	
            }
            
            
            Node expiry = attribute.getNamedItem("expiry");
            if(!(expiry.toString().equalsIgnoreCase("expiry=\"\""))) {
            	reportLog(Status.PASS, expiry.toString(), false);
            }else {
            	reportLog(Status.FAIL, expiry.toString(), false);	
            }
            
            
            Node retref = attribute.getNamedItem("retref");
            if(!(retref.toString().equalsIgnoreCase("retref=\"\""))) {
            	reportLog(Status.PASS, retref.toString(), false);
            }else {
            	reportLog(Status.FAIL, retref.toString(), false);	
            }
            
            
            Node commcard = attribute.getNamedItem("commcard");
            if(!(commcard.toString().equalsIgnoreCase("commcard=\"\""))) {
            	reportLog(Status.PASS, commcard.toString(), false);
            }else {
            	reportLog(Status.FAIL, commcard.toString(), false);	
            }
            
            
            Node respproc = attribute.getNamedItem("respproc");
            if(!(respproc.toString().equalsIgnoreCase("respproc=\"\""))) {
            	reportLog(Status.PASS, respproc.toString(), false);
            }else {
            	reportLog(Status.FAIL, respproc.toString(), false);	
            }
            
            
            Node resptext = attribute.getNamedItem("resptext");
            if(!(resptext.toString().equalsIgnoreCase("resptext=\"\""))) {
            	reportLog(Status.PASS, resptext.toString(), false);
            }else {
            	reportLog(Status.FAIL, resptext.toString(), false);	
            }
            
            
            Node authcode = attribute.getNamedItem("authcode");
            if(!(authcode.toString().equalsIgnoreCase("authcode=\"\""))) {
            	reportLog(Status.PASS, authcode.toString(), false);
            }else {
            	reportLog(Status.FAIL, authcode.toString(), false);	
            }
            
            
            Node respcode = attribute.getNamedItem("respcode");
            if(!(respcode.toString().equalsIgnoreCase("respcode=\"\""))) {
            	reportLog(Status.PASS, respcode.toString(), false);
            }else {
            	reportLog(Status.FAIL, respcode.toString(), false);	
            }
            
            
            Node token = attribute.getNamedItem("token");
            if(!(token.toString().equalsIgnoreCase("token=\"\""))) {
            	reportLog(Status.PASS, token.toString(), false);
            }else {
            	reportLog(Status.FAIL, token.toString(), false);	
            }
            
            
            Node cvvresp = attribute.getNamedItem("cvvresp");
            if(!(cvvresp.toString().equalsIgnoreCase("cvvresp=\"\""))) {
            	reportLog(Status.PASS, cvvresp.toString(), false);
            }else {
            	reportLog(Status.FAIL, cvvresp.toString(), false);	
            }
            
            
            Node respstat = attribute.getNamedItem("respstat");
            if(!(respstat.toString().equalsIgnoreCase("respstat=\"\""))) {
            	reportLog(Status.PASS, respstat.toString(), false);
            }else {
            	reportLog(Status.FAIL, respstat.toString(), false);	
            }
            
            
            Node amount = attribute.getNamedItem("amount");
            if(!(amount.toString().equalsIgnoreCase("amount=\"\""))&&amount.toString().contains(TotalAmount)) {
            	reportLog(Status.PASS, amount.toString(), false);
            }else {
            	reportLog(Status.FAIL, amount.toString(), false);	
            }
            
            Node merchid = attribute.getNamedItem("merchid");
            if(!(merchid.toString().equalsIgnoreCase("merchid=\"\""))) {
            	reportLog(Status.PASS, merchid.toString(), false);
            }else {
            	reportLog(Status.FAIL, merchid.toString(), false);	
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
