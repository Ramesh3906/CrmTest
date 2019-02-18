package com.crm.testCases;

import org.testng.annotations.Test;

import com.crm.Pages.LoginPage;
import com.crm.TestBase.TestBase;

import com.crm.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;

public class LoginTest extends TestBase{
	public static String SheetName="LoginData";
	
	@DataProvider
	  public Object[][] GetCRMData(){
		  Object [][]data=TestUtil.GetTestData(SheetName);
		  return data;
	  }
	
  @Test(dataProvider="GetCRMData")
   public void VerifyLoginTestData(String uname,String pass) {
	  String actualtitle="CRMPRO";
	  LoginPage lo=new LoginPage();
	String title= lo.LoginCheck(uname, pass);
		
	System.out.println("Page Title "+title );
		assertEquals(actualtitle, title);
		  
  }

  
  @BeforeMethod
  public void Setup() {
	  initialization();  
	  
  }

  @AfterMethod
  public void TearDown() {
	  driver.quit();
  }

}
