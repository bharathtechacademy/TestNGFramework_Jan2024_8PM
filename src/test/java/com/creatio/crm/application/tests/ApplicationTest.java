package com.creatio.crm.application.tests;

import java.sql.SQLException;

import org.testng.annotations.Test;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;

public class ApplicationTest extends BaseTest{	
	
	@Test(priority=1)
	public void verifyCookiesPopUp() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
	}
	
	@Test(priority=2,dataProvider="data")
	public void verifyCookiesPopUpContent(String content) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.verifyCookiesPopUpContent(content);
	}	
	
	@Test(priority=3)
	public void verifyCookiesPopUpLogos() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.verifyCookiesPopUpLogos();
	}
	
	@Test(priority=4)
	public void verifyCookiesPopUpSelectionButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.verifyCookiesPopUpSelectionButtons();
	}
	
	@Test(priority=5)
	public void verifyCookiesPopUpSwitchButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.verifyCookiesPopUpSwitchButtons();
	}	

	@Test(priority=6)
	public void verifyCookiesPopUpExpandedView() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.clickOnShowDetailsLink();
		cookiesPage.verifyCookiesPopUpExpandedView();
	}
	
	@Test(priority=7)
	public void verifyCookiesSelectionByAllowingCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.selectTheCookiesOption("AllowAll");
		cookiesPage.verifyCookiesPopUpIsClosed();
	}
	
	@Test(priority=8)
	public void verifyCookiesSelectionByDenyingCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.selectTheCookiesOption("Deny");
		cookiesPage.verifyCookiesPopUpIsClosed();
	}
	
	@Test(priority=9)
	public void verifySignUpPage() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.selectTheCookiesOption("AllowAll");
		cookiesPage.verifyCookiesPopUpIsClosed();
		loginPage.clickOnSignUpLink();
		signUpPage.verifySignUpPageIsLaunched();
	}
	
	@Test(priority=10,dataProvider="data")
	public void verifySignUpForNewUserAccount(String user,String pass) throws SQLException {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.selectTheCookiesOption("AllowAll");
		cookiesPage.verifyCookiesPopUpIsClosed();
		loginPage.clickOnSignUpLink();
		signUpPage.verifySignUpPageIsLaunched();
		signUpPage.enterUserDetails(user, pass);
		signUpPage.clickOnContinueButton();
		signUpPage.enterCompanyDetails();
		signUpPage.clickOnSignUpButton();
		homePage.verifySignUpIsSuccessful();
	}
	
	@Test(priority=11,dataProvider="data")
	public void verifyApplicationLogin(String user,String pass) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpisDisplayed();
		cookiesPage.selectTheCookiesOption("AllowAll");
		cookiesPage.verifyCookiesPopUpIsClosed();
		loginPage.enterCredentials(user, pass);
		loginPage.clickOnLoginButton();
		homePage.verifyLoginIsSuccessful();		
	}
}
