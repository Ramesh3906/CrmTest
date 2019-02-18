package com.crm.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.crm.util.TestUtil;

public class TestBase {

	public static WebDriver driver=null;
	public static Properties pro=null;
	public static EventFiringWebDriver eventDriver;
	//public static WebEventListner eventL;
	
	public TestBase(){
		pro=new Properties();
		try {
			FileInputStream src=new FileInputStream("C:\\Users\\ramur\\testing_workplcce\\CRMAutomationTest\\src\\main\\resources\\config\\Config.properties");
			pro.load(src);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void initialization(){
		String browsername=pro.getProperty("Browser");
		System.out.println("Getting propery values is  "+browsername);
		if(browsername.equals("chorme")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramur\\testing_workplcce\\CRMAutomationTest\\src\\main\\resources\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			
			
		}
		
		/* eventDriver = new EventFiringWebDriver(driver);
		  eventL=new WebEventListner();
		  eventDriver.register(eventL);
		  driver=eventDriver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadWaitTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicityLoadWaitTime, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		

}
}
