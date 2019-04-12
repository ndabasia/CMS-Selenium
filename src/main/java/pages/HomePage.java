package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private static WebElement element = null;
	
	public static WebElement dashboardTitle(WebDriver driver){
		element = driver.findElement(By.id("HEADER_TITLE"));
		return element;
		}
	
	public static WebElement siteTypeDropDown(WebDriver driver){
		element = driver.findElement(By.xpath("//*[contains(@id, 'default-toolbar')]//*/i"));
		return element;	
		}
	
	public static WebElement contentSite(WebDriver driver){
		element = driver.findElement(By.xpath("//*[contains(@id, 'default-toolbar')]/form/div/div[1]/div/div[2]/div[1]"));
		return element;	
		}
	
	public static WebElement hubTable(WebDriver driver){
		element = driver.findElement(By.xpath("//*[contains(@id, 'default-reports')]"));
		return element;	
		}
	}