package Utility;

import com.aventstack.extentreports.Status;
import seleniumhelper.BaseClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TxtWriter extends BaseClass{
//	private static final Path originalFilePath=Paths.get(System.getProperty("user.dir")+"\\output\\HomeDepo.AHK");
	
	public void WriteTxtFile(String path,String StrResetValue, String StrSearchValue) throws IOException {
	     try {
	    	 Path originalFilePath=Paths.get(path);
	    	Stream <String> lines = Files.lines(originalFilePath);
            List <String> replaced = lines.map(line -> line.replaceAll(StrSearchValue,StrResetValue)).collect(Collectors.toList());
            Files.write(originalFilePath, replaced);
            lines.close();
            System.out.println("Find and Replace done!!!");           
            reportLog(Status.PASS, "Text file writing successfully done !!!"+StrResetValue, true);
			logStepInfo("Text file writing successfully done !!!" + StrResetValue);
	     }
	     catch(Exception ex) {
	    	reportLog(Status.PASS, "Text file writing Failed  !!!"+ex.getMessage(), true);
			logStepInfo("Text file writing Failed  !!!"+ex.getMessage());
	     }
	}
}