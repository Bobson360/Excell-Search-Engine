package com.br.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utils {
	
	/******************* METHODO CONSTRUTOR ***************************/
	public Utils() throws IOException {
		
	}
	
	
	/************************* VARAVEIS GLOBAIS ***********************/
	private static int SheetIndex;
	private static int RowIndex;
	static String[] SheetName;
	static XSSFWorkbook workbook;
	static int SheetNumber;
	static XSSFSheet spreadsheet;
	static int index = 0;
	static short cellValue;
	static String massa;
	
	public static void main(String[] args) throws IOException {
		configPOI();
		setRowIndex();
		getSheet("SheetFour");
		massa("nome");
		
	}
	
	/********************* CONFIGURA O PROPERTRIES *********************/
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./Data/config.properties");
		props.load(file);
		return props;		
	}
	
	
	/***************************** GETTERS AND SETTERS *****************************/
	public static int getSheetIndex() {
		return SheetIndex;
	}
	public static void setSheetIndex(int sheetIndex) {
		SheetIndex = sheetIndex;
	}
	public static int getRowIndex() {
		return RowIndex;
	}
	public static void setRowIndex() throws IOException {
		RowIndex = Integer.parseInt(getProp().getProperty("prop.row.index"));
	}
	
	
	
	/************************** MANIPULADORES DA PLANILHA **************************/
	
	
	public static void getSheet(String sheet) throws IOException {

		for (int i = 0; i < SheetNumber; i++) {
			
			if(SheetName[i].equals(sheet)) {
				index = i;	
				spreadsheet = workbook.getSheetAt(index);	
			} 
					
		}
//		System.out.println(spreadsheet.getRow(1).getCell(0));
		cellValue = spreadsheet.getRow(0).getLastCellNum();
		
//		CENFERIR REDUDANCIA COM A VARIAVEL INDEX
		setSheetIndex(index); 
	}
	
	
/************************ RETORNA OVALOR DESEJADO ************************************/
	public static String massa(String texto) {
		
		
		for(int i = 0; i < cellValue; i++) {	
			if(texto.equals(spreadsheet.getRow(0).getCell(i).getStringCellValue())){
				massa = spreadsheet.getRow(RowIndex).getCell(i).getStringCellValue();
				System.out.println(texto + " : " + massa);
			}	
		}
		return massa;
	}
	
	
	
	/****************************** FAZ A CONFIGURACAO INICIAL DO POI 
	 * @return **************/
	public static String[] configPOI() throws IOException {
		FileInputStream fis = new FileInputStream(new File(getProp().getProperty("prop.set.data")));
		workbook = new XSSFWorkbook(fis);
		SheetNumber = workbook.getNumberOfSheets();
		System.out.println("numero da Aba :" + SheetNumber);
		SheetName = new String[SheetNumber];
		for (int i = 0; i < SheetNumber; i++) {
			SheetName[i] =  workbook.getSheetName(i);
		}
		
		return SheetName;
		
	}
	
	
	
	

	
}

