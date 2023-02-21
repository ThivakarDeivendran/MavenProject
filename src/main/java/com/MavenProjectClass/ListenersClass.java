package com.MavenProjectClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersClass implements ITestListener{
	
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	public ExtentSparkReporter htmlReport;
	
	public void onStart(ITestContext context) {
		htmlReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/MyExtentReport/myreport.html");
		htmlReport.config().setDocumentTitle("Automation Testing");
		htmlReport.config().setReportName("Functional Testing");
		htmlReport.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		extentReport.setSystemInfo("Host Name", "LocalHost");
		extentReport.setSystemInfo("Environment", "QATest");
		extentReport.setSystemInfo("User", "Quality Test Engineer");
	}
	
	public void onTestSuccess(ITestResult testResult)  {
		extentTest = extentReport.createTest(testResult.getName());
		extentTest.log(Status.PASS, "Test Case Pass  :"+ testResult.getName());
	}
	public void onTestFailure(ITestResult testResult) {
		extentTest = extentReport.createTest(testResult.getName());
		extentTest.log(Status.FAIL, "Test Case Fail  :"+ testResult.getName());
	}
	public void onTestSkipped(ITestResult testResult) {
		extentTest = extentReport.createTest(testResult.getName());
		extentTest.log(Status.SKIP, "Test Case Skip  :" + testResult.getName());
	}
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
