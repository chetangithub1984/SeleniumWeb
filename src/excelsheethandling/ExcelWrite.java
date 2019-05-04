package excelsheethandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWrite {

	@Test
	
	public void ExcelWrite() throws IOException {
		File file = new File("E:\\Sample Project\\SeleniumWeb\\TestData\\ApachePOI.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Vinay");
		sheet.getRow(0).createCell(1).setCellValue("chetan");
		//sheet.getRow(0).createCell(0).setCellValue("UserNAme5");
		//sheet.getRow(0).createCell(0).setCellValue("Vijay");
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
}
