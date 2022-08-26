package com.NewOrg.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility{
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="accountname") private WebElement orgNameEdt;

	
	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	public void setorgNameEdt(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
	}
	
	
	

}
