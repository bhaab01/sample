package com.automation.selenium;


import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class GoogleSearch {
    static WebDriver driver;
    static Wait<WebDriver> wait;
    @BeforeTest
    public void launchbrowser ()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://www.google.com/");
    }
    @Test
    public void firstPageContainsQAANet()
    {

        //type search query
        driver.findElement(By.name("q")).sendKeys("qa automation\n");

        // click search
        driver.findElement(By.name("btnG")).click();

        // Wait for search to complete
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("resultStats")) != null;
            }
        });
        String x = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(x.contains("qaautomation.net"));
        // Look for QAAutomation.net in the results
        //return .contains("qaautomation.net");
    
    }
    
    @Test 
    public void test1() 
    {
        Assert.assertEquals("abc1", "abc");
    }
    
    
    
    @Test 
    public void test2() 
    {
        Assert.assertEquals("abc", "abc");
    }
    @AfterTest
    public void destroy()
    {
        driver.close();
    }
    /*public static void main(String[] args) {
        

        boolean result;
        try {
            result = firstPageContainsQAANet();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            driver.close();
        }

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }*/

    
}