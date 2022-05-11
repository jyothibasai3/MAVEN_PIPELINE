
package com.testng.pac;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshort {
	
	@Test
	public void Screenshort() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
			
		TakesScreenshot scrn =(TakesScreenshot)driver;
		String dest="C:\\Users\\Welcome\\eclipse-workspace\\TYSS_JYOTHI\\ScreenShort.VtigerFile.png";
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 File destpath = new File(dest);
		 Files.copy(src, destpath);
		
	}

}
