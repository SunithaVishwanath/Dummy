package com.crm.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author sunit
 *
 */

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
		Cell cell = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	
	public void insertIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
		workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);;;
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelPath);
		workbook.write(fos);
		
	}
	
	public int getLastRowNumFromExcel(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
		Sheet sheet= workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
		
	}
}


