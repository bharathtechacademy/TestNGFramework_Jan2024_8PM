package com.creatio.crm.framework.utilies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtil {
	
	public static ResultSet readDb(String query) throws SQLException {
		ResultSet dataSet = null;
		
		Properties prop = PropUtil.readData("Config.properties");
		String db_url= prop.getProperty("db_url");
		String user= prop.getProperty("db_user");
		String pass= prop.getProperty("db_pass");		
		Connection connection = DriverManager.getConnection(db_url, user, pass);
		dataSet = connection.createStatement().executeQuery(query);		
		
		return dataSet;		
	}

}
