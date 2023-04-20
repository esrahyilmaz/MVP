package Utility;

import com.aventstack.extentreports.Status;
import seleniumhelper.BaseClass;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WebServiceUtils extends BaseClass{

	public String sendPostRequest(String postUrl, String xmlFilePath) {
		reportLog(Status.PASS, "The Exchange URL is : "+postUrl, false);
		String responseString = "";
		String outputString = "";
		try{			
		URL url = new URL(postUrl);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput=readXmlFile(xmlFilePath);
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		httpConn.setRequestProperty("Content-Length",String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();
		int statusCode=httpConn.getResponseCode();
		 if(statusCode==200) {
			 InputStreamReader isr =
						new InputStreamReader(httpConn.getInputStream());
						BufferedReader in = new BufferedReader(isr);
						while ((responseString = in.readLine()) != null) {
						outputString = outputString + responseString;
						}
						logStepInfo("Successfully get the response : status code-"+statusCode);
						reportLog(Status.PASS,"Successfully get the response : status code-"+statusCode,false);
						return outputString;
		 }
		 else {
			 logStepInfo("Failed - Error in Soap response : status code-"+statusCode);
				reportLog(Status.FAIL,"Failed - Error in Soap response : status code-"+statusCode,false);
				scenarioFailed();
			 return null;
		 }
		
		}catch(Exception e) {
			logStepInfo("Failed - Error in function sendPostRequest(): "+e.getMessage());
			reportLog(Status.FAIL,"Failed - Error in function sendPostRequest() - check logs for more details",false);
			scenarioFailed();
			return null;			
		}
	}
	
	
	//Below method is used to read xml file and convert it into String format
	public static String readXmlFile(String path)
	{
		File file=new File(path);
		System.out.println("Input Xml File path : "+path);
		FileInputStream fis=null;
		String str="";
		try {
			fis=new FileInputStream(file);
			int content;
			while((content=fis.read())!=-1)
			{
				str +=(char)content;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
					fis.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return str;
	}
	
	
}
