package eKartAutoMation.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {
	
	public static void main(String[] args) {
		SoftAssert softAssert=new SoftAssert();
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./report/extent_report.html");
		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(htmlReport);
		ExtentTest extentTest=extentReports.createTest("TEST - 1");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		extentTest.pass("navigate to google page.");
		softAssert.assertEquals("google", driver.getTitle());
		extentTest.pass("text title passes.");
		driver.close();
		extentReports.flush();
	}

}
