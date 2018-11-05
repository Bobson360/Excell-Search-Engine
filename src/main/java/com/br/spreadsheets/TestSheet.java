package com.br.spreadsheets;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.br.list.App;
import com.br.list.file.SheetFour;
import com.br.list.file.SheetOne;
import com.br.list.file.SheetThree;
import com.br.list.file.SheetTwo;

public class TestSheet{
	
	static Object[] sheet;
	
	
	
	
	

	public static String teste;
	public static String someone;
	
	//SheetList sheetList = new SheetList();
	
	/**
	 * @return
	 * @throws IOException
	 */
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./Data/config.properties");
		props.load(file);
		return props;		
	}
	
	public static void main(String[] args) throws Exception {
		new SheetOne();
		new SheetTwo();
		new SheetThree();
		new SheetFour();
		
		Properties prop = getProp();
		
		teste  =  prop.getProperty("prop.test.auto");
		someone = prop.getProperty("prop.test.someone");
		
		if(Boolean.valueOf(teste)) {
			playAllTests();
		}else if(!Boolean.valueOf(teste)) {
			playSomeoneTest(someone);
		}
				
	}
	
	public static void playAllTests() throws Exception {
		System.out.println("Run All Tests...");
		
		SheetOne.main();
		SheetTwo.main();
		SheetThree.main();
		SheetFour.main();
		
		System.out.println("Todos os testes executados");
		System.exit(0);
		
	}
	
	public static void playSomeoneTest(String test) throws Exception {
		System.out.println("Run Someone Test...");
		//SheetList.main();
		
		switch(test) {
		case "SheetOne":	
			System.out.println("Run method " + test);
			SheetOne.main();
			break;
		
		case "SheetTwo":
			System.out.println("Run method " + test);
			SheetTwo.main();
			break;
			
		case "SheetThree":
			System.out.println("Run method " + test);
			SheetThree.main();
			break;
			
		case "SheetFour":
			System.out.println("Run method " + test);
			SheetFour.main();
			break;
			
			
			
			
		}
		System.exit(0);
	}

}
