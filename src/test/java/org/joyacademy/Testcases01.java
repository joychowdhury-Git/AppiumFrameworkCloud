package org.joyacademy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.joyacademy.TestUtils.BaseTest;
import org.joyacademy.pageObjects.android.CartPage;
import org.joyacademy.pageObjects.android.FromPage;
import org.joyacademy.pageObjects.android.ProductCatalog;
import org.joyacademy.utils.Androidactions;
import org.joyacademy.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class Testcases01 extends BaseTest {

	FromPage FP;
	
	@BeforeMethod(alwaysRun = true)
	public void preSetup()
	{
		/*
		 command
		 adb devices
		 adb shell dumpsys window | find "mCurrentFocus"   --- this is to find the activity package and activity name
		 com.androidsample.generalstore-- this is package name    /com.androidsample.generalstore.MainActivity -- this is activity name
		 * */
		
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		
		((JavascriptExecutor)driver).executeScript("mobile:startActivity", ImmutableMap.of("intent",
				"com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}

	@Test(dataProvider ="getData")
	public void E2ETestApplication(String name, String Country) throws Exception
	{	
		//from page
		FP = new FromPage(driver);	
		//Android action class
		Androidactions action = new Androidactions(driver);	
		Thread.sleep(2000);
		FP.setNamefield(name);
		Thread.sleep(2000);
		driver.hideKeyboard(); // this function is to hide the keyboard
		Thread.sleep(2000);
		FP.setGender();
		Thread.sleep(2000);		
		FP.selectcountrydropdown();
		Thread.sleep(2000);	
		action.scrolldown(Country);
		Thread.sleep(2000);	
		FP.selectcountrydropdownvalue();		
		FP.LetsShopbutton();
		Thread.sleep(3000);
		
		//Product catalog page
		ProductCatalog PC = new ProductCatalog(driver);
		Thread.sleep(3000);
		PC.addproduct1();
		Thread.sleep(2000);
		PC.addproduct2();
		PC.addtocart();	
		Thread.sleep(2000);
		
		//Cart page
		CartPage CP= new CartPage(driver);
		//AppiumUtil grandparent class
		AppiumUtils utils = new AppiumUtils(driver);
		utils.waitForElementtoappear(CP.toolbartitle(),"Cart");
			
		String totalamount = CP.totalamount().getText();
		Double finalamount = action.getformattedvalue(totalamount);
		
		AssertJUnit.assertEquals(CP.totalprice(), finalamount);		
		CP.termsbuttonclick();		
		CP.CancelbuttonClick();
		CP.CheckboxClick();
		CP.ProceedButtonClick();		
		Thread.sleep(5000);						
	}
	
	@Test(groups= {"Smoke"})
	public void ToastMessageValidation() throws Exception
	{
		FP = new FromPage(driver);
		FP.LetsShopbutton();		
		Thread.sleep(2000);
		String tmsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(tmsg, "Please enter your name");		
		Thread.sleep(2000);
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][]
				{
			
			{"Joy Chowdhury","Argentina"},
			{"Rriti Chel","Argentina"},
				
				};
	}
			
}
