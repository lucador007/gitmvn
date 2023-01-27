package framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
		
		try {
			File src = new File("./TestData/Data.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel file "+e.getMessage());
		}
	}
	public String getStringData(String SheetName,int RowNum, int CollNum)
	{
		return wb.getSheet(SheetName).getRow(RowNum).getCell(CollNum).getStringCellValue();
	}
	public String getStringData(int SheetNum,int RowNum, int CollNum)
	{
		return wb.getSheetAt(SheetNum).getRow(RowNum).getCell(CollNum).getStringCellValue();
	}
	public double getNumericData(String SheetName,int RowNum, int CollNum)
	{
		return wb.getSheet(SheetName).getRow(RowNum).getCell(CollNum).getNumericCellValue();
	}
	public double getNumericData(int SheetNum,int RowNum, int CollNum)
	{
		return wb.getSheetAt(SheetNum).getRow(RowNum).getCell(CollNum).getNumericCellValue();
	}
}
