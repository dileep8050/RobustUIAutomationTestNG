package com.learn.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.learn.driver.DriverManager;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
	public static String getBase64Image()
	{
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
