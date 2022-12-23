package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DocumentsPage extends TestBase {
	
	@FindBy(xpath= "//*[contains(text(), 'Documents')]")
	WebElement documentsLable;
	
	@FindBy (xpath = "//button[contains(text(), 'Create')]")
	WebElement NewDocumentLink;
	
	
	
	@FindBy (css = "input[name='title']")
	WebElement TitleLink;
	

	
	@FindBy(xpath= "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	
	
	//Initializing the Page Objects 
			public DocumentsPage() {
				PageFactory.initElements(driver, this);
			}
			
			
			public void selectContactsByName(String name) throws InterruptedException {
				driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
				Thread.sleep(2000);
			}
			
			public boolean verifyDocumentPage() {
				return documentsLable.isDisplayed();
			}
			
			public void CreateNewDocument( String TLink) {
				
				//FloderLink.sendKeys(FLink);
				TitleLink.sendKeys(TLink);
				//TagsLink.sendKeys(TagLink);
				//saveBtn.click();
			}
			

}
