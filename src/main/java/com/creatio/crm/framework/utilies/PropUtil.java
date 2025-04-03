package com.creatio.crm.framework.utilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	
	public static Properties readData(String fileName) {
		Properties prop = new Properties();		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+fileName); //read properties file
			prop.load(fis); //load all properties to 'prop' variable
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 	prop;	
	}

}
