package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Customer_OnlinePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC27_Customer_Online_Test {
	private WebDriver driver;
	private String baseUrl;
	private Customer_OnlinePOM custOnPOM;
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
		custOnPOM = new Customer_OnlinePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@Test(priority=3)
	public void validLoginTest() {
		custOnPOM.sendUserName("admin");
		custOnPOM.sendPassword("admin@123");
		
		custOnPOM.clickLoginBtn(); 
		custOnPOM.clickButtonMenu();
		custOnPOM.clickReports();
		custOnPOM.clickCustomers();
		custOnPOM.clickCustOnline();
		screenShot.captureScreenShot("RTTC27-Total customer in online");
		custOnPOM.sendCustomerName("shobana rajendran");
		screenShot.captureScreenShot("RTTC27-Customer name entry");
		custOnPOM.clickFilter();
		screenShot.captureScreenShot("RTTC27-filter list");
		String selelist = driver.getPageSource();
		
		//assertion used with ip address 
		Assert.assertTrue(selelist.contains("186"), "122.164.214.186");
		System.out.println("Assert verification - Filtered successfully");
	}
	
	@Test(priority=4)
	public void LogoutTest() {
		custOnPOM.clickLogout(); 
	}
	
	@Test(priority=5)
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
