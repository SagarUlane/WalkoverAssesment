package utilities;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class RunReport {

	WebDriver driver;
	Screenshot objScreenshot;
	ExtentHtmlReporter htmlreporter =new ExtentHtmlReporter("./src/main/java/ExtentReports/ExtentReportResults.html");
	ExtentReports extent = new ExtentReports();
	
	
	public RunReport(WebDriver driver) {
	this.driver=driver;
	}
	
	public void LogReport(String testname,String description,Status givenstatus) throws IOException {
		objScreenshot=new Screenshot(driver);
		extent.attachReporter(htmlreporter);
		ExtentTest logger = extent.createTest(testname, description);
		logger.log(givenstatus, description);
		String Dest= objScreenshot.takeSnapShot();
		logger.addScreenCaptureFromPath(Dest);
		
		extent.flush();
	}
}
