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

public class LoginLogoutTest {

    @Test
    void loginWithAllowLocation() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Deny

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.vamco.dev/login");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thien.pt@mekongpetro.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome12345");

        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vamco.dev/");

        driver.quit();
    }

    @Test
    void logout() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Deny

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        driver.get("https://www.vamco.dev/login");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thien.pt@mekongpetro.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome12345");

        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(5000);

        WebElement username = driver.findElement(By.xpath("//span[contains(@class, 'matero-username')]"));
        actions.moveToElement(username).perform();

        driver.findElement(By.xpath("//i[contains(@class, 'ti-layout-sidebar-left')]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.vamco.dev/login");
        driver.quit();
    }
}
