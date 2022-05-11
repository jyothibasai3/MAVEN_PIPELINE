package com.Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listeners1 implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("onTestStart");
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestsuccess");
			
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailure");	
		
		TakesScreenshot scrn =(TakesScreenshot)Sample.sdriver;
		String dest="C:\\Users\\Welcome\\eclipse-workspace\\TYSS_JYOTHI\\ScreenShort.VtigerFile.png";
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 File destpath = new File(dest);
		 try {
			Files.copy(src, destpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish");	
	}

	
}
