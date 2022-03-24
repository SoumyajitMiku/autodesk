package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
/**
 * its developed using Apache POi libraries, which used to handle Microsoft Excel sheet
 * @author Ramya
 *
 */
public class ExcelLibUtilities
{
	/**
	 * getting data from Excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable
	{	
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\testData\\sampleTest.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		workbook.close();
		return data;
	}
	
	/**
	 * getting row count from Excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\testData\\sampleTest.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return sheet.getLastRowNum();		
	}
	/**
	 * writing data to excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int cellNum ,String data) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./src\\main\\resources\\testData\\sampleTest.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);	
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos= new FileOutputStream("./src\\main\\resources\\testData\\sampleTest.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}
	
}
