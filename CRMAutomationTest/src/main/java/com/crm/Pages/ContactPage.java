package com.crm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;

public class ContactPage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLable;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContact;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactBtn;
	
	@FindBy(name="title")
	WebElement initalName;
	
	@FindBy(id="first_name")
	WebElement FirstName1;
	
	@FindBy(id="surname")
	WebElement LastName1;
	
	@FindBy(id="department")
	WebElement Dept;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']" )
	WebElement Save;
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactLable(){
		return contactLable.isDisplayed();
	}
	
	public void tablechecked(String str){
	driver.findElement(By.xpath("//a[contains(text(),'"+str+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();;
	
	}
	
	public void ClickNewContact(){
		Actions a=new Actions(driver);
		a.moveToElement(ContactBtn).build().perform();
		NewContact.click();
		
	}
	
	public void FilleContactDetails(String inital,String FirstName,String LastName, String Dept1,String company1){
		Select sel=new Select(initalName);
		sel.selectByVisibleText(inital);
		FirstName1.sendKeys(FirstName);
		LastName1.sendKeys(LastName);
		Dept.sendKeys(Dept1);
		
		company.sendKeys(company1);
		Save.click();
		
			
	}
	
}
