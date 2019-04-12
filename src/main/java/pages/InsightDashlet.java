package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsightDashlet {
	private static WebElement element = null;
	
	public static WebElement dashboardTitle(WebDriver driver){
		element = driver.findElement(By.id("HEADER_TITLE"));
		return element;
		}
	
	public static WebElement insightTable(WebDriver driver){
		element = driver.findElement(By.className("insights-populate-table"));
		return element;
		}
	}