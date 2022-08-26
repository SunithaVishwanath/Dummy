package com.NewOrg.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationVerify {
	
	//Initialization
	public OrganisationVerify(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement Verify;

	//Utilization
	public WebElement getVerify() {
		return Verify;
	}
	
	
}
