package com.creatio.crm.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class TestListener extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		startReporting(testmethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		logger.pass("Test Execution is Successful for Test Case : "+testmethodName);
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		logger.fail("Test Execution is Failed for Test Case : "+testmethodName);
		logger.fail("Test Execution is Failed due to Error : "+result.getThrowable().getLocalizedMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenshot(new BasePage().getDriver(), testmethodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		stopReporting();
	}
	
	public void onTestSkip(ITestResult result) {
		String testmethodName = result.getMethod().getMethodName();
		logger.fail("Test Execution is Skipped for Test Case : "+testmethodName);
		logger.fail("Test Execution is Skipped due to Error : "+result.getThrowable().getLocalizedMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenshot(new BasePage().getDriver(), testmethodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		stopReporting();
	}

}
