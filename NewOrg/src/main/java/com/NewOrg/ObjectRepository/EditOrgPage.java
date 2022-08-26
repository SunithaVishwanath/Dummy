package com.NewOrg.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;

public class EditOrgPage extends WebDriverUtility {
	
	//Initialization
	public EditOrgPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="accountname") private WebElement orgNameText;
	
	@FindBy(name="industry") private WebElement industryDrop;
	
	@FindBy(name="accounttype") private WebElement typeDrop;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]") private WebElement saveBtn;

	//Utilization
	public WebElement getOrgnametext() {
		return orgNameText;
	}

	/*public WebElement getIndustrydrop() {
		return industryDrop;
	}

	public WebElement getAccountdrop() {
		return typeDrop;
	}*/
	
	
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setOrgnametext(String orgname)
	{
		orgNameText.sendKeys(orgname);
	}
	
	public void selectindustryDrop(String industry)
	{
	selectDropDownByValue(industryDrop, industry);
	}
	
	public void selecttypeDrop(String type)
	{
		selectDropDownByValue(typeDrop, type);

	

	
		
	

	 
		
	}
	
}

