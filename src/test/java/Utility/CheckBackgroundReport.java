package Utility;

import com.aventstack.extentreports.Status;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import seleniumhelper.BaseClass;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class CheckBackgroundReport extends BaseClass {
    private static String OrderURL = "";

    public String getOrderandURL(String responseXML) {

        if (responseXML != null && !responseXML.isEmpty()) {
            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(responseXML));

                Document doc = builder.parse(src);
                String URL = doc.getElementsByTagName("WebURL").item(0).getTextContent();
                if (URL != null) {
                    System.out.println(ResponseXML);
                    reportLog(Status.PASS, "Vendor Registration url is [" + URL + "]", false);
                    OrderURL = URL;
                } else {
                    reportLog(Status.INFO, "Vendor Registration url was not found in the xml", false);
                }
            } catch (Exception e) {
                logger.error(e);
                reportLog(Status.FAIL, e.toString(), false);
            }
        } else {
            reportLog(Status.FAIL, "response xml from the env is empty", false);
        }
        return OrderURL;
    }

    public void verifyMessage(String responseXML) {

        if (responseXML != null && !responseXML.isEmpty()) {
            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(responseXML));

                Document doc = builder.parse(src);

                // Getting Status
                String status = doc.getElementsByTagName("status").item(0).getTextContent();
                if (status != null) {
                    if (status.equalsIgnoreCase("SUCCESS")) {
                        reportLog(Status.PASS, "Vendor Registration status is [" + status + "]", false);
                    } else {
                        reportLog(Status.FAIL, "Vendor Registration status is [" + status + "]", false);
                    }
                }

                // getting status description
                String statusdesc = doc.getElementsByTagName("statusDescription").item(0).getTextContent();
                if (statusdesc != null) {
                    if (statusdesc.equalsIgnoreCase("Account updated")) {
                        reportLog(Status.PASS, "Vendor Registration status description is [" + statusdesc + "]", false);
                    } else {
                        reportLog(Status.FAIL, "Vendor Registration status description is [" + statusdesc + "]", false);
                    }
                }
            } catch (Exception e) {
                logger.error(e);
                reportLog(Status.FAIL, e.toString(), false);
            }
        } else {
            reportLog(Status.FAIL, "response xml from the env is empty", false);
        }
    }

    public void getApplicantLinkAPI() {

        if (PAOutputLog != null && !PAOutputLog.isEmpty()) {
            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(PAOutputLog));

                Document doc = builder.parse(src);

                // Getting URL
                String URL = doc.getElementsByTagName("ApplicantLink").item(0).getTextContent();
                if (URL != null) {
                    PAInviteLink = URL;
                    if (!(PAInviteLink.equalsIgnoreCase(""))) {
                        reportLog(Status.PASS, "PA Invite Link is present [" + PAInviteLink + "]", false);
                    } else {
                        reportLog(Status.FAIL, "PA Invite Link is not present [" + PAInviteLink + "]", false);
                    }
                }
            } catch (Exception e) {
                logger.error(e);
                reportLog(Status.FAIL, e.toString(), false);
            }
        } else {
            reportLog(Status.FAIL, "response xml from the env is empty", false);
        }
    }

    public void getAPIorderID() {

        if (ResponseXML != null && !ResponseXML.isEmpty()) {
            System.out.println(ResponseXML);
            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(ResponseXML));

                Document doc = builder.parse(src);

                // Getting Order ID
                String order = doc.getElementsByTagName("OrderId").item(0).getTextContent();
                if (order != null) {
                    OrderID = order;
                    if (!(OrderID.equalsIgnoreCase(""))) {
                        reportLog(Status.PASS, "Order ID is present [" + OrderID + "]", false);
                    } else {
                        reportLog(Status.FAIL, "Order Id is not present [" + OrderID + "]", false);
                    }
                }
            } catch (Exception e) {
                logger.error(e);
                reportLog(Status.FAIL, e.toString(), false);
            }
        } else {
            reportLog(Status.FAIL, "response xml from the env is empty", false);
        }
    }

}