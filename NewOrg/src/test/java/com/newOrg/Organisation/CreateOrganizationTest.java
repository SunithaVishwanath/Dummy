package com.newOrg.Organisation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.NewOrg.ObjectRepository.EditOrgPage;
import com.NewOrg.ObjectRepository.HomePage;
import com.NewOrg.ObjectRepository.Loginpage;
import com.NewOrg.ObjectRepository.OranisationPage;
import com.NewOrg.ObjectRepository.OrganisationVerify;
import com.crm.GenericUtility.ExcelUtility;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		WebDriver driver=null;

		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		/*
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Common.properties");
		Properties properties=new Properties();
		properties.load(fis);
		 */

		String BROWSER = fLib.getPropertyValue("browser");
		String URL = fLib.getPropertyValue("url");
		String UN = fLib.getPropertyValue("username");
		String PW = fLib.getPropertyValue("password");



		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();*/

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
		int randnum=jLib.getRandomNum();

		//to fetch the excel values
		String orgName = eLib.getDataFromExcel("Organisation", 2, 1)+randnum;
		String industry = eLib.getDataFromExcel("Organisation", 1, 2);
		String type = eLib.getDataFromExcel("Organisation", 2, 3);

		//enter the url
		driver.get(URL);

		//maximize the browser
		wLib.maximizeTheBrowser(driver);


		//implicit wait
		wLib.waitTillPageGetsLoad(driver);


		//calling login page
		Loginpage lgn=new Loginpage(driver);
		lgn.LogintoAdd(UN, PW);

		//clicking on Organisation link
		HomePage homepage = new HomePage(driver); 
		homepage.getOrgName().click();

		//
		OranisationPage orgClick=new OranisationPage(driver);
		orgClick.getOrgLkpImg().click();
		
		EditOrgPage editorgpage = new EditOrgPage(driver);
		editorgpage.setOrgnametext(orgName);
		
		editorgpage.selectindustryDrop(industry);
		editorgpage.selecttypeDrop(type);
		editorgpage.getSaveBtn().click();

		OrganisationVerify Verifi=new OrganisationVerify(driver);
		String text = Verifi.getVerify().getText();
		
		if(text.contains(orgName))
		{
			System.out.println("Organisation is created");
		}
		else
		{
			System.out.println("Organisation is not created");
		}

		lgn.Logout(driver);
	}

}
