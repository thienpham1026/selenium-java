package vamcodev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class TestLoginLogout {

    @Test
    void loginWithAllowLocation() throws InterruptedException {
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Deny

        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("https://www.vamco.dev/login");

        // Wait for 3 seconds
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thien.pt@mekongpetro.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome12345");

        driver.findElement(By.xpath("//button[@type='button']")).click(); // Cách 2

        // Wait for 5 seconds
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vamco.dev/");

        driver.quit();
    }

    @Test
    void logout() throws InterruptedException {
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Deny

        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Assuming driver is already initialized
        Actions actions = new Actions(driver);

        // Navigate to the login page
        driver.get("https://www.vamco.dev/login");

        // Wait for 3 seconds
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thien.pt@mekongpetro.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome12345");

        driver.findElement(By.xpath("//button[@type='button']")).click(); // Cách 2

        // Wait for 5 seconds
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.xpath("//span[@class='matero-username ng-tns-c4055642260-0 ng-star-inserted']"));
        actions.moveToElement(username).perform();

        driver.findElement(By.xpath("//i[@class='ti-layout-sidebar-left ng-tns-c4055642260-0']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vamco.dev/login");
        driver.quit();
    }

}
