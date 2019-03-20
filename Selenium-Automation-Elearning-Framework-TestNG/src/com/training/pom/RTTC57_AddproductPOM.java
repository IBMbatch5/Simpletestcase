package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RTTC57_AddproductPOM {
	private WebDriver driver; 
	String SucMsg;
	String Drpdown;
	

	
	public RTTC57_AddproductPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addbt;
	
	@FindBy(id="input-name1")
	private WebElement prodname; 
	
	@FindBy(id="input-meta-title1")
	private WebElement metatag; 
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement datatab;
	
	@FindBy(id="input-model")
	private WebElement model;

	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement linkstab;
	
	@FindBy(id="input-category")
	private WebElement categories;
	
	@FindBy(xpath="//a[contains(text(),'Earrings')]")
	private WebElement earrings;
	//xpath="//a[contains(text(),'Earrings')]")
	//this is for selection of earring
		
	@FindBy (xpath="//a[contains(text(),'Discount')]")
	private WebElement discounttab;
		
	@FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button")
	private WebElement discaddbt;
	
	@FindBy(name="product_discount[0][quantity]")
	private WebElement discQuantity;
	
	@FindBy(name="product_discount[0][price]")
	private WebElement discprice;
	
	
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
	
	public void clickAddbt() {
		this.addbt.click(); 
	}
	
	public void sendProductName(String PN) {
		this.prodname.clear();
		this.prodname.sendKeys(PN);
	}
	
	public void sendMetaTag(String MT) {
		this.metatag.clear();
		this.metatag.sendKeys(MT);
	}
	
	public void clickDatatab() {
		this.datatab.click();
		System.out.println("data tab is selected");
	}
	
	public void sendModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
		
	public void sendQuantity(String Quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(Quantity);
	}	
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
		
	public void clickLinksTab() {
		this.linkstab.click();
		System.out.println("link tab is selected");
	}	
	
	public void clickCategory() {
		this.categories.click();
		this.earrings.click();
		System.out.println("Earring is selected");
	
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
	
	public void sendDiscPrice(String discprice) {
		this.discprice.clear();
		this.discprice.sendKeys(discprice);
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
		/*SucMsg = driver.getPageSource();
		Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified products");
		System.out.println("Assert verification");*/
}
	
	//logout
	public void clickLogout() {
		logout.click();
	}
}
