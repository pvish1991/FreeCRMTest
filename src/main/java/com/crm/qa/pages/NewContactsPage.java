package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase {
	
	@FindBy (xpath = "//button[contains(text(), 'Create')]")
	WebElement NewContactsLink;
	

	
	
	//Initializing the Page Objects 
			public NewContactsPage() {
				PageFactory.initElements(driver, this);
			}
			//button[contains(text(),'Create')]
			public void selectContactsByName(String name) throws InterruptedException {
				driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
				Thread.sleep(2000);
			}
			
			
}
