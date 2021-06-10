package com.learn.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	private ExtentReport() {}
	
	private static ExtentReports extent;
	
	
	public static void initExtentReport()
	{
		if(Objects.isNull(extent))
		{
		extent =new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Extent Automation Report");
		spark.config().setDocumentTitle("UI Automation Report");
		spark.config().setReportName("Dileep");
		}
		
	}
	public static void flushReports()
	{
		if(Objects.nonNull(extent))
		{
		extent.flush();
		}
	}
	public static void createTest(String testName)
	{
		ExtentManager.setExtentTest(extent.createTest(testName));
	}

}