package com.learn.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.learn.constants.FrameworkConstants;
import com.learn.utils.PropertyUtils;

public final class Driver {
	private Driver() {}

	public static void initDriver() throws Exception
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());

		DriverManager.setDriver(new ChromeDriver());
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(PropertyUtils.get("url"));
		}
	}
	
	public static void quitdriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
