package com.crm.qa.pages;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath= "//*[contains(text(), 'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(name= "first_name")
	WebElement firstname;
	
	@FindBy(name= "last_name")
	WebElement lastname;
	
	@FindBy(name= "middle_name")
	WebElement middlename;
	
	@FindBy(css = "div[name='company'] input.search")
	WebElement company;
	
	@FindBy(xpath= "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath= "//div[@name='category' and @role='listbox']")
	WebElement selectBtn;
	
	

	
	//Initializing the Page Objects 
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Action
		public boolean verifycontactsLable() {
			return contactsLable.isDisplayed();
		}
		
		public void selectContactsByName(String name) throws InterruptedException {
			driver.findElement(By.className("id")).click();
			Thread.sleep(2000);
		}
		
		public void createNewContact( String ftName, String ltName,String mName , String comp, String ctg) throws InterruptedException {
			firstname.sendKeys(ftName);
			lastname.sendKeys(ltName);
			middlename.sendKeys(mName);
			company.sendKeys(comp);
			saveBtn.click();
			selectBtn.click();
			
			selectBtn.findElement(By.xpath("//span[contains(text(),'"+ctg+"')]")).click();
			WebElement ls= driver.findElement(By.xpath("//div[@name='category' and @role='listbox']//span[contains(text(),'"+ctg+"')]"));
			ls.click();
			
			//Thread.sleep(5000);
			Select select = new Select(driver.findElement(By.xpath("//div[@name='category' and @role='listbox']")));
			select.selectByVisibleText("Lead");
		}
}
