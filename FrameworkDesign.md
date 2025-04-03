package snippet;

public class Snippet {
	Framework Design - Step by Step
	===============================
	
	Step 1. Creating simple maven project 
	
	Step 2. Based on project requirements , we need to add required maven dependencies and plugins in the pom.xml
	
	Dependencies:
	
			<!-- testng for framework support-->
			<dependency>
				<groupId>org.testng</groupId>
				<artifactId>testng</artifactId>
				<version>7.4.0</version>
			</dependency>
	
	        <!--selenium-java for web automation-->
			<dependency>
				<groupId>org.seleniumhq.selenium</groupId>
				<artifactId>selenium-java</artifactId>
				<version>4.29.0</version>
			</dependency>
	
	        <!-- commons-io for file operations-->
			<dependency>
				<groupId>commons-io</groupId>
				<artifactId>commons-io</artifactId>
				<version>2.18.0</version>
			</dependency>
	
			<!-- extentreports to generate the test results report-->
			<dependency>
				<groupId>com.aventstack</groupId>
				<artifactId>extentreports</artifactId>
				<version>3.0.0</version>
			</dependency>
	
	        <!-- postgresql to connect with database-->
			<dependency>
				<groupId>org.postgresql</groupId>
				<artifactId>postgresql</artifactId>
				<version>42.7.5</version>
			</dependency>
	
	        <!-- pdfbox to read pdf files-->
			<dependency>
				<groupId>org.apache.pdfbox</groupId>
				<artifactId>pdfbox</artifactId>
				<version>2.0.29</version>
			</dependency>
	
	        <!-- poi-ooxml to read excel-->
			<dependency>
				<groupId>org.apache.poi</groupId>
				<artifactId>poi-ooxml</artifactId>
				<version>5.4.0</version>
			</dependency>
	
			<dependency>
				<groupId>org.apache.poi</groupId>
				<artifactId>poi</artifactId>
				<version>5.4.0</version>
			</dependency>
	
	        <!-- rest-assured to automate APIs-->
	        <dependency>
	            <groupId>io.rest-assured</groupId>
	            <artifactId>rest-assured</artifactId>
	            <version>5.5.1</version>
	        </dependency>
	
	        <!-- json to build payload / request body-->
	        <dependency>
	            <groupId>org.json</groupId>
	            <artifactId>json</artifactId>
	            <version>20250107</version>
	        </dependency>
	
	        <!-- ApacheJMeter_core for api performance testing -->
	        <dependency>
	            <groupId>org.apache.jmeter</groupId>
	            <artifactId>ApacheJMeter_core</artifactId>
	            <version>5.6.3</version>
	        </dependency>
	
	        <dependency>
	            <groupId>org.apache.jmeter</groupId>
	            <artifactId>ApacheJMeter_http</artifactId>
	            <version>5.6.3</version>
	        </dependency>
	
	        <dependency>
	            <groupId>org.freemarker</groupId>
	            <artifactId>freemarker</artifactId>
	            <version>2.3.34</version>
	        </dependency>
	
	Plugins:
	
	maven-compiler-plugin to specify the version of JDK we have used in our local and to be used to run the scripts
	maven-surefire-plugin to specify which file we want to run
	
	<build>
			<pluginManagement>
				<plugins>
	
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.13.0</version>
						<configuration>
							<source>17</source>
							<target>17</target>
						</configuration>
					</plugin>
	
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-surefire-plugin</artifactId>
						<version>3.5.2</version>
						<configuration>
							<suiteXmlFiles>src/main/java/test/${fileName}.java</suiteXmlFiles>
						</configuration>
					</plugin>
				</plugins>
			</pluginManagement>
		</build>
	
	
	
	Step 3. Creating the folder structure
	
	Screenshots ==> to maintain all screenshots of failure test cases
	Reports ==> to maintain test results reports
	TestData ==> to maintain test data excel sheets
	Config ==> to maintain all the data related to application and browser configuration property files
	Files ==> to maintain any files like images, pdf’s etc
	TestRunner ==> to maintain all testng test runner /test suite xml files
	
	Step 4. Creating the framework structure 
	
	( adding all packages and classes to maintain utilities and common methods to reduce duplicate code and to reuse the code)
	
	com.creatio.crm.framework.base ==> all classes and common methods related to browsers
	
	com.creatio.crm.framework.web.commons ==> all classes and common methods related to selenium for web automation
	
	com.creatio.crm.framework.api.commons ==> all classes and common methods related to rest-assured, jmeter and api for api automation
	
	com.creatio.crm.framework.db.commons ==> all classes and common methods related to databases for db automation
	
	com.creatio.crm.framework.utilies ==> all classes and common methods related to different utilities like excel, pdf , property file, db etc..
	
	com.creatio.crm.framework.reports ==> all classes and common methods related to html reports to prepare test results
	
	com.creatio.crm.framework.listeners ==> all classes and common methods related to testng listeners 
	
	
	
	Step 5. Creating the application /project structure to implement page object model
	
	com.creatio.crm.application.elements ==> to maintain application page-wise web-elements and locators
	
	com.creatio.crm.application.steps ==> to maintain application page-wise actions/validations/common methods 
	
	com.creatio.crm.application.tests ==> to maintain all the test cases (testng @Test methods) for UI automation
	
	com.creatio.crm.api.pages ==> to maintain feature-wise actions/validations/common methods 
	
	com.creatio.crm.api.tests ==> to maintain all the test cases (testng @Test methods)  related to api automation & api performance test
}

