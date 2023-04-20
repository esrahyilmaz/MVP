package Report;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import seleniumhelper.BaseClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;

public class ReportWriter extends BaseClass {

	private final String outputFilePath = System.getProperty("user.dir") + "\\output\\Execution_Result_" +getDate()
			+ ".xlsx";
	private static final String inputFilePath = System.getProperty("user.dir") + "\\Report.xlsx";
	private static InputStream oFileReader;
	private static Workbook oExcelWorkbook;
	private static String sExcelFileName;
	private static FileOutputStream oFileWriter;

	Sheet oSheet;
	Row oRow;
	Cell oCell;
	int iRow;

	public ReportWriter() {
		oFileReader = null;
		oFileWriter = null;
		oExcelWorkbook = null;
		sExcelFileName = "";
	}

	public void createReport() throws Exception {
		oExcelWorkbook = new XSSFWorkbook();
		oFileReader = new FileInputStream(inputFilePath);
		sExcelFileName = inputFilePath;
		oExcelWorkbook = WorkbookFactory.create(oFileReader);
				
		oFileWriter = new FileOutputStream(outputFilePath);
		oExcelWorkbook.setSheetName(oExcelWorkbook.getSheetIndex("Sheet1"), getTime());
		oExcelWorkbook.write(oFileWriter);
		System.out.println( "New file created!!!!");
		oFileWriter.close();

	} 
	public void CreateResultExcel(Type cResult) throws Exception {
		oExcelWorkbook = new XSSFWorkbook();
		oFileReader = new FileInputStream(outputFilePath);
		sExcelFileName = outputFilePath;
		oExcelWorkbook = WorkbookFactory.create(oFileReader);
		
		String Result=cResult.toString();
		String []scenario=scenarioName.split("_");

		String sSheetName = oExcelWorkbook.getSheetAt(0).getSheetName();
		oSheet = oExcelWorkbook.getSheet(sSheetName);
		int lastRow = oSheet.getLastRowNum();

		for (int i = 1; i <= lastRow; i++) {
			String keyword = oSheet.getRow(i).getCell(3).getStringCellValue();
			if (keyword.equals(scenario[1])) {
				int rowNum = oSheet.getRow(i).getRowNum();
//				System.out.println(oSheet.getRow(i).getRowNum());
				oRow = oSheet.getRow(i);
				oCell = oRow.getCell(4, Row.RETURN_BLANK_AS_NULL);
				if (oCell == null) {
					oCell = oRow.createCell(4);
					oCell.setCellValue(Result);
				} else {
					oCell.setCellValue(Result);
				}
				System.out.println("Result Written!!");
			}
		}
		oCell=oSheet.getRow(0).getCell(4);
		oCell.setCellValue(getDate());
		System.out.println("Result of test case is :-"+Result);
		oFileWriter = new FileOutputStream(outputFilePath);
		oExcelWorkbook.write(oFileWriter);
		oFileWriter.close();
	}
}
