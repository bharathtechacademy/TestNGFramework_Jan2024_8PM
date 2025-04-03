package com.creatio.crm.framework.utilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static List<Map<String,String>> readData(String fileName,String sheetName){
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
	
		try {
			//Read the excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			
			//Load the file into Excel related class
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			//Read the Sheet by providing sheet name
			XSSFSheet sh = wb.getSheet(sheetName);
			
			//Get the total rows and columns having data
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			
			//Create loops and load all the data into List<Map>
			
			//Start reading data from second row (r=1) till last row
			for(int r=1;r<totalRows;r++) {
				
				//create map for each row and load the data
				Map<String,String> rowData = new HashMap<String,String>();
				
				//start reading each column from first column (c=0) to last column
				for(int c=0; c<totalColumns; c++) {
					String key = sh.getRow(0).getCell(c).getStringCellValue(); //get the column name every time as a key 
					String value = sh.getRow(r).getCell(c).getStringCellValue();//get the value of each row column as value
					rowData.put(key, value);					
				}
				data.add(rowData);				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return data;		
	}
	
	
	//method to store data in Array
	public static String [][] readExcelData(String fileName,String sheetName){
		String [][] data = null;
		
		try {
			//Read the excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			
			//Load the file into Excel related class
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			//Read the Sheet by providing sheet name
			XSSFSheet sh = wb.getSheet(sheetName);
			
			//Get the total rows and columns having data
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			
			//Initialize the Array with length
			data = new String [totalRows-1][totalColumns];
			
			
			
			//Store the data in 2D Array
			for(int r=1; r<totalRows ; r++) {
				for(int c=0;c<totalColumns; c++) {
					data[r-1][c] = sh.getRow(r).getCell(c).getStringCellValue();
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		
		
		
		
		
		
		return data;
	}

}
