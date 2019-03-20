package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RTTC60_SendmailPOM {
	private WebDriver driver; 
	

		
		public RTTC60_SendmailPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="username")
		private WebElement userName; 
		
		@FindBy(name="password")
		private WebElement password;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement loginBtn; 
		
		@FindBy(xpath="//*[@id=\"button-menu\"]")
		private WebElement buttonMenu;
		
		@FindBy(xpath="//li[@id='menu-marketing']")
		private WebElement marketing;
		
		@FindBy(xpath="//a[contains(text(),'Mail')]")
		private WebElement mail;
		
		@FindBy(xpath="//select[@id='input-to']")
		private WebElement toList;
		
		@FindBy(id="input-subject-1")
		private WebElement subjallcust; 
		
		@FindBy(xpath="//*[@id=\"language1\"]/div[2]/div/div/div[3]/div[2]")
		//div[@class='note-editable panel-body']")
		private WebElement msgallcust;
		
		@FindBy(id="button-send")
		private WebElement sendbt;
		
		@FindBy(xpath="//select[@id='input-to']")
		private WebElement toListProd;
		
		@FindBy(id="input-subject-1")
		private WebElement subjProd; 
		
		@FindBy(xpath="//*[@id=\"language1\"]/div[2]/div/div/div[3]/div[2]")
		//div[@class='note-editable panel-body']")
		private WebElement msgProd;
		
		
		
		
		//logout path
		@FindBy(xpath="//*[@id=\"header\"]/ul/li[4]/a")
		private WebElement logout;
		
				
		
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
		
		public void clickButtonMenu() {
			this.buttonMenu.click(); 
		}
		
		public void clickMarketing() {
			this.marketing.click(); 
		}
		
		public void clickMail() {
			this.mail.click(); 
		}
		
		public void selectToList() {
			// to select 'All customer' in TO list
			Select toList=new Select (driver.findElement(By.id("input-to")));
			toList.selectByIndex(1);
			System.out.println("All customers is selected in TO list");
			
		}
		
		public void sendSubjectAllCust(String SAC) {
			this.subjallcust.sendKeys(SAC);
		}
		
		public void sendMsgAllCust(String MAC) {
			this.msgallcust.sendKeys(MAC); 
		}
		
		
		public void clickSendButton() {
			this.sendbt.click();
		}
		
		
		// Now send mail to 'Products'
		
		public void selectToListProd() {
			// to select 'Products' in TO list
			Select toList=new Select (driver.findElement(By.id("input-to")));
			toList.selectByIndex(6);
			System.out.println("Product is selected in TO list");
			
		}
		
		public void sendSubjectProd(String SP) {
			this.subjProd.clear();
			this.subjProd.sendKeys(SP);
		}
		
		public void sendMsgProd(String MP) {
			this.msgProd.clear();
			this.msgallcust.sendKeys(MP); 
		}
		
				
		/*assert message
			SucMsg = driver.getPageSource();
			Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified coupons");
			System.out.println("Assert verified on success message");
		}*/
		
		//logout
		public void clickLogout() {
			logout.click();
		}
}
