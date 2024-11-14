package org.joyacademy.TestUtils;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest
{

	public AppiumDriverLocalService service;
	public AndroidDriver driver;

		
	@BeforeClass(alwaysRun = true)
	public void configureAppium() throws MalformedURLException, Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\joyacademy\\resources\\data.properties");
		prop.load(fis);
		
		
			service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\joych\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(prop.getProperty("ipAddress"))
				.usingPort(Integer.parseInt(prop.getProperty("port")))
				.build();
		
		//service start from eclipse
			service.start();
				
				//Appium Code->Appium Server->Mobile device
				UiAutomator2Options options = new UiAutomator2Options();
				//options.setDeviceName("Joyemulator");
				options.setApp(System.getProperty("user.dir")+"\\src\\main\\java\\org\\joyacademy\\resources\\General-Store.apk");
				//AndroidDriver - it is a class , IOSDriver
				driver = new AndroidDriver(service.getUrl(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("Timeout"))));
	}
	

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
				driver.quit();
		
				//stop the service
				service.stop();
	}

}
