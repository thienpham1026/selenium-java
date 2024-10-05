package letronio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLogin {

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

        // Navigate to the login page
        driver.get("https://www.letron.io/login");

        // Wait for 3 seconds
        Thread.sleep(3000);

        driver.findElement(By.id("iduserName")).sendKeys("thien.pt@katsuma.asia");
        driver.findElement(By.id("idpassword")).sendKeys("Thien_%Q8k");

//        driver.findElement(By.id("loginBtn")).click(); // Cách 1
        driver.findElement(By.xpath("//button[.='Đăng nhập']")).click(); // Cách 2

        // Wait for 5 seconds
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.letron.io/");

        // Wait for 3 seconds
        Thread.sleep(3000);

        prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Deny

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

        // Navigate to the login page
        driver.get("https://www.letron.io/login");

        // Wait for 3 seconds
        Thread.sleep(3000);

        driver.findElement(By.id("iduserName")).sendKeys("thien.pt@katsuma.asia");
        driver.findElement(By.id("idpassword")).sendKeys("Thien_%Q8k");

        driver.findElement(By.xpath("//button[.='Đăng nhập']")).click(); // Cách 2

        // Wait for 5 seconds
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[@class='matero-username ng-star-inserted']")).click();
        driver.findElement(By.xpath("//span[.='Đăng xuất']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.letron.io/login");
        driver.quit();
    }
}
