package ActionClasses;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SuccessPage {

	WebDriver driver;
	
	//Locator
	By successMessage = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
	
	public SuccessPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean verifySuccessMessage() {
		Boolean isPresent = driver.findElement(successMessage).isDisplayed();
		
		if(isPresent) {
			Assert.assertEquals(true, true);
			return true;
					}
		return false;
		
	}
	
}
