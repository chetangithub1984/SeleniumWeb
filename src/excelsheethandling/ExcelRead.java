package excelsheethandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public FileInputStream fis;
	public FileOutputStream fileOut = null;
	public String path;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public List<HashMap<Object,Object>> mylist;
	
	
	public ExcelRead (String path) throws IOException {
		this.path = path;
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);	
	}
	
	public List getExcelData (String sheetName) throws IOException {
		
		sheet = wb.getSheet(sheetName);
		mylist = new ArrayList();
		int totalrows = sheet.getPhysicalNumberOfRows();
		int totalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("total rows = " + totalrows);
		System.out.println("total columns = " + totalColumn);
		
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			HashMap<Object, Object> mymap = new HashMap();

			for (int j = 0; j < sheet.getRow(0).getPhysicalNumberOfCells(); j++) {

				String cellName = sheet.getRow(0).getCell(j)
						.getStringCellValue();
				Object cellValue;
				row = sheet.getRow(i);
				cell = row.getCell(j);

				
		

				switch (cell.getCellType()) {

				case Cell.CELL_TYPE_STRING:

					cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
					mymap.put(cellName, cellValue);
					break;

				case Cell.CELL_TYPE_NUMERIC:
					cellValue = sheet.getRow(i).getCell(j)
							.getNumericCellValue();
					mymap.put(cellName, cellValue);
					break;

				case Cell.CELL_TYPE_BOOLEAN:
					cellValue = sheet.getRow(i).getCell(j)
							.getBooleanCellValue();
					mymap.put(cellName, cellValue);
					break;

				}

			}

			mylist.add(mymap);
		}
		
		wb.close();
		
		System.out.println(mylist);
		return mylist;
	}
	
	public void specificExcelData(int row) {
		

			
			System.out.println(mylist.get(row).get("User Id"));
	
		
	}
	
	public static void main(String[] args) throws IOException {
		String excelpath = "C:\\Users\\Chetan\\Desktop\\Test Data.xlsx";
		ExcelRead obj = new ExcelRead(excelpath);
		obj.getExcelData("Test Data");
		obj.specificExcelData(1);
		//obj.specificExcelData();
	}

}



