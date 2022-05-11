package com.Vtiger.generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFile {

	@Test
	public String readDatafrompropertyfile(String key) throws Throwable    {
		FileInputStream fis = new FileInputStream("C:\\Users\\Welcome\\OneDrive\\Desktop\\File.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
