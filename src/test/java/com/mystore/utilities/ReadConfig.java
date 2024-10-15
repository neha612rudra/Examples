package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	public static String BASE_PATH=System.getProperty("user.dir");
	public static String PROPERTY_FILE_PATH=BASE_PATH+"\\Configuration\\config.properties";

	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(PROPERTY_FILE_PATH);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String value=properties.getProperty("baseurl");
		if(value!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("Url not specified in config file...");
		}
	}
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("Browser not specified in config file...");
		}
	}
}
