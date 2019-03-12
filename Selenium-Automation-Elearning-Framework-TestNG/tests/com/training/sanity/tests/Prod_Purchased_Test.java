package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Prod_PurchasedPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Prod_Purchased_Test {
	private WebDriver driver;
	private String baseUrl;
	private Prod_PurchasedPOM prodPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		prodPOM = new Prod_PurchasedPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	
	@Test
	public void validLoginTest() {
		prodPOM.sendUserName("admin");
		prodPOM.sendPassword("admin@123");
		prodPOM.clickLoginBtn(); 
		prodPOM.clickButtonMenu();
		prodPOM.clickReports();
		prodPOM.clickProducts();
		prodPOM.clickPurchased();
		screenShot.captureScreenShot("RTTC26-Total products purchased");
		prodPOM.clickOrderStatus();
		screenShot.captureScreenShot("RTTC26-Order Status list");
		prodPOM.selectCompleteStatus();
		prodPOM.clickFilter();
		screenShot.captureScreenShot("RTTC26-Complete filter list");
		
	}
	
	@AfterMethod
	public void LogoutTest() {
		prodPOM.clickLogout(); 
		screenShot.captureScreenShot("RTTC26-Admin Homepage");
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
