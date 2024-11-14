package org.joyacademy.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;

	public static ExtentReports getReport() {
		
		ExtentSparkReporter report = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\ExtentReportResults.html");
		report.config().setReportName("Demo Extent report");
		report.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Joy");
		
		return extent;
		
	}
	
	
}
