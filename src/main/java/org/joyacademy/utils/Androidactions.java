package org.joyacademy.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Androidactions extends AppiumUtils {
	
		AndroidDriver driver;
	
	public Androidactions(AndroidDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}
	
	public void longpressAction(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),"Duration",2000
			    
				));
	}
	
	public void scrolldown(String str)
	{
		driver.findElement
		(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+str+"\"))"));
	}
	
	public void Swipe(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "direction", direction,
			    "percent", 0.25
			    
				));
	}
	
	public void draganddrop(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 839,
			    "endY", 745
			));
	}
	
	
	public Double getformattedvalue(String str)
	{
		Double price = Double.parseDouble(str.substring(1));
		return price;
	}
	

}
