package com.crm.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Pages.ContactPage;
import com.crm.Pages.HomePage;
import com.crm.Pages.LoginPage;
import com.crm.TestBase.TestBase;
import com.crm.util.TestUtil;



public class ContactPageTest extends TestBase{
	
	String SheetName="Contacts";
	HomePage HomeObj=null;
	ContactPage ContactObj=null;
	 
	  @BeforeMethod
	  public void SetUp() {
		  initialization();
		  LoginPage LoginObj= new LoginPage();
		  String str= LoginObj.LoginCheck(pro.getProperty("username1"), pro.getProperty("password1"));
		    TestUtil.switchFrames();
		    HomeObj=new HomePage();
		    ContactObj=HomeObj.OpenContactPage();
		 		  
	  }
	  
	   @Test
	  public void VerifyContactLable() {
		  
		  Assert.assertTrue(ContactObj.contactLable());
	  }
	  
	  @Test
	  public void verfiytableselected(){
				  ContactObj.tablechecked("Soumya Hiremath");
	  }
	  
	  @DataProvider
	  public Object[][] GetCRMData(){
		  Object [][]data=TestUtil.GetTestData(SheetName);
		  return data;
	  }
	  
	  @Test(priority=3,dataProvider="GetCRMData")
	  public void CreateTabelDate(String Title,String FirstName,String LastName,String Department,String Company){
			  ContactObj.ClickNewContact();
			  ContactObj.FilleContactDetails(Title, FirstName, LastName, Department,Company);
	  }
	  
	  @AfterMethod
	  public void TearDown() {
		 driver.quit();
	  }

}
