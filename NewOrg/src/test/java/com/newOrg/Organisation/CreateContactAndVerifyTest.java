package com.newOrg.Organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAndVerifyTest {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Common.properties");
		Properties properties=new Properties();
		properties.load(fis);*/
		
		String URL = fLib.getPropertyValue("url");
		String UN = fLib.getPropertyValue("username");
		String PW = fLib.getPropertyValue("password");
		String BROWSER = fLib.getPropertyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			//System.setProperty(IConstants.chromeKey, IConstants.chromeValue);//
			 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		//To get the random number
		int randnum= jLib.getRandomNum();
		
		//Enter the url
		driver.get(URL);
		
		
		
		/*
		
		//Enter the username
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		
		//Enter the password
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PW);
		
		//Click on login button
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//Click on contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on create contact lookup
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String fname = eLib.getDataFromExcel("Sheet1", 1, 3)+randnum;
		
		//Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
		
		String lname = eLib.getDataFromExcel("Sheet1", 1, 4)+randnum; 
		
		//Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);
		
		//Click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Get the created contact
		String contact = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contact);
		
		//verify whether contact is created or not
		if(contact.contains(fname))
		{
			System.out.println("Contact is created");
		}
		else
		{
			System.out.println("Contact is not created");
		}
		
		//Move the cursor to admin to logout
		/*WebElement Admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(Admin).perform();
		
		WebElement eleme = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
		wLib.mouseHoverOnElement(driver, eleme);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		*/
	}

}
