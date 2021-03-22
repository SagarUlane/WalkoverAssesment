package TestSuites;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ActionClasses.LoginPage;
import ActionClasses.ProductHomePage;
import ActionClasses.SuccessPage;
import utilities.RunReport;
import utilities.Screenshot;
import ActionClasses.Checkout2Page;
import ActionClasses.Checkout1Page;
import ActionClasses.CartPage;



public class Assesment {

	WebDriver driver;
	Properties properties;
	ActionClasses.LoginPage objloginpage;
	ProductHomePage objprductHomepage;
	CartPage objCartPage;
	Checkout1Page objCheckout1Page;
	Checkout2Page objCheckout2Page;
	SuccessPage objSuccessPage;
	Screenshot objScreenshot;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	RunReport objRunReport;
	public String reportpath= System.getProperty("user.dir")+"\\src\\main\\java\\ExtentReports\\";
	
	@BeforeClass
	public void setup() throws IOException {

		FileInputStream fileinput=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		properties =new Properties();
		properties.load(fileinput);
		String driverpath=properties.getProperty("driverpath");
		String launchURL=properties.getProperty("launchURL");
		System.setProperty("webdriver.gecko.driver",driverpath);
		driver=new FirefoxDriver();
		driver.get(launchURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		objloginpage=new LoginPage(driver);
		objprductHomepage=new ProductHomePage(driver);	
		objCartPage=new CartPage(driver);
		objCheckout1Page=new Checkout1Page(driver);
		objCheckout2Page=new Checkout2Page(driver);
		objSuccessPage=new SuccessPage(driver);
		objScreenshot=new Screenshot(driver);
		objRunReport=new RunReport(driver);
	}
	
	@Test(priority=1)
	public void testcase1() throws InterruptedException, IOException {
		try {
			
			//Login
			objloginpage.login("standard_user","secret_sauce");		
			//Sort by low to High
			objprductHomepage.sortProducts("Price (low to high)");
			//Add 2 Products
			String ProuctList[] = {"Backpack","Bike Light"};
			objprductHomepage.clickOnMultipleProductAddToCart(ProuctList);
			//Logout
			objprductHomepage.logout();
			//Reporting
			objRunReport.LogReport("First Flow", "First Flow Validation",Status.PASS);
		} catch (Exception e) {
			objScreenshot.takeSnapShot();
			objRunReport.LogReport("First Flow", "Exception Occured",Status.FAIL);
		}
	}
	
	@Test(priority=2)
	public void testcase2() throws InterruptedException, IOException {
		try {
			//login
			objloginpage.login("standard_user","secret_sauce");	
			//Reset the App State
			objprductHomepage.ResetApp();
			//Sort by name
			objprductHomepage.sortProducts("Name (A to Z)");
			//Add to Cart 3 products
			String ProuctList[] = {"Backpack","Bike Light","Fleece Jacket"};
			objprductHomepage.clickOnMultipleProductAddToCart(ProuctList);
			//Click on Add to cart and go to detail page
			objprductHomepage.clickOnAddToCartIcon();
			//Remove 1 product and checkout
			objCartPage.removeProductFromCart("Fleece Jacket");
			objCartPage.clickOnCheckout1FromCart();
			//Fill in All details and Finish
			objCheckout1Page.fillInCheckoutDetails("Sagar", "Ulane", "123456");
			objCheckout2Page.clickOnFinishCheckout();
			//Verify Order is successful
			Boolean Result =objSuccessPage.verifySuccessMessage();
			
			if(Result) {
				//Reporting
				objRunReport.LogReport("Second Flow", "Order Placed Successful Validation",Status.PASS);
			}else
				{objRunReport.LogReport("Second Flow", "Order Placed Unsuccessful",Status.FAIL);}
		} catch (Exception e) {
			objScreenshot.takeSnapShot();
			objRunReport.LogReport("Second Flow", "Exception Occured",Status.FAIL);
		}
	}
	
		
	
}
