package com.crm.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author sunit
 *
 */

public class FileUtility {
	
		public String getPropertyValue(String key) throws IOException {
			FileInputStream fileInputStream = new FileInputStream(IConstants.filepath);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			String value = properties.getProperty(key);
			return value;	
		}

	}

