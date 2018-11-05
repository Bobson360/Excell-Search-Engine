package com.br.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Teste {
	public static String teste;
	
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
	
	public static void main(String[] args) throws IOException {
				
		
		Properties prop = getProp();
		
		teste  = prop.getProperty("prop.test.auto");
		
		if(Boolean.valueOf(teste)) {
			playAllTests();
		}else if(!Boolean.valueOf(teste)) {
			playSomeoneTest();
		}
				
	}
	
	public static void playAllTests() {
		System.out.println("Run All Tests...");
	}
	
	public static void playSomeoneTest() {
		System.out.println("Run Someone Test...");
	}

}
