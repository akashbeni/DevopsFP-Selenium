package org.test.insureme_selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://54.91.76.136:8081/contact.html");
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement name = driver.findElement(By.name("your_name"));
        WebElement phone = driver.findElement(By.name("phone_number"));
        WebElement email = driver.findElement(By.name("email_address"));
        WebElement ymessage = driver.findElement(By.name("your_message"));
        
        Thread.sleep(2000);
        name.sendKeys("test");
        phone.sendKeys("+1949888999");
        email.sendKeys("abcxyz123@gmail.com");
        ymessage.sendKeys("Hello please insure me");
               
        Thread.sleep(2000);
        
        
        driver.findElement(By.id("my-button")).click();
        
        String message = driver.findElement(By.id("response")).getText();

       // WebElement message = driver.findElement(By.id("message"));
       // message.getText();
       
        //capture screenshot
        
        TakesScreenshot scrShot =  ((TakesScreenshot)driver);
        
        File srcFile = scrShot. getScreenshotAs(OutputType.FILE);
        
        File destFile = new File("insureme.jpg");
        
        FileUtils.copyFile(srcFile, destFile); 
        driver.quit();
    }
}
