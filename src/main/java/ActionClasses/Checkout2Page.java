package ActionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout2Page {

	WebDriver driver;
	
	//Locators
	By FinishCheckout = By.xpath("//a[text()='FINISH']");
	
	
	public Checkout2Page(WebDriver driver) {
	this.driver=driver; 
	}
	
	public void clickOnFinishCheckout() {
		driver.findElement(FinishCheckout).click();
	}
}
