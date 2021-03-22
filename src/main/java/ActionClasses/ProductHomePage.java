package ActionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductHomePage {
	WebDriver driver;
	

	public ProductHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	By MenuOption=By.xpath("//button[text()='Open Menu']");	
	By Logout=By.xpath("//a[text()='Logout']");
	By ResetApp=By.xpath("//a[text()='Reset App State']");
	By ClosePanel=By.xpath("//button[text()='Close Menu']");
	By productSortDropdown=By.xpath("//select[@class='product_sort_container']");
	By ProductDetail_AddToCartIcon = By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']");
	
	
	
	public String clickOnMultipleProductAddToCart(String productname[]) throws InterruptedException {
		
		for(int i=0;i<productname.length;i++) {
			driver.findElement(By.xpath("//div[contains(text(),'"+productname[i]+"')]/ancestor::div[@class='inventory_item']//button")).click();
			Thread.sleep(2000);
		}
		return null;
		
	}
	
	public void logout() {
		driver.findElement(MenuOption).click();
		driver.findElement(Logout).click();
	}
	public void ResetApp() {
		driver.findElement(MenuOption).click();
		driver.findElement(ResetApp).click();
		driver.findElement(ClosePanel).click();
		driver.navigate().refresh();
	}
	
	public void sortProducts(String SortingValue) {
		Select selects=new Select(driver.findElement(productSortDropdown));
		selects.selectByVisibleText(SortingValue);
	}
	
	public void clickOnAddToCartIcon() {
		driver.findElement(ProductDetail_AddToCartIcon).click();
	}
	
}
