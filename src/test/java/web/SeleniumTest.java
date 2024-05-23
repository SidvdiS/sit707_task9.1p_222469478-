package web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFullWorkflow() throws InterruptedException {
        //Navigate to Login Page
        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Login")).click();
        
        Thread.sleep(1000); 
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

        //Attempt wrong Login
        driver.findElement(By.id("username")).sendKeys("wrongUser");
        Thread.sleep(500); 
        driver.findElement(By.id("passwd")).sendKeys("wrongPass");
        Thread.sleep(500); 
        driver.findElement(By.id("dob")).sendKeys("1999-05-10");
        Thread.sleep(500); 
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(500); 
 
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        assertTrue(driver.getPageSource().contains("Incorrect credentials."));

        //Attempt Correct Login
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("dob")).clear();

        driver.findElement(By.id("username")).sendKeys("siddharth");
        Thread.sleep(500); 
        driver.findElement(By.id("passwd")).sendKeys("sid_pass");
        Thread.sleep(500); 
        driver.findElement(By.id("dob")).sendKeys("1999-05-10");
        Thread.sleep(500); 
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(500); 

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));

        //Attempt wrong case
        initInputHelper("","2","3");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        assertTrue(driver.getPageSource().contains("All fields are required."));

        //Attempt right case
        initInputHelper("1","2","3");
      
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));

        //Attempt wrong case
        initInputHelper("a","3","2");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        assertTrue(driver.getPageSource().contains("All inputs must be valid numbers."));

        //Attempt right case
        initInputHelper("5","3","2");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));

        //Attempt wrong case
        initInputHelper("","4","12");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        assertTrue(driver.getPageSource().contains("All fields are required."));

        //Attempt right case
        initInputHelper("3","3","9");

        Assert.assertTrue(driver.getCurrentUrl().contains("/success"));
    }
    
    public void initInputHelper(String num1, String num2, String result) throws InterruptedException {
        driver.findElement(By.id("number1")).sendKeys(num1);
        Thread.sleep(500); 
        driver.findElement(By.id("number2")).sendKeys(num2);
        Thread.sleep(500); 
        driver.findElement(By.id("result")).sendKeys(result);
        Thread.sleep(500); 
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(500); 
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
