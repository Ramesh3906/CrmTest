package com.crm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.TestBase.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement signBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String LoginCheck(String uname,String pass){
		username.sendKeys(uname);
		password.sendKeys(pass);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signBtn.click();
		return driver.getTitle();
		
		
		
	}

}
