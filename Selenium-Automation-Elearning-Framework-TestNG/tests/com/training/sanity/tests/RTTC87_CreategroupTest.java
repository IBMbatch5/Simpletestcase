package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC87_CreategroupPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC87_CreategroupTest {
	private WebDriver driver;
	private String baseUrl;
	private RTTC87_CreategroupPOM creategrpPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	private String SucMsg;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		creategrpPOM = new RTTC87_CreategroupPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs2", dataProviderClass = LoginDataProviders.class)
	public void RTTC87_CreategroupTest(String groupname, String description, String firstname, String lastname, String email, String password, String confirmpassword) {
		
		//login page
		creategrpPOM.sendUserName("admin");
		creategrpPOM.sendLnPassword("admin@123");
		creategrpPOM.clickLoginBtn(); 
		
		//button menu
		creategrpPOM.clickButtonMenu();
		creategrpPOM.clickCustomer();
		creategrpPOM.clickCustomergroup();
		
		//customer group added
		creategrpPOM.clickCustgrAddbt();
		System.out.println("Customer group Add button is clicked");
				
		creategrpPOM.sendgroupname(groupname);
		creategrpPOM.senddescription(description);
		System.out.println("Description is entered from db");
		
		//Yes radio button selection
		creategrpPOM.selectAppropriate();
		creategrpPOM.clickSavebt();
		creategrpPOM.clickCustomer();
		creategrpPOM.clickCustomer();
		creategrpPOM.clickCustomers();
		creategrpPOM.clickCustAddbt();
		//navigated to customer page and add button is clicked
		System.out.println("Customer Add button is clicked");
		creategrpPOM.selectCustgrpdw();
		creategrpPOM.sendFirstname(firstname);
		creategrpPOM.sendLastname(lastname);
		creategrpPOM.sendEmail(email);
		creategrpPOM.sendTelephone("8273225098");
		creategrpPOM.sendPassword(password);
		creategrpPOM.sendConfirmPassword(confirmpassword);
		creategrpPOM.clickSavebt();
		screenShot.captureScreenShot("TC87-Success message");
		
		//assert message
		SucMsg = driver.getPageSource();
		Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified customers");
		System.out.println("Assert verified on success message");
		creategrpPOM.clickLogout();

	}



}
