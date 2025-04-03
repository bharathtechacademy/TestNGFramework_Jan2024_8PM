package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilies.PropUtil;

public class WebCommons {
	
	// This class will have all the common methods related to web automation using selenium
	
	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = PropUtil.readData("Config.properties");
	
	// Method to launch the application
	public void launchTheApplication() {
		driver.get(prop.getProperty("url"));
	}
	
	// Method to scroll to element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	// Method to click on the web element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	// Method to click on the hidden element
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	// Method to double click on the web element
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	// Method to enter the text into the text box
	public void enterText(WebElement textbox, String value) {
		scrollToElement(textbox);
		textbox.clear();
		textbox.sendKeys(value);
	}
	
	// method to enter text in textbox using actions class
	public void enterInfo(WebElement textbox, String textValue) {
		scrollToElement(textbox);
		new Actions(driver).sendKeys(textbox, textValue).perform();
	}
	
	//Method to select/deselect the checkbox
	public void checkbox(WebElement checkbox,boolean status) {
		scrollToElement(checkbox);
		if(checkbox.isSelected() !=status) {
			checkbox.click();
		}
	}
	
	// Method to select the option from dropdown
	public void selectOption(WebElement dropdown, String selectBy, String option) {
		scrollToElement(dropdown);
		Select s = new Select(dropdown);
		if(selectBy.equalsIgnoreCase("VisibleText"))
			s.selectByVisibleText(option);
		else if(selectBy.equalsIgnoreCase("value"))
			s.selectByValue(option);
		else if(selectBy.equalsIgnoreCase("Index"))
			s.selectByIndex(Integer.parseInt(option));
	}
	
	// Method to wait
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Method to wait using implicit wait
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	// method to wait using explicit wait - wait for element
	public void waitForElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// method to wait using explicit wait - wait for element
	public void waitForElement(By loactor, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(loactor, 0));
	}
	
	// method to wait using explicit wait - wait for element to be disappeared
	public void waitForElementDisappeared(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// method to take screenshot of window
	public static String takeWindowScreenshot(WebDriver driver, String screenshotNameAndFromat) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotNameAndFromat+".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}

	// method to take screenshot of element
	public static String takeElementScreenshot(WebElement element, String screenshotNameAndFromat) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotNameAndFromat+".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}

	// get element text
	public String getElementText(WebElement element) {
		return element.getText();
	}

	// get element attribute value
	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	// get title of the window
	public String getTitle() {
		return driver.getTitle();
	}

	// check element is displayed
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// check element is enabled
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	// generate unique id
	public String uniqueId(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String uniqueId = sdf.format(Calendar.getInstance().getTime());
		return uniqueId;
	}

	// Method to switch to alert and accept it
	public void switchToAlertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Method to switch to alert and dismiss it
	public void switchToAlertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// Method to get alert text
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	// Method to switch to frame by index
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	// Method to switch to frame by name or ID
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Method to switch to frame using WebElement
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Method to switch back to default content
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Method to get current window handle
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	// Method to get all window handles
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	// Method to switch to a specific window by handle
	public void switchToWindow(String handle) {
		driver.switchTo().window(handle);
	}

	// Method to get the current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	// Method to print messages with in the report
	public void log(String status, String message) {
		if (status.equalsIgnoreCase("pass"))
			Reports.logger.pass(message);
		else if (status.equalsIgnoreCase("fail"))
			Reports.logger.fail(message);
		else if (status.equalsIgnoreCase("warning"))
			Reports.logger.warning(message);
		else if (status.equalsIgnoreCase("info"))
			Reports.logger.info(message);
	}
	
	// Method to add screenshot in report
	public void addScreenshot(WebElement element, String screenshotName) {
		try {
			Reports.logger.addScreenCaptureFromPath(takeElementScreenshot(element, screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
