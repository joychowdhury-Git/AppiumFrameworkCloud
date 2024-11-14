package org.joyacademy.pageObjects.android;

import org.joyacademy.utils.Androidactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends Androidactions {
	
	AndroidDriver driver;
	
	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")
	private WebElement product1;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")
	private WebElement product2;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart" )
	private WebElement addtocart;
	
	public void addproduct1()
	{
		product1.click();
	}
	public void addproduct2()
	{
		product2.click();
	}
	public void addtocart()
	{
		addtocart.click();
	}
	
	
	

}
