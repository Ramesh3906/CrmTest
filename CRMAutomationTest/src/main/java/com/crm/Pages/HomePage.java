package com.crm.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.TestBase.TestBase;



public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactBtn;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsBtn;
	
	@FindBy(xpath="//td[contains(text(),'User: Ramesh Patil')]")
	WebElement LoggedUserName;
	
	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement conmpiesBtn;
	
	@FindBy(xpath="//a[contains(text(),'Cases')]")
	WebElement CaseBtn;

	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle(){
		
		return driver.getTitle();
		
	}
	
	public ContactPage OpenContactPage(){
		 
		ContactBtn.click();
		return new ContactPage();
		
	}
	
	public DealsPage OpenDealsPage()
	{
		
		DealsBtn.click();
		return new DealsPage();
	}
	
	public boolean UserNameCorrect(){
		 
		return LoggedUserName.isDisplayed();
		
	}
	
	public CasePage OpencasePage(){
		
		CaseBtn.click();
		return new CasePage();
	}
	

/*	public CompanyPage OpenCompanyPage(){
		conmpiesBtn.click();
		return new CompanyPage();
		
	}*/


}
