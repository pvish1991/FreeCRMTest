package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	CompaniesPage companiesPage;
	DocumentsPage documentsPage;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	}
	//Test Should be Separated or Independent with each other 
	//before each test case --lunch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	    loginPage = new LoginPage();
	    contactsPage = new ContactsPage();
	    dealsPage = new DealsPage();
	    companiesPage = new CompaniesPage();
	    documentsPage = new DocumentsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
	}
	
	@Test (priority =1)
	public void verifyHomePageTitletest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title is not matched");
	}
	
	@Test (priority =2)
	public void verifyuserName() {
		Assert.assertTrue( homePage.verifyCorrectuserName());
	}
	
	@Test (priority =3)
	public void verifyContactsLink() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test (priority =4)
	public void verifyDealsLink() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test (priority =5)
	public void verifyCompaniesLink() {
		companiesPage = homePage.clickOnCompaniesLink();
	}
	
	@Test (priority =6)
	public void verifyDocumentsLink() {
		documentsPage = homePage.clickOnDocumentsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
