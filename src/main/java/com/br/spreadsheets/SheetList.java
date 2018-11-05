package com.br.spreadsheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SheetList {
	static XSSFRow row;
	static String[] SheetName;
	static int SheetNumber;
	static XSSFSheet spreadsheet;
	static short cellValue;
	static XSSFWorkbook workbook;
	static int index = 0;

	public SheetList() throws Exception {
		configMethod();
	}
	
	
	/*****************************************************************************/
	public static void main(String[] args){
		
		
	}
	/******* Recebe o nome da Sheet, caso exista, retorna seu index **************/
	public static int getSheetIndex(String sheet) throws Exception {
		
		for (int i = 0; i < SheetNumber; i++) {
			if(SheetName[i].equals(sheet))
				index = i;	
				spreadsheet = workbook.getSheetAt(0);
		}
		return index;
	}
	
	
	/**
	 * @return ***************************************************************************/
	public static int configMethod() throws IOException {
				
		FileInputStream fis = new FileInputStream(new File("Data/DataOne.xlsx"));
		workbook = new XSSFWorkbook(fis);
		SheetNumber = workbook.getNumberOfSheets();
		SheetName = new String[SheetNumber];
								
		for (int i = 0; i < SheetNumber; i++) {
			SheetName[i] = workbook.getSheetName(i);	
		}
		workbook.close();
		
		for (int i = 0; i < SheetNumber; i++) {
			if(SheetName[i].equals("SheetOne"))
				index = i;	
				
		}
		return index;
	}
	
	public static short countColl() {
		spreadsheet = workbook.getSheetAt(3);
		cellValue = spreadsheet.getRow(0).getLastCellNum();
//		XSSFCell StringCell = spreadsheet.getRow(row).getCell(cell);
//		System.out.println(StringCell);
		return cellValue;
	}
	
	
	


}
