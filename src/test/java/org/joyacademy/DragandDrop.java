package org.joyacademy;

import org.joyacademy.TestUtils.BaseTest;
import org.joyacademy.utils.Androidactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class DragandDrop extends BaseTest {
	


	@Test
	public void DragDrop() throws InterruptedException
	{	
		//Android action class
		Androidactions action = new Androidactions(driver);	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		action.draganddrop(ele);
		Thread.sleep(5000);
		
		String drop = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(drop,"Dropped!");
	}
	
}
