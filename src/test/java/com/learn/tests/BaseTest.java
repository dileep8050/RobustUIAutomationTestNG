package com.learn.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ITestAnnotation;

import com.learn.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {}
	
	@BeforeMethod(alwaysRun = true)
	protected void setUp() throws Exception
	{
		Driver.initDriver();

	}
	
	@AfterMethod(alwaysRun = true)
	protected void tearDown()
	{
		Driver.quitdriver();
	}

}
