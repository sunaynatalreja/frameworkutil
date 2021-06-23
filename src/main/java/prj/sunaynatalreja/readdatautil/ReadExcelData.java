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

	XSSFSheet sheet;
	FileInputStream fis;
	XSSFWorkbook wb;
	
	/**
	 * Returns shee
	 * @param file
	 * @param workbook
	 * @param sheetName
	 * @return sheet
	 * @throws IOException
	 */
	public XSSFSheet getSheet(String file,String workbook,String sheetName) throws IOException
	{		
		
		workbook=ReadExcelData.class.getClassLoader().getResource("TestData.xlsx").getPath().replace("\\", File.separator);
		try {
			fis=new FileInputStream(workbook);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheet;
	}

	/**
	 * Returns headers of the excel sheet
	 * @param sheet
	 * @return
	 */
	public ArrayList<String> getHeaders(XSSFSheet sheet) {
		ArrayList<String> listOfHeaders=new ArrayList<>();
		int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i=0;i<columnCount;i++)
		{
			listOfHeaders.add(sheet.getRow(0).getCell(i).getStringCellValue());
		}

		return listOfHeaders;
	}
	
	public void closeExcel() throws IOException
	{	
		wb.close();
		fis.close();		
	}

}
