package Scripts;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary 
{

	public String getData(String sheetName, int rownum, int cellnum) throws IOException {

		FileInputStream fis= new FileInputStream("‪‪C:\\Users\\Ramya\\OneDrive\\Desktop\\testdata.xlsx");
		Workbook wb=  WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		Row r = sh.getRow(rownum);
		Cell cell = r.getCell(cellnum);
		String data = cell.getStringCellValue();		
		return data;
	}

	
}
