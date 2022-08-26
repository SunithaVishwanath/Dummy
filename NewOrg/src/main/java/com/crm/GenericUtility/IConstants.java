package com.crm.GenericUtility;

public interface IConstants {

	String filepath = "./src/test/resources/Common.properties";
	String excelPath = "./src/test/resources/ExcelData.xlsx";
	String chromeKey = "WebDriver.chrome.driver";
	String chromeValue = "/Automation/driver/chromedriver.exe";
	String DbUrl = "jdbc:mysql://localhost:3306";
	String DBUsername="root";
	String DBPassword="root";
	int implicitlyWaitDuration=10;
	int explicitlyWaitDuration=10;
}
