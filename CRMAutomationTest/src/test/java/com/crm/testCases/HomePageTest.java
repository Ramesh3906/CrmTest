package com.crm.testCases;

import org.testng.annotations.Test;

import com.crm.Pages.ContactPage;
import com.crm.Pages.DealsPage;
import com.crm.Pages.HomePage;
import com.crm.Pages.LoginPage;
import com.crm.TestBase.TestBase;
import com.crm.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	  public LoginPage LoginObj=null;
	  public HomePage homeObj=null;
	  
		
		public HomePageTest(){
			super();
		}
	  
		
	@BeforeMethod
	  public void setUp() {
			initialization();
			LoginObj=new LoginPage();
			LoginObj.LoginCheck(pro.getProperty("username1"), pro.getProperty("password1"));
			homeObj=new HomePage();
		  
	  }
	  
	  @Test(priority=1)
	  public void verifyHomePageTitle(){
		  
		  String str=homeObj.HomePageTitle();
		  System.out.println("Home is "+ driver.getTitle());
		  AssertJUnit.assertEquals(str, pro.getProperty("HomePageTitle"));
		
		  
	  }
	  
	  @Test(priority=2)
	  public void verifycontactPageOpen(){
		  TestUtil.switchFrames();
		  ContactPage contctObj= homeObj.OpenContactPage();
		
		  
	  }
	 
	  @Test(priority=1)
	  public void verifyDealsPageOpen(){
		  TestUtil.switchFrames();
		  DealsPage DealObj=homeObj.OpenDealsPage();
		  
		  
	  }
	  
	  
	  @Test(priority=4)
	  public void verfiyLoggedUserName(){
		  TestUtil.switchFrames();
		  AssertJUnit.assertTrue(homeObj.UserNameCorrect());
	  }
	  

	 
	@AfterMethod
	  public void tearDown() {
		 driver.quit();
		 
		  
	  }

}
