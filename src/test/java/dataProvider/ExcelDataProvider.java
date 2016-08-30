package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataProvider {
	
	HSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src=new File("./ApplicationTestData/AppData.xls");
		
			try {
				FileInputStream fis=new FileInputStream(src);
				wb=new HSSFWorkbook(fis);
			}  catch (Exception e) {
				
				System.out.println("Exception is: "+e.getMessage());
			}
	}
	
	public String getData(int sheetIndex, int row, int column)
	{
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetName, int row, int column)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
