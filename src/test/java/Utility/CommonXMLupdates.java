package Utility;

import com.aventstack.extentreports.Status;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import seleniumhelper.BaseClass;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class CommonXMLupdates extends BaseClass {
	public void commonUpdate(String xmlPath, String SalesForceID, String PayTO, String Name, String DBAname)
			throws Exception {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (SalesForceID == null) {
			SalesForceID = "";
		}
		if (PayTO == null) {
			PayTO = "";
		}
		if (Name == null) {
			Name = "";
		}
		if (DBAname == null) {
			DBAname = "";
		}

		if (!(SalesForceID.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node SalesForceid = (Node) xPath.compile("//thdSalesForceId").evaluate(doc, XPathConstants.NODE);
			SalesForceid.setTextContent(SalesForceID);
			reportLog(Status.PASS, "SalesForceID is Updated : " + SalesForceID, false);
		}

		if (!(PayTO.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node Payto = (Node) xPath.compile("//payto").evaluate(doc, XPathConstants.NODE);
			Payto.setTextContent(PayTO);
			reportLog(Status.PASS, "PayTO is Updated : " + PayTO, false);
		}

		if (!(Name.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node name = (Node) xPath.compile("//name").evaluate(doc, XPathConstants.NODE);
			name.setTextContent(Name);
			reportLog(Status.PASS, "Name is Updated : " + Name, false);
		}
		if (!(DBAname.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node dbaname = (Node) xPath.compile("//dbaName").evaluate(doc, XPathConstants.NODE);
			dbaname.setTextContent(DBAname);
			reportLog(Status.PASS, "DBAname is Updated : " + DBAname, false);
		}

		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);
	}

	public void pushBackUpdate(String xmlPath, String OrderID,String OrderRefId, String FirstName, String LastName, String SSN,
			String Score) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (OrderID == null) {
			OrderID = "";
		}
		if (FirstName == null) {
			FirstName = "";
		}
		if (LastName == null) {
			LastName = "";
		}
		if (SSN == null) {
			SSN = "";
		}
		if (Score == null) {
			Score = "";
		}

		if (!(OrderID.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node OrderId = (Node) xPath.compile("//Quoteback").evaluate(doc, XPathConstants.NODE);
			OrderId.setTextContent(OrderID);
			reportLog(Status.PASS, "OrderID is Updated : " + OrderID, false);
		}
		if (!(OrderRefId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node OrderIdwps = (Node) xPath.compile("//ProviderReferenceId").evaluate(doc, XPathConstants.NODE);
			OrderIdwps.setTextContent("WPS-" + OrderRefId);
			reportLog(Status.PASS, "WPS-OrderID is Updated : " + OrderID, false);
		}
		if (!(FirstName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node Firstname = (Node) xPath.compile("//GivenName").evaluate(doc, XPathConstants.NODE);
			Firstname.setTextContent(FirstName);
			reportLog(Status.PASS, "FirstName is Updated : " + FirstName, false);
		}
		if (!(LastName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node Lastname = (Node) xPath.compile("//FamilyName").evaluate(doc, XPathConstants.NODE);
			Lastname.setTextContent(LastName);
			reportLog(Status.PASS, "LastName is Updated : " + LastName, false);
		}
		if (!(SSN.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node ssn = (Node) xPath.compile("//GovernmentId").evaluate(doc, XPathConstants.NODE);
			ssn.setTextContent(SSN);
			reportLog(Status.PASS, "SSN is Updated : " + SSN, false);
		}
		if (!(Score.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node score = (Node) xPath.compile("//Score").evaluate(doc, XPathConstants.NODE);
			score.setTextContent(Score);
			reportLog(Status.PASS, "Score is Updated : " + Score, false);
		}
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);

	}
	
	public void daUpdate(String xmlPath,String OrderRefId, String FirstName, String LastName, String SSN,
			String Score) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (OrderRefId == null) {
			OrderRefId = "";
		}
		if (FirstName == null) {
			FirstName = "";
		}
		if (LastName == null) {
			LastName = "";
		}
		if (SSN == null) {
			SSN = "";
		}
		if (Score == null) {
			Score = "";
		}

		if (!(OrderRefId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node OrderIdwps = (Node) xPath.compile("//ProviderReferenceId").evaluate(doc, XPathConstants.NODE);
			OrderIdwps.setTextContent("WPS-" + OrderRefId);
			reportLog(Status.PASS, "WPS-OrderID is Updated : " + OrderID, false);
		}
		if (!(FirstName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node Firstname = (Node) xPath.compile("//GivenName").evaluate(doc, XPathConstants.NODE);
			Firstname.setTextContent(FirstName);
			reportLog(Status.PASS, "FirstName is Updated : " + FirstName, false);
		}
		if (!(LastName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node Lastname = (Node) xPath.compile("//FamilyName").evaluate(doc, XPathConstants.NODE);
			Lastname.setTextContent(LastName);
			reportLog(Status.PASS, "LastName is Updated : " + LastName, false);
		}
		if (!(SSN.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node ssn = (Node) xPath.compile("//GovernmentId").evaluate(doc, XPathConstants.NODE);
			ssn.setTextContent(SSN);
			reportLog(Status.PASS, "SSN is Updated : " + SSN, false);
		}
		if (!(Score.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node score = (Node) xPath.compile("//Score").evaluate(doc, XPathConstants.NODE);
			score.setTextContent(Score);
			reportLog(Status.PASS, "Score is Updated : " + Score, false);
		}
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);

	}
	
	public void commonUpdateNONHD(String xmlPath, String Comanyname, String Username)
			throws Exception {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (Comanyname == null) {
			Comanyname = "";
		}
		if (Username == null) {
			Username = "";
		}
		

		if (!(Comanyname.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node CompanyName = (Node) xPath.compile("//CompanyName").evaluate(doc, XPathConstants.NODE);
			CompanyName.setTextContent(Comanyname);
			reportLog(Status.PASS, "Comany name is Updated : " + Comanyname, false);
		}

		if (!(Username.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node UserName = (Node) xPath.compile("//UserName").evaluate(doc, XPathConstants.NODE);
			UserName.setTextContent(Username);
			reportLog(Status.PASS, "User name is Updated : " + Username, false);
		}

		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);
	}
	
	public void checkBadgeOrderStatusEx(String xmlPath,String companyId, String orderId) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (companyId == null) {
			companyId = "";
		}
		if (orderId == null) {
			orderId = "";
		}
		

		if (!(companyId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node CompanyId = (Node) xPath.compile("//CompanyId").evaluate(doc, XPathConstants.NODE);
			CompanyId.setTextContent(companyId);
			reportLog(Status.PASS, "CompanyId is Updated : " + companyId, false);
		}
		if (!(orderId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node OrderId = (Node) xPath.compile("//OrderId").evaluate(doc, XPathConstants.NODE);
			OrderId.setTextContent(orderId);
			reportLog(Status.PASS, "OrderId is Updated : " + orderId, false);
		}
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);

	}
	
	public void badgeOrder(String xmlPath,String companyId, String orderId, String peopleId) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (companyId == null) {
			companyId = "";
		}
		if (orderId == null) {
			orderId = "";
		}
		if (peopleId == null) {
			peopleId = "";
		}
		

		if (!(companyId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node CompanyId = (Node) xPath.compile("//CompanyId").evaluate(doc, XPathConstants.NODE);
			CompanyId.setTextContent(companyId);
			reportLog(Status.PASS, "CompanyId is Updated : " + companyId, false);
		}
		if (!(orderId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node OrderId = (Node) xPath.compile("//OrderId").evaluate(doc, XPathConstants.NODE);
			OrderId.setTextContent(orderId);
			reportLog(Status.PASS, "OrderId is Updated : " + orderId, false);
		}
		if (!(peopleId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node PeopleId = (Node) xPath.compile("//PeopleId").evaluate(doc, XPathConstants.NODE);
			PeopleId.setTextContent(peopleId);
			reportLog(Status.PASS, "PeopleId is Updated : " + peopleId, false);
		}
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);

	}
	
	public void orderReplacemnetBadge(String xmlPath,String companyId, String orderId, String peopleId) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (companyId == null) {
			companyId = "";
		}
		if (orderId == null) {
			orderId = "";
		}
		if (peopleId == null) {
			peopleId = "";
		}
		

		if (!(companyId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node CompanyId = (Node) xPath.compile("//CompanyId").evaluate(doc, XPathConstants.NODE);
			CompanyId.setTextContent(companyId);
			reportLog(Status.PASS, "CompanyId is Updated : " + companyId, false);
		}
		if (!(orderId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node OrderId = (Node) xPath.compile("//OrderId").evaluate(doc, XPathConstants.NODE);
			OrderId.setTextContent(orderId);
			reportLog(Status.PASS, "OrderId is Updated : " + orderId, false);
		}
		if (!(peopleId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node PeopleId = (Node) xPath.compile("//PeopleId").evaluate(doc, XPathConstants.NODE);
			PeopleId.setTextContent(peopleId);
			reportLog(Status.PASS, "PeopleId is Updated : " + peopleId, false);
		}
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);

	}
	
	public void PABGApiOrder(String xmlPath,String FirstName, String LastName, String DateOfBirth, String EmailAddress, String GovernmentId, String CountryCode, String Region, String Municipality, String SSNProvided, String NameType, String Address1, String City, String State, String ZipCode) throws Exception {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (FirstName == null) {
			FirstName = "";
		}
		if (LastName == null) {
			LastName = "";
		}
		if (DateOfBirth == null) {
			DateOfBirth = "";
		}
		if (EmailAddress == null) {
			EmailAddress = "";
		}
		if (GovernmentId == null) {
			GovernmentId = "";
		}
		if (CountryCode == null) {
			CountryCode = "";
		}
		if (Region == null) {
			Region = "";
		}
		if (Municipality == null) {
			Municipality = "";
		}
		if (SSNProvided == null) {
			SSNProvided = "";
		}
		if (NameType == null) {
			NameType = "";
		}
		if (Address1 == null) {
			Address1 = "";
		}
		if (City == null) {
			City = "";
		}
		if (State == null) {
			State = "";
		}
		if (ZipCode == null) {
			ZipCode = "";
		}

		if (!(FirstName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node fn = (Node) xPath.compile("//FirstName").evaluate(doc, XPathConstants.NODE);
			fn.setTextContent(FirstName);
			reportLog(Status.PASS, "FirstName is Updated : " + FirstName, false);
		}
		if (!(LastName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node ln = (Node) xPath.compile("//LastName").evaluate(doc, XPathConstants.NODE);
			ln.setTextContent(LastName);
			reportLog(Status.PASS, "LastName is Updated : " + LastName, false);
		}
		if (!(DateOfBirth.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node dob = (Node) xPath.compile("//DateOfBirth").evaluate(doc, XPathConstants.NODE);
			dob.setTextContent(DateOfBirth);
			reportLog(Status.PASS, "DateOfBirth is Updated : " + DateOfBirth, false);
		}
		if (!(EmailAddress.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node ema = (Node) xPath.compile("//EmailAddress").evaluate(doc, XPathConstants.NODE);
			ema.setTextContent(EmailAddress);
			reportLog(Status.PASS, "EmailAddress is Updated : " + EmailAddress, false);
		}
		if (!(GovernmentId.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node gi = (Node) xPath.compile("//GovernmentId").evaluate(doc, XPathConstants.NODE);
			gi.setTextContent(GovernmentId);
			reportLog(Status.PASS, "GovernmentId is Updated : " + GovernmentId, false);
		}
		if (!(CountryCode.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node cc = (Node) xPath.compile("//PositionLocations/PositionLocation/CountryCode").evaluate(doc, XPathConstants.NODE);
			cc.setTextContent(CountryCode);
			reportLog(Status.PASS, "PosLoc CountryCode is Updated : " + CountryCode, false);
		}
		if (!(Region.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node rn = (Node) xPath.compile("//PositionLocations/PositionLocation/Region").evaluate(doc, XPathConstants.NODE);
			rn.setTextContent(Region);
			reportLog(Status.PASS, "PosLoc Region is Updated : " + Region, false);
		}
		if (!(Municipality.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node my = (Node) xPath.compile("//Municipality").evaluate(doc, XPathConstants.NODE);
			my.setTextContent(Municipality);
			reportLog(Status.PASS, "PosLoc Municipality is Updated : " + Municipality, false);
		}
		
		if (scenarioName.contains("BGD")) {
			if (!(SSNProvided.isEmpty())) {
				XPath xPath = XPathFactory.newInstance().newXPath();
				Node ssnp = (Node) xPath.compile("//SsnProvided").evaluate(doc, XPathConstants.NODE);
				ssnp.setTextContent(SSNProvided);
				reportLog(Status.PASS, "SSN Provided is Updated : " + SSNProvided, false);
			}
			if (!(NameType.isEmpty())) {
				XPath xPath = XPathFactory.newInstance().newXPath();
				Node nt = (Node) xPath.compile("//NameType").evaluate(doc, XPathConstants.NODE);
				nt.setTextContent(NameType);
				reportLog(Status.PASS, "Name Type is Updated : " + NameType, false);
			}
			if (!(Address1.isEmpty())) {
				XPath xPath = XPathFactory.newInstance().newXPath();
				Node ad = (Node) xPath.compile("//Postals/Postal/Address/Address1").evaluate(doc, XPathConstants.NODE);
				ad.setTextContent(Address1);
				reportLog(Status.PASS, "Address1 is Updated : " + Address1, false);
			}
			if (!(City.isEmpty())) {
				XPath xPath = XPathFactory.newInstance().newXPath();
				Node ct = (Node) xPath.compile("//Postals/Postal/Address/City").evaluate(doc, XPathConstants.NODE);
				ct.setTextContent(City);
				reportLog(Status.PASS, "City is Updated : " + City, false);
			}
			if (!(State.isEmpty())) {
				XPath xPath = XPathFactory.newInstance().newXPath();
				Node st = (Node) xPath.compile("//Postals/Postal/Address/State").evaluate(doc, XPathConstants.NODE);
				st.setTextContent(State);
				reportLog(Status.PASS, "State is Updated : " + State, false);
			}
			if (!(ZipCode.isEmpty())) {
				XPath xPath = XPathFactory.newInstance().newXPath();
				Node zc = (Node) xPath.compile("//Postals/Postal/Address/Zipcode").evaluate(doc, XPathConstants.NODE);
				zc.setTextContent(ZipCode);
				reportLog(Status.PASS, "ZipCode is Updated : " + ZipCode, false);
			}

    		}
		
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);

}
	public void ApiOrder(String xmlPath,String FirstName, String LastName) throws Exception {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File(xmlPath));
		xmlPath = xmlPath.toString();

		if (FirstName == null) {
			FirstName = "";
		}
		if (LastName == null) {
			LastName = "";
		}
		if (!(FirstName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node fn = (Node) xPath.compile("//FirstName").evaluate(doc, XPathConstants.NODE);
			fn.setTextContent(FirstName);
			reportLog(Status.PASS, "FirstName is Updated : " + FirstName, false);
		}
		if (!(LastName.isEmpty())) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node ln = (Node) xPath.compile("//LastName").evaluate(doc, XPathConstants.NODE);
			ln.setTextContent(LastName);
			reportLog(Status.PASS, "LastName is Updated : " + LastName, false);
		}

		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File(xmlPath));
		tf.transform(domSource, sr);
	}
}