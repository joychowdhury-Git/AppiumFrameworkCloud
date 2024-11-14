package org.joyacademy.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;


public class AppiumUtils {

	//appium-driver is the parent of both Android driver and ios-driver
	AppiumDriver driver;
	
	public AppiumUtils(AppiumDriver driver)
	{
		this.driver = driver;
	}
	

	
	public void waitForElementtoappear(WebElement ele,String pagename)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text",pagename));
	}
	
	public static String getScreeshotPath(String testcase, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		String destination =System.getProperty("user.dir")+"//reports"+testcase+".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		return destination;
		
	}
	
	
}
