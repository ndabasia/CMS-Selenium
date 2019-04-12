package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element = null;
	
	public static WebElement usernameField(WebDriver driver){
		element = driver.findElement(By.name("username"));
		return element;
		}
	
	public static WebElement passwordField(WebDriver driver){
		element = driver.findElement(By.name("password"));
		return element;
		}
	
	public static WebElement loginButton(WebDriver driver){
		element = driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button"));
		return element;
		}
}
