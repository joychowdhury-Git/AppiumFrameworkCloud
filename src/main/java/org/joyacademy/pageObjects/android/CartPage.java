package org.joyacademy.pageObjects.android;

import java.util.List;
import org.joyacademy.utils.Androidactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends Androidactions {
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
			
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement toolbartitle;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement CancelButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement Checkboxclick;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement ProceedButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termbutton;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productlist;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalamount;
	
	public WebElement totalamount()
	{
		return totalamount;
	}
	
	public WebElement toolbartitle()
	{
		return toolbartitle;
	}
	
	public void CancelbuttonClick()
	{
		CancelButton.click();
	}
	public void ProceedButtonClick()
	{
		ProceedButton.click();
	}
	public void CheckboxClick()
	{
		Checkboxclick.click();
	}
	public void termsbuttonclick()
	{
		longpressAction(termbutton);
	}
	
	public List<WebElement> getproductlist()
	{
		return productlist;
	}
	
	public double totalprice()
	{
		int productcount = getproductlist().size();
		double sum = 0;
		
		for(int i=0;i<productcount;i++)
		{
			String amount = getproductlist().get(i).getText();
			Double price = getformattedvalue(amount);
			sum = sum + price;
		}
		return sum;
	}
	
}
