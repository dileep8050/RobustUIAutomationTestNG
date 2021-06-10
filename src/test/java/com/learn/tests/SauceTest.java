package com.learn.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learn.annotations.FrameworkAnnotation;
import com.learn.enums.CategoryType;
import com.learn.pages.SauceHomePage;
import com.learn.pages.SauceLoginPage;
import com.learn.reports.ExtentLogger;


public final class SauceTest extends BaseTest{
	private SauceTest() {}
	
	@FrameworkAnnotation(author= {"Dileep","Tanav"}, category={CategoryType.REGRESSION,CategoryType.SANITY})
	@Test(dataProvider ="LoginDetails" ,groups= {"reg","sanity"})
	public void loginLogoutSaucePortal(String username, String password)
	{
		ExtentLogger.info("loginLogoutSaucePortal test started with test data Username: "+username+" and Password : "+password);
		SauceLoginPage slp=new SauceLoginPage();
		slp.enterUsername(username).getPassword(password).clickLoginButton();
		SauceHomePage shp=new SauceHomePage();
		shp.getcart().isDisplayed();	
	}
	
	@DataProvider(name="LoginDetails",parallel=true)
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="standard_user";
		obj[0][1]="secret_sauce";
		
		obj[1][0]="problem_user";
		obj[1][1]="sdfasfdas";
		
		obj[2][0]="performance_glitch_user";
		obj[2][1]="secret_sauce";
		return obj;
	}
	
	@FrameworkAnnotation(author= "Dileep", category=CategoryType.SMOKE)
	@Test(groups= {"smoke"})
	public void test3()
	{
		SauceLoginPage slp=new SauceLoginPage();
		slp.enterUsername("standard_user").getPassword("secret_sauce").clickLoginButton();
		SauceHomePage shp=new SauceHomePage();
		shp.getcart().isDisplayed();
	}
	
	@FrameworkAnnotation(author= "Tanav", category=CategoryType.SMOKE)
	@Test(groups= {"smoke"})
	public void test4()
	{
	ExtentLogger.info("Using annotatin abc");
	}
	
	@FrameworkAnnotation(author= "Tanav", category=CategoryType.REGRESSION)
	@Test(groups= {"reg"})
	public void test5()
	{
	ExtentLogger.info("Using annotatin def");
	}
	
}
