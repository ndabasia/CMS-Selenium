package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentBuilder {
	private static WebElement element = null;
	
	public static WebElement workflowDiagram(WebDriver driver){
		element = driver.findElement(By.id("page_x002e_progress-status_x002e_mintel-editor_x0023_default"));
		return element;
		}
	
	public static WebElement titleText(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"contentbuilderContainer\"]//*/h1"));
		return element;
		}
	
	public static WebElement inlineCommentSpeech(WebDriver driver){
		element = driver.findElement(By.id("add-inline-comment-button"));
		return element;
		}
	
	public static WebElement commentBox(WebDriver driver){
		element = driver.findElement(By.id("reply-field"));
		return element;
		}
	
	public static WebElement saveCommentButton(WebDriver driver){
		element = driver.findElement(By.id("save-comment"));
		return element;
		}
	
	public static WebElement commentsButton(WebDriver driver){
		element = driver.findElement(By.cssSelector("button[class$='comment']"));
		return element;
		}
	
	public static WebElement commentBody(WebDriver driver){
		element = driver.findElement(By.className("inline-comment-body"));
		return element;
		}
	
	public static WebElement commentDropdown(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"comments-list-view\"]/div/div[1]/div[3]/div[1]/div/div[3]"));
		return element;
		}
	
	public static WebElement deleteButton(WebDriver driver){
		element = driver.findElement(By.name("delete"));
		return element;
		}
	
	public static WebElement confirmDelete(WebDriver driver){
		element = driver.findElement(By.id("yui-gen0-button"));
		return element;
		}
	
	public static WebElement deleteMessage(WebDriver driver){
		element = driver.findElement(By.className("bd"));
		return element;
		}
	}