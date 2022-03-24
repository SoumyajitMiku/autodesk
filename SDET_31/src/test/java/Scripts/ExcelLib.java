package Scripts;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
		public String getExcelData(String sheetName, int rowcount, int cellCount) throws Exception
		{
			FileInputStream fis= new FileInputStream("C:\\Users\\Ramya\\OneDrive\\Desktop\\testdata.xlsx");
			Workbook workbook=WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowcount);
			Cell cell = row.getCell(cellCount);
			String data = cell.getStringCellValue();
			return data;
		}
}
