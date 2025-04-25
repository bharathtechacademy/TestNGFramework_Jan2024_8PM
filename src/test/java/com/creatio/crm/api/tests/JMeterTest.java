package com.creatio.crm.api.tests;

import java.io.IOException;

import org.apache.jmeter.report.config.ConfigurationException;
import org.apache.jmeter.report.dashboard.GenerationException;
import org.testng.annotations.Test;

import com.creatio.crm.framework.api.commons.JmeterCommons;

public class JMeterTest {
	
	@Test
	public void runApiPerformanceTest() throws IOException, ConfigurationException, GenerationException {
		JmeterCommons.runJMeterScript("PerformanceTest.jmx");
	}

}
