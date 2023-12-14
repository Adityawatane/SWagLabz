package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;


public class ExtentReportManager extends TestBase
{

	
		static ExtentReports report;
		public static ExtentReports getReportInstance1()
		{
			if(report==null)
			{
				String reportName=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
				ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("E:\\NTC\\Eclipse\\Project_Selenium\\Extent Report\\report.html");
				report=new ExtentReports(); 
				report.attachReporter(htmlReporter); 
				report.setSystemInfo("OS","Windows");
				report.setSystemInfo("Environment","SIT");
				report.setSystemInfo("Build Number","102.02.02.126");
				report.setSystemInfo("Browser","chrome"); 
				htmlReporter.config().setDocumentTitle("UI Testing Documents"); 
				htmlReporter.config().setReportName("UI Test Report");
			}
		return report;
	}
}
