package ActionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	//Locators
	By uname = By.id("user-name");
	By pword = By.id("password");
	By loginbutton = By.className("btn_action");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//Set User-name and Password and click on Login Button
		
	public void setusername(String struname) {
		driver.findElement(uname).sendKeys(struname);
	}
	
	public void setpassword(String strpword) {
		driver.findElement(pword).sendKeys(strpword);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginbutton).click();
	}
	
	//Below method needs to passed the login credentials from the main method
	
	public void login(String setUsername,String setPassword) {
		
		this.setusername(setUsername);
		this.setpassword(setPassword);
		this.clickLoginButton();
	}
	
}
