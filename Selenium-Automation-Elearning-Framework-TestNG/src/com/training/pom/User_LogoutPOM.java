package com.training.pom;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_LogoutPOM {
private WebDriver driver; 
	
	public User_LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]")
	private WebElement accountLogin; 
	
	//drop down of login/register
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[1]/a")
	private WebElement accountMenu;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	//Account menu list
	//xpath="//li[@class='tb_link dropdown tb_menu_system_account_account tb_selected']")
	
	//Logout xpath		
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[4]")
	private WebElement logout;
	
	
	public void clickAccountLogin() {
	accountLogin.click();
	}
	
	public void clickAccountMenu() {
		this.accountMenu.click();
	}
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click();
			}

	public void Logout() {
				
		Actions actions = new Actions(driver);
		//link path of mouse over account icon
		WebElement mainMenu = driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account tb_selected']"));
		actions.moveToElement(mainMenu).build().perform();
		driver.findElement(By.linkText("LOGOUT")).click();
		//actions.click().build().perform();
		
	}
		
}
