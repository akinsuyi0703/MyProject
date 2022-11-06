/**
 * 
 */
package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author ifeol
 *
 */
public class NewExcelLibrary {
	
XSSFWorkbook wb;
	
	public NewExcelLibrary() {
		
		File src = new File("./TestData/data.xlsx");
		
		try {
		FileInputStream fis=new FileInputStream(src);
		
		wb=new XSSFWorkbook(fis);
		}catch(Exception e) {
			System.out.println("unable to read excel file "+e.getMessage());
			
		}
		
	}
	

	public String getStringData(int sheetIndex, int row, int column) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(String sheetName, int row, int column) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName, int row, int column) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
		
	}


}
