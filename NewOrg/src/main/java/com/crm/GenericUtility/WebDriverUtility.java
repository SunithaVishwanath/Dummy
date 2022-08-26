package com.crm.GenericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author sunit
 *
 */

public class WebDriverUtility {
	/**
	 * to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();

	}
	/**
	 *to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();

	}

	/**
	 * to refresh the page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	/**
	 *to get back to previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	/**
	 *to go to next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	/**
	 * to add implicit wait
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlyWaitDuration));
	}
	
	/**
	 * to add explicit wait and wait till element is clicked
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * to add explicit wait and wait till the element is seen
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * 
	 * @param driver
	 * @param title
	 */
	public void waitTillPageLoadTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));

	}
	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public void waitTillPageLoadURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));

	}
	/**
	 * 
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitForAlertPopupMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}
	/**
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchToFrameUsingID(WebDriver driver, String id) {
		driver.switchTo().frame(id);

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrameWithElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();;

	}

	/**
	 * 
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownByVisibileText(WebElement element, String value) {
		Select selectDropDown = new Select(element);
		selectDropDown.deselectByVisibleText(value);
	}
	
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 */
	public void takesScreenShot(WebDriver driver, String screenShotName) {
		Date d =new Date();
		String currentDate = d.toString().replaceAll(":", "-");

		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+currentDate+screenShotName+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		}catch(Exception e) {
			e.printStackTrace();;
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver) {
		FluentWait wait = new FluentWait(driver);
		wait.ignoring(NoSuchElementException.class);

	}
	/**
	 * 
	 * @param element
	 * @param pollingTime
	 * @param duration
	 */
	public void waitAndClick(WebElement element, long pollingTime, int duration) {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			}catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindowUsingTitle(WebDriver driver, String actualTitle) {
		Set<String> windowList = driver.getWindowHandles();
		for(String window : windowList) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(actualTitle)) {
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindowUsingUrl(WebDriver driver, String actualTitle) {
		Set<String> windowList = driver.getWindowHandles();
		Iterator<String> windowiterator = windowList.iterator();
		while(windowiterator.hasNext()) {
			String window = windowiterator.next();
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if(url.contains(window)) {
				break;
			}
		}
	}
}