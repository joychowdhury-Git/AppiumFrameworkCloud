package org.joyacademy.pageObjects.android;

import org.joyacademy.utils.Androidactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FromPage extends Androidactions {
	
	AndroidDriver driver;
	
	public FromPage(AndroidDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement namefield;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleoption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement country;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")
	private WebElement selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShop;
	
	
	//set the namefield value
	public void setNamefield(String str)
	{
		namefield.sendKeys(str);
	}
	
	public void setGender()
	{
		femaleoption.click();
	}
	public void selectcountrydropdown()
	{
		country.click();
	}
	public void selectcountrydropdownvalue()
	{
		selectCountry.click();
	}
	public void LetsShopbutton()
	{
		LetsShop.click();
	}
	
	
}
