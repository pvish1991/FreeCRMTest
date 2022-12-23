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
import com.crm.qa.pages.NewContactsPage;

public class DocumentsPageTest extends TestBase {
	
	LoginPage loginPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	CompaniesPage companiesPage;
	DocumentsPage documentsPage;
	HomePage homePage;
	NewContactsPage newContactsPage;
	DocumentsPage newDocumentsPage;
	
	public DocumentsPageTest() {
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
	    documentsPage =homePage.clickOnDocumentsLink();
	    newDocumentsPage = new DocumentsPage();
}
	
	@Test (priority =1)
	public void verifyDocumentsPageLable() {
		Assert.assertTrue(documentsPage.verifyDocumentPage(), "documents lable is missing on the page");
		
	}
	
	@Test (priority =2)
	public void SelectNewDocumentPage() throws InterruptedException {
		newDocumentsPage.selectContactsByName("Create");
		documentsPage.CreateNewDocument( "SoftWare");
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
		

}
