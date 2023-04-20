package Utility;

import com.aventstack.extentreports.Status;
import seleniumhelper.BaseClass;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util extends BaseClass{
	
	
	
	public static String getBlobAsString(Blob blob) {
		char[] buffer = new char[0x1000];
		StringBuilder s = new StringBuilder();
		String str = null;
		InputStream in = null;
		try {
			in = blob.getBinaryStream();
			Reader r = new InputStreamReader(in, "UTF-8");
			for (int len; (len = r.read(buffer, 0, buffer.length)) != -1;)
				s.append(buffer, 0, len);
			str = s.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return str;
	}

	public void getDigitalBadgeLink(String file) {
		
		String text=file;
		String containedUrls;
	    String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(text);

	    while (urlMatcher.find())
	    {
	        containedUrls=text.substring(urlMatcher.start(0),
	                urlMatcher.end(0));
	        String str=containedUrls;
	       str = str.replace(str.substring(str.length()-3), "");
	       
	       DigitalBadgeLink=str;
	    }
	    
	   
	    if(!(DigitalBadgeLink.equalsIgnoreCase(""))) {
	    	reportLog(Status.PASS, "Digital Badge URL is : "+DigitalBadgeLink, false);
	    }else {
	    	reportLog(Status.FAIL, "Digital Badge URL Not present", false);
	    }
	    
	    
	}
}
