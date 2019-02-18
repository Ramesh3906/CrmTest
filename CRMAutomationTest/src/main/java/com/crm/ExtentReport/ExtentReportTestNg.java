package com.crm.ExtentReport;

import java.io.File;  
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 



public class ExtentReportTestNg implements IReporter {
	private ExtentReports extent=null;

	public void generateReport(List<XmlSuite> xmlSuits, List<ISuite> suits, String OutputDirecory) {
		extent=new ExtentReports(OutputDirecory+File.separator+"Extent.html",true);
		
		for(ISuite s:suits){
			Map<String, ISuiteResult> Result=s.getResults();
			for(ISuiteResult rr:Result.values()){
				ITestContext context=rr.getTestContext();
				BuildTestNode(context.getPassedTests(),LogStatus.PASS);
				BuildTestNode(context.getPassedTests(),LogStatus.FAIL);
				BuildTestNode(context.getPassedTests(),LogStatus.SKIP);
			}
		}
		
		extent.flush();
		   extent.close();
	}
	
	private void BuildTestNode(IResultMap tests, LogStatus status){
		
		ExtentTest test;
		if(tests.size()>0){
			
			
			for(ITestResult result:tests.getAllResults()){
				test=extent.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				for(String group:result.getMethod().getGroups())
					test.assignCategory(group);
					if(result.getThrowable()!=null){
						test.log(status,result.getThrowable());
						
					}else{
						test.log(status,"test Has"+status.toString().toLowerCase()+"ed");
					}
					extent.endTest(test);
				
			}
		}
		
	}
	
		private Date getTime(long millis){
			Calendar calender=Calendar.getInstance();
			calender.setTimeInMillis(millis);
			return calender.getTime();
		}


}
