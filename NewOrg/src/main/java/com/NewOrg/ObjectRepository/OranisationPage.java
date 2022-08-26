package com.NewOrg.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OranisationPage {
	
	//Initialization
	public OranisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement orgLkpImg;
	
	//utilization
	public WebElement getOrgLkpImg() {
		return orgLkpImg;
	}
	
	
	

}
