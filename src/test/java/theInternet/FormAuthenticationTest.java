package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;

    @BeforeClass
    void setup() {
        BrowserUtils.launch("chrome");
        driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    void shouldBeSuccessfully() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @Test
    void shouldBeInValidUsername() {
        driver.findElement(By.id("username")).sendKeys("thienpt");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }

    @Test
    void shouldBeInvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("superSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
    }

    @AfterClass
    void tearDown() {
        if (BrowserUtils.getDriver() != null) {
            BrowserUtils.getDriver().quit();
        }
    }
}
