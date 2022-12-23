package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository (OR):
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//@FindBy(tagName = "Login")
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement Loginlink;
	
	@FindBy(name= "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	//@FindBy(tagName = "Login")
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement LoginBtn;
	
	//@FindBy(tagName = "Sign Up")
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	//Initializing the Page Objects 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String ema, String pwd) throws InterruptedException {
		
		Loginlink.click();
		Thread.sleep(3000);
		email.sendKeys(ema);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	}
	

}