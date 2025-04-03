package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements{
	
	public CookiesPageSteps(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCookiesPopUpisDisplayed() {		
		waitForElement(cookiesHeader, 30);
		log("pass","Cookies Pop-Up is Displayed Successfully");
	}
	
	public void verifyCookiesPopUpContent(String expContent) {
		String actualContent = getElementText(cookiesContent);
		Assert.assertEquals(actualContent, expContent);
		log("pass","Cookies Pop-Up content is Displayed as Expected");
		log("info",actualContent);
	}
	
	public void verifyCookiesPopUpLogos() {
		Assert.assertTrue(isElementDisplayed(creatioLogo));
		log("pass","Creatio logo is Successfully displayed in the Cookies Pop-Up");
		addScreenshot(creatioLogo,"creatioLogo");
		Assert.assertTrue(isElementDisplayed(cookiebotLogo));
		log("pass","Cookie bot logo is Successfully displayed in the Cookies Pop-Up");
		addScreenshot(cookiebotLogo,"cookiebotLogo");		
	}
	
	public void verifyCookiesPopUpSelectionButtons() {
		Assert.assertTrue(isElementDisplayed(allowAllBtn));
		log("pass","Allow All Cookies Selection button is Successfully added in the Cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(allowSelectionBtn));
		log("pass","Allow Selected Cookies button is Successfully added in the Cookies Pop-Up");
		Assert.assertTrue(isElementDisplayed(denyBtn));
		log("pass","Deny Cookies button is Successfully added in the Cookies Pop-Up");
	}
	
	public void verifyCookiesPopUpSwitchButtons() {
		Assert.assertTrue(!isElementEnabled(necessarySwitchtn));
		log("pass","Necessary Cookies Selection Switch-button is Successfully added in the Cookies Pop-Up");
		Assert.assertTrue(isElementEnabled(preferencesSwitchBtn));
		log("pass","Cookies Preferences Switch-button is Successfully added in the Cookies Pop-Up");
		Assert.assertTrue(isElementEnabled(statisticsSwitchBtn));
		log("pass","Cookie Statistics Switch-button is Successfully added in the Cookies Pop-Up");
		Assert.assertTrue(isElementEnabled(marketingSwitchBtn));
		log("pass","Cookies Marketing Switch-button is Successfully added in the Cookies Pop-Up");
	}
	
	public void verifyCookiesPopUpNecessarySwitchButtonIsDisabled() {
		Assert.assertTrue(!isElementEnabled(necessarySwitchtn));
		log("pass","Necessary button is displayed and disabled");
	}
	
	public void selectTheCookiesOption(String option) {
		if(option.equalsIgnoreCase("AllowAll")) {
			click(allowAllBtn);
		}else if(option.equalsIgnoreCase("AllowSelection")) {
			click(allowSelectionBtn);
		}else if(option.equalsIgnoreCase("Deny")) {
			click(denyBtn);
		}
		log("pass","Clicked on the "+option+" button in the Cookies Pop-up");
	}

	public void verifyCookiesPopUpIsClosed() {
		waitForElementDisappeared(cookiesHeader, 30);
		log("pass","Cookies Pop-Up is Closed Successfully");
	}

	public void clickOnShowDetailsLink() {
		click(showDetailsLink);
		log("pass","Cliked on Show Details Link");
	}

	public void verifyCookiesPopUpExpandedView() {
		waitForElement(cookiePopUpExpandedDetails, 10);
		log("pass","Cookies pop-up is Expanded successfully");
	}
}
