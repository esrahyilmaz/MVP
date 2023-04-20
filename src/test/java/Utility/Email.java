package Utility;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email extends BaseClass{

private static String USER_NAME = "fadvCTautomation";  // GMail user name (just the part before "@gmail.com")
private static String PASSWORD = "Qctesting1"; // GMail password

private static String[] RECIPIENT = {"monika.marovic@fadv.com"};

WriteFile wf=new WriteFile();
HandlePopUp hp=new HandlePopUp();

public void sendEmail() {
    String from = USER_NAME;
    String pass = PASSWORD;
    String[] to =  RECIPIENT ; // list of recipient email addresses
    String subject = "Vendor Name Test Email";
//    String subject = "Auto Generated Report For XtdForce Customer Test";
//    String body = "Vendor Name is : "+VendorName+"\r\n" + 
//    		"Below is the Report Link with steps :\r\n" +     		
//    		"	"+ReportpathServer+" \r\n" + 
//  
//    		"	\r\n" + 
//    		"Thank you,\r\n" + 
//    		"Automation Team";

    String body = "Vendor Name is : "+VendorName+"\r\n" + 
    		"Thank you,\r\n" + 
    		"Monika Marovic";
    
    sendFromGMail(from, pass, to, subject, body);
}

private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
    Properties props = System.getProperties();
  String host = "smtp.gmail.com";

    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    props.put("mail.smtp.ssl.trust", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");


    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {

        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++   ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for( int i = 0; i < toAddress.length; i++  ) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }

        message.setSubject(subject);
        message.setText(body);


        Transport transport = session.getTransport("smtp");

        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("Email Sent Sucessfully!!!");
    }
    catch (AddressException ae) {
        ae.printStackTrace();
    }
    catch (MessagingException me) {
        me.printStackTrace();
    }
    }

public void sendEmailwithJSNewUI() throws Exception {
	String strContent="<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<title>Send Mail</title>\r\n" + 
			"<script src=\r\n" + 
			"	\"https://smtpjs.com/v3/smtp.js\">\r\n" + 
			"</script>\r\n" + 
			"<script type=\"text/javascript\">\r\n" + 
			"	function sendEmail() {\r\n" + 
			"	Email.send({\r\n" + 
			"		Host: \"smtp.gmail.com\",\r\n" + 
			"		Username: \"fadvCTautomation@gmail.com\",\r\n" + 
			"		Password: \"Qctesting1\",\r\n" + 
			"		To: 'monika.marovic@fadv.com,tomislav.prsa@fadv.com,mohibullah.hafizi@fadv.com'\r\n" + 
			"		From: \"fadvctautomation@gmail.com\",\r\n" + 
			"		Subject: \"Auto Generated Report For XtdForce Smoke Test of Production(NewUI)\",\r\n" + 
			"		Body: \"Report Status for Smoke Test Production is "+ReportStatus+" <br>Here is the  Report Link: "+ReportpathServer+" <br><br><br>Thank you,<br>Automation Team\",\r\n" + 
			"	})\r\n" + 
			"		.then(function (message) {\r\n" + 
			"		alert(\"mail sent successfully\")\r\n" + 
			"		});\r\n" + 
			"	}\r\n" + 
			"</script>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<form method=\"post\">\r\n" + 
			"	<input type=\"button\" value=\"Send Email\"\r\n" + 
			"		onclick=\"sendEmail()\" />\r\n" + 
			"</form>\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n" + 
			"";
	String path=PropertyFileReader.getProperty("sendEmail.path");
	wf.write(strContent, path);
	String ServeremailFilePath="BDD_Reports";
	String EmailpathServer = PropertyFileReader.getProperty("ReportpathServer")+"BDD_Reports/sendEmail.html";
	ReportUpload.uploadToServerEmailFile(ServeremailFilePath, path);
	loadUrl(EmailpathServer);
	By element=By.xpath("//input[@value='Send Email']");
	clickElement(element, "Send Email");
	wait(5);
	hp.handlePopUp();
}
   } 