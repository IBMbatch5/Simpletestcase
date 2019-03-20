package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RTTC59_AddaffiliatePOM {
	private WebDriver driver; 
	String SucMsg;
	

	
	public RTTC59_AddaffiliatePOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"menu-marketing\"]/ul/li[2]/a")
	private WebElement affiliates;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement addbt;
	
	@FindBy(id="input-firstname")
	private WebElement firstName; 
	
	@FindBy(id="input-lastname")
	private WebElement lastName; 
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-telephone")
	private WebElement telephone; 
	
	@FindBy(id="input-code")
	private WebElement trackingcode; 
	
	@FindBy(id="input-password")
	private WebElement Affpassword; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword; 
	
	@FindBy(id="input-address-1")
	private WebElement address1; 
	
	@FindBy(id="input-address-2")
	private WebElement address2; 
	
	@FindBy(id="input-city")
	private WebElement city; 
	
	@FindBy(id="input-postcode")
	private WebElement postcode; 
	
	@FindBy(id="input-country")
	private WebElement country; 
	
	@FindBy(id="input-zone")
	private WebElement state; 
	
	//payment detail tab
	
	@FindBy(xpath="//*[@id=\"form-affiliate\"]/ul/li[2]/a")
	private WebElement paymentdetails;
	//html/body/div/div/div[2]/div/div[2]/form/ul/li[2]/a
	//*[@id="form-affiliate"]/ul/li[2]/a
	
	
	@FindBy(id="input-cheque")
	private WebElement chequepayeename;
	
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
	
	public void clickMarketing() {
		this.marketing.click(); 
	}
	
	public void clickAffiliates() {
		this.affiliates.click(); 
	}
	
	public void clickAddbt() {
		this.addbt.click(); 
	}
	
	public void sendFirstName(String FNM) {
		this.firstName.sendKeys(FNM);
	}	
	
	public void sendLastName(String LN) {
		this.lastName.sendKeys(LN);
	}
	
	public void sendEmail(String Email) {
		this.email.sendKeys(Email);
	}
	
	public void sendTelephone(String Tele) {
		this.telephone.sendKeys(Tele);
	}
	
	public void sendTrackingcode(String TC) {
		this.trackingcode.sendKeys(TC);
	}
	
	public void sendAffPassword(String PWD) {
		this.Affpassword.sendKeys(PWD);
	}
	
	public void sendConfPassword(String CPWD) {
		this.confirmpassword.sendKeys(CPWD);
	}
	
	public void sendAddress1(String ADD1) {
		this.address1.sendKeys(ADD1);
	}
	
	public void sendAddress2(String ADD2) {
		this.address2.sendKeys(ADD2);
	}
	
	public void sendCity(String city) {
		this.city.sendKeys(city);
	}
	
	public void sendPostcode(String PCD) {
		this.postcode.sendKeys(PCD);
	}
	
	public void selectCountry() throws InterruptedException {
	Select country=new Select (driver.findElement(By.id("input-country")));
	country.selectByVisibleText("India");
	System.out.println("India is selected");
	Thread.sleep(3000);
		
	}	
		
	public void selectZone() {
		Select state=new Select (driver.findElement(By.id("input-zone")));
		state.selectByVisibleText("Tamil Nadu");
		System.out.println("Tamil Nadu is selected");
	}	
		
	public void clickPaymentDetails() {
		this.paymentdetails.click();
	}
	
	public void sendChequePayeeName(String CPN) {
		this.chequepayeename.sendKeys(CPN);
	}
		
	public void clickSaveButton() {
		this.savebt.click();
				
	//assert message
		SucMsg = driver.getPageSource();
		Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified affiliates");
		System.out.println("Assert verified on success message");
}
	
	//logout
	public void clickLogout() {
		logout.click();
	}


}
