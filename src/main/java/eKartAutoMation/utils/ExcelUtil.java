package eKartAutoMation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import eKartAutoMation.constant.AppConstants;

public class ExcelUtil {
	static Workbook workBook=null;
	static Sheet sheet=null;
	
	public static Object[][] readTestData(String sheetName){
		
		System.out.println("READ DATA FROM SHEET: "+ sheetName);
		Object[][] data=null;
		try {
			File file=new File(AppConstants.EXCEL_NPUT_FILE_PATH);
			FileInputStream fileInputStream=new FileInputStream(file);
			workBook=WorkbookFactory.create(fileInputStream);
			sheet=workBook.getSheet(sheetName);
			
			data= new Object [sheet.getLastRowNum()]
					         [sheet.getRow(0).getLastCellNum()];
			//[10][5] get the excel capacity> no of rows and column.
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString(); 
				}
				
			}
		}catch(EncryptedDocumentException ede) {
			ede.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException io) {
			io.printStackTrace();
		}
		
		return data;
	}

}
