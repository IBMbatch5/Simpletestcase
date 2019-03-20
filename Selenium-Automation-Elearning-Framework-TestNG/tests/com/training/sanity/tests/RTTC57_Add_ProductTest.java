package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC57_AddproductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC57_Add_ProductTest {
	private WebDriver driver;
	private String baseUrl;
	private RTTC57_AddproductPOM addprodPOM;
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
		addprodPOM = new RTTC57_AddproductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		addprodPOM.sendUserName("admin");
		addprodPOM.sendPassword("admin@123");
		addprodPOM.clickLoginBtn(); 
		addprodPOM.clickButtonMenu();
		addprodPOM.clickCatalog();
		addprodPOM.clickProducts();
		addprodPOM.clickAddbt();
		System.out.println("Add button is clicked");
		addprodPOM.sendProductName("Toe rings");
		addprodPOM.sendMetaTag("Toe ring for ladies");
		addprodPOM.clickDatatab();
		addprodPOM.sendModel("SKU-012");
		addprodPOM.sendPrice("500");
		addprodPOM.sendQuantity("50");
		addprodPOM.clickLinksTab();
		addprodPOM.clickCategory();
		addprodPOM.clickDiscounttab();
		addprodPOM.clickDiscAddbt();
		addprodPOM.sendDiscQuantity("1");
		addprodPOM.sendDiscPrice("50");
		addprodPOM.sendStartDate("2019-03-22");
		System.out.println("start date is entered");
		addprodPOM.sendEndDate("2019-03-26");
		System.out.println("End date is entered");
		addprodPOM.clickSaveButton();
		System.out.println("Save button clicked");
		screenShot.captureScreenShot("RTTC57-Products added");
		addprodPOM.clickLogout();
					
	}
}
