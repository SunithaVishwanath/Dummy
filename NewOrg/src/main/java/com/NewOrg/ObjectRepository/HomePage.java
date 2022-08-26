package com.NewOrg.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="(//a[text()='Organizations'])[1]") private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']") private WebElement contLink;
	
	@FindBy(xpath="(//a[text()='Opportunities'])[1]") private WebElement opLink;
	
	@FindBy(xpath="//a[text()='Products']") private WebElement prodLink;
	
	@FindBy(xpath = "//a[text()='Documents']") private WebElement docLink;
	
	@FindBy(xpath="//a[text()='More']") private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement AdminLink;
	
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement logoutLink;
	
	
	//Utilization
	public WebElement getOrgName() {
		return orgLink;
	}

	public WebElement getContLink() {
		return contLink;
	}

	public WebElement getOpLink() {
		return opLink;
	}

	public WebElement getProdLink() {
		return prodLink;
	}

	public WebElement getDocLink() {
		return docLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getAdminLink() {
		return AdminLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void Logout(WebDriver driver) {
		logoutLink.click();
		
	}

}


/*
 * package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtilities.WebDriverUtility;
/**
 * 
 * @author SanjayBabu
 *
 */

/*
public class HomePage extends WebDriverUtility{
	//WebDriver driver;
	//declaretion
	@FindBy(linkText = "Organizations")
	private WebElement organisationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;

	@FindBy(linkText = "Products")
	private WebElement productsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLnk;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;

	//initialization
	public HomePage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getOrganisationsLnk() {
		return organisationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getAdministratorLnk() {
		return administratorLnk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	
	public void logout(WebDriver driver)
	{                     
		mouseOverAnElement(driver, administratorLnk);
		signoutLnk.click();
	}
}
*/
