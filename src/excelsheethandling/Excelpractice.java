package excelsheethandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelpractice {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	List<Map<Object, Object>> list;
	Object[][] arr;

	@BeforeTest
	public void excelsetup() throws IOException {
		list = new ArrayList<Map<Object, Object>>();
		fis = new FileInputStream("C:\\Users\\Chetan\\Desktop\\Test Data.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Test Data");
	}

	@Test
	public void exceldatacapture() throws IOException {

		int totalrowcount = sheet.getPhysicalNumberOfRows();
		int totalcolumncount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total row count = " + totalrowcount);
		System.out.println("Total coloumn count = " + totalcolumncount);

		for (int i = 1; i < totalrowcount; i++) {
			Map<Object, Object> map = new HashMap<Object, Object>();

			for (int j = 0; j < totalcolumncount; j++) {

				String columnname = sheet.getRow(0).getCell(j)
						.getStringCellValue();
				Object columnvalue;
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);

				switch (cell.getCellTypeEnum()) {
				case STRING:
					         columnvalue = sheet.getRow(i).getCell(j).getStringCellValue();
					         map.put(columnname, columnvalue);
					         break;
				case NUMERIC:
					columnvalue = sheet.getRow(i).getCell(j).getNumericCellValue();
			         map.put(columnname, columnvalue);
			         break;
			      
				case BOOLEAN:
					  columnvalue = sheet.getRow(i).getCell(j).getBooleanCellValue();
			         map.put(columnname, columnvalue);
			         break;     
					

				default:
					break;

				}

			}
			list.add(map);
		}
		wb.close();

		System.out.println("list is " + list);
	}

	public void specificExcelData(int row) {
		System.out.println(list.get(row).get("User Id"));
	}

	@DataProvider(name = "excelread")
	public Object[][] excelread() {
		int totalrowcount = sheet.getPhysicalNumberOfRows();
		int totalcolumncount = sheet.getRow(0).getPhysicalNumberOfCells();
		arr = new Object[totalrowcount - 1][totalcolumncount - 1];
		for (int i = 1; i < totalrowcount; i++) {

			for (int j = 1; j < totalcolumncount; j++) {

				arr[i - 1][j - 1] = sheet.getRow(i).getCell(j)
						.getStringCellValue();

			}
		}

		for (Object[] oj : arr) {

			for (Object oh : oj) {

				System.out.print(oh.toString() + "  ");
			}
			System.out.println();
		}

		return arr;

	}

	@Test(dataProvider = "excelread")
	public void mtd(String a, String b) {
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) throws IOException {
		Excelpractice obj = new Excelpractice();
		obj.excelsetup();
		obj.excelread();
		obj.exceldatacapture();
		// obj.exceldatacapture();
		// obj.specificExcelData(1);
	}
}
