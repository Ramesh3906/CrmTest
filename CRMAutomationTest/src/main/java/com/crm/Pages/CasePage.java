package com.crm.Pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.TestBase.TestBase;

public class CasePage extends TestBase{
	
	@FindBy(id="title")
	WebElement Title;
	
	@FindBy(xpath="//input[@name='identifier']")
	WebElement Identifier;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement Tag;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;
	@FindBy(xpath="//input[@class='button' and @type='submit']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement Status;
	
	@FindBy(xpath="//select[@name='type' and @size='1']")
	WebElement type;
	
	@FindBy(xpath="//select[@name='priority']")
	WebElement proprity;
	
	
	@FindBy(xpath="//a[contains(text(),'New Case')]")
	WebElement NewCase;
	
	@FindBy(xpath="//a[contains(text(),'Cases')]")
	WebElement caseBtn;
	
	public CasePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickNewCaseButton(){
		Actions a=new Actions(driver); 
		a.moveToElement(caseBtn).build().perform();
		NewCase.click();
				
	}
	
	public void fillCase(String Title_str,String Indetity_str,String tag_str,String Status_str,String type_str,String proprity_str){
		Title.sendKeys(Title_str);
		Identifier.sendKeys(Indetity_str);
		Tag.sendKeys(tag_str);
		Select S=new Select(Status);
		S.selectByVisibleText(Status_str);
		S=new Select(type);
		S.selectByVisibleText(type_str);
		S=new Select(proprity);
		S.selectByVisibleText(proprity_str);
		SaveBtn.click();
	}
	
	
	
	
	public String  checkCasePageTitle()
	{
	
	return driver.getTitle();

	}
	
}