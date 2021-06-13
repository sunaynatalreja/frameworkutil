/**
 * 
 */
package prj.sunaynatalreja.readdatautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Sunayna Talreja
*/
public class ReadExcelData {
	
	public XSSFSheet getSheet(String file,String workbook,String sheetName) throws IOException
	{
		/*
		 * Takes input parameter 
		 * as workbook name and sheet name 
		 * and fetches and returns sheet 
		 * 
		 */
		XSSFSheet sheet=null;
		
		  workbook=ReadExcelData.class.getClassLoader().getResource("TestData.xlsx").getPath();
		  workbook=workbook.replace("\\", File.separator);
		 
		
		FileInputStream fis=new FileInputStream(workbook);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		return sheet;
	}

	/**
	 * @param sheet
	 * @return
	 */
	public ArrayList<String> getHeaders(XSSFSheet sheet) {
		/*
		 * From the excel sheet
		 * fetches the header details
		 */
		ArrayList<String> listOfHeaders=new ArrayList<>();
		int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i=0;i<columnCount;i++)
		{
			listOfHeaders.add(sheet.getRow(0).getCell(i).getStringCellValue());
		}
		
		return listOfHeaders;
	}

}
