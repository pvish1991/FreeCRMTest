package com.crm.qa.testcases;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;
	HomePage  homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	    LoginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = LoginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "Free CRM with Free calling and auto dialing features");
	}
	
	@Test(priority = 2)
	public void crmLogoImagetest() {
		boolean flag = LoginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		homePage = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
