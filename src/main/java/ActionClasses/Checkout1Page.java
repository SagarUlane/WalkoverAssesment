package ActionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout1Page {

	WebDriver driver;
	
	//Locators
	By firstnameCheckout = By.xpath("//input[@data-test='firstName']");
	By lastnameCheckout = By.xpath("//input[@data-test='lastName']");
	By postalCodeCheckout = By.xpath("//input[@data-test='postalCode']");
	By continueButtonCheckout = By.xpath("//input[@value='CONTINUE']");
	
	public Checkout1Page(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String fillInCheckoutDetails(String Fname,String Lname,String PostalCode) {
		
		driver.findElement(firstnameCheckout).sendKeys(Fname);
		driver.findElement(lastnameCheckout).sendKeys(Lname);
		driver.findElement(postalCodeCheckout).sendKeys(PostalCode);
		
		driver.findElement(continueButtonCheckout).click();
		
		return null;
	}
	
	
}
