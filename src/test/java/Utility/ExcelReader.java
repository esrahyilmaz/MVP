package Utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import seleniumhelper.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ExcelReader extends BaseClass{
	public int rowNo,cellNo;
	Sheet sheet;
	CurrentDateTime date=new CurrentDateTime();
	private static final String filePath=System.getProperty("user.dir")+"\\output\\Output_Result.xlsx";
	
	
	public ExcelReader() {
		setRow();
	}
	
	public void readExcel() {
		try {
		File f=new File(System.getProperty("user.dir") +""+PropertyFileReader.getProperty("testData.path"));
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		String[] sheetName=scenarioName.split("_");
		sheet=wb.getSheet(sheetName[0]);
	
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void setRow() {
		try {
		readExcel();	
		for (int i = 1; i <=sheet.getLastRowNum(); i++) {
			Row row=sheet.getRow(i);
			String testCase=row.getCell(0).getStringCellValue();
			String []scenario=scenarioName.split("_");
			if (testCase.equalsIgnoreCase(scenario[1])) {
				rowNo=i;
				break;
			}
		}
		
		}
		catch(Exception e) {
			e.getMessage();
			}
	}
	public String getData(String colName) {
		try {
//			readExcel();
			setRow();
			Row row=sheet.getRow(0);
			for (int i = 1; i <=row.getLastCellNum(); i++) {
				String col=row.getCell(i).getStringCellValue();
				if(colName.equalsIgnoreCase(col)) {
					cellNo=i;
					break;
				}
			}
			String value=sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			return value;
		}
		catch(Exception e) {
			e.getMessage();		
			
		}
		return null;
	}	
	public String writeExcel(String writeValue,int colNum) throws Exception  {
		InputStream inp = new FileInputStream(filePath); 
	    Workbook wb = WorkbookFactory.create(inp); 
	    Sheet sheet = wb.getSheetAt(0); 
	    int num = sheet.getLastRowNum(); 
	    Row row = sheet.createRow(++num);
	    row.createCell(0).setCellValue(CurrentDateTime.getSystemDate());
	    row.createCell(1).setCellValue(scenarioName);
	    if(colNum==2){
	    	row.createCell(2).setCellValue(writeValue);
	    }
	    else if(colNum==3) {
	    	row.createCell(3).setCellValue(writeValue);
	    }
	        FileOutputStream fileOut = new FileOutputStream(filePath); 
	    wb.write(fileOut); 
		return "str";
	}
}
