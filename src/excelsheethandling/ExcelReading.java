package excelsheethandling;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExcelReading {
	   File 	file;
	  FileInputStream fis;
	  XSSFWorkbook wb;
	  XSSFSheet sheet;
	  

	
	
	@BeforeClass
	
	public void Excelsheetinitialization () throws Exception   {
		System.out.println("before Suite method invoked");
		 file = new File("E:\\Sample Project\\SeleniumWeb\\TestData\\ApachePOI.xlsx"); // location of the file
		
		System.out.println(file.getAbsolutePath());
	    fis = new FileInputStream(file);
	   wb = new XSSFWorkbook(fis);
	   sheet= wb.getSheet("Vinay");
	  
	 
	
	}
	
	@Test
	
	public void excelreading() throws IOException {
		
		System.out.println("Test case invoked");
		int Totalrowcount = sheet.getLastRowNum();   ///  1
		System.out.println("Total row count by getlastrow = " + Totalrowcount );
		System.out.println("Total number of row by getphysical row = " + sheet.getPhysicalNumberOfRows());
		System.out.println("Total row count by getlastcell = " + sheet.getRow(0).getLastCellNum() );
		System.out.println("Total row count by getphycical cell  = " + sheet.getRow(0).getPhysicalNumberOfCells() );
		
		System.out.println("Total row count is " + (Totalrowcount +1));   /// 2 rows
		int TotalcoloumnNumber = sheet.getRow(0).getLastCellNum();
	
		System.out.println("Total coloumn count is - "  + TotalcoloumnNumber);   // 2 column 
		String firstdatavalue = sheet.getRow(0).getCell(0).getStringCellValue();
		
		
		System.out.println(firstdatavalue);
		
		for (int i = 0 ; i <=Totalrowcount ; i ++) {
			for ( int j = 0 ; j <TotalcoloumnNumber ; j ++ ) {
				System.out.print(sheet.getRow(i).getCell(j) + "  ");
			}
			System.out.println();
		}
		
		wb.close();
		
	}

}
