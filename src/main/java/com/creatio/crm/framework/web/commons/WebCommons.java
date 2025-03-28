package com.creatio.crm.framework.web.commons;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilies.PropUtil;

public class WebCommons {
	
	// This class will have all the common methods related to web automation using selenium
	
	
	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = PropUtil.readData("Config.properties");
	
	// Method to launch the application
	public void launchApplication() {
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
}
