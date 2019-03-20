package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RTTC56_AdddiscountPOM {
	private WebDriver driver; 
	String SucMsg;
	

	
	public RTTC56_AdddiscountPOM(WebDriver driver) {
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
		
	@FindBy(id="menu-catalog")
	private WebElement catalog;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
	//*[@id="menu-catalog"]/ul/li[2]/a
	private WebElement products;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/div/table/tbody/tr[1]/td[8]/a")
	private WebElement edit;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement datatab;
	
	@FindBy (xpath="//a[contains(text(),'Discount')]")
	private WebElement discounttab;
	
	@FindBy(id="input-quantity")
	private WebElement dataquantity; 
	
	@FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button")
	private WebElement discaddbt;
	
	@FindBy(name="product_discount[0][quantity]")
	private WebElement discQuantity;
	
	@FindBy(name="product_discount[0][price]")
	private WebElement price;
	
	@FindBy(xpath="//input[@placeholder='Date Start']")
	//input[@placeholder='Date Start']
	private WebElement startdate;
	
	@FindBy(xpath="//input[@placeholder='Date End']")
	private WebElement enddate;
			
	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebt;
	
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
	
	public void clickCatalog() {
		this.catalog.click(); 
	}
	
	public void clickProducts() {
		this.products.click(); 
	}
	
	public void clickEdit() {
		this.edit.click(); 
	}
	
	public void clickDatatab() {
		this.datatab.click();
		System.out.println("data tab is selected");
	}
	
	
	public void sendDataQuantity(String DQ) {
		this.dataquantity.clear();
		this.dataquantity.sendKeys(DQ);
	}	
	
	public void clickDiscounttab() {
		this.discounttab.click();
	}
	
	public void clickDiscAddbt() {
		this.discaddbt.click();
	}
	
	public void sendDiscQuantity(String DSQ) {
		this.discQuantity.clear();
		this.discQuantity.sendKeys(DSQ);
	}	
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}	
	
	public void sendStartDate(String Sdate) {
		this.startdate.sendKeys(Sdate);
	}	
	
	public void sendEndDate(String Edate) {
		this.enddate.sendKeys(Edate);
	}
	
	public void clickSaveButton() {
		this.savebt.click();
				
	//assert message
		SucMsg = driver.getPageSource();
		Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified products");
		System.out.println("Assert verification");
}
	
	//logout
	public void clickLogout() {
		logout.click();
	}

}
