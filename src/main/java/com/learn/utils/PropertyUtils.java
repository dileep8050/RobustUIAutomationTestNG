package com.learn.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.learn.constants.FrameworkConstants;


public final class PropertyUtils {
	
	private PropertyUtils () {}
	public static String get(String key) throws Exception
	{
		Properties prop=new Properties();
		
			try {
				FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
				prop.load(fis);
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		
			//Checking input key value is null or not in the same way check the output value also null or not
		if (Objects.isNull(prop.getProperty(key))|| Objects.isNull(key))
		{
			throw new Exception("Property name or Property values "+key+" is not found. Please check config.properties");
		}
		return prop.getProperty(key);
	}

}
