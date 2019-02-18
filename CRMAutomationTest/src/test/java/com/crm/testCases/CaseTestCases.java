package com.crm.testCases;

import org.testng.annotations.Test;

import com.crm.Pages.CasePage;
import com.crm.Pages.HomePage;
import com.crm.Pages.LoginPage;
import com.crm.TestBase.TestBase;
import com.crm.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;



import org.testng.annotations.AfterMethod;

public class CaseTestCases extends TestBase {
	
	HomePage HomePageObj=null;
	 public LoginPage LoginObj=null;
	 CasePage CaseObj=null;
	 String SheetName="CaseData";
/*  @Test
  public void verifyCasePageTitle() {
	  String Expected=pro.getProperty("CasePageTitle");
	  //String actual=CaseObj.checkCasePageTitle();
	  assertEquals(CaseObj.checkCasePageTitle(), Expected);
	 	  
  }*/
	 
	 
	 @DataProvider
	  public Object[][] GetCRMData(){
		  Object [][]data=TestUtil.GetTestData(SheetName);
		  return data;
	  }
	  
	  @Test(dataProvider="GetCRMData")
  public void NewCase(String Title_str,String Indetity_str, String tag_str, String Status_str,String type_str,String proprity_str ){
	  CaseObj.clickNewCaseButton();
	  CaseObj.fillCase(Title_str, Indetity_str, tag_str, Status_str, type_str, proprity_str);
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  initialization();
	  LoginObj=new LoginPage();
	  LoginObj.LoginCheck(pro.getProperty("username1"), pro.getProperty("password1"));
	  HomePageObj=new HomePage();
	  TestUtil.switchFrames();
	  CaseObj= HomePageObj.OpencasePage();
		  
  }
  
  

  
  
  @AfterMethod
  public void TearDown(){
	driver.quit();
  }

}
