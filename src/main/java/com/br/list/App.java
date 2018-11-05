package com.br.list;

import com.br.spreadsheets.SheetList;;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws Exception {
	   new SheetList();
    	    System.out.println(SheetList.getSheetIndex("SheetThree"));
    	    System.out.println(SheetList.countColl());
     }
    
    public static void teste() {
    	//SheetList.getRow(0, 1, 0);
    }
    
}
