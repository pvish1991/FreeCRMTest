/*
 * 
 * @vishal book
 */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class ConatactsPageTest extends TestBase {
	
	LoginPage loginPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	CompaniesPage companiesPage;
	DocumentsPage documentsPage;
	HomePage homePage;
	NewContactsPage newContactsPage;
	
	String sheetName ="contacts";
	
	public ConatactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	    loginPage = new LoginPage();
	    contactsPage = new ContactsPage();
	    dealsPage = new DealsPage();
	    companiesPage = new CompaniesPage();
	    documentsPage = new DocumentsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    contactsPage = homePage.clickOnContactsLink();
	    newContactsPage = new NewContactsPage();
}
	
	@Test (priority =1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifycontactsLable(), "contacts lable is missing on the page");
	}
	
	/*@Test (priority =2)
	public void selectcontactsTest() throws InterruptedException {
		contactsPage.selectContactsByName("rama rao");
	}*/
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority =2, dataProvider ="getCRMTestData")
	public void selectNewcontactspage(String firstName, String lastName, String middleName, String company, String Category) throws InterruptedException {
		newContactsPage.selectContactsByName("Create");
		//contactsPage.createNewContact("xyz", "YYY", "xx", "TD","Lead");
		contactsPage.createNewContact(firstName, lastName, middleName, company, Category);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
