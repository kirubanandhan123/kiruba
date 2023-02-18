package genericLiberies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains reusable method to perform operatoin on excel work book
 * @author KanyaKavi
 *
 */

public class ExcelUtility 
{
private Workbook wb;
/**
 * This method is used to initilized excel work book
 * @param excelPath
 */
public void excelInitialization(String excelPath)
{
	FileInputStream fis=null;
	try {
		fis =new FileInputStream(excelPath);
		
				
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try {
		wb=WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
}
/**
 * This method is used to fetch the data from excel work book by particular cell
 * @paramsheetName
 * @param rowNum
 * @paramcellNum
 * @return
 */
public String fetchDataFromExcel(String sheetName,int rowNum,int cellNum)
{
	return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	
}
/**
 * This method is used to fetch the data all the data from excel workbook by accepting sheet name
 * @paramsheetName
 * @return List of String data
 */

public List<String> fetchDataFromExcel(String sheetName){
	List<String>dataList =new ArrayList<>();
	Sheet sheet=wb.getSheet(sheetName);
	for(int i=0;i<4;i++)
	{
		String data=sheet.getRow(i).getCell(1).getStringCellValue();
		dataList.add(data);
	}
	return dataList;
	
	
	}
/**
 * This Method is used to close the excel WorkBook
 */
public void CloseExcel() {
	try {
		wb.close();
	} catch (IOException e) {

		e.printStackTrace();
	}
	
}

	
	
	
	
	
}
