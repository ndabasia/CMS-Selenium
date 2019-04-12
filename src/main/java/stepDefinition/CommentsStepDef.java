package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.InsightDashlet;
import pages.ContentBuilder;
import pages.HomePage;
import pages.LoginPage;
import testData.Data;
import utilities.DriverUtilities;

public class CommentsStepDef {
    DriverUtilities myDriverUtilities = new DriverUtilities();
    WebDriver driver = myDriverUtilities.getDriver();
	List<WebElement> siteList = new ArrayList<WebElement>();
	WebDriverWait wait = new WebDriverWait(driver, 60);
	Actions action = new Actions(driver);

    @Given("^I have logged in as the correct user$")
    public void login_step() {
        driver.get(Data.TEST);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        LoginPage.usernameField(driver).sendKeys(Data.DEFAULT_USERNAME);
        LoginPage.passwordField(driver).sendKeys(Data.DEFAULT_PASSWORD);
        LoginPage.loginButton(driver).click();
    }
    
    @When("^I choose Site Type as (.*)$")
    public void site_navigation(String siteType) {
    	wait.until(ExpectedConditions.elementToBeClickable(HomePage.siteTypeDropDown(driver)));
    	HomePage.siteTypeDropDown(driver).click();
//    	HomePage.contentSite(driver).click();
    	
    	List<WebElement> siteList = driver.findElements(By.xpath("//*[contains(@id, 'default-toolbar')]/form/div/div[1]/div/div[2]"));
    	
        for (WebElement siteColumn : siteList) {
            List<WebElement> siteRow = siteColumn.findElements(By.tagName("div"));
            
            for (WebElement siteElement : siteRow) {
                String siteTypes = siteElement.getText();
                if (siteTypes.equals(siteType)) {
                	siteElement.findElement(By.xpath("//div[contains(@class, 'item')]")).click();
                }
            }
        }
    }
    
    @And("^I choose (.*) as content type$")
    public void select_content_type(String hubName) {
            List<WebElement> tr_list = HomePage.hubTable(driver).findElements(By.cssSelector("tbody tr"));

            for (WebElement trElement : tr_list) {
                try {
                    List<WebElement> td_list = trElement.findElements(By.tagName("h3"));

                    for (WebElement tdElement : td_list) {
                        String hubTypes = tdElement.getText();
                        if (hubTypes.equals(hubName)) {
                            tdElement.findElement(By.className("theme-color-1")).click();
                        }
                    }
                } catch (org.openqa.selenium.StaleElementReferenceException e) {
                	
                }
            }
        	wait.until(ExpectedConditions.textToBePresentInElement(InsightDashlet.dashboardTitle(driver), hubName));
    }
    
    @And("^I select an insight to add a comment to$")
    public void select_insight() {
        List<WebElement> tr_list = InsightDashlet.insightTable(driver).findElements(By.cssSelector("tbody tr"));

        for (WebElement trElement : tr_list) {
            try {
                List<WebElement> td_list = trElement.findElements(By.tagName("a"));

                for (WebElement tdElement : td_list) {
                    if (tdElement.isEnabled()) {
                        tdElement.findElement(By.xpath("//*[contains(@id, 'yui')]//*/table/tbody//*/a")).click();
                    }
                }
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
            }
        }
    }
    
    @And("^I add a comment$")
    public void add_comment() {
    	wait.until(ExpectedConditions.textToBePresentInElement(ContentBuilder.workflowDiagram(driver), "Create Plan"));
    	action.doubleClick(ContentBuilder.titleText(driver)).perform();
    	wait.until(ExpectedConditions.elementToBeClickable(ContentBuilder.inlineCommentSpeech(driver))).click();
    	wait.until(ExpectedConditions.visibilityOf(ContentBuilder.commentBox(driver))).sendKeys(Data.COMMENT_TEXT);
    	wait.until(ExpectedConditions.elementToBeClickable(ContentBuilder.saveCommentButton(driver))).click();
    }
    
    @Then("^the comment is saved$")
    public void check_comment_saved() {
        ContentBuilder.commentsButton(driver).click();
        wait.until(ExpectedConditions.visibilityOf(ContentBuilder.commentBody(driver))).getText();
        boolean commentText = driver.getPageSource().contains(Data.COMMENT_TEXT);
        Assert.assertTrue(commentText);
    }
    
    @And("^I delete a comment$")
    public void delete_comment() {
    	wait.until(ExpectedConditions.elementToBeClickable(ContentBuilder.commentDropdown(driver))).click();
    	ContentBuilder.deleteButton(driver).click();
    	ContentBuilder.confirmDelete(driver).click();
    }
    
    @Then("^the comment is deleted$")
    public void check_comment_deleted() {
        String actualDeleteMessage = wait.until(ExpectedConditions.visibilityOf(ContentBuilder.deleteMessage(driver))).getText();
        Assert.assertEquals(actualDeleteMessage, Data.DELETE_MESSAGE);
    }
	  
	  @After public void cleanUp() { 
		    driver.quit(); 
		}

}
