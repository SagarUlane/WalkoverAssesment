package ActionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;
	
	//Locators
	By CheckoutButton = By.xpath("//a[text()='CHECKOUT']");
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Methods
	public void clickOnCheckout1FromCart() {
		driver.findElement(CheckoutButton).click();
	}
	
	public void removeProductFromCart(String productname) {
		driver.findElement(By.xpath("//div[contains(text(),'"+productname+"')]/ancestor::div[@class='cart_item']//button")).click();
	}
}
