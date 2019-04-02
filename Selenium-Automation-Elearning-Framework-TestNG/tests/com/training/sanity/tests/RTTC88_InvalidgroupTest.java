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
import com.training.generics.ScreenShot;
import com.training.pom.RTTC88_InvalidgroupPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC88_InvalidgroupTest {
		private WebDriver driver;
		private String baseUrl;
		private RTTC88_InvalidgroupPOM invalidGrpPOM;
		private static Properties properties;
		private ScreenShot screenShot;
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
			invalidGrpPOM = new RTTC88_InvalidgroupPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver);
			// open the browser
			driver.get(baseUrl);
		}

		@AfterMethod
		public void tearDown() throws Exception {
			driver.quit();
		}

		@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
		public void RTTC88_InvalidgroupTest(String userName, String lnpassword, String groupname, String description, String firstname, String lastname, String email, String password, String confirmpassword) {
			//login page
			invalidGrpPOM.sendUserName(userName);
			invalidGrpPOM.sendLnPassword(lnpassword);
			invalidGrpPOM.clickLoginBtn(); 
			
			invalidGrpPOM.clickButtonMenu();
			invalidGrpPOM.clickCustomer();
			invalidGrpPOM.clickCustomergroup();
			
			//customer group added
			invalidGrpPOM.clickCustgrAddbt();
			System.out.println("Customer group Add button is clicked");
					
			invalidGrpPOM.sendgroupname(groupname);
			invalidGrpPOM.senddescription(description);
			System.out.println("Description is entered from db");
			invalidGrpPOM.selectAppropriate();
			
			// save button of group is clicked
			invalidGrpPOM.clickSavebt();
			invalidGrpPOM.clickCustomer();
			invalidGrpPOM.clickCustomer();
			invalidGrpPOM.clickCustomers();
			invalidGrpPOM.clickCustAddbt();
			System.out.println("Customer Add button is clicked");
			invalidGrpPOM.selectCustgrpdw();
			
			//Following are customer add page details
			invalidGrpPOM.sendFirstname(firstname);
			invalidGrpPOM.sendLastname(lastname);
			invalidGrpPOM.sendEmail(email);
			invalidGrpPOM.sendTelephone("8273225098");
			invalidGrpPOM.sendPassword(password);
			invalidGrpPOM.sendConfirmPassword(confirmpassword);
			invalidGrpPOM.clickSavebt();
			screenShot.captureScreenShot("TC87-Success message");
			
			//assert message
			SucMsg = driver.getPageSource();
			Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified customers");
			System.out.println("Assert verified on success message");
			invalidGrpPOM.clickLogout();

		}
}
