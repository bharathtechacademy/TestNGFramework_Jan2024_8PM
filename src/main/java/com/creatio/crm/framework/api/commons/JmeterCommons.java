package com.creatio.crm.framework.api.commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.report.config.ConfigurationException;
import org.apache.jmeter.report.dashboard.GenerationException;
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

public class JmeterCommons {
	
	public static void runJMeterScript(String jmxFile) throws IOException, ConfigurationException, GenerationException {
		
			//1. Get the jmeter home path
			String jmeterHome = "src/test/resources/jmeter";
		
			//2. get the path for storing test results
			String resultsFilePath = Paths.get(jmeterHome, "results","TestResults.csv").toString();
			
			//3. Get the jmx file path
			String testPlanPath = Paths.get(jmeterHome, jmxFile).toString();
			
			//4. Get the property file path
			//String propertyFilePath =  Paths.get(jmeterHome, "bin","jmeter.properties").toString();
			String propertyFilePath =System.getProperty("user.dir")+"\\src\\test\\resources\\jmeter\\bin\\jmeter.properties";
			
			//5. Set Jmeter home directory
			JMeterUtils.setJMeterHome(jmeterHome);
			
			//6. Load all Jmeter properties and configurations
			JMeterUtils.loadJMeterProperties(propertyFilePath);
			
			//7. Load Jmeter script file
			File testPlanFile = new File(testPlanPath);
			HashTree  testPlanTree = SaveService.loadTree(testPlanFile);
			
			//8. Collect and Save all the test results coming from JMX file execution
			ResultCollector resultsCollector = new ResultCollector();
			resultsCollector.setFilename(resultsFilePath);
			
			//9. Run the Jmeter Script
			StandardJMeterEngine jmeter = new StandardJMeterEngine();
			testPlanTree.add(testPlanTree.getArray()[0],resultsCollector );
			jmeter.configure(testPlanTree);		
			jmeter.run();
			
			//10. Generate Html report for performance test results
			ReportGenerator report = new ReportGenerator(resultsFilePath,null);
			report.generate();
	}

}
