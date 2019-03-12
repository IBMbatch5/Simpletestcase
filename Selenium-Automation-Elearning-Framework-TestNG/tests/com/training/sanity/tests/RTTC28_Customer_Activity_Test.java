package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Customer_ActivityPOM;
import com.training.pom.Customer_OnlinePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC28_Customer_Activity_Test {
	private WebDriver driver;
	private String baseUrl;
	private Customer_ActivityPOM custAvtPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@Test(priority=1)
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority=2)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		custAvtPOM = new Customer_ActivityPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@Test(priority=3)
	public void validLoginTest() {
		custAvtPOM.sendUserName("admin");
		custAvtPOM.sendPassword("admin@123");
		
		custAvtPOM.clickLoginBtn(); 
		custAvtPOM.clickButtonMenu();
		custAvtPOM.clickReports();
		custAvtPOM.clickCustomers();
		custAvtPOM.clickCustOnline();
		screenShot.captureScreenShot("RTTC28-Total customer in online");
		custAvtPOM.sendCustomerName("shobana rajendran");
		screenShot.captureScreenShot("RTTC28-Customer name entry");
		//get page title
		String my_title=driver.getTitle();
		System.out.println("Page title="+my_title);
		
		// assert to check page title
		Assert.assertTrue(my_title.contains("Activity Report"));
		System.out.println("Assert condition passed");
		
		custAvtPOM.clickFilter();
		screenShot.captureScreenShot("RTTC28-filter list");
		driver.getCurrentUrl();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//move page down
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		screenShot.captureScreenShot("RTTC28-filter listdown");
		
	}
	
	@Test(priority=4)
	public void LogoutTest() {
		custAvtPOM.clickLogout(); 
	}
	
	@Test(priority=5)
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
