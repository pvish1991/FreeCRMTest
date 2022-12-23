package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath= "//*[contains(text(), 'patelsco')]")
	WebElement userNameLable;
	
	@FindBy (xpath ="//span[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath ="//span[contains(text(), 'Companies')]")
	WebElement CompaniesLink;
	
	@FindBy (xpath ="//span[contains(text(), 'Deals')]")
	WebElement DealsLink;
	
	@FindBy (xpath ="//span[contains(text(), 'Documents')]")
	WebElement DocumentsLink;
	
	@FindBy (xpath = "//button[contains(text(), 'Create')]")
	WebElement NewContactsLink;
	
	
	//Initializing the Page Objects 
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectuserName() {
			return userNameLable.isDisplayed();
		}
		
		public ContactsPage clickOnContactsLink() {
			contactsLink.click();
			return new ContactsPage();
			
		}
			
			public DealsPage clickOnDealsLink() {
				DealsLink.click();
				return new DealsPage();
			}
			
			public CompaniesPage clickOnCompaniesLink() {
				CompaniesLink.click();
				return new CompaniesPage();	
			}
			
			public DocumentsPage clickOnDocumentsLink() {
				DocumentsLink.click();
				return new DocumentsPage();
			}
			
			public NewContactsPage ClickOnNewContactsLink() {
				NewContactsLink.click();
				return new NewContactsPage();
				
			}
		}


