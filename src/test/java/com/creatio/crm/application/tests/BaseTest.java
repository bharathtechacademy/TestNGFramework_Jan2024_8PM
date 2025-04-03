package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilies.ExcelUtil;

public class BaseTest extends BasePage {
	
	public CookiesPageSteps cookiesPage =null;
	public LoginPageSteps loginPage = null;
	public SignUpPageSteps signUpPage = null;
	public HomePageSteps homePage = null;
	
	@BeforeMethod(alwaysRun=true, dependsOnMethods="setupBrowser")
	public void initializePageObjects() {
		WebDriver driver = new BasePage().getDriver();
		cookiesPage = new CookiesPageSteps(driver);
		loginPage = new LoginPageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);
		homePage = new HomePageSteps(driver);
	}
	
	@DataProvider(name="data")
	public String [][] testData(Method method){
		String [][] data = ExcelUtil.readExcelData("TestData.xlsx", method.getName());
		return data;
	}

}
